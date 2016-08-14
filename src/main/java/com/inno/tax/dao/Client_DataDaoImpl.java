package com.inno.tax.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inno.tax.Client_Data;

@Repository
public class Client_DataDaoImpl implements Client_DataDao {
	
	@Autowired
    private SessionFactory sessionFactory;
	
    
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client_Data> findAll() {
		// TODO Auto-generated method stub
		List<Client_Data> list;
		list=sessionFactory.getCurrentSession().createQuery("from Client_Data").list();
		return list;
	}

	@Override
	public void save(Client_Data client_Data) {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(client_Data);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		Client_Data client_Data = (Client_Data) sessionFactory.getCurrentSession().load(Client_Data.class, id);
        if (null != client_Data) {
            sessionFactory.getCurrentSession().delete(client_Data);
        }
	}

	@Override
	public Client_Data findById(Integer id) {
		// TODO Auto-generated method stub
		
		Client_Data client_Data=(Client_Data)sessionFactory.getCurrentSession().load(Client_Data.class, id);
		return client_Data;
	}


	
	
	
	
	

}
