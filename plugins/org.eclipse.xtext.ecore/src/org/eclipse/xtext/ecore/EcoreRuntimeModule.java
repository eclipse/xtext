package org.eclipse.xtext.ecore;

import org.eclipse.xtext.Constants;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.service.AbstractGenericModule;

import com.google.inject.Binder;
import com.google.inject.name.Names;

public class EcoreRuntimeModule extends AbstractGenericModule {

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(IResourceServiceProvider.class).to(EcoreResourceServiceProviderImpl.class);
		binder.bind(IEncodingProvider.class).to(XMLEncodingProvider.class);
	}

	public void configureLanguageName(Binder binder) {
		binder.bind(String.class).annotatedWith(Names.named(Constants.LANGUAGE_NAME))
				.toInstance("org.eclipse.emf.ecore.presentation.EcoreEditorID");
	}

	public void configureFileExtensions(Binder binder) {
		binder.bind(String.class).annotatedWith(Names.named(Constants.FILE_EXTENSIONS)).toInstance("ecore");
	}

}
