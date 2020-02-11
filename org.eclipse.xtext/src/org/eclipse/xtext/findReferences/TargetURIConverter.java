/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.findReferences;

import org.eclipse.emf.common.util.URI;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * @author Titouan Vervack - Moved from UI to non UI
 */
@Singleton
public class TargetURIConverter {
	@Inject
	private Provider<TargetURIs> targetURIProvider;

	public void setTargetURIProvider(Provider<TargetURIs> targetURIProvider) {
		this.targetURIProvider = targetURIProvider;
	}

	public TargetURIs fromIterable(Iterable<URI> uris) {
		if (uris instanceof TargetURIs) {
			return (TargetURIs) uris;
		}
		TargetURIs result = targetURIProvider.get();
		result.addAllURIs(uris);
		return result;
	}
}
