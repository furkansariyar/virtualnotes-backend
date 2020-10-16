package co.sudoers.virtualnotes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "note")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note {

    @Id
    @NotNull
    @GeneratedValue(generator = "note_seq")
    @Column(name = "note_id")
    private int noteId;

    @NotBlank
    @Column(name = "note")
    private String note;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
