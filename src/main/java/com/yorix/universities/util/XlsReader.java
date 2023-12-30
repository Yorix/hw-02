package com.yorix.universities.util;

import com.yorix.universities.enums.StudyProfile;
import com.yorix.universities.model.Student;
import com.yorix.universities.model.University;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XlsReader {

    private XlsReader() {
    }

    public static List<Student> readStudents(String filename) {
        List<Student> students = new ArrayList<>();
        XSSFWorkbook workbook = getDocument(filename);
        XSSFSheet studentsSheet = workbook.getSheet("Студенты");

        Iterator<Row> iterator = studentsSheet.iterator();
        iterator.next();

        while (iterator.hasNext()) {
            Row row = iterator.next();
            Student student = new Student()
                    .setUniversityId(row.getCell(0).getStringCellValue())
                    .setFullName(row.getCell(1).getStringCellValue())
                    .setCurrentCourseNumber(((int) row.getCell(2).getNumericCellValue()))
                    .setAvgExamScore((float) row.getCell(3).getNumericCellValue());
            students.add(student);
        }
        return students;
    }

    public static List<University> readUniversities(String filename) {
        List<University> universities = new ArrayList<>();
        XSSFWorkbook workbook = getDocument(filename);
        XSSFSheet universitiesSheet = workbook.getSheet("Университеты");

        Iterator<Row> iterator = universitiesSheet.iterator();
        iterator.next();

        while (iterator.hasNext()) {
            Row row = iterator.next();
            University university = new University()
                    .setId(row.getCell(0).getStringCellValue())
                    .setFullName(row.getCell(1).getStringCellValue())
                    .setShortName(row.getCell(2).getStringCellValue())
                    .setYearOfFoundation((int) row.getCell(3).getNumericCellValue())
                    .setMainProfile(StudyProfile.valueOf(row.getCell(4).getStringCellValue()));
            universities.add(university);
        }
        return universities;
    }

    private static XSSFWorkbook getDocument(String filename) {
        try {
            InputStream input = ClassLoader.getSystemClassLoader().getResourceAsStream(filename);
            assert input != null;
            return new XSSFWorkbook(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
