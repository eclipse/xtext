/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.trace;

import com.google.common.base.Objects;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.vfs.VirtualFile;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.generator.trace.AbsoluteURI;
import org.eclipse.xtext.generator.trace.ILocationInResource;
import org.eclipse.xtext.generator.trace.ITrace;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.generator.trace.internal.AbstractTrace;
import org.eclipse.xtext.idea.filesystem.IdeaModuleConfig;
import org.eclipse.xtext.idea.resource.VirtualFileURIUtil;
import org.eclipse.xtext.idea.trace.IIdeaTrace;
import org.eclipse.xtext.idea.trace.ILocationInVirtualFile;
import org.eclipse.xtext.idea.trace.LocationInVirtualFile;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.workspace.IProjectConfig;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class VirtualFileBasedTrace extends AbstractTrace implements IIdeaTrace {
  private VirtualFile localVirtualFile;
  
  private Module module;
  
  @Override
  public AbsoluteURI getLocalURI() {
    return this.getURIForVirtualFile(this.localVirtualFile);
  }
  
  @Override
  public Module getLocalProject() {
    return this.module;
  }
  
  @Override
  public VirtualFile getLocalStorage() {
    return this.localVirtualFile;
  }
  
  protected AbsoluteURI getURIForVirtualFile(final VirtualFile virtualFile) {
    URI _uRI = VirtualFileURIUtil.getURI(virtualFile);
    return new AbsoluteURI(_uRI);
  }
  
  public VirtualFile findVirtualFile(final SourceRelativeURI srcRelativeLocation, final Module module) {
    final ModuleRootManager mngr = ModuleRootManager.getInstance(module);
    final VirtualFile[] sourceRoots = mngr.getSourceRoots(true);
    URI _uRI = srcRelativeLocation.getURI();
    final String path = _uRI.path();
    for (final VirtualFile sourceRoot : sourceRoots) {
      {
        final VirtualFile result = sourceRoot.findFileByRelativePath(path);
        boolean _notEquals = (!Objects.equal(result, null));
        if (_notEquals) {
          return result;
        }
      }
    }
    return null;
  }
  
  @Override
  public InputStream getContents(final SourceRelativeURI uri, final IProjectConfig projectConfig) throws IOException {
    Module _module = ((IdeaModuleConfig) projectConfig).getModule();
    return this.getContents(uri, _module);
  }
  
  public InputStream getContents(final SourceRelativeURI uri, final Module project) throws IOException {
    final VirtualFile file = this.findVirtualFile(uri, project);
    byte[] _contentsToByteArray = file.contentsToByteArray();
    return new ByteArrayInputStream(_contentsToByteArray);
  }
  
  @Override
  public ILocationInVirtualFile getBestAssociatedLocation(final ITextRegion region, final VirtualFile associatedVirtualFile) {
    final AbsoluteURI uri = this.getURIForVirtualFile(associatedVirtualFile);
    return this.getBestAssociatedLocation(region, uri);
  }
  
  @Override
  public Iterable<? extends ILocationInVirtualFile> getAllAssociatedLocations(final ITextRegion localRegion, final VirtualFile associatedVirtualFile) {
    final AbsoluteURI uri = this.getURIForVirtualFile(associatedVirtualFile);
    return this.getAllAssociatedLocations(localRegion, uri);
  }
  
  @Override
  public Iterable<? extends ILocationInVirtualFile> getAllAssociatedLocations(final VirtualFile associatedVirtualFile) {
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
  public IdeaModuleConfig getLocalProjectConfig() {
    Module _localProject = this.getLocalProject();
    return new IdeaModuleConfig(_localProject);
  }
  
  @Override
  public Iterable<? extends ILocationInVirtualFile> getAllAssociatedLocations() {
    Iterable<? extends ILocationInResource> _allAssociatedLocations = super.getAllAssociatedLocations();
    return ((Iterable<? extends ILocationInVirtualFile>) _allAssociatedLocations);
  }
  
  @Override
  public Iterable<? extends IIdeaTrace> getAllInverseTraces() {
    Iterable<? extends ITrace> _allInverseTraces = super.getAllInverseTraces();
    return ((Iterable<? extends IIdeaTrace>) _allInverseTraces);
  }
  
  @Override
  public IIdeaTrace getInverseTrace(final AbsoluteURI uri) {
    ITrace _inverseTrace = super.getInverseTrace(uri);
    return ((IIdeaTrace) _inverseTrace);
  }
}
