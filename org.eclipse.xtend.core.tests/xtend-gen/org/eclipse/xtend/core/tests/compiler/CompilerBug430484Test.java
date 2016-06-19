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
public class CompilerBug430484Test extends AbstractXtendCompilerTest {
  @Test
  public void test_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class TestDummy {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static <T extends Enum<T>> void enumeration(Class<T> enumClass) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("for(t : enumClass.getEnumConstants()) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class TestDummy {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public static <T extends Enum<T>> void enumeration(final Class<T> enumClass) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("T[] _enumConstants = enumClass.getEnumConstants();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("for (final T t : _enumConstants) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
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
    _builder.append("class TestDummy {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static <T extends Enum<T>> void enumeration(Class<T> enumClass) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("for(T t : enumClass.getEnumConstants()) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class TestDummy {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public static <T extends Enum<T>> void enumeration(final Class<T> enumClass) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("T[] _enumConstants = enumClass.getEnumConstants();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("for (final T t : _enumConstants) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
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
    _builder.append("class TestDummy {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static <T extends Enum<T>, V extends T> void enumeration(Class<T> enumClass) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("for(T t : enumClass.getEnumConstants() as V[]) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class TestDummy {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public static <T extends Enum<T>, V extends T> void enumeration(final Class<T> enumClass) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("T[] _enumConstants = enumClass.getEnumConstants();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("for (final T t : ((V[]) _enumConstants)) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
}
