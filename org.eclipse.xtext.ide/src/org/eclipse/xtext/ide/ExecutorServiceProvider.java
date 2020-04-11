/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.xtext.util.DisposableRegistry;
import org.eclipse.xtext.util.IDisposable;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * Provider for executor services. By calling {@link #dispose()} all created executor services are shut down.
 * <p>
 * In some situations it is necessary to use multiple instances of executor services in order to avoid deadlocks. That
 * can be achieved with the {@link #get(String)} method, which will return a different instance for each key.
 */
@Singleton
public class ExecutorServiceProvider implements Provider<ExecutorService>, IDisposable {
	@Inject
	public void registerTo(DisposableRegistry disposableRegistry) {
		disposableRegistry.register(this);
	}

	private final Map<String, ExecutorService> instanceCache = Maps.newHashMapWithExpectedSize(3);

	@Override
	public ExecutorService get() {
		return get(null);
	}

	public ExecutorService get(String key) {
		ExecutorService result = instanceCache.get(key);
		if (result == null) {
			synchronized (instanceCache) {
				result = instanceCache.get(key);
				if (result == null) {
					result = createInstance(key);
					instanceCache.put(key, result);
				}
			}
		}
		return result;
	}

	protected ExecutorService createInstance(String key) {
		return Executors.newCachedThreadPool();
	}

	@Override
	public void dispose() {
		for (ExecutorService executorService : instanceCache.values()) {
			executorService.shutdown();
		}
		instanceCache.clear();
	}
}
