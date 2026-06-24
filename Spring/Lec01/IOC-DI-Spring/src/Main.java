import sping.core.service.AccountService;
import sping.core.service.SocialMediaAccount;
import spring.core.service.impl.FacebookAccountImpl;
import spring.core.service.impl.InstagramAccountImpl;
import spring.core.service.impl.WhatsAppAccountImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        SocialMediaAccount socialMediaAccount = new SocialMediaAccount(new InstagramAccountImpl());
        socialMediaAccount.createAccount("Mahmoud","123");
        socialMediaAccount.createPost(1L,"Hellllo");


        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        WhatsAppAccountImpl WhatsAppAccountImplaccountService1 =  applicationContext.getBean("WhatsAppAccountImpl",WhatsAppAccountImpl.class);

        WhatsAppAccountImpl WhatsAppAccountImplaccountService = (WhatsAppAccountImpl) applicationContext.getBean("WhatsAppAccountImpl");
        WhatsAppAccountImplaccountService.createAccount("Salem","456987");
        WhatsAppAccountImplaccountService1.createAccount("Hossam","894");


        SocialMediaAccount socialMediaAccount1 = applicationContext.getBean("SocialMediaAccount",SocialMediaAccount.class);
        socialMediaAccount1.createPost(5L,"JAJA");




//        FacebookAccountImpl facebook = new FacebookAccountImpl();
//        facebook.createAccount("Mahmoud","123");
//        facebook.createPost(1L,"Hellllo");
//
//
//
//        WhatsAppAccountImpl whatsAppAccount = new WhatsAppAccountImpl();
//        whatsAppAccount.createAccount("Salem","456");
//        whatsAppAccount.createPost(2L,"Ahly");
//
//        InstagramAccountImpl  instagram = new InstagramAccountImpl();
//        instagram.createAccount("Trabay","789");
//        instagram.createPost(1L,"Barcelona");

    }
}