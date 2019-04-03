package com.Project.dao;

import com.Project.model.UserDetail;

public interface UserDetailDAO 
{
	public boolean registerUser(UserDetail user);
	 public boolean updateAddress(UserDetail user);
	 public UserDetail getUser(String username);
}
