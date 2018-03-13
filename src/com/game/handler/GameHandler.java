package com.game.handler;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.game.dao.GameDao;
import com.game.dao.PictureDao;
import com.game.dao.UserDao;
import com.game.dao.VideoDao;
import com.game.entities.Game;
import com.game.entities.Picture;
import com.game.entities.User;
import com.game.entities.Video;

@Controller
public class GameHandler {
	@Autowired
	private GameDao gameDao;
	@Autowired
	private PictureDao pictureDao;
	@Autowired
	private VideoDao videoDao;
	@Autowired
	private UserDao userDao;
	
	@ResponseBody
	@RequestMapping(value="/deleteusergame",method=RequestMethod.POST)
	public List<Game> deleteusergame(HttpServletRequest request) throws IllegalStateException, IOException{
		System.out.println("deleteusergame");
		Integer id = Integer.parseInt(request.getParameter("id"));
		System.out.println("id:"+id);
		Integer gid = Integer.parseInt(request.getParameter("gid"));
		System.out.println("gid:"+gid);
		gameDao.delete(gid);
		List<Game>  list = gameDao.getAll();
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="/showusergames",method=RequestMethod.POST)
	public Set<Game> showusergames(HttpServletRequest request) throws IllegalStateException, IOException{
		System.out.println("showusergames");
		Integer id = Integer.parseInt(request.getParameter("id"));
		System.out.println("id:"+id);
		@SuppressWarnings("unchecked")
		Set<Game>  list = userDao.get(id).getGames();
		System.out.println(list);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="/showgames",method=RequestMethod.GET)
	public List<Game> showgames(){
		System.out.println("games");
		List<Game>  list = gameDao.getAll();
		System.out.println(list);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="/showbestgames",method=RequestMethod.GET)
	public List<Game> showbestgames(){
		System.out.println("showbestgames");
		List<Game>  list = gameDao.getBest();
		System.out.println(list);
		return list;
	}
	
/*	@RequestMapping(value="/gamedetail",method=RequestMethod.GET)
	public String gamedetail(HttpServletRequest request) throws IllegalStateException, IOException{
		System.out.println("gamedetail");
		Integer id = Integer.parseInt(request.getParameter("id"));
		System.out.println("id:"+id);
		return "redirect:/gamedetail.html?id="+id;
	}*/
	
	@ResponseBody
	@RequestMapping(value="/showonegame",method=RequestMethod.POST)
	public Game showonegame(HttpServletRequest request) throws IllegalStateException, IOException{
		System.out.println("showonegame");
		Integer id = Integer.parseInt(request.getParameter("id"));
		System.out.println("id:"+id);
		return gameDao.get(id);
	}
	
	@RequestMapping(value="/updateonegame",method=RequestMethod.POST)
	public String updateonegame(HttpServletRequest request) throws IllegalStateException, IOException{
		System.out.println("updateonegame");
		Integer gid = Integer.parseInt(request.getParameter("gid"));
		System.out.println("gid:"+gid);
		Integer uid = Integer.parseInt(request.getParameter("uid"));
		System.out.println("uid:"+uid);
		String gameName = request.getParameter("gameName");
		System.out.println("gameName:"+gameName);
		String score = request.getParameter("score");
		//Double score = Double.parseDouble(request.getParameter("score"));
		System.out.println("score:"+score);
		String memo = request.getParameter("memo");
		System.out.println("memo:"+memo);
		String content = request.getParameter("content");
		System.out.println("content:"+content);
		String downloadLink = request.getParameter("downloadLink");
		System.out.println("downloadLink:"+downloadLink);
		String gameSize = request.getParameter("gameSize");
		System.out.println("gameSize:"+gameSize);
		String path = request.getParameter("mainpicture");
		System.out.println("path:"+path);
		Date put_time = new Date(System.currentTimeMillis());
		User user = userDao.get(uid);
		Game game = new Game(gid, gameName, null, content, memo, put_time, downloadLink, path, score,user, 1, gameSize);
		gameDao.saveOrUpdate(game);
		System.out.println("game:"+game);
		return "redirect:/games.html";
	}
	
	@ResponseBody
	@RequestMapping(value="/showpictures",method=RequestMethod.GET)
	public List<Picture> showpictures(){
		System.out.println("pictures");
		List<Picture>  list = pictureDao.getAll();
		System.out.println(list);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="/showvideos",method=RequestMethod.GET)
	public List<Video> showvideos(){
		System.out.println("videos");
		List<Video>  list = videoDao.getAll();
		System.out.println(list);
		return list;
	}
	
