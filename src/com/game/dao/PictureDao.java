package com.game.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.game.entities.Picture;

@Repository
@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
public class PictureDao extends BaseDao {
	@SuppressWarnings("unchecked")
	public List<Picture> getAll(){ 
		String hql = "from Picture";
		return this.getSession().createQuery(hql).list();
	}
	
	public Picture get(Integer id){
		return (Picture)this.getSession().get(Picture.class, id);
	}
	
	public void delete(Integer id){
		String hql = "delete from Picture p where id=?";
		this.getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}
	
	public void saveOrUpdate(Picture picture){
		this.getSession().saveOrUpdate(picture);
		this.getSession().flush();
	}
}
