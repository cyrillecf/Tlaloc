package com.aistos.tlaloc.data.dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.aistos.tlaloc.MainApplication;
import com.aistos.tlaloc.data.DataSource;
import com.aistos.tlaloc.data.Dto;
import com.aistos.tlaloc.data.PlanningDto;

public class PlanningDao implements Dao{
	
	private Log logger = LogFactory.getLog(MainApplication.class);
	private static String selectAllPlanningRequest = "select id_serre, ligne_irrigation.id_ligne_irrigation, variete,id_planning,  debut_heure, fin_heure, label_frequence, planning.id_frequence " + 
													 "from ligne_irrigation, planning, frequence " + 
													 "where ligne_irrigation.id_ligne_irrigation = planning.id_ligne_irrigation " + 
													 "and frequence.id_frequence = planning.id_frequence";
	
	private static String selectPlanningFromVarieteRequest = "select ligne_irrigation.id_ligne_irrigation, variete,id_planning,  debut_heure, fin_heure, planning.id_frequence, label_frequence, id_serre " +
													  "from ligne_irrigation, planning, frequence " +
													  "where ligne_irrigation.id_ligne_irrigation = planning.id_ligne_irrigation " +
													  "and frequence.id_frequence = planning.id_frequence " +
													  "and ligne_irrigation.id_ligne_irrigation = %d";
	
	private static String selectAllVarieteRequest = "select ligne_irrigation.id_ligne_irrigation, variete,id_planning, debut_heure, fin_heure, planning.id_frequence, label_frequence , id_serre " +
													" from ((ligne_irrigation " +
													" left join planning on ((ligne_irrigation.id_ligne_irrigation = planning.id_ligne_irrigation))) " +
													" left join frequence on ((planning.id_frequence = frequence.id_frequence))) ";
			
			
	private static String insertNewPlanningRequest = "insert into planning (id_planning,debut_heure,fin_heure,id_frequence,id_ligne_irrigation) values(NULL,'%s','%s',%d,%d)";
	private static String updatePlanningRequest = "update planning set debut_heure = '%s', fin_heure = '%s', id_frequence = %d, id_ligne_irrigation = %d where id_planning = %d";
	private static String deletePlanningRequest = "delete from planning where id_planning = %d";
	private static String deletePlanningRequestWithIrrigationLinrId = "delete from planning where id_ligne_irrigation = %d";
	@Override
	public List<?> list() {
		List<PlanningDto> listPlanningsDto = new ArrayList<PlanningDto>();
		try(Connection connection = DataSource.getInstance().getConnection()){
			
			Statement statement = connection.createStatement();	
			statement.execute(selectAllPlanningRequest);
			logger.info("requete : " + selectAllPlanningRequest);
			ResultSet  rs = statement.getResultSet();
			while(rs.next()) {
				PlanningDto currentPlanning = new PlanningDto(rs.getInt("ligne_irrigation.id_ligne_irrigation"),rs.getString("variete"),
															  rs.getInt("id_planning"), rs.getString("debut_heure"), rs.getString("fin_heure"),
															  rs.getString("label_frequence"), rs.getInt("planning.id_frequence"), rs.getInt("id_serre"));
				listPlanningsDto.add(currentPlanning);
			}
			
		} catch(SQLException e) {
			logger.error(e.getMessage());
		} catch(IOException e1) {
			logger.error(e1.getMessage());
		} catch(PropertyVetoException e1) {
			logger.error(e1.getMessage());
		}
		return listPlanningsDto;
	}
	
	
	public List<?> list(int id_ligne) {
		List<PlanningDto> listPlanningsDto = new ArrayList<PlanningDto>();
		try(Connection connection = DataSource.getInstance().getConnection()){
			String sql = "";
			if(id_ligne != 0) {
				sql = String.format(selectPlanningFromVarieteRequest, id_ligne);
			}else {
				sql = selectAllVarieteRequest;
			}

			Statement statement = connection.createStatement();
			
			statement.execute(sql);
			logger.info("requete : " + sql);
			ResultSet  rs = statement.getResultSet();
			while(rs.next()) {
				PlanningDto currentPlanning = new PlanningDto(rs.getInt("ligne_irrigation.id_ligne_irrigation"),rs.getString("variete"),
															  rs.getInt("id_planning"), rs.getString("debut_heure"), rs.getString("fin_heure"),
															  rs.getString("label_frequence"), rs.getInt("planning.id_frequence"), rs.getInt("id_serre"));
				listPlanningsDto.add(currentPlanning);
			}
		} catch(SQLException e) {
			logger.error(e.getMessage());
		} catch(IOException e1) {
			logger.error(e1.getMessage());
		} catch(PropertyVetoException e1) {
			logger.error(e1.getMessage());
		}
		return listPlanningsDto;
	}
	
	@Override
	public boolean insert(Dto dto) {
		int returnedValue = 0;
		PlanningDto planningDto = (PlanningDto) dto;
		try(Connection connection = DataSource.getInstance().getConnection()){
			Statement statement =  connection.createStatement();
			String sql = String.format(insertNewPlanningRequest,planningDto.getDebut_heure(),planningDto.getFin_heure(),planningDto.getIdFrequence(),planningDto.getLigneIrrigation());
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
		PlanningDto planningDto = (PlanningDto) dto;
		try(Connection connection = DataSource.getInstance().getConnection()){
			Statement statement =  connection.createStatement();
			String sql = String.format(updatePlanningRequest,planningDto.getDebut_heure(),planningDto.getFin_heure(),planningDto.getIdFrequence(),planningDto.getLigneIrrigation(),planningDto.getIdPlanning());
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
	public boolean delete(int i) {
		int returnedValue = 0;
		try(Connection connection = DataSource.getInstance().getConnection()){
			Statement statement =  connection.createStatement();
			String sql = String.format(deletePlanningRequest, i);
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
	
	
	public boolean deleteWithLigneIrrigation(int idLigneIrrigation) {
		int returnedValue = 0;
		try(Connection connection = DataSource.getInstance().getConnection()){
			Statement statement =  connection.createStatement();
			String sql = String.format(deletePlanningRequestWithIrrigationLinrId, idLigneIrrigation);
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
