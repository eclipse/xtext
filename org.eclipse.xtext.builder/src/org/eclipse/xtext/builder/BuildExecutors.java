/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder;

import java.util.concurrent.Executors;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.google.inject.Singleton;

/**
 * Provides access to an executor service that can be used for parallel building.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.9
 * 
 * TODO this should be shared accross all languages
 */
@Singleton
public class BuildExecutors {

	// TODO shutdown on workspace shutdown
	private final ListeningExecutorService sharedService;

	public BuildExecutors() {
		int nProcessors = Runtime.getRuntime().availableProcessors();
		int nThreads = Math.max(2, Math.min(4, nProcessors));
		sharedService = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(nThreads, new ThreadFactoryBuilder().setNameFormat("ParallelGenerator-%d").build()));
	}
	
	public ListeningExecutorService getExecutor() {
		return sharedService;
	}
	
}
