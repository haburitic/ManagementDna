package com.proyect.management.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity InfoAdn.
 * @author HABUR
 *
 */
@Entity
@Table(name = "t_info_Adn")
public class InfoAdnEntity  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6829552211144966635L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "count_dna")
	private Integer countDna;
	
	@OneToMany(mappedBy="infoAdn")
    private List<InfoAdnDetailEntity> infoAdnDetailList;

    /**
	 * @return the countDna
	 */
	public Integer getCountDna() {
		return countDna;
	}

	/**
	 * @param countDna the countDna to set
	 */
	public void setCountDna(Integer countDna) {
		this.countDna = countDna;
	}
    
	/**
	 * @return the infoAdnDetailList
	 */
	public List<InfoAdnDetailEntity> getInfoAdnDetailList() {
		return infoAdnDetailList;
	}

	/**
	 * @param infoAdnDetailList the infoAdnDetailList to set
	 */
	public void setInfoAdnDetailList(List<InfoAdnDetailEntity> infoAdnDetailList) {
		this.infoAdnDetailList = infoAdnDetailList;
	}

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
	
}
