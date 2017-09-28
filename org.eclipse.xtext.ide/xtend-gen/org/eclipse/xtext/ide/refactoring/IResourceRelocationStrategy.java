/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.refactoring;

import com.google.inject.Inject;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ide.refactoring.ResourceRelocationChange;
import org.eclipse.xtext.ide.refactoring.ResourceRelocationContext;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Allows a language to execute side-effects when the URI of a resource changes.
 * 
 * Such changes can be move, rename and copy operations, e.g. triggered by the
 * user in a file browser. An example for a language in which such side-effects
 * would make sense is Java, where the package name and the name of the first
 * public top-level class must match the resource's path.
 * 
 * Clients should not directly implement this interface but extend the
 * {@link IResourceRelocationStrategy.AbstractImpl}.
 * 
 * In Eclipse, {@link IResourceRelocationStrategy} are registered to an extension
 * point.
 * 
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
@SuppressWarnings("all")
public interface IResourceRelocationStrategy {
  /**
   * Clients should extend this class to register side-effects on resource relocation changes.
   */
  public static abstract class AbstractImpl implements IResourceRelocationStrategy {
    @Inject
    private IResourceServiceProvider resourceServiceProvider;
    
    public boolean canHandle(final ResourceRelocationChange change) {
      return this.resourceServiceProvider.canHandle(change.getFromURI());
    }
    
    @Override
    public void loadAndWatchResources(final ResourceRelocationContext context) {
      final Function1<ResourceRelocationChange, Boolean> _function = (ResourceRelocationChange it) -> {
        return Boolean.valueOf((it.isFile() && this.canHandle(it)));
      };
      final Consumer<ResourceRelocationChange> _function_1 = (ResourceRelocationChange change) -> {
        try {
          ResourceRelocationContext.ChangeType _changeType = context.getChangeType();
          boolean _tripleEquals = (_changeType == ResourceRelocationContext.ChangeType.COPY);
          if (_tripleEquals) {
            final Resource fromResource = context.getResourceSet().createResource(change.getFromURI());
            fromResource.load(context.getResourceSet().getURIConverter().createInputStream(change.getFromURI()), null);
            fromResource.setURI(change.getToURI());
            context.getChangeSerializer().beginRecordChanges(fromResource);
          } else {
            final Resource fromResource_1 = context.getResourceSet().getResource(change.getFromURI(), true);
            context.getChangeSerializer().beginRecordChanges(fromResource_1);
          }
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      IterableExtensions.<ResourceRelocationChange>filter(context.getChanges(), _function).forEach(_function_1);
    }
    
    @Override
    public void applyChange(final ResourceRelocationContext context) {
      final Function1<ResourceRelocationChange, Boolean> _function = (ResourceRelocationChange it) -> {
        return Boolean.valueOf((it.isFile() && this.canHandle(it)));
      };
      final Consumer<ResourceRelocationChange> _function_1 = (ResourceRelocationChange change) -> {
        ResourceRelocationContext.ChangeType _changeType = context.getChangeType();
        if (_changeType != null) {
          switch (_changeType) {
            case MOVE:
            case RENAME:
              final Resource fromResource = context.getResourceSet().getResource(change.getFromURI(), false);
              fromResource.setURI(change.getToURI());
              break;
            case COPY:
              break;
            default:
              break;
          }
        }
      };
      IterableExtensions.<ResourceRelocationChange>filter(context.getChanges(), _function).forEach(_function_1);
    }
  }
  
  public abstract void loadAndWatchResources(final ResourceRelocationContext context);
  
  public abstract void applyChange(final ResourceRelocationContext context);
  
  public abstract void applySideEffects(final ResourceRelocationContext context);
}
