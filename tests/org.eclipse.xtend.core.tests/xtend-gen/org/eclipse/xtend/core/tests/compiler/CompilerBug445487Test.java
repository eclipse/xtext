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
public class CompilerBug445487Test extends AbstractXtendCompilerTest {
  @Test
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
    _builder_1.append("private Provider<Lexer> lexerProvider = new Provider<Lexer>() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("public Lexer get() {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return new InternalXtendLexer(null);");
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
    _builder_1.append("private Provider<? super Lexer> lexerProvider = new Provider<Lexer>() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("public Lexer get() {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return new InternalXtendLexer(null);");
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
    _builder_1.append("private Provider<? extends Lexer> lexerProvider = new Provider<Lexer>() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("public Lexer get() {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return new InternalXtendLexer(null);");
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
    _builder_1.append("return new Function0<InternalXtendLexer>() {");
    _builder_1.newLine();
    _builder_1.append("          ");
    _builder_1.append("public InternalXtendLexer apply() {");
    _builder_1.newLine();
    _builder_1.append("            ");
    _builder_1.append("return new InternalXtendLexer(null);");
    _builder_1.newLine();
    _builder_1.append("          ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("}.apply();");
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
    _builder_1.append("return ((Function0<? extends Lexer>) new Function0<InternalXtendLexer>() {");
    _builder_1.newLine();
    _builder_1.append("          ");
    _builder_1.append("public InternalXtendLexer apply() {");
    _builder_1.newLine();
    _builder_1.append("            ");
    _builder_1.append("return new InternalXtendLexer(null);");
    _builder_1.newLine();
    _builder_1.append("          ");
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
  
  @Test
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
    _builder_1.append("return new Function1<Object, InternalXtendLexer>() {");
    _builder_1.newLine();
    _builder_1.append("          ");
    _builder_1.append("public InternalXtendLexer apply(final Object it) {");
    _builder_1.newLine();
    _builder_1.append("            ");
    _builder_1.append("return new InternalXtendLexer(null);");
    _builder_1.newLine();
    _builder_1.append("          ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("}.apply(null);");
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
    _builder_1.append("return new Function1<Object, InternalXtendLexer>() {");
    _builder_1.newLine();
    _builder_1.append("                ");
    _builder_1.append("public InternalXtendLexer apply(final Object it) {");
    _builder_1.newLine();
    _builder_1.append("                  ");
    _builder_1.append("return new InternalXtendLexer(null);");
    _builder_1.newLine();
    _builder_1.append("                ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("              ");
    _builder_1.append("}.apply(null);");
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
