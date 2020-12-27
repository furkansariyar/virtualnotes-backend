package co.sudoers.virtualnotes.dto;

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
public class GetTopicDto {

    @NotNull
    @JsonProperty("topic_id")
    private UUID topicId;

    @NotBlank
    @JsonProperty("topic_name")
    private String topicName;
}
