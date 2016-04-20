/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.standalone.incremental;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.Attributes;
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
import org.eclipse.xtext.xbase.lib.MapExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

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
    Iterable<String> _plus = Iterables.<String>concat(fileExtensions, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("java")));
    final Set<String> extensions = IterableExtensions.<String>toSet(_plus);
    PathTraverser _pathTraverser = new PathTraverser();
    final Function1<URI, String> _function = new Function1<URI, String>() {
      @Override
      public String apply(final URI it) {
        return it.toFileString();
      }
    };
    Iterable<String> _map = IterableExtensions.<URI, String>map(roots, _function);
    List<String> _list = IterableExtensions.<String>toList(_map);
    final Predicate<URI> _function_1 = new Predicate<URI>() {
      @Override
      public boolean apply(final URI it) {
        String _fileExtension = it.fileExtension();
        return extensions.contains(_fileExtension);
      }
    };
    final Multimap<String, URI> modelsFound = _pathTraverser.resolvePathes(_list, _function_1);
    Map<String, Collection<URI>> _asMap = modelsFound.asMap();
    final Procedure2<String, Collection<URI>> _function_2 = new Procedure2<String, Collection<URI>>() {
      @Override
      public void apply(final String path, final Collection<URI> resource) {
        final File file = new File(path);
        if ((((!Objects.equal(resource, null)) && (!file.isDirectory())) && file.getName().endsWith(".jar"))) {
          ResourceURICollector.this.registerBundle(file);
        }
      }
    };
    MapExtensions.<String, Collection<URI>>forEach(_asMap, _function_2);
    Collection<URI> _values = modelsFound.values();
    return IterableExtensions.<URI>toSet(_values);
  }
  
  protected void registerBundle(final File file) {
    JarFile jarFile = null;
    try {
      JarFile _jarFile = new JarFile(file);
      jarFile = _jarFile;
      final Manifest manifest = jarFile.getManifest();
      boolean _equals = Objects.equal(manifest, null);
      if (_equals) {
        return;
      }
      Attributes _mainAttributes = manifest.getMainAttributes();
      String name = _mainAttributes.getValue("Bundle-SymbolicName");
      boolean _notEquals = (!Objects.equal(name, null));
      if (_notEquals) {
        final int indexOf = name.indexOf(";");
        if ((indexOf > 0)) {
          String _substring = name.substring(0, indexOf);
          name = _substring;
        }
        Map<String, URI> _platformResourceMap = EcorePlugin.getPlatformResourceMap();
        boolean _containsKey = _platformResourceMap.containsKey(name);
        if (_containsKey) {
          return;
        }
        String _absolutePath = file.getAbsolutePath();
        URI _createFileURI = URI.createFileURI(_absolutePath);
        String _plus = ("archive:" + _createFileURI);
        final String path = (_plus + "!/");
        Map<String, URI> _platformResourceMap_1 = EcorePlugin.getPlatformResourceMap();
        URI _createURI = URI.createURI(path);
        _platformResourceMap_1.put(name, _createURI);
      }
    } catch (final Throwable _t) {
      if (_t instanceof ZipException) {
        final ZipException e = (ZipException)_t;
        String _absolutePath_1 = file.getAbsolutePath();
        String _plus_1 = ("Could not open Jar file " + _absolutePath_1);
        String _plus_2 = (_plus_1 + ".");
        ResourceURICollector.LOG.info(_plus_2);
      } else if (_t instanceof Exception) {
        final Exception e_1 = (Exception)_t;
        String _absolutePath_2 = file.getAbsolutePath();
        ResourceURICollector.LOG.error(_absolutePath_2, e_1);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    } finally {
      try {
        boolean _notEquals_1 = (!Objects.equal(jarFile, null));
        if (_notEquals_1) {
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
  
  private final static Logger LOG = Logger.getLogger(ResourceURICollector.class);
}
