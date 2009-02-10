package org.eclipse.xtext;

import com.google.inject.Injector;


public interface ISetup {

	public Injector createInjectorAndDoEMFRegistration();

}
