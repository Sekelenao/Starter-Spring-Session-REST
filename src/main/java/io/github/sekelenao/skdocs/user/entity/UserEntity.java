package io.github.sekelenao.skdocs.user.entity;

import io.github.sekelenao.skdocs.SharedConstants;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = SharedConstants.MAX_USERNAME_LENGTH)
    @Pattern(regexp = "^\\w+$")
    @Column(unique = true, nullable = false, length = SharedConstants.MAX_USERNAME_LENGTH)
    private String username;

    @NotNull
    @NotBlank
    @Size(min = SharedConstants.MIN_PASSWORD_LENGTH, max = SharedConstants.MAX_PASSWORD_LENGTH)
    @Column(nullable = false, length = SharedConstants.MAX_PASSWORD_LENGTH)
    private String password;

    @NotNull
    @NotBlank
    @Size(max = SharedConstants.MAX_DISPLAY_NAME_LENGTH)
    @Pattern(regexp = "^\\w+$")
    @Column(nullable = false, length = SharedConstants.MAX_DISPLAY_NAME_LENGTH)
    private String displayName;

    public UserEntity() {
        // Default constructor for Hibernate
    }

    public UserEntity(String username, String password, String displayName) {
        this.username = username;
        this.password = password;
        this.displayName = displayName;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDisplayName() {
        return displayName;
    }

}
