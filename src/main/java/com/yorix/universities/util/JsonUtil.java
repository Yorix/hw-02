package com.yorix.universities.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.yorix.universities.model.Student;
import com.yorix.universities.model.University;

import java.util.Collection;
import java.util.List;

public class JsonUtil {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private JsonUtil() {
    }

    public static String universityToJson(University university) {
        return gson.toJson(university);
    }

    public static String studentToJson(Student student) {
        return gson.toJson(student);
    }

    public static String universityCollectionToJson(Collection<University> universities) {
        return gson.toJson(universities);
    }

    public static String studentCollectionToJson(Collection<Student> students) {
        return gson.toJson(students);
    }

    public static University universityFromJson(String json) {
        return gson.fromJson(json, University.class);
    }

    public static Student studentFromJson(String json) {
        return gson.fromJson(json, Student.class);
    }

    public static List<University> universityCollectionFromJson(String json) {
        return gson.fromJson(json, new TypeToken<List<University>>() {}.getType());
    }

    public static List<Student> studentCollectionFromJson(String json) {
        return gson.fromJson(json, new TypeToken<List<Student>>() {}.getType());
    }
}
