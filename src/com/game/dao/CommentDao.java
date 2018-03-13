package com.game.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.game.entities.Comment;

@Repository
@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
public class CommentDao extends BaseDao {
	@SuppressWarnings("unchecked")
	public List<Comment> getAll(){ 
		String hql = "from Comment";
		return this.getSession().createQuery(hql).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Comment> getGameAll(Integer gid){ 
		String hql = "from Comment c where game_id=?";
		return this.getSession().createQuery(hql).setInteger(0, gid).list();
	}
	
	public Comment get(Integer id){
		return (Comment)this.getSession().get(Comment.class, id);
	}
	
	public void delete(Integer id){
		String hql = "delete from Comment c where id=?";
		this.getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}
	
	public void saveOrUpdate(Comment comment){
		this.getSession().saveOrUpdate(comment);
		this.getSession().flush();
	}
}
