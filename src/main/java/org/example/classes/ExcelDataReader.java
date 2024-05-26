package org.example.classes;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReader {

  static String path = "C:\\Users\\LenseL\\IdeaProjects\\24.7.homeworkk\\src\\main\\resources\\universityInfo.xlsx";

  private ExcelDataReader() {
  }

  public static List<Student> readStudents() {
    List<Student> studentList = new ArrayList<>();

    try (XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(path))) {
      XSSFSheet sheet = wb.getSheet("Студенты");

      Iterator<Row> iterator2 = sheet.iterator();
      iterator2.next(); // Skip header row

      while (iterator2.hasNext()) {
        Row row = iterator2.next();

        // Get University ID
        Cell cell = row.getCell(0);
        String universityID = cell != null ? cell.getStringCellValue() : "";

        // Get Full Name
        cell = row.getCell(1);
        String fullName = cell != null ? cell.getStringCellValue() : "";

        // Get Current Course Number
        cell = row.getCell(2);
        int currentCourseNumber = cell != null ? (int) cell.getNumericCellValue() : 0;

        // Get Average Exam Score
        cell = row.getCell(3);
        float avgExamScore = cell != null ? (float) cell.getNumericCellValue() : 0;

        studentList.add(new Student(fullName, universityID, currentCourseNumber, avgExamScore));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return studentList;
  }

  public static List<University> readuniversityCount() {
    List<University> universityCount = new ArrayList<>();

    try (XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(path))) {
      XSSFSheet sheet = wb.getSheet("Университеты");

      Iterator<Row> iterator = sheet.iterator();
      iterator.next();

      while (iterator.hasNext()) {
        Row row = iterator.next();
        //id университета
        Cell getCellValue = row.getCell(0);
        String universityID = getCellValue.getStringCellValue();
        //Полное наименование университета
        getCellValue = row.getCell(1);
        String fullName = getCellValue.getStringCellValue();
        //Аббревиатура
        getCellValue = row.getCell(2);
        String shortName = getCellValue.getStringCellValue();
        //Средний балл
        getCellValue = row.getCell(3);
        int yearOfFoundation = (int) getCellValue.getNumericCellValue();
        //Профиль обучения
        getCellValue = row.getCell(4);
        String mainProfile = getCellValue.getStringCellValue();

        universityCount.add(new University().builder()
            .id(universityID)
            .fullName(fullName)
            .shortName(shortName)
            .yearOfFoundation(yearOfFoundation)
            .mainProfile(University.StudyProfile.valueOf(mainProfile))
            .build());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return universityCount;
  }
}
