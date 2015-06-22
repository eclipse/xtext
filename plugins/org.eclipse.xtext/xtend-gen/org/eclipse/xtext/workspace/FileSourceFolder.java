/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.workspace;

import com.google.common.base.Objects;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.workspace.FileProjectConfig;
import org.eclipse.xtext.workspace.ISourceFolder;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class FileSourceFolder implements ISourceFolder {
  private final FileProjectConfig parent;
  
  private final String name;
  
  @Override
  public String getName() {
    return this.name;
  }
  
  @Override
  public URI getPath() {
    URI _createFileURI = URI.createFileURI(this.name);
    URI _path = this.parent.getPath();
    URI _resolve = _createFileURI.resolve(_path);
    return _resolve.appendSegment("");
  }
  
  @Override
  public boolean equals(final Object obj) {
    if ((obj instanceof FileSourceFolder)) {
      URI _path = this.getPath();
      URI _path_1 = ((FileSourceFolder)obj).getPath();
      return Objects.equal(_path, _path_1);
    }
    return false;
  }
  
  @Override
  public int hashCode() {
    URI _path = this.getPath();
    return _path.hashCode();
  }
  
  @Override
  public String toString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(this.name, "");
    _builder.append(" (");
    URI _path = this.getPath();
    _builder.append(_path, "");
    _builder.append(")");
    return _builder.toString();
  }
  
  public FileSourceFolder(final FileProjectConfig parent, final String name) {
    super();
    this.parent = parent;
    this.name = name;
  }
}
