/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.typesystem;

import com.google.inject.Inject;
import org.eclipse.xtend.core.tests.compiler.CompilerBug410767Test;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.compiler.GeneratorConfig;
import org.eclipse.xtext.xbase.junit.typesystem.Oven;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractCompilerBug410767SmokeTest extends CompilerBug410767Test {
  @Inject
  @Extension
  private Oven _oven;
  
  public void assertCompilesTo(final CharSequence input, final CharSequence expected, final GeneratorConfig config) {
    try {
      this.assertNonSmoking(input);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected abstract void assertNonSmoking(final CharSequence input) throws Exception;
  
  protected void processFile(final String input) {
    try {
      this._oven.fireproof(input);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C1 {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m(C11<?> p) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("p.toMap");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface C11<C1> extends C111<C11<C11<C1>>> {}");
    _builder.newLine();
    _builder.append("interface C111<C1> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def java.util.Map<C1, C1> toMap()");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.Map;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C1 {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Map<C11<C11<? extends Object>>,C11<C11<? extends Object>>> m(final C11<? extends Object> p) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Map<C11<C11<? extends Object>>,C11<C11<? extends Object>>> _map = p.toMap();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return _map;");
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
    _builder.append("abstract class C1<CC1> implements C11<CC1> {");
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
    _builder.append("interface C11<C1> extends C12<C1> {}");
    _builder.newLine();
    _builder.append("interface C12<C2> extends C13<C2, C12<C2>> {}");
    _builder.newLine();
    _builder.append("interface C13<C1, C2> extends C14<C1, C11<C1>> {}");
    _builder.newLine();
    _builder.append("interface C14<C1,C2> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def C13<C1, C2> toMap()");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public abstract class C1<CC1 extends Object> implements C11<CC1> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public C13<CC1,C11<CC1>> m() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("C13<CC1,C11<CC1>> _map = this.toMap();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return _map;");
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
    _builder.append("abstract class C<CC> implements C1<CC> {");
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
    _builder.append("interface C1<CC> extends C11<CC> {}");
    _builder.newLine();
    _builder.append("interface C11<CC> extends C111<CC, C11<CC>> {}");
    _builder.newLine();
    _builder.append("interface C111<CC, CC1> extends C1111<CC, C1<CC>> {}");
    _builder.newLine();
    _builder.append("interface C1111<CC, CC1> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def C111<CC,CC1> toMap()");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public abstract class C<CC extends Object> implements C1<CC> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public C111<? extends String,? extends C1<? extends String>> m(final C<? extends String> p) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("C111<? extends String,? extends C1<? extends String>> _map = p.toMap();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return _map;");
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
    _builder.append("interface C1<C> extends C11<C> {}");
    _builder.newLine();
    _builder.append("interface C11<C> extends C111<C, C11<C>> {}");
    _builder.newLine();
    _builder.append("interface C111<C, C1> extends C1111<C, C1<C>> {}");
    _builder.newLine();
    _builder.append("interface C1111<CC1, C11> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def C111<CC1, C11> toMap()");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public C111<? extends Object,C11<? extends Object>> m(final C1<? extends Object> p) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("C111<? extends Object,C11<? extends Object>> _map = p.toMap();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return _map;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
}
