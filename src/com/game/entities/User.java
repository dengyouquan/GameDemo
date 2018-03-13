package com.game.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="g_user")
public class User {
	private Integer id;
	private String userName;
	private String pwd;
	private Date registerTime;
	private String memo;
	@JsonBackReference
	private Set<Comment> comments = new HashSet<Comment>();
	@JsonBackReference
	private Set<Game> games = new HashSet<Game>();
	
	
	public User(Integer id, String userName, String pwd, Date registerTime, String memo, Set<Comment> comments) {
		super();
		this.id = id;
		this.userName = userName;
		this.pwd = pwd;
		this.registerTime = registerTime;
		this.memo = memo;
		this.comments = comments;
	}
	
	public User(Integer id, String userName, String pwd, Date registerTime, String memo) {
		super();
		this.id = id;
		this.userName = userName;
		this.pwd = pwd;
		this.registerTime = registerTime;
		this.memo = memo;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@OneToMany(mappedBy="user",cascade=CascadeType.REMOVE)
	public Set<Game> getGames() {
		return games;
	}

	public void setGames(Set<Game> games) {
		this.games = games;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	@Column(name="user_name")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(name="register_time")
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", pwd=" + pwd + ", registerTime=" + registerTime
				+ ", memo=" + memo + "]";
	}
	
	
}
