/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.java8.compiler;

import org.eclipse.xtend.core.tests.compiler.AbstractXtendCompilerTest;
import org.eclipse.xtend.core.tests.java8.Java8RuntimeInjectorProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Miro Spoenemann - Copied and adapted to Java 8 output
 */
@InjectWith(Java8RuntimeInjectorProvider.class)
@SuppressWarnings("all")
public class CompilerBug440906Test extends AbstractXtendCompilerTest {
  @Test
  public void test_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("[ Object a, Object b | 1 ]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m2() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("#[].sortWith(m)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.Collections;");
    _builder_1.newLine();
    _builder_1.append("import java.util.Comparator;");
    _builder_1.newLine();
    _builder_1.append("import java.util.List;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.CollectionLiterals;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Functions.Function2;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.IterableExtensions;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Function2<Object, Object, Integer> m() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final Function2<Object, Object, Integer> _function = (Object a, Object b) -> {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return Integer.valueOf(1);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return _function;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public List<Object> m2() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Function2<Object, Object, Integer> _m = this.m();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final Function2<Object, Object, Integer> _final_m = _m;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return IterableExtensions.<Object>sortWith(Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList()), new Comparator<Object>() {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("public int compare(Object arg0, Object arg1) {");
    _builder_1.newLine();
    _builder_1.append("          ");
    _builder_1.append("return _final_m.apply(arg0, arg1);");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("});");
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
    _builder.append("def m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("[ Object a, Object b | 1 ]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m2() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("#[].sortWith({toString m})");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.Collections;");
    _builder_1.newLine();
    _builder_1.append("import java.util.Comparator;");
    _builder_1.newLine();
    _builder_1.append("import java.util.List;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.CollectionLiterals;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Functions.Function2;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.IterableExtensions;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Function2<Object, Object, Integer> m() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final Function2<Object, Object, Integer> _function = (Object a, Object b) -> {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return Integer.valueOf(1);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return _function;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public List<Object> m2() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Function2<Object, Object, Integer> _xblockexpression = null;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("this.toString();");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_xblockexpression = this.m();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final Function2<Object, Object, Integer> _final_xblockexpression = _xblockexpression;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return IterableExtensions.<Object>sortWith(Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList()), new Comparator<Object>() {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("public int compare(Object arg0, Object arg1) {");
    _builder_1.newLine();
    _builder_1.append("          ");
    _builder_1.append("return _final_xblockexpression.apply(arg0, arg1);");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("});");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
}
