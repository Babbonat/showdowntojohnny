import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private final String[] balls = Arrays.stream(Pokeballs.values()).map(ball -> ball.getName()).toArray(String[]::new);
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
            System.out.println("File non trovato");
        }
    }

    public FrontEnd() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 450);
        setResizable(false);
        this.setLayout(new GridLayout(1, 3, 2, 2));
        getTrainerInfo();

        JPanel infopanel = new JPanel(new GridLayout(7, 2, 2, 2));
        infopanel.add(new JLabel("OT"));
        infopanel.add(otField);
        infopanel.add(new JLabel("OTGender"));
        infopanel.add(gendersBox);
        infopanel.add(new JLabel("TID"));
        infopanel.add(tidField);
        infopanel.add(new JLabel("SID"));
        infopanel.add(sidField);
        infopanel.add(new JLabel("Level"));
        infopanel.add(levelSpinner);
        infopanel.add(new JLabel("Ball"));
        ballstext.setEditable(false);
        infopanel.add(ballstext);
        infopanel.add(new JLabel("Language"));
        infopanel.add(languagesBox);

        JPanel ballpanel = new JPanel(new GridLayout(6, 4, 2, 2));
        for (int i = 0; i < ballsPath.length; i++) {
            JButton b = new JButton(new ImageIcon(ballsPath[i]));
            int index = i;
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ballstext.setText(balls[index]);
                }
            });
            ballpanel.add(b);
        }

        JPanel thirdPanel = new JPanel(new GridLayout(2, 1, 2, 2));
        thirdPanel.add(inputPane);
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 2, 2));
        JButton generate = new JButton("Generate");
        generate.addActionListener(this);
        buttonPanel.add(generate);
        JButton save = new JButton("Save Trainer");
        save.addActionListener(this);
        buttonPanel.add(save);
        thirdPanel.add(buttonPanel);

        this.add(infopanel);
        this.add(ballpanel);
        this.add(thirdPanel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (otField.getText().isEmpty() | tidField.getText().isEmpty() | sidField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "invalid parameter");
            return;
        }
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
                toJohnny.append(list[i]);
                if (i == 1) {
                    toJohnny.append(" Level: " + level);
                    toJohnny.append(" Language: " + language);
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
        else if(e.getActionCommand().equals("Save Trainer"))
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
