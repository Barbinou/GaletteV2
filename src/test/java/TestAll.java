public class TestAll {
    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main(
                "TestConcours",
                "TestGourmand",
                "TestGourmet",
                "TestGalettes"
        );
    }
}
