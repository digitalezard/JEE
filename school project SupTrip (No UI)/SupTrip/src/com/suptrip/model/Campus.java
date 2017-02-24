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

@Entity
@Table (name="campus")
public class Campus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="id_campus")
	private Long idCampus;
	
	@ManyToOne(cascade = CascadeType.DETACH , fetch = FetchType.EAGER)
	@JoinColumn (name="country")
	private Pays pays;
	
	@OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="university")
	private Set<Trip> trip;
	
	@OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="universite")
	private Set<Etudiants> etudiants;
	
	@Column (name="campus_name")
	private String campusName;
	
	public Long getIdCampus() {
		return idCampus;
	}
	
	public void setIdCampus(Long id) {
		this.idCampus = id;
	}
	
	public Pays getPays() {
		return pays;
	}
	
	public void setPays(Pays pays) {
		this.pays = pays;
	}
	
	public String getCampusName() {
		return campusName;
	}
	
	public void setCampusName(String name) {
		this.campusName = name;
	}
	
	public Campus() {}
	
	public Campus(String name, Pays pays) {
		this.campusName = name;
		this.pays =	 pays;
	}
}
