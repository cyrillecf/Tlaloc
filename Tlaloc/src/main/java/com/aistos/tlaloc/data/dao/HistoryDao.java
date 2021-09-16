package com.aistos.tlaloc.data.dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.aistos.tlaloc.MainApplication;
import com.aistos.tlaloc.data.DataSource;
import com.aistos.tlaloc.data.Dto;
import com.aistos.tlaloc.data.HistoryDto;


public class HistoryDao implements Dao{

	private Log logger = LogFactory.getLog(MainApplication.class);
	private static String selectHistoryRequest = "SELECT id_historique,historique.id_ligne_irrigation,variete, historique.id_statut,label_statut, " + 
												 "date ,debut_heure,fin_heure " + 
												 "FROM historique,ligne_irrigation,statut " + 
												 "WHERE ligne_irrigation.id_ligne_irrigation = historique.id_ligne_irrigation " +
												 "and historique.id_statut = statut.id_statut " + 
												 "and historique.date >= date_sub(curdate(),interval %d day)";
	
	private static String insertNewHistoryRequest = "insert into historique (id_historique,date,debut_heure,fin_heure,id_serre,id_ligne_irrigation,id_statut) "+
													"values(NULL,now(),'%s','%s',%d,%d,%d);";
	
	private static String updateHistoryRequest = "update  historique set debut_heure = '%s', fin_heure = '%s', id_statut = %d where id_historique = %d";
	
	private static String deletetHistoryRequest = "DELETE FROM historique WHERE id_ligne_irrigation = %d";
	
	
	@Override	
	public List<?> list(){
		DateFormat df = new SimpleDateFormat("dd/MM/YY hh:mm:ss");
		List<HistoryDto> listHistoryDto = new ArrayList<HistoryDto>();
		try(Connection connection = DataSource.getInstance().getConnection()){
			Statement stmt = connection.createStatement();
			String sql = String.format(selectHistoryRequest, 30);
			ResultSet  rs = stmt.executeQuery(sql);
			while(rs.next()) {
				HistoryDto currentHistory = new HistoryDto(
						rs.getInt("id_historique"),
						rs.getInt("id_ligne_irrigation"),
						rs.getString("variete"),
						rs.getInt("id_statut"),
						rs.getString("label_statut"),
						rs.getString("debut_heure"), 
						rs.getString("fin_heure"),
						df.format(rs.getDate("date")))// date fr
						;
				listHistoryDto.add(currentHistory);
			}
			stmt.close();
			rs.close();
		} catch(SQLException e) {
			logger.error(e.getMessage());
		} catch(IOException e1) {
			logger.error(e1.getMessage());
		} catch(PropertyVetoException e1) {
			logger.error(e1.getMessage());
		}
		return listHistoryDto;
	}
	
	@Override
	public boolean insert(Dto dto) {
		int returnedValue = 0;
		HistoryDto historyDto = (HistoryDto) dto;
		try(Connection connection = DataSource.getInstance().getConnection()){
			Statement statement = connection.createStatement();
			String sql = String.format(insertNewHistoryRequest,
					historyDto.getDebutHeure(),
					historyDto.getFinHeure(),
					historyDto.getIdSerre(),
					historyDto.getIdLigneIrrigation(),
					historyDto.getIdStatut());
			logger.info("requete : " + sql);
			returnedValue = statement.executeUpdate(sql);
			statement.close();
		} catch(SQLException e) {
			logger.error(e.getMessage());
		} catch(IOException e1) {
			logger.error(e1.getMessage());
		} catch(PropertyVetoException e1) {
			logger.error(e1.getMessage());
		}
		return returnedValue == 1;
	}

	@Override
	public boolean update(Dto dto) {
		int returnedValue = 0;
		HistoryDto historyDto = (HistoryDto) dto;
		try(Connection connection = DataSource.getInstance().getConnection()){
			Statement statement = connection.createStatement();
			String sql = String.format(updateHistoryRequest,
					historyDto.getDebutHeure(),
					historyDto.getFinHeure(),
					historyDto.getIdStatut(),
					historyDto.getIdHistorique());
			logger.info("requete : " + sql);
			returnedValue = statement.executeUpdate(sql);
			statement.close();
		} catch(SQLException e) {
			logger.error(e.getMessage());
		} catch(IOException e1) {
			logger.error(e1.getMessage());
		} catch(PropertyVetoException e1) {
			logger.error(e1.getMessage());
		}
		return returnedValue == 1;
	}
	

	@Override
	public boolean delete(int idLigneIrrigation) {
		
		int returnedValue = 0;
		try(Connection connection = DataSource.getInstance().getConnection()){
			Statement statement =  connection.createStatement();
			String sql = String.format(deletetHistoryRequest, idLigneIrrigation);
			logger.info("requete : " + sql);
			returnedValue = statement.executeUpdate(sql);
			statement.close();
		} catch(SQLException e) {
			logger.error(e.getMessage());
		} catch(IOException e1) {
			logger.error(e1.getMessage());
		} catch(PropertyVetoException e1) {
			logger.error(e1.getMessage());
		}
		return returnedValue == 1;
	}


}
