package com.springmongo.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.springmongo.collection.AdvertisementCollection;


import com.springmongo.dao.AdvertisementDao;

import com.springmongo.entity.Advertisement;


public class AdvertisementServiceImplementation implements AdvertisementService{
@Autowired
AdvertisementDao advertisementDao;
public Advertisement postAd(Advertisement advertisement, String token) {
	return advertisementDao.postAd(advertisement,token);
}
public List<Advertisement> getAdsByUser(String token) {
	return advertisementDao.getAdsByUser(token);
	// TODO Auto-generated method stub
	
}

}
