/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server

import com.google.inject.Binder
import com.google.inject.Provider
import com.google.inject.name.Names
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import org.eclipse.xtext.service.AbstractGenericModule
import org.eclipse.xtext.web.server.generator.DefaultContentTypeProvider
import org.eclipse.xtext.web.server.generator.IContentTypeProvider

/**
 * Default Guice bindings for the web integration of Xtext.
 * It is the responsibility of the caller of the constructor of this module to shut down the
 * passed executor services. If a provider for executor services is given, it must provide a
 * new instance for each invocation.
 */
class DefaultWebModule extends AbstractGenericModule {
	
	val Provider<ExecutorService> executorServiceProvider
	
	new() {
		executorServiceProvider = [Executors.newCachedThreadPool]
	}
	
	new(Provider<ExecutorService> executorServiceProvider) {
		this.executorServiceProvider = executorServiceProvider
	}
	
	def Class<? extends IContentTypeProvider> bindIContentTypeProvider() {
		DefaultContentTypeProvider
	}
	
	/**
	 * @deprecated The normal executor service is now configured in the {@link DefaultIdeModule}.
	 */
	@Deprecated
	def void configureExecutorService(Binder binder) {
	}
	
	def void configureExecutorServiceWithDocumentLock(Binder binder) {
		binder.bind(ExecutorService).annotatedWith(Names.named("withDocumentLock")).toInstance(executorServiceProvider.get)
	}
	
}