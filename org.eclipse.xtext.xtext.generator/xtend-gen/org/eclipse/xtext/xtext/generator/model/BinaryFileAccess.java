/**
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.model;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * A utility class for generating binary files.
 */
@SuppressWarnings("all")
public class BinaryFileAccess {
  @Accessors
  private String path;
  
  protected byte[] internalContents;
  
  public void setContent(final byte[] content) {
    this.internalContents = content;
  }
  
  public byte[] getContent() {
    return Arrays.copyOf(this.internalContents, this.internalContents.length);
  }
  
  public void writeTo(final IFileSystemAccess2 fileSystemAccess) {
    if ((fileSystemAccess != null)) {
      ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(this.internalContents);
      fileSystemAccess.generateFile(this.path, _byteArrayInputStream);
    }
  }
  
  @Pure
  public String getPath() {
    return this.path;
  }
  
  public void setPath(final String path) {
    this.path = path;
  }
}
