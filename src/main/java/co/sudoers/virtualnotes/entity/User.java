package co.sudoers.virtualnotes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @NotNull
    @GeneratedValue(generator = "user_seq")
    @Column(name = "user_id")
    private int userId;

    @NotBlank
    @Column(name = "username", unique = true)
    private String username;

    @NotBlank
    @Column(name = "full_name")
    private String fullName;

    @NotBlank
    @Column(name = "email")
    private String email;

    @JsonIgnore
    @NotBlank
    @Column(name = "password")
    private String password;

}
