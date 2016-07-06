package course.bean;

import java.io.Serializable;

public class User implements Serializable{
private String username;
private String password;
private String email;
private String usertype;
/**
 * 
 */
public User() {
	super();
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public void setUsertype(String usertype){
	this.usertype = usertype;
}
public String getUsertype(){
	return usertype;
}

}
