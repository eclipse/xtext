/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.example.jetty

import com.google.inject.Provider
import java.util.concurrent.ExecutorService
import org.eclipse.xtext.web.server.persistence.FileResourceHandler
import org.eclipse.xtext.web.server.persistence.IResourceBaseProvider
import org.eclipse.xtext.web.server.persistence.IServerResourceHandler

/**
 * Use this class to register additional components to be used within the web application.
 */
class EntitiesWebModule extends AbstractEntitiesWebModule {
	
	val IResourceBaseProvider resourceBaseProvider

	new(Provider<ExecutorService> executorServiceProvider, IResourceBaseProvider resourceBaseProvider) {
		super(executorServiceProvider)
		this.resourceBaseProvider = resourceBaseProvider
	}

	def Class<? extends IServerResourceHandler> bindIServerResourceHandler() {
		return FileResourceHandler
	}
	
}
