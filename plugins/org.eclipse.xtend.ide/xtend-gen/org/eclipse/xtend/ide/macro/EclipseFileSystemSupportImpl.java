/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.macro;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.core.filesystem.URIUtil;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.core.macro.AbstractFileSystemSupport;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * A FileSystemSupport implementation which maps to the Eclipse Resources API.
 * 
 * @author Sven Efftinge
 */
@SuppressWarnings("all")
public class EclipseFileSystemSupportImpl extends AbstractFileSystemSupport {
  @Accessors
  @Inject
  private IWorkspaceRoot workspaceRoot;
  
  @Override
  public Iterable<? extends Path> getChildren(final URI uri, final Path path) {
    final IResource resource = this.findMember(uri);
    if ((resource instanceof IContainer)) {
      try {
        IResource[] _members = ((IContainer)resource).members();
        final Function1<IResource, Path> _function = new Function1<IResource, Path>() {
          @Override
          public Path apply(final IResource it) {
            IPath _fullPath = it.getFullPath();
            String _string = _fullPath.toString();
            return new Path(_string);
          }
        };
        return ListExtensions.<IResource, Path>map(((List<IResource>)Conversions.doWrapArray(_members)), _function);
      } catch (final Throwable _t) {
        if (_t instanceof CoreException) {
          final CoreException exc = (CoreException)_t;
          String _message = exc.getMessage();
          throw new IllegalArgumentException(_message, exc);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
    return CollectionLiterals.<Path>emptyList();
  }
  
  @Override
  public java.net.URI toURI(final URI uri) {
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
    return this.toURI(uri, _newArrayList);
  }
  
  protected java.net.URI toURI(final URI uri, final List<String> trailingSegments) {
    java.net.URI _xblockexpression = null;
    {
      final IResource resource = this.findMember(uri);
      boolean _equals = Objects.equal(resource, null);
      if (_equals) {
        String _lastSegment = uri.lastSegment();
        trailingSegments.add(_lastSegment);
        URI _trimSegments = uri.trimSegments(1);
        return this.toURI(_trimSegments, trailingSegments);
      }
      List<String> _reverse = ListExtensions.<String>reverse(trailingSegments);
      IPath _location = resource.getLocation();
      final Function2<IPath, String, IPath> _function = new Function2<IPath, String, IPath>() {
        @Override
        public IPath apply(final IPath $0, final String $1) {
          return $0.append($1);
        }
      };
      IPath _fold = IterableExtensions.<String, IPath>fold(_reverse, _location, _function);
      _xblockexpression = URIUtil.toURI(_fold);
    }
    return _xblockexpression;
  }
  
  protected IResource findMember(final URI uri) {
    IResource _xblockexpression = null;
    {
      final String platformResourcePath = uri.toPlatformString(true);
      org.eclipse.core.runtime.Path _path = new org.eclipse.core.runtime.Path(platformResourcePath);
      _xblockexpression = this.workspaceRoot.findMember(_path);
    }
    return _xblockexpression;
  }
  
  @Pure
  public IWorkspaceRoot getWorkspaceRoot() {
    return this.workspaceRoot;
  }
  
  public void setWorkspaceRoot(final IWorkspaceRoot workspaceRoot) {
    this.workspaceRoot = workspaceRoot;
  }
}
