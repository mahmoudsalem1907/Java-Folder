public class Company extends Thread{


    private String name;
    public Company(String name) {
        this.name = name;
    }
    public void run() {
        print();
    }
    public void print() {
        System.out.println("Company " + name + " is running");
    }
}
