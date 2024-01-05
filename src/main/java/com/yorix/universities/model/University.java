package com.yorix.universities.model;

import com.google.gson.annotations.SerializedName;
import com.yorix.universities.enums.StudyProfile;

public class University {
    @SerializedName("Identify")
    private String id;
    @SerializedName("Full name")
    private String fullName;
    @SerializedName("Short name")
    private String shortName;
    @SerializedName("Year of foundation")
    private int yearOfFoundation;
    @SerializedName("Main profile")
    private StudyProfile mainProfile;

    public University() {
    }

    public University(String id, String fullName, String shortName, int yearOfFoundation, StudyProfile mainProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }

    public University setId(String id) {
        this.id = id;
        return this;
    }

    public University setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public University setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public University setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
        return this;
    }

    public University setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("University{");
        sb.append("id='").append(id).append('\'');
        sb.append(", fullName='").append(fullName).append('\'');
        sb.append(", shortName='").append(shortName).append('\'');
        sb.append(", yearOfFoundation=").append(yearOfFoundation);
        sb.append(", mainProfile=").append(mainProfile);
        sb.append('}');
        return sb.toString();
    }
}
