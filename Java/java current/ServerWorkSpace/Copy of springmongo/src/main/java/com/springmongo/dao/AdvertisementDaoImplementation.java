package com.springmongo.dao;



import org.springframework.beans.factory.annotation.Autowired;


import com.springmongo.collection.AdvertisementCollection;

import com.springmongo.collection.UserLoginCollection;
import com.springmongo.entity.Advertisement;

import com.springmongo.repository.AdvertisementRepository;

import com.springmongo.repository.UserLoginRepository;


public class AdvertisementDaoImplementation implements AdvertisementDao{
	@Autowired
	AdvertisementRepository advertisementRepository;
	@Autowired
	UserLoginRepository userLoginRepository;

	public AdvertisementCollection postAd(Advertisement advertisement, String token) {
		
		UserLoginCollection userSession =userLoginRepository.findOne(token);
		System.out.println("Found session, "+userSession);
		if(userSession!=null){
			
			AdvertisementCollection advertisementCollection = new AdvertisementCollection();
			advertisementCollection.setName(advertisement.getName());
			advertisementCollection.setTitle(advertisement.getTitle());
			advertisementCollection.setDescription(advertisement.getDescription());
			advertisementCollection.setCategoryl(advertisement.getCategory());
			System.out.println(advertisementCollection);
			advertisementRepository.save(advertisementCollection);
			return advertisementCollection;
	
		}else{
			return null;
		}
	}

	
	

}
