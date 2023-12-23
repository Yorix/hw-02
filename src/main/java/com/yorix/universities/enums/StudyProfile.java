package com.yorix.universities.enums;

public enum StudyProfile {
    MATHEMATICS("Математика"),
    PHYSICS("Физика"),
    CHEMISTRY("Химия"),
    BIOLOGY("Биология"),
    MEDICINE("Медицина"),
    ASTRONOMY("Астрономия"),
    GEOGRAPHY("География"),
    ENGINEERING("Инженерия"),
    ENERGY("Энергетика"),
    COMPUTER_SCIENCE("Информатика"),
    PHILOSOPHY("Философия"),
    JURISPRUDENCE("Юриспруденция"),
    LINGUISTICS("Лингвистика");

    private final String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }

    @Override
    public String toString() {
        return profileName;
    }
}
