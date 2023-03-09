/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.resource;

import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.util.Pair;

/**
 * A bi directional mapping service that allows to find the EMF {@link URI} for an {@link IStorage}
 * and vice versa.
 * @author Sven Efftinge - Initial contribution and API
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface IStorage2UriMapper {

	/**
	 * Find the storages that can be mapped to the given URI. It will typically 
	 * be only one {@link IStorage} associated with one {@link IProject} but 
	 * in the case that the same external class folder or jar is referenced in 
	 * multiple projects multiple {@link IStorage}s are returned.
	 * @param uri the {@link URI}. May not be <code>null</code>.
	 * @return IStorages corresponding to the given URI. Never <code>null</code>.
	 *   The contained pairs might contain a mapping to <code>null</code> project when the storage is external to the workspace.
	 */
	Iterable<Pair<IStorage, IProject>> getStorages(URI uri);

	/**
	 * Returns the URI for the given {@link IStorage} or <code>null</code> if no valid URI exists.
	 * @return returns the URI for the given {@link IStorage} or <code>null</code>. 
	 */
	URI getUri(IStorage storage);

	/**
	 * @since 2.4
	 */
	Map<URI, IStorage> getAllEntries(IContainer container);
}