	@RequestMapping(value="/addGame",method=RequestMethod.GET)
	public String addGame(){
		Date date = new Date(System.currentTimeMillis());
		Picture p = new Picture(null, "queyang", "images/queyang.jpg", "", null);
		Game game = new Game(null, "缺氧", "好玩", "《缺氧》是由开发过《饥荒》的Klei Entertainment所制作并发行的一款模拟游戏，其美术风格也与《饥荒》一脉相承，并同样采用了横版2D布局。", null, date, "https://pan.baidu.com/share/link?shareid=3506833964&uk=4245428095#list/path=%2F","images/queyang.jpg", "320M");
		//Picture p = new Picture(null, "jihuang", "images/jihuang.jpg", "", null);
		//Game game = new Game(null, "缺氧", "好玩", "饥荒是由《闪克》制造组Klei制造发行的一款动作冒险类求生游戏，《饥荒》的故事讲述的是关于一名科学家被恶魔传送到了异世界荒野。", null, date, "https://pan.baidu.com/share/link?shareid=1956597398&uk=84605489#list/path=%2F","images/jihuang.jpg", "220M");
		game.getPictures().add(p);
		p.setGame(game);
		gameDao.saveOrUpdate(game);
		pictureDao.saveOrUpdate(p);
		return "redirect:/games.html";
	}
	
		//add a game
	@RequestMapping(value="/addonegame",method=RequestMethod.POST)
	public String addgoods(HttpServletRequest request) throws IllegalStateException, IOException{
		System.out.println("addonegame");
		Integer uid = Integer.parseInt(request.getParameter("uid"));
		System.out.println("uid:"+uid);
		String gameName = request.getParameter("gameName");
		System.out.println("gameName:"+gameName);
		String score = request.getParameter("score");
		//Double score = Double.parseDouble(request.getParameter("score"));
		System.out.println("score:"+score);
		String memo = request.getParameter("memo");
		System.out.println("memo:"+memo);
		String content = request.getParameter("content");
		System.out.println("content:"+content);
		String downloadLink = request.getParameter("downloadLink");
		System.out.println("downloadLink:"+downloadLink);
		String gameSize = request.getParameter("gameSize");
		System.out.println("gameSize:"+gameSize);
		/*try {
			name = new String(name.getBytes("ISO-8859-1"),"UTF-8");
			System.out.println(name);
			
			memo = new String(memo.getBytes("ISO-8859-1"),"UTF-8");
			System.out.println(memo);
			
			image = new String(image.getBytes("ISO-8859-1"),"UTF-8");
			System.out.println(image);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}*/
		String path = null;
		String fileName = null;
		//将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request))
        {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            
            MultipartFile file = multiRequest.getFile("mainpicture");
           
           long l = System.currentTimeMillis();
			String s = Long.toString(l);
			if(s.length()>7)
				s = s.substring(s.length()-7, s.length());
			else
				s = s+s;
            //path="/images/"+s+"-"+file.getOriginalFilename();
			fileName = file.getOriginalFilename();
            path=multiRequest.getSession().getServletContext().getRealPath("/images/")+s+"-"+file.getOriginalFilename();
            System.out.println("path:"+path);
            //上传
            file.transferTo(new File(path));
            path = path.split("GameDemo")[1];
            //path = path.substring(1, path.length());
            path = path.replace("\\","/");
            path = path.substring(1, path.length());
            System.out.println("path:"+path);
           /*//获取multiRequest 中所有的文件名
            Iterator<String> iter=multiRequest.getFileNames();
             
            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null)
                {
                    String path="E:/springUpload"+file.getOriginalFilename();
                    //上传
                    file.transferTo(new File(path));
                }
                 
            }*/
           
        }
		Date put_time = new Date(System.currentTimeMillis());
		User user = userDao.get(uid);
		Game game = new Game(null, gameName, null, content, memo, put_time, downloadLink, path, score,user, 1, gameSize);
		gameDao.saveOrUpdate(game);
		Picture p = new Picture(null,fileName , path, "", null);
		pictureDao.saveOrUpdate(p);
		System.out.println("game:"+game);
		System.out.println("picture:"+p);
		return "redirect:/games.html";
	}
}
