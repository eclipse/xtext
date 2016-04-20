/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.trace;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.generator.trace.AbsoluteURI;
import org.eclipse.xtext.generator.trace.ILocationInResource;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.generator.trace.internal.AbstractTrace;
import org.eclipse.xtext.idea.build.IdeaOutputConfigurationProvider;
import org.eclipse.xtext.idea.filesystem.IdeaProjectConfig;
import org.eclipse.xtext.idea.filesystem.IdeaProjectConfigProvider;
import org.eclipse.xtext.idea.filesystem.IdeaSourceFolder;
import org.eclipse.xtext.idea.resource.VirtualFileURIUtil;
import org.eclipse.xtext.idea.trace.IIdeaTrace;
import org.eclipse.xtext.idea.trace.ILocationInVirtualFile;
import org.eclipse.xtext.idea.trace.LocationInVirtualFile;
import org.eclipse.xtext.idea.trace.VirtualFileInProject;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class VirtualFileBasedTrace extends AbstractTrace implements IIdeaTrace {
  private VirtualFileInProject localVirtualFile;
  
  private IdeaOutputConfigurationProvider outputConfigurationProvider;
  
  private IdeaProjectConfigProvider projectConfigProvider;
  
  @Accessors({ AccessorType.PROTECTED_SETTER, AccessorType.PUBLIC_GETTER })
  private IdeaProjectConfig localProjectConfig;
  
  @Accessors({ AccessorType.PROTECTED_SETTER, AccessorType.PUBLIC_GETTER })
  private VirtualFile jarRoot;
  
  @Override
  public AbsoluteURI getLocalURI() {
    return this.getURIForVirtualFile(this.localVirtualFile);
  }
  
  public Module getModule() {
    Module _module = null;
    if (this.localProjectConfig!=null) {
      _module=this.localProjectConfig.getModule();
    }
    return _module;
  }
  
  @Override
  public VirtualFileInProject getLocalStorage() {
    return this.localVirtualFile;
  }
  
  protected void setLocalStorage(final VirtualFileInProject localVirtualFile) {
    this.localVirtualFile = localVirtualFile;
  }
  
  protected void setOutputConfigurationProvider(final IdeaOutputConfigurationProvider outputConfigurationProvider) {
    this.outputConfigurationProvider = outputConfigurationProvider;
  }
  
  protected void setProjectConfigProvider(final IdeaProjectConfigProvider projectConfigProvider) {
    this.projectConfigProvider = projectConfigProvider;
  }
  
  protected AbsoluteURI getURIForVirtualFile(final VirtualFile virtualFile) {
    URI _uRI = VirtualFileURIUtil.getURI(virtualFile);
    return new AbsoluteURI(_uRI);
  }
  
  protected AbsoluteURI getURIForVirtualFile(final VirtualFileInProject virtualFile) {
    VirtualFile _file = virtualFile.getFile();
    return this.getURIForVirtualFile(_file);
  }
  
  public VirtualFileInProject findVirtualFileInProject(final SourceRelativeURI srcRelativeLocation) {
    final AbsoluteURI absoluteUri = this.resolvePath(srcRelativeLocation);
    URI _uRI = absoluteUri.getURI();
    final VirtualFile vFile = VirtualFileURIUtil.getVirtualFile(_uRI);
    if ((vFile == null)) {
      return null;
    }
    Project _project = this.localVirtualFile.getProject();
    return new VirtualFileInProject(vFile, _project);
  }
  
  @Override
  public AbsoluteURI resolvePath(final SourceRelativeURI path) {
    if ((this.jarRoot != null)) {
      String _string = path.toString();
      final VirtualFile child = this.jarRoot.findFileByRelativePath(_string);
      final URI uri = VirtualFileURIUtil.getURI(child);
      return new AbsoluteURI(uri);
    } else {
      if ((this.isTraceToTarget() && (this.getModule() != null))) {
        Module _module = this.getModule();
        final Set<OutputConfiguration> outputConfigurations = this.outputConfigurationProvider.getOutputConfigurations(_module);
        final Set<? extends IdeaSourceFolder> sourceFolders = this.localProjectConfig.getSourceFolders();
        for (final IdeaSourceFolder sourceFolder : sourceFolders) {
          {
            VirtualFile _contentRoot = this.localProjectConfig.getContentRoot();
            OutputConfiguration _head = IterableExtensions.<OutputConfiguration>head(outputConfigurations);
            String _name = sourceFolder.getName();
            String _outputDirectory = _head.getOutputDirectory(_name);
            final VirtualFile outputFolder = _contentRoot.findFileByRelativePath(_outputDirectory);
            if ((outputFolder != null)) {
              URI _uRI = path.getURI();
              String _string_1 = _uRI.toString();
              final VirtualFile file = outputFolder.findFileByRelativePath(_string_1);
              if ((file != null)) {
                URI _uRI_1 = VirtualFileURIUtil.getURI(file);
                return new AbsoluteURI(_uRI_1);
              }
            }
          }
        }
      }
    }
    return super.resolvePath(path);
  }
  
  @Override
  public InputStream getContents(final SourceRelativeURI uri) throws IOException {
    final VirtualFileInProject file = this.findVirtualFileInProject(uri);
    VirtualFile _file = file.getFile();
    byte[] _contentsToByteArray = _file.contentsToByteArray();
    return new ByteArrayInputStream(_contentsToByteArray);
  }
  
  @Override
  public Reader getContentsAsText(final SourceRelativeURI uri) throws IOException {
    final Module project = this.getModule();
    VirtualFileInProject fileInProject = this.findVirtualFileInProject(uri);
    if ((fileInProject == null)) {
      String _name = null;
      if (project!=null) {
        _name=project.getName();
      }
      String _plus = ("\'" + _name);
      String _plus_1 = (_plus + "\' (");
      String _moduleFilePath = null;
      if (project!=null) {
        _moduleFilePath=project.getModuleFilePath();
      }
      String _plus_2 = (_plus_1 + _moduleFilePath);
      final String module = (_plus_2 + ")");
      throw new FileNotFoundException(((("File \'" + uri) + "\' not found in module ") + module));
    }
    final VirtualFile file = fileInProject.getFile();
    String _loadText = VfsUtil.loadText(file);
    return new StringReader(_loadText);
  }
  
  @Override
  protected Reader getLocalContentsAsText() throws IOException {
    final VirtualFile file = this.localVirtualFile.getFile();
    String _loadText = VfsUtil.loadText(file);
    return new StringReader(_loadText);
  }
  
  @Override
  public ILocationInVirtualFile getBestAssociatedLocation(final ITextRegion region, final VirtualFileInProject associatedVirtualFile) {
    final AbsoluteURI uri = this.getURIForVirtualFile(associatedVirtualFile);
    return this.getBestAssociatedLocation(region, uri);
  }
  
  @Override
  public Iterable<? extends ILocationInVirtualFile> getAllAssociatedLocations(final ITextRegion localRegion, final VirtualFileInProject associatedVirtualFile) {
    final AbsoluteURI uri = this.getURIForVirtualFile(associatedVirtualFile);
    return this.getAllAssociatedLocations(localRegion, uri);
  }
  
  @Override
  public Iterable<? extends ILocationInVirtualFile> getAllAssociatedLocations(final VirtualFileInProject associatedVirtualFile) {
    final AbsoluteURI uri = this.getURIForVirtualFile(associatedVirtualFile);
    return this.getAllAssociatedLocations(uri);
  }
  
  @Override
  public ILocationInVirtualFile getBestAssociatedLocation(final ITextRegion region) {
    ILocationInResource _bestAssociatedLocation = super.getBestAssociatedLocation(region);
    return ((ILocationInVirtualFile) _bestAssociatedLocation);
  }
  
  @Override
  public ILocationInVirtualFile createLocationInResource(final ITextRegionWithLineInformation region, final SourceRelativeURI srcRelativePath) {
    int _offset = region.getOffset();
    int _length = region.getLength();
    int _lineNumber = region.getLineNumber();
    int _endLineNumber = region.getEndLineNumber();
    return new LocationInVirtualFile(_offset, _length, _lineNumber, _endLineNumber, srcRelativePath, this);
  }
  
  @Override
  public Iterable<? extends ILocationInVirtualFile> getAllAssociatedLocations(final ITextRegion localRegion) {
    Iterable<? extends ILocationInResource> _allAssociatedLocations = super.getAllAssociatedLocations(localRegion);
    return ((Iterable<? extends ILocationInVirtualFile>) _allAssociatedLocations);
  }
  
  @Override
  public ILocationInVirtualFile getBestAssociatedLocation(final ITextRegion localRegion, final AbsoluteURI uri) {
    ILocationInResource _bestAssociatedLocation = super.getBestAssociatedLocation(localRegion, uri);
    return ((ILocationInVirtualFile) _bestAssociatedLocation);
  }
  
  @Override
  public Iterable<? extends ILocationInVirtualFile> getAllAssociatedLocations(final ITextRegion localRegion, final AbsoluteURI uri) {
    Iterable<? extends ILocationInResource> _allAssociatedLocations = super.getAllAssociatedLocations(localRegion, uri);
    return ((Iterable<? extends ILocationInVirtualFile>) _allAssociatedLocations);
  }
  
  @Override
  public Iterable<? extends ILocationInVirtualFile> getAllAssociatedLocations(final AbsoluteURI uri) {
    Iterable<? extends ILocationInResource> _allAssociatedLocations = super.getAllAssociatedLocations(uri);
    return ((Iterable<? extends ILocationInVirtualFile>) _allAssociatedLocations);
  }
  
  @Override
  public Iterable<? extends ILocationInVirtualFile> getAllAssociatedLocations() {
    Iterable<? extends ILocationInResource> _allAssociatedLocations = super.getAllAssociatedLocations();
    return ((Iterable<? extends ILocationInVirtualFile>) _allAssociatedLocations);
  }
  
  @Pure
  public IdeaProjectConfig getLocalProjectConfig() {
    return this.localProjectConfig;
  }
  
  protected void setLocalProjectConfig(final IdeaProjectConfig localProjectConfig) {
    this.localProjectConfig = localProjectConfig;
  }
  
  @Pure
  public VirtualFile getJarRoot() {
    return this.jarRoot;
  }
  
  protected void setJarRoot(final VirtualFile jarRoot) {
    this.jarRoot = jarRoot;
  }
}
