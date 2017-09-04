package com.springmongo.service;

import com.springmongo.collection.AdvertisementCollection;

import com.springmongo.entity.Advertisement;


public interface AdvertisementService {
	public AdvertisementCollection postAd(Advertisement advertisement, String token);
}
