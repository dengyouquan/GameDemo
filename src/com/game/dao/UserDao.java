package com.game.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.game.entities.User;


@Repository
@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
public class UserDao extends BaseDao {
	@SuppressWarnings("unchecked")
	public List<User> getAll(){ 
		String hql = "from User";
		return this.getSession().createQuery(hql).list();
	}
	
	public User get(Integer id){
		return (User)this.getSession().get(User.class, id);
	}
	
	public void delete(Integer id){
		String hql = "delete from User u where id=?";
		this.getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}
	
	public void saveOrUpdate(User user){
		this.getSession().saveOrUpdate(user);
		this.getSession().flush();
	}
	
	public User login(String userName,String pwd){
		String hql = "select id from User u where userName=? and pwd=? ";
		@SuppressWarnings("unchecked")
		List<Integer>list = this.getSession().createQuery(hql).setString(0,userName).setString(1, pwd).list();
		if(list.isEmpty()) return null;
		Integer id = list.get(0);
		return (User)this.getSession().get(User.class, id);
	}
}
