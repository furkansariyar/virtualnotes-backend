package co.sudoers.virtualnotes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "topic")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topic {

    @Id
    @NotNull
    @GeneratedValue(generator = "topic_seq")
    @Column(name = "topic_id")
    private int topicId;

    @NotBlank
    @Column(name = "topic_name")
    private String topicName;

    /*@OneToMany(mappedBy="topic", cascade=CascadeType.ALL)
    private List<Note> notes = new ArrayList<>();*/
}
