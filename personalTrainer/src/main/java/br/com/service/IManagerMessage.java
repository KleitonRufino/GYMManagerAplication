package br.com.service;

import java.util.List;

import br.com.model.Message;

public interface IManagerMessage {
	
	public void save(Message message, Long idUser);
	public Message findMessageRecent(Long idUser);
	public List<Message> timeline(Long idUser);
	public List<Message> findAll();
	public void delete(Long idMessage);
}
