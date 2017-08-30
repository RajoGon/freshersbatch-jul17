package com.springmongo.controller;


import java.util.Date;

import java.text.SimpleDateFormat;
import java.util.ArrayList;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springmongo.collection.ActionCollection;
import com.springmongo.collection.AdvertisementCollection;
import com.springmongo.collection.ItemCollection;
import com.springmongo.collection.UserCollection;
import com.springmongo.collection.UserLoginCollection;
import com.springmongo.entity.Advertisement;
import com.springmongo.entity.User;
import com.springmongo.entity.UserLogin;
import com.springmongo.service.ActionService;
import com.springmongo.service.AdvertisementService;
import com.springmongo.service.ItemService;
import com.springmongo.service.UserService;

@RestController
@RequestMapping("")
public class MainController {
@Autowired
UserService userService;
@Autowired
ItemService itemService;

@Autowired
ActionService actionService;

@Autowired
AdvertisementService advertisementService;
//register
@RequestMapping(value="/register", method=RequestMethod.POST,
consumes=MediaType.APPLICATION_JSON_VALUE,
produces=MediaType.APPLICATION_JSON_VALUE)	
	 public @ResponseBody UserCollection registerUser(@RequestBody User user){
	System.out.println("Controller");
		return userService.createUser(user);	 
	 }	

//login
@RequestMapping(value="/login", method=RequestMethod.POST,
consumes=MediaType.APPLICATION_JSON_VALUE,
produces=MediaType.APPLICATION_JSON_VALUE)	
	 public @ResponseBody String  loginUser(@RequestBody UserLogin userLogin){
	System.out.println("Controller");
	JSONObject json = new JSONObject();
	UserLoginCollection userLoginCollection= userService.loginUser(userLogin);	
		if(userLoginCollection!=null){
			json.put("auth-token", userLoginCollection.getId());
			json.put("userName", userLoginCollection.getUserName());
			SimpleDateFormat dateFormat = new SimpleDateFormat();
			json.put("lastUpdateDate", dateFormat.format(new Date()) );	
			return json.toString();
		}else{
			json.put("message", "Wrong username or password");
			return json.toString();
		}	
	 }

	//logout
	@RequestMapping(value="/logout", method=RequestMethod.DELETE)
	 public @ResponseBody String  logoutUser(@RequestHeader(value="auth-token") String token){
		UserLoginCollection userSession = userService.logoutUser(token);
		JSONObject json = new JSONObject();
		if(userSession!=null){
			json.put("logout", "success");
			json.put("userName", userSession.getUserName());
			return json.toString();
		}else{
			json.put("logout", "failed");
			return json.toString();
		}		
	 }	
	//categories
	@RequestMapping(value="/categories", method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody String  getCategories(){
		System.out.println("Controller");
		ArrayList<ItemCollection> items = itemService.getAllCategories();
		JSONObject json = new JSONObject();

			if(items!=null){
				json.put("categories",items );
				return json.toString();
			}else{
				json.put("message", "No Categories");
			return json.toString();
			}	
	 }
	//actions
	@RequestMapping(value="/actions", method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody String  getActions(){
		System.out.println("Controller");
		ArrayList<ActionCollection> actions = actionService.getAllActions();
		JSONObject json = new JSONObject();

			if(actions!=null){
				json.put("actions",actions );
				return json.toString();
			}else{
				json.put("message", "No actions");
			return json.toString();
			}	
	 }
	//postAd
	@RequestMapping(value="/postAd", method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody String  postAd(@RequestBody Advertisement advertisement, @RequestHeader(value="auth-token") String token){
		System.out.println("Controller");
		AdvertisementCollection advert = advertisementService.postAd(advertisement,token);
		JSONObject json = new JSONObject();
			if(advert!=null){
			json.put("_id",advert.getId() );
			json.put("name",advert.getName() );
			json.put("title",advert.getTitle() );
			json.put("description",advert.getDescription() );
			json.put("category",advert.getCategoryl() );
				return json.toString();
			}else{
				json.put("message", "Cannot post ad");
			return json.toString();
			}	

	 }
	
	
	
	//getUser
	@RequestMapping(value="/user", method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody String  getUser(@RequestParam("userId") String uname){
		System.out.println("Controller");
		JSONObject json = new JSONObject();
		UserCollection userDetails = userService.getUser(uname);
		if(userDetails!=null){
			
			json.put("userDetails",userDetails);
			return json.toString();
		}else{
			json.put("userDetails","No such user");
			return json.toString();
		}
		
	 }
	
	


}