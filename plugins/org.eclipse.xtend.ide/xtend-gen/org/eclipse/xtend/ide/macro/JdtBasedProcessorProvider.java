/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.macro;

import com.google.common.base.Objects;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.xtend.core.macro.ProcessorInstanceForJvmTypeProvider;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class JdtBasedProcessorProvider extends ProcessorInstanceForJvmTypeProvider {
  @Override
  public Object getProcessorInstance(final JvmType type) {
    try {
      Resource _eResource = type.eResource();
      ResourceSet _resourceSet = _eResource.getResourceSet();
      Object _classpathURIContext = ((XtextResourceSet) _resourceSet).getClasspathURIContext();
      final IJavaProject project = ((IJavaProject) _classpathURIContext);
      final URLClassLoader classLoader = this.createClassLoaderForJavaProject(project);
      String _identifier = type.getIdentifier();
      final Class<?> result = classLoader.loadClass(_identifier);
      return result.newInstance();
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        String _identifier_1 = type.getIdentifier();
        String _plus = ("Problem during instantiation of " + _identifier_1);
        String _plus_1 = (_plus + " : ");
        String _message = e.getMessage();
        String _plus_2 = (_plus_1 + _message);
        throw new IllegalStateException(_plus_2, e);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Override
  public ClassLoader getClassLoader(final EObject ctx) {
    Resource _eResource = ctx.eResource();
    ResourceSet _resourceSet = _eResource.getResourceSet();
    Object _classpathURIContext = ((XtextResourceSet) _resourceSet).getClasspathURIContext();
    final IJavaProject project = ((IJavaProject) _classpathURIContext);
    return this.createClassLoaderForJavaProject(project);
  }
  
  protected URLClassLoader createClassLoaderForJavaProject(final IJavaProject projectToUse) {
    final LinkedHashSet<String> classPathEntries = CollectionLiterals.<String>newLinkedHashSet();
    HashSet<IJavaProject> _newHashSet = CollectionLiterals.<IJavaProject>newHashSet();
    this.deepCollectRuntimeClassPath(projectToUse, _newHashSet, classPathEntries);
    this.removeLocalOutputFolders(projectToUse, classPathEntries);
    final Function1<String, URL> _function = new Function1<String, URL>() {
      @Override
      public URL apply(final String it) {
        try {
          File _file = new File(it);
          URI _uRI = _file.toURI();
          return _uRI.toURL();
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    Iterable<URL> _map = IterableExtensions.<String, URL>map(classPathEntries, _function);
    final List<URL> urls = IterableExtensions.<URL>toList(_map);
    ClassLoader _parentClassLoader = this.getParentClassLoader();
    return new URLClassLoader(((URL[])Conversions.unwrapArray(urls, URL.class)), _parentClassLoader);
  }
  
  protected boolean removeLocalOutputFolders(final IJavaProject project, final LinkedHashSet<String> classPathEntries) {
    try {
      boolean _xblockexpression = false;
      {
        IClasspathEntry[] _rawClasspath = project.getRawClasspath();
        for (final IClasspathEntry classpathEntry : _rawClasspath) {
          int _entryKind = classpathEntry.getEntryKind();
          boolean _equals = (_entryKind == IClasspathEntry.CPE_SOURCE);
          if (_equals) {
            IPath path = classpathEntry.getOutputLocation();
            boolean _notEquals = (!Objects.equal(path, null));
            if (_notEquals) {
              IProject _project = project.getProject();
              IWorkspace _workspace = _project.getWorkspace();
              IWorkspaceRoot _root = _workspace.getRoot();
              final IFolder outputfolder = _root.getFolder(path);
              IPath _location = outputfolder.getLocation();
              String _string = _location.toString();
              classPathEntries.remove(_string);
            }
          }
        }
        IProject _project_1 = project.getProject();
        IWorkspace _workspace_1 = _project_1.getWorkspace();
        IWorkspaceRoot _root_1 = _workspace_1.getRoot();
        IPath _outputLocation = project.getOutputLocation();
        final IFolder outputfolder_1 = _root_1.getFolder(_outputLocation);
        IPath _location_1 = outputfolder_1.getLocation();
        String _string_1 = _location_1.toString();
        _xblockexpression = classPathEntries.remove(_string_1);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void deepCollectRuntimeClassPath(final IJavaProject project, final Set<IJavaProject> visitedProjects, final LinkedHashSet<String> allEntries) {
    try {
      visitedProjects.add(project);
      final String[] entries = JavaRuntime.computeDefaultRuntimeClassPath(project);
      CollectionExtensions.<String>addAll(allEntries, entries);
      String[] _requiredProjectNames = project.getRequiredProjectNames();
      for (final String requiredProjectName : _requiredProjectNames) {
        {
          IProject _project = project.getProject();
          IWorkspace _workspace = _project.getWorkspace();
          IWorkspaceRoot _root = _workspace.getRoot();
          final IProject reqProject = _root.getProject(requiredProjectName);
          final IJavaProject javaReqProject = JavaCore.create(reqProject);
          boolean _isOpen = javaReqProject.isOpen();
          if (_isOpen) {
            this.deepCollectRuntimeClassPath(javaReqProject, visitedProjects, allEntries);
          }
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected ClassLoader getParentClassLoader() {
    final ClassLoader bundleClassLoader = TransformationContext.class.getClassLoader();
    return bundleClassLoader;
  }
}
