package org.eclipse.xtext.builder.standalone;

public class ClusteringConfig {

	/**
	 * We want at least 10MB free memory.
	 * @property
	 */
	private long minimumFreeMemory = 10;

	/**
	 * Minimum cluster size. To force garbage collector to kick in.
	 * @property
	 */
	private int minimumClusterSize = 20;

	/**
	 * Minimum percentage of memory that must be free before trying to load another resource.
	 * @property
	 */
	private long minimumPercentFreeMemory = 15;

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
