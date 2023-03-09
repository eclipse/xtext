/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.resource;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.util.Pair;

import com.google.common.annotations.Beta;

/**
 * A contribution to the {@link IStorage2UriMapper} that allows to
 * contribute additional storages for a uri, or to compute the {@link URI}
 * from a given {@link IStorage storage}.
 *  
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.5
 */
@Beta
public interface IStorage2UriMapperContribution {
	
	/**
	 * Initialize any local caching. Called before first access.
	 */
	void initializeCache();
	
	/**
	 * Allows to reject a given folder, e.g. the bin folder of a {@link IJavaProject java project}.
	 */
	boolean isRejected(/* @NonNull */ IFolder folder);
	
	/**
	 * Returns all the pairs of {@link IStorage} and {@link IProject} that map to
	 * the given {@link URI}, e.g. if the uri points to an archive file that is 
	 * used by different projects, all known references should be returned.
	 */
	/* @NonNull */
	Iterable<Pair<IStorage, IProject>> getStorages(/* @NonNull */ URI uri);
	
	/**
	 * Returns the URI for the given storage or <code>null</code> if this contribution
	 * does no handle the storage explicitly.
	 */
	/* @Nullable */
	URI getUri(/* @NonNull */ IStorage storage);
	
}
