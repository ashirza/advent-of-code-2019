import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class TwoPartTwo {
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

        int intListLength = intList.size();
        int noun = 0;
        int verb = 0;

        for(int first = 0; first <= 99; first++) {
            for(int second = 0; second <= 99; second++) {
                ArrayList<Integer> tempIntList = new ArrayList<>(intList);

                intList.set(1, first);
                intList.set(2, second);
                noun = first;
                verb = second;

                for(int i = 0; i < intListLength; i+= 4) {
                    if (tempIntList.get(i) == 1) {
                        int sum = tempIntList.get(tempIntList.get(i + 1)) + tempIntList.get(tempIntList.get(i + 2));
                        tempIntList.set(tempIntList.get(i + 3), sum);
                    }
                    else if (tempIntList.get(i) == 2) {
                        int multiplied = tempIntList.get(tempIntList.get(i + 1)) * tempIntList.get(tempIntList.get(i + 2));
                        tempIntList.set(tempIntList.get(i + 3), multiplied);
                    }
                    else if (tempIntList.get(i) == 99) {
                        break;
                    }
                }

                if(tempIntList.get(0) == 19690720) {
                    System.out.println(tempIntList.toString());
                    System.out.println("Noun: " + tempIntList.get(1));
                    System.out.println("Verb: " + tempIntList.get(2));
                    System.out.println("Answer: " + ((100 * noun) + verb));
                }
            }
        }
    }
}