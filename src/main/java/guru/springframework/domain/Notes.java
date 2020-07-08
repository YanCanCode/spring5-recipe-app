package guru.springframework.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Don't need cascade because Recipe owns Notes
    // If we delete notes we don't want it to delete the recipe
    @OneToOne
    private Recipe recipe;

    // Allows users to write more than 255 chars (JPA/Hibernate limit)
    @Lob
    private String recipeNotes;

}
