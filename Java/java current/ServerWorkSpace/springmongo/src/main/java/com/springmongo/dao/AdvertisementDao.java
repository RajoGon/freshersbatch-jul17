package com.springmongo.dao;

import java.util.Collection;
import java.util.List;

import com.springmongo.collection.AdvertisementCollection;
import com.springmongo.collection.UserCollection;
import com.springmongo.collection.UserLoginCollection;
import com.springmongo.entity.Advertisement;
import com.springmongo.entity.GetMessage;
import com.springmongo.entity.UpdateAd;
import com.springmongo.entity.User;
import com.springmongo.entity.UserLogin;

public interface AdvertisementDao {
	public Advertisement postAd(Advertisement advertisement, String token);

	public List<Advertisement> getAdsByUser(String token);

	public String updateAd(UpdateAd updateAd, String token);

	public String deleteAd(int postId, String token);

	public Advertisement viewAd(int postId, String token);

	public String sendMessage(GetMessage messageObj, String token);

	public List<Advertisement> viewAllAds();

	public List<Advertisement> searchByText(String searchText);
}
