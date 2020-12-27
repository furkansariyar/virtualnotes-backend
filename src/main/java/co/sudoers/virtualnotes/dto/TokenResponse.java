package co.sudoers.virtualnotes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenResponse {
    private UUID userId;
    private String username;
    private String token;
}
