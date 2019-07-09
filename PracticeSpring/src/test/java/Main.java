import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
        Animal animal = animalFactory.getAnimals().get(2);

        System.out.println(animalFactory.getAnimals().size());
        cat.say();
        dog.say();
        animal.say();
        JSONObject cat1 = new JSONObject();
        JSONObject cat2 = new JSONObject();
        cat2.put("HAHA","啊啊啊啊");
        cat2.put("VALUE","liwpb");
        cat1.put("姓名",cat2);
        cat.setAttribute(cat1);
        System.out.println(cat.getValue("姓名"));

    }
}
