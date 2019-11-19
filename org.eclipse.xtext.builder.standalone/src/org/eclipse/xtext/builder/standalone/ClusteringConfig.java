/**
 * Copyright (c) 2014, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.standalone;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class ClusteringConfig {
	/**
	 * Minimum free memory in MB.
	 */
	private long minimumFreeMemory;

	/**
	 * Minimum cluster size. To force garbage collector to kick in.
	 */
	private int minimumClusterSize;

	/**
	 * Minimum percentage of memory that must be free before trying to load
	 * another resource.
	 */
	private long minimumPercentFreeMemory;

	public ClusteringConfig(long minimumFreeMemory, int minimumClusterSize, long minimumPercentFreeMemory) {
		this.minimumFreeMemory = minimumFreeMemory;
		this.minimumClusterSize = minimumClusterSize;
		this.minimumPercentFreeMemory = minimumPercentFreeMemory;
	}

	public long getMinimumFreeMemory() {
		return minimumFreeMemory;
	}

	public int getMinimumClusterSize() {
		return minimumClusterSize;
	}

	public long getMinimumPercentFreeMemory() {
		return minimumPercentFreeMemory;
	}
}
