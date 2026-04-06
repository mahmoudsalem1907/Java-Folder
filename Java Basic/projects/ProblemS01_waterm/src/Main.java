import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {


//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        System.out.println(num);

        



    }


    /*
/// ///////////////////////////////////////////////////////////////
//12.
    ///  ///////////////////
    private static void nestedEx() {
        try{
            int sum = 5/0;
            System.out.println("sum is " + sum);
        }catch(ArithmeticException e){
            try {
                String word = null;
                System.out.println("word is " + word.toLowerCase());
            }catch (NullPointerException ex){
                System.out.println("EXception  "+ex.getMessage());
            }
        }
    }
/// ////////////////////////////////

//9.
//////////////////////////////////
    private static void propgationEx() {
        try {
            findById(15);
        }catch (InputMismatchException e) {
            System.out.println("Invalid Input " + e.getMessage());
        }
    }


    public static void findById(int id ){
            if(id == 18){
                System.out.println("Found It");
            }else {
                throw new InputMismatchException();
            }

    }

/// ///////////////////////////////

//10.
/// ////////////////////////////////////
    private static void readfileException() {
        try {
            readFile();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());;
        }
    }

    private static BufferedReader readFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("data.txt"));
        return br;


    }
/// //////////////////////////////////
//11.
    private static void finallyUse() {
        try {
            double result = 5/0;
            System.out.println(result);
        }catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception  :::: " + e.getMessage());
        }finally {
            System.out.println("Finally Block");
        }
    }
//7.
    private static void customException() {
        try{
            System.out.println("Enter Age :");
            Scanner input = new Scanner(System.in);
            int age = input.nextInt();
            if (age >= 18) {
                System.out.println("Your age is " + age);
            }else {
                throw new InvalidAgeException(age);
            }
        }catch (InvalidAgeException e){
            System.out.println("THAT IS " + e.getMessage());
        }
    }
//6.
    private static void multipleCatch() {
        try{

            int[] arr = new int[5];
            arr[0] = 1;
            arr[1] = 2;
            arr[2] = 3;
            arr[3] = 0;
            String word = null;
            System.out.println("OUR ARRAY IS "+Arrays.toString(arr));
            System.out.println("Enter the number to make calculation");
            System.out.println("1 - multiple\n" +
                    "2 - divide\n" +
                    "3 - read\n" + "Else print name"
            );
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            if(num == 1){
                System.out.println("Result ::: " + arr[2] * arr[1]);
            }else if(num == 2){
                System.out.println("Result ::: " + arr[0] / arr[3]);
            }else if(num == 3){
                System.out.println("Result ::: " + arr[5]);
            }else {
                System.out.println(word.toLowerCase());
            }


        }catch(ArithmeticException e){
            System.out.println("Arithmetic Exception " + e.getMessage());
        }catch(NullPointerException e){
            System.out.println("NullPointer Exception " + e.getMessage());
        }
    }
//5.
    private static void fileRead() {
        try{
            File file = new File("C:\\Users\\Sheen\\Downloads\\new login rdesp.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }

            sc.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found Ya DEV " + e.getMessage());
        }
    }
//4.
    private static void arrayIndexOut() {
        try{
            int[] arr = new int[5];
            arr[0] = 1;
            arr[1] = 2;
            arr[2] = 3;
            System.out.println(Arrays.toString(arr));
            System.out.println(arr[1]);
            System.out.println(arr[6]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Not vaild ya basha becouse" + e.getMessage() );
        }
    }
//3.
    private static void nullPointer() {
        try{
            String names = null;
            System.out.println(names.toUpperCase());
        }catch(NullPointerException e){
            System.out.println("Error ::: "+e.getMessage());
        }
    }
//2.
    private static void numberFortater() {
        try{
            Scanner input = new Scanner(System.in);
            System.out.println("Enter The Number");
            String word = input.nextLine();
            int number = Integer.parseInt(word);

            System.out.println("Your Number is " + number);
        }catch(NumberFormatException e){
            System.out.println("Invalid Input Ya Basha");
        }
    }
//1.
    public static void divideByzero(){
        try{
            Scanner input = new Scanner(System.in);
            System.out.println("Enter First Number");
            int fNum = input.nextInt();
            System.out.println("Enter Second Number");
            int sNum = input.nextInt();
            double result = fNum/ sNum;
            System.out.println("The result is: " + result);
        }catch (ArithmeticException e){

            System.out.println("You Have Issue Becouse " + e.getMessage());
        }
    }

/// ///////////////////////////////////////////////////////////////
*/


    public static void Game(){
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        List<Integer> inputWords = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num; i++) {
            int word = input.nextInt();
            inputWords.add(word);
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < inputWords.size(); i++) {
            System.out.println((inputWords.get(i)));
            for (int j = 0; j < inputWords.get(i); j++) {}
            stack.push(inputWords.get(i));
            result.add("DA");
        }
    }
    
    public static void InSearchofanEasyProblem(){
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

//        boolean hard = false;
//        for (int i = 0; i < n; i++) {
//            if (input.nextInt() == 1) {
//                hard = true;
//                break;
//            }
//        }
//        System.out.println(hard ? "HARD" : "EASY");


        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < num; i++) {
            int bool = input.nextInt();
            set.add(bool);
        }
        if (set.size() > 1 || set.contains(1)){
            System.out.println("HARD");
        }else {
            System.out.println("EASY");
        }
    }

    public static void CalculatingFunction(){
        //Calculating Function
        Scanner sc = new Scanner(System.in);
        long num = sc.nextInt();

//        if (num % 2 == 0) {
//            System.out.println(num / 2);
//        } else {
//            System.out.println(-(num + 1) / 2);
//        }

        long sum = 0;
        for (int i = 1; i <= num; i++) {

            int number =i;
            if(i %2 !=0) {
                number = i *-1;
            }
            sum+=number;
        }

        System.out.println(sum);
    }

    public static void sum(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<String> lastList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            PriorityQueue pq = new PriorityQueue<>();
            List list = new ArrayList();
            int sum1 = 0;
            for (int j = 0; j < 3; j++) {
                int m = scanner.nextInt();
                pq.add(m);
            }
            while (!pq.isEmpty()) {
                list.add(pq.poll());
            }

            int sum2 = (int) list.get(list.size() - 1);
            for (int ii = 0; ii < list.size()-1; ii++) {
                sum1 += (int) list.get(ii);
            }
            if (sum1 == sum2) {
                lastList.add("YES");
            }else {
                lastList.add("NO");
            }
        }

        for (String s : lastList) {
            System.out.println(s);
        }


    }

    public static void girlAndBoy(){
        Scanner scanner = new Scanner(System.in);
        String gender = scanner.nextLine();

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < gender.length(); i++) {
            set.add(gender.charAt(i) + "");
        }

        if(set.size() %2==0){
            System.out.println("CHAT WITH HER!");
        }else {
            System.out.println("IGNORE HIM!");
        }
    }

    public static void twoSisters(){
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        Vector<Integer> result =  new Vector<>();

        for (int i = 0; i < num; i++) {
            int num2 = input.nextInt();
            if(num2 > 2){
                if(num2%2 ==0){
                    result.add((num2/2)-1);
                }else {
                    result.add(num2/2);
                }
            }else {
                result.add(0);
            }
        }

        for(Integer i : result){
            System.out.println(i);
        }
    }

    public static void getAvarage(){
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        double sum = 0;
        for (int i = 0; i < num; i++) {
            int num2 = input.nextInt();
            sum += num2;
        }

        double average = sum / num;
        System.out.println(average);
    }

    public static void addingNumber(){
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        input.nextLine();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            int addingNumber = input.nextInt();
            input.nextLine();
            int firstNum = addingNumber/10;
            int secondNum = addingNumber%10;
            int finalNum = firstNum + secondNum;
            numbers.add(finalNum);

        }
        for(int i = 0; i < numbers.size(); i++){
            System.out.println(numbers.get(i));
        }
    }

    public static void yesOryes(){
        Scanner input = new Scanner(System.in);
        int inputNumber = input.nextInt();
        input.nextLine();
        List<String> result = new ArrayList<>();
        for (int i = 0; i <inputNumber; i++) {
            Scanner inputword = new Scanner(System.in);
            String word = inputword.nextLine();
            if (word.length() == 3 && word.toLowerCase().equals("yes")){
                result.add("YES");

            }else {
                result.add("NO");
            }

        }
        for (String s : result) {
            System.out.println(s);
        }
    }

    public static void tooLongString(){



//        Scanner number = new Scanner(System.in);
//        int number1 = number.nextInt();
//        List arrayList = new ArrayList();
//        for (int i = 0; i < number1; i++) {
//            Scanner word = new Scanner(System.in);
//            String word1 = word.nextLine();
//            arrayList.add(word1);
//        }
//        for (int i = 0; i < arrayList.size(); i++) {
//            if (arrayList.get(i).toString().length() <=10) {
//                System.out.println(arrayList.get(i).toString().toLowerCase());
//            }else {
//                String word1 = arrayList.get(i).toString();
//                int size = (word1.length()) - 2;
//                System.out.println(word1.charAt(0) + "" + size + "" + word1.charAt(word1.length() - 1));
//
//            }}

                Scanner scanner = new Scanner(System.in);

                int number1 = scanner.nextInt();
                scanner.nextLine();

                List<String> arrayList = new ArrayList<>();

                for (int i = 0; i < number1; i++) {
                    String word = scanner.nextLine();
                    arrayList.add(word);
                }

                for (int i = 0; i < arrayList.size(); i++) {
                    String word = arrayList.get(i);

                    if (word.length() <= 4) {
                        System.out.println(word.toLowerCase());
                    } else {
                        int size = word.length() - 2;
                        System.out.println(word.charAt(0) + "" + size + "" + word.charAt(word.length() - 1));
                    }
                }
    }

    public static void watermelon(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n<=2){
            System.out.println("NO");
        }else if (n % 2 == 0) {
            System.out.println("YES");
        }else  {
            System.out.println("NO");
        }
    }

//        Scanner input = new Scanner(System.in);
//        int inputNumber = input.nextInt();
//        input.nextLine();
//
//        for (int i = 0; i <= inputNumber; i++) {
//            System.out.println("add value of opinion of every member");
//            int opinion = input.nextInt();
//            input.nextLine();
//
//        }
}

