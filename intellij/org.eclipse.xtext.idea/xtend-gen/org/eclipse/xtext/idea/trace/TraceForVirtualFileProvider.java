/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.trace;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileManager;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.generator.trace.AbsoluteURI;
import org.eclipse.xtext.generator.trace.TraceFileNameProvider;
import org.eclipse.xtext.generator.trace.internal.AbstractTraceForURIProvider;
import org.eclipse.xtext.idea.build.XtextAutoBuilderComponent;
import org.eclipse.xtext.idea.filesystem.IdeaModuleConfig;
import org.eclipse.xtext.idea.filesystem.IdeaWorkspaceConfig;
import org.eclipse.xtext.idea.resource.VirtualFileURIUtil;
import org.eclipse.xtext.idea.trace.IIdeaTrace;
import org.eclipse.xtext.idea.trace.ITraceForVirtualFileProvider;
import org.eclipse.xtext.idea.trace.VirtualFileBasedTrace;
import org.eclipse.xtext.idea.trace.VirtualFileInProject;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class TraceForVirtualFileProvider extends AbstractTraceForURIProvider<VirtualFileInProject, VirtualFileBasedTrace> implements ITraceForVirtualFileProvider {
  @FinalFieldsConstructor
  protected static class VirtualFilePersistedTrace implements AbstractTraceForURIProvider.PersistedTrace {
    private final VirtualFile file;
    
    private final TraceForVirtualFileProvider traceProvider;
    
    @Override
    public AbsoluteURI getPath() {
      return this.traceProvider.getAbsoluteLocation(this.file);
    }
    
    @Override
    public long getTimestamp() {
      return this.file.getModificationStamp();
    }
    
    @Override
    public InputStream openStream() throws IOException {
      byte[] _contentsToByteArray = this.file.contentsToByteArray();
      return new ByteArrayInputStream(_contentsToByteArray);
    }
    
    @Override
    public boolean exists() {
      return this.file.exists();
    }
    
    public VirtualFilePersistedTrace(final VirtualFile file, final TraceForVirtualFileProvider traceProvider) {
      super();
      this.file = file;
      this.traceProvider = traceProvider;
    }
  }
  
  @Inject
  private Provider<VirtualFileBasedTrace> traceProvider;
  
  @Override
  protected VirtualFileInProject asFile(final AbsoluteURI absoluteURI, final IProjectConfig project) {
    VirtualFileManager _instance = VirtualFileManager.getInstance();
    URI _uRI = absoluteURI.getURI();
    String _string = _uRI.toString();
    final VirtualFile file = _instance.findFileByUrl(_string);
    final Module module = ((IdeaModuleConfig) project).getModule();
    final Project ideaProject = module.getProject();
    return new VirtualFileInProject(file, ideaProject);
  }
  
  @Override
  protected List<AbstractTraceForURIProvider.PersistedTrace> findInverseTraceFiles(final VirtualFileInProject sourceFile) {
    final Project ideaProject = sourceFile.getProject();
    final XtextAutoBuilderComponent builder = ideaProject.<XtextAutoBuilderComponent>getComponent(XtextAutoBuilderComponent.class);
    VirtualFile _file = sourceFile.getFile();
    URI _uRI = VirtualFileURIUtil.getURI(_file);
    final Iterable<URI> generatedSources = builder.getGeneratedSources(_uRI);
    final Function1<URI, AbstractTraceForURIProvider.PersistedTrace> _function = new Function1<URI, AbstractTraceForURIProvider.PersistedTrace>() {
      @Override
      public AbstractTraceForURIProvider.PersistedTrace apply(final URI it) {
        VirtualFileManager _instance = VirtualFileManager.getInstance();
        String _string = it.toString();
        final VirtualFile file = _instance.findFileByUrl(_string);
        VirtualFileInProject _virtualFileInProject = new VirtualFileInProject(file, ideaProject);
        return TraceForVirtualFileProvider.this.findPersistedTrace(_virtualFileInProject);
      }
    };
    Iterable<AbstractTraceForURIProvider.PersistedTrace> _map = IterableExtensions.<URI, AbstractTraceForURIProvider.PersistedTrace>map(generatedSources, _function);
    return IterableExtensions.<AbstractTraceForURIProvider.PersistedTrace>toList(_map);
  }
  
  @Override
  public IIdeaTrace getTraceToTarget(final VirtualFileInProject sourceResource) {
    AbsoluteURI _absoluteLocation = this.getAbsoluteLocation(sourceResource);
    IProjectConfig _projectConfig = this.getProjectConfig(sourceResource);
    return this.getTraceToTarget(sourceResource, _absoluteLocation, _projectConfig);
  }
  
  @Override
  protected AbstractTraceForURIProvider.PersistedTrace findPersistedTrace(final VirtualFileInProject generatedFile) {
    final VirtualFile virtualFile = generatedFile.getFile();
    VirtualFile _traceFile = this.getTraceFile(virtualFile);
    return new TraceForVirtualFileProvider.VirtualFilePersistedTrace(_traceFile, this);
  }
  
  @Override
  protected AbsoluteURI getAbsoluteLocation(final VirtualFileInProject file) {
    VirtualFile _file = file.getFile();
    return this.getAbsoluteLocation(_file);
  }
  
  protected AbsoluteURI getAbsoluteLocation(final VirtualFile file) {
    URI _uRI = VirtualFileURIUtil.getURI(file);
    return new AbsoluteURI(_uRI);
  }
  
  @Override
  protected IProjectConfig getProjectConfig(final VirtualFileInProject sourceFile) {
    Project _project = sourceFile.getProject();
    IdeaWorkspaceConfig _ideaWorkspaceConfig = new IdeaWorkspaceConfig(_project);
    VirtualFile _file = sourceFile.getFile();
    URI _uRI = VirtualFileURIUtil.getURI(_file);
    return _ideaWorkspaceConfig.findProjectContaining(_uRI);
  }
  
  @Override
  protected VirtualFileBasedTrace newAbstractTrace(final VirtualFileInProject file) {
    final VirtualFileBasedTrace result = this.traceProvider.get();
    result.setLocalStorage(file);
    return result;
  }
  
  protected VirtualFile getTraceFile(final VirtualFile generatedFile) {
    VirtualFile _parent = generatedFile.getParent();
    TraceFileNameProvider _traceFileNameProvider = this.getTraceFileNameProvider();
    String _name = generatedFile.getName();
    String _traceFromJava = _traceFileNameProvider.getTraceFromJava(_name);
    final VirtualFile result = _parent.findChild(_traceFromJava);
    return result;
  }
}
