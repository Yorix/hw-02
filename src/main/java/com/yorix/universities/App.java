package com.yorix.universities;

import com.yorix.universities.util.comparator.student.StudentComparator;
import com.yorix.universities.util.comparator.university.UniversityComparator;
import com.yorix.universities.enums.StudentComparatorType;
import com.yorix.universities.enums.UniversityComparatorType;
import com.yorix.universities.model.Student;
import com.yorix.universities.model.University;
import com.yorix.universities.util.ComparatorUtil;
import com.yorix.universities.util.XlsReader;

import java.util.Collection;
import java.util.stream.Stream;

public class App {
    private static final String FILENAME = "universityInfo.xlsx";

    public static void main(String[] args) {
        UniversityComparator uYearOfFoundationComp =
                ComparatorUtil.getUniversityComparator(UniversityComparatorType.YEAR_OF_FOUNDATION);
        StudentComparator sAvgScoreComp =
                ComparatorUtil.getStudentsComparator(StudentComparatorType.AVG_EXAM_SCORE);

        Collection<University> universities = XlsReader.readUniversities(FILENAME);
        Collection<Student> students = XlsReader.readStudents(FILENAME);

        universities.stream()
                .sorted(uYearOfFoundationComp)
                .forEach(System.out::println);

        Stream.generate(() -> "=").limit(44).forEach(System.out::print);
        System.out.println();

        students.stream()
                .sorted(sAvgScoreComp)
                .forEach(System.out::println);
    }
}
