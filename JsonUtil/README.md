# JsonUtil
## method list
### public static <T> T fromJson(String json, Class<T> clazz)
- object mapping from Json String to class
### public static <T> String toJson(T obj)
- class to Json String
### public static JsonObject parse(String json)
- Json String to JsonObject
### public static String getValue(JsonObject object, String key)
- get String value of key from JsonObject
- Support chained key
    - key1.key2.key3
- Support array index
    - arrKey[10]
    - arrKey[0][2]
- It can throw NumberFormatException, IndexOutOfBoundsException
### public static String getValue(String jsonStr, String key)
- get String value of key from Json String
### public static int getValueAsInteger(String jsonStr, String key)
- get int value of key from Json String
### public static int getValueAsInteger(JsonObject jsonObj, String key)
- get int value of key from JsonObject
### public static long getValueAsLong(String jsonStr, String key)
- get long value of key from Json String
### public static long getValueAsLong(JsonObject jsonObj, String key)
- get long value of key from JsonObject
### public static double getValueAsDouble(JsonObject jsonObj, String key)
- get double value of key from JsonObject
### public static double getValueAsDouble(String jsonStr, String key)
- get double value of key from Json String
### public static float getValueAsFloat(JsonObject jsonObj, String key)
- get float value of key from JsonObject
### public static float getValueAsFloat(String jsonStr, String key)
- get float value of key from Json String
### public static boolean getValueAsBoolean(String jsonStr, String key)
- get boolean value of key from Json String
### public static boolean getValueAsBoolean(JsonObject jsonObj, String key)
- get boolean value of key from JsonObject
### public static boolean contain(String jsonStr, String key)
- check the key is in the Json String
### public static boolean contain(JsonObject jsonObj, String key)
- check the key is in the JsonObject
