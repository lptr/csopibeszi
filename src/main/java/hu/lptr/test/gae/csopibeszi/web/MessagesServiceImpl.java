package hu.lptr.test.gae.csopibeszi.web;

import hu.lptr.test.gae.csopibeszi.client.MessagesService;
import hu.lptr.test.gae.csopibeszi.model.Message;
import hu.lptr.test.gae.csopibeszi.model.Messages;

import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
@Singleton
public class MessagesServiceImpl extends RemoteServiceServlet implements
        MessagesService {

    @Inject private Messages messageRepository;

    @Override
    public void create(Message message) {
        messageRepository.create(message);
    }

    @Override
    public void deleteById(Long id) {
        messageRepository.deleteById(id);
    }

    @Override
    public Collection<Message> getAll() {
        return messageRepository.getAll();
    }
}
