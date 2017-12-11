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

        //take a second name:
        frame.println("please enter another full name");
        String name2 = frame.nextLine().toString();

        //draw the output:
        frame.drawText(name, 100, 100, 30, 0, ColorLatte.Aquamarine);

        //charlie's initials display:
        String its = initials(name);
        frame.drawText("initials: " + its, 100, 130, 20, 0, ColorLatte.CornflowerBlue);

        //Abrahams, Grace '20



        //Allina, Nicole '20



        //Bascobert, Paul (Paul) '19



        //Cahill, Phoebe '20

        String fn = firstname(name);
        frame.drawText("first name: " + fn, 100, 200, 20, 0, ColorLatte.Crimson);


        //Firestone, Nicholas '20



        //Foley, Timothy (Teddy) '20



        //Jamee, Mehrab '20



        //Jiang, Claire '20



        //Katz, Liza '20



        //Levin, Hannah '20



        //Miller, Marshall '20



        //Morse, Madeline (Maddie) '20



        //Radomisli, Julia '20
        String ship = shipname(name, name2);
        frame.drawText("ship name: " + ship, 300, 200, 20, 0, ColorLatte.Violet);


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

    static String firstname (String name) {
        String firstname;
        String[] getname = name.split(" ");

        firstname = getname[0];

        return firstname;


    }

    //Firestone, Nicholas '20



    //Foley, Timothy (Teddy) '20



    //Jamee, Mehrab '20



    //Jiang, Claire '20



    //Katz, Liza '20



    //Levin, Hannah '20



    //Miller, Marshall '20



    //Morse, Madeline (Maddie) '20



    //Radomisli, Julia '20
    static String shipname(String name, String name2) {
        String shipname;


        //first three letters:
        shipname = name.charAt(0) + "";
        shipname += name.charAt(1) + "";
        shipname += name.charAt(2) + "";

        //next three letters:
        shipname += name2.charAt(0) + "";
        shipname += name2.charAt(1) + "";
        shipname += name2.charAt(2) + "";

        return shipname;


    //Schoeman, Isabel '20



}
