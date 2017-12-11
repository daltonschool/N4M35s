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

        String fn = firstname(name);
        frame.drawText("first name: " + fn, 100, 200, 20, 0, ColorLatte.Crimson);


        //Firestone, Nicholas '20
        String oodled = oodlifey(name);
        frame.drawText("oodled: " + oodled, 100, 230, 20, 0, ColorLatte.BlueViolet);


        //Foley, Timothy (Teddy) '20



        //Jamee, Mehrab '20



        //Jiang, Claire '20



        //Katz, Liza '20



        //Levin, Hannah '20



        //Miller, Marshall '20



        //Morse, Madeline (Maddie) '20
        // (backwards)
        String b = backwards(name);
        frame.drawText("backwards: " + b, 100, 300, 20, 0, ColorLatte.BlueViolet);

        //Radomisli, Julia '20



        //Schoeman, Isabel '20
        frame.drawText("Your middle name is " + middleName(name), 100, 230, 30, 0, ColorLatte.Chartreuse);


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
    static String oodlifey(String name) {
        //make a string array:
        //"charlie forster"
        //declare finalname
        String[] names = name.split("");
        String finalname = "";
        for (int i = 0; i < name.length(); i++) {
            if(names[i].equals("a")|| names[i].equals("e")|| names[i].equals("i") || names[i].equals("o") || names[i].equals("u") || names[i].equals("y")  ){
                names[i]="oodle";
            }
            //add each individual string to finalname
            finalname += names[i];
        }

        return finalname;
    }


    //Foley, Timothy (Teddy) '20



    //Jamee, Mehrab '20



    //Jiang, Claire '20



    //Katz, Liza '20



    //Levin, Hannah '20



    //Miller, Marshall '20



    //Morse, Madeline (Maddie) '20

    static String backwards(String name) {

        String c = "";

        for (int b = name.length()-1; b >= 0; b--) {
            c += name.charAt(b);

        }
        return c;
    }

    //Radomisli, Julia '20



    //Schoeman, Isabel '20
    static String middleName (String name){
        String middleName = " " ;
        String [] splitName = name.split(" ");
        int x = splitName.length;
        if (splitName.length <= 2){
            middleName = "NO MIDDLE NAME";
        } else {
            for (int i = 0; i < splitName.length; i++) {
                if (i == 0 || i == x - 1) {
                    middleName = middleName;

                } else {
                    middleName += " " + splitName[i];
                }
            }

        }
        return middleName;
    }



}
