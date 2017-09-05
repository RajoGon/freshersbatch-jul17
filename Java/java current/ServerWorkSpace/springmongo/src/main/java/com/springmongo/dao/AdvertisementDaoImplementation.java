package com.springmongo.dao;



import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.springmongo.collection.AdvertisementCollection;

import com.springmongo.collection.UserLoginCollection;
import com.springmongo.entity.Advertisement;
import com.springmongo.entity.UpdateAd;
import com.springmongo.repository.AdvertisementRepository;

import com.springmongo.repository.UserLoginRepository;


public class AdvertisementDaoImplementation extends HibernateDaoSupport implements AdvertisementDao{

	static SimpleDateFormat dateFormat = new SimpleDateFormat();
	@Transactional
	public Advertisement postAd(Advertisement advertisement, String token) {	
		boolean userSession =verifyToken(token);
		System.out.println("Found session, "+userSession);
		if(userSession==true){
			org.hibernate.Query uname = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("select userName from UserLoginCollection where id=:authToken ");
			uname.setParameter("authToken", token);
			String userName = (String) uname.list().get(0);
			System.out.println("Add for usser"+userName);
			advertisement.setCreatedDate(dateFormat.format(new Date()));
			advertisement.setUserName(userName);
			 getHibernateTemplate().save(advertisement);
			return advertisement;
	
		}else{
			return null;
		}
	}

	
	@Transactional
	public List<Advertisement> getAdsByUser(String token) {
		org.hibernate.Query uname = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("select userName from UserLoginCollection where id=:authToken ");
		uname.setParameter("authToken", token);
		String userName = (String) uname.list().get(0);
		System.out.println("user"+userName);
		org.hibernate.Query ads = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("from Advertisement where userName= :uname ");
		ads.setParameter("uname", userName);
		List advertisementList = ads.list();
		if(advertisementList!=null){
			return advertisementList;
		}else{
			return null;
		}
	
	}
	@Transactional
	public String updateAd(UpdateAd updateAd,String token) {
		boolean verify = verifyToken(token);
		if(verify==true){
			System.out.println("Updateing ad with is"+updateAd.getPostId() );
			org.hibernate.Query ads = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("update Advertisement set name= :newName, title= :newTitle, description= :newDescription,category= :newCategory where id= :postId ");														
			ads.setParameter("newName", updateAd.getName());
			ads.setParameter("newTitle", updateAd.getTitle());
			ads.setParameter("newDescription", updateAd.getDescription());
			ads.setParameter("newCategory", updateAd.getCategory());
			ads.setParameter("postId", updateAd.getPostId());
			System.out.println("Query is"+ads);
			int adUpdaate = ads.executeUpdate();
			if(adUpdaate>0){
				return "Updated";
			}else{
				return "Failed";
			}			
		}else{
			return "Failed";
		}
		
	}
	@Transactional
	public String deleteAd(int postId, String token) {
		boolean verify = verifyToken(token);
		if(verify==true){
			org.hibernate.Query ads = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("Delete Advertisement where id= :postId ");														
			ads.setParameter("postId", postId);
			int adUpdaate = ads.executeUpdate();
			if(adUpdaate>0){
				return "Delete";
			}else{
				return "Failed";
			}
		}else{
			return "Failed";
		}

	}
	
	@Transactional
	public Advertisement viewAd(int postId, String token) {
		boolean verify = verifyToken(token);
		if(verify==true){
			org.hibernate.Query ads = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("from Advertisement where id= :postId ");														
			ads.setParameter("postId", postId);
			Advertisement viewAdDetails= (Advertisement) ads.list().get(0);
			if(viewAdDetails!=null){
				return viewAdDetails;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	public boolean verifyToken(String token){
		org.hibernate.Query q = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("from UserLoginCollection where id=:authToken ");
		q.setParameter("authToken", token);
		
		if(q.list()!=null){
			return true;
		}else{
			return false;
		}
	}


	


	

}
