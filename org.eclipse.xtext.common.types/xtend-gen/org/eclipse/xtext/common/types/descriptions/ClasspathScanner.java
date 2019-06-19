/**
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.common.types.descriptions;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.Resource;
import io.github.classgraph.ScanResult;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.common.types.descriptions.ClasspathTypeDescriptor;
import org.eclipse.xtext.common.types.descriptions.ITypeDescriptor;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Singleton
@SuppressWarnings("all")
public class ClasspathScanner {
  @Data
  protected static class ClassLoaderPackageConfig {
    private final ClassLoader loader;
    
    private final boolean bootstrap;
    
    private final Collection<String> packagePrefixes;
    
    public ClassLoaderPackageConfig(final ClassLoader loader, final boolean bootstrap, final Collection<String> packagePrefixes) {
      super();
      this.loader = loader;
      this.bootstrap = bootstrap;
      this.packagePrefixes = packagePrefixes;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.loader== null) ? 0 : this.loader.hashCode());
      result = prime * result + (this.bootstrap ? 1231 : 1237);
      return prime * result + ((this.packagePrefixes== null) ? 0 : this.packagePrefixes.hashCode());
    }
    
    @Override
    @Pure
    public boolean equals(final Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      ClasspathScanner.ClassLoaderPackageConfig other = (ClasspathScanner.ClassLoaderPackageConfig) obj;
      if (this.loader == null) {
        if (other.loader != null)
          return false;
      } else if (!this.loader.equals(other.loader))
        return false;
      if (other.bootstrap != this.bootstrap)
        return false;
      if (this.packagePrefixes == null) {
        if (other.packagePrefixes != null)
          return false;
      } else if (!this.packagePrefixes.equals(other.packagePrefixes))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("loader", this.loader);
      b.add("bootstrap", this.bootstrap);
      b.add("packagePrefixes", this.packagePrefixes);
      return b.toString();
    }
    
    @Pure
    public ClassLoader getLoader() {
      return this.loader;
    }
    
    @Pure
    public boolean isBootstrap() {
      return this.bootstrap;
    }
    
    @Pure
    public Collection<String> getPackagePrefixes() {
      return this.packagePrefixes;
    }
  }
  
  @Inject
  private Provider<ClassGraph> classGraphProvider = ((Provider<ClassGraph>) () -> {
    return new ClassGraph();
  });
  
  private Cache<ClasspathScanner.ClassLoaderPackageConfig, Iterable<ITypeDescriptor>> classLoaderDescriptors = this.createClassLoaderCache();
  
  protected Cache<ClasspathScanner.ClassLoaderPackageConfig, Iterable<ITypeDescriptor>> createClassLoaderCache() {
    return CacheBuilder.newBuilder().initialCapacity(8).concurrencyLevel(2).maximumSize(32).expireAfterAccess(5, TimeUnit.MINUTES).<ClasspathScanner.ClassLoaderPackageConfig, Iterable<ITypeDescriptor>>build();
  }
  
  public Iterable<ITypeDescriptor> getDescriptors(final ClassLoader classLoader, final Collection<String> packagePrefixes) {
    return this.getDescriptors(classLoader, false, packagePrefixes);
  }
  
  protected Iterable<ITypeDescriptor> getDescriptors(final ClassLoader classLoader, final boolean bootstrap, final Collection<String> packagePrefixes) {
    try {
      ClasspathScanner.ClassLoaderPackageConfig _classLoaderPackageConfig = new ClasspathScanner.ClassLoaderPackageConfig(classLoader, bootstrap, packagePrefixes);
      final Callable<Iterable<ITypeDescriptor>> _function = () -> {
        return this.loadDescriptors(classLoader, bootstrap, packagePrefixes);
      };
      return this.classLoaderDescriptors.get(_classLoaderPackageConfig, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Iterable<ITypeDescriptor> getBootClasspathDescriptors(final Collection<String> packagePrefixes) {
    return this.getDescriptors(ClassLoader.getSystemClassLoader(), true, packagePrefixes);
  }
  
  private String[] systemClasspath = null;
  
  public String[] getSystemClasspath() {
    if ((this.systemClasspath != null)) {
      return this.systemClasspath;
    }
    try (final ScanResult scanResult = this.classGraphProvider.get().enableSystemJarsAndModules().addClassLoader(ClassLoader.getSystemClassLoader()).scan()) {
      final List<URI> classpathURIs = scanResult.getClasspathURIs();
      final Function1<URI, String> _function = (URI it) -> {
        return it.getPath();
      };
      this.systemClasspath = ((String[])Conversions.unwrapArray(IterableExtensions.<String>filterNull(ListExtensions.<URI, String>map(classpathURIs, _function)), String.class));
      return this.systemClasspath;
    }
  }
  
  protected Iterable<ITypeDescriptor> loadDescriptors(final ClassLoader classLoader, final boolean bootstrap, final Collection<String> packagePrefixes) {
    final ClassGraph classGraph = this.classGraphProvider.get().ignoreClassVisibility().enableClassInfo().whitelistPackages(packagePrefixes.<String>toArray(new String[] {})).addClassLoader(classLoader);
    if (bootstrap) {
      classGraph.enableSystemJarsAndModules();
    }
    try (final ScanResult scanResult = classGraph.scan()) {
      return this.loadDescriptors(scanResult);
    }
  }
  
  protected Iterable<ITypeDescriptor> loadDescriptors(final ScanResult scanResult) {
    final ArrayList<ITypeDescriptor> result = new ArrayList<ITypeDescriptor>();
    final Consumer<ClassInfo> _function = (ClassInfo clazz) -> {
      Resource _resource = clazz.getResource();
      boolean _tripleNotEquals = (_resource != null);
      if (_tripleNotEquals) {
        result.add(this.newDescriptor(clazz.getName(), clazz.getModifiers()));
      }
    };
    scanResult.getAllClasses().forEach(_function);
    return result;
  }
  
  protected ITypeDescriptor newDescriptor(final String name, final int modifiers) {
    return new ClasspathTypeDescriptor(name, modifiers);
  }
}
