import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class SortArray {
    private int[] array;

    public SortArray(String filePath) {
        readInputFile(filePath);
    }

    private void readInputFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            String line2=line.substring(1, line.length()-1);
        //    System.out.println(line2);
            String[] elements = line2.split(",");
            array = new int[elements.length];
            for (int i = 0; i < elements.length; i++) {
                array[i] = Integer.parseInt(elements[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[] simpleSort(int i) {
        if(i==1||i==3){
        int n = array.length;
        for (int l = 1; l < n; l++) {
            int key = array[l];
            int index = l - 1;
            while (index >= 0 && array[index] < key) {
                array[index + 1] = array[index];
                index--;
            }
            array[index + 1] = key;
        }
    }
     if (i==2 ||i==3) {
        int n = array.length;
        List<int[]> output = new ArrayList<>();
        output.add(array.clone());
        for (int k = 1; k < n; k++) {
            int key = array[k];
            int index = k - 1;
            while (index >= 0 && array[index] < key) {
                array[index + 1] = array[index];
                index--;
            }
            array[index + 1] = key;
            output.add(array.clone());
        }
        for (int[] num : output) {
            for(int m :num){
                System.out.print(m + " ");
            }
            System.out.println();
        }
       
    }
    return array;
    }

    public int[] efficientSort(int i) {
        return array;
      
    }


    

    public int[] nonComparisonSort(int i) {
        return array;
       
    }


    void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

public class lab1 {
    public static void main(String[] args) {
       
        System.out.println("Please provide the path of the input file.");
        Scanner input=new Scanner(System.in);
        String filePath =input.nextLine();
        SortArray sortArray = new SortArray(filePath);

        // Main menu
        while (true) {
            System.out.println("\n--- Sorting Algorithms Menu ---");
            System.out.println("1. Simple Sort (O(n^2))");
            System.out.println("2. Efficient Sort (O(n log n)");
            System.out.println("3. Non-Comparison Sort (O(n)");
            System.out.println("4. Exit");
            System.out.flush();

            System.out.println("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(System.console().readLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number.");
                continue;
            }

            int[] sortedArray;
            switch (choice) {
                case 1:
                    int choice2=0;
                    while(choice2!=1||choice2!=2||choice2!=3){
                        System.out.println("1. Final sorted array");
                        System.out.println("2. intermediate arrays");
                        System.out.println("3. Both");
                        System.out.println("4. Exit");
                        try {
                            choice2 = Integer.parseInt(System.console().readLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid choice. Please enter a number.");
                            continue;
                        } 
                        switch (choice2) {
                            case 1:
                            sortedArray = sortArray.simpleSort(1); 
                            sortArray.printArray(sortedArray);
                                break;
                            
                            case 2:
                            sortedArray = sortArray.simpleSort(2); 
                            break;
                            case 3:
                            sortedArray = sortArray.simpleSort(3);
                            sortArray.printArray(sortedArray);
                            break; 
                            case 4:
                            return;
                            default:
                            System.out.println("Invalid choice. Please enter a valid option.");
                        }
                    }
                case 2:


                int choice3=0;
                while(choice3!=1||choice3!=2||choice3!=3){
                    System.out.println("1. Final sorted array");
                    System.out.println("2. intermediate arrays");
                    System.out.println("3. Both");
                    try {
                        choice3 = Integer.parseInt(System.console().readLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid choice. Please enter a number.");
                        continue;
                    } 
                    switch (choice3) {
                        case 1:
                        sortedArray = sortArray.efficientSort(1); 
                        sortArray.printArray(sortedArray);
                            break;
                        
                        case 2:
                        sortedArray = sortArray.efficientSort(2); 
                        sortArray.printArray(sortedArray);
                        break;
                        case 3:
                        sortedArray = sortArray.efficientSort(3);
                        sortArray.printArray(sortedArray);
                        break; 
                        case 4:
                        return;
                        default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                    }
                }
                   
                case 3:
                int choice4=0;
                while(choice4!=1||choice4!=2||choice4!=3){
                    System.out.println("1. Final sorted array");
                    System.out.println("2. intermediate arrays");
                    System.out.println("3. Both");
                    try {
                        choice4 = Integer.parseInt(System.console().readLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid choice. Please enter a number.");
                        continue;
                    } 
                    switch (choice4) {
                        case 1:
                        sortedArray = sortArray.nonComparisonSort(1); 
                        sortArray.printArray(sortedArray);
                            break;
                        
                        case 2:
                        sortedArray = sortArray.nonComparisonSort(2); 
                        sortArray.printArray(sortedArray);
                        break;
                        case 3:
                        sortedArray = sortArray.nonComparisonSort(3);
                        sortArray.printArray(sortedArray);
                        break; 
                        case 4:
                        return;
                        default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                    }
                }
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}