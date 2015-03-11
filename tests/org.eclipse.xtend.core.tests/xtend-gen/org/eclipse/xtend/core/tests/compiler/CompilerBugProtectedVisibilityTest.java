/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.compiler;

import org.eclipse.xtend.core.tests.compiler.AbstractXtendCompilerTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class CompilerBugProtectedVisibilityTest extends AbstractXtendCompilerTest {
  @Test
  public void test_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo extends test.Visibilities {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("protectedMethod");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import test.Visibilities;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo extends Visibilities {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void foo() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("this.protectedMethod();");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void test_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo extends test.Visibilities {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.protectedMethod");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super.protectedMethod");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import test.Visibilities;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo extends Visibilities {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void foo() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("this.protectedMethod();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("super.protectedMethod();");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void test_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package test ");
    _builder.newLine();
    _builder.append("class C extends test.Visibilities {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m(test.Visibilities s) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("s.protectedMethod");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package test;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import test.Visibilities;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C extends Visibilities {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void m(final Visibilities s) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("s.protectedMethod();");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void test_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package test ");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m(test.Visibilities s) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("s.protectedMethod");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package test;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import test.Visibilities;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void m(final Visibilities s) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("s.protectedMethod();");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void test_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package test");
    _builder.newLine();
    _builder.append("class C extends test.Visibilities {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m(test.VisibilitiesSubclass vc) { vc.protectedMethod }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package test;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import test.Visibilities;");
    _builder_1.newLine();
    _builder_1.append("import test.VisibilitiesSubclass;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C extends Visibilities {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void m(final VisibilitiesSubclass vc) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("vc.protectedMethod();");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void test_06() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package test");
    _builder.newLine();
    _builder.append("class C extends test.Visibilities {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m(test.VisibilitiesSubclass vc) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("(vc as test.Visibilities).protectedMethod");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package test;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import test.Visibilities;");
    _builder_1.newLine();
    _builder_1.append("import test.VisibilitiesSubclass;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C extends Visibilities {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void m(final VisibilitiesSubclass vc) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("((Visibilities) vc).protectedMethod();");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void test_07() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package x");
    _builder.newLine();
    _builder.append("class C extends test.Visibilities {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m(D d) { d.protectedMethod }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class D extends C {}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package x;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import test.Visibilities;");
    _builder_1.newLine();
    _builder_1.append("import x.D;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C extends Visibilities {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void m(final D d) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("d.protectedMethod();");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
}
