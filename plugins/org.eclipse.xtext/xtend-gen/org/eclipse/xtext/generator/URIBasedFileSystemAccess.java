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
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Map;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.generator.AbstractFileSystemAccess2;
import org.eclipse.xtext.generator.IFilePostProcessor;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ITraceRegionProvider;
import org.eclipse.xtext.generator.trace.TraceFileNameProvider;
import org.eclipse.xtext.generator.trace.TraceRegionSerializer;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.util.RuntimeIOException;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
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
    public abstract InputStream beforeWrite(final URI changed, final String outputCfgName, final InputStream in);
  }
  
  public interface BeforeRead {
    public abstract InputStream beforeRead(final URI changed, final InputStream in);
  }
  
  @Accessors
  private URIConverter converter;
  
  @Accessors
  private URI baseDir;
  
  @Accessors
  private boolean generateTraces = false;
  
  @Accessors
  private IEncodingProvider encodingProvider = new IEncodingProvider.Runtime();
  
  @Accessors
  private TraceRegionSerializer traceRegionSerializer;
  
  @Accessors
  private TraceFileNameProvider traceFileNameProvider;
  
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
    public InputStream beforeWrite(final URI $0, final String $1, final InputStream $2) {
      return $2;
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
  public void setPostProcessor(final IFilePostProcessor filePostProcessor) {
    super.setPostProcessor(filePostProcessor);
  }
  
  @Override
  public URI getURI(final String path, final String outputConfiguration) {
    Map<String, String> _pathes = this.getPathes();
    final String outlet = _pathes.get(outputConfiguration);
    boolean _equals = Objects.equal(outlet, null);
    if (_equals) {
      throw new IllegalArgumentException((("A slot with name \'" + outputConfiguration) + "\' has not been configured."));
    }
    final URI uri = URI.createFileURI(((outlet + File.separator) + path));
    boolean _notEquals = (!Objects.equal(this.baseDir, null));
    if (_notEquals) {
      final URI resolved = uri.resolve(this.baseDir);
      return resolved;
    } else {
      return uri;
    }
  }
  
  public String getEncoding(final URI uri) {
    return this.encodingProvider.getEncoding(uri);
  }
  
  @Override
  public void generateFile(final String fileName, final String outputCfgName, final CharSequence contents) {
    try {
      final URI uri = this.getURI(fileName, outputCfgName);
      boolean _and = false;
      OutputConfiguration _outputConfig = this.getOutputConfig(outputCfgName);
      boolean _isOverrideExistingResources = _outputConfig.isOverrideExistingResources();
      boolean _not = (!_isOverrideExistingResources);
      if (!_not) {
        _and = false;
      } else {
        Map<Object, Object> _emptyMap = CollectionLiterals.<Object, Object>emptyMap();
        boolean _exists = this.converter.exists(uri, _emptyMap);
        _and = _exists;
      }
      if (_and) {
        return;
      }
      final String encoding = this.getEncoding(uri);
      final CharSequence postProcessed = this.postProcess(fileName, outputCfgName, contents, encoding);
      this.generateTrace(fileName, outputCfgName, postProcessed);
      String _string = postProcessed.toString();
      byte[] _bytes = _string.getBytes(encoding);
      final ByteArrayInputStream inStream = new ByteArrayInputStream(_bytes);
      this.generateFile(fileName, outputCfgName, inStream);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void generateTrace(final String generatedFile, final String outputConfigName, final CharSequence contents) {
    try {
      boolean _and = false;
      boolean _isGenerateTraces = this.isGenerateTraces();
      if (!_isGenerateTraces) {
        _and = false;
      } else {
        _and = (contents instanceof ITraceRegionProvider);
      }
      if (_and) {
        String traceFileName = this.traceFileNameProvider.getTraceFromJava(generatedFile);
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        AbstractTraceRegion traceRegion = ((ITraceRegionProvider) contents).getTraceRegion();
        this.traceRegionSerializer.writeTraceRegionTo(traceRegion, out);
        byte[] _byteArray = out.toByteArray();
        ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_byteArray);
        this.generateFile(traceFileName, outputConfigName, _byteArrayInputStream);
      }
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
        final InputStream processedContent = this.beforeWrite.beforeWrite(uri, outputCfgName, content);
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
  public URI getBaseDir() {
    return this.baseDir;
  }
  
  public void setBaseDir(final URI baseDir) {
    this.baseDir = baseDir;
  }
  
  @Pure
  public boolean isGenerateTraces() {
    return this.generateTraces;
  }
  
  public void setGenerateTraces(final boolean generateTraces) {
    this.generateTraces = generateTraces;
  }
  
  @Pure
  public IEncodingProvider getEncodingProvider() {
    return this.encodingProvider;
  }
  
  public void setEncodingProvider(final IEncodingProvider encodingProvider) {
    this.encodingProvider = encodingProvider;
  }
  
  @Pure
  public TraceRegionSerializer getTraceRegionSerializer() {
    return this.traceRegionSerializer;
  }
  
  public void setTraceRegionSerializer(final TraceRegionSerializer traceRegionSerializer) {
    this.traceRegionSerializer = traceRegionSerializer;
  }
  
  @Pure
  public TraceFileNameProvider getTraceFileNameProvider() {
    return this.traceFileNameProvider;
  }
  
  public void setTraceFileNameProvider(final TraceFileNameProvider traceFileNameProvider) {
    this.traceFileNameProvider = traceFileNameProvider;
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
