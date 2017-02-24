package com.suptrip.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="commandes")
public class Commandes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="id_commande")
	private Long idCommande;
	
	@ManyToOne(cascade = CascadeType.DETACH , fetch = FetchType.EAGER)
	@JoinColumn (name="student")
	private Etudiants etudiant;
	
	@ManyToOne(cascade = CascadeType.DETACH , fetch = FetchType.EAGER)
	@JoinColumn (name="voyage")
	private Trip trip;
	
	@Column (name="campus_depart")
	private String campusDepart;
	
	public Long getIdCommande() {
		return idCommande;
	}
	
	public void setIdCommande(Long id) {
		this.idCommande = id;
	}
	
	public Etudiants getEtudiant() {
		return etudiant;
	}
	
	public void setEtudiant(Etudiants etudiant) {
		this.etudiant = etudiant;
	}
	
	public Trip getTrip() {
		return trip;
	}
	
	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	
	public String getCampusDepart() {
		return campusDepart;
	}
	
	public void setCampusDepart(String name) {
		this.campusDepart = name;
	}
	
	
	public Commandes() {}
	
	public Commandes(Etudiants etudiant, Trip trip, String campusdepart) {
	this.campusDepart = campusdepart;
	this.etudiant = etudiant;
	this.trip = trip;
}
}
