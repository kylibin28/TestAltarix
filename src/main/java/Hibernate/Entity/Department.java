package Hibernate.Entity;

import org.springframework.hateoas.Identifiable;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Макс on 07.10.2017.
 */
@Entity
@Table(name = "department")
public class Department {

        @Id
        @GeneratedValue
        private Integer id_department;

        @Basic
        @Column(name = "name", length = 50, nullable = false)
        private String name;

        @Basic
        @Column(name = "creation_date", nullable = false)
        private Date creation_date;

        @OneToMany(mappedBy = "id_department")
        private Set<Employee> tasks = new HashSet<Employee>();

    }
