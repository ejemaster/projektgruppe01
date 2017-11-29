package org.projektmanagement.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Kunde")
public class Kunde {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "kunde_id")
	private int id;

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;

	@Column(name = "street")
	private String street;

	@Column(name = "streetnr")
	private String streetnr;

	@Column(name = "plz")
	private String plz;

	@Column(name = "place")
	private String place;

	@Column(name = "country")
	private String country;

	@Column(name = "houses")
	@OneToMany(mappedBy="besitzer", fetch=FetchType.EAGER)
	private List<Haus> houses = new ArrayList<Haus>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Haus> getHouses() {
		return houses;
	}

	public void setHouses(List<Haus> houses) {
		this.houses = houses;
	}

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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetnr() {
		return streetnr;
	}

	public void setStreetnr(String streetnr) {
		this.streetnr = streetnr;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
