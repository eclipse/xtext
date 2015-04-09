/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.standalone.incremental;

import com.google.inject.Inject;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess;
import org.eclipse.xtext.common.types.access.impl.TypeResourceServices;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.9
 */
@SuppressWarnings("all")
public class JavaSupport {
  @Inject
  private TypeResourceServices typeResourceServices;
  
  @Inject
  private IndexedJvmTypeAccess typeAccess;
  
  public void installLocalOnlyTypeProvider(final Iterable<File> classPathRoots, final XtextResourceSet resSet) {
    final URLClassLoader classLoader = this.createURLClassLoader(classPathRoots);
    new ClasspathTypeProvider(classLoader, resSet, null, this.typeResourceServices);
    resSet.setClasspathURIContext(classLoader);
  }
  
  public void installTypeProvider(final Iterable<File> classPathRoots, final XtextResourceSet resSet) {
    final URLClassLoader classLoader = this.createURLClassLoader(classPathRoots);
    new ClasspathTypeProvider(classLoader, resSet, this.typeAccess, this.typeResourceServices);
    resSet.setClasspathURIContext(classLoader);
  }
  
  protected URLClassLoader createURLClassLoader(final Iterable<File> classPathEntries) {
    final Function1<File, URL> _function = new Function1<File, URL>() {
      @Override
      public URL apply(final File it) {
        try {
          URI _uRI = it.toURI();
          return _uRI.toURL();
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    final Iterable<URL> classPathUrls = IterableExtensions.<File, URL>map(classPathEntries, _function);
    return new URLClassLoader(((URL[])Conversions.unwrapArray(classPathUrls, URL.class)));
  }
}
