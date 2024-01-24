package com.yorix.universities.comparator.student;

import com.yorix.universities.model.Student;

public class StudentCurrentCourseComparator implements StudentComparator {
    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getCurrentCourseNumber(), o2.getCurrentCourseNumber());
    }
}
