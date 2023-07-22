import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.*;
import java.util.Arrays;

public class FrontEnd extends JFrame implements ActionListener {
    private String level;
    private String language;
    private String OT;
    private String TID;
    private String SID;
    private String OTGender;
    private String ball;

    private final String[] genders = new String[]{"Male", "Female"};
    private final String[] ballsNames = Arrays.stream(Pokeballs.values()).map(ball -> ball.getName()).toArray(String[]::new);
    private final String[] ballsPath = Arrays.stream(Pokeballs.values()).map(ball -> ball.getPath()).toArray(String[]::new);
    private final String[] languages = Arrays.stream(Languages.values()).map(lang -> lang.getLanguage()).toArray(String[]::new);

    private JTextPane inputPane = new JTextPane();
    private JSpinner levelSpinner = new JSpinner(new SpinnerNumberModel(100, 1, 100, 1));
    private JComboBox languagesBox = new JComboBox(languages);
    private JComboBox gendersBox = new JComboBox(genders);
    private JTextField otField = new JTextField();
    private JTextField tidField = new JTextField();
    private JTextField sidField = new JTextField();
    private JTextField ballstext = new JTextField("Poke Ball");

    private void getTrainerInfo()
    {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("trainerinfo.txt"));
            otField.setText(reader.readLine());
            tidField.setText(reader.readLine());
            sidField.setText(reader.readLine());
            gendersBox.setSelectedItem(reader.readLine());
            languagesBox.setSelectedItem(reader.readLine());
            reader.close();
        } catch (Exception e) {
            System.out.println("trainerinfo not found");
        }
    }

    public FrontEnd() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 450);
        setResizable(false);
        this.setLayout(new GridLayout(1, 3, 2, 2));
        getTrainerInfo();

        JPanel infopanel = new JPanel(new GridLayout(7, 2, 2, 2));
        infopanel.add(new JLabel("  OT"));
        infopanel.add(otField);
        infopanel.add(new JLabel("  OTGender"));
        infopanel.add(gendersBox);
        infopanel.add(new JLabel("  TID"));
        infopanel.add(tidField);
        infopanel.add(new JLabel("  SID"));
        infopanel.add(sidField);
        infopanel.add(new JLabel("  Language"));
        infopanel.add(languagesBox);
        infopanel.add(new JLabel("  Level"));
        infopanel.add(levelSpinner);
        infopanel.add(new JLabel("  Ball"));
        ballstext.setEditable(false);
        infopanel.add(ballstext);

        JPanel ballpanel = new JPanel(new GridLayout(6, 4, 2, 2));
        for (int i = 0; i < ballsPath.length; i++) {
            Image img = null;
            JButton b = null;
            try {
                img = ImageIO.read(getClass().getResourceAsStream(ballsPath[i]));
                b = new JButton(new ImageIcon(img));
            } catch (IOException e) {
                b = new JButton(ballsNames[i]);
            }
            int index = i;
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ballstext.setText(ballsNames[index]);
                }
            });
            ballpanel.add(b);
        }

        JPanel thirdPanel = new JPanel(new GridLayout(2, 1, 2, 2));
        inputPane.setText("Paste your Showdown export here");
        inputPane.setForeground(Color.red);
        inputPane.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (inputPane.getText().equals("Paste your Showdown export here")) {
                    inputPane.setText("");
                    inputPane.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                    if (inputPane.getText().isEmpty()) {
                        inputPane.setText("Paste your Showdown export here");
                        inputPane.setForeground(Color.red);
                    }
            }
        });
        thirdPanel.add(inputPane);
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 2, 2));
        JButton generate = new JButton("Generate");
        generate.addActionListener(this);
        buttonPanel.add(generate);
        JButton save = new JButton("Save Trainer Info");
        save.addActionListener(this);
        buttonPanel.add(save);
        thirdPanel.add(buttonPanel);

        this.add(infopanel);
        this.add(ballpanel);
        this.add(thirdPanel);
        setVisible(true);
    }

    private boolean checkInput(JTextField otField, JTextField tidField, JTextField sidField)
    {
        if (otField.getText().isEmpty() | tidField.getText().isEmpty() | sidField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid entries");
            return false;
        }
        if(otField.getText().length()>12)
        {
            JOptionPane.showMessageDialog(null, "OT too long");
            return false;
        }
        try{
            int n = Integer.parseInt(tidField.getText());
            n = Integer.parseInt(sidField.getText());
        } catch(NumberFormatException ne)
        {
            JOptionPane.showMessageDialog(null, "TID/SID is not a number");
            return false;
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!checkInput(otField, tidField, sidField))
            return;
        if (e.getActionCommand().equals("Generate")) {
            level = String.valueOf(levelSpinner.getValue());
            language = languagesBox.getSelectedItem().toString();
            OT = otField.getText();
            TID = tidField.getText();
            SID = sidField.getText();
            OTGender = gendersBox.getSelectedItem().toString();
            ball = ballstext.getText();

            String input = inputPane.getText();
            String[] list = input.split("  ");

            StringBuilder toJohnny = new StringBuilder();
            toJohnny.append("#trade ");
            int size = list.length;
            for (int i = 0; i < size; i++) {
                if(i!=2)
                    toJohnny.append(list[i]);
                if (i == 1) {
                    toJohnny.append("\nLevel: " + level);
                    toJohnny.append("\nLanguage: " + language);
                    toJohnny.append(" OT: " + OT);
                    toJohnny.append(" TID: " + TID);
                    toJohnny.append(" SID: " + SID);
                    toJohnny.append(" OTGender: " + OTGender);
                    toJohnny.append(" Ball: " + ball);
                }
            }
            StringSelection stringSelection = new StringSelection(toJohnny.toString());
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
            System.out.println("Copied to Clipboard!\n" + toJohnny.toString());
            JOptionPane.showMessageDialog(null, "Copied to Clipboard!");
        }
        else if(e.getActionCommand().equals("Save Trainer Info"))
        {
            OT = otField.getText();
            TID = tidField.getText();
            SID = sidField.getText();
            OTGender = gendersBox.getSelectedItem().toString();
            language = languagesBox.getSelectedItem().toString();
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("trainerinfo.txt"));
                writer.write(OT+"\n");
                writer.write(TID+"\n");
                writer.write(SID+"\n");
                writer.write(OTGender+"\n");
                writer.write(language);
                writer.close();
                JOptionPane.showMessageDialog(null,"Trainer info saved!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Unexpected error");
                throw new RuntimeException(ex);
            }
        }
    }
}
