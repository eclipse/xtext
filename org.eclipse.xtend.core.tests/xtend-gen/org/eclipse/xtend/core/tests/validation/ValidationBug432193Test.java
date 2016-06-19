/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.validation;

import com.google.inject.Inject;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class ValidationBug432193Test extends AbstractXtendTestCase {
  @Inject
  private ValidationTestHelper helper;
  
  @Inject
  private ParseHelper<XtendFile> parser;
  
  @Test
  public void test_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface Bar {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void bar(Object o) ");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Bar bar = [ String o | ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("o.substring(7)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertError(file, XbasePackage.Literals.XCLOSURE, IssueCodes.INCOMPATIBLE_TYPES, "Type mismatch: cannot convert from (String)=>void to Bar");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface Bar<T extends Number> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void bar(T o) ");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public Bar<?> bar = [ String o | ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("o.substring(7)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertError(file, XbasePackage.Literals.XCLOSURE, IssueCodes.INCOMPATIBLE_TYPES, "Type mismatch: cannot convert from (String)=>void to Bar");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_03() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface Bar {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void bar(String o) ");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Bar bar = [ Object o | ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertNoErrors(file);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_04() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface Bar<T extends Number> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void bar(T o) ");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public Bar<?> bar = [ Integer o | ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertNoErrors(file);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_05() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class SAM {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val MyAbstract1<Integer> x1 = [String k|k.substring(0, 1).length]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("abstract class MyAbstract1<T> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def T myAbstract(int u);");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertError(file, XbasePackage.Literals.XCLOSURE, IssueCodes.INCOMPATIBLE_TYPES, "Type mismatch: cannot convert from (String)=>int to MyAbstract1<Integer>");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_06() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class SAM {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val MyInterface<Integer> x2 = [String k|k.substring(0, 1).length]");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("interface MyInterface<T> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def T myAbstract(int u);");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertError(file, XbasePackage.Literals.XCLOSURE, IssueCodes.INCOMPATIBLE_TYPES, "Type mismatch: cannot convert from (String)=>int to MyInterface<Integer>");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_07() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface Bar<T extends Number> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void bar(Iterable<T> o) ");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public Bar<?> bar = [ Iterable<String> o | ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertError(file, XbasePackage.Literals.XCLOSURE, IssueCodes.INCOMPATIBLE_TYPES, "Type mismatch: cannot convert from (Iterable<String>)=>void to Bar<?>");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_08() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface Bar<T extends Number> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void bar(Iterable<T> o) ");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public Bar<? super Integer> bar = [ Iterable<String> o | ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertError(file, XbasePackage.Literals.XCLOSURE, IssueCodes.INCOMPATIBLE_TYPES, "Type mismatch: cannot convert from (Iterable<String>)=>void to Bar<? super Integer>");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_09() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface Bar<T extends Number> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def String bar(Iterable<T> o) ");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public Bar<? extends Integer> bar = [ Iterable<Integer> o | ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("o.head");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertError(file, XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.INCOMPATIBLE_TYPES, "Type mismatch: cannot convert from Integer to String");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface Bar {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void bar(java.util.List<Number> o) ");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public Bar bar = [ Iterable<String> o | ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertError(file, XbasePackage.Literals.XCLOSURE, IssueCodes.INCOMPATIBLE_TYPES, "Type mismatch: cannot convert from (Iterable<String>)=>void to Bar");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_11() {
    try {
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
      _builder.append("LC<? extends String> c |");
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
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertNoErrors(file);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_12() {
    try {
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
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertError(file, XbasePackage.Literals.XCLOSURE, IssueCodes.INCOMPATIBLE_TYPES, "Type mismatch: cannot convert from (LC<String>)=>void to LL<? super String>");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_13() {
    try {
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
      _builder.append("LC<? extends String> c |");
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
      _builder.append("def void onChanged(LC<E> c)");
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
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertNoErrors(file);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_14() {
    try {
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
      _builder.append("LC<? super String> c |");
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
      _builder.append("def void onChanged(LC<E> c)");
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
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertNoErrors(file);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
