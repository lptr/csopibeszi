package hu.lptr.test.gae.csopibeszi.client;

import hu.lptr.test.gae.csopibeszi.model.Messages;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("messages")
public interface MessagesService extends RemoteService, Messages {
    // marker interface
}
