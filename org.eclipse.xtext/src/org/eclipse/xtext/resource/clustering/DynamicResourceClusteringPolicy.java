/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.clustering;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Knut Wannheden - Initial contribution and API
 * @since 2.7
 */
public class DynamicResourceClusteringPolicy implements IResourceClusteringPolicy {
	
	public static final String MINIMUM_FREE_MEMORY = "org.eclipse.xtext.resource.clustering.DynamicResourceClusteringPolicy.minimumFreeMemory";
	public static final String MINIMUM_CLUSTER_SIZE = "org.eclipse.xtext.resource.clustering.DynamicResourceClusteringPolicy.minimumClusterSize";
	public static final String MINIMUM_PERCENT_FREE_MEMORY = "org.eclipse.xtext.resource.clustering.DynamicResourceClusteringPolicy.minimumPercentFreeMemory";

	private static final Logger LOGGER = Logger.getLogger(DynamicResourceClusteringPolicy.class);
	
	/** We want at least 10MB free memory. */
	private static final long MINIMUM_10MB_FREE_MEMORY = 10 * 1 << 20;

	/** Minimum free memory. */
	@Inject(optional = true)
	@Named(MINIMUM_FREE_MEMORY)
	private long minimumFreeMemory = MINIMUM_10MB_FREE_MEMORY;

	/** Minimum cluster size. To force garbage collector to kick in. */
	@Inject(optional = true)
	@Named(MINIMUM_CLUSTER_SIZE)
	private int minimumClusterSize = 20;

	/** Minimum percentage of memory that must be free before trying to load another resource. */
	@Inject(optional = true)
	@Named(MINIMUM_PERCENT_FREE_MEMORY)
	private long minimumPercentFreeMemory = 15;

	@Override
	public boolean continueProcessing(ResourceSet resourceSet, URI next, int alreadyProcessed) {
		if (next != null && resourceSet.getResource(next, false) != null)
			return true;
		if (alreadyProcessed == 0)
			return true;
		final long maxMemory = Runtime.getRuntime().maxMemory();
		final long totalMemory = Runtime.getRuntime().totalMemory();
		if (maxMemory > totalMemory + minimumFreeMemory)
			return true;
		final long freeMemory = Runtime.getRuntime().freeMemory();
		if (freeMemory < minimumFreeMemory) {
			logClusterCapped(resourceSet, alreadyProcessed, freeMemory, totalMemory);
			return false;
		} else if (alreadyProcessed < minimumClusterSize) {
			return true;
		} else if (freeMemory < maxMemory / 100 * minimumPercentFreeMemory) {
			logClusterCapped(resourceSet, alreadyProcessed, freeMemory, totalMemory);
			return false;
		}

		return true;
	}
	
	private static boolean hasLoggedAboutIncreasingHeap = false;
	
	protected void logClusterCapped(ResourceSet resourceSet, int alreadyProcessed, final long freeMemory,
			final long totalMemory) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Cluster capped at " + alreadyProcessed + '/' + resourceSet.getResources().size()
					+ " processed/loaded resources; " + (freeMemory >> 20) + "/" + (totalMemory >> 20)
					+ " free/total memory");
		}
		if (!hasLoggedAboutIncreasingHeap) {
			hasLoggedAboutIncreasingHeap = true;
			LOGGER.warn("Your total heap size (" + (totalMemory >> 20) + "m) is too small (free: " + (freeMemory >> 20) + "m, max: "
					+ (Runtime.getRuntime().maxMemory() >> 20) + "m). Please increase the maximum heap for your running JVM!");
		}
	}
	
	public long getMinimumFreeMemory() {
		return minimumFreeMemory;
	}

	public void setMinimumFreeMemory(long minimumFreeMemory) {
		this.minimumFreeMemory = minimumFreeMemory;
	}

	public int getMinimumClusterSize() {
		return minimumClusterSize;
	}

	public void setMinimumClusterSize(int minimumClusterSize) {
		this.minimumClusterSize = minimumClusterSize;
	}

	public long getMinimumPercentFreeMemory() {
		return minimumPercentFreeMemory;
	}

	public void setMinimumPercentFreeMemory(long minimumPercentFreeMemory) {
		this.minimumPercentFreeMemory = minimumPercentFreeMemory;
	}
	
}
