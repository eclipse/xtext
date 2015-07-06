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
import org.eclipse.xtext.web.server.model.AbstractPreComputedService;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@Singleton
@SuppressWarnings("all")
public class PreComputedServiceRegistry {
  private final Set<AbstractPreComputedService<? extends IServiceResult>> preComputedServices = CollectionLiterals.<AbstractPreComputedService<? extends IServiceResult>>newHashSet();
  
  public boolean addPreComputedService(final AbstractPreComputedService<? extends IServiceResult> service) {
    return this.preComputedServices.add(service);
  }
  
  public boolean removePreComputedService(final AbstractPreComputedService<? extends IServiceResult> service) {
    return this.preComputedServices.remove(service);
  }
  
  public Iterable<AbstractPreComputedService<? extends IServiceResult>> getPreComputedServices() {
    return this.preComputedServices;
  }
}
