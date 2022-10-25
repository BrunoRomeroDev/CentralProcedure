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
	public void execProcedurePMSVAcesso(Integer chapa, String intruso) {
		PreparedStatement cs = null;
		Integer rs = null;
		try {
			
			cs = conn.prepareCall(
					"CALL public.pmsv_acessos_c065_c012_sp(?)");
			
				cs.setInt(1, chapa);

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
			
			cs = conn.prepareStatement("SELECT\r\n"
					+ "        uc.codigo_usuario,\r\n"
					+ "        au.nome,\r\n"
					+ "        au.senha\r\n"
					+ "      FROM\r\n"
					+ "        aac_usuario_complemento uc\r\n"
					+ "      left join\r\n"
					+ "        aac_usuarios au on au.codigo_usuario = uc.codigo_usuario\r\n"
					+ "      WHERE\r\n"
					+ "        uc.chapa = ?");
			cs.setInt(1, chapa);
			rs = cs.executeQuery();
			rs.next();
				
			JOptionPane.showMessageDialog(null,"Nome: "+rs.getString("NOME").trim()+" \r\nCódigo: " +rs.getString("CODIGO_USUARIO").trim());
			
				
		}catch (SQLException e){
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(cs);
			DB.closeResultSet(rs);
		}
		
	}


	@Override
	public void execProcedurePMSVDerruba(String login) {
		PreparedStatement cs = null;
		ResultSet rs = null;
		try {
			
			cs = conn.prepareStatement(
					"execute procedure PMSV_DERRUBA_SESSAO (?)");
			
				cs.setString(1, login);

				rs = cs.executeQuery() ;
				
					JOptionPane.showMessageDialog(null, " Executado com Sucesso!!!");
				
		}catch (SQLException e){
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(cs);
			DB.closeResultSet(rs);
		}
		
	}


}
