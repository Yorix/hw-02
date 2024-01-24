package com.yorix.universities.util;

import com.yorix.universities.comparator.student.*;
import com.yorix.universities.comparator.university.*;
import com.yorix.universities.enums.StudentComparatorType;
import com.yorix.universities.enums.UniversityComparatorType;

public class ComparatorUtil {

    private ComparatorUtil() {
    }

    public static UniversityComparator getUniversityComparator(UniversityComparatorType comparatorType) {
        return switch (comparatorType) {
            case FULL_NAME -> new UniversityFullNameComparator();
            case SHORT_NAME -> new UniversityShortNameComparator();
            case YEAR_OF_FOUNDATION -> new UniversityYearOfFoundationComparator();
            case MAIN_PROFILE -> new UniversityMainProfileComparator();
            default -> new UniversityIdComparator();
        };
    }

    public static StudentComparator getStudentsComparator(StudentComparatorType comparatorType) {
        return switch (comparatorType) {
            case UNIVERSITY_ID -> new StudentUniversityIdComparator();
            case CURRENT_COURSE_NUMBER -> new StudentCurrentCourseComparator();
            case AVG_EXAM_SCORE -> new StudentAvgExamScoreComparator();
            default -> new StudentFullNameComparator();
        };
    }
}
