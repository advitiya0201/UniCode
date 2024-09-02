package com.example.unicode.entity;


public class Student {
    public int bitsId;
    public String name;
    public int labNumber;
    public int systemNumber;

    public Student(int bitsId, int labNumber, String name, int systemNumber) {
        this.bitsId = bitsId;
        this.labNumber = labNumber;
        this.name = name;
        this.systemNumber = systemNumber;
    }
}
