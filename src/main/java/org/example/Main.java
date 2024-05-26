package org.example;

import java.io.IOException;
import java.util.List;

import org.example.classes.*;
import org.example.util.StatisticsUtil;

public class Main {

    public static void main(String[] args) throws IOException {

        List<Student> studentList = ExcelDataReader.readStudents();
        List<University> universityList = ExcelDataReader.readuniversityCount();
        List<Statistics> statisticsList = StatisticsUtil.computeStats(studentList, universityList);
        String path = "C:\\Users\\LenseL\\IdeaProjects\\24.7.homeworkk\\src\\main\\resources\\universityStatistics.xlsx";
        XlsWriter.xslFileWrite(statisticsList, path);

//
//    StudentComparator sc = EnumComparator.getStudentComparator(StudentComparatorEnum.AVG_EXAM_SCORE);
//    UniversityComparator uc = EnumComparator.getUniversityComparator(UniversityComparatorEnum.ID);
//
//    studentList.stream()
//        .map(JsonUtil::serializeStudentToJson)
//        .peek(System.out::println)
//        .map(JsonUtil::deserializeStudentFromJson)
//        .forEach(System.out::println);
//
//    System.out.println();
//
//    universityList.stream()
//        .map(JsonUtil::serializeUniversityToJson)
//        .peek(System.out::println)
//        .map(JsonUtil::deserializeUniversityFromJson)
//        .forEach(System.out::println);
    }
}
