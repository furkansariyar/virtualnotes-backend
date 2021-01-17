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
@ApiModel(value = "Creating User Data Transfer Object")
public class CreateUserDto {

    @NotBlank
    @JsonProperty("username")
    @ApiModelProperty(value = "Username", required = true)
    private String username;

    @NotBlank
    @JsonProperty("full_name")
    @ApiModelProperty(value = "User Fullname", required = true)
    private String fullName;

    @NotBlank
    @JsonProperty("email")
    @ApiModelProperty(value = "User Email", required = true)
    private String email;

    @NotBlank
    @JsonProperty("password")
    @ApiModelProperty(value = "User Password", required = true)
    private String password;
}
