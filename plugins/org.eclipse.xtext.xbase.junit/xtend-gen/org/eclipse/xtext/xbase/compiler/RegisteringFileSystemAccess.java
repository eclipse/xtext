/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.compiler;

import com.google.inject.Inject;
import java.io.File;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.IWorkspaceConfig;
import org.eclipse.xtext.workspace.IWorkspaceConfigProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
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
public class RegisteringFileSystemAccess extends JavaIoFileSystemAccess {
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
      result = prime * result + ((this.contents== null) ? 0 : this.contents.hashCode());
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
  
  @Inject
  private IWorkspaceConfigProvider workspaceConfigProvider;
  
  @Accessors
  private final Set<RegisteringFileSystemAccess.GeneratedFile> textFiles = CollectionLiterals.<RegisteringFileSystemAccess.GeneratedFile>newHashSet();
  
  @Accessors
  private Object context;
  
  @Override
  public void generateFile(final String fileName, final String outputConfigurationName, final CharSequence contents) {
    super.generateFile(fileName, outputConfigurationName, contents);
    final String path = this.getPath(fileName, outputConfigurationName);
    String _xifexpression = null;
    boolean _endsWith = fileName.endsWith(".java");
    if (_endsWith) {
      int _length = fileName.length();
      int _minus = (_length - 5);
      String _substring = fileName.substring(0, _minus);
      _xifexpression = _substring.replace("/", ".");
    }
    final String javaName = _xifexpression;
    RegisteringFileSystemAccess.GeneratedFile _generatedFile = new RegisteringFileSystemAccess.GeneratedFile(path, javaName, contents);
    this.textFiles.add(_generatedFile);
  }
  
  protected String getPath(final String fileName, final String outputConfigurationName) {
    Map<String, String> _pathes = this.getPathes();
    final String path = _pathes.get(outputConfigurationName);
    IProjectConfig _project = this.getProject();
    String _name = _project.getName();
    String _plus = ("/" + _name);
    String _plus_1 = (_plus + "/");
    String _plus_2 = (_plus_1 + path);
    String _plus_3 = (_plus_2 + "/");
    return (_plus_3 + fileName);
  }
  
  @Override
  protected File getFile(final String fileName, final String outputConfigName) {
    File _xblockexpression = null;
    {
      Map<String, String> _pathes = this.getPathes();
      final String outlet = _pathes.get(outputConfigName);
      if ((outlet == null)) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("A slot with name \'");
        _builder.append(outputConfigName, "");
        _builder.append("\' has not been configured.");
        throw new IllegalArgumentException(_builder.toString());
      }
      IProjectConfig _project = this.getProject();
      URI _path = _project.getPath();
      String _fileString = _path.toFileString();
      _xblockexpression = new File(_fileString, ((outlet + "/") + fileName));
    }
    return _xblockexpression;
  }
  
  public IProjectConfig getProject() {
    IProjectConfig _xifexpression = null;
    if ((this.context instanceof Resource)) {
      IWorkspaceConfig _workspaceConfig = this.workspaceConfigProvider.getWorkspaceConfig(((Resource)this.context));
      Set<? extends IProjectConfig> _projects = _workspaceConfig.getProjects();
      _xifexpression = IterableExtensions.head(_projects);
    }
    return _xifexpression;
  }
  
  @Pure
  public Set<RegisteringFileSystemAccess.GeneratedFile> getTextFiles() {
    return this.textFiles;
  }
  
  @Pure
  public Object getContext() {
    return this.context;
  }
  
  public void setContext(final Object context) {
    this.context = context;
  }
}
