package com.springmongo.controller;


import java.util.Date;
import java.util.List;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.springmongo.entity.UpdateAd;
import com.springmongo.entity.User;
import com.springmongo.entity.UserLogin;
import com.springmongo.service.ActionService;
import com.springmongo.service.AdvertisementService;
import com.springmongo.service.ItemService;
import com.springmongo.service.UserService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("")
public class MainController {
	static SimpleDateFormat dateFormat = new SimpleDateFormat();
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
	 public @ResponseBody User registerUser(@RequestBody User user){
	System.out.println("Controller");
		return userService.createUser(user);	 
	 }	

//login
@RequestMapping(value="/login", method=RequestMethod.POST,
consumes=MediaType.APPLICATION_JSON_VALUE,
produces=MediaType.APPLICATION_JSON_VALUE)	
	 public @ResponseBody String  loginUser(@RequestBody UserLogin userLogin){
	System.out.println("Controller"+userLogin);
	JSONObject data = new JSONObject();
	JSONObject json = new JSONObject();
	UserLoginCollection userLoginCollection= userService.loginUser(userLogin);	
		if(userLoginCollection!=null){
			json.put("auth-token",userLoginCollection.getId() );
			json.put("userId", userLoginCollection.getUserName());			
			json.put("lastUpdateDate", userLoginCollection.getLastUpdated() );	
			data.put("data", json);
			System.out.println(data);
			return data.toString();
		}else{
			json.put("message", "Wrong username or password");
			return data.toString();
		}	
	 }

	//logout
	@RequestMapping(value="/logout", method=RequestMethod.DELETE)
	 public @ResponseBody String  logoutUser(@RequestHeader(value="auth-token") String token){
		String userSession = userService.logoutUser(token);
		JSONObject json = new JSONObject();
		if(userSession!=null){
			json.put("logout", userSession);
			return json.toString();
		}else{
			json.put("logout", userSession);
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
		JSONObject itemList = new JSONObject();
			if(items!=null){
				itemList.put("itemList", items);
				json.put("data",itemList );
				return json.toString();
			}else{
				json.put("message", "No Categories");
			return json.toString();
			}	
	 }
	//actions
	@RequestMapping(value="/actions", method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody String  getActions(@RequestHeader(value="auth-token") String token){
		System.out.println("Controller");
		ArrayList<ActionCollection> actions = actionService.getAllActions(token);
		JSONObject json = new JSONObject();
		JSONObject actionList = new JSONObject();
			if(actions!=null){
				actionList.put("actionList", actions);
				json.put("data",actionList );
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
		Advertisement advert = advertisementService.postAd(advertisement,token);
		JSONObject json = new JSONObject();
			if(advert!=null){
			json.put("_id",advert.getId() );
			json.put("userName",advert.getUserName() );
			json.put("name",advert.getName() );
			json.put("title",advert.getTitle() );
			json.put("description",advert.getDescription() );
			json.put("category",advert.getCategory() );
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
		JSONObject userDetail = new JSONObject();
		JSONObject userItems = new JSONObject();
		User userDetails = userService.getUser(uname);
		
		if(userDetails!=null){
			userItems.put("userName", userDetails.getUserName());
			userItems.put("email", userDetails.getEmail());
			userItems.put("firstName", userDetails.getFirstName());
			userItems.put("lastName", userDetails.getLastName());
			userItems.put("phone", userDetails.getPhone());
			userDetail.put("user", userItems);
			json.put("data",userDetail);
			return json.toString();
		}else{
			json.put("userDetails","No such user");
			return json.toString();
		}
		
	 }
	//postBySpecificUser
	@RequestMapping(value="/posts", method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody String  getPostsByUser(@RequestHeader(value="auth-token") String token){
		System.out.println("Controller");
		List<Advertisement> advertisementList = advertisementService.getAdsByUser(token);
		
		//JSONObject advertisementByUserListDetails = new JSONObject();
		JSONObject json = new JSONObject();
			if(advertisementList!=null){
				
				JSONObject advertisementByUserList = new JSONObject();
				for(Advertisement x : advertisementList){
					JSONObject temp = new JSONObject();
					temp.put("id", x.getId());
					temp.put("createdDate", x.getCreatedDate());
					temp.put("title", x.getTitle());
					temp.put("category", x.getCategory());
					temp.put("status", "Open");
					temp.put("description", x.getDescription());
					advertisementByUserList.append("mypostList", temp);

				}
				
				//advertisementByUserList.put("mypostList", advertisementList);
				json.put("data",advertisementByUserList );
				return json.toString();
			}else{
				json.put("message", "No actions");
			return json.toString();
			}

	 }
	//Update Ad
	@RequestMapping(value="/postAd", method=RequestMethod.PUT,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody String  updateAd(@RequestBody UpdateAd updateAd, @RequestHeader(value="auth-token") String token){
		System.out.println("Controller "+updateAd);
		JSONObject json = new JSONObject();
		json.put("update", advertisementService.updateAd(updateAd,token));
		return json.toString();
	 }
	
	//Delete Specific ad
	@RequestMapping(value="/post", method=RequestMethod.DELETE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody String  deleteAd(@RequestParam("postId") int postId,@RequestHeader(value="auth-token") String token ){
		System.out.println("Controller");
		JSONObject json = new JSONObject();
		json.put("delete", advertisementService.deleteAd(postId,token));
		return json.toString();
		
	 }
	//ViewAd
	@RequestMapping(value="/viewAd", method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody String  viewAd(@RequestParam("postId") int postId,@RequestHeader(value="auth-token") String token ){
		System.out.println("Controller "+postId);
		Advertisement x = advertisementService.viewAd(postId,token);
		JSONObject json = new JSONObject();
		JSONObject temp = new JSONObject();
		temp.put("id", x.getId());
		temp.put("createdDate", x.getCreatedDate());
		temp.put("title", x.getTitle());
		temp.put("category", x.getCategory());
		temp.put("status", "Open");
		temp.put("description", x.getDescription());
		json.put("data",temp );
		return json.toString();
		
	 }
	
	//Token
	public static String generateToken(){
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
            salt.append(System.currentTimeMillis());
        }
        String saltStr = salt.toString();
        return saltStr;
		
	}


}
