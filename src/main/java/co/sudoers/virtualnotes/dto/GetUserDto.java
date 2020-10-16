package co.sudoers.virtualnotes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetUserDto {

    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("username")
    private String username;

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("email")
    private String email;
}
