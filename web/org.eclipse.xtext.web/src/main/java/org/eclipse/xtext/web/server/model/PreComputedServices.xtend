/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.model

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.Set
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.web.server.IServiceResult

@Singleton
class PreComputedServiceRegistry {
	
	val Set<AbstractPreComputedService<? extends IServiceResult>> preComputedServices = newHashSet
	
	def addPreComputedService(AbstractPreComputedService<? extends IServiceResult> service) {
		preComputedServices += service
	}
	
	def removePreComputedService(AbstractPreComputedService<? extends IServiceResult> service) {
		preComputedServices -= service
	}
	
	def Iterable<AbstractPreComputedService<? extends IServiceResult>> getPreComputedServices() {
		preComputedServices
	}
}

abstract class AbstractPreComputedService<T extends IServiceResult> {
	
	@Inject def register(PreComputedServiceRegistry preComputedServiceRegistry) {
		preComputedServiceRegistry.addPreComputedService(this)
	}
	
	def T getResult(XtextWebDocumentAccess it) {
		getCachedResult(this, true)
	}

	def T compute(IXtextWebDocument it, CancelIndicator cancelIndicator)
	
}