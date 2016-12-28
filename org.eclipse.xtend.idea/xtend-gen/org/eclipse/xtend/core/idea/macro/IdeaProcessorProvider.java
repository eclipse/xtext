/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.macro;

import com.intellij.openapi.roots.OrderEnumerator;
import com.intellij.openapi.vfs.VirtualFile;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collections;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
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
    final Function1<String, Boolean> _function = (String name) -> {
      final Function1<String, Boolean> _function_1 = (String packageName) -> {
        return Boolean.valueOf(name.startsWith(packageName));
      };
      return Boolean.valueOf(IterableExtensions.<String>exists(IdeaProcessorProvider.MACRO_PACKAGE_NAMES, _function_1));
    };
    return new FilteringClassLoader(_classLoader, _function);
  }
  
  protected URL[] getUrls(final EObject context) {
    final Function1<VirtualFile, URL> _function = (VirtualFile it) -> {
      try {
        String _path = it.getPath();
        return new File(_path).toURI().toURL();
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    return ((URL[])Conversions.unwrapArray(ListExtensions.<VirtualFile, URL>map(OrderEnumerator.orderEntries(ModuleProvider.findModule(context.eResource().getResourceSet())).recursively().classes().getPathsList().getVirtualFiles(), _function), URL.class));
  }
}
