package com.yorix.universities;

import com.yorix.universities.enums.StudentComparatorType;
import com.yorix.universities.enums.UniversityComparatorType;
import com.yorix.universities.model.Student;
import com.yorix.universities.model.University;
import com.yorix.universities.util.ComparatorUtil;
import com.yorix.universities.util.JsonUtil;
import com.yorix.universities.util.XlsReader;
import com.yorix.universities.util.comparator.student.StudentComparator;
import com.yorix.universities.util.comparator.university.UniversityComparator;

import java.util.List;
import java.util.stream.Stream;

public class App {
    private static final String FILENAME = "universityInfo.xlsx";

    public static void main(String[] args) {
        UniversityComparator uYearOfFoundationComp =
                ComparatorUtil.getUniversityComparator(UniversityComparatorType.YEAR_OF_FOUNDATION);
        StudentComparator sAvgScoreComp =
                ComparatorUtil.getStudentsComparator(StudentComparatorType.AVG_EXAM_SCORE);

        List<University> universities = XlsReader.readUniversities(FILENAME);
        List<Student> students = XlsReader.readStudents(FILENAME);

        universities.stream()
                .sorted(uYearOfFoundationComp)
                .forEach(System.out::println);

        Stream.generate(() -> "=").limit(44).forEach(System.out::print);
        System.out.println();

        students.stream()
                .sorted(sAvgScoreComp)
                .forEach(System.out::println);

        Stream.generate(() -> "=").limit(44).forEach(System.out::print);
        System.out.println();

        String universitiesJson = JsonUtil.universityCollectionToJson(universities);
        String studentsJson = JsonUtil.studentCollectionToJson(students);

        List<University> universitiesFromJson = JsonUtil.universityCollectionFromJson(universitiesJson);
        List<Student> studentsFromJson = JsonUtil.studentCollectionFromJson(studentsJson);

        System.out.println(universities.size() == universitiesFromJson.size());
        System.out.println(students.size() == studentsFromJson.size());

        universities.stream()
                .map(JsonUtil::universityToJson)
                .peek(System.out::println)
                .map(JsonUtil::universityFromJson)
                .forEach(System.out::println);

        students.stream()
                .map(JsonUtil::studentToJson)
                .peek(System.out::println)
                .map(JsonUtil::studentFromJson)
                .forEach(System.out::println);
    }
}
