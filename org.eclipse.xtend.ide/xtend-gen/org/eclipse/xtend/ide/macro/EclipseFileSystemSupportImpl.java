/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.macro;

import com.google.inject.Inject;
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
        final Function1<IResource, Path> _function = (IResource it) -> {
          String _string = it.getFullPath().toString();
          return new Path(_string);
        };
        return ListExtensions.<IResource, Path>map(((List<IResource>)Conversions.doWrapArray(((IContainer)resource).members())), _function);
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
    return this.toURI(uri, CollectionLiterals.<String>newArrayList());
  }

  protected java.net.URI toURI(final URI uri, final List<String> trailingSegments) {
    java.net.URI _xblockexpression = null;
    {
      final IResource resource = this.findMember(uri);
      if ((resource == null)) {
        String _lastSegment = uri.lastSegment();
        trailingSegments.add(_lastSegment);
        return this.toURI(uri.trimSegments(1), trailingSegments);
      }
      final Function2<IPath, String, IPath> _function = (IPath $0, String $1) -> {
        return $0.append($1);
      };
      _xblockexpression = URIUtil.toURI(IterableExtensions.<String, IPath>fold(ListExtensions.<String>reverse(trailingSegments), resource.getLocation(), _function));
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
