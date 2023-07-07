package com.zn.portfolio.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "skills")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    @Override
    public String toString(){
        return name;
    }
    @ManyToOne
    @JoinColumn(name="project_id")
    @JsonBackReference
    @Setter
    private Project project;
}
