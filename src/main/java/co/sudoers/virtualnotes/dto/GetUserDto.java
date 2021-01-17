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
@ApiModel(value = "Getting User Data Transfer Object")
public class GetUserDto {

    @JsonProperty("user_id")
    @ApiModelProperty(value = "User ID")
    private UUID userId;

    @JsonProperty("username")
    @ApiModelProperty(value = "Username")
    private String username;

    @JsonProperty("full_name")
    @ApiModelProperty(value = "User Fullname")
    private String fullName;

    @JsonProperty("email")
    @ApiModelProperty(value = "User Email")
    private String email;
}
