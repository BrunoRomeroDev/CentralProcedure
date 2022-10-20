package model.dao;

import java.util.List;

import model.entities.Usuarios;

public interface UsuariosDao {

	void insert(Usuarios obj);
	void update(Usuarios obj);
	void deleteById(Integer id);
	Usuarios findById(Integer id);
	List<Usuarios> findAll();
	boolean checkLogin(String text, String text2);
}
