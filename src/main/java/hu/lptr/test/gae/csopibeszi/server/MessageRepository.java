package hu.lptr.test.gae.csopibeszi.server;

import hu.lptr.test.gae.csopibeszi.model.Message;
import hu.lptr.test.gae.csopibeszi.model.Messages;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Provider;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

@Singleton
@Transactional
public class MessageRepository implements Messages {

	@Inject
	private Provider<EntityManager> em;

	/**
	 * @see hu.lptr.test.gae.csopibeszi.model.Messages#getAll()
	 */
	public Collection<Message> getAll() {
		CriteriaBuilder cb = em.get().getCriteriaBuilder();
		CriteriaQuery<Message> query = cb.createQuery(Message.class);
		Root<Message> from = query.from(Message.class);
		query.select(from);
		return new ArrayList<Message>(em.get().createQuery(query).getResultList());
	}

	/**
	 * @see hu.lptr.test.gae.csopibeszi.model.Messages#create(hu.lptr.test.gae.csopibeszi.model.Message)
	 */
	public void create(Message message) {
		em.get().persist(message);
	}

	/**
	 * @see hu.lptr.test.gae.csopibeszi.model.Messages#deleteById(java.lang.Long)
	 */
	public void deleteById(Long id) {
		Message message = em.get().find(Message.class, id);
		if (message != null) {
			em.get().remove(message);
		}
	}
}
