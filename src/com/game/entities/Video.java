package com.game.entities;

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
@Table(name="g_video")
public class Video {
	private Integer id;
	private String videoName;
	private String dateLen;
	private String videoPos;
	private String memo;
	private Game game;
	public Video(Integer id, String videoName, String dateLen, String videoPos, String memo, Game game) {
		super();
		this.id = id;
		this.videoName = videoName;
		this.dateLen = dateLen;
		this.videoPos = videoPos;
		this.memo = memo;
		this.game = game;
	}
	
	public Video() {
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
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="game_id")
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	@Column(name="video_name")
	public String getVideoName() {
		return videoName;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	@Column(name="date_len")
	public String getDateLen() {
		return dateLen;
	}
	public void setDateLen(String dateLen) {
		this.dateLen = dateLen;
	}
	@Column(name="video_pos")
	public String getVideoPos() {
		return videoPos;
	}
	public void setVideoPos(String videoPos) {
		this.videoPos = videoPos;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	@Override
	public String toString() {
		return "Video [id=" + id + ", videoName=" + videoName + ", dateLen=" + dateLen + ", videoPos=" + videoPos
				+ ", memo=" + memo + ", game=" + game + "]";
	}
	
}
