import java.util.Scanner;

public class CountriesApp {


    public static void CountryMenu ()       //This method is responsible for printing the menu

    {

        Scanner scan = new Scanner(System.in);

        int menu = 1;

        while (menu == 1 || menu == 2 || menu == 3) {                                                //continuously prints the menu until user choose to exit
            System.out.println("1 - See the ist of countries\n" +
            "2 - Add a country\n" +
            "3 - Remove a country\n" +
            "4 - Exit\n");


            menu = Validator.getInt(scan, "Enter menu item: ", 1, 4);               //validator for user input to limit choices within menu items 1-4
            if (menu == 1)                                                                            //calls for method to read the list from file
            {
                StringBuilder list = CountriesTextFile.readCountriesFile("countries.txt");  //file name is passed into method to read from countries.txt
                System.out.println(list);
            }
            else if (menu == 2)                                                                       //calls for method to write user input into file
            {

                String input =Validator.getString(scan, "Enter Country: ");
                CountriesTextFile.writeCountriesToFile("countries.txt", input + "\n");  //scanner input is passed into for entries to be added to the file countries.txt
                System.out.println( input + " has been added to the List\n");
            }
            else if (menu == 3)                                                                        //calls for method to remove user input from file
            {
                String input = Validator.getString(scan, "Entry the country to be removed: ");
                CountriesTextFile.removeCountryFromFile("countries.txt", input);               //scanner input and countries.txt is passed into method to read from the original file
                System.out.println(input + " has been deleted from the List!\n");
            }
            else
            {
                System.out.println("Buh-bye!");                                                         //exits the loop/program
            }




        }

    }
}
