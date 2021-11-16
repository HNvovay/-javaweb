package com.factory;

import com.dao.*;
import com.dao.UserDao;
import com.daoimpl.ResidentDaoimpl;
import com.daoimpl.*;

public class DaoFactory {
	public static UserDao getUserDaoInstance() {
		return new UserDaoimpl();
	}
	public static ResidentDao getResidentDaoInstance() {
		return new ResidentDaoimpl();
	}
	public static RoomDao getRoomDaoInstance() {
		return new RoomDaoimpl();
	}
	public static ContractDao getContractDaoInstance() {
		return new ContractDaoimpl();
	}
}
