package com.xmedia.springstart.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "employee_experience")
public class EmployeeExperience {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public EmployeeExperience() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "skills_id")
    private Skill skill;
}
