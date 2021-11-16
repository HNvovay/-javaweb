package com.dao;

import java.sql.ResultSet;

import com.bean.Resident;

public interface ResidentDao {
	public boolean addResident(Resident resident);
	public boolean updateResident(Resident resident);
	public boolean deleteResident(Resident resident);  
	public ResultSet selectResident(String check);
	public String getResidentName(String residentID);
}
