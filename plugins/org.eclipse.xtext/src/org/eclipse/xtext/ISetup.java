package org.eclipse.xtext;

import org.eclipse.xtext.resource.IResourceFactory;

import com.google.inject.Injector;


public interface ISetup {

	public Injector createInjectorAndDoEMFRegistration();

}
