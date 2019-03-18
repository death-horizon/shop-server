package com.death.horizon.shopserver.util;

import com.google.gson.Gson;
import lombok.NonNull;

/**
 * @author dayday
 */
public class JsonUtils {

    private JsonUtils() {
    }

    public static <T> String toJsonString(@NonNull final T object) {
        Gson gson = new Gson();
        return gson.toJson(object);
    }
}
