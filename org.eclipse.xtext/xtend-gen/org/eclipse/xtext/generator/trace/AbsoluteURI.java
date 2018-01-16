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
    if ((absoluteURI.isRelative() || (!absoluteURI.isHierarchical()))) {
      String _valueOf = String.valueOf(absoluteURI);
      throw new IllegalArgumentException(_valueOf);
    }
  }
  
  public AbsoluteURI(final String absoluteURI) {
    this(URI.createURI(absoluteURI));
  }
  
  public SourceRelativeURI deresolve(final URI sourceFolderURI) {
    try {
      URI _deresolve = this.getURI().deresolve(sourceFolderURI);
      return new SourceRelativeURI(_deresolve);
    } catch (final Throwable _t) {
      if (_t instanceof IllegalArgumentException) {
        final IllegalArgumentException e = (IllegalArgumentException)_t;
        URI _uRI = this.getURI();
        String _plus = ("Base URI was " + _uRI);
        throw new IllegalArgumentException(_plus, e);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public SourceRelativeURI deresolve(final ISourceFolder sourceFolder) {
    return this.deresolve(sourceFolder.getPath());
  }
  
  public SourceRelativeURI deresolve(final IProjectConfig projectConfig) {
    final ISourceFolder sourceFolder = projectConfig.findSourceFolderContaining(this.getURI());
    SourceRelativeURI _deresolve = null;
    if (sourceFolder!=null) {
      _deresolve=this.deresolve(sourceFolder);
    }
    return _deresolve;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (((obj != null) && (!Objects.equal(obj.getClass(), AbsoluteURI.class)))) {
      String _valueOf = String.valueOf(obj);
      String _plus = (_valueOf + " instanceof ");
      Class<?> _class = null;
      if (obj!=null) {
        _class=obj.getClass();
      }
      String _name = null;
      if (_class!=null) {
        _name=_class.getName();
      }
      String _plus_1 = (_plus + _name);
      throw new IllegalArgumentException(_plus_1);
    }
    return super.equals(obj);
  }
}
