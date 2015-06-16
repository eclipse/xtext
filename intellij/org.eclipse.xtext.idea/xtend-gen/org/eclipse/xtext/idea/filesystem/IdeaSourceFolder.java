/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.filesystem;

import com.intellij.openapi.roots.SourceFolder;
import com.intellij.openapi.vfs.VirtualFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.idea.extensions.RootModelExtensions;
import org.eclipse.xtext.workspace.ISourceFolder;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class IdeaSourceFolder implements ISourceFolder {
  private final SourceFolder folder;
  
  @Override
  public String getName() {
    return RootModelExtensions.getRelativePath(this.folder);
  }
  
  @Override
  public URI getPath() {
    VirtualFile _file = this.folder.getFile();
    String _url = _file.getUrl();
    return URI.createURI(_url);
  }
  
  public IdeaSourceFolder(final SourceFolder folder) {
    super();
    this.folder = folder;
  }
}
