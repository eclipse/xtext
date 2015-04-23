/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.build.daemon;

import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.builder.standalone.incremental.FilesAndURIs;
import org.eclipse.xtext.idea.build.net.ObjectChannel;
import org.eclipse.xtext.idea.build.net.Protocol;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtextBuildResultCollector {
  @Accessors(AccessorType.PUBLIC_GETTER)
  private Protocol.BuildResultMessage buildResult = new Protocol.BuildResultMessage();
  
  @Accessors
  private ObjectChannel output;
  
  private URI currentSourceURI;
  
  public URI setCurrentResource(final Resource resource) {
    URI _uRI = resource.getURI();
    return this.currentSourceURI = _uRI;
  }
  
  public void addIssue(final Protocol.BuildIssueMessage issue) {
    this.output.writeObject(issue);
  }
  
  public boolean addChangedFile(final String path) {
    List<Protocol.GeneratedFile> _generatedFiles = this.buildResult.getGeneratedFiles();
    Protocol.GeneratedFile _generatedFile = new Protocol.GeneratedFile();
    final Procedure1<Protocol.GeneratedFile> _function = new Procedure1<Protocol.GeneratedFile>() {
      @Override
      public void apply(final Protocol.GeneratedFile it) {
        List<String> _sourceFiles = it.getSourceFiles();
        String _string = XtextBuildResultCollector.this.currentSourceURI.toString();
        _sourceFiles.add(_string);
        URI _asFileURI = FilesAndURIs.asFileURI(path);
        String _string_1 = _asFileURI.toString();
        it.setFile(_string_1);
      }
    };
    Protocol.GeneratedFile _doubleArrow = ObjectExtensions.<Protocol.GeneratedFile>operator_doubleArrow(_generatedFile, _function);
    return _generatedFiles.add(_doubleArrow);
  }
  
  public boolean addOutputDir(final String outputDir) {
    boolean _xifexpression = false;
    List<String> _outputDirs = this.buildResult.getOutputDirs();
    boolean _contains = _outputDirs.contains(outputDir);
    boolean _not = (!_contains);
    if (_not) {
      List<String> _outputDirs_1 = this.buildResult.getOutputDirs();
      _xifexpression = _outputDirs_1.add(outputDir);
    }
    return _xifexpression;
  }
  
  public boolean addDeletedFile(final String path) {
    List<String> _deletedFiles = this.buildResult.getDeletedFiles();
    return _deletedFiles.add(path);
  }
  
  @Pure
  public Protocol.BuildResultMessage getBuildResult() {
    return this.buildResult;
  }
  
  @Pure
  public ObjectChannel getOutput() {
    return this.output;
  }
  
  public void setOutput(final ObjectChannel output) {
    this.output = output;
  }
}
