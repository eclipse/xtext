package org.eclipse.xtext.example.domainmodel.tests;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.example.domainmodel.tests.InjectorProviderCustom;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(InjectorProviderCustom.class)
@SuppressWarnings("all")
public class CompilerTest {
  @Inject
  @Extension
  private CompilationTestHelper _compilationTestHelper;
  
  @Inject
  @Extension
  private ReflectExtensions _reflectExtensions;
  
  @Test
  public void testGeneratedJava() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("entity Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("name : String");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("op doStuff(String x) : String {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return x + \' \' + this.name");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          try {
            Class<? extends Object> _compiledClass = it.getCompiledClass();
            final Object obj = _compiledClass.newInstance();
            CompilerTest.this._reflectExtensions.invoke(obj, "setName", "Foo");
            Object _invoke = CompilerTest.this._reflectExtensions.invoke(obj, "doStuff", "Hello");
            Assert.assertEquals("Hello Foo", _invoke);
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      this._compilationTestHelper.compile(_builder, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void compareGeneratedJava() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("entity Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("name : String");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;");
          _builder.newLine();
          _builder.append("import org.eclipse.xtext.xbase.lib.util.ToStringHelper;");
          _builder.newLine();
          _builder.newLine();
          _builder.append("@SuppressWarnings(\"all\")");
          _builder.newLine();
          _builder.append("public class Foo {");
          _builder.newLine();
          _builder.append("  ");
          _builder.append("public Foo() {");
          _builder.newLine();
          _builder.append("  ");
          _builder.append("}");
          _builder.newLine();
          _builder.append("  ");
          _builder.newLine();
          _builder.append("  ");
          _builder.append("public Foo(final Procedure1<Foo> initializer) {");
          _builder.newLine();
          _builder.append("    ");
          _builder.append("initializer.apply(this);");
          _builder.newLine();
          _builder.append("  ");
          _builder.append("}");
          _builder.newLine();
          _builder.append("  ");
          _builder.newLine();
          _builder.append("  ");
          _builder.append("private String name;");
          _builder.newLine();
          _builder.append("  ");
          _builder.newLine();
          _builder.append("  ");
          _builder.append("public String getName() {");
          _builder.newLine();
          _builder.append("    ");
          _builder.append("return this.name;");
          _builder.newLine();
          _builder.append("  ");
          _builder.append("}");
          _builder.newLine();
          _builder.append("  ");
          _builder.newLine();
          _builder.append("  ");
          _builder.append("public void setName(final String name) {");
          _builder.newLine();
          _builder.append("    ");
          _builder.append("this.name = name;");
          _builder.newLine();
          _builder.append("  ");
          _builder.append("}");
          _builder.newLine();
          _builder.append("  ");
          _builder.newLine();
          _builder.append("  ");
          _builder.append("@Override");
          _builder.newLine();
          _builder.append("  ");
          _builder.append("public String toString() {");
          _builder.newLine();
          _builder.append("    ");
          _builder.append("String result = new ToStringHelper().toString(this);");
          _builder.newLine();
          _builder.append("    ");
          _builder.append("return result;");
          _builder.newLine();
          _builder.append("  ");
          _builder.append("}");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
          String _string = _builder.toString();
          String _singleGeneratedCode = it.getSingleGeneratedCode();
          Assert.assertEquals(_string, _singleGeneratedCode);
        }
      };
      this._compilationTestHelper.compile(_builder, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
