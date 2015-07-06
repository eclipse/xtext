/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.model;

import com.google.common.io.Files;
import java.io.File;
import java.nio.charset.Charset;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class TextFileAccess {
  @Accessors
  private String path;
  
  @Accessors
  private CharSequence content;
  
  @Accessors
  private IEncodingProvider encodingProvider;
  
  public CharSequence generate() {
    return this.content;
  }
  
  public void writeTo(final IFileSystemAccess2 fileSystemAccess) {
    CharSequence _generate = this.generate();
    fileSystemAccess.generateFile(this.path, _generate);
  }
  
  public void writeToFile() {
    try {
      Charset charset = null;
      if ((this.encodingProvider != null)) {
        final URI uri = URI.createFileURI(this.path);
        String _encoding = this.encodingProvider.getEncoding(uri);
        Charset _forName = Charset.forName(_encoding);
        charset = _forName;
      } else {
        Charset _defaultCharset = Charset.defaultCharset();
        charset = _defaultCharset;
      }
      CharSequence _generate = this.generate();
      File _file = new File(this.path);
      Files.write(_generate, _file, charset);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Pure
  public String getPath() {
    return this.path;
  }
  
  public void setPath(final String path) {
    this.path = path;
  }
  
  @Pure
  public CharSequence getContent() {
    return this.content;
  }
  
  public void setContent(final CharSequence content) {
    this.content = content;
  }
  
  @Pure
  public IEncodingProvider getEncodingProvider() {
    return this.encodingProvider;
  }
  
  public void setEncodingProvider(final IEncodingProvider encodingProvider) {
    this.encodingProvider = encodingProvider;
  }
}
