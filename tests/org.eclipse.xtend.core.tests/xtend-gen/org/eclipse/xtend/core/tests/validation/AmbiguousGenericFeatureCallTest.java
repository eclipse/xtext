/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.validation;

import org.eclipse.xtend.core.tests.validation.AmbiguityValidationTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class AmbiguousGenericFeatureCallTest extends AmbiguityValidationTest {
  @Test
  public void testAmbiguousMethods_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n(StringBuilder b) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m2(b)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <T extends CharSequence> void m2(T c) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <X extends Appendable> void m2(X a) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertAmbiguous(_builder, "<T extends CharSequence> m2(T)", "<X extends Appendable> m2(X)");
  }
  
  @Test
  public void testAmbiguousMethods_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n(StringBuilder b) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m2(get)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2(CharSequence c) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m2(Appendable a) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <T> T get() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Ambiguous feature call.");
    _builder_1.newLine();
    _builder_1.append("The methods");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m2(CharSequence) in C and");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m2(Appendable) in C");
    _builder_1.newLine();
    _builder_1.append("both match.");
    this.assertAmbiguous(_builder, _builder_1.toString());
  }
  
  @Test
  public void testAmbiguousMethods_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n(D<String> it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(\'\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class D<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(String s) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(T t) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Ambiguous feature call.");
    _builder_1.newLine();
    _builder_1.append("The methods");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m(String) in D and");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m(T) in D");
    _builder_1.newLine();
    _builder_1.append("both match.");
    this.assertAmbiguous(_builder, _builder_1.toString());
  }
  
  @Test
  public void testAmbiguousMethods_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(D<String> it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("add(\'\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class D<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void add(T t) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <X extends String> void add(X x) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Ambiguous feature call.");
    _builder_1.newLine();
    _builder_1.append("The methods");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("add(T) in D and");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("<X extends String> add(X) in D");
    _builder_1.newLine();
    _builder_1.append("both match.");
    this.assertAmbiguous(_builder, _builder_1.toString());
  }
  
  @Test
  public void testAmbiguousMethods_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(D<String> it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("add(\'\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <X extends String> void add(X x) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class D<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void add(T t) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Ambiguous feature call.");
    _builder_1.newLine();
    _builder_1.append("The methods");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("add(T) in D and");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("<X extends String> add(X) in C");
    _builder_1.newLine();
    _builder_1.append("both match.");
    this.assertAmbiguous(_builder, _builder_1.toString());
  }
  
  @Test
  public void testAmbiguousMethods_06() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() { foo(\"foo\") }");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(CharSequence x) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(Comparable<?> x) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Ambiguous feature call.");
    _builder_1.newLine();
    _builder_1.append("The methods");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("foo(CharSequence) in C and");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("foo(Comparable<?>) in C");
    _builder_1.newLine();
    _builder_1.append("both match.");
    this.assertAmbiguous(_builder, _builder_1.toString());
  }
  
  @Test
  public void testAmbiguousMethods_07() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() { foo }");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def getFoo() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Ambiguous feature call.");
    _builder_1.newLine();
    _builder_1.append("The methods");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("foo() in C and");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("getFoo() in C");
    _builder_1.newLine();
    _builder_1.append("both match.");
    this.assertAmbiguous(_builder, _builder_1.toString());
  }
  
  @Test
  public void testAmbiguousMethods_08() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def Iterable<String> m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val list = new java.util.ArrayList");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("list.add(new java.util.ArrayList)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("list.head.head.head");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Ambiguous feature call.");
    _builder_1.newLine();
    _builder_1.append("The extension methods");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("<T> head(Iterable<T>) in IterableExtensions and");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("<T> head(Iterator<T>) in IteratorExtensions");
    _builder_1.newLine();
    _builder_1.append("both match.");
    this.assertAmbiguous(_builder, _builder_1.toString());
  }
  
  @Test
  public void testAmbiguousMethods_09() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.*");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(<StringBuilder>newArrayList)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(Collection<? extends CharSequence> c) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(List<? extends Appendable> c) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Ambiguous feature call.");
    _builder_1.newLine();
    _builder_1.append("The methods");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m(Collection<? extends CharSequence>) in C and");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m(List<? extends Appendable>) in C");
    _builder_1.newLine();
    _builder_1.append("both match.");
    this.assertAmbiguous(_builder, _builder_1.toString());
  }
  
  @Test
  public void testAmbiguousMethods_10() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.*");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(<StringBuilder>newArrayList)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(Collection<? extends CharSequence> c) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(List<? extends Appendable> c) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(Iterable<? extends StringBuilder> c) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Ambiguous feature call.");
    _builder_1.newLine();
    _builder_1.append("The methods");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m(Collection<? extends CharSequence>) in C,");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m(List<? extends Appendable>) in C and");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m(Iterable<? extends StringBuilder>) in C");
    _builder_1.newLine();
    _builder_1.append("all match.");
    this.assertAmbiguous(_builder, _builder_1.toString());
  }
  
  @Test
  public void testAmbiguousMethods_11() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.concurrent.*");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m [| \'\' ]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(Runnable r) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(Callable<String> c) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Ambiguous feature call.");
    _builder_1.newLine();
    _builder_1.append("The methods");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m(Runnable) in C and");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("m(Callable<String>) in C");
    _builder_1.newLine();
    _builder_1.append("both match.");
    this.assertAmbiguous(_builder, _builder_1.toString());
  }
  
  @Test
  public void testUnambiguousMethods_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n(E<String> it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(\'\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class D<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(T t) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class E<T> extends D<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(String s) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethods_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n(D<CharSequence> it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(\'\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class D<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(String s) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(T t) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethods_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def Iterable<String> m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val list = new java.util.ArrayList");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("list.add(new java.util.ArrayList)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("list.head.flatten.head");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethods_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.*");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def Iterator<String> m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val list = new ArrayList");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("list.add(new ArrayList)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("list.head.flatten.head");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethods_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.*");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(<StringBuilder>newArrayList)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(Collection<? extends CharSequence> c) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(List<? extends Appendable> c) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(AbstractList<? extends StringBuilder> c) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(Iterable<? extends StringBuilder> c) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethods_06() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n(L<String> list) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("list.addListener [");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("LC<String> c |");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface O {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void addListener(IL listener)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface L<E> extends O {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void addListener(LL<? super E> listener)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface LL<E> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void onChanged(LC<? extends E> c)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface LC<E> {}");
    _builder.newLine();
    _builder.append("interface IL {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void invalidated(O o)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethods_07() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n(L<String> list) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("list.addListener [");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("LC<CharSequence> lc |");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface O {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void addListener(IL listener)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface L<E> extends O {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void addListener(LL<? super E> listener)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface LL<E> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void onChanged(LC<? extends E> c)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface LC<E> {}");
    _builder.newLine();
    _builder.append("interface IL {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void invalidated(O o)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethods_08() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n(L<String> list) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("list.addListener [");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("O o |");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface O {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void addListener(IL listener)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface L<E> extends O {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void addListener(LL<? super E> listener)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface LL<E> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void onChanged(LC<? extends E> c)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface LC<E> {}");
    _builder.newLine();
    _builder.append("interface IL {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void invalidated(O o)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethods_09() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.concurrent.*");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m [| return; ]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(Runnable r) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(Callable<String> c) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethods_10() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.concurrent.*");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m [| return \'\'; ]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(Runnable r) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(Callable<String> c) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethods_11() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.concurrent.*");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m [| if (true) return \'\' ]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(Runnable r) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(Callable<String> c) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethods_12() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.concurrent.*");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m [| if (true) return \'\'; \'\' ]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(Runnable r) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(Callable<String> c) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethods_13() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.concurrent.*");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m [| if (true) return \'\' else \'\' ]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(Runnable r) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(Callable<String> c) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethods_14() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.concurrent.*");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m [| \'\' ]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(()=>String f) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(Callable<Integer> c) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
  
  @Test
  public void testUnambiguousMethods_15() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.concurrent.*");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void n() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m [| 1 ]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(()=>String f) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(Callable<Integer> c) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnambiguous(_builder);
  }
}
