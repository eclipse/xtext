/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.conversion;

import com.google.common.base.Predicate;
import com.google.common.io.Files;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.core.conversion.JavaConverter;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.mwe.PathTraverser;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class JavaFileConverterTest extends AbstractXtendTestCase {
  @Inject
  private Provider<JavaConverter> javaConverter;
  
  @Test
  @Ignore
  public void testConvertFilesInThisProject() throws Exception {
    File _file = new File("");
    final File projectRoot = _file.getAbsoluteFile();
    File _parentFile = projectRoot.getParentFile();
    final File testProject = new File(_parentFile, "test-converter");
    String _path = projectRoot.getPath();
    String _plus = ("Working in " + _path);
    InputOutput.<String>println(_plus);
    final PathTraverser pathTraverser = new PathTraverser();
    String _absolutePath = projectRoot.getAbsolutePath();
    final Set<URI> allResourceUris = pathTraverser.findAllResourceUris(_absolutePath, 
      new Predicate<URI>() {
        public boolean apply(final URI input) {
          final String fileName = input.toFileString();
          boolean _and = false;
          boolean _and_1 = false;
          String _fileExtension = input.fileExtension();
          boolean _equals = "java".equals(_fileExtension);
          if (!_equals) {
            _and_1 = false;
          } else {
            boolean _contains = fileName.contains("xtend-gen");
            boolean _not = (!_contains);
            _and_1 = _not;
          }
          if (!_and_1) {
            _and = false;
          } else {
            boolean _contains_1 = fileName.contains("ScenarioBug395002");
            boolean _not_1 = (!_contains_1);
            _and = _not_1;
          }
          return _and;
        }
      });
    int errors = 0;
    int problems = 0;
    for (final URI uri : allResourceUris) {
      {
        String _fileString = uri.toFileString();
        final File file = new File(_fileString);
        String _absolutePath_1 = file.getAbsolutePath();
        String _plus_1 = ("Converting: " + _absolutePath_1);
        InputOutput.<String>println(_plus_1);
        Charset _defaultCharset = Charset.defaultCharset();
        final String javaCode = Files.toString(file, _defaultCharset);
        final JavaConverter j2x = this.javaConverter.get();
        String _name = file.getName();
        final JavaConverter.ConversionResult xtendResult = j2x.toXtend(_name, javaCode);
        int _problems = problems;
        Iterable<String> _problems_1 = xtendResult.getProblems();
        int _size = IterableExtensions.size(_problems_1);
        problems = (_problems + _size);
        final String xtendCode = xtendResult.getXtendCode();
        String _fileString_1 = uri.toFileString();
        String _absolutePath_2 = projectRoot.getAbsolutePath();
        final String javaFileProjRelPath = _fileString_1.replace(_absolutePath_2, "");
        String fileName = (javaFileProjRelPath + ".xtend");
        String content = xtendCode;
        try {
          this.file(xtendCode, true);
        } catch (final Throwable _t) {
          if (_t instanceof AssertionError) {
            final AssertionError error = (AssertionError)_t;
            StringConcatenation _builder = new StringConcatenation();
            _builder.append(uri, "");
            _builder.append(" - ");
            String _message = error.getMessage();
            _builder.append(_message, "");
            System.err.println(_builder);
            this.writeToFile(testProject, javaFileProjRelPath, javaCode);
            String _fileName = fileName;
            fileName = (_fileName + ".error");
            errors++;
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
        this.writeToFile(testProject, fileName, content);
      }
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Problems (");
    _builder.append(problems, "");
    _builder.append(")");
    InputOutput.<String>println(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Errors (");
    _builder_1.append(errors, "");
    _builder_1.append(")");
    InputOutput.<String>println(_builder_1.toString());
    InputOutput.<String>println("Done...");
    Assert.assertEquals(13, errors);
    Assert.assertEquals(27, problems);
  }
  
  public void writeToFile(final File parent, final String fileName, final String content) {
    try {
      final File targetFile = new File(parent, fileName);
      String _absolutePath = targetFile.getAbsolutePath();
      String _plus = ("Writing to: " + _absolutePath);
      InputOutput.<String>println(_plus);
      boolean _exists = targetFile.exists();
      boolean _not = (!_exists);
      if (_not) {
        Files.createParentDirs(targetFile);
        targetFile.createNewFile();
      }
      Charset _defaultCharset = Charset.defaultCharset();
      Files.write(content, targetFile, _defaultCharset);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
