package org.eclipse.xtext.builder.standalone;

public class ClusteringConfig {

	/**
	 * @property
	 */
	private long minimunFreeMemory = 10 * 1 << 20;

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

	public long getMinimunFreeMemory() {
		return minimunFreeMemory;
	}

	public int getMinimumClusterSize() {
		return minimumClusterSize;
	}

	public long getMinimumPercentFreeMemory() {
		return minimumPercentFreeMemory;
	}
}
