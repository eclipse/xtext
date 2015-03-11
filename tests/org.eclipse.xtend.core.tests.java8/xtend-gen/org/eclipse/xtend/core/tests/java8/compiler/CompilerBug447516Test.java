/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.java8.compiler;

import org.eclipse.xtend.core.tests.compiler.AbstractXtendCompilerTest;
import org.eclipse.xtend.core.tests.java8.Java8RuntimeInjectorProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Miro Spoenemann - Copied and adapted to Java 8 output
 */
@InjectWith(Java8RuntimeInjectorProvider.class)
@SuppressWarnings("all")
public class CompilerBug447516Test extends AbstractXtendCompilerTest {
  @Test
  public void test_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.eclipse.xtext.util.concurrent.IReadAccess");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val IReadAccess<String> readAccess = [");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return it.exec(\'\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import org.eclipse.xtext.util.concurrent.IReadAccess;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.util.concurrent.IUnitOfWork;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Exceptions;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private final IReadAccess<String> readAccess = new IReadAccess<String>() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("@Override");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("public <T extends Object> T readOnly(final IUnitOfWork<T, String> it) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("try {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("return it.exec(\"\");");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("} catch (Throwable _e) {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("throw Exceptions.sneakyThrow(_e);");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void test_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.eclipse.xtext.util.concurrent.IReadAccess");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val I<CharSequence> readAccess = [");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return it.apply(\'\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("interface I<P> {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("def <T extends P> T exec((P)=>T arg)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Functions.Function1;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public interface I<P extends Object> {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("public abstract <T extends P> T exec(final Function1<? super P, ? extends T> arg);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private final C.I<CharSequence> readAccess = new C.I<CharSequence>() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("@Override");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("public <T extends CharSequence> T exec(final Function1<? super CharSequence, ? extends T> it) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return it.apply(\"\");");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void test_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.eclipse.xtext.util.concurrent.IReadAccess");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val I<CharSequence, String> i = [");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return $1.apply(\'\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("interface I<P, W extends P> {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("def <T extends P, V extends T> T exec(W w, (P)=>T arg)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Functions.Function1;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public interface I<P extends Object, W extends P> {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("public abstract <T extends P, V extends T> T exec(final W w, final Function1<? super P, ? extends T> arg);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private final C.I<CharSequence, String> i = new C.I<CharSequence, String>() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("@Override");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("public <T extends CharSequence, V extends T> T exec(final String $0, final Function1<? super CharSequence, ? extends T> $1) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return $1.apply(\"\");");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
}
