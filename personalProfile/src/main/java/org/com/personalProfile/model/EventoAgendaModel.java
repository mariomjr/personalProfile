package org.com.personalProfile.model;

import java.sql.SQLException;
import java.util.List;

import org.com.personalProfile.dao.EventoAgendaDao;
import org.com.personalProfile.entity.EventoAgenda;

public class EventoAgendaModel {

	
	private EventoAgendaDao eventoAgendaDao;

	
	public EventoAgenda buscaEventoAgendaById(Long id){
		return getEventoAgendaDao().buscaEventoAgendaById(id);
	}

	public List<EventoAgenda> buscaEventoAgendaByUsuarioId(Long usuarioId) {
		return getEventoAgendaDao().buscaEventoAgendaByUsuarioId(usuarioId);
	}
	
	public boolean salvarAlterarEventoAgenda(EventoAgenda eventoAgenda){
		return getEventoAgendaDao().salvarAlterarEventoAgenda(eventoAgenda);
	}
	
	public boolean removerEventoAgenda(Long id) throws SQLException{
		return getEventoAgendaDao().removerEventoAgenda(id);
	}
	
	public EventoAgendaDao getEventoAgendaDao() {
		if(eventoAgendaDao == null){
			eventoAgendaDao = new EventoAgendaDao();
		}
		return eventoAgendaDao;
	}

	public void setEventoAgendaDao(EventoAgendaDao eventoAgendaDao) {
		this.eventoAgendaDao = eventoAgendaDao;
	}
	
}
