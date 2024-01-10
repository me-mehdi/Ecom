package com.example.ogani.model.request;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {


    @NotNull(message="Le nom d'utilisateur est vide")
    @NotEmpty(message="Le nom d'utilisateur est vide")
    @Size(min=5,max=30,message="Nom d'utilisateur de 5 à 30 caractères")
    @Schema(description="Username",example="admin",required=true)
    private String username;

    @NotNull(message="E-mail vide")
    @NotEmpty(message="E-mail vide")
    @Size(min =5,max=30, message="E-mail de 5 à 30 caractères")
    @Email(message="Email invalide")
    @Schema(description = "Email",example="admin@gmail.com",required=true)
    private String email;

    @NotNull(message="Mot de passe vide")
    @NotEmpty(message="Mot de passe vide")
    @Size(min=6,max=30,message="Mot de passe de 6 à 30 caractères")
    @Schema(description="Mot de passe",example="123456")
    private String password;

    private Set<String> role;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<String> getRole() {
		return role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}
    
    
    
}
