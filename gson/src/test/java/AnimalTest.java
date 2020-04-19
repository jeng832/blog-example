import com.google.gson.Gson;
import org.junit.Test;

public class AnimalTest {

    @Test
    public void testJson() {
        Gson gson = new Gson();

        String json = "{\"legs\":4, \"name\": \"Bill\"}";
        Animal animal = gson.fromJson(json, Animal.class);
        System.out.println(animal);

        String reJson = gson.toJson(animal);
        System.out.println(reJson);
    }
}
