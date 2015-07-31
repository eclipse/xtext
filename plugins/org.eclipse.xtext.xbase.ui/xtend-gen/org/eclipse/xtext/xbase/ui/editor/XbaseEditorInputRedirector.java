/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.ui.editor;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.Iterator;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.ITypeRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.LanguageInfo;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.ui.generator.trace.IEclipseTrace;
import org.eclipse.xtext.ui.generator.trace.ILocationInEclipseResource;
import org.eclipse.xtext.ui.generator.trace.ITraceForStorageProvider;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class XbaseEditorInputRedirector {
  @Inject
  private ITraceForStorageProvider traceInformation;
  
  @Inject
  private LanguageInfo languageInfo;
  
  @Inject
  private FileExtensionProvider fileExtensionProvider;
  
  public ITypeRoot getTypeRoot(final IEditorInput it) {
    ITypeRoot _xblockexpression = null;
    {
      final Object adapter = it.getAdapter(IJavaElement.class);
      ITypeRoot _xifexpression = null;
      if ((adapter instanceof ITypeRoot)) {
        _xifexpression = ((ITypeRoot)adapter);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  /**
   * @param an input
   * 
   * @return the original source for an editor input that points to an Xtext resource copied to the output folder, the given input otherwise
   */
  public IEditorInput findOriginalSourceForOuputFolderCopy(final IEditorInput input) {
    try {
      final IFile resource = ResourceUtil.getFile(input);
      boolean _notEquals = (!Objects.equal(resource, null));
      if (_notEquals) {
        IPath _fullPath = resource.getFullPath();
        String _fileExtension = _fullPath.getFileExtension();
        boolean _isValid = this.fileExtensionProvider.isValid(_fileExtension);
        if (_isValid) {
          IProject _project = resource.getProject();
          final IJavaProject project = JavaCore.create(_project);
          boolean _exists = project.exists();
          if (_exists) {
            IPath _outputLocation = project.getOutputLocation();
            IPath _fullPath_1 = resource.getFullPath();
            boolean _isPrefixOf = _outputLocation.isPrefixOf(_fullPath_1);
            if (_isPrefixOf) {
              IPath _fullPath_2 = resource.getFullPath();
              IPath _outputLocation_1 = project.getOutputLocation();
              int _segmentCount = _outputLocation_1.segmentCount();
              final IPath relative = _fullPath_2.removeFirstSegments(_segmentCount);
              IPackageFragmentRoot[] _packageFragmentRoots = project.getPackageFragmentRoots();
              final Function1<IPackageFragmentRoot, Boolean> _function = new Function1<IPackageFragmentRoot, Boolean>() {
                @Override
                public Boolean apply(final IPackageFragmentRoot it) {
                  try {
                    int _kind = it.getKind();
                    return Boolean.valueOf((_kind == IPackageFragmentRoot.K_SOURCE));
                  } catch (Throwable _e) {
                    throw Exceptions.sneakyThrow(_e);
                  }
                }
              };
              Iterable<IPackageFragmentRoot> _filter = IterableExtensions.<IPackageFragmentRoot>filter(((Iterable<IPackageFragmentRoot>)Conversions.doWrapArray(_packageFragmentRoots)), _function);
              for (final IPackageFragmentRoot source : _filter) {
                {
                  IResource _correspondingResource = source.getCorrespondingResource();
                  IPath _projectRelativePath = _correspondingResource.getProjectRelativePath();
                  final IPath fullPath = _projectRelativePath.append(relative);
                  IProject _project_1 = resource.getProject();
                  final IFile newFile = _project_1.getFile(fullPath);
                  boolean _exists_1 = newFile.exists();
                  if (_exists_1) {
                    return new FileEditorInput(newFile);
                  }
                }
              }
            }
            IClasspathEntry[] _rawClasspath = project.getRawClasspath();
            final Function1<IClasspathEntry, Boolean> _function_1 = new Function1<IClasspathEntry, Boolean>() {
              @Override
              public Boolean apply(final IClasspathEntry it) {
                int _entryKind = it.getEntryKind();
                return Boolean.valueOf((_entryKind == IClasspathEntry.CPE_SOURCE));
              }
            };
            Iterable<IClasspathEntry> _filter_1 = IterableExtensions.<IClasspathEntry>filter(((Iterable<IClasspathEntry>)Conversions.doWrapArray(_rawClasspath)), _function_1);
            for (final IClasspathEntry sourceFolder : _filter_1) {
              boolean _and = false;
              IPath _outputLocation_2 = sourceFolder.getOutputLocation();
              boolean _notEquals_1 = (!Objects.equal(_outputLocation_2, null));
              if (!_notEquals_1) {
                _and = false;
              } else {
                IPath _outputLocation_3 = sourceFolder.getOutputLocation();
                IPath _fullPath_3 = resource.getFullPath();
                boolean _isPrefixOf_1 = _outputLocation_3.isPrefixOf(_fullPath_3);
                _and = _isPrefixOf_1;
              }
              if (_and) {
                IPath _fullPath_4 = resource.getFullPath();
                IPath _outputLocation_4 = sourceFolder.getOutputLocation();
                int _segmentCount_1 = _outputLocation_4.segmentCount();
                final IPath relative_1 = _fullPath_4.removeFirstSegments(_segmentCount_1);
                IPackageFragmentRoot[] _findPackageFragmentRoots = project.findPackageFragmentRoots(sourceFolder);
                final IPackageFragmentRoot source_1 = IterableExtensions.<IPackageFragmentRoot>head(((Iterable<IPackageFragmentRoot>)Conversions.doWrapArray(_findPackageFragmentRoots)));
                IResource _correspondingResource = source_1.getCorrespondingResource();
                IPath _projectRelativePath = _correspondingResource.getProjectRelativePath();
                final IPath fullPath = _projectRelativePath.append(relative_1);
                IProject _project_1 = resource.getProject();
                final IFile newFile = _project_1.getFile(fullPath);
                boolean _exists_1 = newFile.exists();
                if (_exists_1) {
                  return new FileEditorInput(newFile);
                }
              }
            }
          }
        }
      }
      return input;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public IEditorInput findOriginalSource(final IEditorInput input) {
    final IFile resource = ResourceUtil.getFile(input);
    boolean _notEquals = (!Objects.equal(resource, null));
    if (_notEquals) {
      final IEditorInput original = this.findOriginalSourceForOuputFolderCopy(input);
      if ((original != input)) {
        return original;
      }
      final IEclipseTrace trace = this.traceInformation.getTraceToSource(resource);
      boolean _equals = Objects.equal(trace, null);
      if (_equals) {
        return input;
      }
      Iterable<? extends ILocationInEclipseResource> _allAssociatedLocations = trace.getAllAssociatedLocations();
      final Iterator<? extends ILocationInEclipseResource> allLocations = _allAssociatedLocations.iterator();
      ILocationInEclipseResource sourceInformation = null;
      while ((allLocations.hasNext() && Objects.equal(sourceInformation, null))) {
        {
          final ILocationInEclipseResource candidate = allLocations.next();
          LanguageInfo _language = candidate.getLanguage();
          boolean _equals_1 = this.languageInfo.equals(_language);
          if (_equals_1) {
            sourceInformation = candidate;
          }
        }
      }
      boolean _equals_1 = Objects.equal(sourceInformation, null);
      if (_equals_1) {
        return input;
      }
      final IStorage originalStorage = sourceInformation.getPlatformResource();
      boolean _notEquals_1 = (!Objects.equal(originalStorage, null));
      if (_notEquals_1) {
        return EditorUtils.createEditorInput(originalStorage);
      }
    }
    return input;
  }
  
  protected IPackageFragmentRoot _getPackageFragmentRoot(final IJavaElement element) {
    IJavaElement _parent = element.getParent();
    return this.getPackageFragmentRoot(_parent);
  }
  
  protected IPackageFragmentRoot _getPackageFragmentRoot(final IPackageFragmentRoot element) {
    return element;
  }
  
  protected IPackageFragmentRoot _getPackageFragmentRoot(final Void element) {
    throw new IllegalStateException("couldn\'t find source package fragment root.");
  }
  
  public IPackageFragmentRoot getPackageFragmentRoot(final IJavaElement element) {
    if (element instanceof IPackageFragmentRoot) {
      return _getPackageFragmentRoot((IPackageFragmentRoot)element);
    } else if (element != null) {
      return _getPackageFragmentRoot(element);
    } else if (element == null) {
      return _getPackageFragmentRoot((Void)null);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(element).toString());
    }
  }
}
