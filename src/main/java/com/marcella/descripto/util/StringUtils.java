package com.marcella.descripto.util;

import java.util.Objects;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public final class StringUtils {

    private static Gson gson;

    private StringUtils() {

    }
    //ENTENDI NADA, NÃO SEI NEM PARA QUE SERVE

    public static String toJson(Object obj) {
        if (Objects.isNull(gson)) {
            gson = new GsonBuilder().setPrettyPrinting().create();
        }
        return gson.toJson(obj);
    }
}
