//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//
//        Thread t4 = new Thread(()->{
//            for (int i = 1; i <= 10; i++) {
//                if(i%2==0){
//                    System.out.println("HABIBI "+i);
////                    try {
////                        Thread.sleep(3000);
////                    } catch (InterruptedException e) {
////                        throw new RuntimeException(e);
////                    }
//                }
//            }
//        });
//
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 1; i <= 5; i++) {
//                    System.out.println("Woman"+i);
//                }
//                System.out.println("Finish" + Thread.currentThread().getName());
//            }
//        });
//        t1.start();
//        Thread t2 = new Thread(()->{
//            for (int i = 1; i <= 5; i++) {
//                System.out.println("Man "+i);
//            }
//            System.out.println("Finish" + Thread.currentThread().getName());
//        });
//
//        Thread t3 = new Thread(new Person("Ali",25));
//        t3.start();
//
//        t4.start();
//        try {
//            t4.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        t2.start();
//
//        School school = new School("FADL");
//        school.start();




//
//        Teacher teacher = new Teacher();
//        Thread thread = new Thread(teacher);
//        Thread thread1 = new Thread(teacher);
//        thread.start();
//        thread1.start();
//        try {
//            thread.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        try {
//            thread1.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        System.out.println(teacher.getCounter());



// 1 .
//        Company company = new Company("Asset");
//        company.start();
//2 .

//        Employee employee= new Employee();
//        employee.setId(1L);
//        employee.setName("John");
//        Thread thread = new Thread(employee);
//        thread.start();

//3.
//        Thread threadSleep = new Thread(()->{
//            for(int i=1;i<=5;i++) {
//                System.out.println(i);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    System.out.println(e.getMessage());
//                }
//            }
//        });
//        threadSleep.start();

//4.
//        try {
//            threadSleep.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(Thread.currentThread().getName());



//5.
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBalance(1000);

        Thread depositorThread = new Thread(new Depositor(bankAccount));
        Thread withdrowerThread = new Thread(new Withdrower(bankAccount));

        depositorThread.start();
        withdrowerThread.start();

    }
}