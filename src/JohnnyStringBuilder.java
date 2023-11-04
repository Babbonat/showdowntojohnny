import java.util.Arrays;
import java.util.HashMap;

public class JohnnyStringBuilder
{
    private final String[] statsNames = new String[] {"HP", "Atk", "Def", "SpA", "SpD", "Spe"};
    private final String[] gamesNames = Arrays.stream(Games.values()).map(game -> game.getName()).toArray(String[]::new);
    private final String[] gamesPrefix = Arrays.stream(Games.values()).map(game -> game.getPrefix()).toArray(String[]::new);
    private final String game;
    private final String level;
    private final String language;
    private final String OT;
    private final String TID;
    private final String SID;
    private final String OTGender;
    private final String ball;
    private final String metLocation;
    private final String mark;
    private HashMap<String, Stats> ivMap;

    public JohnnyStringBuilder(String game, String level, String language, String OT, String TID, String SID, String OTGender, String ball, String metLocation, String mark, HashMap<String, Stats> ivMap) {
        this.game = game;
        this.level = level;
        this.language = language;
        this.OT = OT;
        this.TID = TID;
        this.SID = SID;
        this.OTGender = OTGender;
        this.ball = ball;
        this.metLocation = metLocation;
        this.mark = mark;
        this.ivMap = ivMap;
    }

    public String getPrefix(String game)
    {
        for(int i = 0; i < gamesNames.length; i++)
        {
            if(gamesNames[i].equals(game))
                return gamesPrefix[i];
        }
        return "#";
    }

    public String transformString(String input) {
        boolean done = false;
        String[] lines = input.split("\n");
        StringBuilder toJohnny = new StringBuilder();
        int i = 0;
        while(!lines[i].startsWith("IVs: ") && !lines[i].startsWith("- "))
        {
            switch (i) {
                case 0:
                    toJohnny.append(getPrefix(game)).append("trade ").append(lines[i]).append("\n");
                    break;
                case 1:
                    toJohnny.append(lines[i]);
                    toJohnny.append("\nLevel: " + level);
                    toJohnny.append("\nLanguage: " + language);
                    toJohnny.append("\nOT: " + OT);
                    toJohnny.append("\nTID: " + TID);
                    toJohnny.append("\nSID: " + SID);
                    toJohnny.append("\nOTGender: " + OTGender);
                    toJohnny.append("\nBall: " + ball + "\n");
                    break;
                case 2:
                    break;
                default:
                    if(!game.equals("SV") && lines[i].startsWith("Tera Type: "))
                        break;
                    if(!game.equals("SWOSHI") && lines[i].startsWith("Gigantamax: "))
                        break;
                    toJohnny.append(lines[i]).append("\n");
                    break;
            }
            i++;
        }

        boolean isPresent = lines[i].startsWith("IVs: ");

        if(isPresent) {
            //Prende la linea con le IVs, togliendo la prima parte e le divide per stat
            String ivLine = lines[i].substring(5);
            String[] ivValues = ivLine.split(" / ");

            //per ogni stat, divide valore numerico e nome e aggiorna la map
            for (String ivStat : ivValues) {
                String[] parts = ivStat.split(" ");
                if (parts.length == 2) {
                    String ivName = parts[1];
                    int ivValue = Integer.parseInt(parts[0]);
                    ivMap.replace(ivName, new Stats(ivName, ivValue));
                }
            }
        }

        //costruzione della nuova stringa
        StringBuilder ivString = new StringBuilder("IVs: ");
        int j = 0;
        int statsCount = count31();
        for (int k = 0; k < statsNames.length; k++) {
            String ivName = statsNames[k];
            int ivValue = ivMap.get(ivName).getValue();
            if(ivValue != 31)
                ivString.append(ivValue).append(" ").append(ivName).append((++j==(statsCount)) ? "" : " / ");
        }
        if(ivString.length() > 5)
            toJohnny.append(ivString).append("\n");

        if(isPresent)
            i++;
        while(i<lines.length) {
            if (!done && lines[i].startsWith("-")) {
                if (!metLocation.equals("None"))
                    toJohnny.append(metLocation + "\n");
                if (!mark.equals("None"))
                    toJohnny.append(mark + "\n");
                done = true;
            }
            toJohnny.append(lines[i++]).append("\n");
        }

        return toJohnny.toString();
    }

    private int count31()
    {
        int counter = 0;
        for(int i = 0; i < ivMap.size(); i++)
        {
            if(ivMap.get(statsNames[i]).getValue() != 31)
                counter++;
        }
        return counter;
    }
}
