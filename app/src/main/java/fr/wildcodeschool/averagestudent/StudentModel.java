package fr.wildcodeschool.averagestudent;

import java.util.ArrayList;

public class StudentModel {

    private String name;
    private int note1;
    private int note2;
    private int note3;
    private double average;
    private ArrayList<ClassModel> classes;

    // constructeur vide pour Firebase
    public StudentModel() {}

    public StudentModel(String name, int note1, int note2, int note3) {
        this.name = name;
        this.note1 = note1;
        this.note2 = note2;
        this.note3 = note3;
        this.average = calculateAverage();
    }

    private double calculateAverage() {
        int total = this.note1 + this.note2 + this.note3;
        return total / 3.0;
    }

    // getters obligatoires dans Firebase
    public String getName() {
        return name;
    }

    public int getNote1() {
        return note1;
    }

    public int getNote2() {
        return note2;
    }

    public int getNote3() {
        return note3;
    }

    public double getAverage() {
        return average;
    }

    /*
    public ArrayList<ClassModel> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<ClassModel> classes) {
        this.classes = classes;
    }
    */
}
