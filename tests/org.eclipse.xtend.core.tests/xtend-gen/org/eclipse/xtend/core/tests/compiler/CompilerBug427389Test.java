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
public class CompilerBug427389Test extends AbstractXtendCompilerTest {
  @Test
  public void testBug_427389_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.eclipse.xtend2.lib.StringConcatenation;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.xbase.lib.Pair;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"all\")");
    _builder.newLine();
    _builder.append("public abstract class C<T extends Object> {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public final CharSequence m(final T it) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("StringConcatenation _builder = new StringConcatenation();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("Iterable<Pair<? extends D,Class<? extends E<?>>>> _m2 = this.m2(it);");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("for(final Pair<? extends D, Class<? extends E<?>>> it_1 : _m2) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("_builder.append(\"\\t\");");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("_builder.newLine();");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return _builder;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public abstract Iterable<Pair<? extends D,Class<? extends E<?>>>> m2(final T it);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertCompilesTo("\n\t\t\tabstract class C<T> {\n\t\t\t\tdef final m(T it)\'\'\'\n\t\t\t\t\t«FOR  it : m2»\n\t\t\t\t\t\t\n\t\t\t\t\t«ENDFOR»\n\t\t\t\t\'\'\'\n\t\t\t\tdef abstract Iterable<Pair<? extends D, Class<? extends E<?>>>> m2(T it) \n\t\t\t}\n\t\t\tclass D {}\n\t\t\tclass E<T> {}\n\t\t", _builder);
  }
}
