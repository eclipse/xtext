/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.refactoring;

import com.google.inject.Inject;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ide.refactoring.ResourceRelocationChange;
import org.eclipse.xtext.ide.refactoring.ResourceRelocationContext;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;

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
    
    @Override
    public boolean canHandle(final ResourceRelocationChange change) {
      return this.resourceServiceProvider.canHandle(change.getFromURI());
    }
    
    @Override
    public Resource loadAndWatchResource(final ResourceRelocationChange change, final ResourceRelocationContext context) {
      final Resource fromResource = context.getResourceSet().getResource(change.getFromURI(), true);
      ResourceRelocationChange.Type _type = change.getType();
      boolean _tripleEquals = (_type == ResourceRelocationChange.Type.COPY);
      if (_tripleEquals) {
        final Resource copy = context.getResourceSet().createResource(change.getToURI());
        return copy;
      } else {
        context.getChangeSerializer().beginRecordChanges(fromResource);
        return fromResource;
      }
    }
    
    @Override
    public void applyChange(final ResourceRelocationChange change, final Resource resource, final ResourceRelocationContext context) {
      try {
        final Resource fromResource = context.getResourceSet().getResource(change.getFromURI(), false);
        ResourceRelocationChange.Type _type = change.getType();
        if (_type != null) {
          switch (_type) {
            case COPY:
              final ByteArrayOutputStream buffer = new ByteArrayOutputStream();
              fromResource.save(buffer, null);
              final Resource copy = context.getResourceSet().getResource(change.getToURI(), false);
              byte[] _byteArray = buffer.toByteArray();
              ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_byteArray);
              copy.load(_byteArrayInputStream, null);
              context.getChangeSerializer().beginRecordChanges(copy);
              break;
            case MOVE:
            case RENAME:
              context.getChangeSerializer().beginRecordChanges(fromResource);
              fromResource.setURI(change.getToURI());
              break;
            default:
              break;
          }
        }
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    }
  }
  
  public abstract boolean canHandle(final ResourceRelocationChange change);
  
  public abstract Resource loadAndWatchResource(final ResourceRelocationChange change, final ResourceRelocationContext context);
  
  public abstract void applyChange(final ResourceRelocationChange change, final Resource resource, final ResourceRelocationContext context);
  
  public abstract void applySideEffects(final ResourceRelocationChange change, final Resource resource, final ResourceRelocationContext context);
}
