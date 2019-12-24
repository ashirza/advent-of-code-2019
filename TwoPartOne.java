import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class TwoPartOne {
    public static void main(String[] args) {
        File file = new File("files/two-intcode.txt");
        Scanner sc = null;
        ArrayList<Integer> intList = new ArrayList<>();
        
        try {
            sc = new Scanner(file);
            sc.useDelimiter(",");

            while(sc.hasNextInt()) {
                intList.add(sc.nextInt());
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }

        intList.set(1, 12);
        intList.set(2, 2);
        int intListLength = intList.size();

        for(int i = 0; i < intListLength; i+= 4) {
            if (intList.get(i) == 1) {
                int sum = intList.get(intList.get(i + 1)) + intList.get(intList.get(i + 2));
                intList.set(intList.get(i + 3), sum);
            }
            else if (intList.get(i) == 2) {
                int multiplied = intList.get(intList.get(i + 1)) * intList.get(intList.get(i + 2));
                intList.set(intList.get(i + 3), multiplied);
            }
            else if (intList.get(i) == 99) {
                break;
            }
        }
        
        System.out.println(intList.toString());
        System.out.println(intList.get(0));
    }
}