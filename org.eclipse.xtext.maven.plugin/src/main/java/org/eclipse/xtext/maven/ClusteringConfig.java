/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.maven;

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
	
	public org.eclipse.xtext.builder.standalone.ClusteringConfig convertToStandaloneConfig(){
		return new org.eclipse.xtext.builder.standalone.ClusteringConfig(minimumFreeMemory,minimumClusterSize, minimumPercentFreeMemory);
	}
}
