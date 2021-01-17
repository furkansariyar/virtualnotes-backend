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
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Token Response Data Transfer Object")
public class TokenResponse {

    @ApiModelProperty(value = "User ID")
    private UUID userId;

    @ApiModelProperty(value = "Username")
    private String username;

    @ApiModelProperty(value = "Token")
    private String token;
}
