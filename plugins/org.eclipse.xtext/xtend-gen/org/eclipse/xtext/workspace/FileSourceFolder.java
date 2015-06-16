/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.workspace;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
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
    URI _path = this.parent.getPath();
    String[] _split = this.name.split("/");
    return _path.appendSegments(_split);
  }
  
  public FileSourceFolder(final FileProjectConfig parent, final String name) {
    super();
    this.parent = parent;
    this.name = name;
  }
}
