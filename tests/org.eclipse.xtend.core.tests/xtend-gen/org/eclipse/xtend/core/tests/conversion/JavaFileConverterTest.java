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
import org.eclipse.xtext.mwe.PathTraverser;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.junit.Test;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class JavaFileConverterTest extends AbstractXtendTestCase {
  @Inject
  private Provider<JavaConverter> javaConverter;
  
  @Test
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
    for (final URI uri : allResourceUris) {
      {
        String _fileString = uri.toFileString();
        final File file = new File(_fileString);
        String _absolutePath_1 = file.getAbsolutePath();
        String _plus_1 = ("Converting: " + _absolutePath_1);
        InputOutput.<String>println(_plus_1);
        Charset _defaultCharset = Charset.defaultCharset();
        final String java = Files.toString(file, _defaultCharset);
        final JavaConverter j2x = this.javaConverter.get();
        String _name = file.getName();
        JavaConverter.ConversionResult _xtend = j2x.toXtend(_name, java);
        final String xtendCode = _xtend.getXtendCode();
        String _fileString_1 = uri.toFileString();
        String _absolutePath_2 = projectRoot.getAbsolutePath();
        final String projectRelative = _fileString_1.replace(_absolutePath_2, "");
        final File targetFile = new File(testProject, (projectRelative + ".xtend"));
        String _absolutePath_3 = targetFile.getAbsolutePath();
        String _plus_2 = ("Writing to: " + _absolutePath_3);
        InputOutput.<String>println(_plus_2);
        boolean _exists = targetFile.exists();
        boolean _not = (!_exists);
        if (_not) {
          Files.createParentDirs(targetFile);
          targetFile.createNewFile();
        }
        Charset _defaultCharset_1 = Charset.defaultCharset();
        Files.write(xtendCode, targetFile, _defaultCharset_1);
        try {
          this.file(xtendCode, true);
        } catch (final Throwable _t) {
          if (_t instanceof AssertionError) {
            final AssertionError error = (AssertionError)_t;
            String _message = error.getMessage();
            System.err.print(_message);
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
    }
    InputOutput.<String>println("Done...");
  }
}
