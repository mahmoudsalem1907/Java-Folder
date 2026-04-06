public class School extends Thread{
    public void run(){
        print();
    }
    private String name;
    public School(String name){
        this.name=name;
    }


    public void print(){
        System.out.println("My School is "+this.name);
    }
}
