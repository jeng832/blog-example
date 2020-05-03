import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class JsonUtilTest {
    String mappingJson = "" +
            "{" +
            "    num:1," +
            "    str:a" +
            "}";

    @Test
    public void testObjectMapping() {
        assertEquals(new TestClazz(1, "a"), JsonUtil.fromJson(mappingJson, TestClazz.class));

        assertEquals("{\"num\":1,\"str\":\"a\"}", JsonUtil.toJson(new TestClazz(1, "a")));

        JsonObject jsonObject = new JsonObject();
        jsonObject.add("num", new JsonPrimitive(1));
        jsonObject.add("str", new JsonPrimitive("a"));
        assertEquals(jsonObject, JsonUtil.parse(mappingJson));
    }

    String parsingJson = "" +
            "{" +
            "    \"strKey\": \"strValue\"," +
            "    \"numKey\": 99," +
            "    \"boolKey\": true," +
            "    \"arrObj\": [" +
            "        {\"k1\": \"v1\", \"k2\": \"v2\"}," +
            "        {\"k1\": \"v3\", \"k2\": \"v4\"}," +
            "        {\"k1\": \"v5\", \"k2\": \"v6\"}" +
            "    ]," +
            "    \"arrObj2\": [" +
            "        {\"k1\": \"v1\", \"k2\": [10, 20, 30]}" +
            "    ]," +
            "    \"arrNum\": [3.14, 200, 300]," +
            "    \"doubleArrNum\": [[100, 200], [300, 400]]" +
            "}";

    @Test
    public void testJsonParse() {
        JsonObject obj = JsonParser.parseString(parsingJson).getAsJsonObject();
        assertEquals("strValue", JsonUtil.getValue(parsingJson, "strKey"));
        assertEquals("strValue", JsonUtil.getValue(obj, "strKey"));
        assertEquals(99, JsonUtil.getValueAsInteger(parsingJson, "numKey"));
        assertEquals(99, JsonUtil.getValueAsInteger(obj, "numKey"));
        assertEquals("99", JsonUtil.getValue(parsingJson, "numKey"));
        assertEquals("99", JsonUtil.getValue(obj, "numKey"));
        assertEquals(true, JsonUtil.getValueAsBoolean(parsingJson, "boolKey"));
        assertEquals(true, JsonUtil.getValueAsBoolean(obj, "boolKey"));
        assertEquals("{\"k1\":\"v3\",\"k2\":\"v4\"}", JsonUtil.getValue(parsingJson, "arrObj[1]"));
        assertEquals("{\"k1\":\"v3\",\"k2\":\"v4\"}", JsonUtil.getValue(obj, "arrObj[1]"));
        assertEquals(300, JsonUtil.getValueAsInteger(parsingJson, "arrNum[2]"));
        assertEquals(300, JsonUtil.getValueAsInteger(obj, "arrNum[2]"));
        assertEquals(300, JsonUtil.getValueAsInteger(parsingJson, "doubleArrNum[1][0]"));
        assertEquals(300, JsonUtil.getValueAsInteger(obj, "doubleArrNum[1][0]"));
        assertEquals(20, JsonUtil.getValueAsInteger(parsingJson, "arrObj2[0].k2[1]"));
        assertEquals(20, JsonUtil.getValueAsInteger(obj, "arrObj2[0].k2[1]"));

        assertNull(JsonUtil.getValue(parsingJson, "nothing"));
    }

    @Test(expected = NumberFormatException.class)
    public void testNumberFormatException() {
        JsonObject obj = JsonParser.parseString(parsingJson).getAsJsonObject();
        assertEquals("{\"k1\": \"v3\", \"k2\": \"v4\"}", JsonUtil.getValue(parsingJson, "arrObj[a]"));
        assertEquals("{\"k1\": \"v3\", \"k2\": \"v4\"}", JsonUtil.getValue(obj, "arrObj[a]"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsException() {
        JsonObject obj = JsonParser.parseString(parsingJson).getAsJsonObject();
        JsonUtil.getValue(parsingJson, "arrObj[99]");
        JsonUtil.getValue(obj, "arrObj[99]");
    }

    class TestClazz {
        private int num;
        private String str;
        public TestClazz(int n, String s) {
            num = n;
            str = s;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null) return false;
            if (o instanceof TestClazz) {
                TestClazz testClazz = (TestClazz) o;
                return num == testClazz.num &&
                        str.equals(testClazz.str);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(num, str);
        }
    }
}
