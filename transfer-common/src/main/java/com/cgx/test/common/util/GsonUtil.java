package com.cgx.test.common.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {

    private final static Gson gson = new GsonBuilder().disableHtmlEscaping().serializeNulls().create();

    public static String toJson(Object object) {
        return gson.toJson(object);
    }

}
