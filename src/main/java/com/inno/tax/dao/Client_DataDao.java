package com.inno.tax.dao;
import java.util.List;

import com.inno.tax.Client_Data;

public interface Client_DataDao {
	
	public List<Client_Data> findAll();
    public void save(Client_Data client_Data);
    public void deleteById(Integer id);
    public Client_Data findById(Integer id);
}
