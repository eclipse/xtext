/**
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.web.test.languages;

import org.eclipse.xtext.web.server.persistence.FileResourceHandler;
import org.eclipse.xtext.web.server.persistence.IResourceBaseProvider;
import org.eclipse.xtext.web.server.persistence.IServerResourceHandler;
import org.eclipse.xtext.xbase.web.DefaultXbaseWebModule;

import com.google.inject.Binder;

public class EntitiesWebModule extends DefaultXbaseWebModule {
	private IResourceBaseProvider resourceBaseProvider;

	public Class<? extends IServerResourceHandler> bindIServerResourceHandler() {
		return FileResourceHandler.class;
	}

	public void configureResourceBaseProvider(Binder binder) {
		if (resourceBaseProvider != null) {
			binder.bind(IResourceBaseProvider.class).toInstance(resourceBaseProvider);
		}
	}

	public IResourceBaseProvider getResourceBaseProvider() {
		return resourceBaseProvider;
	}

	public void setResourceBaseProvider(IResourceBaseProvider resourceBaseProvider) {
		this.resourceBaseProvider = resourceBaseProvider;
	}
}
