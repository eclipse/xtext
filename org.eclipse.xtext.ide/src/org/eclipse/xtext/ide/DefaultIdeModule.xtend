/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide

import com.google.inject.Binder
import com.google.inject.Provider
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import org.eclipse.xtext.service.AbstractGenericModule

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class DefaultIdeModule extends AbstractGenericModule {
	
	val Provider<ExecutorService> executorServiceProvider
	
	new() {
		executorServiceProvider = [Executors.newCachedThreadPool]
	}
	
	new(Provider<ExecutorService> executorServiceProvider) {
		this.executorServiceProvider = executorServiceProvider
	}
	
	def void configureExecutorService(Binder binder) {
		binder.bind(ExecutorService).toInstance(executorServiceProvider.get)
	}
	
}