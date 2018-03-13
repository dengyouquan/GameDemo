package com.game.main;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.game.dao.GameDao;
import com.game.dao.PictureDao;
import com.game.entities.Game;
import com.game.entities.Picture;

public class AddGame {
	@Autowired
	private GameDao gameDao;
	@Autowired
	private PictureDao pictureDao;
	
	public static void main(String[] args) {
		AddGame ag = new AddGame();
		
	}
}
