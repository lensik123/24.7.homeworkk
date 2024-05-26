package org.example.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.model.Student;
import org.example.model.University;

public class ExcelDataReader {

  private static final Logger logger = Logger.getLogger(ExcelDataReader.class.getName());
  static String path = "C:\\Users\\LenseL\\IdeaProjects\\24.7.homeworkk\\src\\main\\resources\\universityInfo.xlsx";

  private ExcelDataReader() {
  }

  public static List<Student> readStudents() {
    List<Student> studentList = new ArrayList<>();

    logger.info("Начало чтения данных о студентах из файла Excel");
    try (XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(path))) {
      XSSFSheet sheet = wb.getSheet("Студенты");

      Iterator<Row> iterator2 = sheet.iterator();
      iterator2.next();

      while (iterator2.hasNext()) {
        Row row = iterator2.next();

        Cell cell = row.getCell(0);
        String universityID = cell != null ? cell.getStringCellValue() : "";

        cell = row.getCell(1);
        String fullName = cell != null ? cell.getStringCellValue() : "";

        cell = row.getCell(2);
        int currentCourseNumber = cell != null ? (int) cell.getNumericCellValue() : 0;

        cell = row.getCell(3);
        float avgExamScore = cell != null ? (float) cell.getNumericCellValue() : 0;

        studentList.add(new Student(fullName, universityID, currentCourseNumber, avgExamScore));
      }
    } catch (IOException e) {
      logger.severe("Ошибка при чтении файла Excel: " + e.getMessage());
    }

    logger.fine("Информация о студентах собрана из excel файла");
    return studentList;
  }

  public static List<University> readuniversityCount() {
    List<University> universityCount = new ArrayList<>();

    logger.info("Начало чтения данных об университетах из файла Excel");
    try (XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(path))) {
      XSSFSheet sheet = wb.getSheet("Университеты");

      Iterator<Row> iterator = sheet.iterator();
      iterator.next();

      while (iterator.hasNext()) {
        Row row = iterator.next();
        Cell getCellValue = row.getCell(0);
        String universityID = getCellValue.getStringCellValue();

        getCellValue = row.getCell(1);
        String fullName = getCellValue.getStringCellValue();

        getCellValue = row.getCell(2);
        String shortName = getCellValue.getStringCellValue();

        getCellValue = row.getCell(3);
        int yearOfFoundation = (int) getCellValue.getNumericCellValue();

        getCellValue = row.getCell(4);
        String mainProfile = getCellValue.getStringCellValue();

        new University();
        universityCount.add(University.builder()
            .id(universityID)
            .fullName(fullName)
            .shortName(shortName)
            .yearOfFoundation(yearOfFoundation)
            .mainProfile(University.StudyProfile.valueOf(mainProfile))
            .build());
      }
    } catch (IOException e) {
      logger.severe("Ошибка при чтении файла Excel: " + e.getMessage());
    }
    logger.fine("Информация о университетах собрана из excel файла");
    return universityCount;
  }
}
