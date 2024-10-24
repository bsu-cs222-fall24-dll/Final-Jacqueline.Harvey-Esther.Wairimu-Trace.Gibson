//This is me testing the search feature, do not mind me (JH)
//This could be adjusted as needed, I just want to be useful in some way.
import edu.bsu.cs.User;

import java.util.Scanner;

public class SearchTest {
    private Scanner scanner = new Scanner(System.in);
    User user = new User();

    public void menuTest() {
        int selection;

        while(true) {
            System.out.print("Would you like to Sign Up or Log In?:\n" +
                    "1.) Sign Up" +
                    "2.) Log In");
            selection = Integer.parseInt(scanner.nextLine());

            if (selection == 1) {
                signUP();
            }

            else if (selection == 2) {
                logIn();
            }

            else {
                System.out.println("Invalid Entry!");
            }
        }
    }

    private void logIn() {
        String userName;
        String password;

        System.out.println("Please enter your username: ");
        userName = scanner.nextLine();

    }

    private void signUP() {
    }
}//End of searchTest class
