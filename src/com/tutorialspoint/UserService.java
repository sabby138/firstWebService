package com.tutorialspoint;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;
@Path("/UserService") public class UserService {
	
	UserDao userDao = new UserDao();
	
	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getUsers(){
		JSONObject outputJsonObj = null;
		People people =null;
		try {
			 people = new People();
			people.setUserList(userDao.getAllUsers());
			//JSONArray peopleJson = new JSONArray(people);
			outputJsonObj = new JSONObject();
			outputJsonObj.put("output", people);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outputJsonObj;   
	}

}
