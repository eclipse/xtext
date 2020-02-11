/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
 * Default bindings for EMF resources which are not based on Xtext.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein
 */
public abstract class AbstractGenericResourceRuntimeModule extends AbstractGenericModule {

	protected abstract String getLanguageName();
	
	protected abstract String getFileExtensions();

	public Class<? extends IResourceServiceProvider> bindIResourceServiceProvider() {
		return GenericResourceServiceProvider.class;
	}
	
	public Class<? extends IEncodingProvider> bindIEncodingProvider() {
		return XMLEncodingProvider.class;
	}
	
	public Class<? extends IResourceDescription.Manager> bindIResourceDescription$Manager() {
		return GenericResourceDescriptionManager.class;
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
