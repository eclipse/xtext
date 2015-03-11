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
 */
@SuppressWarnings("all")
public class ModifierCompilerTest extends AbstractXtendCompilerTest {
  @Test
  public void testStrictfp_onClass() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("strictfp class X {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public strictfp class X {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testStrictfp_onInterface() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("strictfp interface X {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public strictfp interface X {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testStrictfp_onMethod() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class X {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("strictfp def void foo() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class X {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public strictfp void foo() {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testSynchronizedStrictfp_onMethod() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class X {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("synchronized strictfp def void foo() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class X {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public synchronized strictfp void foo() {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testNativeMethod() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class X {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("native def void foo()");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class X {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public native void foo();");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testTransientVolatileField() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class X {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("transient volatile String foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class X {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private transient volatile String foo;");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
}
