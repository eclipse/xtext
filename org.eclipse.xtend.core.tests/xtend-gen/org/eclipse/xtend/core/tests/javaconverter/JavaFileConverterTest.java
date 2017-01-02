/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.javaconverter;

import com.google.common.base.Predicate;
import com.google.common.io.Files;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.core.javaconverter.JavaConverter;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.mwe.PathTraverser;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class JavaFileConverterTest extends AbstractXtendTestCase {
  @Inject
  private Provider<JavaConverter> javaConverter;
  
  private String sourceProject;
  
  private String targetProject;
  
  private int errorsExpected = 0;
  
  private int problemsExpected = 0;
  
  @Before
  public void setUp() {
    this.sourceProject = null;
    this.targetProject = null;
    this.errorsExpected = 0;
    this.problemsExpected = 0;
  }
  
  @Test
  @Ignore
  public void testConvertFilesInThisProject() throws Exception {
    this.sourceProject = "org.eclipse.xtend.core.tests";
    this.targetProject = "test-converter";
    this.errorsExpected = 0;
    this.problemsExpected = 22;
    this.runConverter();
  }
  
  @Test
  @Ignore
  public void testConvertFilesInXtextTestsProject() throws Exception {
    this.sourceProject = "org.eclipse.xtext.tests";
    this.targetProject = "org.eclipse.xtext.tests.converted";
    this.errorsExpected = 87;
    this.problemsExpected = 13404;
    this.runConverter();
  }
  
  public void runConverter() {
    try {
      File _parentFile = new File("").getAbsoluteFile().getParentFile();
      final File srcProjectRoot = new File(_parentFile, this.sourceProject);
      File _parentFile_1 = srcProjectRoot.getParentFile();
      final File testProject = new File(_parentFile_1, this.targetProject);
      String _path = srcProjectRoot.getPath();
      String _plus = ("Working in " + _path);
      InputOutput.<String>println(_plus);
      final PathTraverser pathTraverser = new PathTraverser();
      String _absolutePath = srcProjectRoot.getAbsolutePath();
      final Set<URI> allResourceUris = pathTraverser.findAllResourceUris(_absolutePath, 
        new Predicate<URI>() {
          @Override
          public boolean apply(final URI input) {
            final String fileName = input.toFileString();
            return (("java".equals(input.fileExtension()) && (!fileName.contains("xtend-gen"))) && 
              (!fileName.contains("batch-compiler-data")));
          }
        });
      int errors = 0;
      int problems = 0;
      int files = 0;
      int filesWithErrorsOrProblems = 0;
      for (final URI uri : allResourceUris) {
        {
          String _fileString = uri.toFileString();
          final File file = new File(_fileString);
          final String javaFileProjRelPath = uri.toFileString().replace(srcProjectRoot.getAbsolutePath(), "");
          InputOutput.<String>println(("Converting: " + javaFileProjRelPath));
          boolean compileError = false;
          final String javaCode = Files.toString(file, Charset.defaultCharset());
          final JavaConverter.ConversionResult xtendResult = this.converToXtend(file.getName(), javaCode);
          final int knownProblemsFound = IterableExtensions.size(xtendResult.getProblems());
          String xtendCode = xtendResult.getXtendCode();
          String fileName = (javaFileProjRelPath + ".xtend");
          try {
            this.file(xtendCode, true);
          } catch (final Throwable _t) {
            if (_t instanceof AssertionError) {
              final AssertionError error = (AssertionError)_t;
              compileError = true;
              StringConcatenation _builder = new StringConcatenation();
              _builder.append(javaFileProjRelPath);
              _builder.append(" - ");
              String _message = error.getMessage();
              _builder.append(_message);
              System.err.println(_builder);
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
          if (((knownProblemsFound != 0) || compileError)) {
            filesWithErrorsOrProblems++;
            if ((knownProblemsFound != 0)) {
              this.writeToFile(testProject, javaFileProjRelPath, javaCode);
              String _fileName = fileName;
              fileName = (_fileName + ".error");
            } else {
              errors++;
            }
          }
          int _problems = problems;
          problems = (_problems + knownProblemsFound);
          files++;
          this.writeToFile(testProject, fileName, xtendCode);
        }
      }
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Not covered Errors (");
      _builder.append(errors);
      _builder.append(")");
      InputOutput.<String>println(_builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Known Problems (");
      _builder_1.append(problems);
      _builder_1.append(")");
      InputOutput.<String>println(_builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("Files read (");
      _builder_2.append(files);
      _builder_2.append(")");
      InputOutput.<String>println(_builder_2.toString());
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("Files with errors/problems (");
      _builder_3.append(filesWithErrorsOrProblems);
      _builder_3.append(")");
      InputOutput.<String>println(_builder_3.toString());
      InputOutput.<String>println("Done...");
      Assert.assertEquals(this.problemsExpected, problems);
      Assert.assertEquals(this.errorsExpected, errors);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public JavaConverter.ConversionResult converToXtend(final String unitName, final String javaCode) {
    try {
      final JavaConverter j2x = this.javaConverter.get();
      JavaConverter.ConversionResult result = j2x.toXtend(unitName, javaCode);
      int _size = IterableExtensions.size(result.getProblems());
      boolean _equals = (_size == 0);
      if (_equals) {
        try {
          this.file(result.getXtendCode(), true);
        } catch (final Throwable _t) {
          if (_t instanceof AssertionError) {
            final AssertionError error = (AssertionError)_t;
            result = j2x.useRobustSyntax().toXtend(unitName, javaCode);
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
      return result;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void writeToFile(final File parent, final String fileName, final String content) {
    try {
      final File targetFile = new File(parent, fileName);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Writing to: ");
      _builder.append(fileName);
      InputOutput.<String>println(_builder.toString());
      boolean _exists = targetFile.exists();
      boolean _not = (!_exists);
      if (_not) {
        Files.createParentDirs(targetFile);
        targetFile.createNewFile();
      }
      Files.write(content, targetFile, Charset.defaultCharset());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
