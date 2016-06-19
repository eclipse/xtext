/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.java8.compiler;

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
public class CompilerBug412894Test extends org.eclipse.xtend.core.tests.compiler.CompilerBug412894Test {
  @Test
  @Override
  public void test_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m()\t{");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val list = newArrayList");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("list.forEach [");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("switch it {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("String: list.add(it)");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.ArrayList;");
    _builder_1.newLine();
    _builder_1.append("import java.util.function.Consumer;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.CollectionLiterals;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void m() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final ArrayList<String> list = CollectionLiterals.<String>newArrayList();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final Consumer<String> _function = (String it) -> {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("boolean _matched = false;");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("if (it instanceof String) {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("_matched=true;");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("list.add(it);");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("list.forEach(_function);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  @Override
  public void test_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m()\t{");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val list = newArrayList");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("list.forEach [");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("switch it {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("String: list.add(it)");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("Number: list.add(it)");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.io.Serializable;");
    _builder_1.newLine();
    _builder_1.append("import java.util.ArrayList;");
    _builder_1.newLine();
    _builder_1.append("import java.util.function.Consumer;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.CollectionLiterals;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void m() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final ArrayList<Serializable> list = CollectionLiterals.<Serializable>newArrayList();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final Consumer<Serializable> _function = (Serializable it) -> {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("boolean _matched = false;");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("if (it instanceof String) {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("_matched=true;");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("list.add(it);");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("if (!_matched) {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("if (it instanceof Number) {");
    _builder_1.newLine();
    _builder_1.append("          ");
    _builder_1.append("_matched=true;");
    _builder_1.newLine();
    _builder_1.append("          ");
    _builder_1.append("list.add(it);");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("list.forEach(_function);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  @Override
  public void test_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m()\t{");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val list = newArrayList");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("list.forEach [");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("switch it {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("Number: list.add(it.toString)");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.io.Serializable;");
    _builder_1.newLine();
    _builder_1.append("import java.util.ArrayList;");
    _builder_1.newLine();
    _builder_1.append("import java.util.function.Consumer;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.CollectionLiterals;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void m() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final ArrayList<Serializable> list = CollectionLiterals.<Serializable>newArrayList();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final Consumer<Serializable> _function = (Serializable it) -> {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("boolean _matched = false;");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("if (it instanceof Number) {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("_matched=true;");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("String _string = ((Number)it).toString();");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("list.add(_string);");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("list.forEach(_function);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  @Override
  public void test_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m()\t{");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val list = newArrayList");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("list.forEach [");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (it instanceof String) list.add(it)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.ArrayList;");
    _builder_1.newLine();
    _builder_1.append("import java.util.function.Consumer;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.CollectionLiterals;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void m() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final ArrayList<Object> list = CollectionLiterals.<Object>newArrayList();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final Consumer<Object> _function = (Object it) -> {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("if ((it instanceof String)) {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("list.add(it);");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("list.forEach(_function);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
}
