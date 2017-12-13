import lattelib.ColorLatte;
import lattelib.WebLatte;

public class N4M35s {

    public static void main(String[] args) {
        //declarations:
        WebLatte frame = new WebLatte();
        String name;

        //input:
        frame.println("please enter your full name");
        name = frame.nextLine().toString();

        //draw the output:
        frame.drawText(name, 100, 100, 30, 0, ColorLatte.Aquamarine);

        //charlie's initials display:
        String its = initials(name);
        frame.drawText("initials: " + its, 100, 130, 20, 0, ColorLatte.CornflowerBlue);

        //Abrahams, Grace '20



        //Allina, Nicole '20



        //Bascobert, Paul (Paul) '19



        //Cahill, Phoebe '20



        //Firestone, Nicholas '20



        //Foley, Timothy (Teddy) '20



        //Jamee, Mehrab '20



        //Jiang, Claire '20



        //Katz, Liza '20



        //Levin, Hannah '20



        //Miller, Marshall '20
        String length = length(name)+"";
        frame.drawText("length: " + length, 100, 200, 20, 0, ColorLatte.CornflowerBlue);

        
        //Morse, Madeline (Maddie) '20



        //Radomisli, Julia '20



        //Schoeman, Isabel '20


        //paint:
        frame.paint();
    }


    //charlie's initials function:
    static String initials(String name) {
        String initials;

        //first initial:
        initials = name.charAt(0) +"";

        //second initial:
        int space = name.indexOf(" ");
        initials += name.charAt(space+1);

        return initials;
    }

    //Abrahams, Grace '20



    //Allina, Nicole '20



    //Bascobert, Paul (Paul) '19



    //Cahill, Phoebe '20



    //Firestone, Nicholas '20



    //Foley, Timothy (Teddy) '20



    //Jamee, Mehrab '20



    //Jiang, Claire '20



    //Katz, Liza '20



    //Levin, Hannah '20



    //Miller, Marshall '20

    static int length (String name){
        name = name.replaceAll("\\s+","");
        return name.length();
    }

    //Morse, Madeline (Maddie) '20



    //Radomisli, Julia '20



    //Schoeman, Isabel '20



}
