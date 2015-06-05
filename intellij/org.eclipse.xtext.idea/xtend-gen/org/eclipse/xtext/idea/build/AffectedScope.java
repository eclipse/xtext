/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.build;

import com.intellij.openapi.compiler.CompileScope;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.vfs.VirtualFile;
import java.util.HashSet;
import java.util.Map;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class AffectedScope implements CompileScope {
  @Accessors
  private final HashSet<URI> affectedFiles = CollectionLiterals.<URI>newHashSet();
  
  @Override
  public boolean belongs(final String url) {
    boolean _xblockexpression = false;
    {
      final URI uri = URI.createURI(url);
      _xblockexpression = this.affectedFiles.contains(uri);
    }
    return _xblockexpression;
  }
  
  @Override
  public Module[] getAffectedModules() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public VirtualFile[] getFiles(final FileType fileType, final boolean inSourceOnly) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public Map<Key, Object> exportUserData() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public <T extends Object> T getUserData(final Key<T> key) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public <T extends Object> void putUserData(final Key<T> key, final T value) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Pure
  public HashSet<URI> getAffectedFiles() {
    return this.affectedFiles;
  }
}
