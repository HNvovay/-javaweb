package com.dao;

import java.sql.ResultSet;

import com.bean.Contract;

public interface ContractDao {
	public boolean addContract(Contract contract);
	public boolean updateContract(Contract resident);
	public boolean deleteContract(Contract resident);  
	public ResultSet selectContract(String check);
	public String getContractImg(String roomID);
}
