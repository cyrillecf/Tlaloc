package com.aistos.tlaloc.tomcat.service;


import java.util.List;

import org.springframework.stereotype.Component;

import com.aistos.tlaloc.data.HistoryDto;
import com.aistos.tlaloc.data.dao.HistoryDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Component
public class HistoryService {
	
	@SuppressWarnings("unchecked")
	public String getHistory() {
		HistoryDao historyDao = new HistoryDao();
		List<HistoryDto> historyList = (List<HistoryDto>) historyDao.list();
		Gson gson = new GsonBuilder().create();
		return gson.toJson(historyList);
	}
	
	public Boolean addHistory(HistoryDto h) {
		HistoryDao historyDao = new HistoryDao();
		return historyDao.insert(h);
	}
	
	public Boolean updateHistory(HistoryDto h) {
		HistoryDao historyDao = new HistoryDao();
		return historyDao.update(h);
	}
	
	public Boolean deleteHistory(int id_ligne_irrigation) {
		HistoryDao historyDao = new HistoryDao();
		return historyDao.delete(id_ligne_irrigation);
	}
}
