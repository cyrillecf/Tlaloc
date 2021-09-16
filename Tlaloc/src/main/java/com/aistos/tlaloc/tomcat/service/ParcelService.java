package com.aistos.tlaloc.tomcat.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.aistos.tlaloc.data.ParcelDto;
import com.aistos.tlaloc.data.dao.Dao;
import com.aistos.tlaloc.data.dao.ParcelDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Component
public class ParcelService {
	
	@SuppressWarnings("unchecked")
	public String getParcels() {
		Dao dao = new ParcelDao();
		List<ParcelDto> parcelList = (List<ParcelDto>) dao.list();
		Gson gson = new GsonBuilder().create();
		return gson.toJson(parcelList);
	}
	
	public Boolean addParcel(ParcelDto parcel) {
		Dao dao = new ParcelDao();
		return dao.insert(parcel);
	}
	
	public Boolean updateParcel(ParcelDto parcel) {
		Dao dao = new ParcelDao();
		return dao.update(parcel);	
	}
	
	public Boolean deleteParcel(int i) {
		Dao dao = new ParcelDao();
		return dao.delete(i);
	}
}
