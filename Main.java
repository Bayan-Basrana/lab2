import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

/*
1.Write a program to find all of the longest word in a given dictionary.
 */
        String[] dictionary = {"cat", "dog", "red", "is", "am"};
        System.out.println(findlongestWord(dictionary));

    /*
 2. Write a program that displays the number of occurrences of an element in the array.
     */

        int[] arr = {1, 1, 1, 3, 3, 5};
        countOccurrences(arr);

/*
3.Write a program to find the k largest elements in a given array. Elements in the array can be in
any order.
 */
        int[] array1 = {1, 4, 17, 7, 25, 3, 100};
        int k = 3;
        findLargest(array1, k);

  /*
  4. Create a method to reverse an array of integers. Implement the method without creating a new
array.
   */
        int[] arrays = {5, 4, 3, 2, 1};
        reversArrays(arrays);
        System.out.println("Reversed Array:  ");
        for (int a : arrays)
            System.out.print(a + "  ");
        System.out.println();
   /*
  5. Write a menu driven Java program with following option:
    */
        System.out.println("chose the size of the array");
        int sizeArray = input.nextInt();
        int[] element = new int[sizeArray];
        int num=0;
        do {
            System.out.println("The menu");
            System.out.println("1. Accept elements of an array ");
            System.out.println("2. Display elements of an array ");
            System.out.println("3. Search the element within array ");
            System.out.println("4. Sort the array ");
            System.out.println("5.To stop ");

            num = input.nextInt();
            switch (num) {
                case 1:
                    System.out.println(" enter element of the Array");
                    for (int i = 0; i < sizeArray; i++)
                        element[i] = input.nextInt();
                    break;
                case 2:
                    System.out.println("Array elements :" + Arrays.toString(element));
                    break;
                case 3:
                    System.out.println(" enter elements to search");
                    int searchNum = input.nextInt();
                    boolean test = false;
                    for (int e : element){
                        if (e == searchNum){
                            test = true;
                            System.out.println("element " + searchNum + " is present in the Array");
                        } else

                            System.out.println("element " + searchNum + " is not present in the Array");}
                    break;
                case 4:
                    Arrays.sort(element);
                    System.out.println(Arrays.toString(element));
                    System.out.println("Array sorted");
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option ");
                    break;
            }


        }while (num != 5) ;
  /*
  6. Create a method that generates a random number within a given range. Allow the user to
specify the range and call the method to display random numbers.
Hint: use Random class
   */
        System.out.println("Enter the minimum value of the range: ");
        int min= input.nextInt();
        System.out.println("Enter the maximum value of the range: ");
        int max=input.nextInt();

        System.out.println("Enter the number of random numbers to generate: ");
        int count= input.nextInt();

generatesRandomNum(min ,max, count);

  /*
 7. Write a program that checks the strength of a password. Create a method that evaluates a
password based on criteria like length, inclusion of special characters, and
uppercase/lowercase letters.
   */

        System.out.print("Enter a password: ");
        String password = input.next();

        System.out.println(evaluatePasswordStrength(password));
 /*
  8. Create a method that generates the Fibonacci sequence up to a specified number of terms.
Hint: The Fibonacci sequence is a mathematical sequence of numbers that starts with 0 and 1,
and each subsequent number in the sequence is the sum of the two preceding ones.
  */
        System.out.println("Enter the number of Fibonacci to generate: ");
int term = input.nextInt();
fibonacciGenerator(term);
    }

    public static void countOccurrences(int[] arr) {
        boolean[] counted = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (!counted[i]) {
                int count = 1;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] == arr[j]) {
                        count++;
                        counted[j] = true;
                    }
                }
                System.out.println(arr[i] + " occurs " + count + " times");
            }}
    }



    public static ArrayList<String> findlongestWord (String[] dictionary) {
        ArrayList<String> longestWord = new ArrayList<>();
        int longest = 0;
        for (String word : dictionary) {
            if (word.length() > longest) {
                longest = word.length();
                longestWord.clear();
                longestWord.add(word);
            } else if (word.length() == longest) {
                longestWord.add(word);
            }
        }
        return longestWord;
    }



    public static void findLargest(int [] array1 , int k){
        if (k> array1.length){
            System.out.println(k+ "  largest elements of the said array are: ");
            return;
        }
        Arrays.sort(array1);
        ArrayList<Integer> newArray= new ArrayList<>();
        for (int i= array1.length-1 ; i>= array1.length-k; i--)
          newArray.add(array1[i]);
        System.out.println(newArray);
    }
    public static void reversArrays (int [] arrays ){
        int left=0;
        int right =arrays.length -1 ;
        while (left<right){
            int temp = arrays[left];
            arrays[left]= arrays[right];
            arrays[right]=temp;
            left++;
            right--;
        }
    }

    public static void generatesRandomNum (int min, int max ,int count){
        Random ran = new Random();
        System.out.println("Random numbers within the specified range:  ");
        for(int i=0 ;i<count; i++) {
            int randomNum =ran.nextInt((max-min)+1);
            System.out.println(randomNum);

        }
    }
    public static void fibonacciGenerator (int term){
        int num1 =0;
        int num2=1;
     System.out.println("Fibonacci sequence with "+term+" terms: ");
     for (int i=0; i<term;i++){
         System.out.println(num1+ " ");
     int nextNum= num1 +num2;
     num1 = num2;
     num2 = nextNum;
    }
}

    public static int checkLength(String password) {
        if (password.length() >= 8) {
            return 3;
        } else if (password.length() >= 6) {
            return 2;
        } else {
            return 0;
        }}
    public static int checkSpecialCharacters(String password) {
        if (password.matches(".*[!@#$%^&()].*")) {
            return 2;
        } else {
            return 0;
        }}
    public static int checkUpperCaseLowerCase(String password) {
        if (password.matches(".*[A-Z].*") && password.matches(".*[a-z].*")) {
            return 3;
        } else {
            return 0;}}
    public static String evaluatePasswordStrength(String password) {
        int lengthScore = checkLength(password);
        int specialChrScore = checkSpecialCharacters(password);
        int caseScore = checkUpperCaseLowerCase(password);
        int totalScore = lengthScore+ caseScore+ specialChrScore;
        System.out.println("length Score " + lengthScore);
        System.out.println("special ChrScore " + specialChrScore);
        System.out.println("case Score " + caseScore);
        System.out.println("total " + totalScore);
        if (totalScore >= 8) {
            return "Password is strong.";
        } else if (totalScore >= 5) {
            return "Password is moderately strong.";
        } else {
            return "Password is weak.";
        }}
}