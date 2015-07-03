/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.generator;

import com.google.common.base.Objects;
import java.util.Iterator;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * A file system access that simply stores all generated file contents in a list.
 * Attempts to write files to output configurations other than the default output
 * are ignored.
 */
@SuppressWarnings("all")
public class ResponseFileSystemAccess implements IFileSystemAccess {
  @Data
  public static class ResponseFile {
    private final String name;
    
    private final CharSequence content;
    
    public ResponseFile(final String name, final CharSequence content) {
      super();
      this.name = name;
      this.content = content;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.name== null) ? 0 : this.name.hashCode());
      result = prime * result + ((this.content== null) ? 0 : this.content.hashCode());
      return result;
    }
    
    @Override
    @Pure
    public boolean equals(final Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      ResponseFileSystemAccess.ResponseFile other = (ResponseFileSystemAccess.ResponseFile) obj;
      if (this.name == null) {
        if (other.name != null)
          return false;
      } else if (!this.name.equals(other.name))
        return false;
      if (this.content == null) {
        if (other.content != null)
          return false;
      } else if (!this.content.equals(other.content))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("name", this.name);
      b.add("content", this.content);
      return b.toString();
    }
    
    @Pure
    public String getName() {
      return this.name;
    }
    
    @Pure
    public CharSequence getContent() {
      return this.content;
    }
  }
  
  @Accessors
  private final List<ResponseFileSystemAccess.ResponseFile> files = CollectionLiterals.<ResponseFileSystemAccess.ResponseFile>newArrayList();
  
  @Override
  public void generateFile(final String fileName, final CharSequence contents) {
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(fileName);
    boolean _not = (!_isNullOrEmpty);
    if (_not) {
      this.deleteFile(fileName);
    }
    ResponseFileSystemAccess.ResponseFile _responseFile = new ResponseFileSystemAccess.ResponseFile(fileName, contents);
    this.files.add(_responseFile);
  }
  
  @Override
  public void generateFile(final String fileName, final String outputConfigurationName, final CharSequence contents) {
    boolean _equals = Objects.equal(outputConfigurationName, IFileSystemAccess.DEFAULT_OUTPUT);
    if (_equals) {
      this.generateFile(fileName, contents);
    }
  }
  
  @Override
  public void deleteFile(final String fileName) {
    if ((fileName == null)) {
      throw new NullPointerException();
    }
    final Iterator<ResponseFileSystemAccess.ResponseFile> iterator = this.files.iterator();
    while (iterator.hasNext()) {
      ResponseFileSystemAccess.ResponseFile _next = iterator.next();
      boolean _equals = Objects.equal(_next.name, fileName);
      if (_equals) {
        iterator.remove();
        return;
      }
    }
  }
  
  @Pure
  public List<ResponseFileSystemAccess.ResponseFile> getFiles() {
    return this.files;
  }
}
