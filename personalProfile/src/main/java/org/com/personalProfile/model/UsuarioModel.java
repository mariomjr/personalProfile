package org.com.personalProfile.model;

import org.com.personalProfile.dao.UsuarioDao;
import org.com.personalProfile.entity.Usuario;

public class UsuarioModel {
	
	private UsuarioDao usuarioDao;

	public Usuario buscaUsuarioByLogin(String login){
		return getUsuarioDao().buscaUsuarioByLogin(login);
	}
	
	public boolean salvarUsuario(Usuario usuario){
		try{
			getUsuarioDao().salvarUsuario(usuario);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	
	public UsuarioDao getUsuarioDao() {
		if(usuarioDao == null){
			usuarioDao = new UsuarioDao();
		}
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
}
