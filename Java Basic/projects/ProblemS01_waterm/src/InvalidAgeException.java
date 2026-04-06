public class InvalidAgeException extends Exception {

    public int age;
    public InvalidAgeException(int age) {

        super("Exception Age Must Top or Above 18 No (" + age+")");
    }

}
