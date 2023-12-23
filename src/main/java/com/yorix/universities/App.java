package com.yorix.universities;

import com.yorix.universities.model.Student;
import com.yorix.universities.model.University;
import com.yorix.universities.service.UniversityReader;

import java.util.Collection;

public class App {
    private static final String FILENAME = "universityInfo.xlsx";

    public static void main(String[] args) {
        Collection<University> universities = UniversityReader.readUniversities(FILENAME);
        Collection<Student> students = UniversityReader.readStudents(FILENAME);

        universities.forEach(System.out::println);
        students.forEach(System.out::println);
    }
}
