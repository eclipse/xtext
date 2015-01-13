/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
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
 * @author Miro Spoenemann - Initial contribution and API
 */
@InjectWith(Java8RuntimeInjectorProvider.class)
@SuppressWarnings("all")
public class Java8CompilerTest extends AbstractXtendCompilerTest {
  @Test
  public void testStaticMethodInInterface() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("interface Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static def bar() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("\"bar!\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public interface Foo {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public static String bar() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return \"bar!\";");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testJava8UnaryOperator() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("class Test {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def test(List<Integer> list) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("list.replaceAll[it + 1]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.List;");
    _builder_1.newLine();
    _builder_1.append("import java.util.function.UnaryOperator;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Test {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void test(final List<Integer> list) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final UnaryOperator<Integer> _function = (Integer it) -> {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return Integer.valueOf(((it).intValue() + 1));");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("list.replaceAll(_function);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testJava8Comparator() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("class Test {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def test(List<String> list) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("list.sort(java.util.Comparator.comparingInt[String s | s.length]");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append(".thenComparing[String s | s.length])");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.Comparator;");
    _builder_1.newLine();
    _builder_1.append("import java.util.List;");
    _builder_1.newLine();
    _builder_1.append("import java.util.function.Function;");
    _builder_1.newLine();
    _builder_1.append("import java.util.function.ToIntFunction;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Test {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void test(final List<String> list) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final ToIntFunction<String> _function = (String s) -> {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return s.length();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Comparator<String> _comparingInt = Comparator.<String>comparingInt(_function);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final Function<String, Integer> _function_1 = (String s_1) -> {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return Integer.valueOf(s_1.length());");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Comparator<String> _thenComparing = _comparingInt.<Integer>thenComparing(_function_1);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("list.sort(_thenComparing);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testJava8Predicate() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("class Test {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def test(List<Integer> list) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("list.removeIf[it < 2]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.List;");
    _builder_1.newLine();
    _builder_1.append("import java.util.function.Predicate;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Test {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public boolean test(final List<Integer> list) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final Predicate<Integer> _function = (Integer it) -> {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return ((it).intValue() < 2);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return list.removeIf(_function);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testJava8BinaryOperation() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("class Test {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def test(List<Boolean> list) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("list.stream.reduce[a, b | a && b]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.List;");
    _builder_1.newLine();
    _builder_1.append("import java.util.Optional;");
    _builder_1.newLine();
    _builder_1.append("import java.util.function.BinaryOperator;");
    _builder_1.newLine();
    _builder_1.append("import java.util.stream.Stream;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Test {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Optional<Boolean> test(final List<Boolean> list) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Stream<Boolean> _stream = list.stream();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final BinaryOperator<Boolean> _function = (Boolean a, Boolean b) -> {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("boolean _and = false;");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("if (!(a).booleanValue()) {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("_and = false;");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("} else {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("_and = (b).booleanValue();");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return Boolean.valueOf(_and);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return _stream.reduce(_function);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testJava8Consumer() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("class Test {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def test(List<String> list) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("list.stream.forEach[println(it)]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.List;");
    _builder_1.newLine();
    _builder_1.append("import java.util.function.Consumer;");
    _builder_1.newLine();
    _builder_1.append("import java.util.stream.Stream;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.InputOutput;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Test {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void test(final List<String> list) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Stream<String> _stream = list.stream();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final Consumer<String> _function = (String it) -> {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("InputOutput.<String>println(it);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("_stream.forEach(_function);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testJava8BiFunction() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Map");
    _builder.newLine();
    _builder.append("class Test {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def test(Map<String, Integer> map) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("map.replaceAll[k, v | v + k.length]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.Map;");
    _builder_1.newLine();
    _builder_1.append("import java.util.function.BiFunction;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Test {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void test(final Map<String, Integer> map) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final BiFunction<String, Integer, Integer> _function = (String k, Integer v) -> {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("int _length = k.length();");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return Integer.valueOf(((v).intValue() + _length));");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("map.replaceAll(_function);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
}
