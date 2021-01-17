package co.sudoers.virtualnotes.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Login Request Data Transfer Object")
public class LoginRequestDto {

    @NotBlank
    @ApiModelProperty(value = "Username", required = true)
    private String username;

    @NotBlank
    @ApiModelProperty(value = "Password", required = true)
    private String password;
}
