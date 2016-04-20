/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.example.jetty.resource;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.web.server.IServiceContext;
import org.eclipse.xtext.web.server.ISession;
import org.eclipse.xtext.web.server.model.IWebResourceSetProvider;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * Resources that run in multi-resource mode share the same resource set.
 */
@SuppressWarnings("all")
public class StatemachineResourceSetProvider implements IWebResourceSetProvider {
  private final static String MULTI_RESOURCE_PREFIX = "multi-resource";
  
  @Inject
  private Provider<ResourceSet> provider;
  
  @Override
  public ResourceSet get(final String resourceId, final IServiceContext serviceContext) {
    if (((resourceId != null) && resourceId.startsWith(StatemachineResourceSetProvider.MULTI_RESOURCE_PREFIX))) {
      int _indexOf = resourceId.indexOf("/");
      int _length = StatemachineResourceSetProvider.MULTI_RESOURCE_PREFIX.length();
      final int pathEnd = Math.max(_indexOf, _length);
      ISession _session = serviceContext.getSession();
      String _substring = resourceId.substring(0, pathEnd);
      Pair<Class<ResourceSet>, String> _mappedTo = Pair.<Class<ResourceSet>, String>of(ResourceSet.class, _substring);
      final Function0<ResourceSet> _function = new Function0<ResourceSet>() {
        @Override
        public ResourceSet apply() {
          return StatemachineResourceSetProvider.this.provider.get();
        }
      };
      return _session.<ResourceSet>get(_mappedTo, _function);
    } else {
      return this.provider.get();
    }
  }
}
