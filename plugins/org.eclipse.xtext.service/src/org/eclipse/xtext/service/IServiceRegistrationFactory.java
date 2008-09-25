package org.eclipse.xtext.service;

import java.util.Set;

public interface IServiceRegistrationFactory {
	public interface IServiceRegistration {
		IServiceScope scope();
		IServiceFactory serviceFactory();
		int priority();
	}
	
	Set<IServiceRegistration> registrations();
}	

