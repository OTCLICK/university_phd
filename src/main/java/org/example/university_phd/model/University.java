package org.example.university_phd.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Arrays;
import java.util.List;

@Document(collection = "universities")
public class University {

    @Id
    private String id;

    @Field(name = "name")
    @Indexed(unique = false, sparse = true, direction = IndexDirection.ASCENDING, background = false)
    private String name;
    private String type;
    private String[] departments;
    private int buildingNumber;
    private int numberOfStudents;
    private String phoneNumber;

    public University() {}

    public University(String name, String s, List<String> strings, int i, int i1, String s1) {
        this.name = name;
        this.type = s;
        this.departments = strings.toArray(new String[strings.size()]);
        this.buildingNumber = i;
        this.numberOfStudents = i1;
        this.phoneNumber = s1;
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

    @Override
    public String toString() {
        return "University{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", departments=" + Arrays.toString(departments) +
                ", buildingNumber=" + buildingNumber +
                ", numberOfStudents=" + numberOfStudents +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
