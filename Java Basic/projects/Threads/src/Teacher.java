public class Teacher implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 6000; i++) {
            counter++;
        }
    }
    private int counter = 0;
    public void setCounter(int counter) {
        this.counter = counter;
    }
    public int getCounter() {
        return counter;
    }

}
