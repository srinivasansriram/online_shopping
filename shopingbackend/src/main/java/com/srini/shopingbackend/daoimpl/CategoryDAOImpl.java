package com.srini.shopingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srini.shopingbackend.dao.CategoryDAO;
import com.srini.shopingbackend.dto.Category;
@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	

	@Override
	public List<Category> list() {
		
		String selectActiveCategory = "FROM Category WHERE  active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("active",true);
		
		return query.getResultList();
	}

	@Override
	
	public boolean add(Category category) {
		// TODO Auto-generated method stub
		
		try {
			
			sessionFactory.getCurrentSession().persist(category);
			
			
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}

// method for updating the table
	@Override
	public boolean update(Category category) {
		// TODO Auto-generated method stub
		
try {
			
			sessionFactory.getCurrentSession().update(category);
			
			
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}


	@Override
	public boolean delete(Category category) {
		// TODO Auto-generated method stub
		category.setActive(false);
		
try {
			
			sessionFactory.getCurrentSession().update(category);
			
			
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
	// getting a single class id
	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		return  sessionFactory.getCurrentSession().get(Category.class,Integer.valueOf(id));
	}

}
