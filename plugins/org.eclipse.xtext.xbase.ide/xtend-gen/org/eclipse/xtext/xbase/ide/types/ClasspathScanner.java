/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.ide.types;

import com.google.common.base.Objects;
import com.google.common.base.Splitter;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.Iterables;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import org.eclipse.xtext.xbase.ide.types.ClasspathTypeDescriptor;
import org.eclipse.xtext.xbase.ide.types.ITypeDescriptor;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class ClasspathScanner {
  private final static Splitter PROPERTY_CLASSPATH_SPLITTER = Splitter.on(File.pathSeparatorChar);
  
  private final static Splitter MANIFEST_CLASSPATH_SPLITTER = Splitter.on(" ").omitEmptyStrings();
  
  private Cache<Pair<ClassLoader, Collection<String>>, Iterable<ITypeDescriptor>> classLoaderDescriptors;
  
  private Cache<Pair<URI, Collection<String>>, Iterable<ITypeDescriptor>> uriDescriptors;
  
  protected Cache<Pair<ClassLoader, Collection<String>>, Iterable<ITypeDescriptor>> createClassLoaderCache() {
    CacheBuilder<Object, Object> _newBuilder = CacheBuilder.newBuilder();
    CacheBuilder<Object, Object> _initialCapacity = _newBuilder.initialCapacity(8);
    CacheBuilder<Object, Object> _concurrencyLevel = _initialCapacity.concurrencyLevel(2);
    CacheBuilder<Object, Object> _maximumSize = _concurrencyLevel.maximumSize(32);
    CacheBuilder<Object, Object> _expireAfterAccess = _maximumSize.expireAfterAccess(5, TimeUnit.MINUTES);
    return _expireAfterAccess.<Pair<ClassLoader, Collection<String>>, Iterable<ITypeDescriptor>>build();
  }
  
  protected Cache<Pair<URI, Collection<String>>, Iterable<ITypeDescriptor>> createUriCache() {
    CacheBuilder<Object, Object> _newBuilder = CacheBuilder.newBuilder();
    CacheBuilder<Object, Object> _initialCapacity = _newBuilder.initialCapacity(64);
    CacheBuilder<Object, Object> _concurrencyLevel = _initialCapacity.concurrencyLevel(2);
    CacheBuilder<Object, Object> _maximumSize = _concurrencyLevel.maximumSize(256);
    CacheBuilder<Object, Object> _expireAfterAccess = _maximumSize.expireAfterAccess(30, TimeUnit.MINUTES);
    return _expireAfterAccess.<Pair<URI, Collection<String>>, Iterable<ITypeDescriptor>>build();
  }
  
  public Iterable<ITypeDescriptor> getDescriptors(final ClassLoader classLoader, final Collection<String> packagePrefixes) {
    try {
      synchronized (this) {
        if ((this.classLoaderDescriptors == null)) {
          Cache<Pair<ClassLoader, Collection<String>>, Iterable<ITypeDescriptor>> _createClassLoaderCache = this.createClassLoaderCache();
          this.classLoaderDescriptors = _createClassLoaderCache;
        }
      }
      Pair<ClassLoader, Collection<String>> _mappedTo = Pair.<ClassLoader, Collection<String>>of(classLoader, packagePrefixes);
      final Callable<Iterable<ITypeDescriptor>> _function = new Callable<Iterable<ITypeDescriptor>>() {
        @Override
        public Iterable<ITypeDescriptor> call() throws Exception {
          return ClasspathScanner.this.loadDescriptors(classLoader, packagePrefixes);
        }
      };
      return this.classLoaderDescriptors.get(_mappedTo, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Iterable<ITypeDescriptor> getDescriptors(final URI uri, final Collection<String> packagePrefixes) {
    try {
      synchronized (this) {
        if ((this.uriDescriptors == null)) {
          Cache<Pair<URI, Collection<String>>, Iterable<ITypeDescriptor>> _createUriCache = this.createUriCache();
          this.uriDescriptors = _createUriCache;
        }
      }
      Pair<URI, Collection<String>> _mappedTo = Pair.<URI, Collection<String>>of(uri, packagePrefixes);
      final Callable<Iterable<ITypeDescriptor>> _function = new Callable<Iterable<ITypeDescriptor>>() {
        @Override
        public Iterable<ITypeDescriptor> call() throws Exception {
          return ClasspathScanner.this.loadDescriptors(uri, packagePrefixes);
        }
      };
      return this.uriDescriptors.get(_mappedTo, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Iterable<ITypeDescriptor> getBootClasspathDescriptors(final Collection<String> packagePrefixes) {
    Iterable<ITypeDescriptor> _xblockexpression = null;
    {
      final String classpath = System.getProperty("sun.boot.class.path");
      if ((classpath == null)) {
        return Collections.<ITypeDescriptor>emptyList();
      }
      Iterable<String> _split = ClasspathScanner.PROPERTY_CLASSPATH_SPLITTER.split(classpath);
      final Function1<String, Iterable<ITypeDescriptor>> _function = new Function1<String, Iterable<ITypeDescriptor>>() {
        @Override
        public Iterable<ITypeDescriptor> apply(final String path) {
          File _file = new File(path);
          URI _uRI = _file.toURI();
          return ClasspathScanner.this.getDescriptors(_uRI, packagePrefixes);
        }
      };
      Iterable<Iterable<ITypeDescriptor>> _map = IterableExtensions.<String, Iterable<ITypeDescriptor>>map(_split, _function);
      _xblockexpression = Iterables.<ITypeDescriptor>concat(_map);
    }
    return _xblockexpression;
  }
  
  protected Iterable<ITypeDescriptor> loadDescriptors(final ClassLoader classLoader, final Collection<String> packagePrefixes) {
    try {
      Iterable<ITypeDescriptor> _xblockexpression = null;
      {
        final LinkedList<ClassLoader> classLoaderHierarchy = new LinkedList<ClassLoader>();
        ClassLoader cl = classLoader;
        while ((cl != null)) {
          {
            classLoaderHierarchy.push(cl);
            ClassLoader _parent = cl.getParent();
            cl = _parent;
          }
        }
        final LinkedHashSet<URI> uris = new LinkedHashSet<URI>();
        while ((!classLoaderHierarchy.isEmpty())) {
          {
            ClassLoader _pop = classLoaderHierarchy.pop();
            cl = _pop;
            if ((cl instanceof URLClassLoader)) {
              URL[] _uRLs = ((URLClassLoader)cl).getURLs();
              for (final URL url : _uRLs) {
                URI _uRI = url.toURI();
                uris.add(_uRI);
              }
            }
          }
        }
        final Function1<URI, Iterable<ITypeDescriptor>> _function = new Function1<URI, Iterable<ITypeDescriptor>>() {
          @Override
          public Iterable<ITypeDescriptor> apply(final URI it) {
            return ClasspathScanner.this.getDescriptors(it, packagePrefixes);
          }
        };
        Iterable<Iterable<ITypeDescriptor>> _map = IterableExtensions.<URI, Iterable<ITypeDescriptor>>map(uris, _function);
        _xblockexpression = Iterables.<ITypeDescriptor>concat(_map);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected Iterable<ITypeDescriptor> loadDescriptors(final URI uri, final Collection<String> packagePrefixes) {
    String _scheme = uri.getScheme();
    boolean _equals = Objects.equal(_scheme, "file");
    if (_equals) {
      final File file = new File(uri);
      boolean _isDirectory = file.isDirectory();
      if (_isDirectory) {
        final ArrayList<ITypeDescriptor> descriptors = new ArrayList<ITypeDescriptor>();
        this.loadDirectoryDescriptors(file, "", descriptors, packagePrefixes);
        return descriptors;
      } else {
        boolean _exists = file.exists();
        if (_exists) {
          return this.loadJarDescriptors(file, true, packagePrefixes);
        }
      }
    }
    return Collections.<ITypeDescriptor>emptyList();
  }
  
  protected void loadDirectoryDescriptors(final File directory, final String packageName, final List<ITypeDescriptor> descriptors, final Collection<String> packagePrefixes) {
    final File[] children = directory.listFiles();
    boolean _equals = Objects.equal(children, null);
    if (_equals) {
      return;
    }
    for (final File file : children) {
      boolean _isDirectory = file.isDirectory();
      if (_isDirectory) {
        String _xifexpression = null;
        boolean _isEmpty = packageName.isEmpty();
        if (_isEmpty) {
          _xifexpression = file.getName();
        } else {
          String _name = file.getName();
          _xifexpression = ((packageName + ".") + _name);
        }
        final String subPackageName = _xifexpression;
        this.loadDirectoryDescriptors(file, subPackageName, descriptors, packagePrefixes);
      } else {
        final ClasspathTypeDescriptor typeDesc = ClasspathTypeDescriptor.forFile(file, packageName, packagePrefixes);
        if ((typeDesc != null)) {
          descriptors.add(typeDesc);
        }
      }
    }
  }
  
  protected Iterable<ITypeDescriptor> loadJarDescriptors(final File file, final boolean includeManifestEntries, final Collection<String> packagePrefixes) {
    try {
      JarFile jarFile = null;
      try {
        JarFile _jarFile = new JarFile(file, false);
        jarFile = _jarFile;
        List<Iterable<ITypeDescriptor>> descriptorCollections = null;
        boolean _and = false;
        if (!includeManifestEntries) {
          _and = false;
        } else {
          Manifest _manifest = jarFile.getManifest();
          boolean _tripleNotEquals = (_manifest != null);
          _and = _tripleNotEquals;
        }
        if (_and) {
          Manifest _manifest_1 = jarFile.getManifest();
          Attributes _mainAttributes = _manifest_1.getMainAttributes();
          final String classpath = _mainAttributes.getValue("Class-Path");
          if ((classpath != null)) {
            ArrayList<Iterable<ITypeDescriptor>> _arrayList = new ArrayList<Iterable<ITypeDescriptor>>();
            descriptorCollections = _arrayList;
            Iterable<String> _split = ClasspathScanner.MANIFEST_CLASSPATH_SPLITTER.split(classpath);
            for (final String path : _split) {
              try {
                URI uri = new URI(path);
                boolean _isAbsolute = uri.isAbsolute();
                boolean _not = (!_isAbsolute);
                if (_not) {
                  File _parentFile = file.getParentFile();
                  String _replace = path.replace("/", File.separator);
                  File _file = new File(_parentFile, _replace);
                  URI _uRI = _file.toURI();
                  uri = _uRI;
                }
                Iterable<ITypeDescriptor> _descriptors = this.getDescriptors(uri, packagePrefixes);
                descriptorCollections.add(_descriptors);
              } catch (final Throwable _t) {
                if (_t instanceof URISyntaxException) {
                  final URISyntaxException exception = (URISyntaxException)_t;
                } else {
                  throw Exceptions.sneakyThrow(_t);
                }
              }
            }
          }
        }
        final ArrayList<ITypeDescriptor> descriptors = new ArrayList<ITypeDescriptor>();
        final Enumeration<JarEntry> entries = jarFile.entries();
        while (entries.hasMoreElements()) {
          {
            final JarEntry entry = entries.nextElement();
            boolean _and_1 = false;
            boolean _isDirectory = entry.isDirectory();
            boolean _not_1 = (!_isDirectory);
            if (!_not_1) {
              _and_1 = false;
            } else {
              String _name = entry.getName();
              boolean _startsWith = _name.startsWith("META-INF");
              boolean _not_2 = (!_startsWith);
              _and_1 = _not_2;
            }
            if (_and_1) {
              final ClasspathTypeDescriptor typeDesc = ClasspathTypeDescriptor.forJarEntry(entry, jarFile, packagePrefixes);
              if ((typeDesc != null)) {
                descriptors.add(typeDesc);
              }
            }
          }
        }
        if ((descriptorCollections == null)) {
          return descriptors;
        } else {
          descriptorCollections.add(descriptors);
          return Iterables.<ITypeDescriptor>concat(descriptorCollections);
        }
      } catch (final Throwable _t_1) {
        if (_t_1 instanceof IOException) {
          final IOException exception_1 = (IOException)_t_1;
          return Collections.<ITypeDescriptor>emptyList();
        } else {
          throw Exceptions.sneakyThrow(_t_1);
        }
      } finally {
        if ((jarFile != null)) {
          jarFile.close();
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
