package org.example.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import org.example.classes.Student;
import org.example.classes.University;

public class JsonUtil {

  static  Gson gson = new Gson();

  private JsonUtil() {

  }


  public static String serializeStudentToJson(Student student) {
    return gson.toJson(student);
  }

  public static String serializeUniversityToJson(University university) {
    return gson.toJson(university);
  }

  public static String serializeStudentListToJson(List<Student> list) {
    return gson.toJson(list);
  }

  public static String serializeUniversityListToJson(List<University> list) {
    return gson.toJson(list);
  }

  public static Student deserializeStudentFromJson(String json) {
    return gson.fromJson(json, Student.class);
  }

  public static University deserializeUniversityFromJson(String json) {
    return gson.fromJson(json, University.class);
  }

  public static List<Student> deserializeStudentListFromJson(String json) {
    return gson.fromJson(json, new TypeToken<List<Student>>(){});
  }

  public static List<University> deserializeUniversityListFromJson(String json) {
    return gson.fromJson(json, new TypeToken<List<University>>() {});
  }

}
