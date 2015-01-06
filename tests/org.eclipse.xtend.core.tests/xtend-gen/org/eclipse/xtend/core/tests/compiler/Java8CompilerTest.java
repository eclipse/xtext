/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.compiler;

import org.eclipse.xtend.core.tests.Java8RuntimeInjectorProvider;
import org.eclipse.xtend.core.tests.compiler.AbstractXtendCompilerTest;
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
}
