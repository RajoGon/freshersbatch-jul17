package com.springmongo.service;



import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.springmongo.collection.AdvertisementCollection;


import com.springmongo.dao.AdvertisementDao;

import com.springmongo.entity.Advertisement;
import com.springmongo.entity.GetMessage;
import com.springmongo.entity.UpdateAd;


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

public String updateAd(UpdateAd updateAd, String token) {
	// TODO Auto-generated method stub
	return advertisementDao.updateAd(updateAd,token);	
}
public String deleteAd(int postId, String token) {
	// TODO Auto-generated method stub
	return advertisementDao.deleteAd(postId,token);
}
public Advertisement viewAd(int postId, String token) {
	// TODO Auto-generated method stub
	return advertisementDao.viewAd(postId,token);
}
public String sendMessage(GetMessage messageObj, String token) {
	// TODO Auto-generated method stub
	return advertisementDao.sendMessage(messageObj,token);
}
public List<Advertisement> viewAllAds() {
	// TODO Auto-generated method stub
	return advertisementDao.viewAllAds();
}
public List<Advertisement> searchByText(String searchText) {
	// TODO Auto-generated method stub
	return advertisementDao.searchByText(searchText);
}

}
