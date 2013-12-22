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
@Table (name="tasks")
@SequenceGenerator (name="seq_gen", sequenceName="it_works_id_seq")

public class Task{
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_gen")
	private Integer id;
	
	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "owner_id")
	private Integer owner_id;
	
	@Column(name="employee_id")
	private Integer employee_id;
	
	@Column(name="completed")
	private Boolean completed;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title=title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description=description;
	}

	public Integer getOwnerID() {
		return owner_id;
	}

	public void setOwnerID(Integer ownerid) {
		this.owner_id=ownerid;
	}
	public Integer getEmployeeID() {
		return employee_id;
	}

	public void setEmployeeID(Integer employeeid) {
		this.employee_id=employeeid;
	}
	
	public Boolean getCompleted(){
		return completed;
	}
	
	public void setCompleted(Boolean completed){
		this.completed=completed;
	}

}

