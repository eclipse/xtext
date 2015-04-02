/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.build.daemon;

import java.io.File;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.idea.build.daemon.Protocol;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@Data
@SuppressWarnings("all")
public class XtextBuildParameters {
  private final List<File> classpath;
  
  private final List<File> sourceRoots;
  
  private final File baseDir;
  
  private final String encoding;
  
  public XtextBuildParameters(final Protocol.BuildRequest request) {
    List<String> _classpath = request.getClasspath();
    final Function1<String, File> _function = new Function1<String, File>() {
      @Override
      public File apply(final String it) {
        return XtextBuildParameters.this.toFile(it);
      }
    };
    List<File> _map = ListExtensions.<String, File>map(_classpath, _function);
    this.classpath = _map;
    List<String> _sourceRoots = request.getSourceRoots();
    final Function1<String, File> _function_1 = new Function1<String, File>() {
      @Override
      public File apply(final String it) {
        return XtextBuildParameters.this.toFile(it);
      }
    };
    List<File> _map_1 = ListExtensions.<String, File>map(_sourceRoots, _function_1);
    this.sourceRoots = _map_1;
    String _baseDir = request.getBaseDir();
    File _file = this.toFile(_baseDir);
    this.baseDir = _file;
    String _encoding = request.getEncoding();
    this.encoding = _encoding;
  }
  
  protected File toFile(final String it) {
    return new File(it);
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.classpath== null) ? 0 : this.classpath.hashCode());
    result = prime * result + ((this.sourceRoots== null) ? 0 : this.sourceRoots.hashCode());
    result = prime * result + ((this.baseDir== null) ? 0 : this.baseDir.hashCode());
    result = prime * result + ((this.encoding== null) ? 0 : this.encoding.hashCode());
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
    XtextBuildParameters other = (XtextBuildParameters) obj;
    if (this.classpath == null) {
      if (other.classpath != null)
        return false;
    } else if (!this.classpath.equals(other.classpath))
      return false;
    if (this.sourceRoots == null) {
      if (other.sourceRoots != null)
        return false;
    } else if (!this.sourceRoots.equals(other.sourceRoots))
      return false;
    if (this.baseDir == null) {
      if (other.baseDir != null)
        return false;
    } else if (!this.baseDir.equals(other.baseDir))
      return false;
    if (this.encoding == null) {
      if (other.encoding != null)
        return false;
    } else if (!this.encoding.equals(other.encoding))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("classpath", this.classpath);
    b.add("sourceRoots", this.sourceRoots);
    b.add("baseDir", this.baseDir);
    b.add("encoding", this.encoding);
    return b.toString();
  }
  
  @Pure
  public List<File> getClasspath() {
    return this.classpath;
  }
  
  @Pure
  public List<File> getSourceRoots() {
    return this.sourceRoots;
  }
  
  @Pure
  public File getBaseDir() {
    return this.baseDir;
  }
  
  @Pure
  public String getEncoding() {
    return this.encoding;
  }
}
