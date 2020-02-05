import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;



class hangman {

    public static String get_password(){
        final List<String> capitals = Arrays.asList("LONDON","MOSKOW","WARASAW","LISBON","SAN MARINO", "LA PAZ","SANTO DOMINGO");
        final Random rand = new  Random();
        return capitals.get(rand.nextInt(capitals.size()));
    }
    public static String get_hashed(String radnomPassword){
        String space = " ";
        char cSpace = ' ';
        final int lenght = radnomPassword.length();
        String hashedPassword = new String(new char[lenght]).replace("\0", "_");
        for (int i = -1; (i = radnomPassword.indexOf(space, i + 1)) != -1; i++){
        char[] password = hashedPassword.toCharArray();
        password[i] = cSpace;
        hashedPassword = String.valueOf(password);
        }
        return hashedPassword;

    }
    public static String get_input(ArrayList<String> used_letters){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter character");
        String userInput = input.nextLine();
        
        userInput = userInput.toUpperCase();
        char c = userInput.charAt(0);
        if (used_letters.contains(userInput)){
            System.out.println("Sorry this letter has been already used, please try again");
            userInput = get_input(used_letters);
        } 
        if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)){

            return userInput;       // getting back to line 31 get_input(used_letters); and returns previous userInput
        }else {System.out.println("This is not alphabetic character");
        userInput = get_input(used_letters);
    }   
        return userInput;
    }

    
    public static String get_replace_password(String capital, String password, String letter){
        char c = letter.charAt(0);
        for (int i = -1; (i = capital.indexOf(letter, i + 1)) != -1; i++){
            System.out.println(i);
            char[] passwordChar = password.toCharArray();
            passwordChar[i] = c;
            password = String.valueOf(passwordChar); 
        }
        return password;
    }
    
    public static ArrayList<String> used_letter(String letter, ArrayList<String> used_letters){
        // ArrayList<String> used_letters = new ArrayList<String>();
        used_letters.add(letter);
        return used_letters;

    }
    
    
    public static void main(final String[] args) {
        String capital = get_password();
        System.out.println(capital);
        String password = get_hashed(capital);
        System.out.println(password);
        String str1 = "0";
        ArrayList<String> used_letters = new ArrayList<>();
        int life_points = 6;
        while (true){
            // StringBuilder sbPassword = new StringBuilder();
            // sbPassword.append(password);
            
            String letter = get_input(used_letters);
            // letter = letter.toUpperCase();
            char c = letter.charAt(0);
            int isInPassword = capital.indexOf(c);
            if (isInPassword == -1){
                life_points -= 1;
            }else{
            password =get_replace_password(capital, password, letter);
            }
            used_letters = used_letter(letter, used_letters);
            if (life_points == 0){
                System.out.println("Sorry Memory but youve lost");
                break;
            }
            System.out.println("Your life points: " + life_points);
            System.out.println(password);
            System.out.println(used_letters);
            if (capital.equals(password)){
               System.out.println("Simply The Best!! :)");
               break;
            } else if(letter.equals(capital)){
               System.out.println(capital);
               System.out.println("Simply Genius");
               break;
            }
            int result = str1.compareTo(letter);
            if (result == 0){
                break;
            
            }




        }



        }


    
    
    



}