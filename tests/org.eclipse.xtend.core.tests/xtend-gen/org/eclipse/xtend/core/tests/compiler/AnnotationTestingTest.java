/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.compiler;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.lang.reflect.Field;
import java.util.List;
import org.eclipse.xtend.core.tests.compiler.AbstractXtendCompilerTest;
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.internal.TemporaryFolder;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
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
  
  @Inject
  @Extension
  protected MutableFileSystemSupport fileSystemSupport;
  
  @Test
  public void testPath() {
    try {
      Path _path = new Path((("/" + CompilationTestHelper.PROJECT_NAME) + "/res/template.txt"));
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("foo,bar,baz");
      _builder.newLine();
      this.fileSystemSupport.setContents(_path, _builder);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("@org.eclipse.xtend.core.tests.compiler.MyAnnotation class Foo {}");
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          final Class<?> compiledClass = it.getCompiledClass();
          Field[] _declaredFields = compiledClass.getDeclaredFields();
          int _size = ((List<Field>)Conversions.doWrapArray(_declaredFields)).size();
          Assert.assertEquals(3, _size);
          Field[] _declaredFields_1 = compiledClass.getDeclaredFields();
          final Function1<Field, Boolean> _function = new Function1<Field, Boolean>() {
            public Boolean apply(final Field it) {
              String _name = it.getName();
              return Boolean.valueOf(Objects.equal(_name, "foo"));
            }
          };
          boolean _exists = IterableExtensions.<Field>exists(((Iterable<Field>)Conversions.doWrapArray(_declaredFields_1)), _function);
          Assert.assertTrue(_exists);
          Field[] _declaredFields_2 = compiledClass.getDeclaredFields();
          final Function1<Field, Boolean> _function_1 = new Function1<Field, Boolean>() {
            public Boolean apply(final Field it) {
              String _name = it.getName();
              return Boolean.valueOf(Objects.equal(_name, "bar"));
            }
          };
          boolean _exists_1 = IterableExtensions.<Field>exists(((Iterable<Field>)Conversions.doWrapArray(_declaredFields_2)), _function_1);
          Assert.assertTrue(_exists_1);
          Field[] _declaredFields_3 = compiledClass.getDeclaredFields();
          final Function1<Field, Boolean> _function_2 = new Function1<Field, Boolean>() {
            public Boolean apply(final Field it) {
              String _name = it.getName();
              return Boolean.valueOf(Objects.equal(_name, "baz"));
            }
          };
          boolean _exists_2 = IterableExtensions.<Field>exists(((Iterable<Field>)Conversions.doWrapArray(_declaredFields_3)), _function_2);
          Assert.assertTrue(_exists_2);
          Path _path = new Path((("/" + CompilationTestHelper.PROJECT_NAME) + "/src-gen/out.txt"));
          CharSequence _contents = AnnotationTestingTest.this.fileSystemSupport.getContents(_path);
          String _string = _contents.toString();
          String _trim = _string.trim();
          Assert.assertEquals("foo|bar|baz", _trim);
        }
      };
      this.compilationTestHelper.compile(_builder_1, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
