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
@Table(name="g_main_picture")
public class MainPicture {
	private Integer id;
	private String pictureName;
	private String picturePos;
	private String memo;
	private Game game;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public MainPicture(Integer id, String pictureName, String picturePos, String memo, Game game) {
		super();
		this.id = id;
		this.pictureName = pictureName;
		this.picturePos = picturePos;
		this.memo = memo;
		this.game = game;
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
	@Column(name="picture_name")
	public String getPictureName() {
		return pictureName;
	}
	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}
	@Column(name="picture_pos")
	public String getPicturePos() {
		return picturePos;
	}
	public void setPicturePos(String picturePos) {
		this.picturePos = picturePos;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	@Override
	public String toString() {
		return "Picture [id=" + id + ", pictureName=" + pictureName + ", picturePos=" + picturePos + ", memo=" + memo
				+ ", game=" + game + "]";
	}
}
