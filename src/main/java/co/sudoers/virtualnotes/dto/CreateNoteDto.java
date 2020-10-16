package co.sudoers.virtualnotes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateNoteDto {

    @NotBlank
    @JsonProperty("note")
    private String note;

    @NotNull
    @JsonProperty("topic_id")
    private int topicId;

    @NotNull
    @JsonProperty("user_id")
    private int userId;
}
