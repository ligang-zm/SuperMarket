package com.lg.dao;

import java.util.List;

import com.lg.entity.UserAccount;

public interface IUserDAO {
   boolean addUser(UserAccount ac);
   boolean deleteUser(int acId);
   boolean updateUser(UserAccount ac);
   boolean findUser(String acName);
   boolean checkUserByName(String acName);
   UserAccount findUserByName(String acName);
   UserAccount findUserById(int acId);
   List<UserAccount>findAllUsers();
	boolean updateUser(String acname, String acpassword, String problem,
			String answer);
   
}
