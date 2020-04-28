import com.google.gson.*;
import org.junit.Test;

public class GsonTest {
    @Test
    public void testJsonObject() {
        String json =
                "{" +
                        "    strKey : strValue, " +
                        "    numKey: 235, " +
                        "    arrKey: [arrV1, arrV2, arrV3]," +
                        "    objKey: {subKey: subValue}," +
                        "    numArrKey: [100, 200, 300]," +
                        "    nullKey: null" +
                        "}";
        JsonObject jsonObj = (JsonObject) JsonParser.parseString(json);
        System.out.println(jsonObj.isJsonPrimitive());
        System.out.println(jsonObj.isJsonObject());
        System.out.println(jsonObj.isJsonArray());
        System.out.println(jsonObj.isJsonNull());
        System.out.println(jsonObj.toString());

        System.out.println("=============== strKey ===============");
        JsonElement element = jsonObj.get("strKey");
        System.out.println(element.isJsonPrimitive());
        System.out.println(element.isJsonObject());
        System.out.println(element.isJsonArray());
        System.out.println(element.isJsonNull());
        System.out.println(element.toString());

        JsonPrimitive primitive = element.getAsJsonPrimitive();
        System.out.println(primitive.getAsString());

        System.out.println("=============== numKey ===============");
        element = jsonObj.get("numKey");
        System.out.println(element.isJsonPrimitive());
        System.out.println(element.isJsonObject());
        System.out.println(element.isJsonArray());
        System.out.println(element.isJsonNull());
        System.out.println(element.toString());

        primitive = element.getAsJsonPrimitive();
        System.out.println(primitive.getAsString());

        System.out.println("=============== arrKey ===============");
        element = jsonObj.get("arrKey");
        System.out.println(element.isJsonPrimitive());
        System.out.println(element.isJsonObject());
        System.out.println(element.isJsonArray());
        System.out.println(element.isJsonNull());
        System.out.println(element.toString());

        JsonArray array = element.getAsJsonArray();

        System.out.println("=============== objKey ===============");
        element = jsonObj.get("objKey");
        System.out.println(element.isJsonPrimitive());
        System.out.println(element.isJsonObject());
        System.out.println(element.isJsonArray());
        System.out.println(element.isJsonNull());
        System.out.println(element.toString());

        System.out.println("=============== nullKey ===============");
        element = jsonObj.get("nullKey");
        System.out.println(element.isJsonPrimitive());
        System.out.println(element.isJsonObject());
        System.out.println(element.isJsonArray());
        System.out.println(element.isJsonNull());
        System.out.println(element.toString());
    }

    @Test
    public void testJsonParse() {
        String json =
                "{" +
                        "    strKey : strValue, " +
                        "    numKey: 235, " +
                        "    arrKey: [arrV1, arrV2, arrV3]," +
                        "    objKey: {subKey: subValue}," +
                        "    numArrKey: [100, 200, 300]," +
                        "    nullKey: null" +
                        "}";
        JsonObject jsonObj = (JsonObject) JsonParser.parseString(json);
        jsonObj = JsonParser.parseString(json).getAsJsonObject();
    }

    @Test
    public void testJsonConvert() {
        JsonElement elem = JsonParser.parseString("{}:wq");
        if (elem.isJsonPrimitive()) {
            JsonPrimitive primitive = elem.getAsJsonPrimitive();
            // logic for JsonPrimitive
        } else if (elem.isJsonArray()) {
            JsonArray array = elem.getAsJsonArray();
            // logic for JsonArray
        } else if (elem.isJsonObject()) {
            JsonObject object = elem.getAsJsonObject();
            // logic for JsonObject
        } else if (elem.isJsonNull()) {
            JsonNull jsonNull = elem.getAsJsonNull();
            // logic for JsonNull
        }
    }

}


