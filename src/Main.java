import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        FrontEnd f = new FrontEnd();
    }

    /*public static final String level = "Level: 100 ";
    public static final String language = "Language: Italian ";
    public static final String OT = "OT: Francesco ";
    public static final String TID = "TID: 686505 ";
    public static final String SID = "SID: 3616 ";
    public static final String OTGender = "OTGender: Male ";
    public static final String ball = "Ball: Poke Ball ";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = "";
        String s = "";
        List<String> list = new ArrayList<>();
        System.out.println("Enter Input : ");
        while(scanner.hasNext())
        {
            line = scanner.nextLine();

            if(line.equals("Q"))
            {
                scanner.close();
                break;
            }
            line = line.replace("  ", " ");
            list.add(line);
        }
        StringBuilder toJohnny = new StringBuilder();
        toJohnny.append("#trade ");
        int size = list.size();
        for(int i = 0; i<size;i++)
        {
            toJohnny.append(list.get(i));
            if(i==1)
            {
                toJohnny.append(level);
                toJohnny.append(language);
                toJohnny.append(OT);
                toJohnny.append(TID);
                toJohnny.append(SID);
                toJohnny.append(OTGender);
                toJohnny.append(ball);
            }
        }
        StringSelection stringSelection = new StringSelection(toJohnny.toString());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        System.out.println("Copied to Clipboard!\n" + toJohnny.toString());
    }*/
}