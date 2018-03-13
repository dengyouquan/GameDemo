package com.game.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="g_comment")
public class Comment {
	private Integer id;
	private String content;
	private Date commentDate;
	private String memo;
	private Game game;
	private User user;
	
	public Comment(Integer id, String content, Date commentDate, String memo, Game game, User user) {
		super();
		this.id = id;
		this.content = content;
		this.commentDate = commentDate;
		this.memo = memo;
		this.game = game;
		this.user = user;
	}
	
	public Comment() {
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
	//@JsonBackReference
	@ManyToOne
	@JoinColumn(name="game_id")
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public String getContent() {
		return content;
	}
	//@JsonBackReference
	@ManyToOne
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Column(name="comment_date")
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", commentDate=" + commentDate + ", memo=" + memo
				+ ", user=" + user + "]";
	}
	
	
}
