package model.dao;

import java.util.List;

import model.entities.Usuarios;

public interface UsuariosDao {

	
	Usuarios findById(Integer id);
	List<Usuarios> findAll();
	boolean checkLogin(String text, String text2);
}
