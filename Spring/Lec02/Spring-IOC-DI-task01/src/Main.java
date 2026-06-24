import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.core.service.Impl.AccountServiceImpl;
import spring.core.service.Impl.MangerService;
import spring.core.service.Impl.PersonService;
import spring.core.service.UserService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonService personService = (PersonService) context.getBean("PersonService");

        personService.save("Mahmoud Salem");
        personService.update("Ali Mokhtar");

        MangerService mangerService = (MangerService) context.getBean("MangerService");

        mangerService.save("Mahmoud Abdallah Manger");
        mangerService.update("Hassan Mokhtar Manager");


        System.out.println("*************** NO XML *****************");
        PersonService personServiceFromJava = new PersonService();
        personServiceFromJava.save("Daly JAVA");
        personServiceFromJava.update("Hamada C#");


        MangerService mangerServiceFromJava = new MangerService();
        mangerServiceFromJava.save("Hamdy C++");
        mangerServiceFromJava.update("Fathy Dart");

        System.out.println("\n********************************");
        System.out.println("************ TASK-02 *************");
        System.out.println("********************************\n");


        AccountServiceImpl accountServiceimpl = (AccountServiceImpl) context.getBean("AccountServiceImpl");
        accountServiceimpl.getSavePerson("Marwan");
        System.out.println("*************** No XML *****************");
        AccountServiceImpl accountService = new AccountServiceImpl(new PersonService());
        accountService.getSavePerson("Nasr");

        System.out.println("\n********************************");
        System.out.println("************ TASK-03 *************");
        System.out.println("********************************\n");

        context.close();


    }
}