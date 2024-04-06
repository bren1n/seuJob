package br.com.danluan.seuJob.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_company")
public class Application {

    // TODO: Implement the Application entity

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id")
    private Job job;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
