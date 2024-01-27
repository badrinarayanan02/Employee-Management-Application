// Adding model class

package com.springbootproject.employeemanager.model;

import jakarta.persistence.*;
import org.hibernate.sql.results.graph.embeddable.EmbeddableLoadingLogger;

import java.io.Serializable;

@Entity // Making sure this class is mapped to any database that we had configured on class path
public class Employee implements Serializable {
    // Serializable - It helps to transform the java class into different types of streams
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // For generating primary key
    @Column(nullable = false,updatable = false) // Specifying column information for Id
    private Long id;
    private String name;
    private String email;
    private String jobTitle;
    private String phone;
    @Column(nullable = true)
    private String imageUrl;
    @Column(nullable = false,updatable = false)
    private String employeeCode;

    // Default Constructor
    public Employee() {}

    // Parameterized Constructor
    public Employee(String name, String email, String jobTitle, String phone, String imageUrl, String employeeCode) {
        this.name = name;
        this.email = email;
        this.jobTitle = jobTitle;
        this.phone = phone;
        this.imageUrl = imageUrl;
        this.employeeCode = employeeCode;
    }

    // Getter and Setter Methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    // Using toString method for display
    // Rather than displaying the location of the object it displays the information
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", phone='" + phone + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
