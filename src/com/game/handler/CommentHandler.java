package com.game.handler;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.game.dao.CommentDao;
import com.game.dao.GameDao;
import com.game.dao.UserDao;
import com.game.entities.Comment;
import com.game.entities.Game;
import com.game.entities.User;

@Controller
public class CommentHandler {
	@Autowired
	private GameDao gameDao;
	@Autowired
	private CommentDao commentDao;
	@Autowired
	private UserDao userDao;
	
	@ResponseBody
	@RequestMapping(value="/showusercomments",method=RequestMethod.POST)
	public Set<Comment> showusercomments(HttpServletRequest request) throws IllegalStateException, IOException{
		System.out.println("showusercomments");
		Integer uid = Integer.parseInt(request.getParameter("uid"));
		System.out.println("uid:"+uid);
		Set<Comment> list = userDao.get(uid).getComments();
		System.out.println(list);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteusercomment",method=RequestMethod.POST)
	public Set<Comment> deleteusercomment(HttpServletRequest request) throws IllegalStateException, IOException{
		System.out.println("deleteusercomment");
		Integer uid = Integer.parseInt(request.getParameter("uid"));
		System.out.println("uid:"+uid);
		Integer cid = Integer.parseInt(request.getParameter("cid"));
		System.out.println("uid:"+cid);
		commentDao.delete(cid);
		Set<Comment> list = userDao.get(uid).getComments();
		System.out.println(list);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="/showcomments",method=RequestMethod.POST)
	public List<Comment> showcomments(HttpServletRequest request) throws IllegalStateException, IOException{
		System.out.println("showcomments");
		Integer gid = Integer.parseInt(request.getParameter("id"));
		System.out.println("id:"+gid);
		List<Comment>  list = commentDao.getGameAll(gid);
		System.out.println(list);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="/addacomment",method=RequestMethod.POST)
	public List<Comment> addacomment(HttpServletRequest request) throws IllegalStateException, IOException{
		System.out.println("addacomment");
		Integer gid = Integer.parseInt(request.getParameter("gid"));
		System.out.println("gid:"+gid);
		Integer uid = Integer.parseInt(request.getParameter("uid"));
		System.out.println("uid:"+uid);
		String content = request.getParameter("content");
		System.out.println("content:"+content);
		Game g = gameDao.get(gid);
		User u = userDao.get(uid);
		Date d = new Date(System.currentTimeMillis());
		Comment c = new Comment(null, content, d, null, g, u);
		commentDao.saveOrUpdate(c);
		List<Comment>  list = commentDao.getGameAll(gid);
		System.out.println(list);
		return list;
	}
}
