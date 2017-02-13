import java.util.Scanner;

public class CountriesApp {


    public static void CountryMenu ()

    {

        Scanner scan = new Scanner(System.in);

        int menu = 1;

        while (menu == 1 || menu == 2) {
            System.out.println("1 - See the ist of countries\n" +
            "2 - Add a country\n" +
            "3 - Exit\n");


            menu = Validator.getInt(scan, "Enter menu item: ", 1, 3);
            if (menu == 1)
            {
                StringBuilder list = CountriesTextFile.readCountriesFile("countries.txt");
                System.out.println(list);
            }
            else if (menu == 2)
            {

                String input =Validator.getString(scan, "Enter Country");
                CountriesTextFile.writeCountriesToFile("countries.txt", input + "\n");
                System.out.println( input + " has been added to the List");
            }
//            else if (menu == 3)
//            {
//                CountriesTextFile.removeCountryFromFile();
//                System.out.println(input + " has been deleted from the List!");
//            }
            else
            {
                System.out.println("Buh-bye!");
            }




        }

    }
}
