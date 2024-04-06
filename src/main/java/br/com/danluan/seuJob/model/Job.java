package br.com.danluan.seuJob.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    private Company company;

    @Column(nullable = false, length = 500)
    private String title;

    @Column(nullable = false, length = 500)
    private String description;

    @Column(nullable = false, length = 500)
    private String location;

    @Column(nullable = false, length = 500)
    private String contractType;

    @Column(nullable = false)
    private Float salary;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "publication_date")
    private Date publicationDate;


    public Job(String title, String description, String location, String contractType, Float salary, Date publicationDate) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.contractType = contractType;
        this.salary = salary;
        this.publicationDate = publicationDate;
    }

    public Job() {

    }
}
