package br.com.fiap.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import br.com.fiap.model.BandaModel;
import br.com.fiap.model.IntegranteModel;
import br.com.fiap.model.AlbumModel;


public class BandaRowMapper implements RowMapper<BandaModel> {

	@Override
	public BandaModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		IntegranteModel integrante = new BeanPropertyRowMapper<>(IntegranteModel.class).mapRow(rs,  rowNum);
		
		AlbumModel album = new BeanPropertyRowMapper<>(AlbumModel.class).mapRow(rs, rowNum);
		
		BandaModel banda = new BeanPropertyRowMapper<>(BandaModel.class).mapRpw(rs, rowNum);
		
		
		
	}
	
	
	
}
