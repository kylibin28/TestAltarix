package Hibernate.Entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Макс on 07.10.2017.
 */
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue
    @Column(name = "id_employee")
    private Integer id_employee;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "surname", length = 50, nullable = false)
    private String surname;

    @Column(name = "patronymic", length = 50)
    private String patronymic;

    @Column(name = "sex", length = 10, nullable = false)
    private String sex;

    @Column(name = "birthday", nullable = false)
    private Date birthday;

    @Column(name = "admition_date", nullable = false)
    private Date admition_date;

    @Column(name = "dismissal_date")
    private Date dismissal_date;

    @Column(name = "post", length = 50, nullable = false)
    private String post;

    @Column(name = "salary", nullable = false)
    private Integer salary;

    @Column(name = "chief", nullable = false)
    private Boolean chief;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_department")
    private Department id_department;
}
