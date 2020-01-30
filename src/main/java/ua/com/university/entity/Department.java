package ua.com.university.entity;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class Department implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long head;

    public Department() {
    }

    public Department(String name, Long head) {
        this.name = name;
        this.head = head;
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

    public Long getHead() {
        return head;
    }

    public void setHead(Long head) {
        this.head = head;
    }
}
