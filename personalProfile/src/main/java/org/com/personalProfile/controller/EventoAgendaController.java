package org.com.personalProfile.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.com.personalProfile.entity.EventoAgenda;
import org.com.personalProfile.entity.Usuario;
import org.com.personalProfile.model.EventoAgendaModel;
import org.com.personalProfile.utils.UtilUsuario;

@WebServlet(urlPatterns = { "/personalAgenda" })
public class EventoAgendaController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1246319857538189474L;
	
	private EventoAgendaModel eventoAgendaModel;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher;
		dispatcher = getServletContext().getRequestDispatcher("/pages/personalAgenda.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
	    if(action.equals("adicionar")){
	    	try {
				adicionarEventoAgenda(req, resp);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }else if(action.equals("editar")){
	    	try {
				editarEventoAgenda(req, resp);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }else if(action.equals("remover")){
	    	try {
				removerEventoAgenda(req, resp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	}


	private void adicionarEventoAgenda(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, ParseException {
		String nomeEvento = req.getParameter("nomeEvento");
		String localEvento = req.getParameter("localEvento");
		String dataEventoString =  req.getParameter("dataEvento");
		SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");
        Date dataEvento = (Date) formatoData.parse(dataEventoString);
		String horarioEvento = req.getParameter("horarioEvento");
		String usuarioId = req.getParameter("usuarioId");

		EventoAgenda eventoAgenda = new EventoAgenda(nomeEvento, localEvento, dataEvento, horarioEvento, Long.valueOf(usuarioId));

		getEventoAgendaModel().salvarAlterarEventoAgenda(eventoAgenda);

		List<EventoAgenda> result = getEventoAgendaModel().buscaEventoAgendaByUsuarioId(Long.valueOf(usuarioId));
		req.setAttribute("idEventoAgenda", eventoAgenda.getId());
		req.setAttribute("message", "Evento salvo com sucesso!");
		forwardListEventoAgenda(req, resp, result);

	}

    private void editarEventoAgenda(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException, ParseException {
    	String nomeEvento = req.getParameter("nomeEvento");
        String localEvento = req.getParameter("localEvento");
        String dataEventoString =  req.getParameter("dataEvento");
		SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");
        Date dataEvento = (Date) formatoData.parse(dataEventoString);
        String horarioEvento = req.getParameter("horarioEvento");
        String usuarioId = req.getParameter("usuarioId");
        long idEventoAgenda = Integer.valueOf(req.getParameter("idEventoAgenda"));
        
        EventoAgenda eventoAgenda = new EventoAgenda(idEventoAgenda ,nomeEvento, localEvento, dataEvento, horarioEvento, Long.valueOf(usuarioId));
        
        getEventoAgendaModel().salvarAlterarEventoAgenda(eventoAgenda);
        
        List<EventoAgenda> result = getEventoAgendaModel().buscaEventoAgendaByUsuarioId(Long.valueOf(usuarioId));  
        req.setAttribute("idEventoAgenda", eventoAgenda.getId());
        req.setAttribute("message", "Evento alterado com sucesso!");
        forwardListEventoAgenda(req, resp, result);
    } 
    
    private void removerEventoAgenda(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException, SQLException {
        long idEventoAgenda = Integer.valueOf(req.getParameter("idEventoAgenda"));
        getEventoAgendaModel().removerEventoAgenda(idEventoAgenda);
        req.setAttribute("message", "Evento removido com sucesso!");
        Usuario usuario = UtilUsuario.getUsusarioLogado(req);
        List<EventoAgenda> result = getEventoAgendaModel().buscaEventoAgendaByUsuarioId(usuario.getId());  
        forwardListEventoAgenda(req, resp, result);
    }
    
    private void forwardListEventoAgenda(HttpServletRequest req, HttpServletResponse resp, List<EventoAgenda> listEventoAgenda)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/personalTelefone.jsp");
        req.setAttribute("listTelefones", listEventoAgenda);
        dispatcher.forward(req, resp);
    }
	
	
	public EventoAgendaModel getEventoAgendaModel() {
		if(eventoAgendaModel == null){
			eventoAgendaModel = new EventoAgendaModel();
		}
		return eventoAgendaModel;
	}

	public void setEventoAgendaModel(EventoAgendaModel eventoAgendaModel) {
		this.eventoAgendaModel = eventoAgendaModel;
	}
	
	private void logout(HttpServletRequest req, HttpServletResponse resp) {

	}

	private void autenticarUsuario(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession(true);
		// session.setAttribute("usuarioLogado", getLogin());
	}
}
