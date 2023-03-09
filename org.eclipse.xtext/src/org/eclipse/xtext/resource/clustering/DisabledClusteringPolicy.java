/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource.clustering;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * A clustering policy that effectively disables the clustering.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.7
 */
public class DisabledClusteringPolicy implements IResourceClusteringPolicy  {

	/**
	 * Returns always {@code true} to continue the processing in the very same resource set.
	 * @return {@code true}.
	 */
	@Override
	public boolean continueProcessing(ResourceSet resourceSet, URI next, int alreadyProcessed) {
		return true;
	}

}
