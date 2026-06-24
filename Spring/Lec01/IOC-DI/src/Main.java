import sping.core.service.SocialMediaAccount;
import spring.core.service.impl.FacebookAccountImpl;
import spring.core.service.impl.InstagramAccountImpl;
import spring.core.service.impl.WhatsAppAccountImpl;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        SocialMediaAccount socialMediaAccount = new SocialMediaAccount(new InstagramAccountImpl());
        socialMediaAccount.createAccount("Mahmoud","123");
        socialMediaAccount.createPost(1L,"Hellllo");







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