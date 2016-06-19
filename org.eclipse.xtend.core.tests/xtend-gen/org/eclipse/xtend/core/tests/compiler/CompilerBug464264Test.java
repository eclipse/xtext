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
public class CompilerBug464264Test extends AbstractXtendCompilerTest {
  @Test
  public void test_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m(I i, List<CharSequence> list) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("i.strings += list.map[it as String]");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("list.map[it]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("interface I {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("def List<String> getStrings()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import com.google.common.collect.Iterables;");
    _builder_1.newLine();
    _builder_1.append("import java.util.List;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Functions.Function1;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.ListExtensions;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public interface I {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("public abstract List<String> getStrings();");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public List<CharSequence> m(final C.I i, final List<CharSequence> list) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("List<CharSequence> _xblockexpression = null;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("List<String> _strings = i.getStrings();");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("final Function1<CharSequence, String> _function = new Function1<CharSequence, String>() {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("public String apply(final CharSequence it) {");
    _builder_1.newLine();
    _builder_1.append("          ");
    _builder_1.append("return ((String) it);");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("List<String> _map = ListExtensions.<CharSequence, String>map(list, _function);");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("Iterables.<String>addAll(_strings, _map);");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("final Function1<CharSequence, CharSequence> _function_1 = new Function1<CharSequence, CharSequence>() {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("public CharSequence apply(final CharSequence it) {");
    _builder_1.newLine();
    _builder_1.append("          ");
    _builder_1.append("return it;");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_xblockexpression = ListExtensions.<CharSequence, CharSequence>map(list, _function_1);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return _xblockexpression;");
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
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m(List<? super CharSequence> res, Iterable<? extends Object> obj) { ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("res += obj.map[\"\"]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import com.google.common.collect.Iterables;");
    _builder_1.newLine();
    _builder_1.append("import java.util.List;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Functions.Function1;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.IterableExtensions;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public boolean m(final List<? super CharSequence> res, final Iterable<?> obj) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final Function1<Object, String> _function = new Function1<Object, String>() {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("public String apply(final Object it) {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("return \"\";");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Iterable<? extends CharSequence> _map = IterableExtensions.map(obj, _function);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return Iterables.addAll(res, _map);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
}
