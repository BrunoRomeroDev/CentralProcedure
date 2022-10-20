package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import db.DB;
import db.DbException;
import model.dao.ServicesDao;

public class ServiceDaoJDBC implements ServicesDao{
	
	private Connection conn; 
	
	public ServiceDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	
	@Override
	public void execProcedurePMSV_ACESSO(Integer chapa,String intruso) {
		PreparedStatement cs = null;
		Integer rs = null;
		try {
			
			cs = conn.prepareCall(
					"CALL public.pmsv_acessos_c065_c012_sp(?,?)");
			
				cs.setInt(1, chapa);
				cs.setString(2, intruso);
				rs = cs.executeUpdate();
				
					JOptionPane.showMessageDialog(null,rs.toString()+ " Executado com Sucesso!!!");
				
		}catch (SQLException e){
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(cs);
			
		}
		
	}



	@Override
	public void ConsultaAcesso(Integer chapa) {
		PreparedStatement cs = null;
		ResultSet rs = null;
		try {
			
			cs = conn.prepareCall("SELECT * FROM public.aac_acessos_usuario limit 10");
			rs = cs.executeQuery();
				
			JOptionPane.showMessageDialog(null,rs.toString()+ " Executado com Sucesso!!!");
			
				
		}catch (SQLException e){
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(cs);
			DB.closeResultSet(rs);
		}
		
	}


	@Override
	public void execProcedurePMSV_SESSAO(Integer chapa) {
		
		
	}


}
