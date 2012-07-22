package hu.lptr.test.gae.csopibeszi.server;

import hu.lptr.test.gae.csopibeszi.model.Messages;
import hu.lptr.test.gae.csopibeszi.web.MessagesServiceImpl;

import javax.servlet.ServletContextEvent;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

public class GuiceConfiguration extends GuiceServletContextListener {

	private PersistService persistService;

	@Override
	protected Injector getInjector() {
		Injector injector = Guice.createInjector(
				new JpaPersistModule("standing-orders"), 
				new ServletModule() {
					@Override
					protected void configureServlets() {
						bind(Messages.class).to(MessageRepository.class);
						
						filter("/*").through(PersistFilter.class);
						serve("/messages/*").with(MessagesServiceImpl.class);
					}
		});
		persistService = injector.getInstance(PersistService.class);
		//persistService.start();
		return injector;
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		if (persistService != null) {
			//persistService.stop();
		}
		super.contextDestroyed(servletContextEvent);
	}
}
