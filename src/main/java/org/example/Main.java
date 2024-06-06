package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import lombok.EqualsAndHashCode;
import org.example.comparator.student.comparator.SortByAvgExamScore;
import org.example.comparator.university.comparator.SortById;
import org.example.io.ExcelDataReader;
import org.example.io.JaxbWriter;
import org.example.io.JsonWriter;
import org.example.model.Statistics;
import org.example.model.Student;
import org.example.model.University;
import org.example.model.XmlAndJsonStructure;
import org.example.util.StatisticsUtil;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Main {

  private static final Logger logger = Logger.getLogger(Main.class.getName());

  public static void main(String[] args) throws IOException {
    try (FileInputStream configFile = new FileInputStream(
        "C:\\Users\\LenseL\\IdeaProjects\\24.7.homeworkk\\src\\main\\resources\\logging.properties")) {
      LogManager.getLogManager().readConfiguration(configFile);
    } catch (IOException e) {
      logger.severe("failed to read config file");
    }
    logger.info("Программа запущена");

    List<Student> studentList = ExcelDataReader.readStudents();
    List<University> universityList = ExcelDataReader.readuniversityCount();
    List<Statistics> statisticsList = StatisticsUtil.computeStats(studentList, universityList);

    studentList.sort(new SortByAvgExamScore());
    universityList.sort(new SortById());

    XmlAndJsonStructure xmlAndJsonStructure = XmlAndJsonStructure.builder()
        .studentList(studentList)
        .universityList(universityList)
        .statisticsList(statisticsList)
        .build();

    try {
      JaxbWriter.jaxbWrite(xmlAndJsonStructure);
    } catch (JAXBException e) {
      System.out.println("Fail parsing to xml");
    }

    JsonWriter.jsonWrite(xmlAndJsonStructure);

    logger.fine("Программа завершена");

  }
}
