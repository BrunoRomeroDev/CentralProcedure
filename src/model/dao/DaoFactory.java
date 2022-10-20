package model.dao;

import db.DB;
import model.dao.impl.ServiceDaoJDBC;
import model.dao.impl.UsuariosDaoJDBC;



public class DaoFactory {

	public static UsuariosDao createUsuarioDao() {
		return new UsuariosDaoJDBC(DB.getConnection());
	}
	
	public static ServicesDao execProcedure() {
		return new ServiceDaoJDBC(DB.getConnection());
		
	}
}
