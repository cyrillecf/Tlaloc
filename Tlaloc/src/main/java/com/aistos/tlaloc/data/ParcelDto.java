package com.aistos.tlaloc.data;

public class ParcelDto implements Dto{

	private int ligneIrrigation;
	private String variete;
	private int idSerre;
	private String labelSerre;
	private String commentaire;
	
	public ParcelDto(int ligneIrrigation, String variete 
					 ,String labelSerre, int idSerre, String commentaire) {
		super();
		this.ligneIrrigation = ligneIrrigation;
		this.variete = variete;
		this.idSerre = idSerre;
		this.labelSerre = labelSerre;
		this.commentaire = commentaire;
	}
	
	
	public ParcelDto(String variete, int ligneIrrigation,int idSerre) {
		super();
		this.variete = variete;
		this.idSerre = idSerre;
		this.ligneIrrigation = ligneIrrigation;
	}
	
	public ParcelDto(String variete, int ligneIrrigation) {
		super();
		this.variete = variete;
		this.ligneIrrigation = ligneIrrigation;
	}


	public String getLabelSerre() {
		return labelSerre;
	}
	public void setLabelSerre(String labelSerre) {
		this.labelSerre = labelSerre;
	}
	public String getVariete() {
		return variete;
	}
	public void setVariete(String variete) {
		this.variete = variete;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public int getIdSerre() {
		return idSerre;
	}
	public void setIdSerre(int idSerre) {
		this.idSerre = idSerre;
	}
	public int getLigneIrrigation() {
		return ligneIrrigation;
	}
	public void setLigneIrrigation(int ligneIrrigation) {
		this.ligneIrrigation = ligneIrrigation;
	}
	

}
