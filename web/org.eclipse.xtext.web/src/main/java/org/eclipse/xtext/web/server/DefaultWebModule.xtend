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
	
	val ExecutorService executorService
	val ExecutorService executorServiceWithDocumentLock
	
	new(Provider<ExecutorService> executorServiceProvider) {
		executorService = executorServiceProvider.get()
		executorServiceWithDocumentLock = executorServiceProvider.get()
	}
	
	def Class<? extends IContentTypeProvider> bindIContentTypeProvider() {
		DefaultContentTypeProvider
	}
	
	def configureExecutorService(Binder binder) {
		binder.bind(ExecutorService).toInstance(executorService)
	}
	
	def configureExecutorServiceWithDocumentLock(Binder binder) {
		binder.bind(ExecutorService).annotatedWith(Names.named("withDocumentLock")).toInstance(executorServiceWithDocumentLock)
	}
	
}