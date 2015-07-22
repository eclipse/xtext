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
import org.eclipse.xtext.workspace.IWorkspaceConfig;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class AbsoluteURI extends AbstractURIWrapper {
  public AbsoluteURI(final URI absoluteURI) {
    super(absoluteURI);
    boolean _isRelative = absoluteURI.isRelative();
    if (_isRelative) {
      String _valueOf = String.valueOf(absoluteURI);
      throw new IllegalArgumentException(_valueOf);
    }
  }
  
  public AbsoluteURI(final String absoluteURI) {
    this(URI.createURI(absoluteURI));
  }
  
  public SourceRelativeURI deresolve(final ISourceFolder sourceFolder) {
    URI _uRI = this.getURI();
    URI _path = sourceFolder.getPath();
    URI _deresolve = _uRI.deresolve(_path);
    return new SourceRelativeURI(_deresolve);
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
  
  public SourceRelativeURI deresolve(final IWorkspaceConfig workspaceConfig) {
    URI _uRI = this.getURI();
    final IProjectConfig project = workspaceConfig.findProjectContaining(_uRI);
    SourceRelativeURI _deresolve = null;
    if (project!=null) {
      _deresolve=this.deresolve(project);
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
      boolean _equals = Objects.equal(_class, SourceRelativeURI.class);
      _and = _equals;
    }
    if (_and) {
      String _valueOf = String.valueOf(obj);
      throw new IllegalArgumentException(_valueOf);
    }
    return super.equals(obj);
  }
}
