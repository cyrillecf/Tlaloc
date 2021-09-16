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
import com.aistos.tlaloc.data.ParcelDto;


public class ParcelDao implements Dao{
	
	private Log logger = LogFactory.getLog(MainApplication.class);
	private static String selectAllParcelRequest = "SELECT id_ligne_irrigation, variete, serre.id_serre, label_serre, commentaire FROM serre, ligne_irrigation WHERE serre.id_serre = ligne_irrigation.id_serre";
	private static String insertNewParcelRequest = "insert into ligne_irrigation(variete, id_ligne_irrigation, id_serre) values('%s' ,%d , %d)";
	private static String updateParcelRequest = "update ligne_irrigation set variete = '%s'where id_ligne_irrigation = '%d'";
	private static String deleteParcelRequest = "delete from ligne_irrigation where id_ligne_irrigation = %d";
	
	@Override
	public List<?> list() {
		List<ParcelDto> listParcelsDto = new ArrayList<ParcelDto>();
		try(Connection connection = DataSource.getInstance().getConnection()){
			Statement statement = connection.createStatement();	
			statement.execute(selectAllParcelRequest);
			logger.info("requete : " + selectAllParcelRequest);
			ResultSet  rs = statement.getResultSet();
			while(rs.next()) {
				ParcelDto currentParcel = new ParcelDto(rs.getInt("id_ligne_irrigation"),rs.getString("variete"),
						rs.getString("label_serre"),rs.getInt("serre.id_serre"),rs.getString("commentaire"));
				listParcelsDto.add(currentParcel);
			}
			statement.close();
			rs.close();
		} catch(SQLException e) {
			logger.error(e.getMessage());
		} catch(IOException e1) {
			logger.error(e1.getMessage());
		} catch(PropertyVetoException e1) {
			logger.error(e1.getMessage());
		}
		return listParcelsDto;
	}

	@Override
	public boolean insert(Dto dto) {
		int returnedValue = 0;
		ParcelDto parcelDto = (ParcelDto) dto;
		try(Connection connection = DataSource.getInstance().getConnection()) {
			Statement statement = connection.createStatement();
			String sql = String.format(insertNewParcelRequest,parcelDto.getVariete(), parcelDto.getLigneIrrigation(), parcelDto.getIdSerre());
			logger.info("requete : "+ sql);
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
		ParcelDto parcelDto = (ParcelDto) dto;
		try(Connection connection = DataSource.getInstance().getConnection()) {
			Statement statement = connection.createStatement();
			String sql = String.format(updateParcelRequest,parcelDto.getVariete(),/*parcelDto.getIdSerre(),*/parcelDto.getLigneIrrigation());
			logger.info("requete : "+ sql);
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
		try(Connection connection = DataSource.getInstance().getConnection()) {
			Statement statement = connection.createStatement();
			String sql = String.format(deleteParcelRequest,i);
			logger.info("requete : "+ sql);
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
