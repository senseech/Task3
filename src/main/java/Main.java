public class Main {
    public static void main(String[] args) {

        GsonParseTests parseTests = new GsonParseTests();
        RootTests rootTests = parseTests.parse();
        System.out.println("Root Tests " + rootTests.toString());

        GsonParseValues parseValues = new GsonParseValues();
        RootValues rootValues = parseValues.parse();
        System.out.println("Root Values " + rootValues.toString());


        //rootTests.tests.forEach();
    }
}
