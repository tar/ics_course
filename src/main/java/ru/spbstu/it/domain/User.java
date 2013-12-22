package ru.spbstu.it.domain;

import java.math.BigInteger;

import javax.persistence.*;

@Entity
@Table (name="users")

public class User {
	@Id
	@Column (name="user_id")
	private BigInteger id;
	
	@Column(name = "username")
	private String username;

	@Column(name = "skill")
	private String skill;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username=username;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill=skill;
	}
}
