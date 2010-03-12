package org.eclipse.xtext.ecore;

import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.service.AbstractGenericModule;

import com.google.inject.Binder;

public class EcoreRuntimeModule extends AbstractGenericModule {

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(IResourceServiceProvider.class).to(EcoreResourceServiceProviderImpl.class);
		bindProperties(binder, "org/eclipse/xtext/ecore/Ecore.properties");
	}
	
}
