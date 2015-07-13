/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
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
public class CompilerBug472142Test extends AbstractXtendCompilerTest {
  @Test
  public void test_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def boolean m(CharSequence obj) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return obj?.subSequence(1,1) instanceof String && obj!==null && obj.getClass()!==null;");
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
    _builder_1.append("public boolean m(final CharSequence obj) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("boolean _and = false;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("boolean _and_1 = false;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("CharSequence _subSequence = null;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (obj!=null) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_subSequence=obj.subSequence(1, 1);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (!(_subSequence instanceof String)) {");
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
    _builder_1.append("Class<? extends CharSequence> _class = obj.getClass();");
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
  public void test_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def boolean m(CharSequence obj) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return obj?.subSequence(1,1) instanceof String && obj!==null");
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
    _builder_1.append("public boolean m(final CharSequence obj) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("boolean _and = false;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("CharSequence _subSequence = null;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (obj!=null) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_subSequence=obj.subSequence(1, 1);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (!(_subSequence instanceof String)) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_and = false;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("} else {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_and = (obj != null);");
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
}
