import com.google.gson.Gson;
import java.io.FileReader;

public class GsonParseTests {

    public RootTests parse(String string) {

        Gson gson = new Gson();

        try (FileReader reader = new FileReader(string)) {
            return gson.fromJson(reader, RootTests.class);

        } catch (Exception e) {
            System.out.println("pars err" + e);
        }

        return null;
    }
}
