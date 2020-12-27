package co.sudoers.virtualnotes.dto;

import co.sudoers.virtualnotes.entity.Topic;
import co.sudoers.virtualnotes.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetNoteDto {

    @NotNull
    @JsonProperty("id")
    private UUID noteId;

    @NotBlank
    @JsonProperty("note")
    private String note;

    @JsonProperty("topic")
    private Topic topic;

    @JsonIgnore
    @JsonProperty("user")
    private User user;
}
