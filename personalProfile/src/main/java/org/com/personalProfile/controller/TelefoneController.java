package org.com.personalProfile.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.com.personalProfile.entity.Telefone;
import org.com.personalProfile.entity.Usuario;
import org.com.personalProfile.model.TelefoneModel;
import org.com.personalProfile.utils.UtilUsuario;

@WebServlet(urlPatterns = {"/telefones"})
public class TelefoneController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2550383676190259228L;
	
	private TelefoneModel telefoneModel;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("searchAction");
		if (action != null) {
			if(action.equals("buscaTelefoneById")){
				buscaTelefoneById(req, resp);
			}else if(action.equals("buscaByItem")){
				buscaTelefoneByQuery(req, resp);
			}
		} else {
			List<Telefone> result = getTelefoneModel().buscaTelefoneByQuery(null, UtilUsuario.getUsusarioLogado(req));  
			forwardListTelefones(req, resp, result);
		}
	}
	
    private void buscaTelefoneById(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        long idTelefone = Long.valueOf(req.getParameter("idTelefone"));
        Telefone telefone = null;
        try {
        	telefone = getTelefoneModel().buscaTelefoneById(idTelefone);
        } catch (Exception ex) {
            Logger.getLogger(TelefoneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        req.setAttribute("telefone", telefone);
        req.setAttribute("acaoTela", "adicionarAlterar");
        String nextJSP = "/pages/personalTelefoneAdd.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(req, resp);
    }
    
    private void buscaTelefoneByQuery(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String query = req.getParameter("queryItem");
        List<Telefone> result = getTelefoneModel().buscaTelefoneByQuery(query, UtilUsuario.getUsusarioLogado(req));
        forwardListTelefones(req, resp, result);
    }
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("acaoTela");
		String actionNovo = req.getParameter("acaoNovo");
		if(actionNovo== null || (actionNovo != null && actionNovo.equals(""))){
		    if(action.equals("adicionarAlterar")){
		    	String idTelefone = req.getParameter("idTelefone");
		    	if(idTelefone == null || (idTelefone != null && idTelefone.equals(""))){
		    		adicionarTelefone(req, resp);
		    	}else{
		    		editarLivro(req, resp);
		    	}
		    }else if(action.equals("remover")){
		    	removerTelefone(req, resp);
		    }
		}else if(actionNovo.equals("novo")){
	    	String nextJSP = "/pages/personalTelefoneAdd.jsp";
	        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
	        dispatcher.forward(req, resp);
	    }
	}
	
    private void adicionarTelefone(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String nomePessoa = req.getParameter("nomePessoa");
        String numero = req.getParameter("numero");
        String email = req.getParameter("email");
        
        Telefone telefone = new Telefone(nomePessoa, numero, email, UtilUsuario.getUsusarioLogado(req).getId());
        
        boolean salvou = getTelefoneModel().salvarAlterarTelefone(telefone);
        
        List<Telefone> result = getTelefoneModel().buscaTelefoneByUsuarioId(UtilUsuario.getUsusarioLogado(req).getId());  
        if(salvou){
	        req.setAttribute("idTelefone", telefone.getId());
	        req.setAttribute("message", "Telefone salvo com sucesso!");
	        req.setAttribute("message", "Telefone salvo com sucesso!");
	        forwardListTelefones(req, resp, result);
        }else{
	        req.setAttribute("message", "Erro ao salvar telefone!");
        }
        
    }

    private void editarLivro(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	String nomePessoa = req.getParameter("nomePessoa");
        String numero = req.getParameter("numero");
        String email = req.getParameter("email");
        
        long idTelefone = Integer.valueOf(req.getParameter("idTelefone"));
        
        Telefone telefone = new Telefone(idTelefone,nomePessoa, numero, email, UtilUsuario.getUsusarioLogado(req).getId());
        
        
        boolean salvou = getTelefoneModel().salvarAlterarTelefone(telefone);
        
        List<Telefone> result = getTelefoneModel().buscaTelefoneByUsuarioId(UtilUsuario.getUsusarioLogado(req).getId());  
        if(salvou){
        	req.setAttribute("idTelefone", telefone.getId());
        	req.setAttribute("message", "Telefone alterado com sucesso!");
        	forwardListTelefones(req, resp, result);
        }else{
        	req.setAttribute("message", "Erro ao alterar telefone!");
        }
    } 
    
    private void removerTelefone(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        long idTelefone = Integer.valueOf(req.getParameter("idTelefone"));
        getTelefoneModel().removerTelefone(idTelefone);
        req.setAttribute("message", "Telefone removido com sucesso!");
        Usuario usuario = UtilUsuario.getUsusarioLogado(req);
        List<Telefone> result = getTelefoneModel().buscaTelefoneByUsuarioId(usuario.getId());  
        forwardListTelefones(req, resp, result);
    }
    
    private void forwardListTelefones(HttpServletRequest req, HttpServletResponse resp, List<Telefone> listTelefones)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/personalTelefone.jsp");
        req.setAttribute("listTelefones", listTelefones);
        dispatcher.forward(req, resp);
    }
	
	
	public TelefoneModel getTelefoneModel() {
		if(telefoneModel == null){
			telefoneModel = new TelefoneModel();
		}
		return telefoneModel;
	}

	public void setTelefoneModel(TelefoneModel telefoneModel) {
		this.telefoneModel = telefoneModel;
	}
	
}
