/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.standalone.incremental;

import com.google.inject.Inject;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.generator.trace.TraceFileNameProvider;
import org.eclipse.xtext.util.RuntimeIOException;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * TODO: It'd be nicer to add the event notification to JavaIoFileSystemAccess directly.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class TrackingFileSystemAccess extends JavaIoFileSystemAccess {
  public interface Listener {
    public abstract void fileAdded(final String outputDir, final String fileName);
    
    public abstract void fileDeleted(final String outputDir, final String fileName);
  }
  
  @Inject
  private TraceFileNameProvider traceFileNameProvider;
  
  private final JavaIoFileSystemAccess delegate;
  
  private List<TrackingFileSystemAccess.Listener> listeners = CollectionLiterals.<TrackingFileSystemAccess.Listener>newArrayList();
  
  public TrackingFileSystemAccess(final JavaIoFileSystemAccess delegate) {
    this.delegate = delegate;
    Map<String, OutputConfiguration> _outputConfigurations = delegate.getOutputConfigurations();
    this.setOutputConfigurations(_outputConfigurations);
  }
  
  public void addListener(final TrackingFileSystemAccess.Listener listener) {
    this.listeners.add(listener);
  }
  
  public void removeListener(final TrackingFileSystemAccess.Listener listener) {
    this.listeners.remove(listener);
  }
  
  @Override
  public void generateFile(final String fileName, final String outputConfigName, final CharSequence contents) throws RuntimeIOException {
    this.delegate.generateFile(fileName, outputConfigName, contents);
    this.fireFileAdded(fileName, outputConfigName);
  }
  
  @Override
  public void generateTrace(final String fileName, final String outputConfigName, final CharSequence contents) {
    this.delegate.generateTrace(fileName, outputConfigName, contents);
    String _traceFromJava = this.traceFileNameProvider.getTraceFromJava(fileName);
    this.fireFileAdded(_traceFromJava, outputConfigName);
  }
  
  @Override
  public void generateFile(final String fileName, final CharSequence contents) {
    this.delegate.generateFile(fileName, contents);
    this.fireFileAdded(fileName, IFileSystemAccess.DEFAULT_OUTPUT);
  }
  
  @Override
  public void generateFile(final String fileName, final InputStream content) {
    this.delegate.generateFile(fileName, content);
    this.fireFileAdded(fileName, IFileSystemAccess.DEFAULT_OUTPUT);
  }
  
  @Override
  public void generateFile(final String fileName, final String outputConfigName, final InputStream content) throws RuntimeIOException {
    this.delegate.generateFile(fileName, outputConfigName, content);
    this.fireFileAdded(fileName, outputConfigName);
  }
  
  @Override
  public void deleteFile(final String fileName, final String outputConfiguration) {
    this.delegate.deleteFile(fileName, outputConfiguration);
    this.fireFileDeleted(fileName, outputConfiguration);
  }
  
  @Override
  public void deleteFile(final String fileName) {
    this.delegate.deleteFile(fileName);
    this.fireFileDeleted(fileName, IFileSystemAccess.DEFAULT_OUTPUT);
  }
  
  protected void fireFileAdded(final String fileName, final String outputConfigName) {
    Map<String, OutputConfiguration> _outputConfigurations = this.getOutputConfigurations();
    final OutputConfiguration outputConfig = _outputConfigurations.get(outputConfigName);
    final Procedure1<TrackingFileSystemAccess.Listener> _function = new Procedure1<TrackingFileSystemAccess.Listener>() {
      @Override
      public void apply(final TrackingFileSystemAccess.Listener it) {
        String _outputDirectory = outputConfig.getOutputDirectory();
        it.fileAdded(fileName, _outputDirectory);
      }
    };
    IterableExtensions.<TrackingFileSystemAccess.Listener>forEach(this.listeners, _function);
  }
  
  protected void fireFileDeleted(final String fileName, final String outputConfigName) {
    Map<String, OutputConfiguration> _outputConfigurations = this.getOutputConfigurations();
    final OutputConfiguration outputConfig = _outputConfigurations.get(outputConfigName);
    final Procedure1<TrackingFileSystemAccess.Listener> _function = new Procedure1<TrackingFileSystemAccess.Listener>() {
      @Override
      public void apply(final TrackingFileSystemAccess.Listener it) {
        String _outputDirectory = outputConfig.getOutputDirectory();
        it.fileDeleted(fileName, _outputDirectory);
      }
    };
    IterableExtensions.<TrackingFileSystemAccess.Listener>forEach(this.listeners, _function);
  }
}
