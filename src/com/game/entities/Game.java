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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="g_game")
public class Game {
	private Integer id;
	private String gameName;
	private String introduction;
	private String content;
	private String memo;
	private Date put_time;
	private String downloadLink;
	private String mainpicture;
	private String score;
	private User user;
	private Integer status;
	@JsonBackReference
	private Set<Picture> pictures = new HashSet<Picture>();
	@JsonBackReference
	private Set<Video> videos = new HashSet<Video>();
	@JsonBackReference
	private Set<Comment> comments = new HashSet<Comment>();
	private String gameSize;
	public Game(Integer id, String gameName, String introduction, String content, String memo, Date put_time,
			String downloadLink, String mainpicture, String score, Integer status, String gameSize) {
		super();
		this.id = id;
		this.gameName = gameName;
		this.introduction = introduction;
		this.content = content;
		this.memo = memo;
		this.put_time = put_time;
		this.downloadLink = downloadLink;
		this.mainpicture = mainpicture;
		this.score = score;
		this.status = status;
		this.gameSize = gameSize;
	}
	
	public Game(Integer id, String gameName, String introduction, String content, String memo, Date put_time,
			String downloadLink, String mainpicture, String score, User user, Integer status, String gameSize) {
		super();
		this.id = id;
		this.gameName = gameName;
		this.introduction = introduction;
		this.content = content;
		this.memo = memo;
		this.put_time = put_time;
		this.downloadLink = downloadLink;
		this.mainpicture = mainpicture;
		this.score = score;
		this.user = user;
		this.status = status;
		this.gameSize = gameSize;
	}

	public Game(Integer id, String gameName, String introduction, String content, String memo, Date put_time,
			String downloadLink, String mainpicture, String gameSize) {
		super();
		this.id = id;
		this.gameName = gameName;
		this.introduction = introduction;
		this.content = content;
		this.memo = memo;
		this.put_time = put_time;
		this.downloadLink = downloadLink;
		this.mainpicture = mainpicture;
		this.gameSize = gameSize;
	}
	public Game() {
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
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Column(name="game_name")
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	
	public String getMainpicture() {
		return mainpicture;
	}
	public void setMainpicture(String mainpicture) {
		this.mainpicture = mainpicture;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public Date getPut_time() {
		return put_time;
	}
	public void setPut_time(Date put_time) {
		this.put_time = put_time;
	}
	@Column(name="download_link")
	public String getDownloadLink() {
		return downloadLink;
	}
	public void setDownloadLink(String downloadLink) {
		this.downloadLink = downloadLink;
	}
	@OneToMany(mappedBy="game",cascade=CascadeType.REMOVE)
	public Set<Picture> getPictures() {
		return pictures;
	}
	public void setPictures(Set<Picture> pictures) {
		this.pictures = pictures;
	}
	@OneToMany(mappedBy="game",cascade=CascadeType.REMOVE)
	public Set<Video> getVideos() {
		return videos;
	}
	public void setVideos(Set<Video> videos) {
		this.videos = videos;
	}
	@OneToMany(mappedBy="game",cascade=CascadeType.ALL)
	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	@Column(name="game_size")
	public String getGameSize() {
		return gameSize;
	}
	public void setGameSize(String gameSize) {
		this.gameSize = gameSize;
	}

	public Game(Integer id, String gameName, String introduction, String content, String memo, Date put_time,
			String downloadLink, String mainpicture, String score, User user, Integer status, Set<Comment> comments,
			String gameSize) {
		super();
		this.id = id;
		this.gameName = gameName;
		this.introduction = introduction;
		this.content = content;
		this.memo = memo;
		this.put_time = put_time;
		this.downloadLink = downloadLink;
		this.mainpicture = mainpicture;
		this.score = score;
		this.user = user;
		this.status = status;
		this.comments = comments;
		this.gameSize = gameSize;
	}
}
