package co.sudoers.virtualnotes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTopicDto {

    @NotBlank
    @JsonProperty("topic_name")
    private String topicName;

}
