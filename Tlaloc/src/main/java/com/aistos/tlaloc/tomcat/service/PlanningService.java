package com.aistos.tlaloc.tomcat.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.aistos.tlaloc.data.PlanningDto;
import com.aistos.tlaloc.data.dao.Dao;
import com.aistos.tlaloc.data.dao.PlanningDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Component
public class PlanningService {
	
	/**
	 * Créer la liste des plannings
	 * @return une chaine de caractère au format au JSON
	 * @deprecated
	 */
	@SuppressWarnings("unchecked")
	public String getPlannings() {
		Dao dao = new PlanningDao();
		List<PlanningDto> PlanningList = (List<PlanningDto>) dao.list();
		Gson gson = new GsonBuilder().create();
		return gson.toJson(PlanningList);
	}
	@SuppressWarnings("unchecked")
	public String getplanningsVariete(int id_ligne) {
		PlanningDao dao = new PlanningDao();
		List<PlanningDto> planningVariete = (List<PlanningDto>) dao.list(id_ligne);
		Gson gson = new GsonBuilder().create();
		return gson.toJson(planningVariete);
	}
	public Boolean addPlanning(PlanningDto planning) {
		Dao dao = new PlanningDao();
		return dao.insert(planning);
	}
	
	public Boolean updatePlanning(PlanningDto planning) {
		Dao dao = new PlanningDao();
		return dao.update(planning);
	}
	
	public Boolean deletePlanning(int id_planning) {
		Dao dao = new PlanningDao();
		return dao.delete(id_planning);
	}
	
	public Boolean deletePlanningWithIrrigationLineId(int id_ligne_irrigation) {
		PlanningDao dao = new PlanningDao();
		return dao.deleteWithLigneIrrigation(id_ligne_irrigation);
	}
	
}
