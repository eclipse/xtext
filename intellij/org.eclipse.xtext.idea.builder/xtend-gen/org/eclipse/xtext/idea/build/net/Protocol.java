/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.build.net;

import java.io.Serializable;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.EqualsHashCode;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.jetbrains.jps.incremental.messages.BuildMessage;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class Protocol {
  @Accessors
  @EqualsHashCode
  public static class BuildRequestMessage implements Serializable {
    private List<String> dirtyFiles = CollectionLiterals.<String>newArrayList();
    
    private List<String> deletedFiles = CollectionLiterals.<String>newArrayList();
    
    private List<String> classpath = CollectionLiterals.<String>newArrayList();
    
    private List<String> sourceRoots = CollectionLiterals.<String>newArrayList();
    
    private String baseDir;
    
    private String encoding;
    
    @Pure
    public List<String> getDirtyFiles() {
      return this.dirtyFiles;
    }
    
    public void setDirtyFiles(final List<String> dirtyFiles) {
      this.dirtyFiles = dirtyFiles;
    }
    
    @Pure
    public List<String> getDeletedFiles() {
      return this.deletedFiles;
    }
    
    public void setDeletedFiles(final List<String> deletedFiles) {
      this.deletedFiles = deletedFiles;
    }
    
    @Pure
    public List<String> getClasspath() {
      return this.classpath;
    }
    
    public void setClasspath(final List<String> classpath) {
      this.classpath = classpath;
    }
    
    @Pure
    public List<String> getSourceRoots() {
      return this.sourceRoots;
    }
    
    public void setSourceRoots(final List<String> sourceRoots) {
      this.sourceRoots = sourceRoots;
    }
    
    @Pure
    public String getBaseDir() {
      return this.baseDir;
    }
    
    public void setBaseDir(final String baseDir) {
      this.baseDir = baseDir;
    }
    
    @Pure
    public String getEncoding() {
      return this.encoding;
    }
    
    public void setEncoding(final String encoding) {
      this.encoding = encoding;
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
      Protocol.BuildRequestMessage other = (Protocol.BuildRequestMessage) obj;
      if (this.dirtyFiles == null) {
        if (other.dirtyFiles != null)
          return false;
      } else if (!this.dirtyFiles.equals(other.dirtyFiles))
        return false;
      if (this.deletedFiles == null) {
        if (other.deletedFiles != null)
          return false;
      } else if (!this.deletedFiles.equals(other.deletedFiles))
        return false;
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
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.dirtyFiles== null) ? 0 : this.dirtyFiles.hashCode());
      result = prime * result + ((this.deletedFiles== null) ? 0 : this.deletedFiles.hashCode());
      result = prime * result + ((this.classpath== null) ? 0 : this.classpath.hashCode());
      result = prime * result + ((this.sourceRoots== null) ? 0 : this.sourceRoots.hashCode());
      result = prime * result + ((this.baseDir== null) ? 0 : this.baseDir.hashCode());
      result = prime * result + ((this.encoding== null) ? 0 : this.encoding.hashCode());
      return result;
    }
  }
  
  @Accessors
  @EqualsHashCode
  public static class BuildResultMessage implements Serializable {
    private List<String> dirtyFiles = CollectionLiterals.<String>newArrayList();
    
    private List<String> deletedFiles = CollectionLiterals.<String>newArrayList();
    
    private List<String> outputDirs = CollectionLiterals.<String>newArrayList();
    
    @Pure
    public List<String> getDirtyFiles() {
      return this.dirtyFiles;
    }
    
    public void setDirtyFiles(final List<String> dirtyFiles) {
      this.dirtyFiles = dirtyFiles;
    }
    
    @Pure
    public List<String> getDeletedFiles() {
      return this.deletedFiles;
    }
    
    public void setDeletedFiles(final List<String> deletedFiles) {
      this.deletedFiles = deletedFiles;
    }
    
    @Pure
    public List<String> getOutputDirs() {
      return this.outputDirs;
    }
    
    public void setOutputDirs(final List<String> outputDirs) {
      this.outputDirs = outputDirs;
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
      Protocol.BuildResultMessage other = (Protocol.BuildResultMessage) obj;
      if (this.dirtyFiles == null) {
        if (other.dirtyFiles != null)
          return false;
      } else if (!this.dirtyFiles.equals(other.dirtyFiles))
        return false;
      if (this.deletedFiles == null) {
        if (other.deletedFiles != null)
          return false;
      } else if (!this.deletedFiles.equals(other.deletedFiles))
        return false;
      if (this.outputDirs == null) {
        if (other.outputDirs != null)
          return false;
      } else if (!this.outputDirs.equals(other.outputDirs))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.dirtyFiles== null) ? 0 : this.dirtyFiles.hashCode());
      result = prime * result + ((this.deletedFiles== null) ? 0 : this.deletedFiles.hashCode());
      result = prime * result + ((this.outputDirs== null) ? 0 : this.outputDirs.hashCode());
      return result;
    }
  }
  
  @Accessors
  @EqualsHashCode
  public static class BuildIssueMessage implements Serializable {
    private BuildMessage.Kind kind;
    
    private String message;
    
    private String path;
    
    private int startOffset;
    
    private int endOffset;
    
    private int locationOffset;
    
    private int line;
    
    private int column;
    
    @Pure
    public BuildMessage.Kind getKind() {
      return this.kind;
    }
    
    public void setKind(final BuildMessage.Kind kind) {
      this.kind = kind;
    }
    
    @Pure
    public String getMessage() {
      return this.message;
    }
    
    public void setMessage(final String message) {
      this.message = message;
    }
    
    @Pure
    public String getPath() {
      return this.path;
    }
    
    public void setPath(final String path) {
      this.path = path;
    }
    
    @Pure
    public int getStartOffset() {
      return this.startOffset;
    }
    
    public void setStartOffset(final int startOffset) {
      this.startOffset = startOffset;
    }
    
    @Pure
    public int getEndOffset() {
      return this.endOffset;
    }
    
    public void setEndOffset(final int endOffset) {
      this.endOffset = endOffset;
    }
    
    @Pure
    public int getLocationOffset() {
      return this.locationOffset;
    }
    
    public void setLocationOffset(final int locationOffset) {
      this.locationOffset = locationOffset;
    }
    
    @Pure
    public int getLine() {
      return this.line;
    }
    
    public void setLine(final int line) {
      this.line = line;
    }
    
    @Pure
    public int getColumn() {
      return this.column;
    }
    
    public void setColumn(final int column) {
      this.column = column;
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
      Protocol.BuildIssueMessage other = (Protocol.BuildIssueMessage) obj;
      if (this.kind == null) {
        if (other.kind != null)
          return false;
      } else if (!this.kind.equals(other.kind))
        return false;
      if (this.message == null) {
        if (other.message != null)
          return false;
      } else if (!this.message.equals(other.message))
        return false;
      if (this.path == null) {
        if (other.path != null)
          return false;
      } else if (!this.path.equals(other.path))
        return false;
      if (other.startOffset != this.startOffset)
        return false;
      if (other.endOffset != this.endOffset)
        return false;
      if (other.locationOffset != this.locationOffset)
        return false;
      if (other.line != this.line)
        return false;
      if (other.column != this.column)
        return false;
      return true;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.kind== null) ? 0 : this.kind.hashCode());
      result = prime * result + ((this.message== null) ? 0 : this.message.hashCode());
      result = prime * result + ((this.path== null) ? 0 : this.path.hashCode());
      result = prime * result + this.startOffset;
      result = prime * result + this.endOffset;
      result = prime * result + this.locationOffset;
      result = prime * result + this.line;
      result = prime * result + this.column;
      return result;
    }
  }
}
