package com.yorix.universities;

import com.yorix.universities.comparator.student.StudentComparator;
import com.yorix.universities.comparator.university.UniversityComparator;
import com.yorix.universities.enums.StudentComparatorType;
import com.yorix.universities.enums.UniversityComparatorType;
import com.yorix.universities.model.Statistics;
import com.yorix.universities.model.Student;
import com.yorix.universities.model.University;
import com.yorix.universities.util.*;

import java.util.List;
import java.util.stream.Stream;

public class App {
    private static final String INFO = "src/main/resources/universityInfo.xlsx";
    private static final String STATISTICS = "src/main/resources/statistics.xlsx";

    public static void main(String[] args) {
        UniversityComparator uYearOfFoundationComp =
                ComparatorUtil.getUniversityComparator(UniversityComparatorType.YEAR_OF_FOUNDATION);
        StudentComparator sAvgScoreComp =
                ComparatorUtil.getStudentsComparator(StudentComparatorType.AVG_EXAM_SCORE);

        List<University> universities = XlsReader.readUniversities(INFO);
        List<Student> students = XlsReader.readStudents(INFO);

        universities.sort(uYearOfFoundationComp);
        universities.forEach(System.out::println);

        delimiter();

        students.sort(sAvgScoreComp);
        students.forEach(System.out::println);

        delimiter();

        String universitiesJson = JsonUtil.universityCollectionToJson(universities);
        String studentsJson = JsonUtil.studentCollectionToJson(students);

        List<University> universitiesFromJson = JsonUtil.universityCollectionFromJson(universitiesJson);
        List<Student> studentsFromJson = JsonUtil.studentCollectionFromJson(studentsJson);

        System.out.println(universities.size() == universitiesFromJson.size());
        System.out.println(students.size() == studentsFromJson.size());

        delimiter();

        universities.stream()
                .map(JsonUtil::universityToJson)
                .peek(System.out::println)
                .map(JsonUtil::universityFromJson)
                .forEach(System.out::println);

        delimiter();

        students.stream()
                .map(JsonUtil::studentToJson)
                .peek(System.out::println)
                .map(JsonUtil::studentFromJson)
                .forEach(System.out::println);

        delimiter();

        List<Statistics> statisticsList = StatisticsUtil.getStatistics(universities, students);
        XlsWriter.writeStatistics(statisticsList, STATISTICS);
    }

    private static void delimiter() {
        Stream.generate(() -> "-").limit(44).forEach(System.out::print);
        System.out.println();
    }
}
