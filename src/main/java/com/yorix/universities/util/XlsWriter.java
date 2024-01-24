package com.yorix.universities.util;

import com.yorix.universities.model.Statistics;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class XlsWriter {

    private XlsWriter() {
    }

    public static void writeStatistics(List<Statistics> statisticsList, String path) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Статистика");

        Font font = workbook.createFont();
        font.setFontHeightInPoints((short) 12);
        font.setBold(true);
        font.setColor(IndexedColors.INDIGO.index);

        CellStyle style = workbook.createCellStyle();
        style.setFont(font);

        Row head = sheet.createRow(0);

        Cell head0 = head.createCell(0);
        head0.setCellStyle(style);
        head0.setCellValue("Профиль обучения");
        Cell head1 = head.createCell(1);
        head1.setCellStyle(style);
        head1.setCellValue("Средний балл");
        Cell head2 = head.createCell(2);
        head2.setCellStyle(style);
        head2.setCellValue("Количество студентов");
        Cell head3 = head.createCell(3);
        head3.setCellStyle(style);
        head3.setCellValue("Количество университетов");
        Cell head4 = head.createCell(4);
        head4.setCellStyle(style);
        head4.setCellValue("Названия университетов");

        for (int i = 0, size = statisticsList.size(); i < size; i++) {
            Row row = sheet.createRow(i + 1);
            Statistics statistics = statisticsList.get(i);

            row.createCell(0).setCellValue(statistics.getProfile().getProfileName());
            row.createCell(1).setCellValue(statistics.getAvgExamScore());
            row.createCell(2).setCellValue(statistics.getStudentsNumByProfile());
            row.createCell(3).setCellValue(statistics.getUniversitiesNumByProfile());
            row.createCell(4).setCellValue(String.join("\n", statistics.getUniversityNames()));
        }

        sheet.setAutobreaks(true);
        for (int i = 0; i < 5; i++) sheet.autoSizeColumn(i);

        try (FileOutputStream out = new FileOutputStream(path)) {
            workbook.write(out);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
