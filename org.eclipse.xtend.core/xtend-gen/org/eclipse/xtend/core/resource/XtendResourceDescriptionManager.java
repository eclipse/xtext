/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.resource;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Collection;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.xbase.lib.ArrayExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.resource.XbaseResourceDescriptionManager;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;

@Singleton
@SuppressWarnings("all")
public class XtendResourceDescriptionManager extends XbaseResourceDescriptionManager implements IResourceDescription.Manager.AllChangeAware {
  @Inject
  private IBatchTypeResolver typeResolver;

  @Inject
  private IQualifiedNameConverter nameConverter;

  @Override
  public IResourceDescription createResourceDescription(final Resource resource, final IDefaultResourceDescriptionStrategy strategy) {
    IResourceScopeCache _cache = this.getCache();
    return new XtendResourceDescription(resource, strategy, _cache, this.typeResolver, this.nameConverter);
  }

  @Override
  public boolean hasChanges(final IResourceDescription.Delta delta, final IResourceDescription candidate) {
    return (super.hasChanges(delta, candidate) || this.containsActiveAnnotation(candidate));
  }

  private boolean containsActiveAnnotation(final IResourceDescription description) {
    final Function1<IEObjectDescription, Boolean> _function = (IEObjectDescription it) -> {
      return Boolean.valueOf(ArrayExtensions.contains(it.getUserDataKeys(), XtendResourceDescriptionStrategy.ACTIVE_ANNOTATION_TIMESTAMP));
    };
    return IterableExtensions.<IEObjectDescription>exists(description.getExportedObjects(), _function);
  }

  /**
   * When an annotation processor changes, even if it is just its implementation, the downstream classes should be rebuilt. That is why we are interested even in
   * deltas that have no changed EObjectDescriptions
   */
  @Override
  public boolean isAffectedByAny(final Collection<IResourceDescription.Delta> deltas, final IResourceDescription candidate, final IResourceDescriptions context) throws IllegalArgumentException {
    return this.isAffected(deltas, candidate, context);
  }
}
