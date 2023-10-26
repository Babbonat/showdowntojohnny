import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
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
    private final String[] gamesNames = Arrays.stream(Games.values()).map(game -> game.getName()).toArray(String[]::new);
    private final String[] gamesPrefix = Arrays.stream(Games.values()).map(game -> game.getPrefix()).toArray(String[]::new);


    private JTextPane inputPane = new JTextPane();
    private JSpinner levelSpinner = new JSpinner(new SpinnerNumberModel(100, 1, 100, 1));
    private JComboBox languagesBox = new JComboBox(languages);
    private JComboBox gamesBox = new JComboBox(gamesNames);
    private JComboBox gendersBox = new JComboBox(genders);
    private JTextField otField = new JTextField();
    private JTextField tidField = new JTextField();
    private JTextField sidField = new JTextField();
    private JTextField ballstext = new JTextField("Poke Ball");

    private boolean getTrainerInfo(String game)
    {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("trainerinfo"+game+".txt"));
            otField.setText(reader.readLine());
            tidField.setText(reader.readLine());
            sidField.setText(reader.readLine());
            gendersBox.setSelectedItem(reader.readLine());
            languagesBox.setSelectedItem(reader.readLine());
            reader.close();
        } catch (Exception e) {
            System.out.println("trainerinfo not found");
            return false;
        }
        return true;
    }

    public FrontEnd() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 450);
        setResizable(false);
        this.setLayout(new GridLayout(1, 3, 2, 2));

        for(int i = 0; i < gamesNames.length; i++)
        {
            if(getTrainerInfo(gamesNames[i]))
                break;
        }

        ArrayList<JButton> buttons = new ArrayList<>();
        for (int i = 0; i < ballsPath.length; i++) {
            buttons.add(null);
        }

        JPanel infopanel = new JPanel(new GridLayout(8, 2, 2, 2));
        infopanel.add(new JLabel("  Game"));
        infopanel.add(gamesBox);
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

        gamesBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String item = e.getItem().toString();
                    boolean gameCheck = item.equals(Games.PLA.getName());
                    for (int i = 0; i < ballsPath.length; i++) {
                        if (gameCheck && i < 24)
                            buttons.get(i).setEnabled(false);
                        else if (gameCheck && i >= 24)
                            buttons.get(i).setEnabled(true);
                        else if (!gameCheck && i < 24)
                            buttons.get(i).setEnabled(true);
                        else if (!gameCheck && i >= 24)
                            buttons.get(i).setEnabled(false);
                    }
                    if (!getTrainerInfo(item)) {
                        otField.setText("");
                        tidField.setText("");
                        sidField.setText("");
                        gendersBox.setSelectedItem(genders[0]);
                        languagesBox.setSelectedItem(languages[0]);
                    }
                    levelSpinner.setValue(100);
                    ballstext.setText("Poke Ball");
                }
            }
        });

        JPanel ballpanel = new JPanel(new GridLayout(9, 4, 2, 2));
        for (int i = 0; i < ballsPath.length; i++) {
            Image img = null;
            try {
                img = ImageIO.read(getClass().getResourceAsStream(ballsPath[i]));
                buttons.set(i, new JButton(new ImageIcon(img)));
            } catch (IOException e) {
                buttons.set(i, new JButton(ballsNames[i]));
            }
            int index = i;
            buttons.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ballstext.setText(ballsNames[index]);
                }
            });
            if(i>=24)
                buttons.get(i).setEnabled(false);
            ballpanel.add(buttons.get(i));
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
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 2, 2));
        JButton generate = new JButton("Generate");
        generate.addActionListener(this);
        buttonPanel.add(generate);
        JButton load = new JButton("Load Trainer Info");
        load.addActionListener(this);
        buttonPanel.add(load);
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
        if (e.getActionCommand().equals("Generate")) {
            if(!checkInput(otField, tidField, sidField))
                return;
            if(inputPane.getText().equals("Paste your Showdown export here"))
            {
                JOptionPane.showMessageDialog(null, "Paste a Showdown export");
                return;
            }
            level = String.valueOf(levelSpinner.getValue());
            language = languagesBox.getSelectedItem().toString();
            OT = otField.getText();
            TID = tidField.getText();
            SID = sidField.getText();
            OTGender = gendersBox.getSelectedItem().toString();
            ball = ballstext.getText();

            String input = inputPane.getText();
            String[] list = input.split("  ");
            String prefix = gamesPrefix[gamesBox.getSelectedIndex()];

            StringBuilder toJohnny = new StringBuilder();
            toJohnny.append(prefix);
            toJohnny.append("trade ");
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
            if(!checkInput(otField, tidField, sidField))
                return;
            OT = otField.getText();
            TID = tidField.getText();
            SID = sidField.getText();
            OTGender = gendersBox.getSelectedItem().toString();
            language = languagesBox.getSelectedItem().toString();
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("trainerinfo"+gamesBox.getSelectedItem().toString()+".txt"));
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
        } else if (e.getActionCommand().equals("Load Trainer Info"))
        {
            getTrainerInfo(gamesBox.getSelectedItem().toString());
        }
    }
}
