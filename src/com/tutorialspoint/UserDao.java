package com.tutorialspoint;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	public List<User> getAllUsers(){
		List<User> userList = null;
		try {
			File file = new File("C:\\Users\\Admin\\Downloads\\Users.txt");
			if (!file.exists()) { 
				User user = new User(1, "Mahesh", "Teacher");
				userList = new ArrayList<User>();
				userList.add(user);
				saveUserList(userList);
			}         else{

				FileInputStream fis = new FileInputStream(file); 
				ObjectInputStream ois = new ObjectInputStream(fis); 
				userList = (List<User>) ois.readObject();   
				ois.close();  
			}     
		} 
		catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) { 
			e.printStackTrace(); 
		}       
		return userList;  
	} 


	private void saveUserList(List list) {
		File file = new File("C:\\Users\\Admin\\Downloads\\Users.txt");
		FileOutputStream fos;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos); 
			//userList = (List<User>)  ;
			oos.writeObject(list);
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
 
 }