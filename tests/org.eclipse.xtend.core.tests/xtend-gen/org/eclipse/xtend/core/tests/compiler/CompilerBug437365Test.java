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
 * @author Sven Efftinge - Initial contribution and API
 * 
 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=437365
 */
@SuppressWarnings("all")
public class CompilerBug437365Test extends AbstractXtendCompilerTest {
  @Test
  public void test_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Test {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def static void main(String[] args) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("val java.util.List<String>[] arrayOfList = newArrayOfSize(4);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("arrayOfList.set(0, new java.util.LinkedList())");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("arrayOfList.get(0).add(new String())");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("val String a = arrayOfList.get(0).get(0)");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("println(a)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.LinkedList;");
    _builder_1.newLine();
    _builder_1.append("import java.util.List;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.InputOutput;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Test {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public static void main(final String[] args) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final List<String>[] arrayOfList = new List[4];");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("LinkedList<String> _linkedList = new LinkedList<String>();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("arrayOfList[0] = _linkedList;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("List<String> _get = arrayOfList[0];");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("String _string = new String();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("_get.add(_string);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("List<String> _get_1 = arrayOfList[0];");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final String a = _get_1.get(0);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("InputOutput.<String>println(a);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
}
