/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.standalone.incremental;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.io.Files;
import com.google.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collections;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.builder.standalone.LanguageAccess;
import org.eclipse.xtext.builder.standalone.compiler.IJavaCompiler;
import org.eclipse.xtext.builder.standalone.incremental.BuildContext;
import org.eclipse.xtext.builder.standalone.incremental.BuildRequest;
import org.eclipse.xtext.builder.standalone.incremental.FilesAndURIs;
import org.eclipse.xtext.common.types.descriptions.IStubGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.9
 */
@SuppressWarnings("all")
public class JavaSupport {
  private final static Logger LOG = Logger.getLogger(JavaSupport.class);
  
  @Inject
  private IJavaCompiler compiler;
  
  @Inject
  private JavaIoFileSystemAccess commonFileAccess;
  
  protected URLClassLoader createURLClassLoader(final Iterable<URI> classPathEntries) {
    final Function1<URI, URL> _function = new Function1<URI, URL>() {
      @Override
      public URL apply(final URI it) {
        try {
          String _string = it.toString();
          return new URL(_string);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    final Iterable<URL> classPathUrls = IterableExtensions.<URI, URL>map(classPathEntries, _function);
    return new URLClassLoader(((URL[])Conversions.unwrapArray(classPathUrls, URL.class)));
  }
  
  public URI preCompileJavaFiles(final Iterable<URI> changedResources, final ResourceDescriptionsData newIndex, final BuildRequest request, @Extension final BuildContext context) {
    try {
      final File stubsDir = this.createTmpDir("stubs", request);
      final File javaDir = this.createTmpDir("java", request);
      String _absolutePath = stubsDir.getAbsolutePath();
      String _plus = ("Generating stubs into " + _absolutePath);
      JavaSupport.LOG.info(_plus);
      String _absolutePath_1 = javaDir.getAbsolutePath();
      String _plus_1 = ("Copying modified Java files into " + _absolutePath_1);
      JavaSupport.LOG.info(_plus_1);
      final Procedure1<JavaIoFileSystemAccess> _function = new Procedure1<JavaIoFileSystemAccess>() {
        @Override
        public void apply(final JavaIoFileSystemAccess it) {
          String _absolutePath = stubsDir.getAbsolutePath();
          it.setOutputPath(IFileSystemAccess.DEFAULT_OUTPUT, _absolutePath);
          it.setWriteTrace(false);
        }
      };
      ObjectExtensions.<JavaIoFileSystemAccess>operator_doubleArrow(
        this.commonFileAccess, _function);
      for (final URI resource : changedResources) {
        String _fileExtension = resource.fileExtension();
        boolean _equals = Objects.equal(_fileExtension, "java");
        if (_equals) {
          final URI relativeURI = FilesAndURIs.findSourceRootRelativeURI(resource, request);
          boolean _equals_1 = Objects.equal(relativeURI, null);
          if (_equals_1) {
            JavaSupport.LOG.error((("Changed java file " + resource) + " is not in any sourceRoot"));
          } else {
            String _asPath = FilesAndURIs.asPath(resource);
            final File source = new File(_asPath);
            String _string = relativeURI.toString();
            final File target = new File(javaDir, _string);
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
      final File stubsClasses = this.createTmpDir("stubs-classes", request);
      final File javaClasses = this.createTmpDir("classes", request);
      this.compile(stubsDir, stubsClasses, request);
      this.compile(javaDir, javaClasses, request, stubsClasses);
      return FilesAndURIs.asURI(javaClasses);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void compile(final File sourceDir, final File targetDir, final BuildRequest request, final File... additionalClassesFolders) {
    final Function1<File, String> _function = new Function1<File, String>() {
      @Override
      public String apply(final File it) {
        return it.getAbsolutePath();
      }
    };
    List<String> _map = ListExtensions.<File, String>map(((List<File>)Conversions.doWrapArray(additionalClassesFolders)), _function);
    List<URI> _outputs = request.getOutputs();
    final Function1<URI, String> _function_1 = new Function1<URI, String>() {
      @Override
      public String apply(final URI it) {
        return FilesAndURIs.asPath(it);
      }
    };
    List<String> _map_1 = ListExtensions.<URI, String>map(_outputs, _function_1);
    Iterable<String> _plus = Iterables.<String>concat(_map, _map_1);
    List<URI> _classPath = request.getClassPath();
    final Function1<URI, String> _function_2 = new Function1<URI, String>() {
      @Override
      public String apply(final URI it) {
        return FilesAndURIs.asPath(it);
      }
    };
    List<String> _map_2 = ListExtensions.<URI, String>map(_classPath, _function_2);
    Iterable<String> _plus_1 = Iterables.<String>concat(_plus, _map_2);
    this.compiler.setClassPath(_plus_1);
    String _absolutePath = sourceDir.getAbsolutePath();
    String _plus_2 = ("Pre-compiling java files located in " + _absolutePath);
    JavaSupport.LOG.info(_plus_2);
    String _absolutePath_1 = sourceDir.getAbsolutePath();
    final IJavaCompiler.CompilationResult result = this.compiler.compile(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(_absolutePath_1)), targetDir);
    if (result != null) {
      switch (result) {
        case SKIPPED:
          JavaSupport.LOG.info("Nothing to pre-compile.");
          break;
        case FAILED:
          JavaSupport.LOG.info("Pre-compilation finished with errors. No need to worry. This is normal.");
          break;
        case SUCCEEDED:
          JavaSupport.LOG.info("Pre-compilation successfully finished.");
          break;
        default:
          break;
      }
    }
  }
  
  protected File createTmpDir(final String subDir, final BuildRequest request) {
    try {
      URI _baseDir = request.getBaseDir();
      File _asFile = FilesAndURIs.asFile(_baseDir);
      final File tmpRoot = new File(_asFile, "xtext-tmp");
      boolean _and = false;
      boolean _mkdirs = tmpRoot.mkdirs();
      boolean _not = (!_mkdirs);
      if (!_not) {
        _and = false;
      } else {
        boolean _exists = tmpRoot.exists();
        boolean _not_1 = (!_exists);
        _and = _not_1;
      }
      if (_and) {
        String _absolutePath = tmpRoot.getAbsolutePath();
        String _plus = ("Failed to create directory \'" + _absolutePath);
        String _plus_1 = (_plus + "\'");
        throw new IOException(_plus_1);
      }
      final File tmpDir = new File(tmpRoot, subDir);
      boolean _and_1 = false;
      boolean _mkdirs_1 = tmpDir.mkdirs();
      boolean _not_2 = (!_mkdirs_1);
      if (!_not_2) {
        _and_1 = false;
      } else {
        boolean _exists_1 = tmpDir.exists();
        boolean _not_3 = (!_exists_1);
        _and_1 = _not_3;
      }
      if (_and_1) {
        String _absolutePath_1 = tmpDir.getAbsolutePath();
        String _plus_2 = ("Failed to create directory \'" + _absolutePath_1);
        String _plus_3 = (_plus_2 + "\'");
        throw new IOException(_plus_3);
      }
      return tmpDir;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
