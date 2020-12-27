package co.sudoers.virtualnotes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "topic")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topic {

    @Id
    @NotNull
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "topic_id")
    private UUID topicId;

    @NotBlank
    @Column(name = "topic_name")
    private String topicName;

    /*@OneToMany(mappedBy="topic", cascade=CascadeType.ALL)
    private List<Note> notes = new ArrayList<>();*/
}
