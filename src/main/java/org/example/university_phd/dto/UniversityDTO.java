package org.example.university_phd.dto;

import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

public class UniversityDTO {

    private String id;
    private String name;
    private String type;
    private String[] departments;
    private int buildingNumber;
    private int numberOfStudents;
    private String phoneNumber;

    public UniversityDTO() {}

    public UniversityDTO(String id, String name, String type, String[] departments, int buildingNumber, int numberOfStudents, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.departments = departments;
        this.buildingNumber = buildingNumber;
        this.numberOfStudents = numberOfStudents;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getDepartments() {
        return departments;
    }

    public void setDepartments(String[] departments) {
        this.departments = departments;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
