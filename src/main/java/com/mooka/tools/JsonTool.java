package com.mooka.tools;

import com.google.gson.Gson;

import java.util.Map;

public class JsonTool {
    public static String fromMapToJson(Map map) {
        return new Gson().toJson(map);
    }
}
