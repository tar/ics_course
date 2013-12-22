package ru.spbstu.it.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.*;

@Entity
@Table (name="it_works")
@SequenceGenerator (name="seq_gen", sequenceName="it_works_id_seq")

public class ITWork{
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_gen")
	private Integer id;
	
	@Column(name = "COMPLETED")
	private Boolean completed;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "CREATOR_ID")
	private Integer creatorID;
	
	//private String creatorName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed=completed;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description=description;
	}

	public Integer getCreatorID() {
		return creatorID;
	}

	public void setCreatorID(Integer creator_id) {
		this.creatorID=creator_id;
	}
	
	/*public String getCreatorName(){
		return creatorName;
	}
	
	public void setCreatorName(String creator_name){
		this.creatorName=creator_name;
	}*/
}

