package ua.com.university.entity;

import javax.persistence.*;

@Entity
@Table(name = "lector")
public class Lector implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String SurName;
    private Long rankId;

    public Lector() {
    }

    public Lector(String name, String surName, Long rankId) {
        this.name = name;
        SurName = surName;
        this.rankId = rankId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return SurName;
    }

    public void setSurName(String surName) {
        SurName = surName;
    }

    public Long getRankId() {
        return rankId;
    }

    public void setRankId(Long rankId) {
        this.rankId = rankId;
    }

    @Override
    public String toString() {
        return "Lector{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", SurName='" + SurName + '\'' +
                ", rankId=" + rankId +
                '}';
    }
}
