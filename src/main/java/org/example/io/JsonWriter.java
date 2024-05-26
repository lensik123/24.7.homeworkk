package org.example.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;
import org.example.model.XmlStructure;
import org.example.util.JsonUtil;

public class JsonWriter {

  private static final Logger logger = Logger.getLogger(XlsWriter.class.getName());

  public static void jsonWrite(XmlStructure xmlStructure) {

    logger.info("Сериализация структуры в json");

    String studentsJson = JsonUtil.serializeListToJson(xmlStructure.getStudentList());
    String universitiesJson = JsonUtil.serializeListToJson(xmlStructure.getUniversityList());
    String statisticsJson = JsonUtil.serializeListToJson(xmlStructure.getStatisticsList());

    File directory = new File("S:\\Java\\jsonFiles");
    if (!directory.exists()) {
      directory.mkdir();
    }

    LocalDateTime localDateTime = LocalDateTime.now();
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
    String fileName = dateTimeFormatter.format(localDateTime);
    File file = new File(directory, fileName + ".json");

    try (FileWriter fileWriter = new FileWriter(file)) {
      fileWriter.write(studentsJson);
      fileWriter.write(universitiesJson);
      fileWriter.write(statisticsJson);
    } catch (IOException e) {
      logger.severe("Error writing json file" + e.getMessage());
    }
    logger.fine("Сериализация структуры в json прошла успешно");

  }
}
