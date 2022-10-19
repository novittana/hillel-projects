import util.AutoBrand;
import util.AutoModel;

public class Main {

    public static void main (String[] args) {

        Auto auto1 = new Auto(AutoBrand.Audi, AutoModel.A6,10);
        auto1.setCurrentSpeed(100);

        Auto auto2 = new Auto(AutoBrand.Audi, AutoModel.A6,10);
        auto2.setCurrentSpeed(350);

        Auto auto3 = new InheritAuto(AutoBrand.Porche,AutoModel.Porche_911,50);
        auto3.setCurrentSpeed(410);

        Auto auto4 = new InheritAuto(AutoBrand.Porche,AutoModel.Porche_911,1111111111);
        auto4.setCurrentSpeed(390);

        User user = new User ("Vasya","Pupkin","vasyaPupkin@gmail.com","Qwerty123");
        user.setCountry("England");
        user.setBirthday("14.02.1990");
        user.addAuto(auto1);
        user.addAuto(auto2);
        user.showInfo();

        User user2 = new User ("Vasya","Pupkin","vasyaPupkingmail.com","Qwerty123");
        user2.showInfo();

        User user3 = new User ("vasya@Pupkingmail.com","Qwerty123");
        user3.addAuto(auto3);
        user3.showInfo();
    }
}
