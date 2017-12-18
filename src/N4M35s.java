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
        String lstnm = LastName(name);
        frame.drawText("last name: " + lstnm, 500, 200, 20, 0, ColorLatte.CadetBlue);

        //Bascobert, Paul (Paul) '19



        //Cahill, Phoebe '20

        String fn = firstname(name);
        frame.drawText("first name: " + fn, 100, 200, 20, 0, ColorLatte.Crimson);


        //Firestone, Nicholas '20
        String oodled = oodlifey(name);
        frame.drawText("oodled: " + oodled, 100, 260, 20, 0, ColorLatte.BlueViolet);


        //Foley, Timothy (Teddy) '20
        frame.drawText(common(name), 400,500,20,0,ColorLatte.BLACK);

        //Jamee, Mehrab '20



        //Jiang, Claire '20



        //Katz, Liza '20



        //Levin, Hannah '20
        //hannah's spacify display
        String space = spacify(name);
        frame.drawText("spacify: " + space, 120, 160, 20, 0, ColorLatte.MediumPurple);

        //Miller, Marshall '20
        String length = length(name)+"";
        frame.drawText("length: " + length, 300, 130, 20, 0, ColorLatte.CornflowerBlue);

        
        //Morse, Madeline (Maddie) '20
        // (backwards)
        String b = backwards(name);
        frame.drawText("backwards: " + b, 100, 300, 20, 0, ColorLatte.BlueViolet);



        //Radomisli, Julia '20
        String ship = shipname(name, name2);
        frame.drawText("ship name: " + ship, 300, 200, 20, 0, ColorLatte.Violet);


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
    static String LastName(String name) {
        String lastName = " ";
        //turn string to array by dividing at spaces
        String[] nameArray = name.split(" ");
        if (nameArray.length <= 1) {
            lastName = "No last name";
        } else {
            for (int i = 0; i < nameArray.length; i++) {
                if (i == nameArray.length - 1) {
                    lastName += nameArray[i];
                }
            }
            return lastName;
        }
        return lastName;
    }


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
    static String common(String name) {
        char[] alphabet = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int[] prevalence = new int[26];
        String most_common = "";
        int big = 0;

        for (int i = 0; i < name.length(); i++){
            for (int j = 0; j < 26; j++){
                if (name.charAt(i)==alphabet[j]) {
                    prevalence[j]++;
                }
            }
        }
        for(int i = 0; i < 26; i++){
            if (prevalence[i]>big){
                big = prevalence[i];
            }
        }


        for (int i = 0; i < 26; i++){
            if (prevalence[i] == big) {
                most_common = Character.toString(alphabet[i]) + " ";
            }
        }

        return most_common;
    }


    //Jamee, Mehrab '20



    //Jiang, Claire '20



    //Katz, Liza '20



    //Levin, Hannah '20
    static String spacify(String name) {
        String spacify = "";

        //make array of letters
        char[] letters = new char[name.length()];
        for (int i = 0; i < letters.length; i++) {
            letters[i] = name.charAt(i);
            spacify = spacify + letters[i] + " ";
        }

        return spacify;
    }



    //Miller, Marshall '20

    static int length (String name){
        name = name.replaceAll("\\s+","");
        return name.length();
    }

    //Morse, Madeline (Maddie) '20

    static String backwards(String name) {

        String c = "";

        for (int b = name.length()-1; b >= 0; b--) {
            c += name.charAt(b);

        }
        return c;
    }

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
    }

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
