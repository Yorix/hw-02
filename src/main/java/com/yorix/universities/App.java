package com.yorix.universities;

import com.yorix.universities.model.Student;
import com.yorix.universities.model.University;
import com.yorix.universities.utils.XlsReader;

import java.util.Collection;

public class App {
    private static final String FILENAME = "universityInfo.xlsx";

    public static void main(String[] args) {
        Collection<University> universities = XlsReader.readUniversities(FILENAME);
        Collection<Student> students = XlsReader.readStudents(FILENAME);

        universities.forEach(System.out::println);
        students.forEach(System.out::println);
    }
}
