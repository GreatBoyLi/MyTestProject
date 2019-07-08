import com.peng.wen.factory.AnimalFactory;
import com.peng.wen.interfaces.Animal;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:Spring*.xml");
        AnimalFactory animalFactory = (AnimalFactory)context.getBean("animalFactory");
        Animal cat = animalFactory.getAnimals().get(0);
        Animal dog = animalFactory.getAnimals().get(1);

        cat.say();
        dog.say();
    }
}
