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
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class ParameterizedInnerTypesCompilerTest extends AbstractXtendCompilerTest {
  @Test
  public void test_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import bug417675.*");
    _builder.newLine();
    _builder.append("class EitherTest {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("Either<Integer, Boolean> either;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def m() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("either.right().get();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import bug417675.Either;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class EitherTest {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private Either<Integer, Boolean> either;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Boolean m() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Either<Integer, Boolean>.RightProjection _right = this.either.right();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return _right.get();");
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
    _builder.append("import bug417675.*");
    _builder.newLine();
    _builder.append("class EitherTest {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("Either<Integer, Boolean> either;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def m() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("either.left().get();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import bug417675.Either;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class EitherTest {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private Either<Integer, Boolean> either;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Integer m() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Either<Integer, Boolean>.LeftProjection _left = this.either.left();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return _left.get();");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void test_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import bug417675.*");
    _builder.newLine();
    _builder.append("class EitherTest {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def m(Either<Integer, Boolean> it) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("right().on [ intValue == 0 ]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import bug417675.Either;");
    _builder_1.newLine();
    _builder_1.append("import com.google.common.base.Function;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class EitherTest {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Boolean m(final Either<Integer, Boolean> it) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Either<Integer, Boolean>.RightProjection _right = it.right();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final Function<Integer, Boolean> _function = new Function<Integer, Boolean>() {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("public Boolean apply(final Integer it) {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("int _intValue = it.intValue();");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("return Boolean.valueOf((_intValue == 0));");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return _right.on(_function);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void test_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import bug417675.*");
    _builder.newLine();
    _builder.append("class EitherTest {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def m(Either<Integer, Boolean> it) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("left().either().right()");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import bug417675.Either;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class EitherTest {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Either<Integer, Boolean>.RightProjection m(final Either<Integer, Boolean> it) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Either<Integer, Boolean>.LeftProjection _left = it.left();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Either<Integer, Boolean> _either = _left.either();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return _either.right();");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void test_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import bug417675.*");
    _builder.newLine();
    _builder.append("class EitherTest {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def m(Either<Integer, Boolean> it) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("left().iterator().next");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import bug417675.Either;");
    _builder_1.newLine();
    _builder_1.append("import java.util.Iterator;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class EitherTest {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Integer m(final Either<Integer, Boolean> it) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Either<Integer, Boolean>.LeftProjection _left = it.left();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Iterator<Integer> _iterator = _left.iterator();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return _iterator.next();");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void test_06() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import bug417675.*");
    _builder.newLine();
    _builder.append("class EitherTest {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def m(Either<Integer, Boolean> it) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("map [ toString ].swap");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import bug417675.Either;");
    _builder_1.newLine();
    _builder_1.append("import com.google.common.base.Function;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class EitherTest {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Either<String, Integer> m(final Either<Integer, Boolean> it) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final Function<Boolean, String> _function = new Function<Boolean, String>() {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("public String apply(final Boolean it) {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("return it.toString();");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Either<Integer, String> _map = it.<String>map(_function);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return _map.swap();");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void test_07() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import bug417675.*");
    _builder.newLine();
    _builder.append("class EitherTest {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def m() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("val either = Either.left(\'\')");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("val String s = either.right().get");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return either");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import bug417675.Either;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class EitherTest {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Either<String, String> m() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final Either<String, String> either = Either.<String, String>left(\"\");");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Either<String, String>.RightProjection _right = either.right();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final String s = _right.get();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return either;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void test_08() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import bug417675.*");
    _builder.newLine();
    _builder.append("class EitherTest {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def m() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("val either = Either.left(\'\')");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("val int i = either.swap().left().iterator().next");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return either");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import bug417675.Either;");
    _builder_1.newLine();
    _builder_1.append("import java.util.Iterator;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class EitherTest {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Either<String, Integer> m() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final Either<String, Integer> either = Either.<String, Integer>left(\"\");");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Either<Integer, String> _swap = either.swap();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Either<Integer, String>.LeftProjection _left = _swap.left();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Iterator<Integer> _iterator = _left.iterator();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final int i = (_iterator.next()).intValue();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return either;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
}
