package com.suptrip.model;

import java.util.Set;

import javax.persistence.CascadeType;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table (name="trip")
@XmlRootElement
public class Trip {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="id_trip")
	private Long idTrip;

	@ManyToOne(cascade = CascadeType.DETACH , fetch = FetchType.EAGER)
	@JoinColumn (name="university")
	private Campus campus;
	
	@OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="voyage")
	@XmlTransient
	private Set<Commandes> commandes;
	
	@Column (name="name")
	private String name;
	
	@Column (name="content")
	private String content;
	
	@Column (name="date_depart")
	private String dateDepart;
	
	@Column (name="date_retour")
	private String dateRetour;
	
	public Long getIdTrip() {
		return idTrip;
	}
	public void setIdTrip(Long idTrip) {
		this.idTrip = idTrip;
	}
	public String getName() {
		return name;
	}
	public String getContent() {
		return content;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@XmlTransient
	public Campus getCampus() {
		return campus;
	}
	
	public void setCampus(Campus campus) {
		this.campus = campus;
	}
	
	public String getDateDepart() {
		return dateDepart;
	}
	public void setDateDepart(String date) {
		this.dateDepart = date;
	}
	
	public String getDateRetour() {
		return dateRetour;
	}
	public void setDateRetour(String date) {
		this.dateRetour = date;
	}
	public Trip() {}
	
	public Trip(String name, String content, Campus campus, String datedepart, String dateretour) {
		this.name 		= name;
		this.content 	= content;
		this.campus = campus;
		this.dateDepart = datedepart;
		this.dateRetour = dateretour;
	}
}
