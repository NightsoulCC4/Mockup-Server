package com.server.mockup.Utility;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Utility {
    static{

    }
    /* public static String StringToBytesToGson(String data){
        // Convert String to Byte array
        String str = data;
        byte[] byteArray = str.getBytes();

    } */
    public static List<Map<String, Object>> StringToMap(String data) {
        // Create a Gson instance
        Gson gson = new Gson();

        // Define the type for the Map
        Type type = new TypeToken<List<Map<String, Object>>>() {}.getType();

        // Convert the JSON string to a Map
        List<Map<String, Object>> resultMap = gson.fromJson(data, type);

        return resultMap;
    }
}
