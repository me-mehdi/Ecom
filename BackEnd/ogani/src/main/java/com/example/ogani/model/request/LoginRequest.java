package com.example.ogani.model.request;

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
public class LoginRequest {
    
    @NotNull(message="Nom d'utilisateur")
    @NotEmpty(message="Le nom d'utilisateur est vide")
    @Size(min=5,max=30,message="Le nom d'utilisateur comporte 5 à 30 caractères")
    @Schema(description = "Username",example="admin",required=true)
    private String username;

    @NotNull(message = "Mot de passe vide")
    @NotEmpty(message = "Mot de passe vide")
    @Size(min=6,max=30,message="Le mot de passe comporte 6 à 30 caractères")
    @Schema(description = "Mot de passe",example = "123456")
    private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    
    
}
