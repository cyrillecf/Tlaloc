package com.aistos.tlaloc.data;

public class PlanningDto implements Dto{
		
		private int idSerre;
		private int ligneIrrigation;
		private String variete;
		private int idPlanning;
		private String debut_heure;
		private String fin_heure;
		private String labelFrequence;
		
		private int idFrequence;

		public PlanningDto(int ligneIrrigation, String variete, int idPlanning, String debut_heure, String fin_heure,
				String labelFrequence, int idFrequence, int idSerre) {
			super();
			this.ligneIrrigation = ligneIrrigation;
			this.variete = variete;
			this.idPlanning = idPlanning;
			this.debut_heure = debut_heure;
			this.fin_heure = fin_heure;
			this.labelFrequence = labelFrequence;
			this.idFrequence = idFrequence;
			this.idSerre = idSerre;
		}

		public PlanningDto(String debut_heure, String fin_heure, int idFrequence, int ligneIrrigation) {
			super();
			this.debut_heure = debut_heure;
			this.fin_heure = fin_heure;
			this.idFrequence = idFrequence;
			this.ligneIrrigation = ligneIrrigation;
		}

		public PlanningDto(String debut_heure, String fin_heure, int idFrequence, int ligneIrrigation, int idPlanning) {
			super();
			this.debut_heure = debut_heure;
			this.fin_heure = fin_heure;
			this.idFrequence = idFrequence;
			this.ligneIrrigation = ligneIrrigation;
			this.idPlanning = idPlanning;
		}
		
		public int getLigneIrrigation() {
			return ligneIrrigation;
		}

		public void setLigneIrrigation(int ligneIrrigation) {
			this.ligneIrrigation = ligneIrrigation;
		}

		public String getVariete() {
			return variete;
		}

		public void setVariete(String variete) {
			this.variete = variete;
		}

		public int getIdPlanning() {
			return idPlanning;
		}

		public void setIdPlanning(int idPlanning) {
			this.idPlanning = idPlanning;
		}

		public String getDebut_heure() {
			return debut_heure;
		}

		public void setDebut_heure(String debut_heure) {
			this.debut_heure = debut_heure;
		}

		public String getFin_heure() {
			return fin_heure;
		}

		public void setFin_heure(String fin_heure) {
			this.fin_heure = fin_heure;
		}

		public String getLabelFrequence() {
			return labelFrequence;
		}

		public void setLabelFrequence(String labelFrequence) {
			this.labelFrequence = labelFrequence;
		}

		public int getIdFrequence() {
			return idFrequence;
		}

		public void setIdFrequence(int idFrequence) {
			this.idFrequence = idFrequence;
		}

		public int getIdSerre() {
			return idSerre;
		}

		public void setIdSerre(int idSerre) {
			this.idSerre = idSerre;
		}

		
		
		
}
