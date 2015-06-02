/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.web.scoping;

import com.google.common.base.Objects;
import com.google.common.base.Splitter;
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
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.web.scoping.ClasspathTypeDescriptor;

@SuppressWarnings("all")
public class ClasspathScanner {
  private final static Splitter PROPERTY_CLASSPATH_SPLITTER = Splitter.on(File.pathSeparatorChar);
  
  private final static Splitter MANIFEST_CLASSPATH_SPLITTER = Splitter.on(" ").omitEmptyStrings();
  
  @Accessors
  private final static ClasspathScanner instance = new ClasspathScanner();
  
  private final HashMap<Pair<ClassLoader, Collection<String>>, Iterable<ClasspathTypeDescriptor>> classLoaderDescriptors = new HashMap<Pair<ClassLoader, Collection<String>>, Iterable<ClasspathTypeDescriptor>>();
  
  private final HashMap<Pair<URI, Collection<String>>, Iterable<ClasspathTypeDescriptor>> uriDescriptors = new HashMap<Pair<URI, Collection<String>>, Iterable<ClasspathTypeDescriptor>>();
  
  public Iterable<ClasspathTypeDescriptor> getDescriptors(final ClassLoader classLoader, final Collection<String> packagePrefixes) {
    final Pair<ClassLoader, Collection<String>> key = new Pair<ClassLoader, Collection<String>>(classLoader, packagePrefixes);
    /* this.classLoaderDescriptors; */
    synchronized (this.classLoaderDescriptors) {
      {
        Iterable<ClasspathTypeDescriptor> result = this.classLoaderDescriptors.get(key);
        if ((result == null)) {
          Iterable<ClasspathTypeDescriptor> _loadDescriptors = this.loadDescriptors(classLoader, packagePrefixes);
          result = _loadDescriptors;
          this.classLoaderDescriptors.put(key, result);
        }
        return result;
      }
    }
  }
  
  public Iterable<ClasspathTypeDescriptor> getDescriptors(final URI uri, final Collection<String> packagePrefixes) {
    final Pair<URI, Collection<String>> key = new Pair<URI, Collection<String>>(uri, packagePrefixes);
    /* this.uriDescriptors; */
    synchronized (this.uriDescriptors) {
      {
        Iterable<ClasspathTypeDescriptor> result = this.uriDescriptors.get(key);
        if ((result == null)) {
          Iterable<ClasspathTypeDescriptor> _loadDescriptors = this.loadDescriptors(uri, packagePrefixes);
          result = _loadDescriptors;
          this.uriDescriptors.put(key, result);
        }
        return result;
      }
    }
  }
  
  public Iterable<ClasspathTypeDescriptor> getBootClasspathDescriptors(final Collection<String> packagePrefixes) {
    Iterable<ClasspathTypeDescriptor> _xblockexpression = null;
    {
      final String classpath = System.getProperty("sun.boot.class.path");
      if ((classpath == null)) {
        return Collections.<ClasspathTypeDescriptor>emptyList();
      }
      Iterable<String> _split = ClasspathScanner.PROPERTY_CLASSPATH_SPLITTER.split(classpath);
      final Function1<String, Iterable<ClasspathTypeDescriptor>> _function = new Function1<String, Iterable<ClasspathTypeDescriptor>>() {
        @Override
        public Iterable<ClasspathTypeDescriptor> apply(final String path) {
          try {
            URI _uRI = new URI("file", null, path, null);
            return ClasspathScanner.this.getDescriptors(_uRI, packagePrefixes);
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      Iterable<Iterable<ClasspathTypeDescriptor>> _map = IterableExtensions.<String, Iterable<ClasspathTypeDescriptor>>map(_split, _function);
      _xblockexpression = Iterables.<ClasspathTypeDescriptor>concat(_map);
    }
    return _xblockexpression;
  }
  
  protected Iterable<ClasspathTypeDescriptor> loadDescriptors(final ClassLoader classLoader, final Collection<String> packagePrefixes) {
    try {
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
      final Function1<URI, Iterable<ClasspathTypeDescriptor>> _function = new Function1<URI, Iterable<ClasspathTypeDescriptor>>() {
        @Override
        public Iterable<ClasspathTypeDescriptor> apply(final URI it) {
          return ClasspathScanner.this.getDescriptors(it, packagePrefixes);
        }
      };
      Iterable<Iterable<ClasspathTypeDescriptor>> _map = IterableExtensions.<URI, Iterable<ClasspathTypeDescriptor>>map(uris, _function);
      return Iterables.<ClasspathTypeDescriptor>concat(_map);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected Iterable<ClasspathTypeDescriptor> loadDescriptors(final URI uri, final Collection<String> packagePrefixes) {
    String _scheme = uri.getScheme();
    boolean _equals = Objects.equal(_scheme, "file");
    if (_equals) {
      final File file = new File(uri);
      boolean _isDirectory = file.isDirectory();
      if (_isDirectory) {
        final ArrayList<ClasspathTypeDescriptor> descriptors = new ArrayList<ClasspathTypeDescriptor>();
        this.loadDirectoryDescriptors(file, "", descriptors, packagePrefixes);
        return descriptors;
      } else {
        boolean _exists = file.exists();
        if (_exists) {
          return this.loadJarDescriptors(file, true, packagePrefixes);
        }
      }
    }
    return Collections.<ClasspathTypeDescriptor>emptyList();
  }
  
  protected void loadDirectoryDescriptors(final File directory, final String packageName, final List<ClasspathTypeDescriptor> descriptors, final Collection<String> packagePrefixes) {
    File[] _listFiles = directory.listFiles();
    for (final File file : _listFiles) {
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
  
  protected Iterable<ClasspathTypeDescriptor> loadJarDescriptors(final File file, final boolean includeManifestEntries, final Collection<String> packagePrefixes) {
    try {
      JarFile jarFile = null;
      try {
        JarFile _jarFile = new JarFile(file, false);
        jarFile = _jarFile;
        List<Iterable<ClasspathTypeDescriptor>> descriptorCollections = null;
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
            ArrayList<Iterable<ClasspathTypeDescriptor>> _arrayList = new ArrayList<Iterable<ClasspathTypeDescriptor>>();
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
                Iterable<ClasspathTypeDescriptor> _descriptors = this.getDescriptors(uri, packagePrefixes);
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
        final ArrayList<ClasspathTypeDescriptor> descriptors = new ArrayList<ClasspathTypeDescriptor>();
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
          return Iterables.<ClasspathTypeDescriptor>concat(descriptorCollections);
        }
      } catch (final Throwable _t_1) {
        if (_t_1 instanceof IOException) {
          final IOException exception_1 = (IOException)_t_1;
          return Collections.<ClasspathTypeDescriptor>emptyList();
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
  
  @Pure
  public static ClasspathScanner getInstance() {
    return ClasspathScanner.instance;
  }
}
