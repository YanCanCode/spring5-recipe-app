package guru.springframework.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;


@Data
@EqualsAndHashCode(exclude = {"recipe"})
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

    public Notes() {
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Notes;
    }

}
