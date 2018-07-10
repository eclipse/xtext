/**
 * Copyright (c) 2012, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.ui.editor;

import com.google.inject.Inject;
import java.util.Arrays;
import java.util.Iterator;
import org.eclipse.core.resources.IFile;
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
      final IJavaElement adapter = it.<IJavaElement>getAdapter(IJavaElement.class);
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
      if ((resource != null)) {
        boolean _isValid = this.fileExtensionProvider.isValid(resource.getFullPath().getFileExtension());
        if (_isValid) {
          final IJavaProject project = JavaCore.create(resource.getProject());
          boolean _exists = project.exists();
          if (_exists) {
            boolean _isPrefixOf = project.getOutputLocation().isPrefixOf(resource.getFullPath());
            if (_isPrefixOf) {
              final IPath relative = resource.getFullPath().removeFirstSegments(project.getOutputLocation().segmentCount());
              final Function1<IPackageFragmentRoot, Boolean> _function = (IPackageFragmentRoot it) -> {
                try {
                  int _kind = it.getKind();
                  return Boolean.valueOf((_kind == IPackageFragmentRoot.K_SOURCE));
                } catch (Throwable _e) {
                  throw Exceptions.sneakyThrow(_e);
                }
              };
              Iterable<IPackageFragmentRoot> _filter = IterableExtensions.<IPackageFragmentRoot>filter(((Iterable<IPackageFragmentRoot>)Conversions.doWrapArray(project.getPackageFragmentRoots())), _function);
              for (final IPackageFragmentRoot source : _filter) {
                {
                  final IPath fullPath = source.getCorrespondingResource().getProjectRelativePath().append(relative);
                  final IFile newFile = resource.getProject().getFile(fullPath);
                  boolean _exists_1 = newFile.exists();
                  if (_exists_1) {
                    return new FileEditorInput(newFile);
                  }
                }
              }
            }
            final Function1<IClasspathEntry, Boolean> _function_1 = (IClasspathEntry it) -> {
              int _entryKind = it.getEntryKind();
              return Boolean.valueOf((_entryKind == IClasspathEntry.CPE_SOURCE));
            };
            Iterable<IClasspathEntry> _filter_1 = IterableExtensions.<IClasspathEntry>filter(((Iterable<IClasspathEntry>)Conversions.doWrapArray(project.getRawClasspath())), _function_1);
            for (final IClasspathEntry sourceFolder : _filter_1) {
              if (((sourceFolder.getOutputLocation() != null) && sourceFolder.getOutputLocation().isPrefixOf(resource.getFullPath()))) {
                final IPath relative_1 = resource.getFullPath().removeFirstSegments(sourceFolder.getOutputLocation().segmentCount());
                final IPackageFragmentRoot source_1 = IterableExtensions.<IPackageFragmentRoot>head(((Iterable<IPackageFragmentRoot>)Conversions.doWrapArray(project.findPackageFragmentRoots(sourceFolder))));
                final IPath fullPath = source_1.getCorrespondingResource().getProjectRelativePath().append(relative_1);
                final IFile newFile = resource.getProject().getFile(fullPath);
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
    if ((resource != null)) {
      final IEditorInput original = this.findOriginalSourceForOuputFolderCopy(input);
      if ((original != input)) {
        return original;
      }
      final IEclipseTrace trace = this.traceInformation.getTraceToSource(resource);
      if ((trace == null)) {
        return input;
      }
      final Iterator<? extends ILocationInEclipseResource> allLocations = trace.getAllAssociatedLocations().iterator();
      ILocationInEclipseResource sourceInformation = null;
      while ((allLocations.hasNext() && (sourceInformation == null))) {
        {
          final ILocationInEclipseResource candidate = allLocations.next();
          boolean _equals = this.languageInfo.equals(candidate.getLanguage());
          if (_equals) {
            sourceInformation = candidate;
          }
        }
      }
      if ((sourceInformation == null)) {
        return input;
      }
      final IStorage originalStorage = sourceInformation.getPlatformResource();
      if ((originalStorage != null)) {
        return EditorUtils.createEditorInput(originalStorage);
      }
    }
    return input;
  }
  
  protected IPackageFragmentRoot _getPackageFragmentRoot(final IJavaElement element) {
    return this.getPackageFragmentRoot(element.getParent());
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
