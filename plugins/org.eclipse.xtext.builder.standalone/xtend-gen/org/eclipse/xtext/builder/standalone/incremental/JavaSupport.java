/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.standalone.incremental;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.builder.standalone.LanguageAccess;
import org.eclipse.xtext.builder.standalone.compiler.IJavaCompiler;
import org.eclipse.xtext.builder.standalone.incremental.BuildContext;
import org.eclipse.xtext.builder.standalone.incremental.BuildRequest;
import org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess;
import org.eclipse.xtext.common.types.access.impl.TypeResourceServices;
import org.eclipse.xtext.common.types.descriptions.IStubGenerator;
import org.eclipse.xtext.generator.AbstractFileSystemAccess;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.9
 */
@SuppressWarnings("all")
public class JavaSupport {
  private final static Logger LOG = Logger.getLogger(JavaSupport.class);
  
  @Inject
  private TypeResourceServices typeResourceServices;
  
  @Inject
  private IndexedJvmTypeAccess typeAccess;
  
  @Inject
  private IJavaCompiler compiler;
  
  @Inject
  private AbstractFileSystemAccess commonFileAccess;
  
  public void installLocalOnlyTypeProvider(final Iterable<File> classPathRoots, final XtextResourceSet resourceSet) {
    JavaSupport.LOG.info("Installing type provider for local types only");
    final URLClassLoader classLoader = this.createURLClassLoader(classPathRoots);
    new ClasspathTypeProvider(classLoader, resourceSet, null, this.typeResourceServices);
    resourceSet.setClasspathURIContext(classLoader);
  }
  
  public File generateAndCompileJavaStubs(final Iterable<URI> changedResources, final ResourceDescriptionsData newIndex, final BuildRequest request, @Extension final BuildContext context) {
    File _generateStubs = this.generateStubs(changedResources, newIndex, request, context);
    return this.compileStubs(_generateStubs, request);
  }
  
  public void installTypeProvider(final Iterable<File> classPathRoots, final XtextResourceSet resSet) {
    JavaSupport.LOG.info("Installing type provider with stubs");
    final URLClassLoader classLoader = this.createURLClassLoader(classPathRoots);
    new ClasspathTypeProvider(classLoader, resSet, this.typeAccess, this.typeResourceServices);
    resSet.setClasspathURIContext(classLoader);
  }
  
  protected URLClassLoader createURLClassLoader(final Iterable<File> classPathEntries) {
    final Function1<File, URL> _function = new Function1<File, URL>() {
      @Override
      public URL apply(final File it) {
        try {
          java.net.URI _uRI = it.toURI();
          return _uRI.toURL();
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    final Iterable<URL> classPathUrls = IterableExtensions.<File, URL>map(classPathEntries, _function);
    return new URLClassLoader(((URL[])Conversions.unwrapArray(classPathUrls, URL.class)));
  }
  
  protected File compileStubs(final File stubsDir, final BuildRequest request) {
    final File stubsClassesFolder = this.createTempDir("classes", request);
    List<File> _classPath = request.getClassPath();
    final Function1<File, String> _function = new Function1<File, String>() {
      @Override
      public String apply(final File it) {
        return it.getAbsolutePath();
      }
    };
    List<String> _map = ListExtensions.<File, String>map(_classPath, _function);
    this.compiler.setClassPath(_map);
    String _absolutePath = stubsDir.getAbsolutePath();
    String _plus = ("Compiling stubs located in " + _absolutePath);
    JavaSupport.LOG.info(_plus);
    List<File> _sourceRoots = request.getSourceRoots();
    final Function1<File, String> _function_1 = new Function1<File, String>() {
      @Override
      public String apply(final File it) {
        return it.getAbsolutePath();
      }
    };
    List<String> _map_1 = ListExtensions.<File, String>map(_sourceRoots, _function_1);
    String _absolutePath_1 = stubsDir.getAbsolutePath();
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList(_absolutePath_1);
    Iterable<String> _plus_1 = Iterables.<String>concat(_map_1, _newArrayList);
    final Set<String> sourcesToCompile = this.uniqueEntries(_plus_1);
    String _join = IterableExtensions.join(sourcesToCompile, ",");
    String _plus_2 = ("Compiler source roots: " + _join);
    JavaSupport.LOG.info(_plus_2);
    final IJavaCompiler.CompilationResult result = this.compiler.compile(sourcesToCompile, stubsClassesFolder);
    if (result != null) {
      switch (result) {
        case SKIPPED:
          JavaSupport.LOG.info("Nothing to compile. Stubs compilation was skipped.");
          break;
        case FAILED:
          JavaSupport.LOG.info("Stubs compilation finished with errors.");
          break;
        case SUCCEEDED:
          JavaSupport.LOG.info("Stubs compilation successfully finished.");
          break;
        default:
          break;
      }
    }
    return stubsClassesFolder;
  }
  
  protected File generateStubs(final Iterable<URI> changedResources, final ResourceDescriptionsData newIndex, final BuildRequest request, @Extension final BuildContext context) {
    final File stubsDir = this.createTempDir("stubs", request);
    String _absolutePath = stubsDir.getAbsolutePath();
    String _plus = ("Generating stubs into " + _absolutePath);
    JavaSupport.LOG.info(_plus);
    String _absolutePath_1 = stubsDir.getAbsolutePath();
    this.commonFileAccess.setOutputPath(IFileSystemAccess.DEFAULT_OUTPUT, _absolutePath_1);
    final Function1<URI, Boolean> _function = new Function1<URI, Boolean>() {
      @Override
      public Boolean apply(final URI it) {
        LanguageAccess _languageAccess = context.getLanguageAccess(it);
        return Boolean.valueOf(_languageAccess.isLinksAgainstJava());
      }
    };
    final Iterable<URI> generateStubs = IterableExtensions.<URI>filter(changedResources, _function);
    final Procedure1<URI> _function_1 = new Procedure1<URI>() {
      @Override
      public void apply(final URI it) {
        LanguageAccess _languageAccess = context.getLanguageAccess(it);
        IStubGenerator _stubGenerator = _languageAccess.getStubGenerator();
        IResourceDescription _resourceDescription = newIndex.getResourceDescription(it);
        _stubGenerator.doGenerateStubs(JavaSupport.this.commonFileAccess, _resourceDescription);
      }
    };
    IterableExtensions.<URI>forEach(generateStubs, _function_1);
    return stubsDir;
  }
  
  protected File createTempDir(final String subDir, final BuildRequest request) {
    try {
      File _tempDir = request.getTempDir();
      final File file = new File(_tempDir, subDir);
      boolean _and = false;
      boolean _mkdirs = file.mkdirs();
      boolean _not = (!_mkdirs);
      if (!_not) {
        _and = false;
      } else {
        boolean _exists = file.exists();
        boolean _not_1 = (!_exists);
        _and = _not_1;
      }
      if (_and) {
        String _absolutePath = file.getAbsolutePath();
        String _plus = ("Failed to create directory \'" + _absolutePath);
        String _plus_1 = (_plus + "\'");
        throw new IOException(_plus_1);
      }
      return file;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected Set<String> uniqueEntries(final Iterable<String> pathes) {
    final Function1<String, String> _function = new Function1<String, String>() {
      @Override
      public String apply(final String it) {
        File _file = new File(it);
        return _file.getAbsolutePath();
      }
    };
    Iterable<String> _map = IterableExtensions.<String, String>map(pathes, _function);
    return IterableExtensions.<String>toSet(_map);
  }
}
