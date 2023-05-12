package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cursos") // This tells Hibernate to make a table out of this class
public class Curso  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String curso;
    private String tema;

    private boolean ok;


}
