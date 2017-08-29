package com.springtest.springmongo.controller;


import java.util.Map;

import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rajo")
public class MainController {
	
	@RequestMapping(value="/getuname", method=RequestMethod.GET)
	@ResponseBody					
	public String returnUname(@RequestParam("uname") String uname){
		return uname;
	}
	@RequestMapping(value="/getparam/{uname}", method=RequestMethod.GET)
	@ResponseBody
	public String returnParamUname(@PathVariable("uname") String uname){
		return uname;
	}
	@RequestMapping(value="/getheader", method=RequestMethod.POST)
	@ResponseBody
	public String returnHeader(@RequestHeader(value="auth-token") String token){
		return token;
		
	}
	@RequestMapping(value="/getmatrix/{details}", method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)	
	public @ResponseBody String returnMatrix(@RequestBody @MatrixVariable Map<String,String> matrixVars){
		System.out.println(matrixVars);
		JSONObject json = new JSONObject();
		json.put("user_profile", matrixVars);
		return json.toString();	
	}
	
	@RequestMapping(value="/getmatrixid/{details}", method=RequestMethod.GET)	
	public @ResponseBody String returnId(@RequestBody @MatrixVariable(pathVar="details", name="id")String id){
		System.out.println(id);	
		return id;	
	}
	
}
