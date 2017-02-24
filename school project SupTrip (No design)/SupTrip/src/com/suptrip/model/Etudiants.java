package com.suptrip.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="etudiants")
public class Etudiants {
	
	@Id
	@Column (name="idbooster")
	private Long idBooster;
	
	@ManyToOne(cascade = CascadeType.DETACH , fetch = FetchType.EAGER)
	@JoinColumn (name="universite")
	private Campus campus;
	
	@OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="student")
	private Set<Commandes> commandes;
	
	@Column (name="first_name")
	private String firstName;
	
	@Column (name="last_name")
	private String lastName;
	
	@Column (name="mail")
	private String Mail;
	
	@Column (name="mdp")
	private String Mdp;

	
	public Long getIdBooster() {
		return idBooster;
	}
	
	public void setIdBooster(Long id) {
		this.idBooster = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String name) {
		this.firstName = name;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String name) {
		this.lastName = name;
	}
	
	public String getMail() {
		return Mail;
	}
	
	public void setMail(String mail) {
		this.Mail = mail;
	}
	
	public String getMdp() {
		return Mdp;
	}
	
	public void setMdp(String mdp) {
		this.Mdp = mdp;
	}
	
	public Campus getCampus() {
		return campus;
	}
	
	public void setCampus(Campus campus) {
		this.campus = campus;
	}
	
	public Etudiants() {}
	
		public Etudiants(Long idbooster, String firstname, String lastname, String mail, String mdp, Campus campus) {
		this.idBooster = idbooster;
		this.firstName = firstname;
		this.lastName = lastname;
		this.Mail = mail;
		this.Mdp = mdp;
		this.campus = campus;
	}
	
}
