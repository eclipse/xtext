package org.eclipse.xtend.core.tests.compiler;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.generator.IFilePostProcessor;
import org.eclipse.xtext.xbase.compiler.ElementIssueProvider;
import org.eclipse.xtext.xbase.compiler.GeneratorConfig;
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class XtendCompilerErrorHandlingTest extends AbstractXtendTestCase {
  @Inject
  private JvmModelGenerator generator;
  
  @Inject
  private ElementIssueProvider.Factory issueProviderFactory;
  
  @Inject
  private IGeneratorConfigProvider generatorConfigProvider;
  
  @Inject
  protected IFilePostProcessor postProcessor;
  
  @Test
  public void testUnresolvedSuperclass() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo extends Unresolved {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo /* implements Unresolved  */{");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testPrivateToplevelClass() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("private class C {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("class C {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testUnresolvedInterface() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo implements Unresolved {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo /* implements Unresolved  */{");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testUnresolvedInterface_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo implements Cloneable, Unresolved {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo implements Cloneable/* , Unresolved */ {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testUnresolvedInterface_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo implements Unresolved, Cloneable {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo implements /* Unresolved */Cloneable {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testUnresolvedAnnotation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@MyAnnotation");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("/* @MyAnnotation */@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testUnresolvedAnnotation_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Deprecated");
    _builder.newLine();
    _builder.append("@Unresolved");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@Deprecated/* ");
    _builder_1.newLine();
    _builder_1.append("@Unresolved */");
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  /**
   * the @SuppressWarnings should be transformed into
   * a synthetic @SuppressWarnings("all") on class declarations.
   */
  @Test
  public void testUnresolvedAnnotation_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@MyAnnotation(x = \'foo\')");
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"unused\")");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("/* @MyAnnotation() */@SuppressWarnings(\"unused\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testUnresolvedFieldType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Unresolved bar");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private /* Unresolved */Object bar;");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testUnresolvedReturnType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def Unresolved bar() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("null");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public /* Unresolved */Object bar() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return null;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testUnresolvedParameterType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void bar(Unresolved p) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void bar(final /* Unresolved */Object p) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testUnresolvedException() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void bar() throws Unresolved {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void bar()/*  throws Unresolved */ {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testUnresolvedException_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void bar() throws Unresolved, RuntimeException {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void bar() throws /* Unresolved */RuntimeException {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testUnresolvedException_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void bar() throws RuntimeException, Unresolved {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void bar() throws RuntimeException/* , Unresolved */ {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testUnresolvedTypeConstraint() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo <T extends Unresolved> {}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo<T/*  extends Unresolved */> {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testFieldInitializerTypeError() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val int bar = null");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private final int bar /* Skipped initializer because of errors */;");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testFieldInitializerLinkError() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val bar = foo()");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private final Object bar /* Skipped initializer because of errors */;");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testMethodBodyTypeError() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def int bar() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("null");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public int bar() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("throw new Error(\"Unresolved compilation problems:\"");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("+ \"\\nType mismatch: cannot convert from null to int\");");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testMethodBodyLinkError() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def int bar() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("foo()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public int bar() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("throw new Error(\"Unresolved compilation problems:\"");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("+ \"\\nThe method foo() is undefined\");");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testMethodOrFieldLinkError() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def int bar() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("foo");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public int bar() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("throw new Error(\"Unresolved compilation problems:\"");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("+ \"\\nThe method or field foo is undefined\");");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testMethodLinkReceiverError() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def int bar() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.foo()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public int bar() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("throw new Error(\"Unresolved compilation problems:\"");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("+ \"\\nThe method foo() is undefined for the type Foo\");");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testBug462914() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def create DoesNotExists::createZonk m(String s) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.ArrayList;");
    _builder_1.newLine();
    _builder_1.append("import java.util.HashMap;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.CollectionLiterals;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Object m(final String s) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("throw new Error(\"Unresolved compilation problems:\"");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("+ \"\\nDoesNotExists cannot be resolved to a type.\"");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("+ \"\\ncreateZonk cannot be resolved\");");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private final /* HashMap<ArrayList<?>, Object> */Object _createCache_m = CollectionLiterals.newHashMap();");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private void _init_m(final Object it, final String s) {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  public void assertCompilesTo(final CharSequence input, final CharSequence expected) {
    try {
      String _string = input.toString();
      final XtendFile file = this.file(_string, false);
      final Resource resource = file.eResource();
      try {
        this.issueProviderFactory.attachData(resource);
        EList<EObject> _contents = resource.getContents();
        Iterable<JvmDeclaredType> _filter = Iterables.<JvmDeclaredType>filter(_contents, JvmDeclaredType.class);
        final JvmDeclaredType inferredType = IterableExtensions.<JvmDeclaredType>head(_filter);
        GeneratorConfig _get = this.generatorConfigProvider.get(inferredType);
        CharSequence javaCode = this.generator.generateType(inferredType, _get);
        CharSequence _postProcess = this.postProcessor.postProcess(null, javaCode);
        javaCode = _postProcess;
        String _string_1 = expected.toString();
        String _string_2 = javaCode.toString();
        Assert.assertEquals(_string_1, _string_2);
      } finally {
        this.issueProviderFactory.detachData(resource);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
