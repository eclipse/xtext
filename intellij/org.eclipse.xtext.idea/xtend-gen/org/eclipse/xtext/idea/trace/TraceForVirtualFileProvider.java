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
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileManager;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.util.indexing.IndexingDataKeys;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.generator.trace.AbsoluteURI;
import org.eclipse.xtext.generator.trace.ITraceURIConverter;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.generator.trace.TraceFileNameProvider;
import org.eclipse.xtext.generator.trace.internal.AbstractTraceForURIProvider;
import org.eclipse.xtext.idea.build.IdeaOutputConfigurationProvider;
import org.eclipse.xtext.idea.build.XtextAutoBuilderComponent;
import org.eclipse.xtext.idea.filesystem.IdeaModuleConfig;
import org.eclipse.xtext.idea.filesystem.IdeaWorkspaceConfig;
import org.eclipse.xtext.idea.resource.VirtualFileURIUtil;
import org.eclipse.xtext.idea.trace.IIdeaTrace;
import org.eclipse.xtext.idea.trace.ILocationInVirtualFile;
import org.eclipse.xtext.idea.trace.ITraceForVirtualFileProvider;
import org.eclipse.xtext.idea.trace.VirtualFileBasedTrace;
import org.eclipse.xtext.idea.trace.VirtualFileInProject;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.ISourceFolder;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
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
      boolean _and = false;
      if (!(this.file != null)) {
        _and = false;
      } else {
        boolean _exists = this.file.exists();
        _and = _exists;
      }
      return _and;
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
  public List<? extends PsiElement> getGeneratedElements(final PsiElement element) {
    final PsiFile containgFile = element.getContainingFile();
    if ((containgFile == null)) {
      return CollectionLiterals.<PsiElement>emptyList();
    }
    PsiFile _containingFile = element.getContainingFile();
    final VirtualFile vFile = this.tryHardToFindVirtualFile(_containingFile);
    if ((vFile == null)) {
      return CollectionLiterals.<PsiElement>emptyList();
    }
    Project _project = element.getProject();
    final VirtualFileInProject fileInProject = new VirtualFileInProject(vFile, _project);
    final IIdeaTrace traceToTarget = this.getTraceToTarget(fileInProject);
    return this.getTracedElements(traceToTarget, element);
  }
  
  private List<PsiElement> getTracedElements(final IIdeaTrace trace, final PsiElement element) {
    if ((trace == null)) {
      return CollectionLiterals.<PsiElement>emptyList();
    }
    final TextRange range = element.getTextRange();
    int _startOffset = range.getStartOffset();
    int _length = range.getLength();
    TextRegion _textRegion = new TextRegion(_startOffset, _length);
    final Iterable<? extends ILocationInVirtualFile> targetLocations = trace.getAllAssociatedLocations(_textRegion);
    final PsiManager mngr = element.getManager();
    final Function1<ILocationInVirtualFile, Boolean> _function = new Function1<ILocationInVirtualFile, Boolean>() {
      @Override
      public Boolean apply(final ILocationInVirtualFile it) {
        ITextRegionWithLineInformation _textRegion = it.getTextRegion();
        int _length = _textRegion.getLength();
        return Boolean.valueOf((_length > 0));
      }
    };
    Iterable<? extends ILocationInVirtualFile> _filter = IterableExtensions.filter(targetLocations, _function);
    final Function1<ILocationInVirtualFile, PsiElement> _function_1 = new Function1<ILocationInVirtualFile, PsiElement>() {
      @Override
      public PsiElement apply(final ILocationInVirtualFile it) {
        PsiElement _xblockexpression = null;
        {
          VirtualFileInProject _platformResource = it.getPlatformResource();
          final VirtualFile targetFile = _platformResource.getFile();
          final ITextRegionWithLineInformation textRegion = it.getTextRegion();
          PsiFile _findFile = mngr.findFile(targetFile);
          int _offset = textRegion.getOffset();
          PsiElement result = _findFile.findElementAt(_offset);
          while ((!result.getTextRange().containsRange(textRegion.getOffset(), (textRegion.getOffset() + textRegion.getLength())))) {
            PsiElement _parent = result.getParent();
            result = _parent;
          }
          int _textLength = result.getTextLength();
          boolean _equals = (_textLength == 0);
          if (_equals) {
            return null;
          }
          _xblockexpression = result;
        }
        return _xblockexpression;
      }
    };
    Iterable<PsiElement> _map = IterableExtensions.map(_filter, _function_1);
    Iterable<PsiElement> _filterNull = IterableExtensions.<PsiElement>filterNull(_map);
    Set<PsiElement> _set = IterableExtensions.<PsiElement>toSet(_filterNull);
    final List<PsiElement> result = IterableExtensions.<PsiElement>toList(_set);
    return result;
  }
  
  private VirtualFile tryHardToFindVirtualFile(final PsiFile psiFile) {
    final PsiFile originalFile = psiFile.getOriginalFile();
    if (((originalFile != psiFile) && (originalFile != null))) {
      return this.tryHardToFindVirtualFile(originalFile);
    }
    final VirtualFile result = psiFile.<VirtualFile>getUserData(IndexingDataKeys.VIRTUAL_FILE);
    if ((result != null)) {
      return result;
    }
    FileViewProvider _viewProvider = psiFile.getViewProvider();
    return _viewProvider.getVirtualFile();
  }
  
  @Override
  public List<? extends PsiElement> getOriginalElements(final PsiElement element) {
    PsiFile _containingFile = element.getContainingFile();
    final VirtualFile vFile = this.tryHardToFindVirtualFile(_containingFile);
    Project _project = element.getProject();
    final VirtualFileInProject fileInProject = new VirtualFileInProject(vFile, _project);
    final VirtualFileBasedTrace traceToSource = this.getTraceToSource(fileInProject);
    return this.getTracedElements(traceToSource, element);
  }
  
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
    final VirtualFileManager mngr = VirtualFileManager.getInstance();
    final Function1<URI, VirtualFile> _function = new Function1<URI, VirtualFile>() {
      @Override
      public VirtualFile apply(final URI it) {
        String _string = it.toString();
        return mngr.findFileByUrl(_string);
      }
    };
    final Iterable<VirtualFile> generatedFiles = IterableExtensions.<URI, VirtualFile>map(generatedSources, _function);
    final Function1<VirtualFile, Boolean> _function_1 = new Function1<VirtualFile, Boolean>() {
      @Override
      public Boolean apply(final VirtualFile it) {
        return Boolean.valueOf(TraceForVirtualFileProvider.this.isTraceFile(it));
      }
    };
    final Iterable<VirtualFile> generatedTraces = IterableExtensions.<VirtualFile>filter(generatedFiles, _function_1);
    final Function1<VirtualFile, AbstractTraceForURIProvider.PersistedTrace> _function_2 = new Function1<VirtualFile, AbstractTraceForURIProvider.PersistedTrace>() {
      @Override
      public AbstractTraceForURIProvider.PersistedTrace apply(final VirtualFile it) {
        TraceForVirtualFileProvider.VirtualFilePersistedTrace _virtualFilePersistedTrace = new TraceForVirtualFileProvider.VirtualFilePersistedTrace(it, TraceForVirtualFileProvider.this);
        return ((AbstractTraceForURIProvider.PersistedTrace) _virtualFilePersistedTrace);
      }
    };
    Iterable<AbstractTraceForURIProvider.PersistedTrace> _map = IterableExtensions.<VirtualFile, AbstractTraceForURIProvider.PersistedTrace>map(generatedTraces, _function_2);
    final List<AbstractTraceForURIProvider.PersistedTrace> result = IterableExtensions.<AbstractTraceForURIProvider.PersistedTrace>toList(_map);
    return result;
  }
  
  @Override
  public SourceRelativeURI getGeneratedUriForTrace(final IProjectConfig projectConfig, final AbsoluteURI absoluteSourceResource, final AbsoluteURI generatedFileURI, final ITraceURIConverter traceURIConverter) {
    final Module module = ((IdeaModuleConfig) projectConfig).getModule();
    IResourceServiceProvider _serviceProvider = this.getServiceProvider(absoluteSourceResource);
    final IdeaOutputConfigurationProvider outputConfigurationProvider = _serviceProvider.<IdeaOutputConfigurationProvider>get(IdeaOutputConfigurationProvider.class);
    final Set<OutputConfiguration> outputConfigurations = outputConfigurationProvider.getOutputConfigurations(module);
    URI _uRI = absoluteSourceResource.getURI();
    final ISourceFolder sourceFolder = projectConfig.findSourceFolderContaining(_uRI);
    OutputConfiguration _head = IterableExtensions.<OutputConfiguration>head(outputConfigurations);
    String _name = sourceFolder.getName();
    final String outputFolder = _head.getOutputDirectory(_name);
    ModuleRootManager _instance = ModuleRootManager.getInstance(module);
    VirtualFile[] _contentRoots = _instance.getContentRoots();
    final VirtualFile contentRoot = IterableExtensions.<VirtualFile>head(((Iterable<VirtualFile>)Conversions.doWrapArray(_contentRoots)));
    final VirtualFile outputSourceFolder = contentRoot.findFileByRelativePath(outputFolder);
    if ((outputSourceFolder == null)) {
      final SourceRelativeURI result = super.getGeneratedUriForTrace(projectConfig, absoluteSourceResource, generatedFileURI, traceURIConverter);
      return result;
    }
    final URI sourceFolderURI = VirtualFileURIUtil.getURI(outputSourceFolder);
    final SourceRelativeURI result_1 = generatedFileURI.deresolve(sourceFolderURI);
    return result_1;
  }
  
  private boolean isTraceFile(final VirtualFile file) {
    TraceFileNameProvider _traceFileNameProvider = this.getTraceFileNameProvider();
    String _name = file.getName();
    return _traceFileNameProvider.isTraceFileName(_name);
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
  public boolean isGenerated(final VirtualFileInProject file) {
    AbstractTraceForURIProvider.PersistedTrace _findPersistedTrace = this.findPersistedTrace(file);
    return _findPersistedTrace.exists();
  }
  
  @Override
  public VirtualFileBasedTrace getTraceToTarget(final VirtualFileInProject sourceFile, final AbsoluteURI absoluteSourceResource, final IProjectConfig projectConfig) {
    final VirtualFileBasedTrace result = super.getTraceToTarget(sourceFile, absoluteSourceResource, projectConfig);
    if ((result != null)) {
      IResourceServiceProvider _serviceProvider = this.getServiceProvider(absoluteSourceResource);
      final IdeaOutputConfigurationProvider outputConfigurationProvider = _serviceProvider.<IdeaOutputConfigurationProvider>get(IdeaOutputConfigurationProvider.class);
      result.setOutputConfigurationProvider(outputConfigurationProvider);
    }
    return result;
  }
  
  @Override
  protected VirtualFileBasedTrace newAbstractTrace(final VirtualFileInProject file) {
    final VirtualFileBasedTrace result = this.traceProvider.get();
    result.setLocalStorage(file);
    IProjectConfig _projectConfig = this.getProjectConfig(file);
    Module _module = ((IdeaModuleConfig) _projectConfig).getModule();
    result.setModule(_module);
    return result;
  }
  
  protected VirtualFile getTraceFile(final VirtualFile generatedFile) {
    final VirtualFile parent = generatedFile.getParent();
    if ((parent == null)) {
      return null;
    }
    TraceFileNameProvider _traceFileNameProvider = this.getTraceFileNameProvider();
    String _name = generatedFile.getName();
    String _traceFromJava = _traceFileNameProvider.getTraceFromJava(_name);
    final VirtualFile result = parent.findChild(_traceFromJava);
    return result;
  }
}
