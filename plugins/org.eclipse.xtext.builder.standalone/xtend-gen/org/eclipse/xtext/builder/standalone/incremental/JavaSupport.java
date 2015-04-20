/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.standalone.incremental;

import com.google.common.base.Objects;
import com.google.common.io.Files;
import com.google.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collections;
import java.util.List;
import org.apache.log4j.Logger;
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
  
  public File generateAndCompileJavaStubs(final Iterable<org.eclipse.emf.common.util.URI> changedResources, final ResourceDescriptionsData newIndex, final BuildRequest request, @Extension final BuildContext context) {
    File _xblockexpression = null;
    {
      final File stubsDir = this.generateStubs(changedResources, newIndex, request, context);
      _xblockexpression = this.compileStubs(stubsDir, request);
    }
    return _xblockexpression;
  }
  
  protected File generateStubs(final Iterable<org.eclipse.emf.common.util.URI> changedResources, final ResourceDescriptionsData newIndex, final BuildRequest request, @Extension final BuildContext context) {
    try {
      final File stubsDir = this.createTempDir("stubs", request);
      String _absolutePath = stubsDir.getAbsolutePath();
      String _plus = ("Generating stubs into " + _absolutePath);
      JavaSupport.LOG.info(_plus);
      String _absolutePath_1 = stubsDir.getAbsolutePath();
      this.commonFileAccess.setOutputPath(IFileSystemAccess.DEFAULT_OUTPUT, _absolutePath_1);
      List<File> _sourceRoots = request.getSourceRoots();
      final Function1<File, org.eclipse.emf.common.util.URI> _function = new Function1<File, org.eclipse.emf.common.util.URI>() {
        @Override
        public org.eclipse.emf.common.util.URI apply(final File it) {
          org.eclipse.emf.common.util.URI _xblockexpression = null;
          {
            String _path = it.getPath();
            final org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI.createFileURI(_path);
            org.eclipse.emf.common.util.URI _xifexpression = null;
            boolean _hasTrailingPathSeparator = uri.hasTrailingPathSeparator();
            if (_hasTrailingPathSeparator) {
              _xifexpression = uri;
            } else {
              _xifexpression = uri.appendSegment("");
            }
            _xblockexpression = _xifexpression;
          }
          return _xblockexpression;
        }
      };
      final List<org.eclipse.emf.common.util.URI> sourceRootURIs = ListExtensions.<File, org.eclipse.emf.common.util.URI>map(_sourceRoots, _function);
      for (final org.eclipse.emf.common.util.URI resource : changedResources) {
        String _fileExtension = resource.fileExtension();
        boolean _equals = Objects.equal(_fileExtension, "java");
        if (_equals) {
          final org.eclipse.emf.common.util.URI relativeURI = this.findSourceRootRelativeURI(resource, sourceRootURIs);
          boolean _equals_1 = Objects.equal(relativeURI, null);
          if (_equals_1) {
            JavaSupport.LOG.error((("Changed java file " + resource) + " is not in any sourceRoot"));
          } else {
            String _fileString = resource.toFileString();
            final File source = new File(_fileString);
            String _string = relativeURI.toString();
            final File target = new File(stubsDir, _string);
            Files.createParentDirs(target);
            Files.copy(source, target);
          }
        } else {
          LanguageAccess _languageAccess = context.getLanguageAccess(resource);
          boolean _isLinksAgainstJava = false;
          if (_languageAccess!=null) {
            _isLinksAgainstJava=_languageAccess.isLinksAgainstJava();
          }
          if (_isLinksAgainstJava) {
            LanguageAccess _languageAccess_1 = context.getLanguageAccess(resource);
            IStubGenerator _stubGenerator = _languageAccess_1.getStubGenerator();
            IResourceDescription _resourceDescription = newIndex.getResourceDescription(resource);
            _stubGenerator.doGenerateStubs(this.commonFileAccess, _resourceDescription);
          }
        }
      }
      return stubsDir;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected org.eclipse.emf.common.util.URI findSourceRootRelativeURI(final org.eclipse.emf.common.util.URI uri, final List<org.eclipse.emf.common.util.URI> sourceRootURIs) {
    for (final org.eclipse.emf.common.util.URI sourceRootURI : sourceRootURIs) {
      {
        final org.eclipse.emf.common.util.URI relativeURI = uri.deresolve(sourceRootURI);
        boolean _notEquals = (!Objects.equal(relativeURI, uri));
        if (_notEquals) {
          return relativeURI;
        }
      }
    }
    return null;
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
    String _absolutePath_1 = stubsDir.getAbsolutePath();
    final List<String> sourcesToCompile = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(_absolutePath_1));
    String _join = IterableExtensions.join(sourcesToCompile, ",");
    String _plus_1 = ("Compiler source roots: " + _join);
    JavaSupport.LOG.info(_plus_1);
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
}
