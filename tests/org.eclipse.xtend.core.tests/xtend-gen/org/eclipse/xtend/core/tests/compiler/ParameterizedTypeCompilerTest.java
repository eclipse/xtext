/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
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
public class ParameterizedTypeCompilerTest extends AbstractXtendCompilerTest {
  @Test
  public void testSimpleArgument_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class MyRef extends java.lang.ref.WeakReference<String> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(String s) { super(s) }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.lang.ref.WeakReference;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class MyRef extends WeakReference<String> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public MyRef(final String s) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("super(s);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testSimpleArgument_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class MyRef<U> extends java.lang.ref.WeakReference<U> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new() { super(null) }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.lang.ref.WeakReference;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class MyRef<U extends Object> extends WeakReference<U> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public MyRef() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("super(null);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testSimpleArgument_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class MyRef<U> extends java.lang.ref.WeakReference<U> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(U u) { super(u) }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.lang.ref.WeakReference;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class MyRef<U extends Object> extends WeakReference<U> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public MyRef(final U u) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("super(u);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testSimpleArgument_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class MyRef<U> extends java.lang.ref.WeakReference<U> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(Iterable<U> u) { super(u.head) }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.lang.ref.WeakReference;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.IterableExtensions;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class MyRef<U extends Object> extends WeakReference<U> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public MyRef(final Iterable<U> u) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("super(IterableExtensions.<U>head(u));");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testSimpleArgument_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class MyRef<U> extends java.lang.ref.WeakReference<U> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(java.util.List<U> list) { super(list.get(0)) }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.lang.ref.WeakReference;");
    _builder_1.newLine();
    _builder_1.append("import java.util.List;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class MyRef<U extends Object> extends WeakReference<U> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public MyRef(final List<U> list) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("super(list.get(0));");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testSimpleArgument_06() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class MyRef<U extends CharSequence> extends java.lang.ref.WeakReference<String> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(U u) { this(u as Object) }");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(Object o) { super(o.toString()) }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.lang.ref.WeakReference;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class MyRef<U extends CharSequence> extends WeakReference<String> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public MyRef(final U u) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("this(((Object) u));");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public MyRef(final Object o) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("super(o.toString());");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testSimpleArgument_07() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class MyRef<U> extends java.lang.ref.WeakReference<Iterable<U>> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new() { super(newArrayList) }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.lang.ref.WeakReference;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.CollectionLiterals;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class MyRef<U extends Object> extends WeakReference<Iterable<U>> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public MyRef() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("super(CollectionLiterals.<U>newArrayList());");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testSimpleArgument_08() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class MyRef<U> extends java.lang.ref.WeakReference<Iterable<U>> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new() { super(newArrayList(null)) }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.lang.ref.WeakReference;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.CollectionLiterals;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class MyRef<U extends Object> extends WeakReference<Iterable<U>> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public MyRef() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("super(CollectionLiterals.<U>newArrayList(null));");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testSimpleArgument_09() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class MyRef<U> extends java.lang.ref.WeakReference<Iterable<U>> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(U u) { super(newArrayList(u)) }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.lang.ref.WeakReference;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.CollectionLiterals;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class MyRef<U extends Object> extends WeakReference<Iterable<U>> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public MyRef(final U u) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("super(CollectionLiterals.<U>newArrayList(u));");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testTransitiveArgument_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class MyRef<AAA, AA extends AAA> extends java.lang.ref.WeakReference<AAA> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(AA a) { super(a) }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.lang.ref.WeakReference;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class MyRef<AAA extends Object, AA extends AAA> extends WeakReference<AAA> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public MyRef(final AA a) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("super(a);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testTransitiveArgument_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class MyRef<AAA, AA extends AAA> extends java.lang.ref.WeakReference<Iterable<AAA>> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(AA a) { super(<AAA>newArrayList(a)) }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.lang.ref.WeakReference;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.CollectionLiterals;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class MyRef<AAA extends Object, AA extends AAA> extends WeakReference<Iterable<AAA>> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public MyRef(final AA a) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("super(CollectionLiterals.<AAA>newArrayList(a));");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testTransitiveArgument_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class MyRef<AAA, AA extends AAA> extends java.lang.ref.WeakReference<Iterable<AA>> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(AAA a) { this(newArrayList(a as AA)) }");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(Iterable<AA> iter) { super(iter) }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.lang.ref.WeakReference;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.CollectionLiterals;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class MyRef<AAA extends Object, AA extends AAA> extends WeakReference<Iterable<AA>> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public MyRef(final AAA a) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("this(CollectionLiterals.<AA>newArrayList(((AA) a)));");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public MyRef(final Iterable<AA> iter) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("super(iter);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testTransitiveArgument_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class MyList<AAA, AA extends java.util.List<AAA>> extends java.util.ArrayList<AAA> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(AA a) { super(a) }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.ArrayList;");
    _builder_1.newLine();
    _builder_1.append("import java.util.List;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class MyList<AAA extends Object, AA extends List<AAA>> extends ArrayList<AAA> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public MyList(final AA a) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("super(a);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testTransitiveArgument_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class MyList<T, U extends T> extends java.util.ArrayList<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(U u) { super(newArrayList(u)) }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.ArrayList;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.CollectionLiterals;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class MyList<T extends Object, U extends T> extends ArrayList<T> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public MyList(final U u) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("super(CollectionLiterals.<U>newArrayList(u));");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testBug403706_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("class TestA<T> {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("new(List<T> list) {}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def woot(List<T> list) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class TestB<U> extends TestA<U> {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("new(List<U> list) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("super(list)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("override woot(List<U> list) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("super.woot(list)");
    _builder.newLine();
    _builder.append("    ");
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
    _builder_1.append("public class TestA<T extends Object> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public TestA(final List<T> list) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Object woot(final List<T> list) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return null;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testBug403706_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("class TestB<U> extends TestA<U> {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("new(List<U> list) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("super(list)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("override woot(List<U> list) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("super.woot(list)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class TestA<T> {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("new(List<T> list) {}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def woot(List<T> list) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.List;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class TestB<U extends Object> extends TestA<U> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public TestB(final List<U> list) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("super(list);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Object woot(final List<U> list) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return super.woot(list);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testBug434589_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Node<TNode extends Node<TNode, TValue>, TValue> {}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Node<TNode extends Node<TNode, TValue>, TValue extends Object> {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
}
