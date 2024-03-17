package webApplication;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class UserBean implements Serializable
{
private String name,email;
int age;
Date dob;
public UserBean() 
{
System.out.println("user been constructor");
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}



public int getAge() {
	return age;
}


public void setAge(int age) {
	this.age = age;
}


public Date getDob() {
	return dob;
}


public void setDob(Date dob) {
	this.dob = dob;
}


@Override
public String toString() {
	return "UserBean [name=" + name + ", email=" + email + ", age=" + age + ", dob=" + dob + "]";
}



}
