/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.generic;

import org.eclipse.xtext.Constants;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.SimpleNameProvider;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.service.AbstractGenericModule;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Default bindings for Ecore's resource service provider, etc.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein
 */
public abstract class AbstractEmfResourceRuntimeModule extends AbstractGenericModule {

	protected abstract String getLanguageName();
	
	protected abstract String getFileExtensions();

	public Class<? extends IResourceServiceProvider> bindIResourceServiceProvider() {
		return EmfResourceServiceProvider.class;
	}
	
	public Class<? extends IEncodingProvider> bindIEncodingProvider() {
		return XMLEncodingProvider.class;
	}
	
	public Class<? extends IResourceDescription.Manager> bindIResourceDescription$Manager() {
		return EmfResourceDescriptionManager.class;
	}
	
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return SimpleNameProvider.class;
	}
	
	public void configureLanguageName(Binder binder) {
		binder.bind(String.class).annotatedWith(Names.named(Constants.LANGUAGE_NAME))
				.toInstance(getLanguageName());
	}

	public void configureFileExtensions(Binder binder) {
		binder.bind(String.class).annotatedWith(Names.named(Constants.FILE_EXTENSIONS)).toInstance(getFileExtensions());
	}

}
