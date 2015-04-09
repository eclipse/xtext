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
import com.google.common.collect.Multimap;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
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
import org.eclipse.xtext.builder.standalone.LanguageAccess;
import org.eclipse.xtext.builder.standalone.incremental.BuildContext;
import org.eclipse.xtext.mwe.NameBasedFilter;
import org.eclipse.xtext.mwe.PathTraverser;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.MapExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.9
 */
@SuppressWarnings("all")
public class ResourceURICollector {
  private final static Logger LOG = Logger.getLogger(ResourceURICollector.class);
  
  protected List<URI> collectResources(final List<File> roots, final BuildContext context) {
    Map<String, LanguageAccess> _languages = context.getLanguages();
    Set<String> _keySet = _languages.keySet();
    final String extensions = IterableExtensions.join(_keySet, "|");
    final NameBasedFilter nameBasedFilter = new NameBasedFilter();
    nameBasedFilter.setRegularExpression(((".*\\.(?:(" + extensions) + "))$"));
    final List<URI> resources = CollectionLiterals.<URI>newArrayList();
    PathTraverser _pathTraverser = new PathTraverser();
    final Function1<File, String> _function = new Function1<File, String>() {
      @Override
      public String apply(final File it) {
        return it.getAbsolutePath();
      }
    };
    List<String> _map = ListExtensions.<File, String>map(roots, _function);
    List<String> _list = IterableExtensions.<String>toList(_map);
    final Predicate<URI> _function_1 = new Predicate<URI>() {
      @Override
      public boolean apply(final URI input) {
        final boolean matches = nameBasedFilter.matches(input);
        if (matches) {
          ResourceURICollector.LOG.info((("Adding file \'" + input) + "\'"));
          resources.add(input);
        }
        return matches;
      }
    };
    final Multimap<String, URI> modelsFound = _pathTraverser.resolvePathes(_list, _function_1);
    Map<String, Collection<URI>> _asMap = modelsFound.asMap();
    final Procedure2<String, Collection<URI>> _function_2 = new Procedure2<String, Collection<URI>>() {
      @Override
      public void apply(final String uri, final Collection<URI> resource) {
        final File file = new File(uri);
        boolean _and = false;
        boolean _and_1 = false;
        boolean _notEquals = (!Objects.equal(resource, null));
        if (!_notEquals) {
          _and_1 = false;
        } else {
          boolean _isDirectory = file.isDirectory();
          boolean _not = (!_isDirectory);
          _and_1 = _not;
        }
        if (!_and_1) {
          _and = false;
        } else {
          String _name = file.getName();
          boolean _endsWith = _name.endsWith(".jar");
          _and = _endsWith;
        }
        if (_and) {
          ResourceURICollector.this.registerBundle(file);
        }
      }
    };
    MapExtensions.<String, Collection<URI>>forEach(_asMap, _function_2);
    return resources;
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
        java.net.URI _uRI = file.toURI();
        String _plus = ("archive:" + _uRI);
        final String path = (_plus + "!/");
        final URI uri = URI.createURI(path);
        Map<String, URI> _platformResourceMap_1 = EcorePlugin.getPlatformResourceMap();
        _platformResourceMap_1.put(name, uri);
      }
    } catch (final Throwable _t) {
      if (_t instanceof ZipException) {
        final ZipException e = (ZipException)_t;
        String _absolutePath = file.getAbsolutePath();
        String _plus_1 = ("Could not open Jar file " + _absolutePath);
        String _plus_2 = (_plus_1 + ".");
        ResourceURICollector.LOG.info(_plus_2);
      } else if (_t instanceof Exception) {
        final Exception e_1 = (Exception)_t;
        String _absolutePath_1 = file.getAbsolutePath();
        ResourceURICollector.LOG.error(_absolutePath_1, e_1);
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
}
