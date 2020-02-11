/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.model;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * A utility class for generating plain text files.
 */
@SuppressWarnings("all")
public class TextFileAccess {
  @Accessors
  private String path;
  
  protected CharSequence internalContents;
  
  public void setContent(final StringConcatenationClient content) {
    StringConcatenation _stringConcatenation = new StringConcatenation();
    final Procedure1<StringConcatenation> _function = (StringConcatenation it) -> {
      it.append(content);
    };
    StringConcatenation _doubleArrow = ObjectExtensions.<StringConcatenation>operator_doubleArrow(_stringConcatenation, _function);
    this.internalContents = _doubleArrow;
  }
  
  public CharSequence getContent() {
    return this.internalContents.toString();
  }
  
  public String getContentString() {
    return this.getContent().toString();
  }
  
  public void writeTo(final IFileSystemAccess2 fileSystemAccess) {
    if ((fileSystemAccess != null)) {
      fileSystemAccess.generateFile(this.path, this.getContent());
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
