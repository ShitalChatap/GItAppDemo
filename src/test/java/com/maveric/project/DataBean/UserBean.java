package com.maveric.project.DataBean;

public class UserBean 
{
	private String userName , password;
	public UserBean()
	{
		
	}
	public String getuserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName=userName;
		
	}
	public String getPassword()
	{
		return password;
	}
	public void setpassword(String password)
	{
	
		this.password=password;	
	}
	@Override
	public String toString()
	{
		return "UserBean[userName="+userName+",password="+password+"]";
	}


}
