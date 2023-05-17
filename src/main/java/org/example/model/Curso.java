package org.example.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="CURSOS")
public class Curso {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String curso;
    private String tema;

    private boolean ok;


}
