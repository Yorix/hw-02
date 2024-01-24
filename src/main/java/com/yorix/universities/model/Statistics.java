package com.yorix.universities.model;

import com.yorix.universities.enums.StudyProfile;

import java.util.List;

public class Statistics {
    private StudyProfile profile;
    private float avgExamScore;
    private int studentsNumByProfile;
    private int universitiesNumByProfile;
    private List<String> universityNames;

    public Statistics() {
    }

    public Statistics(StudyProfile profile, float avgExamScore, int studentsNumByProfile, int universitiesNumByProfile, List<String> universityNames) {
        this.profile = profile;
        this.avgExamScore = avgExamScore;
        this.studentsNumByProfile = studentsNumByProfile;
        this.universitiesNumByProfile = universitiesNumByProfile;
        this.universityNames = universityNames;
    }

    public StudyProfile getProfile() {
        return profile;
    }

    public Statistics setProfile(StudyProfile profile) {
        this.profile = profile;
        return this;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public Statistics setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
        return this;
    }

    public int getStudentsNumByProfile() {
        return studentsNumByProfile;
    }

    public Statistics setStudentsNumByProfile(int studentsNumByProfile) {
        this.studentsNumByProfile = studentsNumByProfile;
        return this;
    }

    public int getUniversitiesNumByProfile() {
        return universitiesNumByProfile;
    }

    public Statistics setUniversitiesNumByProfile(int universitiesNumByProfile) {
        this.universitiesNumByProfile = universitiesNumByProfile;
        return this;
    }

    public List<String> getUniversityNames() {
        return universityNames;
    }

    public Statistics setUniversityNames(List<String> universityNames) {
        this.universityNames = universityNames;
        return this;
    }
}
