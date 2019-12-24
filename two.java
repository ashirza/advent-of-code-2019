import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Two {
    public static void main(String[] args) {
        File file = new File("files/one-numbers.txt");
        Scanner sc = null;
        double totalFuelRequired = 0;

        try{
            sc = new Scanner(file);
            while(sc.hasNextLine()) {
                totalFuelRequired += calculateFuel(Double.valueOf(sc.nextLine()));;
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } finally{
            sc.close();
        }
        System.out.println(totalFuelRequired);
    }

    static double calculateFuel(double a) {
        double fuelRequired = Math.floor((a/3)) - 2;

        if(fuelRequired < 0) {
            return 0;
        } else {
            return fuelRequired + calculateFuel(fuelRequired);
        }
    }
}