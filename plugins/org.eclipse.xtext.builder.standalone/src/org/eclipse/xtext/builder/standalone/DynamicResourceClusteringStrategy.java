/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class DynamicResourceClusteringStrategy implements IClusteringStrategy {

	private static final Logger LOGGER = Logger.getLogger(DynamicResourceClusteringStrategy.class);

	private long minimumFreeMemory;

	private int minimumClusterSize;

	private long minimumPercentFreeMemory;

	public DynamicResourceClusteringStrategy(ClusteringConfig config) {
		super();
		// Convert MB to byte to make it easier for the user
		this.minimumFreeMemory = config.getMinimumFreeMemory() * 1024 * 1024;
		this.minimumClusterSize = config.getMinimumClusterSize();
		this.minimumPercentFreeMemory = config.getMinimumPercentFreeMemory();
	}

	public boolean continueProcessing(ResourceSet resourceSet, int alreadyProcessed) {
		if (alreadyProcessed == 0)
			return true;
		final long maxMemory = Runtime.getRuntime().maxMemory();
		if (maxMemory > Runtime.getRuntime().totalMemory() + minimumFreeMemory)
			return true;
		final long freeMemory = Runtime.getRuntime().freeMemory();
		if (freeMemory < minimumFreeMemory) {
			logClusterCapped(resourceSet, alreadyProcessed, freeMemory, maxMemory);
			return false;
		} else if (alreadyProcessed < minimumClusterSize) {
			return true;
		} else if (freeMemory < maxMemory / 100 * minimumPercentFreeMemory) {
			logClusterCapped(resourceSet, alreadyProcessed, freeMemory, maxMemory);
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
			LOGGER.error("Your total heap size ("
					+ (totalMemory >> 20)
					+ "m) is too small. Please increase the maximum heap for your running Maven build! (export MAVEN_OPTS='-Xms256m -Xmx2048m')");
		}
	}
}
