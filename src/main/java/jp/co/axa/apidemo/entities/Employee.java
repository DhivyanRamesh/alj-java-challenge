package jp.co.axa.apidemo.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name="EMPLOYEE")
public class Employee {

    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="EMPLOYEE_NAME")
    private String name;

    @Column(name="EMPLOYEE_SALARY")
    private Integer salary;

    @Column(name="DEPARTMENT")
    private String department;
    
    @Column(name="CREATION_DATE")
    private Date createdDate;
    
    @Column(name="CREATED_BY")
    private String createdBy;
    
    @Column(name="UPDATED_DATE")
    private Date updatedDate;
    
    @Column(name="UPDATION_BY")
    private String updatedBy;

}
