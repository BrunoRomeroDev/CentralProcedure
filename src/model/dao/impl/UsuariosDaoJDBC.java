package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import db.DB;
import db.DbException;
import model.dao.UsuariosDao;
import model.entities.Usuarios;

public class UsuariosDaoJDBC implements UsuariosDao {

	private Connection conn;
	
	public UsuariosDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public Usuarios findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT * FROM usuarios WHERE Id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Usuarios obj = new Usuarios();
				obj.setId(rs.getInt("Id"));
				obj.setName(rs.getString("Name"));
				return obj;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Usuarios> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT * FROM usuarios ORDER BY Name");
			rs = st.executeQuery();

			List<Usuarios> list = new ArrayList<>();

			while (rs.next()) {
				Usuarios obj = new Usuarios();
				obj.setId(rs.getInt("Id"));
				obj.setName(rs.getString("Name"));
				list.add(obj);
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	
	@Override
	 public boolean checkLogin(String login, String senha) {
		PreparedStatement st = null;
		ResultSet rs = null;
		boolean check = false;

        try {

            st = conn.prepareStatement("SELECT NOME,SENHA FROM aac_usuarios WHERE NOME = ? AND SENHA = ?");
            st.setString(1, login);
            st.setString(2, senha);

            rs = st.executeQuery();

            if (rs.next()) {

                check = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        	DB.closeStatement(st);
        	DB.closeResultSet(rs);
        }

        return check;

    }
}
