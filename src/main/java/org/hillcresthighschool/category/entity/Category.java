package org.hillcresthighschool.category.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hillcresthighschool.questions.entity.Question;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="category")
public class Category {

    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="archived")
    private boolean archived;

    @Column(name="school_year")
    private Integer schoolYear;

    @ManyToMany(mappedBy = "categories")
    private Set<Question> questions;

}
