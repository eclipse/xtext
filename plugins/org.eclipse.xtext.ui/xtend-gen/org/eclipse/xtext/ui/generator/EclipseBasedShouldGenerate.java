/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.generator;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.generator.IShouldGenerate;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class EclipseBasedShouldGenerate implements IShouldGenerate {
  @Inject
  private IStorage2UriMapper storage2UriMapper;
  
  @Override
  public boolean shouldGenerate(final Resource resource, final CancelIndicator cancelIndicator) {
    ResourceSet _resourceSet = null;
    if (resource!=null) {
      _resourceSet=resource.getResourceSet();
    }
    EList<Resource> _resources = null;
    if (_resourceSet!=null) {
      _resources=_resourceSet.getResources();
    }
    Resource _head = null;
    if (_resources!=null) {
      _head=IterableExtensions.<Resource>head(_resources);
    }
    URI _uRI = null;
    if (_head!=null) {
      _uRI=_head.getURI();
    }
    final URI uri = _uRI;
    boolean _or = false;
    boolean _equals = Objects.equal(uri, null);
    if (_equals) {
      _or = true;
    } else {
      boolean _isPlatformResource = uri.isPlatformResource();
      boolean _not = (!_isPlatformResource);
      _or = _not;
    }
    if (_or) {
      return false;
    }
    IWorkspace _workspace = ResourcesPlugin.getWorkspace();
    IWorkspaceRoot _root = _workspace.getRoot();
    String _segment = uri.segment(1);
    final IProject project = _root.getProject(_segment);
    try {
      URI _uRI_1 = resource.getURI();
      Iterable<Pair<IStorage, IProject>> storages = this.storage2UriMapper.getStorages(_uRI_1);
      for (final Pair<IStorage, IProject> pair : storages) {
        boolean _and = false;
        IStorage _first = pair.getFirst();
        if (!(_first instanceof IFile)) {
          _and = false;
        } else {
          IProject _second = pair.getSecond();
          boolean _equals_1 = _second.equals(project);
          _and = _equals_1;
        }
        if (_and) {
          IStorage _first_1 = pair.getFirst();
          IFile file = ((IFile) _first_1);
          int _findMaxProblemSeverity = file.findMaxProblemSeverity(null, true, IResource.DEPTH_INFINITE);
          return (_findMaxProblemSeverity != IMarker.SEVERITY_ERROR);
        }
      }
      return false;
    } catch (final Throwable _t) {
      if (_t instanceof CoreException) {
        final CoreException exc = (CoreException)_t;
        throw new WrappedException(exc);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
