import java.io.*;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        nestedEx();

    }


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
            System.out.println("OUR ARRAY IS "+ Arrays.toString(arr));
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
}