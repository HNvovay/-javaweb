package com.dao;

import com.bean.UserLogin;

public interface UserDao {
 public  int login(UserLogin userlogin);//登陆接口
 public  UserLogin Loginsucceedtakeuser(UserLogin userlogin) ;
 //利用登陆界面返回的用户名给定一个userlogin对象，然后在传一个带有登陆了的用户姓名的uselogin对象，返回一个取了数据库中所有userlogin对象的值出来付给session；
 public  boolean register(UserLogin login) ;
 public  boolean updatepwd(UserLogin user) ;
}
