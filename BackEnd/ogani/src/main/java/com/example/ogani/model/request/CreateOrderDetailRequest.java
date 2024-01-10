package com.example.ogani.model.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderDetailRequest {

    @NotNull(message="Le nom du produit est vide")
    @NotEmpty(message = "Le nom du produit est vide")
    @Size(min=5,max=50,message="Nom du produit de 5 à 50 caractères")
    private String name;

    @NotNull(message="Le prix du produit est vide")
    @NotEmpty(message="Le prix du produit est vide")
    @Size(min=0,message ="Prix ​​du produit à partir de 0 ou plus")
    private long price;

    @NotNull(message = "Nombre de produits vides")
    @NotEmpty(message = "Nombre de produits vides")
    @Size(min = 1,message="La quantité de produits est de 1 ou plus")
    private int quantity;

    private long subTotal;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public long getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(long subTotal) {
		this.subTotal = subTotal;
	}
    
    
}
