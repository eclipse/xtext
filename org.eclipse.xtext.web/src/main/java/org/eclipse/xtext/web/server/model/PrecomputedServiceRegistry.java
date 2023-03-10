/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server.model;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.eclipse.xtext.web.server.IServiceResult;
import com.google.inject.Singleton;

/**
 * Precomputed services are able to store their results in the document, which
 * can in turn be cached in the session store of the server. This concept can
 * improve performance by
 * <ul>
 * <li>avoiding multiple computations of the same results and</li>
 * <li>starting computations immediately after a document change, reducing wait
 * time for the corresponding requests.</li>
 * </ul>
 */
@Singleton
public class PrecomputedServiceRegistry {

	private final Set<AbstractCachedService<? extends IServiceResult>> precomputedServices = new CopyOnWriteArraySet<>();

	/**
	 * Register a service to be precomputed after each document change.
	 */
	public boolean addPrecomputedService(AbstractCachedService<? extends IServiceResult> service) {
		return precomputedServices.add(service);
	}

	/**
	 * Remove a service from the registry.
	 */
	public boolean removePrecomputedService(AbstractCachedService<? extends IServiceResult> service) {
		return precomputedServices.remove(service);
	}

	/**
	 * Return the registered services. These services should be invoked whenever the
	 * document is changed.
	 */
	public Iterable<AbstractCachedService<? extends IServiceResult>> getPrecomputedServices() {
		return Collections.unmodifiableSet(precomputedServices);
	}
}
