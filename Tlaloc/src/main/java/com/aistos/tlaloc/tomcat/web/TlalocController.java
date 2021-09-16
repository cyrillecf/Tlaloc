package com.aistos.tlaloc.tomcat.web;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aistos.tlaloc.MainApplication;
import com.aistos.tlaloc.data.ParcelDto;
import com.aistos.tlaloc.data.PlanningDto;
import com.aistos.tlaloc.tomcat.service.HistoryService;
import com.aistos.tlaloc.tomcat.service.ParcelService;
import com.aistos.tlaloc.tomcat.service.PlanningService;


@Controller
public class TlalocController {
	
	private static Log logger = LogFactory.getLog(MainApplication.class);

	/*
	 * Parcelle
	 */
	
	@CrossOrigin
	@RequestMapping("/parcelle/list")
	@ResponseBody
	public String getParcelleList() {
		ParcelService parcelService= new ParcelService();
		String parcelListJson = parcelService.getParcels();
		return parcelListJson;
	}

	@CrossOrigin
	@RequestMapping("/parcelle/insert")
	@ResponseBody
	public Boolean addParcel(@RequestParam(value="variete") String variete, @RequestParam(value="ligne_irrigation") int ligne_irrigation) {
		variete = parseString(variete,"_");
		logger.info("insert new parcel : " + variete + " " + ligne_irrigation);//? remplacer la requete sql en remplaçant id-serre par ligne_irrigation
		ParcelDto parcel =  new ParcelDto(variete,ligne_irrigation, 1);
		ParcelService parcelService= new ParcelService();
		boolean isInserted = parcelService.addParcel(parcel);
		logger.info("requete validéé : " + isInserted);
		if(isInserted) {
			return true;
		}else {
			return false;
		}
	}
	
	
	@CrossOrigin
	@RequestMapping("/parcelle/update")
	@ResponseBody
	public Boolean updateParcel(@RequestParam(value="variete") String variete, @RequestParam(value="ligne_irrigation") int ligne_irrigation){
		
		variete = parseString(variete,"_");
		logger.info("update parcel : " + variete + " " + ligne_irrigation);
		ParcelDto parcel =  new ParcelDto(variete,ligne_irrigation,1);
		ParcelService parcelService= new ParcelService();
		boolean isUpdated = parcelService.updateParcel(parcel);
		logger.info("requete validéé : " + isUpdated);
		
		if(isUpdated) {return true;}
		else {return false;}
	}
	
	
	@CrossOrigin
	@RequestMapping("/parcelle/delete")
	@ResponseBody
	public Boolean deleteParcel(@RequestParam(value="ligne_irrigation") int ligne_irrigation){

		logger.info("delete parcel : " + ligne_irrigation);
		
		PlanningService planningService = new PlanningService();
		boolean planning_isDeleted = planningService.deletePlanningWithIrrigationLineId(ligne_irrigation);
		logger.info("planning requete validéé : " + planning_isDeleted);
		
		HistoryService historyService = new HistoryService();
		boolean log_isDeleted = historyService.deleteHistory(ligne_irrigation);
		logger.info("log requete validéé : " + log_isDeleted);
		
		ParcelService parcelService = new ParcelService();
		boolean parcel_isDeleted = parcelService.deleteParcel(ligne_irrigation);
		logger.info("parcelle requete validéé : " + parcel_isDeleted);
		
		if(parcel_isDeleted) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	/*
	 * Planning
	 */
	
	@CrossOrigin
	@RequestMapping("/planning/list")
	@ResponseBody
	public String getPlanningVarieteList(@RequestParam("id_ligne") int id_ligne) {
		PlanningService planningService = new PlanningService();
		String planningListJson = planningService.getplanningsVariete(id_ligne);
		return planningListJson;		
	}
	
	@CrossOrigin
	@RequestMapping("/planning/insert")
	@ResponseBody
	public Boolean addPlanning(
			@RequestParam(value="debut_heure") String debut_heure,
			@RequestParam(value="fin_heure") String fin_heure,
			@RequestParam(value="id_frequence") int id_frequence,
			@RequestParam(value="ligne_irrigation") int ligne_irrigation) {
		
		if(timeControl(debut_heure,fin_heure)) {
			logger.warn("debut_heure : " +  debut_heure +" est plus grand que " + "fin_heure : " +fin_heure);
			return false;
		}else {
			logger.info("insert new planning : " + debut_heure + " " + fin_heure + " " + id_frequence + " " + ligne_irrigation);
			PlanningDto planning =  new PlanningDto(debut_heure, fin_heure, id_frequence, ligne_irrigation);
			PlanningService planningService= new PlanningService();
			boolean isInserted = planningService.addPlanning(planning);
			logger.info("requete validéé : " + isInserted);
			if(isInserted) {
				return true;
			}else {
				return false;
			}
		}
	}
	
	@CrossOrigin
	@RequestMapping("/planning/update")
	@ResponseBody
	public Boolean updatePlanning(
			@RequestParam(value="debut_heure") String debut_heure,
			@RequestParam(value="fin_heure") String fin_heure,
			@RequestParam(value="id_frequence") int id_frequence,
			@RequestParam(value="ligne_irrigation") int ligne_irrigation,
			@RequestParam(value="id_planning") int id_planning){
		
		if(timeControl(debut_heure,fin_heure)) {
			logger.warn("debut_heure : " +  debut_heure +" est plus grand que " + "fin_heure : " +fin_heure);
			return false;
		}
		else {
			logger.info("update parcel : " + debut_heure + " " + fin_heure + " " + id_frequence + " " + ligne_irrigation + " " + id_planning);
			PlanningDto planning =  new PlanningDto(debut_heure, fin_heure, id_frequence, ligne_irrigation, id_planning);
			PlanningService planningService= new PlanningService();
			boolean isUpdated = planningService.updatePlanning(planning);
			logger.info("requete validéé : " + isUpdated);
			if(isUpdated) {
				return true;
			}else {
				return false;
			}
		}
	}
		
	
	@CrossOrigin
	@RequestMapping("/planning/delete")
	@ResponseBody
	public Boolean deletePlanning(@RequestParam(value="id_planning") int id_planning){
		logger.info("delete planning : " + id_planning);
		PlanningService planningService= new PlanningService();
		boolean isDeleted = planningService.deletePlanning(id_planning);
		logger.info("requete validéé : " + isDeleted);
		if(isDeleted) {
			return true;
		}else {
			return false;
		}
	}
	
	/*
	 * Historique
	 */
	
	@CrossOrigin
	@RequestMapping("/history/list")
	@ResponseBody
	public String getHistoryList() {
		
		HistoryService historyService= new HistoryService();
		String historyListJson = historyService.getHistory();
		return historyListJson;	
	}
	
	/**
	 * parse une chaine dont le caractere de separation est "separateur", par default : "_";
	 * @param data
	 * 		une chaine de caractère
	 * @param separateur
	 * 		le caractère de séparation de la chaine <b>data</b>
	 * @return une nouvelle chaine de caractère
	 */
	public static String parseString(String data, String separateur) {
		String string = "";
		String[] tab = data.split(separateur);
		
		for(int i = 0; i<tab.length; i++) {
			if(tab[i]==tab[tab.length - 1]) {
				string += tab[i];
			}else {
				string += tab[i]+" ";
			}
		}
		return string;
	}
	
	public static boolean timeControl(String debut_heure, String fin_heure){
		DateFormat dateFormatter = new SimpleDateFormat("hh:mm");
		
		try {
			Date startingTime = dateFormatter.parse(debut_heure);
			Date endingTime = dateFormatter.parse(fin_heure);
			
			if(startingTime.compareTo(endingTime) > 0) {System.out.println("compare ok");
				return true;
			}
			else {System.out.println("compare no");
				return false;
			}
		}catch (ParseException e) {
			logger.warn(e.getMessage());
			return false;
		}
	}		
}
