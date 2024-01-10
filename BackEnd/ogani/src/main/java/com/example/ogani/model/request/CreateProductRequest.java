package com.example.ogani.model.request;

import java.util.Set;

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
public class CreateProductRequest {
    
    @NotNull(message = "Le nom du produit est vide")
    @NotEmpty(message="Le nom du produit est vide")
    @Schema(description = "Nom du produit",example="Product1",required=true)
    @Size(min=5,max=50,message="Nom du produit de 3 à 50 caractères")
    private String name;

    @NotNull(message = "Description vide")
    @NotEmpty(message="Description vide")
    @Schema(description = "Description du produit",example="C'est le deuxième produit")
    @Size(min=5,max=1000,message="Description du produit de 5 à 1 000 caractères")
    private String description;

    @NotNull(message = "Prix ​​vide")
    @NotEmpty(message = "Prix ​​vide")
    @Schema(description = "Prix ​​du produit",example = "12")
    @Size(min=0,message="Le prix du produit est supérieur à 0")
    private long price;

    @NotNull(message = "Le nombre de produits")
    @NotEmpty(message="Le nombre de produits")
    @Schema(description = "Le nombre de produits",example="12")
    @Size(min=0,message="Nombre de produits de 0")
    private int quantity;

    @NotNull(message = "Catégorie vide")
    @NotEmpty(message = "Catégorie vide")
    @Schema(description = "ID de catégorie",example="1")
    private long categoryId;

    @NotNull(message="Photo de produit vide")
    @Schema(description="Tableau d'identifiants d'image",example="[1,2,3]")
    private Set<Long> imageIds;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public Set<Long> getImageIds() {
		return imageIds;
	}

	public void setImageIds(Set<Long> imageIds) {
		this.imageIds = imageIds;
	}
    
    
    
}
