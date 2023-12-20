package com.reactive.ReactiveDemo.modal;

import lombok.*;
import org.springframework.data.annotation.Id;


@ToString
public class User {
    @Id
    private int id;

    private String name;

    private String job_description;

    private boolean full_time_employee;

    public User(String name, String job_description, boolean full_time_employee) {
        this.id = id;
        this.name = name;
        this.job_description = job_description;
        this.full_time_employee = full_time_employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob_description() {
        return job_description;
    }

    public void setJob_description(String job_description) {
        this.job_description = job_description;
    }

    public boolean isFull_time_employee() {
        return full_time_employee;
    }

    public void setFull_time_employee(boolean full_time_employee) {
        this.full_time_employee = full_time_employee;
    }
}
