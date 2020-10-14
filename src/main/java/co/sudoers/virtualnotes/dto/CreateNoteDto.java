package co.sudoers.virtualnotes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateNoteDto {

    @NotBlank
    @JsonProperty("note")
    private String note;

    @NotBlank
    @JsonProperty("topic")
    private String topic;
}
