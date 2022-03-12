import com.google.gson.Gson;
import java.io.FileReader;

public class GsonParseValues {

    public RootValues parse(String string) {

        Gson gson = new Gson();

        try (FileReader reader = new FileReader(string)) {
            RootValues root = gson.fromJson(reader, RootValues.class);
            return root;

        } catch (Exception e) {
            System.out.println("pars err" + e.toString());
        }

        return null;
    }

}
