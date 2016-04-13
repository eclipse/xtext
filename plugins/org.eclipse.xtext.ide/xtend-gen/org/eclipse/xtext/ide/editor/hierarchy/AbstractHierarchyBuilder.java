/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.editor.hierarchy;

import com.google.inject.Inject;
import javax.inject.Provider;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.findReferences.IReferenceFinder;
import org.eclipse.xtext.findReferences.TargetURICollector;
import org.eclipse.xtext.findReferences.TargetURIs;
import org.eclipse.xtext.ide.editor.hierarchy.HierarchyBuilder;
import org.eclipse.xtext.ide.editor.hierarchy.HierarchyNodeLocationProvider;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@Accessors({ AccessorType.PUBLIC_SETTER, AccessorType.PROTECTED_GETTER })
@SuppressWarnings("all")
public abstract class AbstractHierarchyBuilder implements HierarchyBuilder {
  private IReferenceFinder.IResourceAccess resourceAccess;
  
  private IResourceDescriptions indexData;
  
  @Inject
  private IReferenceFinder referenceFinder;
  
  @Inject
  private TargetURICollector targetURICollector;
  
  @Inject
  private Provider<TargetURIs> targetURIProvider;
  
  @Inject
  private HierarchyNodeLocationProvider hierarchyNodeLocationProvider;
  
  @Inject
  private IResourceServiceProvider.Registry resourceServiceProviderRegistry;
  
  @Pure
  protected IReferenceFinder.IResourceAccess getResourceAccess() {
    return this.resourceAccess;
  }
  
  public void setResourceAccess(final IReferenceFinder.IResourceAccess resourceAccess) {
    this.resourceAccess = resourceAccess;
  }
  
  @Pure
  protected IResourceDescriptions getIndexData() {
    return this.indexData;
  }
  
  public void setIndexData(final IResourceDescriptions indexData) {
    this.indexData = indexData;
  }
  
  @Pure
  protected IReferenceFinder getReferenceFinder() {
    return this.referenceFinder;
  }
  
  public void setReferenceFinder(final IReferenceFinder referenceFinder) {
    this.referenceFinder = referenceFinder;
  }
  
  @Pure
  protected TargetURICollector getTargetURICollector() {
    return this.targetURICollector;
  }
  
  public void setTargetURICollector(final TargetURICollector targetURICollector) {
    this.targetURICollector = targetURICollector;
  }
  
  @Pure
  protected Provider<TargetURIs> getTargetURIProvider() {
    return this.targetURIProvider;
  }
  
  public void setTargetURIProvider(final Provider<TargetURIs> targetURIProvider) {
    this.targetURIProvider = targetURIProvider;
  }
  
  @Pure
  protected HierarchyNodeLocationProvider getHierarchyNodeLocationProvider() {
    return this.hierarchyNodeLocationProvider;
  }
  
  public void setHierarchyNodeLocationProvider(final HierarchyNodeLocationProvider hierarchyNodeLocationProvider) {
    this.hierarchyNodeLocationProvider = hierarchyNodeLocationProvider;
  }
  
  @Pure
  protected IResourceServiceProvider.Registry getResourceServiceProviderRegistry() {
    return this.resourceServiceProviderRegistry;
  }
  
  public void setResourceServiceProviderRegistry(final IResourceServiceProvider.Registry resourceServiceProviderRegistry) {
    this.resourceServiceProviderRegistry = resourceServiceProviderRegistry;
  }
}
