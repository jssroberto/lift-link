package com.robertogarcia.liftlinkapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{user.username.notblank}")
    private String username;

    @JsonIgnore
    private String password;

    @NotBlank(message = "{user.email.notblank}")
    @Email(message = "{user.email.invalid}")
    private String email;

    @NotBlank(message = "{user.firstname.notblank}")
    private String firstName;

    @NotBlank(message = "{user.lastname.notblank}")
    private String lastName;

    @Past(message = "{user.dateofbirth.past}")
    private LocalDate dateOfBirth;

    @Pattern(regexp = ".*\\.(jpg|jpeg|png)$", message = "{user.profilepicture.format}")
    private String profilePicturePath;
}
