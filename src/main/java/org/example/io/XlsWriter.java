package org.example.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.model.Statistics;

@SuppressWarnings("ALL")
public class XlsWriter {

  private static final Logger logger = Logger.getLogger(XlsWriter.class.getName());

  public static void xslFileWrite(List<Statistics> statisticsList, String path) throws IOException {

    Workbook wb = new XSSFWorkbook();
    Sheet sheet = wb.createSheet("Статистика");
    Row headerRow = sheet.createRow(0);

    String[] columnNames = {"Профиль обучения", "Средний балл за экзамен",
        "Количество студентов по профилю", "Количество университетов по профилю",
        "Названия университетов"};

    CellStyle headerStyle = wb.createCellStyle();
    Font font = wb.createFont();
    font.setBold(true);
    font.setFontHeightInPoints((short) 14);
    headerStyle.setFont(font);

    for (int i = 0; i < columnNames.length; i++) {
      Cell cell = headerRow.createCell(i);
      cell.setCellValue(columnNames[i]);
      cell.setCellStyle(headerStyle);
    }

    int rowNumber = 0;
    for (Statistics statistics : statisticsList) {
      Row dataRow = sheet.createRow(++rowNumber);

      Cell profileCell = dataRow.createCell(0);
      profileCell.setCellValue(statistics.getProfileName().name());

      Cell avgScoreCell = dataRow.createCell(1);
      avgScoreCell.setCellValue(statistics.getAvgExamScore());

      Cell numberOfStudentsCell = dataRow.createCell(2);
      numberOfStudentsCell.setCellValue(statistics.getNumberOfStudents());

      Cell numberOfUniversitiesCell = dataRow.createCell(3);
      numberOfUniversitiesCell.setCellValue(statistics.getUniversityCount());

      Cell universitiesCell = dataRow.createCell(4);
      universitiesCell.setCellValue(statistics.getUniversityNames());
    }

    logger.info("Начало записи статистики в excel файл");

    try (FileOutputStream fos = new FileOutputStream(path)) {
      wb.write(fos);
    } catch (IOException e) {
      logger.severe(
          "Произошла ошибка при попытке записать статистику в excel файл: " + e.getMessage());
    } finally {
      wb.close();
    }
    logger.fine("Запись статистики в excel файл прошла успешна");
  }
}
