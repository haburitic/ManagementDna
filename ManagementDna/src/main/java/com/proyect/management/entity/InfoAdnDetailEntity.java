package com.proyect.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity InfoAdnDetail
 * @author HABUR
 *
 */
@Entity
@Table(name = "t_info_Adn_detail")
public class InfoAdnDetailEntity  {
	
	public InfoAdnDetailEntity() {
		
	}
	

	
	/**
	 * @param id
	 * @param element
	 * @param infoAdn
	 */
	public InfoAdnDetailEntity(String element, InfoAdnEntity infoAdn) {
		super();
		this.element = element;
		this.infoAdn = infoAdn;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "element")
	private String element;
	
    /**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the element
	 */
	public String getElement() {
		return element;
	}

	/**
	 * @param element the element to set
	 */
	public void setElement(String element) {
		this.element = element;
	}

	/**
	 * @return the infoAdn
	 */
	public InfoAdnEntity getInfoAdn() {
		return infoAdn;
	}

	/**
	 * @param infoAdn the infoAdn to set
	 */
	public void setInfoAdn(InfoAdnEntity infoAdn) {
		this.infoAdn = infoAdn;
	}

	@ManyToOne
    @JoinColumn(name="info_adn_id", nullable=false)
    private InfoAdnEntity infoAdn;
	
	
}
