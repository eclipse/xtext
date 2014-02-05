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
public class CompilerBug410767Test extends AbstractXtendCompilerTest {
  @Test
  public void test_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m(C1<?> p) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("p.toMap");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface C1<A1> extends C2<C1<C1<A1>>> {}");
    _builder.newLine();
    _builder.append("interface C2<A2> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def java.util.Map<A2, A2> toMap()");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.Map;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Map<C1<C1<?>>, C1<C1<?>>> m(final C1<?> p) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return p.toMap();");
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
    _builder.append("abstract class C<T> implements C1<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("toMap");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface C1<A1> extends C2<A1> {}");
    _builder.newLine();
    _builder.append("interface C2<A2> extends C3<A2, C2<A2>> {}");
    _builder.newLine();
    _builder.append("interface C3<A3, B3> extends C4<A3, C1<A3>> {}");
    _builder.newLine();
    _builder.append("interface C4<A4, B4> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def java.util.Map<A4, B4> toMap()");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.Map;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public abstract class C<T extends Object> implements C1<T> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Map<T, C1<T>> m() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return this.toMap();");
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
    _builder.append("abstract class C<T> implements C1<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m(C<? extends String> p) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("p.toMap");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface C1<A1> extends C2<A1> {}");
    _builder.newLine();
    _builder.append("interface C2<A2> extends C3<A2, C2<A2>> {}");
    _builder.newLine();
    _builder.append("interface C3<A3, B3> extends C4<A3, C1<A3>> {}");
    _builder.newLine();
    _builder.append("interface C4<A4, B4> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def java.util.Map<A4, B4> toMap()");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.Map;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public abstract class C<T extends Object> implements C1<T> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Map<? extends String, ? extends C1<? extends String>> m(final C<? extends String> p) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return p.toMap();");
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
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m(C1<?> p) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("p.toMap");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface C1<A1> extends C2<A1> {}");
    _builder.newLine();
    _builder.append("interface C2<A2> extends C3<A2, C2<A2>> {}");
    _builder.newLine();
    _builder.append("interface C3<A3, B3> extends C4<A3, C1<A3>> {}");
    _builder.newLine();
    _builder.append("interface C4<A4, B4> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def java.util.Map<A4, B4> toMap()");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.Map;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Map<?, C1<?>> m(final C1<?> p) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return p.toMap();");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
}
