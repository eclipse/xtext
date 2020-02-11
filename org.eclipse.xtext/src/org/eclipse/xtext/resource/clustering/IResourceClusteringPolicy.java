/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource.clustering;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.google.inject.ImplementedBy;

/**
 * This strategy allows to cope with low memory environments where resources have to
 * be unloaded during the build.
 * 
 * @author Knut Wannheden - Initial contribution and API
 * @since 2.7
 */
@ImplementedBy(DisabledClusteringPolicy.class)
public interface IResourceClusteringPolicy {

	/**
	 * Determine whether another resource should be loaded into the resource set and be processed.
	 * 
	 * @param resourceSet
	 *            The resource set, containing all currently loaded resources.
	 * @param next
	 *            The next URI to be processed. Can be <code>null</code> if yet unknown.
	 * @param alreadyProcessed
	 *            The number of already processed resources. Note that the resource set may contain more resources.
	 * @return <code>true</code> if another resource should be processed, <code>false</code> if a new cluster should be
	 *         created.
	 */
	boolean continueProcessing(ResourceSet resourceSet, URI next, int alreadyProcessed);

}
