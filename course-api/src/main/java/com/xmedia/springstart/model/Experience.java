package com.xmedia.springstart.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "experience")
public class Experience {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "start")
    private Date start;

    @Column(name = "now")
    private Date now;

    @Column(name = "end")
    private Date end;

    public Experience() {

    }

    public Experience(Date start, Date now, Date end, String skill) {
        this.start = start;
        this.now = now;
        this.end = end;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    @ManyToMany(mappedBy = "experiences")
    private Collection<Employee> employees;

}
