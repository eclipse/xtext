package org.eclipse.xtend.ide.macro.fsaccess;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.fsaccess.AbstractFileSystemAccessImpl;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.ide.macro.fsaccess.EclipseFolderHandle;
import org.eclipse.xtend.lib.macro.services.FolderHandle;
import org.eclipse.xtext.builder.EclipseOutputConfigurationProvider;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class EclipseFileSystemAccessImpl extends AbstractFileSystemAccessImpl {
  @Inject
  private IStorage2UriMapper mapper;
  
  @Inject
  private IEncodingProvider encodingProvider;
  
  @Inject
  private IJavaProjectProvider javaProjectProvider;
  
  @Inject
  private EclipseOutputConfigurationProvider outputConfigurationProvider;
  
  public FolderHandle doGetSourceFolder(final CompilationUnitImpl it) {
    EclipseFolderHandle _xblockexpression = null;
    {
      final IFile file = this.getFile(it);
      boolean _equals = Objects.equal(file, null);
      if (_equals) {
        return null;
      }
      final IPath sourcePath = this.getSourcePath(it);
      boolean _equals_1 = Objects.equal(sourcePath, null);
      if (_equals_1) {
        return null;
      }
      IProject _project = file.getProject();
      EclipseFolderHandle _eclipseFolderHandle = new EclipseFolderHandle(_project, sourcePath, this.encodingProvider);
      _xblockexpression = (_eclipseFolderHandle);
    }
    return _xblockexpression;
  }
  
  public FolderHandle doGetRootFolder(final CompilationUnitImpl it) {
    EclipseFolderHandle _xblockexpression = null;
    {
      final IFile file = this.getFile(it);
      boolean _equals = Objects.equal(file, null);
      if (_equals) {
        return null;
      }
      IProject _project = file.getProject();
      IProject _project_1 = file.getProject();
      IPath _projectRelativePath = _project_1.getProjectRelativePath();
      EclipseFolderHandle _eclipseFolderHandle = new EclipseFolderHandle(_project, _projectRelativePath, this.encodingProvider);
      _xblockexpression = (_eclipseFolderHandle);
    }
    return _xblockexpression;
  }
  
  public FolderHandle doGetTargetFolder(final CompilationUnitImpl it) {
    EclipseFolderHandle _xblockexpression = null;
    {
      final IFile file = this.getFile(it);
      boolean _equals = Objects.equal(file, null);
      if (_equals) {
        return null;
      }
      OutputConfiguration _outputConfig = this.getOutputConfig(file);
      final String directory = _outputConfig.getOutputDirectory();
      IPath _sourcePath = this.getSourcePath(it);
      String _plus = ("../" + directory);
      final IPath path = _sourcePath.append(_plus);
      IProject _project = file.getProject();
      EclipseFolderHandle _eclipseFolderHandle = new EclipseFolderHandle(_project, path, this.encodingProvider);
      _xblockexpression = (_eclipseFolderHandle);
    }
    return _xblockexpression;
  }
  
  public IPath getSourcePath(final CompilationUnitImpl it) {
    try {
      IPath _xblockexpression = null;
      {
        IFile _file = this.getFile(it);
        IPath _fullPath = null;
        if (_file!=null) {
          _fullPath=_file.getFullPath();
        }
        final IPath filePath = _fullPath;
        boolean _equals = Objects.equal(filePath, null);
        if (_equals) {
          return null;
        }
        IJavaProject _javaProject = this.getJavaProject(it);
        IClasspathEntry[] _resolvedClasspath = _javaProject.getResolvedClasspath(true);
        final Function1<IClasspathEntry,Boolean> _function = new Function1<IClasspathEntry,Boolean>() {
            public Boolean apply(final IClasspathEntry it) {
              boolean _and = false;
              int _entryKind = it.getEntryKind();
              boolean _equals = (_entryKind == IClasspathEntry.CPE_SOURCE);
              if (!_equals) {
                _and = false;
              } else {
                IPath _path = it.getPath();
                boolean _isPrefixOf = _path.isPrefixOf(filePath);
                _and = (_equals && _isPrefixOf);
              }
              return Boolean.valueOf(_and);
            }
          };
        Iterable<IClasspathEntry> _filter = IterableExtensions.<IClasspathEntry>filter(((Iterable<IClasspathEntry>)Conversions.doWrapArray(_resolvedClasspath)), _function);
        IClasspathEntry _head = IterableExtensions.<IClasspathEntry>head(_filter);
        IPath _path = null;
        if (_head!=null) {
          _path=_head.getPath();
        }
        IPath _removeFirstSegments = _path.removeFirstSegments(1);
        _xblockexpression = (_removeFirstSegments);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public OutputConfiguration getOutputConfig(final IFile it) {
    IProject _project = it.getProject();
    Set<OutputConfiguration> _outputConfigurations = this.outputConfigurationProvider.getOutputConfigurations(_project);
    OutputConfiguration _head = IterableExtensions.<OutputConfiguration>head(_outputConfigurations);
    return _head;
  }
  
  public IFile getFile(final CompilationUnitImpl it) {
    Iterable<Pair<IStorage,IProject>> _storages = this.getStorages(it);
    final Function1<Pair<IStorage,IProject>,IStorage> _function = new Function1<Pair<IStorage,IProject>,IStorage>() {
        public IStorage apply(final Pair<IStorage,IProject> it) {
          IStorage _first = it.getFirst();
          return _first;
        }
      };
    Iterable<IStorage> _map = IterableExtensions.<Pair<IStorage,IProject>, IStorage>map(_storages, _function);
    Iterable<IFile> _filter = Iterables.<IFile>filter(_map, IFile.class);
    IFile _head = IterableExtensions.<IFile>head(_filter);
    return _head;
  }
  
  public Iterable<Pair<IStorage,IProject>> getStorages(final CompilationUnitImpl it) {
    XtendFile _xtendFile = it.getXtendFile();
    Resource _eResource = _xtendFile.eResource();
    URI _uRI = _eResource.getURI();
    Iterable<Pair<IStorage,IProject>> _storages = this.mapper.getStorages(_uRI);
    return _storages;
  }
  
  public IJavaProject getJavaProject(final CompilationUnitImpl it) {
    XtendFile _xtendFile = it.getXtendFile();
    Resource _eResource = _xtendFile.eResource();
    ResourceSet _resourceSet = _eResource.getResourceSet();
    IJavaProject _javaProject = this.javaProjectProvider.getJavaProject(_resourceSet);
    return _javaProject;
  }
}
