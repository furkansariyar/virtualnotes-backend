package co.sudoers.virtualnotes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Updating Note Data Transfer Object")
public class UpdateNoteDto {

    @JsonProperty("note_id")
    @ApiModelProperty(value = "Note ID")
    private UUID noteId;

    @JsonProperty("note")
    @ApiModelProperty(value = "Note Content")
    private String note;

    @JsonProperty("topic_id")
    @ApiModelProperty(value = "Topic ID")
    private UUID topicId;
}
