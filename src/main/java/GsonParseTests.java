import com.google.gson.Gson;

import java.io.FileReader;

public class GsonParseTests {

    public RootTests parse(){

        Gson gson =  new Gson();
        try(FileReader reader = new FileReader("tests.json")){

            RootTests root = gson.fromJson(reader, RootTests.class);
            return root;

        }catch (Exception e){
            System.out.println("pars err" + e.toString());
        }

        return null;
    }
}
