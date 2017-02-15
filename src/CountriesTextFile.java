import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CountriesTextFile {

    public static void writeCountriesToFile(String fileName, String Input) {


        Path filePath = Paths.get(fileName);

        File productsFile = filePath.toFile();


        try {

            PrintWriter out = new PrintWriter(new FileOutputStream(productsFile, true));

            out.print(Input);
            out.close();

        } catch (FileNotFoundException e) {

        }

    }


    public static StringBuilder readCountriesFile(String fileName) {

        Path filePath = Paths.get(fileName);

        File productsFile = filePath.toFile();

        StringBuilder result = new StringBuilder();

        try {
            FileReader r = new FileReader(productsFile);
            BufferedReader reader = new BufferedReader(r);

            String line = reader.readLine();
            while (line != null) {
                result.append(line + "\n");
                line = reader.readLine();

            }
            reader.close();
            return result;
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
    }




    public static void removeCountryFromFile(String fileName, String input) {
        //read
        Path filePath = Paths.get(fileName);
        File countries = filePath.toFile();

        //write
        Path temp = Paths.get("temp.txt");
        File tempFile = temp.toFile();


        try {

            FileReader r = new FileReader(countries);
            BufferedReader reader = new BufferedReader(r);
            PrintWriter out = new PrintWriter(new FileOutputStream(tempFile, false));

            String line = reader.readLine();
            while (line != null) {
                if (!line.equalsIgnoreCase(input)) {

                    out.println(line);
                }

                line = reader.readLine();

            }

            out.close();
            reader.close();

            countries.delete();
            tempFile.renameTo(countries);

        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }


    }


}
