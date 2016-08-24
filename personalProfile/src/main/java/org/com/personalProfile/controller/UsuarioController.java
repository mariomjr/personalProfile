package org.com.personalProfile.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.com.personalProfile.entity.Usuario;
import org.com.personalProfile.model.UsuarioModel;
import org.com.personalProfile.utils.UtilUsuario;

@WebServlet(urlPatterns = {"/usuarioLogin"})
public class UsuarioController extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 105878987583278746L;
	
	private UsuarioModel usuarioModel;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		String action = req.getParameter("action");
		if(action== null || (action!= null && action.equals(""))){
			if(UtilUsuario.getUsusarioLogado(req)!= null){
				dispatcher = getServletContext().getRequestDispatcher("/pages/personalProfile.jsp");
			    req.setAttribute("usuario", UtilUsuario.getUsusarioLogado(req));
			}else{
				dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			}
		}else if(action.equals("sair")){
			UtilUsuario.invalidadeSession(req);
			dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
		}
		dispatcher.forward(req, resp);
	}

	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
    		throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action.equals("autenticar")){
            autenticarUsuario(req, resp);
        }else if(action.equals("salvarProfile")){
        	salvarProfile(req, resp);
        }
	}
	
	private void salvarProfile(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	String nome = req.getParameter("nome");
        String endereco = req.getParameter("endereco");
        String telefone = req.getParameter("telefone");
        String email = req.getParameter("email");
        
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEndereco(endereco);
        usuario.setTelefone(telefone);
        usuario.setEmail(email);
        usuario.setId(UtilUsuario.getUsusarioLogado(req).getId());
        
        getUsuarioModel().salvarUsuario(usuario);
        
        req.setAttribute("message", "Profile salvo");
        req.setAttribute("usuario", usuario);
        UtilUsuario.setUsusarioLogado(req, usuario);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/personalProfile.jsp");
        dispatcher.forward(req, resp);
    } 

	private void autenticarUsuario(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String login = req.getParameter("login");
        String senha = req.getParameter("senha");
        RequestDispatcher dispatcher;
        if(login != null && senha != null){
	        Usuario usuario = getUsuarioModel().buscaUsuarioByLogin(login);
	        
	        if(usuario != null && senha.equals(usuario.getSenha())){
	        	UtilUsuario.setUsusarioLogado(req, usuario);	
				dispatcher = getServletContext().getRequestDispatcher("/pages/personalProfile.jsp");
			    req.setAttribute("usuario", usuario);
	        }else{
	        	dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
	        	req.setAttribute("message", "Usuário ou senha incorreto!");
	        }
        }else{
        	dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
        	req.setAttribute("message", "Insira usuário ou senha!");
        }
        
        dispatcher.forward(req, resp);
       
	}

	public UsuarioModel getUsuarioModel() {
		if(usuarioModel == null){
			usuarioModel = new UsuarioModel();
		}
		return usuarioModel;
	}

	public void setUsuarioModel(UsuarioModel usuarioModel) {
		this.usuarioModel = usuarioModel;
	}
	
}
