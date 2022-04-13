/**
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.macro;

import org.eclipse.xtend.core.compiler.batch.XtendCompilerTester;
import org.eclipse.xtend.lib.macro.services.Problem;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
@SuppressWarnings("all")
public class AnnotationWithNestedEnumProcessorTest extends AbstractActiveAnnotationTest {
  @Test
  public void testBug487559_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.eclipse.xtend.core.tests.macro.AnnotationWithNestedEnum");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@org.eclipse.xtend.core.tests.macro.AnnotationWithNestedEnum");
    _builder.newLine();
    _builder.append("class Client {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final IAcceptor<XtendCompilerTester.CompilationResult> _function = (XtendCompilerTester.CompilationResult it) -> {
      final Function1<Problem, String> _function_1 = (Problem it_1) -> {
        return it_1.getMessage();
      };
      Assert.assertTrue(IterableExtensions.join(ListExtensions.map(it.getAllProblems(), _function_1), ", "), it.getAllProblems().isEmpty());
    };
    this._xtendCompilerTester.compile(_builder, _function);
  }

  @Test
  public void testBug487559_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.eclipse.xtend.core.tests.macro.AnnotationWithNestedEnum");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@org.eclipse.xtend.core.tests.macro.AnnotationWithNestedEnum");
    _builder.newLine();
    _builder.append("class Client {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("@org.eclipse.xtend.core.tests.macro.AnnotationWithNestedEnum(VALUE2)");
    _builder.newLine();
    _builder.append("class Client2 {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("MULTIPLE FILES WERE GENERATED");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("File 1 : /myProject/xtend-gen/Client.java");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtend.core.tests.macro.AnnotationWithNestedEnum;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@AnnotationWithNestedEnum");
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Client {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("File 2 : /myProject/xtend-gen/Client2.java");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtend.core.tests.macro.AnnotationWithNestedEnum;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@AnnotationWithNestedEnum(AnnotationWithNestedEnum.NestedEnum.VALUE2)");
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Client2 {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("File 3 : /myProject/xtend-gen/Client2Interface.java");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtend.core.tests.macro.AnnotationWithNestedEnum;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@AnnotationWithNestedEnum(value = AnnotationWithNestedEnum.NestedEnum.VALUE2)");
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public interface Client2Interface {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("File 4 : /myProject/xtend-gen/ClientInterface.java");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtend.core.tests.macro.AnnotationWithNestedEnum;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@AnnotationWithNestedEnum(value = AnnotationWithNestedEnum.NestedEnum.VALUE)");
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public interface ClientInterface {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    this._xtendCompilerTester.assertCompilesTo(_builder, _builder_1);
  }
}
