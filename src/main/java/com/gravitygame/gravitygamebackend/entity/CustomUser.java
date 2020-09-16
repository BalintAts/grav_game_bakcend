package com.gravitygame.gravitygamebackend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomUser {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public CustomUser(@NotEmpty String username, @NotEmpty String password) {
        this.username = username;
        this.password = password;
    }

    @NotEmpty
    String username;

    @NotEmpty
    String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<String> getRoles() {
        return roles;
    }
}
