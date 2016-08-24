package org.com.personalProfile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.com.personalProfile.entity.Usuario;
import org.com.personalProfile.utils.ConnectionFactory;

public class UsuarioDao {

	public Usuario buscaUsuarioByLogin(String login) {
			
		Connection conn = null;
		StringBuilder sql = new StringBuilder();
		try {
			conn = ConnectionFactory.createConnection();
			
			sql.append(" select id, nome, endereco,telefone, email, login, senha  from usuario  where login = ?");
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, login);
			ResultSet rs = ps.executeQuery();
			Usuario usuario;
			if(rs.next()){
				usuario = new Usuario();
				usuario.setId(rs.getLong("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setTelefone(rs.getString("telefone"));
				usuario.setEndereco(rs.getString("endereco"));
				usuario.setEmail(rs.getString("email"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				return usuario;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public void salvarUsuario(Usuario usuario) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			StringBuilder sql = new StringBuilder();
			sql.append(" update usuario set nome = ?, endereco = ? , telefone = ?, email=? where id = ?");
			ps = conn.prepareStatement(sql.toString());
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getEndereco());
			ps.setString(3, usuario.getTelefone());
			ps.setString(4, usuario.getEmail());
			ps.setLong(5, usuario.getId());
			ps.executeUpdate();
			
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		}finally{
			if(ps!= null){
				ps.close();
			}
			if(conn != null){
				conn.close();
			}
		}
		
	}

}
