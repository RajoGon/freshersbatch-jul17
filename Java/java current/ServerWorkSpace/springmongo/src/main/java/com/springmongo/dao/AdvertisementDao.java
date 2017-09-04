package com.springmongo.dao;

import java.util.List;

import com.springmongo.collection.AdvertisementCollection;
import com.springmongo.collection.UserCollection;
import com.springmongo.collection.UserLoginCollection;
import com.springmongo.entity.Advertisement;
import com.springmongo.entity.User;
import com.springmongo.entity.UserLogin;

public interface AdvertisementDao {
	public Advertisement postAd(Advertisement advertisement, String token);

	public List<Advertisement> getAdsByUser(String token);
}
