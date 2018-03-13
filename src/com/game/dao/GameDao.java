package com.game.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.game.entities.Game;

@Repository
@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
public class GameDao extends BaseDao {
	
	@SuppressWarnings("unchecked")
	public List<Game> getAll(){ 
		String hql = "from Game";
		return this.getSession().createQuery(hql).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Game> getBest(){ 
		String hql = "from Game g order by g.score desc";
		return this.getSession().createQuery(hql).setFirstResult(0).setMaxResults(2).list();
	}
	
	
	public Game get(Integer id){
		return (Game)this.getSession().get(Game.class, id);
	}
	
	public void delete(Integer id){
		String hql = "delete from Game g where id=?";
		this.getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}
	
	public void saveOrUpdate(Game game){
		this.getSession().saveOrUpdate(game);
		this.getSession().flush();
	}
}
