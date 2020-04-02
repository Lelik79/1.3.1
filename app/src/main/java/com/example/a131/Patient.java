package com.example.a131;

public class Patient {
    String fio;
    int age;

    public Patient(String fio, int age) {
        this.fio = fio;
        this.age = age;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Пациент " + fio + " в возрасте " + age + " лет.";
    }
}
