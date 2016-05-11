/**
 * Copyright (c) 2016 TypeFox.io (http://www.typefox.io) and others.
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
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class CompilerBug491931Test extends AbstractXtendCompilerTest {
  @Test
  public void test_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void foo(boolean a, boolean b) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val boolean x1 = !a && !b");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val boolean x2 = a && !b");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val boolean x3 = !a && b");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val boolean x4 = a && b");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("println(x1 || x2 || x3 || x4)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.InputOutput;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void foo(final boolean a, final boolean b) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final boolean x1 = ((!a) && (!b));");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final boolean x2 = (a && (!b));");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final boolean x3 = ((!a) && b);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final boolean x4 = (a && b);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("InputOutput.<Boolean>println(Boolean.valueOf((((x1 || x2) || x3) || x4)));");
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
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def boolean foo(boolean a, boolean b) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return a && b");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public boolean foo(final boolean a, final boolean b) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return (a && b);");
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
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def boolean foo(boolean a, boolean b) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return !a && !b");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public boolean foo(final boolean a, final boolean b) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return ((!a) && (!b));");
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
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def boolean m(Object obj) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return obj?.toString() instanceof String && obj!==null && obj.getClass()!==null; ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public boolean m(final Object obj) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("boolean _and = false;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("boolean _and_1 = false;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("String _string = null;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (obj!=null) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_string=obj.toString();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (!(_string instanceof String)) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_and_1 = false;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("} else {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_and_1 = (obj != null);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (!_and_1) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_and = false;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("} else {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("Class<?> _class = obj.getClass();");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("boolean _tripleNotEquals = (_class != null);");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_and = _tripleNotEquals;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return _and;");
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
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def boolean foo(CharSequence obj) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return !((obj.subSequence(1, 1) instanceof String) && obj != null)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import com.google.common.base.Objects;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public boolean foo(final CharSequence obj) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return (!((obj.subSequence(1, 1) instanceof String) && (!Objects.equal(obj, null))));");
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
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void foo(java.util.List<String> l) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("l.add(\"x\") && l.add(\"y\")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.List;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void foo(final List<String> l) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("boolean _and = false;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("boolean _add = l.add(\"x\");");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (!_add) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_and = false;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("} else {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("boolean _add_1 = l.add(\"y\");");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_and = _add_1;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
}
