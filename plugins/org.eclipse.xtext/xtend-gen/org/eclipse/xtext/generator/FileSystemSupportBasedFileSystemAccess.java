/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator;

import com.google.inject.Inject;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtext.generator.AbstractFileSystemAccess2;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IFileSystemAccessExtension;
import org.eclipse.xtext.generator.IFileSystemAccessExtension2;
import org.eclipse.xtext.generator.IFileSystemAccessExtension3;
import org.eclipse.xtext.util.RuntimeIOException;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * An adapter between {org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport} and {org.eclipse.xtext.generator.IFileSystemAccess}
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.7
 */
@SuppressWarnings("all")
public class FileSystemSupportBasedFileSystemAccess extends AbstractFileSystemAccess2 implements IFileSystemAccess, IFileSystemAccessExtension, IFileSystemAccessExtension2, IFileSystemAccessExtension3 {
  @Inject
  @Accessors(AccessorType.PUBLIC_SETTER)
  @Extension
  private MutableFileSystemSupport fileSystemSupport;
  
  @Accessors(AccessorType.PUBLIC_SETTER)
  private String projectName;
  
  protected Path getPath(final String fileName, final String outputConfigurationName) {
    Map<String, String> _pathes = this.getPathes();
    final String path = _pathes.get(outputConfigurationName);
    return new Path(((((("/" + this.projectName) + "/") + path) + "/") + fileName));
  }
  
  @Override
  public void generateFile(final String fileName, final String outputConfigurationName, final CharSequence contents) {
    final Path path = this.getPath(fileName, outputConfigurationName);
    this.fileSystemSupport.setContents(path, contents);
  }
  
  @Override
  public URI getURI(final String fileName, final String outputConfiguration) {
    try {
      Path _path = this.getPath(fileName, outputConfiguration);
      java.net.URI _uRI = this.fileSystemSupport.toURI(_path);
      URL _uRL = _uRI.toURL();
      String _file = _uRL.getFile();
      return URI.createFileURI(_file);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public void generateFile(final String fileName, final String outputConfigurationName, final InputStream content) throws RuntimeIOException {
    final Path path = this.getPath(fileName, outputConfigurationName);
    this.fileSystemSupport.setContentsAsStream(path, content);
  }
  
  @Override
  public InputStream readBinaryFile(final String fileName, final String outputConfigurationName) throws RuntimeIOException {
    final Path path = this.getPath(fileName, outputConfigurationName);
    return this.fileSystemSupport.getContentsAsStream(path);
  }
  
  @Override
  public CharSequence readTextFile(final String fileName, final String outputConfigurationName) throws RuntimeIOException {
    final Path path = this.getPath(fileName, outputConfigurationName);
    return this.fileSystemSupport.getContents(path);
  }
  
  public void setFileSystemSupport(final MutableFileSystemSupport fileSystemSupport) {
    this.fileSystemSupport = fileSystemSupport;
  }
  
  public void setProjectName(final String projectName) {
    this.projectName = projectName;
  }
}
