/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.macro;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.xtend.core.macro.ProcessorInstanceForJvmTypeProvider;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

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
    try {
      final String[] classPathEntries = JavaRuntime.computeDefaultRuntimeClassPath(projectToUse);
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
      List<URL> _map = ListExtensions.<String, URL>map(((List<String>)Conversions.doWrapArray(classPathEntries)), _function);
      final List<URL> urls = IterableExtensions.<URL>toList(_map);
      ClassLoader _parentClassLoader = this.getParentClassLoader();
      return new URLClassLoader(((URL[])Conversions.unwrapArray(urls, URL.class)), _parentClassLoader);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected ClassLoader getParentClassLoader() {
    final ClassLoader bundleClassLoader = TransformationContext.class.getClassLoader();
    return bundleClassLoader;
  }
}
