/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.trace;

import com.google.common.base.Objects;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.generator.trace.AbstractURIWrapper;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.ISourceFolder;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * An absolute URI that allows to obtain a resource in a {@link IProjectConfig project}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class AbsoluteURI extends AbstractURIWrapper {
  public AbsoluteURI(final URI absoluteURI) {
    super(absoluteURI);
    boolean _or = false;
    boolean _isRelative = absoluteURI.isRelative();
    if (_isRelative) {
      _or = true;
    } else {
      boolean _isHierarchical = absoluteURI.isHierarchical();
      boolean _not = (!_isHierarchical);
      _or = _not;
    }
    if (_or) {
      String _valueOf = String.valueOf(absoluteURI);
      throw new IllegalArgumentException(_valueOf);
    }
  }
  
  public AbsoluteURI(final String absoluteURI) {
    this(URI.createURI(absoluteURI));
  }
  
  public SourceRelativeURI deresolve(final URI sourceFolderURI) {
    try {
      URI _uRI = this.getURI();
      URI _deresolve = _uRI.deresolve(sourceFolderURI);
      return new SourceRelativeURI(_deresolve);
    } catch (final Throwable _t) {
      if (_t instanceof IllegalArgumentException) {
        final IllegalArgumentException e = (IllegalArgumentException)_t;
        URI _uRI_1 = this.getURI();
        String _plus = ("Base URI was " + _uRI_1);
        throw new IllegalArgumentException(_plus, e);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public SourceRelativeURI deresolve(final ISourceFolder sourceFolder) {
    URI _path = sourceFolder.getPath();
    return this.deresolve(_path);
  }
  
  public SourceRelativeURI deresolve(final IProjectConfig projectConfig) {
    URI _uRI = this.getURI();
    final ISourceFolder sourceFolder = projectConfig.findSourceFolderContaining(_uRI);
    SourceRelativeURI _deresolve = null;
    if (sourceFolder!=null) {
      _deresolve=this.deresolve(sourceFolder);
    }
    return _deresolve;
  }
  
  @Override
  public boolean equals(final Object obj) {
    boolean _and = false;
    if (!(obj != null)) {
      _and = false;
    } else {
      Class<?> _class = obj.getClass();
      boolean _notEquals = (!Objects.equal(_class, AbsoluteURI.class));
      _and = _notEquals;
    }
    if (_and) {
      String _valueOf = String.valueOf(obj);
      String _plus = (_valueOf + " instanceof ");
      Class<?> _class_1 = null;
      if (obj!=null) {
        _class_1=obj.getClass();
      }
      String _name = null;
      if (_class_1!=null) {
        _name=_class_1.getName();
      }
      String _plus_1 = (_plus + _name);
      throw new IllegalArgumentException(_plus_1);
    }
    return super.equals(obj);
  }
}
