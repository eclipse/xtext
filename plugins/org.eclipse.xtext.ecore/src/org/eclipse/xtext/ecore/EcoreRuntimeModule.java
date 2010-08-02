/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ecore;

import org.eclipse.xtext.Constants;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.service.AbstractGenericModule;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Default bindings for Ecore's resource service provider, etc.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class EcoreRuntimeModule extends AbstractGenericModule {

	public Class<? extends IResourceServiceProvider> bindIResourceServiceProvider() {
		return EcoreResourceServiceProviderImpl.class;
	}
	
	public Class<? extends IEncodingProvider> bindIEncodingProvider() {
		return XMLEncodingProvider.class;
	}
	
	public void configureLanguageName(Binder binder) {
		binder.bind(String.class).annotatedWith(Names.named(Constants.LANGUAGE_NAME))
				.toInstance("org.eclipse.emf.ecore.presentation.EcoreEditorID");
	}

	public void configureFileExtensions(Binder binder) {
		binder.bind(String.class).annotatedWith(Names.named(Constants.FILE_EXTENSIONS)).toInstance("ecore");
	}

}
