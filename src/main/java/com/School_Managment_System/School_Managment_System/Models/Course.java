package com.School_Managment_System.School_Managment_System.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Data
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String description;
    String courseCode;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private List<StudentCourse> studentCourses;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private List<Teacher> teachers;

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    ClassRoom classRoom;
}
