import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static RootTests SearchValues(RootValues rootValues, RootTests rootTests) {
        rootValues.values.forEach(x -> {
            Optional<Test> option = rootTests.tests.stream().filter(y -> {
                if (x.id == y.id) {
                    return true;
                }
                if (y.values == null) {
                    return false;
                }
                return y.values.stream().anyMatch(z -> z.id == x.id);
            }).findFirst();
            option.ifPresent(test -> test.value = x.value);
        });
        return rootTests;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        GsonParseTests parseTests = new GsonParseTests();
        RootTests rootTests = parseTests.parse(in.next());

        GsonParseValues parseValues = new GsonParseValues();
        RootValues rootValues = parseValues.parse(in.next());

//        System.out.println("Root Tests " + rootTests.toString());
//        System.out.println("Root Values " + rootValues.toString());
//        System.out.println("Root Tests " + rootTests.toString());

        try {
            Writer writer = new FileWriter("report.json");
            new Gson().toJson(SearchValues(rootValues, rootTests), writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
