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
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.ide.types.ClasspathTypeDescriptor;
import org.eclipse.xtext.xbase.ide.types.ITypeDescriptor;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class ClasspathScanner {
  private static class ScanResult {
    private Iterable<ITypeDescriptor> descriptors;
    
    private long timestamp;
  }
  
  private static class CacheCleanerThread extends Thread {
    private final ClasspathScanner cs;
    
    public CacheCleanerThread(final ClasspathScanner cs) {
      super("Xbase Classpath Cache Cleaner");
      this.setDaemon(true);
      this.cs = cs;
    }
    
    @Override
    public void run() {
      try {
        while (true) {
          {
            final long uriCacheTime = (this.cs.uriCacheTime * 1000);
            final long classloaderCacheTime = (this.cs.classloaderCacheTime * 1000);
            long _min = Math.min(uriCacheTime, classloaderCacheTime);
            Thread.sleep(_min);
            /* this.cs.lock; */
            synchronized (this.cs.lock) {
              {
                final long currentTime = System.currentTimeMillis();
                Collection<ClasspathScanner.ScanResult> _values = this.cs.classLoaderDescriptors.values();
                final Iterator<ClasspathScanner.ScanResult> classLoaderResultIter = _values.iterator();
                while (classLoaderResultIter.hasNext()) {
                  if ((currentTime > (classLoaderResultIter.next().timestamp + classloaderCacheTime))) {
                    classLoaderResultIter.remove();
                  }
                }
                Collection<ClasspathScanner.ScanResult> _values_1 = this.cs.uriDescriptors.values();
                final Iterator<ClasspathScanner.ScanResult> uriResultIter = _values_1.iterator();
                while (uriResultIter.hasNext()) {
                  if ((currentTime > (uriResultIter.next().timestamp + uriCacheTime))) {
                    uriResultIter.remove();
                  }
                }
                boolean _and = false;
                boolean _isEmpty = this.cs.classLoaderDescriptors.isEmpty();
                if (!_isEmpty) {
                  _and = false;
                } else {
                  boolean _isEmpty_1 = this.cs.uriDescriptors.isEmpty();
                  _and = _isEmpty_1;
                }
                if (_and) {
                  this.cs.cacheCleanerThread = null;
                  return;
                }
              }
            }
          }
        }
      } catch (final Throwable _t) {
        if (_t instanceof InterruptedException) {
          final InterruptedException exception = (InterruptedException)_t;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
  }
  
  /**
   * The default time after which a cached classloader scan result is cleared, in seconds.
   */
  private final static long CLASSLOADER_CACHE_TIME = 300;
  
  /**
   * The default time after which a cached URI scan result is cleared, in seconds.
   */
  private final static long URI_CACHE_TIME = 1800;
  
  private final static Splitter PROPERTY_CLASSPATH_SPLITTER = Splitter.on(File.pathSeparatorChar);
  
  private final static Splitter MANIFEST_CLASSPATH_SPLITTER = Splitter.on(" ").omitEmptyStrings();
  
  @Accessors
  private long classloaderCacheTime = ClasspathScanner.CLASSLOADER_CACHE_TIME;
  
  @Accessors
  private long uriCacheTime = ClasspathScanner.URI_CACHE_TIME;
  
  private final Object lock = new Object();
  
  private final HashMap<Pair<ClassLoader, Collection<String>>, ClasspathScanner.ScanResult> classLoaderDescriptors = new HashMap<Pair<ClassLoader, Collection<String>>, ClasspathScanner.ScanResult>();
  
  private final HashMap<Pair<URI, Collection<String>>, ClasspathScanner.ScanResult> uriDescriptors = new HashMap<Pair<URI, Collection<String>>, ClasspathScanner.ScanResult>();
  
  private ClasspathScanner.CacheCleanerThread cacheCleanerThread;
  
  public Iterable<ITypeDescriptor> getDescriptors(final ClassLoader classLoader, final Collection<String> packagePrefixes) {
    final Pair<ClassLoader, Collection<String>> key = new Pair<ClassLoader, Collection<String>>(classLoader, packagePrefixes);
    /* this.lock; */
    synchronized (this.lock) {
      {
        ClasspathScanner.ScanResult result = this.classLoaderDescriptors.get(key);
        if ((result == null)) {
          ClasspathScanner.ScanResult _loadDescriptors = this.loadDescriptors(classLoader, packagePrefixes);
          result = _loadDescriptors;
          this.classLoaderDescriptors.put(key, result);
          if ((this.cacheCleanerThread == null)) {
            ClasspathScanner.CacheCleanerThread _cacheCleanerThread = new ClasspathScanner.CacheCleanerThread(this);
            this.cacheCleanerThread = _cacheCleanerThread;
            this.cacheCleanerThread.start();
          }
        }
        long _currentTimeMillis = System.currentTimeMillis();
        result.timestamp = _currentTimeMillis;
        return result.descriptors;
      }
    }
  }
  
  public Iterable<ITypeDescriptor> getDescriptors(final URI uri, final Collection<String> packagePrefixes) {
    final Pair<URI, Collection<String>> key = new Pair<URI, Collection<String>>(uri, packagePrefixes);
    /* this.lock; */
    synchronized (this.lock) {
      {
        ClasspathScanner.ScanResult result = this.uriDescriptors.get(key);
        if ((result == null)) {
          ClasspathScanner.ScanResult _loadDescriptors = this.loadDescriptors(uri, packagePrefixes);
          result = _loadDescriptors;
          this.uriDescriptors.put(key, result);
          if ((this.cacheCleanerThread == null)) {
            ClasspathScanner.CacheCleanerThread _cacheCleanerThread = new ClasspathScanner.CacheCleanerThread(this);
            this.cacheCleanerThread = _cacheCleanerThread;
            this.cacheCleanerThread.start();
          }
        }
        long _currentTimeMillis = System.currentTimeMillis();
        result.timestamp = _currentTimeMillis;
        return result.descriptors;
      }
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
          try {
            URI _uRI = new URI("file", null, path, null);
            return ClasspathScanner.this.getDescriptors(_uRI, packagePrefixes);
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      Iterable<Iterable<ITypeDescriptor>> _map = IterableExtensions.<String, Iterable<ITypeDescriptor>>map(_split, _function);
      _xblockexpression = Iterables.<ITypeDescriptor>concat(_map);
    }
    return _xblockexpression;
  }
  
  protected ClasspathScanner.ScanResult loadDescriptors(final ClassLoader classLoader, final Collection<String> packagePrefixes) {
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
      ClasspathScanner.ScanResult _scanResult = new ClasspathScanner.ScanResult();
      final Procedure1<ClasspathScanner.ScanResult> _function = new Procedure1<ClasspathScanner.ScanResult>() {
        @Override
        public void apply(final ClasspathScanner.ScanResult it) {
          final Function1<URI, Iterable<ITypeDescriptor>> _function = new Function1<URI, Iterable<ITypeDescriptor>>() {
            @Override
            public Iterable<ITypeDescriptor> apply(final URI it) {
              return ClasspathScanner.this.getDescriptors(it, packagePrefixes);
            }
          };
          Iterable<Iterable<ITypeDescriptor>> _map = IterableExtensions.<URI, Iterable<ITypeDescriptor>>map(uris, _function);
          Iterable<ITypeDescriptor> _flatten = Iterables.<ITypeDescriptor>concat(_map);
          it.descriptors = _flatten;
        }
      };
      return ObjectExtensions.<ClasspathScanner.ScanResult>operator_doubleArrow(_scanResult, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected ClasspathScanner.ScanResult loadDescriptors(final URI uri, final Collection<String> packagePrefixes) {
    final ClasspathScanner.ScanResult result = new ClasspathScanner.ScanResult();
    String _scheme = uri.getScheme();
    boolean _equals = Objects.equal(_scheme, "file");
    if (_equals) {
      final File file = new File(uri);
      boolean _isDirectory = file.isDirectory();
      if (_isDirectory) {
        final ArrayList<ITypeDescriptor> descriptors = new ArrayList<ITypeDescriptor>();
        this.loadDirectoryDescriptors(file, "", descriptors, packagePrefixes);
        result.descriptors = descriptors;
      } else {
        boolean _exists = file.exists();
        if (_exists) {
          Iterable<ITypeDescriptor> _loadJarDescriptors = this.loadJarDescriptors(file, true, packagePrefixes);
          result.descriptors = _loadJarDescriptors;
        }
      }
    }
    if ((result.descriptors == null)) {
      List<ITypeDescriptor> _emptyList = Collections.<ITypeDescriptor>emptyList();
      result.descriptors = _emptyList;
    }
    return result;
  }
  
  protected void loadDirectoryDescriptors(final File directory, final String packageName, final List<ITypeDescriptor> descriptors, final Collection<String> packagePrefixes) {
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
  
  @Pure
  public long getClassloaderCacheTime() {
    return this.classloaderCacheTime;
  }
  
  public void setClassloaderCacheTime(final long classloaderCacheTime) {
    this.classloaderCacheTime = classloaderCacheTime;
  }
  
  @Pure
  public long getUriCacheTime() {
    return this.uriCacheTime;
  }
  
  public void setUriCacheTime(final long uriCacheTime) {
    this.uriCacheTime = uriCacheTime;
  }
}
