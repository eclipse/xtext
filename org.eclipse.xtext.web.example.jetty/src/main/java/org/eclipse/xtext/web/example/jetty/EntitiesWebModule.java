/*******************************************************************************
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.example.jetty;

import org.eclipse.xtext.web.server.persistence.FileResourceHandler;
import org.eclipse.xtext.web.server.persistence.IResourceBaseProvider;
import org.eclipse.xtext.web.server.persistence.IServerResourceHandler;

import com.google.inject.Binder;

/**
 * Use this class to register additional components to be used within the web
 * application.
 */
public class EntitiesWebModule extends AbstractEntitiesWebModule {
	private IResourceBaseProvider resourceBaseProvider;

	public void configureResourceBaseProvider(Binder binder) {
		if (this.resourceBaseProvider != null) {
			binder.bind(IResourceBaseProvider.class).toInstance(this.resourceBaseProvider);
		}
	}

	public Class<? extends IServerResourceHandler> bindIServerResourceHandler() {
		return FileResourceHandler.class;
	}

	public EntitiesWebModule(IResourceBaseProvider resourceBaseProvider) {
		this.resourceBaseProvider = resourceBaseProvider;
	}
}
