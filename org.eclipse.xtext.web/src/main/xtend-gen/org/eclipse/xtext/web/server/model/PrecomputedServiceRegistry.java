/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.model;

import com.google.inject.Singleton;
import java.util.Set;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.web.server.model.AbstractCachedService;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * Precomputed services are able to store their results in the document, which can in turn
 * be cached in the session store of the server. This concept can improve performance by
 * <ul>
 *   <li>avoiding multiple computations of the same results and</li>
 *   <li>starting computations immediately after a document change, reducing wait time for
 *     the corresponding requests.</li>
 * </ul>
 */
@Singleton
@SuppressWarnings("all")
public class PrecomputedServiceRegistry {
  private final Set<AbstractCachedService<? extends IServiceResult>> precomputedServices = CollectionLiterals.<AbstractCachedService<? extends IServiceResult>>newHashSet();
  
  /**
   * Register a service to be precomputed after each document change.
   */
  public boolean addPrecomputedService(final AbstractCachedService<? extends IServiceResult> service) {
    boolean _xsynchronizedexpression = false;
    synchronized (this.precomputedServices) {
      _xsynchronizedexpression = this.precomputedServices.add(service);
    }
    return _xsynchronizedexpression;
  }
  
  /**
   * Remove a service from the registry.
   */
  public boolean removePrecomputedService(final AbstractCachedService<? extends IServiceResult> service) {
    boolean _xsynchronizedexpression = false;
    synchronized (this.precomputedServices) {
      _xsynchronizedexpression = this.precomputedServices.remove(service);
    }
    return _xsynchronizedexpression;
  }
  
  /**
   * Return the registered services. These services should be invoked whenever the document is changed.
   */
  public Iterable<AbstractCachedService<? extends IServiceResult>> getPrecomputedServices() {
    return this.precomputedServices;
  }
}
