/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.model

import com.google.inject.Singleton
import java.util.Set
import org.eclipse.xtext.web.server.IServiceResult

/**
 * Precomputed services are able to store their results in the document, which can in turn
 * be cached in the session store of the server. This concept can improve performance by
 * <ul>
 *   <li>avoiding multiple computations of the same results and</li>
 *   <li>starting computations immediately after a document change, reducing wait time for
 *     the corresponding requests.</li>
 * </ul>
 */
@Singleton
class PrecomputedServiceRegistry {
	
	val Set<AbstractCachedService<? extends IServiceResult>> precomputedServices = newHashSet
	
	/**
	 * Register a service to be precomputed after each document change.
	 */
	def addPrecomputedService(AbstractCachedService<? extends IServiceResult> service) {
		synchronized (precomputedServices) {
			precomputedServices += service
		}
	}
	
	/**
	 * Remove a service from the registry.
	 */
	def removePrecomputedService(AbstractCachedService<? extends IServiceResult> service) {
		synchronized (precomputedServices) {
			precomputedServices -= service
		}
	}
	
	/**
	 * Return the registered services. These services should be invoked whenever the document is changed.
	 */
	def Iterable<AbstractCachedService<? extends IServiceResult>> getPrecomputedServices() {
		precomputedServices
	}
	
}
