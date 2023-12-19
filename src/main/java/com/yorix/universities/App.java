package com.yorix.universities;

import com.yorix.universities.model.Student;
import com.yorix.universities.model.StudyProfile;
import com.yorix.universities.model.University;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        University u1 = new University()
                .setId("1")
                .setFullName("Крымский Федеральный Университет им. В. И. Вернадского")
                .setShortName("КФУ")
                .setMainProfile(StudyProfile.CHEMISTRY)
                .setYearOfFoundation(2014);

        Set<Student> students = new HashSet<>();
        for (int i = 0; i < 16; i++) {
            students.add(new Student()
                    .setFullName("Name" + i + " Surname" + i)
                    .setUniversityId("1")
                    .setCurrentCourseNumber(new Random().nextInt(1, 6))
                    .setAvgExamScore(new Random().nextFloat(2, 5))
            );
        }

        System.out.println(u1);
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
