/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.emf.common.util.URI;

/**
 * Extension to the {@link IResourceServiceProvider} which allows to ask
 * if a given resource URI points to a project source or a library.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @since 2.8
 */
public interface IResourceServiceProviderExtension {

	/**
	 * Returns true if the given uri is from a source that is to-be-processed.
	 * @since 2.9
	 */
	boolean isSource(URI uri);
}
