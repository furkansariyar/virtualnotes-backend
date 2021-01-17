package co.sudoers.virtualnotes.dto;

import co.sudoers.virtualnotes.entity.Topic;
import co.sudoers.virtualnotes.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@ApiModel(value = "Getting Note Data Transfer Object")
public class GetNoteDto {

    @NotNull
    @JsonProperty("id")
    @ApiModelProperty(value = "Note ID", required = true)
    private UUID noteId;

    @NotBlank
    @JsonProperty("note")
    @ApiModelProperty(value = "Note Content", required = true)
    private String note;

    @JsonProperty("topic")
    @ApiModelProperty(value = "Topic")
    private Topic topic;

    @JsonIgnore
    @JsonProperty("user")
    @ApiModelProperty(value = "User")
    private User user;
}
