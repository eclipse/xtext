/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator;

import com.google.common.base.Objects;
import com.google.common.io.ByteStreams;
import com.google.common.io.CharStreams;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Map;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.generator.AbstractFileSystemAccess2;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.util.RuntimeIOException;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * A file system access implementation that is based on EMF URIs and URIConverter
 * @since 2.9
 */
@SuppressWarnings("all")
public class URIBasedFileSystemAccess extends AbstractFileSystemAccess2 {
  public interface BeforeDelete {
    /**
     * @return <code>true</code> if the file can be deleted, false otherwise
     */
    public abstract boolean beforeDelete(final URI changed);
  }
  
  public interface BeforeWrite {
    public abstract InputStream beforeWrite(final URI changed, final InputStream in);
  }
  
  public interface BeforeRead {
    public abstract InputStream beforeRead(final URI changed, final InputStream in);
  }
  
  @Accessors
  private URIConverter converter;
  
  @Accessors
  private IEncodingProvider encodingProvider = new IEncodingProvider.Runtime();
  
  @Accessors
  private URIBasedFileSystemAccess.BeforeDelete beforeDelete = new URIBasedFileSystemAccess.BeforeDelete() {
    @Override
    public boolean beforeDelete(final URI it) {
      return true;
    }
  };
  
  @Accessors
  private URIBasedFileSystemAccess.BeforeWrite beforeWrite = new URIBasedFileSystemAccess.BeforeWrite() {
    @Override
    public InputStream beforeWrite(final URI $0, final InputStream $1) {
      return $1;
    }
  };
  
  @Accessors
  private URIBasedFileSystemAccess.BeforeRead beforeRead = new URIBasedFileSystemAccess.BeforeRead() {
    @Override
    public InputStream beforeRead(final URI $0, final InputStream $1) {
      return $1;
    }
  };
  
  @Override
  public URI getURI(final String path, final String outputConfiguration) {
    Map<String, String> _pathes = this.getPathes();
    final String outlet = _pathes.get(outputConfiguration);
    boolean _equals = Objects.equal(outlet, null);
    if (_equals) {
      throw new IllegalArgumentException((("A slot with name \'" + outputConfiguration) + "\' has not been configured."));
    }
    final URI uri = URI.createURI(((outlet + "/") + path));
    return uri;
  }
  
  public String getEncoding(final URI uri) {
    return this.encodingProvider.getEncoding(uri);
  }
  
  @Override
  public void generateFile(final String fileName, final String outputCfgName, final CharSequence contents) {
    try {
      final URI uri = this.getURI(fileName, outputCfgName);
      final String encoding = this.getEncoding(uri);
      String _string = contents.toString();
      byte[] _bytes = _string.getBytes(encoding);
      final ByteArrayInputStream inStream = new ByteArrayInputStream(_bytes);
      this.generateFile(fileName, outputCfgName, inStream);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public void generateFile(final String fileName, final String outputCfgName, final InputStream content) throws RuntimeIOException {
    try {
      final URI uri = this.getURI(fileName, outputCfgName);
      final OutputStream out = this.converter.createOutputStream(uri);
      try {
        final InputStream processedContent = this.beforeWrite.beforeWrite(uri, content);
        ByteStreams.copy(processedContent, out);
      } finally {
        out.close();
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public InputStream readBinaryFile(final String fileName, final String outputCfgName) throws RuntimeIOException {
    try {
      final URI uri = this.getURI(fileName, outputCfgName);
      final InputStream input = this.converter.createInputStream(uri);
      return this.beforeRead.beforeRead(uri, input);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public CharSequence readTextFile(final String fileName, final String outputCfgName) throws RuntimeIOException {
    try {
      final URI uri = this.getURI(fileName, outputCfgName);
      final InputStream inputstream = this.readBinaryFile(fileName, outputCfgName);
      String _encoding = this.getEncoding(uri);
      InputStreamReader _inputStreamReader = new InputStreamReader(inputstream, _encoding);
      return CharStreams.toString(_inputStreamReader);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Pure
  public URIConverter getConverter() {
    return this.converter;
  }
  
  public void setConverter(final URIConverter converter) {
    this.converter = converter;
  }
  
  @Pure
  public IEncodingProvider getEncodingProvider() {
    return this.encodingProvider;
  }
  
  public void setEncodingProvider(final IEncodingProvider encodingProvider) {
    this.encodingProvider = encodingProvider;
  }
  
  @Pure
  public URIBasedFileSystemAccess.BeforeDelete getBeforeDelete() {
    return this.beforeDelete;
  }
  
  public void setBeforeDelete(final URIBasedFileSystemAccess.BeforeDelete beforeDelete) {
    this.beforeDelete = beforeDelete;
  }
  
  @Pure
  public URIBasedFileSystemAccess.BeforeWrite getBeforeWrite() {
    return this.beforeWrite;
  }
  
  public void setBeforeWrite(final URIBasedFileSystemAccess.BeforeWrite beforeWrite) {
    this.beforeWrite = beforeWrite;
  }
  
  @Pure
  public URIBasedFileSystemAccess.BeforeRead getBeforeRead() {
    return this.beforeRead;
  }
  
  public void setBeforeRead(final URIBasedFileSystemAccess.BeforeRead beforeRead) {
    this.beforeRead = beforeRead;
  }
}
