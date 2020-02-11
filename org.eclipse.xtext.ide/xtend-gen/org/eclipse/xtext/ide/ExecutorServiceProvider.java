/**
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.eclipse.xtext.util.DisposableRegistry;
import org.eclipse.xtext.util.IDisposable;

/**
 * Provider for executor services. By calling {@link #dispose()} all created executor services are shut down.
 * <p>
 * In some situations it is necessary to use multiple instances of executor services in order to avoid deadlocks.
 * That can be achieved with the {@link #get(String)} method, which will return a different instance for each key.
 */
@Singleton
@SuppressWarnings("all")
public class ExecutorServiceProvider implements Provider<ExecutorService>, IDisposable {
  @Inject
  public void registerTo(final DisposableRegistry disposableRegistry) {
    disposableRegistry.register(this);
  }
  
  private final Map<String, ExecutorService> instanceCache = Maps.<String, ExecutorService>newHashMapWithExpectedSize(3);
  
  @Override
  public ExecutorService get() {
    return this.get(null);
  }
  
  public ExecutorService get(final String key) {
    ExecutorService result = this.instanceCache.get(key);
    if ((result == null)) {
      synchronized (this.instanceCache) {
        result = this.instanceCache.get(key);
        if ((result == null)) {
          result = this.createInstance(key);
          this.instanceCache.put(key, result);
        }
      }
    }
    return result;
  }
  
  protected ExecutorService createInstance(final String key) {
    return Executors.newCachedThreadPool();
  }
  
  @Override
  public void dispose() {
    Collection<ExecutorService> _values = this.instanceCache.values();
    for (final ExecutorService executorService : _values) {
      executorService.shutdown();
    }
    this.instanceCache.clear();
  }
}
