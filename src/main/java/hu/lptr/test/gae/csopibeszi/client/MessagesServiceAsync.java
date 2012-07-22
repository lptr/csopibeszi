package hu.lptr.test.gae.csopibeszi.client;

import hu.lptr.test.gae.csopibeszi.model.Message;

import java.util.List;


import com.google.gwt.user.client.rpc.AsyncCallback;

public interface MessagesServiceAsync {

    void getAll(AsyncCallback<List<Message>> callback);

    void create(Message message, AsyncCallback<Void> callback);

    void deleteById(Long id, AsyncCallback<Void> callback);

}
