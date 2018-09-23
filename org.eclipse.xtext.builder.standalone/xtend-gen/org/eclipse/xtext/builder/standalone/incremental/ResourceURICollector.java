/**
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.standalone.incremental;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.zip.ZipException;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.xtext.mwe.PathTraverser;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.9
 */
@Log
@SuppressWarnings("all")
public class ResourceURICollector {
  public Set<URI> collectAllResources(final Iterable<URI> roots, final Set<String> fileExtensions) {
    boolean _isInfoEnabled = ResourceURICollector.LOG.isInfoEnabled();
    if (_isInfoEnabled) {
      ResourceURICollector.LOG.info("Collecting source models.");
    }
    final long startedAt = System.currentTimeMillis();
    final Set<URI> result = this.collectResources(roots, fileExtensions);
    boolean _isDebugEnabled = ResourceURICollector.LOG.isDebugEnabled();
    if (_isDebugEnabled) {
      long _currentTimeMillis = System.currentTimeMillis();
      long _minus = (_currentTimeMillis - startedAt);
      String _plus = ("Finished collecting source models. Took: " + Long.valueOf(_minus));
      String _plus_1 = (_plus + " ms.");
      ResourceURICollector.LOG.debug(_plus_1);
    }
    return result;
  }
  
  protected Set<URI> collectResources(final Iterable<URI> roots, final Set<String> fileExtensions) {
    final Set<String> extensions = IterableExtensions.<String>toSet(Iterables.<String>concat(fileExtensions, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("java"))));
    final Function1<URI, String> _function = (URI it) -> {
      return it.toFileString();
    };
    final Predicate<URI> _function_1 = (URI it) -> {
      return extensions.contains(it.fileExtension());
    };
    final Multimap<String, URI> modelsFound = new PathTraverser().resolvePathes(IterableExtensions.<String>toList(IterableExtensions.<URI, String>map(roots, _function)), _function_1);
    final BiConsumer<String, Collection<URI>> _function_2 = (String path, Collection<URI> resource) -> {
      final File file = new File(path);
      if ((((resource != null) && (!file.isDirectory())) && file.getName().endsWith(".jar"))) {
        this.registerBundle(file);
      }
    };
    modelsFound.asMap().forEach(_function_2);
    return IterableExtensions.<URI>toSet(modelsFound.values());
  }
  
  protected void registerBundle(final File file) {
    JarFile jarFile = null;
    try {
      JarFile _jarFile = new JarFile(file);
      jarFile = _jarFile;
      final Manifest manifest = jarFile.getManifest();
      if ((manifest == null)) {
        return;
      }
      String name = manifest.getMainAttributes().getValue("Bundle-SymbolicName");
      if ((name != null)) {
        final int indexOf = name.indexOf(";");
        if ((indexOf > 0)) {
          name = name.substring(0, indexOf);
        }
        boolean _containsKey = EcorePlugin.getPlatformResourceMap().containsKey(name);
        if (_containsKey) {
          return;
        }
        URI _createFileURI = URI.createFileURI(file.getAbsolutePath());
        String _plus = ("archive:" + _createFileURI);
        final String path = (_plus + "!/");
        EcorePlugin.getPlatformResourceMap().put(name, URI.createURI(path));
      }
    } catch (final Throwable _t) {
      if (_t instanceof ZipException) {
        String _absolutePath = file.getAbsolutePath();
        String _plus_1 = ("Could not open Jar file " + _absolutePath);
        String _plus_2 = (_plus_1 + ".");
        ResourceURICollector.LOG.info(_plus_2);
      } else if (_t instanceof Exception) {
        final Exception e_1 = (Exception)_t;
        ResourceURICollector.LOG.error(file.getAbsolutePath(), e_1);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    } finally {
      try {
        if ((jarFile != null)) {
          jarFile.close();
        }
      } catch (final Throwable _t_1) {
        if (_t_1 instanceof IOException) {
          final IOException e_2 = (IOException)_t_1;
          ResourceURICollector.LOG.error(jarFile, e_2);
        } else {
          throw Exceptions.sneakyThrow(_t_1);
        }
      }
    }
  }
  
  private static final Logger LOG = Logger.getLogger(ResourceURICollector.class);
}
