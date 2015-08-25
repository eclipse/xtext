/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.model;

import com.google.common.base.Objects;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class TextFileAccess {
  @Accessors
  private String path;
  
  @Accessors
  private CharSequence content;
  
  public CharSequence generate() {
    return this.content;
  }
  
  public void writeTo(final IFileSystemAccess2 fileSystemAccess) {
    boolean _notEquals = (!Objects.equal(fileSystemAccess, null));
    if (_notEquals) {
      CharSequence _generate = this.generate();
      fileSystemAccess.generateFile(this.path, _generate);
    }
  }
  
  @Pure
  public String getPath() {
    return this.path;
  }
  
  public void setPath(final String path) {
    this.path = path;
  }
  
  @Pure
  public CharSequence getContent() {
    return this.content;
  }
  
  public void setContent(final CharSequence content) {
    this.content = content;
  }
}
