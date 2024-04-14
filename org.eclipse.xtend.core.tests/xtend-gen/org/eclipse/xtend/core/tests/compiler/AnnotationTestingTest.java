/**
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.compiler;

import com.google.common.io.Files;
import com.google.inject.Inject;
import java.io.File;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Objects;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.testing.CompilationTestHelper;
import org.eclipse.xtext.xbase.testing.TemporaryFolder;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author svenefftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class AnnotationTestingTest extends AbstractXtendCompilerTest {
  @Rule
  @Inject
  public TemporaryFolder temporaryFolder;

  @Test
  public void testPath() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("foo,bar,baz");
      _builder.newLine();
      final URI sourceFileUri = this.compilationTestHelper.copyToWorkspace((CompilationTestHelper.PROJECT_NAME + "/res/template.txt"), _builder);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("@org.eclipse.xtend.core.tests.compiler.MyAnnotation class Foo {}");
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        try {
          final Class<?> compiledClass = it.getCompiledClass();
          Assert.assertEquals(3, ((List<Field>)Conversions.doWrapArray(compiledClass.getDeclaredFields())).size());
          final Function1<Field, Boolean> _function_1 = (Field it_1) -> {
            String _name = it_1.getName();
            return Boolean.valueOf(Objects.equals(_name, "foo"));
          };
          Assert.assertTrue(IterableExtensions.<Field>exists(((Iterable<Field>)Conversions.doWrapArray(compiledClass.getDeclaredFields())), _function_1));
          final Function1<Field, Boolean> _function_2 = (Field it_1) -> {
            String _name = it_1.getName();
            return Boolean.valueOf(Objects.equals(_name, "bar"));
          };
          Assert.assertTrue(IterableExtensions.<Field>exists(((Iterable<Field>)Conversions.doWrapArray(compiledClass.getDeclaredFields())), _function_2));
          final Function1<Field, Boolean> _function_3 = (Field it_1) -> {
            String _name = it_1.getName();
            return Boolean.valueOf(Objects.equals(_name, "baz"));
          };
          Assert.assertTrue(IterableExtensions.<Field>exists(((Iterable<Field>)Conversions.doWrapArray(compiledClass.getDeclaredFields())), _function_3));
          final URI targetFileUri = sourceFileUri.trimSegments(2).appendSegment("xtend-gen").appendSegment("out.txt");
          String _fileString = targetFileUri.toFileString();
          final File targetFile = new File(_fileString);
          final String result = Files.asCharSource(targetFile, Charset.defaultCharset()).read();
          Assert.assertEquals("foo|bar|baz", result.trim());
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      this.compilationTestHelper.compile(_builder_1, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
