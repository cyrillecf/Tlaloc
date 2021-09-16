package com.aistos.tlaloc.data;

import java.sql.Date;

public class HistoryDto implements Dto{
	
	private String dateFR;
	private int idHistorique;
	private String labelSerre;
	private int idLigneIrrigation;
	private String labelStatut;
	private int idStatut;
	private int idSerre;
	private Date date;
	private String debutHeure;
	private String finHeure;
	private String variete;
	
	public HistoryDto(String debutHeure, String finHeure, int idSerre, int ligneIrrigation, int idStatut) {
		super();
		this.debutHeure = debutHeure;
		this.finHeure = finHeure;
		this.idSerre = idSerre;
		this.idLigneIrrigation = ligneIrrigation;
		this.idStatut = idStatut;
	}

	
	public HistoryDto(int idHistorique, int idLigneIrrigation, String variete, int idStatut, String labelStatut,
			String debutHeure, String finHeure, String dateFR) {
		super();
		this.idHistorique = idHistorique;
		
		this.idLigneIrrigation = idLigneIrrigation;
		this.idStatut = idStatut;
		this.labelStatut = labelStatut;
		this.debutHeure = debutHeure;
		this.finHeure = finHeure;
		this.dateFR = dateFR;
		this.variete = variete;
	}
	
	public HistoryDto(String debutHeure, String finHeure, int idStatut, int idHistorique ) {
		super();
		this.debutHeure = debutHeure;
		this.finHeure = finHeure;
		this.idStatut = idStatut;
		this.idHistorique = idHistorique;
	}

	public int getIdHistorique() {
		return idHistorique;
	}



	public void setIdHistorique(int idHistorique) {
		this.idHistorique = idHistorique;
	}



	public String getLabelSerre() {
		return labelSerre;
	}



	public void setLabelSerre(String labelSerre) {
		this.labelSerre = labelSerre;
	}



	public int getIdLigneIrrigation() {
		return idLigneIrrigation;
	}



	public void setIdLigneIrrigation(int idLigneIrrigation) {
		this.idLigneIrrigation = idLigneIrrigation;
	}



	public String getLabelStatut() {
		return labelStatut;
	}



	public void setLabelStatut(String labelStatut) {
		this.labelStatut = labelStatut;
	}



	public int getIdStatut() {
		return idStatut;
	}



	public void setIdStatut(int idStatut) {
		this.idStatut = idStatut;
	}



	public int getIdSerre() {
		return idSerre;
	}



	public void setIdSerre(int idSerre) {
		this.idSerre = idSerre;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public String getDebutHeure() {
		return debutHeure;
	}



	public void setDebutHeure(String debutHeure) {
		this.debutHeure = debutHeure;
	}



	public String getFinHeure() {
		return finHeure;
	}



	public void setFinHeure(String finHeure) {
		this.finHeure = finHeure;
	}



	public String getDateFR() {
		return dateFR;
	}



	public void setDateFR(String dateFR) {
		this.dateFR = dateFR;
	}


	public String getVariete() {
		return variete;
	}


	public void setVariete(String variete) {
		this.variete = variete;
	}
	
	
	
}
