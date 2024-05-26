package org.example.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

public class JsonUtil {

  static Gson gson = new Gson();

  private JsonUtil() {

  }

  public static <T> String serializeToJson(T object) {
    return gson.toJson(object);
  }

  public static <T> T deserializeFromJson(String json, Class<T> clazz) {
    return gson.fromJson(json, clazz);
  }

  public static <T> String serializeListToJson(List<T> list) {
    Type listType = new TypeToken<List<T>>() {
    }.getType();
    return gson.toJson(list, listType);
  }

  public static <T> List<T> deserializeListFromJson(String json, Class<T> clazz) {
    Type listType = TypeToken.getParameterized(List.class, clazz).getType();
    return gson.fromJson(json, listType);
  }

}
