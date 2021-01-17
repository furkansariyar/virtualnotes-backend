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
@ApiModel(value = "Getting Topic Data Transfer Object")
public class GetTopicDto {

    @NotNull
    @JsonProperty("topic_id")
    @ApiModelProperty(value = "Topic ID", required = true)
    private UUID topicId;

    @NotBlank
    @JsonProperty("topic_name")
    @ApiModelProperty(value = "Topic Name", required = true)
    private String topicName;
}
