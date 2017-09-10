package com.backend.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.backend.spring.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao implements UserDao{

	public void saveUser(User user) {
		// TODO Auto-generated method stub
		persist(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(User.class);
        return (List<User>) criteria.list();
	}

	public void deleteUserById(int id) {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery("delete from User where user_id = :user_id");
		query.setInteger("user_id", id);
        query.executeUpdate();
	}

	public User findById(int id) {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("id",id));
        return (User) criteria.uniqueResult();
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		getSession().update(user);
	}

	public void deleteAllUsers() {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery("delete from User");
		query.executeUpdate();
	}

}
