/**
 * Copyright (c) 2020 Harald Fassler and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.compiler;

import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Test;

/**
 * @author Harald Fassler - Initial contribution and API
 */
@SuppressWarnings("all")
public class ImportManagerTest extends AbstractXtendCompilerTest {
  @Test
  public void testNoUnusedImport() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package douglas.adams.hitchhikers.guide");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class DeepThought {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def theAnswer() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return 42");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package douglas.adams.hitchhikers.guide");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("class AfterSevenPointFiveMillionYears {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def void tellIt() {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("System.out.println(new DeepThought().theAnswer());");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final Iterable<XtendFile> xtendFiles = this.files(false, _builder.toString(), _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package douglas.adams.hitchhikers.guide;");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("@SuppressWarnings(\"all\")");
      _builder_2.newLine();
      _builder_2.append("public class DeepThought {");
      _builder_2.newLine();
      _builder_2.append("  ");
      _builder_2.append("public int theAnswer() {");
      _builder_2.newLine();
      _builder_2.append("    ");
      _builder_2.append("return 42;");
      _builder_2.newLine();
      _builder_2.append("  ");
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("package douglas.adams.hitchhikers.guide;");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("@SuppressWarnings(\"all\")");
      _builder_3.newLine();
      _builder_3.append("public class AfterSevenPointFiveMillionYears {");
      _builder_3.newLine();
      _builder_3.append("  ");
      _builder_3.append("public void tellIt() {");
      _builder_3.newLine();
      _builder_3.append("    ");
      _builder_3.append("System.out.println(new DeepThought().theAnswer());");
      _builder_3.newLine();
      _builder_3.append("  ");
      _builder_3.append("}");
      _builder_3.newLine();
      _builder_3.append("}");
      _builder_3.newLine();
      this.assertFilesCompileTo(xtendFiles, _builder_2, _builder_3);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testRegularImport() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package org.eclipse.xtend.example");
    _builder.newLine();
    _builder.append("class SillySingletonSet {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val bars = java.util.Collections.singleton(\"bar\")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package org.eclipse.xtend.example;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import java.util.Collections;");
    _builder_1.newLine();
    _builder_1.append("import java.util.Set;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class SillySingletonSet {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void foo() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final Set<String> bars = Collections.<String>singleton(\"bar\");");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
}
