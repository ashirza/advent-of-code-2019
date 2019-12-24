import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class OnePartOne {
    public static void main(String[] args) {
        File file = new File("files/one-numbers.txt");
        Scanner sc = null;
        double totalFuelRequired = 0;

        try{
            sc = new Scanner(file);
            while(sc.hasNextLine()) {
                Double module = Double.valueOf(sc.nextLine());
                double fuelRequired = Math.floor((module / 3)) - 2;
                totalFuelRequired += fuelRequired;
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } finally{
            sc.close();
        }
        System.out.println(totalFuelRequired);
    }
}