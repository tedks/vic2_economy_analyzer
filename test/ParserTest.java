import eug.parser.EUGFileIO;
import eug.shared.GenericObject;

public final class ParserTest {
    public static void main(String[] args) {
        GenericObject root = EUGFileIO.loadFromString(
                "country={name=FRA population=123 province={id=1}}\n");
        if (root == null || root.getChild("country") == null) {
            throw new AssertionError("country object was not parsed");
        }
        GenericObject country = root.getChild("country");
        if (!"FRA".equals(country.getString("name")) || country.getInt("population") != 123) {
            throw new AssertionError("country fields were not parsed");
        }
        GenericObject province = country.getChild("province");
        if (province == null || province.getInt("id") != 1) {
            throw new AssertionError("nested province was not parsed");
        }
    }
}
