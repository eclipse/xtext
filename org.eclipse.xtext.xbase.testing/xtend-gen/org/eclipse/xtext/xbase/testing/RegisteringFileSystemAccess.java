/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.testing;

import java.util.Set;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noreference This class is not intended to be referenced by clients.
 * 
 * @since 2.7
 */
@SuppressWarnings("all")
public class RegisteringFileSystemAccess extends InMemoryFileSystemAccess {
  /**
   * @noreference This class is not intended to be referenced by clients.
   */
  @Data
  public static class GeneratedFile {
    private final String path;
    
    private final String javaClassName;
    
    private final CharSequence contents;
    
    public GeneratedFile(final String path, final String javaClassName, final CharSequence contents) {
      super();
      this.path = path;
      this.javaClassName = javaClassName;
      this.contents = contents;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.path== null) ? 0 : this.path.hashCode());
      result = prime * result + ((this.javaClassName== null) ? 0 : this.javaClassName.hashCode());
      return prime * result + ((this.contents== null) ? 0 : this.contents.hashCode());
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
      RegisteringFileSystemAccess.GeneratedFile other = (RegisteringFileSystemAccess.GeneratedFile) obj;
      if (this.path == null) {
        if (other.path != null)
          return false;
      } else if (!this.path.equals(other.path))
        return false;
      if (this.javaClassName == null) {
        if (other.javaClassName != null)
          return false;
      } else if (!this.javaClassName.equals(other.javaClassName))
        return false;
      if (this.contents == null) {
        if (other.contents != null)
          return false;
      } else if (!this.contents.equals(other.contents))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("path", this.path);
      b.add("javaClassName", this.javaClassName);
      b.add("contents", this.contents);
      return b.toString();
    }
    
    @Pure
    public String getPath() {
      return this.path;
    }
    
    @Pure
    public String getJavaClassName() {
      return this.javaClassName;
    }
    
    @Pure
    public CharSequence getContents() {
      return this.contents;
    }
  }
  
  @Accessors
  private final Set<RegisteringFileSystemAccess.GeneratedFile> generatedFiles = CollectionLiterals.<RegisteringFileSystemAccess.GeneratedFile>newHashSet();
  
  @Accessors
  private String projectName;
  
  @Override
  public void generateFile(final String fileName, final String outputConfigurationName, final CharSequence contents) {
    super.generateFile(fileName, outputConfigurationName, contents);
    final String path = this.getPath(fileName, outputConfigurationName);
    String _xifexpression = null;
    boolean _endsWith = fileName.endsWith(".java");
    if (_endsWith) {
      int _length = fileName.length();
      int _minus = (_length - 5);
      _xifexpression = fileName.substring(0, _minus).replace("/", ".");
    }
    final String javaName = _xifexpression;
    RegisteringFileSystemAccess.GeneratedFile _generatedFile = new RegisteringFileSystemAccess.GeneratedFile(path, javaName, contents);
    this.generatedFiles.add(_generatedFile);
  }
  
  protected String getPath(final String fileName, final String outputConfigurationName) {
    final String path = this.getPathes().get(outputConfigurationName);
    return ((((("/" + this.projectName) + "/") + path) + "/") + fileName);
  }
  
  @Pure
  public Set<RegisteringFileSystemAccess.GeneratedFile> getGeneratedFiles() {
    return this.generatedFiles;
  }
  
  @Pure
  public String getProjectName() {
    return this.projectName;
  }
  
  public void setProjectName(final String projectName) {
    this.projectName = projectName;
  }
}
