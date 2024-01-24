package com.yorix.universities.util;

import com.yorix.universities.enums.StudyProfile;
import com.yorix.universities.model.Statistics;
import com.yorix.universities.model.Student;
import com.yorix.universities.model.University;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StatisticsUtil {

    public static List<Statistics> getStatistics(List<University> universities, List<Student> students) {
        Set<StudyProfile> profiles = universities.stream()
                .map(University::getMainProfile)
                .collect(Collectors.toSet());

        List<Statistics> statisticsList = new ArrayList<>(profiles.size());
        profiles.forEach(profile -> statisticsList.add(new Statistics().setProfile(profile)));

        statisticsList
                .forEach(statistics -> statistics
                        .setAvgExamScore(
                                universities.stream()
                                        .filter(university -> university.getMainProfile() == statistics.getProfile())
                                        .map(university -> students.stream()
                                                .filter(student -> student.getUniversityId().equals(university.getId()))
                                                .map(Student::getAvgExamScore)
                                                .reduce(Float::sum)
                                                .map(aFloat -> BigDecimal.valueOf(aFloat).setScale(2, RoundingMode.CEILING).floatValue())
                                                .orElse(0f)
                                        )
                                        .reduce(Float::sum)
                                        .map(aFloat -> BigDecimal.valueOf(aFloat).setScale(2, RoundingMode.CEILING).floatValue())
                                        .orElse(0f)
                        )
                        .setStudentsNumByProfile(
                                universities.stream()
                                        .filter(university -> university.getMainProfile() == statistics.getProfile())
                                        .map(university -> students.stream()
                                                .filter(student -> student.getUniversityId().equals(university.getId()))
                                                .count()
                                        )
                                        .map(Long::intValue)
                                        .reduce(Integer::sum)
                                        .orElse(0)
                        )
                        .setUniversitiesNumByProfile(
                                (int) universities.stream()
                                        .filter(university -> university.getMainProfile() == statistics.getProfile())
                                        .count()
                        )
                        .setUniversityNames(
                                universities.stream()
                                        .filter(university -> university.getMainProfile() == statistics.getProfile())
                                        .map(University::getFullName)
                                        .toList()
                        )
                );

        return statisticsList;
    }
}
