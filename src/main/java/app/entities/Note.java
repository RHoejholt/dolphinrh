package app.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CascadeType;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String note;
    private LocalDate created;
    private String createdBy;

    @ManyToOne
    @ToString.Exclude
    private Person person;

    public Note(String note, String createdBy) {
        this.note = note;
        this.created = LocalDate.now(); // Auto-sets the current date
        this.createdBy = createdBy;
    }

}
