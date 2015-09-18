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
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class TextFileAccess {
  @Accessors
  private String path;
  
  protected CharSequence internalContents;
  
  public CharSequence setContent(final StringConcatenationClient content) {
    StringConcatenation _stringConcatenation = new StringConcatenation();
    final Procedure1<StringConcatenation> _function = new Procedure1<StringConcatenation>() {
      @Override
      public void apply(final StringConcatenation it) {
        it.append(content);
      }
    };
    StringConcatenation _doubleArrow = ObjectExtensions.<StringConcatenation>operator_doubleArrow(_stringConcatenation, _function);
    return this.internalContents = _doubleArrow;
  }
  
  public CharSequence getContent() {
    return this.internalContents.toString();
  }
  
  public void writeTo(final IFileSystemAccess2 fileSystemAccess) {
    boolean _notEquals = (!Objects.equal(fileSystemAccess, null));
    if (_notEquals) {
      CharSequence _content = this.getContent();
      fileSystemAccess.generateFile(this.path, _content);
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
