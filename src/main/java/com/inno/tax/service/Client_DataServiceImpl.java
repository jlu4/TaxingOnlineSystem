package com.inno.tax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inno.tax.Client_Data;
import com.inno.tax.dao.Client_DataDao;

@Service
public class Client_DataServiceImpl implements Client_DataService {

	@Autowired
	Client_DataDao client_DataDao;
	
	@Transactional
	public List<Client_Data> findAll() {
		// TODO Auto-generated method stub
		return client_DataDao.findAll();
	}
	
	@Transactional
	public void save(Client_Data client_Data) {
		// TODO Auto-generated method stub
		client_DataDao.save(client_Data);

	}
	
	@Transactional
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		client_DataDao.deleteById(id);
			
	}
	
	@Transactional
	public Client_Data findById(Integer id) {
		// TODO Auto-generated method stub
		return client_DataDao.findById(id);
	}

	public Client_DataDao getClient_DataDao() {
		return client_DataDao;
	}

	public void setClient_DataDao(Client_DataDao client_DataDao) {
		this.client_DataDao = client_DataDao;
	}
	
	

}
