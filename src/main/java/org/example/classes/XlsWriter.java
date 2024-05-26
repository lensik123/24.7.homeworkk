package org.example.classes;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@SuppressWarnings("ALL")
public class XlsWriter {
    public static void xslFileWrite(List<Statistics> statisticsList, String path) throws IOException {

        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("Статистика");
        Row headerRow = sheet.createRow(0);

        String[] columnNames = {"Профиль обучения", "Средний балл за экзамен", "Количество студентов по профилю", "Количество университетов по профилю", "Названия университетов"};

        // Создаем стиль для заголовков
        CellStyle headerStyle = wb.createCellStyle();
        Font font = wb.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 14);
        headerStyle.setFont(font);

        // Применяем стильк заголовкам
        for (int i = 0; i < columnNames.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columnNames[i]);
            cell.setCellStyle(headerStyle);
        }

        // Заполняем данные
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

        // Сохраняем файл
        try (FileOutputStream fos = new FileOutputStream(path)) {
            wb.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            wb.close();
        }
    }
}
