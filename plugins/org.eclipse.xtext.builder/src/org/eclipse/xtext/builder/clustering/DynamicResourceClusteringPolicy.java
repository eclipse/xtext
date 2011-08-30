/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.clustering;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public class DynamicResourceClusteringPolicy implements IResourceClusteringPolicy {

	public static final String MINIMUM_CLUSTER_SIZE = "org.eclipse.xtext.builder.clustering.DynamicResourceClusteringPolicy.minimumClusterSize";
	public static final String MINIMUM_PERCENT_FREE_MEMORY = "org.eclipse.xtext.builder.clustering.DynamicResourceClusteringPolicy.minimumPercentFreeMemory";

	private static final Logger LOGGER = Logger.getLogger(DynamicResourceClusteringPolicy.class);

	/** We want at least 10MB free memory. */
	private static final long MINIMUM_FREE_MEMORY = 10 * 1 << 20;

	/** Minimum cluster size. To force garbage collector to kick in. */
	@Inject(optional = true)
	@Named(MINIMUM_CLUSTER_SIZE)
	private final int minimumClusterSize = 20;

	/** Minimum percentage of memory that must be free before trying to load another resource. */
	@Inject(optional = true)
	@Named(MINIMUM_PERCENT_FREE_MEMORY)
	private final long minimumPercentFreeMemory = 10;

	public boolean continueProcessing(ResourceSet resourceSet, URI next, int alreadyProcessed) {
		final long freeMemory = Runtime.getRuntime().freeMemory();
		final long totalMemory = Runtime.getRuntime().totalMemory();

		if (freeMemory < MINIMUM_FREE_MEMORY) {
			logClusterCapped(resourceSet, alreadyProcessed, freeMemory, totalMemory);
			return false;
		} else if (alreadyProcessed < minimumClusterSize) {
			return true;
		} else if (freeMemory < totalMemory / 100 * minimumPercentFreeMemory) {
			logClusterCapped(resourceSet, alreadyProcessed, freeMemory, totalMemory);
			return false;
		}

		return true;
	}

	protected void logClusterCapped(ResourceSet resourceSet, int alreadyProcessed, final long freeMemory,
			final long totalMemory) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Cluster capped at " + alreadyProcessed + '/' + resourceSet.getResources().size()
					+ " processed/loaded resources; " + (freeMemory >> 20) + "/" + (totalMemory >> 20)
					+ " free/total memory");
		}
	}

}
