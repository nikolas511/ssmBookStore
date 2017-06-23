package cn.pjj.dao;

import cn.pjj.bean.User;

public interface UserDao {
	void addUser(User user);
	
	void updateUser(User user);

	User login(String username,String password);

	void deleteUserById(String id);
	
	User queryUserById(String id);
}
