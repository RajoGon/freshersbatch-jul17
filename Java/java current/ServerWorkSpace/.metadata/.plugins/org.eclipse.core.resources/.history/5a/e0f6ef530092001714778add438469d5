package com.springmongo.service;

import java.util.Collection;
import java.util.List;

import com.springmongo.collection.AdvertisementCollection;

import com.springmongo.entity.Advertisement;
import com.springmongo.entity.UpdateAd;


public interface AdvertisementService {
	public Advertisement postAd(Advertisement advertisement, String token);

	public List<Advertisement> getAdsByUser(String token);

	public String updateAd(UpdateAd updateAd, String token);

	public String deleteAd(int postId, String token);

	public Advertisement viewAd(int postId, String token);
}
