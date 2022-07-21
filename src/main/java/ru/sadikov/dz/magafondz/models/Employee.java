package ru.sadikov.dz.magafondz.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
    @Id

    @Column(name = "name")
    private  String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "job_title")
    private String jobTitle;

    public Employee() {
    }

    public Employee(String name, String surname, String jobTitle) {
        this.name = name;
        this.surname = surname;
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", job_title='" + jobTitle + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}