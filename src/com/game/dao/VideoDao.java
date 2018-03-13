package com.game.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.game.entities.Video;

@Repository
@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
public class VideoDao extends BaseDao {
	@SuppressWarnings("unchecked")
	public List<Video> getAll(){ 
		String hql = "from Video";
		return this.getSession().createQuery(hql).list();
	}
	
	public Video get(Integer id){
		return (Video)this.getSession().get(Video.class, id);
	}
	
	public void delete(Integer id){
		String hql = "delete from Video v where id=?";
		this.getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}
	
	public void saveOrUpdate(Video video){
		this.getSession().saveOrUpdate(video);
		this.getSession().flush();
	}
}
