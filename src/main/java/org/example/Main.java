package org.example;

import java.util.List;
import org.example.Enum.EnumComparator;
import org.example.Enum.StudentComparatorEnum;
import org.example.Enum.UniversityComparatorEnum;
import org.example.classes.ExcelDataReader;
import org.example.classes.Student;
import org.example.classes.University;
import org.example.comparator.studentcomparator.StudentComparator;
import org.example.comparator.universitycomparator.UniversityComparator;
import org.example.util.JsonUtil;

public class Main {

  public static void main(String[] args) {

    List<Student> studentList = ExcelDataReader.readStudents();
    List<University> universityList = ExcelDataReader.readUniversities();

    StudentComparator sc = EnumComparator.getStudentComparator(StudentComparatorEnum.AVG_EXAM_SCORE);
    UniversityComparator uc = EnumComparator.getUniversityComparator(UniversityComparatorEnum.ID);

    studentList.stream()
        .map(JsonUtil::serializeStudentToJson)
        .peek(System.out::println)
        .map(JsonUtil::deserializeStudentFromJson)
        .forEach(System.out::println);

    System.out.println();

    universityList.stream()
        .map(JsonUtil::serializeUniversityToJson)
        .peek(System.out::println)
        .map(JsonUtil::deserializeUniversityFromJson)
        .forEach(System.out::println);


  }
}
