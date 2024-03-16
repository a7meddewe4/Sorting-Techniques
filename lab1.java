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
 
    private void readInputFile(String filePath) {              //to read the array from the file 
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
        if(i==1||i==3){                                           // if 1 or 3 it will sort the array and return final array
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
     if (i==2 ||i==3) {                                          //if 2 or 3 it will return subarrays 
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


    

    public int[] nonComparisonSort(int l) {
          // filter array to 2 arrays +ve , -ve
          int postive=0,negative=0;
          for(int i=0;i<array.length;i++)
          {
             if(array[i]>=0)postive++;
             else    negative++;
          }
          int positives[]=new int[postive];
          int negatives[]=new int[negative];
          int p=0,n=0;
  
          for(int i=0;i<array.length;i++)
          {
              if(array[i]>=0){
                  positives[p++]=array[i];
              }
              else
              {
                  negatives[n++]=-1*array[i];
              }
          }
          if (l==2||l==3) {
            System.out.println("Fisrt split array to positives and negatives");
            System.out.print("positives: ");
            printArray(positives);
            System.out.print("abs(negatives): ");
            printArray(negatives);
          }
         
          int maxp=getmax(positives);
          int maxn=getmax(negatives);
          if (l==2||l==3) { System.out.println("first thing to sort positives using radix sort");}
         
          for(int pos=1;maxp/pos>0;pos=pos*10)
          {
              countSortHelpRadix(positives,pos);
          }
          if (l==2||l==3) { System.out.print("positives after sorting:");
          printArray(positives);
          System.out.println("second thing to sort negatives using radix sort");}
         
          for(int pos=1;maxn/pos>0;pos=pos*10)
          {
                   countSortHelpRadix(negatives,pos);
          }
          if (l==2||l==3) {  System.out.print("negatives after sorting:");
          printArray(negatives);}
        
          int i=0;
          while(n-1>=0)
          {
            array[i++]=negatives[--n]*-1;
          }
          for(int k=0;k<positives.length;k++)
          {
            array[i++]=positives[k];
          }
         
        return array;
       
    }
    private int getmax(int arr[])
    {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            if(max<arr[i])max=arr[i];
        }
        return max;
    }
    private void countSortHelpRadix(int a[],int pos)
    {
           int count[]=new int[10];
           for(int i=0;i<10;i++)count[i]=0;
           for(int i=0;i<a.length;i++)
           {
               ++count[(a[i]/pos)%10];
           }
           for(int i=1;i<10;i++)count[i]+=count[i-1];
           int []b=new int[a.length];
           for(int i=a.length-1;i>=0;i--)
           {
               b[--count[(a[i]/pos)%10]]=a[i];
           }

           for(int i=0;i<a.length;i++)a[i]=b[i];
        }


        void printArray(int[] arr) {
            System.out.print("[ ");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
                if (i < arr.length - 1) {
                    System.out.print(" , ");
                }
            }
            System.out.println(" ]");
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
            System.out.println("2. Efficient Sort (O(n log n))");
            System.out.println("3. Non-Comparison Sort (O(n))");
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