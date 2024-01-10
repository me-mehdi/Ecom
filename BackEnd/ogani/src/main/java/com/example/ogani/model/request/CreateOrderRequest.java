package com.example.ogani.model.request;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderRequest {
    
    @NotNull(message="Le nom de famille du client est vide")
    @NotEmpty(message="Le nom de famille du client est vide")
    @Size(min=3,max=50,message="Nom de famille du client de 3 à 50 caractères")
    private String firstname;
    
    @NotNull(message="Le nom du client est vide")
    @NotEmpty(message="Le nom du client est vide")
    @Size(min=3,max=50,message="Nom du client de 3 à 50 caractères")
    private String lastname;

    @NotNull(message="Nom du pays vide")
    @NotEmpty(message="Nom du pays vide")
    private String country;

    @NotNull(message="Nom d'adresse vide")
    @NotEmpty(message="Nom d'adresse vide")
    private String address;

    @NotNull(message="Nom du pays vide")
    @NotEmpty(message="Nom du pays videg")
    private String town;

    @NotNull(message="Nom de la zone vide")
    @NotEmpty(message="Nom de la zone vide")
    private String state;

    @NotNull(message ="Le code postal est vide")
    @NotEmpty(message ="Le code postal est vide")
    private long postCode;

    @NotNull(message = "E-mail vide")
    @NotEmpty(message = "E-mail vide")
    @Email(message = "Email Malformé")
    private String email;
     
    @NotNull(message="Numéro de téléphone vide")
    @NotEmpty(message="Numéro de téléphone vide")
    private String phone;

    private String note;

    private long totalPrice;
    
    private String username;

    private List<CreateOrderDetailRequest> orderDetails;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public long getPostCode() {
		return postCode;
	}

	public void setPostCode(long postCode) {
		this.postCode = postCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<CreateOrderDetailRequest> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<CreateOrderDetailRequest> orderDetails) {
		this.orderDetails = orderDetails;
	}
    
    
    
}
