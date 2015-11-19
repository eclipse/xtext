/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.model;

import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.web.server.IServiceContext;

/**
 * Provider for resource set instances.
 */
@ImplementedBy(IWebResourceSetProvider.DefaultImpl.class)
@SuppressWarnings("all")
public interface IWebResourceSetProvider {
  /**
   * The default implementation creates a new resource set for each resource.
   */
  public static class DefaultImpl implements IWebResourceSetProvider {
    @Inject
    private Provider<ResourceSet> provider;
    
    @Override
    public ResourceSet get(final String resourceId, final IServiceContext serviceContext) {
      return this.provider.get();
    }
  }
  
  /**
   * Provides a resource set. The resourceId may be {@code null}, which means that the
   * request should be processed in stateless mode. Fetching the session from the service
   * context should be avoided in this case.
   */
  public abstract ResourceSet get(final String resourceId, final IServiceContext serviceContext);
}
