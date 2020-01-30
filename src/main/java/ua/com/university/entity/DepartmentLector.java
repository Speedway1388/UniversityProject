package ua.com.university.entity;

import javax.persistence.*;

@Entity
@Table
public class DepartmentLector implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long departmentId;
    private Long lectorId;

    public DepartmentLector() {
    }

    public DepartmentLector(Long departmentId, Long lectorId) {
        this.departmentId = departmentId;
        this.lectorId = lectorId;
    }

    public Long getId() {
        return id;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getLectorId() {
        return lectorId;
    }

    public void setLectorId(Long lectorId) {
        this.lectorId = lectorId;
    }
}
