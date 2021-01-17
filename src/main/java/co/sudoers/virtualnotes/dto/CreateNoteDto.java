package co.sudoers.virtualnotes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Creating Note Data Transfer Object")
public class CreateNoteDto {

    @NotBlank
    @JsonProperty("note")
    @ApiModelProperty(value = "Note Content", required = true)
    private String note;

    @NotNull
    @JsonProperty("topic_id")
    @ApiModelProperty(value = "Topic ID", required = true)
    private UUID topicId;

    @NotNull
    @JsonProperty("user_id")
    @ApiModelProperty(value = "User ID", required = true)
    private UUID userId;
}
