package co.sudoers.virtualnotes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Updating Topic Data Transfer Object")
public class UpdateTopicDto {

    @JsonProperty("topic_name")
    @ApiModelProperty(value = "Topic Name")
    private String topicName;
}
