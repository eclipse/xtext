/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.macro;

import org.eclipse.xtend.core.tests.macro.AbstractActiveAnnotationTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Test;

/**
 * @author Miro Spoenemann - Initial contribution and API
 */
@SuppressWarnings("all")
public class Bug446364Test extends AbstractActiveAnnotationTest {
  @Test
  public void testRenameMethods() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@org.eclipse.xtend.core.tests.macro.Bug446364(\'rename\')");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def String test() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("\"code\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def create new StringBuilder createMethod(String p) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("append(p)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.ArrayList;");
    _builder_1.newLine();
    _builder_1.append("import java.util.HashMap;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtend.core.tests.macro.Bug446364;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.CollectionLiterals;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@Bug446364(\"rename\")");
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public String prefix_test() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return \"code\";");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public StringBuilder prefix_createMethod(final String p) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(p);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final StringBuilder _result;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("synchronized (_createCache_createMethod) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("if (_createCache_createMethod.containsKey(_cacheKey)) {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("return _createCache_createMethod.get(_cacheKey);");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("StringBuilder _stringBuilder = new StringBuilder();");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_result = _stringBuilder;");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_createCache_createMethod.put(_cacheKey, _result);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("prefix__init_createMethod(_result, p);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return _result;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private final HashMap<ArrayList<?>, StringBuilder> _createCache_createMethod = CollectionLiterals.newHashMap();");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private void prefix__init_createMethod(final StringBuilder it, final String p) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("it.append(p);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this._xtendCompilerTester.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testChangeBody() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@org.eclipse.xtend.core.tests.macro.Bug446364(\'changeBody\')");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def String test() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("\"code\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def create new StringBuilder createMethod(String p) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("append(p)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.ArrayList;");
    _builder_1.newLine();
    _builder_1.append("import java.util.HashMap;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtend.core.tests.macro.Bug446364;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.CollectionLiterals;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@Bug446364(\"changeBody\")");
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public String test() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return null;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public StringBuilder createMethod(final String p) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return null;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private final HashMap<ArrayList<?>, StringBuilder> _createCache_createMethod = CollectionLiterals.newHashMap();");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private void _init_createMethod(final Object/* type is \'null\' */ it, final String p) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return null;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this._xtendCompilerTester.assertCompilesTo(_builder, _builder_1);
  }
}
