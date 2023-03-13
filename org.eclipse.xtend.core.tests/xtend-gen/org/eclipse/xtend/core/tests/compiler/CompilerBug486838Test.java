/**
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.compiler;

import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Test;

/**
 * @author Christian Schneider
 * @see <a href=https://bugs.eclipse.org/bugs/show_bug.cgi?id=486838>https://bugs.eclipse.org/bugs/show_bug.cgi?id=486838</a>
 */
@SuppressWarnings("all")
public class CompilerBug486838Test extends AbstractXtendCompilerTest {
  @Test
  public void testBug486838() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package bug486838");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* field");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("UnknownType field");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package bug486838;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("* field");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private /* UnknownType */Object field;");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }

  @Test
  public void testBug486838_comment() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package bug486838");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* field");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("UnknownType/* comment */ field");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package bug486838;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("* field");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private /* UnknownType */Object field;");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }

  @Test
  public void testBug486838_inner() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package bug486838");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* field");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Unknown.InnerType field");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package bug486838;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("* field");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private /* Unknown.InnerType */Object field;");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }

  @Test
  public void testBug486838_inner_comment() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package bug486838");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* field");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Unknown./* comment */InnerType field");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package bug486838;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("* field");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private /* Unknown. InnerType */Object field;");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }

  @Test
  public void testBug486838_inner_comment_WS() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package bug486838");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* field");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Unkown. /* comment*/ InnerType field");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package bug486838;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("* field");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private /* Unkown. InnerType */Object field;");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }

  @Test
  public void testBug486838_parameterized() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package bug486838");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* field");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Unknown<Argument> field");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package bug486838;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("* field");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private /* Unknown<Argument> */Object field;");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }

  @Test
  public void testBug486838_parameterized_comment() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package bug486838");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* field");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Unknown< /* comment */ Argument> field");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package bug486838;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("* field");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private /* Unknown<Argument> */Object field;");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }

  @Test
  public void testBug486838_parameterized_argumentUnkown() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package bug486838");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* field");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Functions.Function0<Argument> field");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package bug486838;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Functions.Function0;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("* field");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private /* Function0<Argument> */Object field;");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }

  @Test
  public void testBug486838_parameterized_argumentUnkown_comment() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package bug486838");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* field");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Functions.Function0/* comment */<Argument> field");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package bug486838;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Functions.Function0;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("* field");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private /* Function0<Argument> */Object field;");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }

  @Test
  public void testBug486838_parameterized_argumentUnkown_comment2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package bug486838");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* field");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Functions.Function0</* comment */ Argument> field");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package bug486838;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Functions.Function0;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("/**");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("* field");
    _builder_1.newLine();
    _builder_1.append("   ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private /* Function0<Argument> */Object field;");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }

  @Override
  public XtendFile file(final String string, final boolean validate) throws Exception {
    return this.file(string, false, true);
  }
}
