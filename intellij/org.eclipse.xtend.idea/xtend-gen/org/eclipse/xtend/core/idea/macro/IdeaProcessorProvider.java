/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.macro;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.roots.OrderEnumerator;
import com.intellij.openapi.roots.OrderRootsEnumerator;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.PathsList;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.core.macro.ProcessorInstanceForJvmTypeProvider;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtext.idea.resource.ModuleProvider;
import org.eclipse.xtext.idea.util.FilteringClassLoader;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class IdeaProcessorProvider extends ProcessorInstanceForJvmTypeProvider {
  private final static Set<String> MACRO_PACKAGE_NAMES = Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet("org.eclipse.xtend.lib.macro", "org.eclipse.xtend2.lib", "org.eclipse.xtext.xbase.lib", "com.google.common"));
  
  @Override
  public ClassLoader getClassLoader(final EObject ctx) {
    URL[] _urls = this.getUrls(ctx);
    FilteringClassLoader _macroClassLoader = this.getMacroClassLoader();
    return new URLClassLoader(_urls, _macroClassLoader);
  }
  
  protected FilteringClassLoader getMacroClassLoader() {
    ClassLoader _classLoader = TransformationContext.class.getClassLoader();
    final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
      @Override
      public Boolean apply(final String name) {
        final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
          @Override
          public Boolean apply(final String packageName) {
            return Boolean.valueOf(name.startsWith(packageName));
          }
        };
        return Boolean.valueOf(IterableExtensions.<String>exists(IdeaProcessorProvider.MACRO_PACKAGE_NAMES, _function));
      }
    };
    return new FilteringClassLoader(_classLoader, _function);
  }
  
  protected URL[] getUrls(final EObject context) {
    Resource _eResource = context.eResource();
    ResourceSet _resourceSet = _eResource.getResourceSet();
    Module _findModule = ModuleProvider.findModule(_resourceSet);
    OrderEnumerator _orderEntries = OrderEnumerator.orderEntries(_findModule);
    OrderEnumerator _recursively = _orderEntries.recursively();
    OrderRootsEnumerator _classes = _recursively.classes();
    PathsList _pathsList = _classes.getPathsList();
    List<VirtualFile> _virtualFiles = _pathsList.getVirtualFiles();
    final Function1<VirtualFile, URL> _function = new Function1<VirtualFile, URL>() {
      @Override
      public URL apply(final VirtualFile it) {
        try {
          String _path = it.getPath();
          File _file = new File(_path);
          URI _uRI = _file.toURI();
          return _uRI.toURL();
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    return ((URL[])Conversions.unwrapArray(ListExtensions.<VirtualFile, URL>map(_virtualFiles, _function), URL.class));
  }
}
