/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.model

import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.web.server.IServiceResult

/**
 * Superclass for services that support caching their results in the document. Such a service is
 * not necessarily precomputed automatically after a document change; this happens only if the
 * service is registered in the {@link PrecomputedServiceRegistry}.
 */
abstract class AbstractCachedService<T extends IServiceResult> {
	
	/**
	 * If a cached result is available, that instance is returned. Otherwise a new result
	 * is obtained with {@link #compute(IXtextWebDocument, CancelIndicator)}.
	 */
	def T getResult(XtextWebDocumentAccess it) {
		getCachedServiceResult(this, true)
	}

	/**
	 * Perform the actual computations to obtain a result. This method should not be called
	 * directly from the service dispatcher; use {@link #getResult(XtextWebDocumentAccess)} instead
	 * in order to avoid duplicate computations.
	 */
	def T compute(IXtextWebDocument it, CancelIndicator cancelIndicator)
	
}