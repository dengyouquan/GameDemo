package com.game.handler;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.game.dao.UserDao;
import com.game.entities.User;

@Controller
public class UserHandler {
	@Autowired
	private UserDao userDao;
	
	@ResponseBody
	@RequestMapping(value="/updatepwd",method=RequestMethod.POST)
	public User updatepwd(HttpServletRequest request) throws IllegalStateException, IOException{
		System.out.println("updatepwd");
		Integer uid = Integer.parseInt(request.getParameter("uid"));
		System.out.println("uid:"+uid);
		String pwd = request.getParameter("pwd");
		System.out.println("pwd:"+pwd);
		String oldpwd = request.getParameter("oldpwd");
		System.out.println("oldpwd:"+oldpwd);
		User user = userDao.get(uid);
		System.out.println(user.getPwd());
		if(!user.getPwd().equalsIgnoreCase(oldpwd)) return null;
		user.setPwd(pwd);
		userDao.saveOrUpdate(user);
		System.out.println(user.getPwd());
		return user;
	}
	
	@ResponseBody
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public List<User> users(){
		System.out.println("users");
		List<User>  list = userDao.getAll();
		System.out.println(list);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="/showoneuser",method=RequestMethod.POST)
	public User showoneuser(HttpServletRequest request) throws IllegalStateException, IOException{
		System.out.println("showoneuser");
		Integer uid = Integer.parseInt(request.getParameter("uid"));
		System.out.println("uid:"+uid);
		return userDao.get(uid);
	}
	
	@ResponseBody
	@RequestMapping(value="/userlogin",method=RequestMethod.POST)
	public User userlogin(HttpServletRequest request) throws IllegalStateException, IOException{
		System.out.println("userlogin");
		String userName = request.getParameter("userName");
		System.out.println("userName:"+userName);
		String pwd = request.getParameter("pwd");
		System.out.println("pwd:"+pwd);
		User user = userDao.login(userName, pwd);
		if(user==null) System.out.println("µÇÂ¼Ê§°Ü");
		else System.out.println("µÇÂ¼³É¹¦");
		return user;
	}
	
	@ResponseBody
	@RequestMapping(value="/userregister",method=RequestMethod.POST)
	public User userregister(HttpServletRequest request) throws IllegalStateException, IOException{
		System.out.println("userregister");
		String userName = request.getParameter("userName");
		System.out.println("userName:"+userName);
		String pwd = request.getParameter("pwd");
		System.out.println("pwd:"+pwd);
		Date registerTime = new Date(System.currentTimeMillis());
		User user = new User(null, userName, pwd, registerTime, null);
		userDao.saveOrUpdate(user);
		return user;
	}
	
	@ResponseBody
	@RequestMapping(value="/userlogout",method=RequestMethod.POST)
	public User userlogout(HttpServletRequest request) throws IllegalStateException, IOException{
		System.out.println("userlogout");
		return null;
	}
}
