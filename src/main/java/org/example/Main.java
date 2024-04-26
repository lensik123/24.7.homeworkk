package org.example;

import java.util.List;

public class Main {

  public static void main(String[] args) {

    List<Student> studentList = ExcelDataReader.readStudents();
    List<University> universityList = ExcelDataReader.readUniversities();

    for (Student student : studentList){
      System.out.println(student);
    }
    for (University university : universityList){
      System.out.println(university);
    }


  }
}
