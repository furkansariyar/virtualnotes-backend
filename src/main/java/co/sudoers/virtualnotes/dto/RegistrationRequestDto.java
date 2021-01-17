package co.sudoers.virtualnotes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel(value = "Registration Request Data Transfer Object")
public class RegistrationRequestDto {

    @NotBlank
    @ApiModelProperty(value = "Username", required = true)
    private String username;

    @NotBlank
    @ApiModelProperty(value = "Fullname", required = true)
    private String fullName;

    @NotBlank
    @ApiModelProperty(value = "Password", required = true)
    private String password;

    @NotBlank
    @ApiModelProperty(value = "Email", required = true)
    private String email;
}
