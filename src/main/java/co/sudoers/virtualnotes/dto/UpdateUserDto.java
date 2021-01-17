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
@ApiModel(value = "Updating User Data Transfer Object")
public class UpdateUserDto {

    @JsonProperty("username")
    @ApiModelProperty(value = "Username")
    private String username;

    @JsonProperty("full_name")
    @ApiModelProperty(value = "Fullname")
    private String fullName;

}
