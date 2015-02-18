/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.java8.compiler;

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
public class CompilerBug445487Test extends org.eclipse.xtend.core.tests.compiler.CompilerBug445487Test {
  @Test
  @Override
  public void test_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import com.google.inject.Provider");
    _builder.newLine();
    _builder.append("import org.antlr.runtime.Lexer");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Provider<Lexer> lexerProvider= [return new InternalXtendLexer(null)]");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import com.google.inject.Provider;");
    _builder_1.newLine();
    _builder_1.append("import org.antlr.runtime.Lexer;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private Provider<Lexer> lexerProvider = ((Provider<Lexer>) () -> {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return new InternalXtendLexer(null);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("});");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  @Override
  public void test_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import com.google.inject.Provider");
    _builder.newLine();
    _builder.append("import org.antlr.runtime.Lexer");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Provider<? super Lexer> lexerProvider= [return new InternalXtendLexer(null)]");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import com.google.inject.Provider;");
    _builder_1.newLine();
    _builder_1.append("import org.antlr.runtime.Lexer;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private Provider<? super Lexer> lexerProvider = ((Provider<Lexer>) () -> {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return new InternalXtendLexer(null);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("});");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  @Override
  public void test_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import com.google.inject.Provider");
    _builder.newLine();
    _builder.append("import org.antlr.runtime.Lexer");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Provider<? extends Lexer> lexerProvider= [return new InternalXtendLexer(null)]");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import com.google.inject.Provider;");
    _builder_1.newLine();
    _builder_1.append("import org.antlr.runtime.Lexer;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private Provider<? extends Lexer> lexerProvider = ((Provider<Lexer>) () -> {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return new InternalXtendLexer(null);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("});");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  @Override
  public void test_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import com.google.inject.Provider");
    _builder.newLine();
    _builder.append("import org.antlr.runtime.Lexer");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Provider<Lexer> lexerProvider= [|return new InternalXtendLexer(null)] as Provider<Lexer> ");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import com.google.inject.Provider;");
    _builder_1.newLine();
    _builder_1.append("import org.antlr.runtime.Lexer;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Functions.Function0;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private Provider<Lexer> lexerProvider = ((Provider<Lexer>) new Provider<Lexer>() {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("public Lexer get() {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("return ((Function0<InternalXtendLexer>) () -> {");
    _builder_1.newLine();
    _builder_1.append("          ");
    _builder_1.append("return new InternalXtendLexer(null);");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("}).apply();");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("});");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  @Override
  public void test_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import com.google.inject.Provider");
    _builder.newLine();
    _builder.append("import org.antlr.runtime.Lexer");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Provider<Lexer> lexerProvider= [|return new InternalXtendLexer(null)] as ()=>Lexer");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import com.google.inject.Provider;");
    _builder_1.newLine();
    _builder_1.append("import org.antlr.runtime.Lexer;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Functions.Function0;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private Provider<Lexer> lexerProvider = new Provider<Lexer>() {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("public Lexer get() {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("return ((Function0<? extends Lexer>) ((Function0<InternalXtendLexer>) () -> {");
    _builder_1.newLine();
    _builder_1.append("          ");
    _builder_1.append("return new InternalXtendLexer(null);");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("})).apply();");
    _builder_1.newLine();
    _builder_1.append("      ");
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
  @Override
  public void test_06() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import com.google.inject.Provider");
    _builder.newLine();
    _builder.append("import org.antlr.runtime.Lexer");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Provider<Lexer> lexerProvider= [return new InternalXtendLexer(null)] as Provider<Lexer> ");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import com.google.inject.Provider;");
    _builder_1.newLine();
    _builder_1.append("import org.antlr.runtime.Lexer;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Functions.Function1;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private Provider<Lexer> lexerProvider = ((Provider<Lexer>) new Provider<Lexer>() {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("public Lexer get() {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("return ((Function1<Object, InternalXtendLexer>) (Object it) -> {");
    _builder_1.newLine();
    _builder_1.append("          ");
    _builder_1.append("return new InternalXtendLexer(null);");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("}).apply(null);");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("});");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  @Override
  public void test_07() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import com.google.inject.Provider");
    _builder.newLine();
    _builder.append("import org.antlr.runtime.Lexer");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Provider<Lexer> lexerProvider= [return new InternalXtendLexer(null)] as ()=>Lexer");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import com.google.inject.Provider;");
    _builder_1.newLine();
    _builder_1.append("import org.antlr.runtime.Lexer;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Functions.Function0;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Functions.Function1;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private Provider<Lexer> lexerProvider = new Provider<Lexer>() {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("public Lexer get() {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("return ((Function0<? extends Lexer>) new Function0<Lexer>() {");
    _builder_1.newLine();
    _builder_1.append("            ");
    _builder_1.append("public Lexer apply() {");
    _builder_1.newLine();
    _builder_1.append("              ");
    _builder_1.append("return ((Function1<Object, InternalXtendLexer>) (Object it) -> {");
    _builder_1.newLine();
    _builder_1.append("                ");
    _builder_1.append("return new InternalXtendLexer(null);");
    _builder_1.newLine();
    _builder_1.append("              ");
    _builder_1.append("}).apply(null);");
    _builder_1.newLine();
    _builder_1.append("            ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("}).apply();");
    _builder_1.newLine();
    _builder_1.append("      ");
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
