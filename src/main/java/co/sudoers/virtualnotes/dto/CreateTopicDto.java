package co.sudoers.virtualnotes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Creating Topic Data Transfer Object")
public class CreateTopicDto {

    @NotBlank
    @JsonProperty("topic_name")
    @ApiModelProperty(value = "Topic Name", required = true)
    private String topicName;

}
