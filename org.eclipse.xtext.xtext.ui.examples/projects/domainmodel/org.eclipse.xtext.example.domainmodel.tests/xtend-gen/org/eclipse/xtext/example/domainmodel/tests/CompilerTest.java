package org.eclipse.xtext.example.domainmodel.tests;

import com.google.inject.Inject;
import java.util.Collections;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.example.domainmodel.tests.DomainmodelInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions;
import org.eclipse.xtext.xbase.testing.CompilationTestHelper;
import org.eclipse.xtext.xbase.testing.TemporaryFolder;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(DomainmodelInjectorProvider.class)
@SuppressWarnings("all")
public class CompilerTest {
  @Rule
  @Inject
  public TemporaryFolder temporaryFolder;
  
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
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        try {
          final Object obj = it.getCompiledClass().newInstance();
          this._reflectExtensions.invoke(obj, "setName", "Foo");
          Assert.assertEquals("Hello Foo", this._reflectExtensions.invoke(obj, "doStuff", "Hello"));
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      this._compilationTestHelper.compile(_builder, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testGeneratedJavaFromSeveralInputs() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("entity Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("bar : Bar");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("op doStuff(String x) : String {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return x + \' \' + bar.getName()");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("entity Bar {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("name : String");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        try {
          final Object barObj = it.getCompiledClass("Bar").newInstance();
          this._reflectExtensions.invoke(barObj, "setName", "Bar");
          final Object fooObj = it.getCompiledClass("Foo").newInstance();
          this._reflectExtensions.invoke(fooObj, "setBar", barObj);
          Assert.assertEquals("Hello Bar", this._reflectExtensions.invoke(fooObj, "doStuff", "Hello"));
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      this._compilationTestHelper.compile(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(_builder.toString(), _builder_1.toString())), _function);
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
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;");
        _builder_1.newLine();
        _builder_1.append("import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("@SuppressWarnings(\"all\")");
        _builder_1.newLine();
        _builder_1.append("public class Foo {");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("public Foo() {");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("public Foo(final Procedure1<Foo> initializer) {");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("initializer.apply(this);");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("private String name;");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("public String getName() {");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("return this.name;");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("public void setName(final String name) {");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("this.name = name;");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("@Override");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("public String toString() {");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("String result = new ToStringBuilder(this).addAllFields().toString();");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("return result;");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        Assert.assertEquals(_builder_1.toString(), it.getSingleGeneratedCode());
      };
      this._compilationTestHelper.compile(_builder, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
