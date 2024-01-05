package com.yorix.universities.model;

import com.google.gson.annotations.SerializedName;

public class Student {
    @SerializedName("Full name")
    private String fullName;
    @SerializedName("University ID")
    private String universityId;
    @SerializedName("Current course number")
    private int currentCourseNumber;
    @SerializedName("Average exam score")
    private float avgExamScore;

    public Student() {
    }

    public Student(String fullName, String universityId, int currentCourseNumber, float avgExamScore) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
    }

    public Student setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public Student setUniversityId(String universityId) {
        this.universityId = universityId;
        return this;
    }

    public Student setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
        return this;
    }

    public Student setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("fullName='").append(fullName).append('\'');
        sb.append(", universityId='").append(universityId).append('\'');
        sb.append(", currentCourseNumber=").append(currentCourseNumber);
        sb.append(", avgExamScore=").append(avgExamScore);
        sb.append('}');
        return sb.toString();
    }
}
