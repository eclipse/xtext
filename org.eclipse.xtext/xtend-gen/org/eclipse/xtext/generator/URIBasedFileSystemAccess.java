/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator;

import com.google.common.io.ByteStreams;
import com.google.common.io.CharStreams;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.generator.AbstractFileSystemAccess2;
import org.eclipse.xtext.generator.IFilePostProcessor;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ITraceRegionProvider;
import org.eclipse.xtext.generator.trace.TraceFileNameProvider;
import org.eclipse.xtext.generator.trace.TraceNotFoundException;
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
  private URIBasedFileSystemAccess.BeforeDelete beforeDelete = ((URIBasedFileSystemAccess.BeforeDelete) (URI it) -> {
    return true;
  });
  
  @Accessors
  private URIBasedFileSystemAccess.BeforeWrite beforeWrite = ((URIBasedFileSystemAccess.BeforeWrite) (URI $0, String $1, InputStream $2) -> {
    return $2;
  });
  
  @Accessors
  private URIBasedFileSystemAccess.BeforeRead beforeRead = ((URIBasedFileSystemAccess.BeforeRead) (URI $0, InputStream $1) -> {
    return $1;
  });
  
  @Override
  public void setPostProcessor(final IFilePostProcessor filePostProcessor) {
    super.setPostProcessor(filePostProcessor);
  }
  
  @Override
  public URI getURI(final String path, final String outputConfiguration) {
    final String outlet = this.getPathes().get(outputConfiguration);
    if ((outlet == null)) {
      throw new IllegalArgumentException((("A slot with name \'" + outputConfiguration) + "\' has not been configured."));
    }
    final URI uri = URI.createFileURI(((outlet + File.separator) + path));
    if ((this.baseDir != null)) {
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
      if (((!this.getOutputConfig(outputCfgName).isOverrideExistingResources()) && this.converter.exists(uri, CollectionLiterals.<Object, Object>emptyMap()))) {
        return;
      }
      final String encoding = this.getEncoding(uri);
      final CharSequence postProcessed = this.postProcess(fileName, outputCfgName, contents, encoding);
      this.generateTrace(fileName, outputCfgName, postProcessed);
      byte[] _bytes = postProcessed.toString().getBytes(encoding);
      final ByteArrayInputStream inStream = new ByteArrayInputStream(_bytes);
      this.generateFile(fileName, outputCfgName, inStream);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void generateTrace(final String generatedFile, final String outputConfigName, final CharSequence contents) {
    try {
      if ((this.isGenerateTraces() && (contents instanceof ITraceRegionProvider))) {
        try {
          AbstractTraceRegion traceRegion = ((ITraceRegionProvider) contents).getTraceRegion();
          String traceFileName = this.traceFileNameProvider.getTraceFromJava(generatedFile);
          final ByteArrayOutputStream out = new ByteArrayOutputStream();
          this.traceRegionSerializer.writeTraceRegionTo(traceRegion, out);
          byte[] _byteArray = out.toByteArray();
          ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_byteArray);
          this.generateFile(traceFileName, outputConfigName, _byteArrayInputStream);
        } catch (final Throwable _t) {
          if (_t instanceof TraceNotFoundException) {
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
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
      try {
        final URI uri = this.getURI(fileName, outputCfgName);
        final InputStream input = this.converter.createInputStream(uri);
        return this.beforeRead.beforeRead(uri, input);
      } catch (final Throwable _t) {
        if (_t instanceof FileNotFoundException) {
          final FileNotFoundException e = (FileNotFoundException)_t;
          throw new RuntimeIOException(e);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
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
