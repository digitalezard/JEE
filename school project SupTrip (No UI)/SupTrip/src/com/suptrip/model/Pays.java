package com.suptrip.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="pays")
public class Pays {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="id_pays")
	private Long idPays;
	
	@Column (name="country_name")
	private String countryName;
	
	@OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="country")
	private Set<Campus> campus;
	
	public Long getIdPays() {
		return idPays;
	}
	
	public void setIdPays(Long idPays) {
		this.idPays = idPays;
	}
	
	public String getCountryName() {
		return countryName;
	}
	
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	public Pays() {}
	
	public Pays(Long id, String name) {
		this.idPays = id;
		this.countryName = name;
	}
}
