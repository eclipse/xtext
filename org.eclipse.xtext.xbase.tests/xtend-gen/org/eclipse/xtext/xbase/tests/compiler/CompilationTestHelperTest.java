/**
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.compiler;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.JavaVersion;
import org.eclipse.xtext.xbase.compiler.GeneratorConfig;
import org.eclipse.xtext.xbase.compiler.GeneratorConfigProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.testing.CompilationTestHelper;
import org.eclipse.xtext.xbase.testing.TemporaryFolder;
import org.eclipse.xtext.xbase.tests.jvmmodel.AbstractJvmModelTest;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Lorenzo Bettini - Initial contribution and API
 */
@SuppressWarnings("all")
public class CompilationTestHelperTest extends AbstractJvmModelTest {
  @Rule
  @Inject
  public TemporaryFolder temporaryFolder;
  
  @Inject
  @Extension
  private CompilationTestHelper compilationTestHelper;
  
  @Inject
  private GeneratorConfigProvider generatorConfigProvider;
  
  @Inject
  private FileExtensionProvider extensionProvider;
  
  @Test
  public void testSwitchJavaVersion6() {
    try {
      this.compilationTestHelper.setJavaVersion(JavaVersion.JAVA6);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val s = \"\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch (s) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case \"foo\": \"foo\"");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("default: \"bar\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("import com.google.common.base.Objects;");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("@SuppressWarnings(\"all\")");
        _builder_1.newLine();
        _builder_1.append("public class Test {");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("public String doStuff(final String s) {");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("String _xblockexpression = null;");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("{");
        _builder_1.newLine();
        _builder_1.append("      ");
        _builder_1.append("final String s_1 = \"\";");
        _builder_1.newLine();
        _builder_1.append("      ");
        _builder_1.append("String _switchResult = null;");
        _builder_1.newLine();
        _builder_1.append("      ");
        _builder_1.append("boolean _matched = false;");
        _builder_1.newLine();
        _builder_1.append("      ");
        _builder_1.append("if (Objects.equal(s_1, \"foo\")) {");
        _builder_1.newLine();
        _builder_1.append("        ");
        _builder_1.append("_matched=true;");
        _builder_1.newLine();
        _builder_1.append("        ");
        _builder_1.append("_switchResult = \"foo\";");
        _builder_1.newLine();
        _builder_1.append("      ");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("      ");
        _builder_1.append("if (!_matched) {");
        _builder_1.newLine();
        _builder_1.append("        ");
        _builder_1.append("_switchResult = \"bar\";");
        _builder_1.newLine();
        _builder_1.append("      ");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("      ");
        _builder_1.append("_xblockexpression = _switchResult;");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("return _xblockexpression;");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        Assert.assertEquals(_builder_1.toString(), it.getSingleGeneratedCode());
        it.getCompiledClass();
      };
      this.compilationTestHelper.compile(_builder, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSwitchJavaVersion7() {
    try {
      this.compilationTestHelper.setJavaVersion(JavaVersion.JAVA7);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val s = \"\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("switch (s) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("case \"foo\": \"foo\"");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("default: \"bar\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("@SuppressWarnings(\"all\")");
        _builder_1.newLine();
        _builder_1.append("public class Test {");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("public String doStuff(final String s) {");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("String _xblockexpression = null;");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("{");
        _builder_1.newLine();
        _builder_1.append("      ");
        _builder_1.append("final String s_1 = \"\";");
        _builder_1.newLine();
        _builder_1.append("      ");
        _builder_1.append("String _switchResult = null;");
        _builder_1.newLine();
        _builder_1.append("      ");
        _builder_1.append("if (s_1 != null) {");
        _builder_1.newLine();
        _builder_1.append("        ");
        _builder_1.append("switch (s_1) {");
        _builder_1.newLine();
        _builder_1.append("          ");
        _builder_1.append("case \"foo\":");
        _builder_1.newLine();
        _builder_1.append("            ");
        _builder_1.append("_switchResult = \"foo\";");
        _builder_1.newLine();
        _builder_1.append("            ");
        _builder_1.append("break;");
        _builder_1.newLine();
        _builder_1.append("          ");
        _builder_1.append("default:");
        _builder_1.newLine();
        _builder_1.append("            ");
        _builder_1.append("_switchResult = \"bar\";");
        _builder_1.newLine();
        _builder_1.append("            ");
        _builder_1.append("break;");
        _builder_1.newLine();
        _builder_1.append("        ");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("      ");
        _builder_1.append("} else {");
        _builder_1.newLine();
        _builder_1.append("        ");
        _builder_1.append("_switchResult = \"bar\";");
        _builder_1.newLine();
        _builder_1.append("      ");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("      ");
        _builder_1.append("_xblockexpression = _switchResult;");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("return _xblockexpression;");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        Assert.assertEquals(_builder_1.toString(), it.getSingleGeneratedCode());
        it.getCompiledClass();
      };
      this.compilationTestHelper.compile(_builder, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testLambdaJavaVersion6() {
    try {
      this.compilationTestHelper.setJavaVersion(JavaVersion.JAVA6);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val f = [ int i | i + 1 ]");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("import org.eclipse.xtext.xbase.lib.Functions.Function1;");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("@SuppressWarnings(\"all\")");
        _builder_1.newLine();
        _builder_1.append("public class Test {");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("public String doStuff(final String s) {");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("final Function1<Integer, Integer> _function = new Function1<Integer, Integer>() {");
        _builder_1.newLine();
        _builder_1.append("      ");
        _builder_1.append("@Override");
        _builder_1.newLine();
        _builder_1.append("      ");
        _builder_1.append("public Integer apply(final Integer i) {");
        _builder_1.newLine();
        _builder_1.append("        ");
        _builder_1.append("return Integer.valueOf((i + 1));");
        _builder_1.newLine();
        _builder_1.append("      ");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("};");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("final Function1<Integer, Integer> f = _function;");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("return null;");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        Assert.assertEquals(_builder_1.toString(), it.getSingleGeneratedCode());
        it.getCompiledClass();
      };
      this.compilationTestHelper.compile(_builder, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testLambdaJavaVersion8() {
    try {
      this.compilationTestHelper.setJavaVersion(JavaVersion.JAVA8);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val f = [ int i | i + 1 ]");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("import org.eclipse.xtext.xbase.lib.Functions.Function1;");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("@SuppressWarnings(\"all\")");
        _builder_1.newLine();
        _builder_1.append("public class Test {");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("public String doStuff(final String s) {");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("final Function1<Integer, Integer> _function = (Integer i) -> {");
        _builder_1.newLine();
        _builder_1.append("      ");
        _builder_1.append("return Integer.valueOf((i + 1));");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("};");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("final Function1<Integer, Integer> f = _function;");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("return null;");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        Assert.assertEquals(_builder_1.toString(), it.getSingleGeneratedCode());
        it.getCompiledClass();
      };
      this.compilationTestHelper.compile(_builder, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testCustomConfigIsNotLost() {
    try {
      this.compilationTestHelper.setJavaVersion(JavaVersion.JAVA8);
      String _primaryFileExtension = this.extensionProvider.getPrimaryFileExtension();
      String _plus = ("MyFile." + _primaryFileExtension);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val f = [ int i | i + 1 ]");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      Pair<String, String> _mappedTo = Pair.<String, String>of(_plus, _builder.toString());
      final ResourceSet resourceSet = this.compilationTestHelper.resourceSet(
        new Pair[] { _mappedTo });
      GeneratorConfig _generatorConfig = new GeneratorConfig();
      final Procedure1<GeneratorConfig> _function = (GeneratorConfig it) -> {
        it.setGenerateSyntheticSuppressWarnings(false);
      };
      GeneratorConfig _doubleArrow = ObjectExtensions.<GeneratorConfig>operator_doubleArrow(_generatorConfig, _function);
      this.generatorConfigProvider.install(resourceSet, _doubleArrow);
      final IAcceptor<CompilationTestHelper.Result> _function_1 = (CompilationTestHelper.Result it) -> {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("import org.eclipse.xtext.xbase.lib.Functions.Function1;");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("public class Test {");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("public String doStuff(final String s) {");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("final Function1<Integer, Integer> _function = (Integer i) -> {");
        _builder_1.newLine();
        _builder_1.append("      ");
        _builder_1.append("return Integer.valueOf((i + 1));");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("};");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("final Function1<Integer, Integer> f = _function;");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("return null;");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        Assert.assertEquals(_builder_1.toString(), it.getSingleGeneratedCode());
      };
      this.compilationTestHelper.compile(resourceSet, _function_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
