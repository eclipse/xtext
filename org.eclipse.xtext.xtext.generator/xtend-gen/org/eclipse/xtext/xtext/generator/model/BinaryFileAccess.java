/**
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.model;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;

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
  
  public boolean existIn(final IXtextGeneratorFileSystemAccess fileSystemAccess) {
    if ((fileSystemAccess == null)) {
      return false;
    }
    return fileSystemAccess.isFile(this.path);
  }
  
  @Pure
  public String getPath() {
    return this.path;
  }
  
  public void setPath(final String path) {
    this.path = path;
  }
}
