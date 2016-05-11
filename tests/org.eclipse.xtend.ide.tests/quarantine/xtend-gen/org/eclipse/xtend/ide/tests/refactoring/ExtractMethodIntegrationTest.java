package org.eclipse.xtend.ide.tests.refactoring;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.internal.corext.refactoring.ParameterInfo;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.xtend.ide.refactoring.ExtractMethodRefactoring;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.ui.refactoring.ExpressionUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jan Koehnlein
 */
@SuppressWarnings("all")
public class ExtractMethodIntegrationTest extends AbstractXtendUITestCase {
  @Inject
  @Extension
  private WorkbenchTestHelper workbenchTestHelper;
  
  @Inject
  private Provider<ExtractMethodRefactoring> refactoringProvider;
  
  @Inject
  private ExpressionUtil util;
  
  @After
  public void tiraMiGiu() throws Exception {
    this.workbenchTestHelper.tearDown();
  }
  
  @Test
  public void testSimple() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("$val x = 1$");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("bar()");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("val x = 1");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void testStatic() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("$val x = 1$");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def static foo() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("bar()");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def static bar() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("val x = 1");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void testParameter() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val x = 1");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("$val y = x$");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("val x = 1");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("bar(x)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar(int x) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("val y = x");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void testReturnVariable() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("$var x = 1$");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val y = x");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
        it.setExplicitlyDeclareReturnType(true);
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("var x = bar()");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("val y = x");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def int bar() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("1");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void testReturnValue() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("$val x = 1$");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val y = x");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
        it.setExplicitlyDeclareReturnType(true);
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("val x = bar()");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("val y = x");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def int bar() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("1");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void testReturnStatements_0() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(int i) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("$switch i {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("case 0: return 0");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("switch i {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("case 2: return \'\'");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("case 3: return null");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}$");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
        it.setExplicitlyDeclareReturnType(true);
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo(int i) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("bar(i)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def Object bar(int i) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("switch i {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("case 0: return 0");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("switch i {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("case 2: return \'\'");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("case 3: return null");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void testReturnStatements_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(int i) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("switch i {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("case 0: return 0");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("$switch i {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("case 2: return \'\'");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("case 3: return null");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}$");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
        it.setExplicitlyDeclareReturnType(true);
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo(int i) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("switch i {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("case 0: return 0");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("bar(i)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def String bar(int i) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("switch i {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("case 2: return \'\'");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("case 3: return null");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void testVoidStatements() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(int x) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("$for (i : x..45) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("println(i)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}$");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
        it.setExplicitlyDeclareReturnType(true);
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo(int x) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("bar(x)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def void bar(int x) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("for (i : x..45) {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("println(i)");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void testClosure_0() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(String baz) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("newArrayList(baz).map$[toFirstUpper]$");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
        it.setExplicitlyDeclareReturnType(true);
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo(String baz) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("newArrayList(baz).map(bar())");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def (String)=>String bar() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("[toFirstUpper]");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void testClosure_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(String baz) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("newArrayList(baz).map$[x|x.toFirstUpper]$");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
        it.setExplicitlyDeclareReturnType(true);
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo(String baz) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("newArrayList(baz).map(bar())");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def (String)=>String bar() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("[x|x.toFirstUpper]");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void testClosure_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(String baz) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("newArrayList(baz).map$[String it|toFirstUpper]$");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
        it.setExplicitlyDeclareReturnType(true);
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo(String baz) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("newArrayList(baz).map(bar())");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def (String)=>String bar() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("[String it|toFirstUpper]");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void testClosure_3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(String baz) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("newArrayList(baz).map($String it|toFirstUpper$)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
        it.setExplicitlyDeclareReturnType(true);
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo(String baz) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("newArrayList(baz).map(bar())");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def (String)=>String bar() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("[String it|toFirstUpper]");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void testRenameParameter() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(int shrinkMe, int expandMe) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("$shrinkMe + expandMe - shrinkMe-  expandMe$");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
        List<ParameterInfo> _parameterInfos = it.getParameterInfos();
        ParameterInfo _get = _parameterInfos.get(0);
        _get.setNewName("s");
        List<ParameterInfo> _parameterInfos_1 = it.getParameterInfos();
        ParameterInfo _get_1 = _parameterInfos_1.get(1);
        _get_1.setNewName("expandMeMore");
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo(int shrinkMe, int expandMe) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("bar(shrinkMe, expandMe)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar(int s, int expandMeMore) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("s + expandMeMore - s-  expandMeMore");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void testSwapParameterNames() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(int i, int j) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("$i-j$");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
        List<ParameterInfo> _parameterInfos = it.getParameterInfos();
        ParameterInfo _get = _parameterInfos.get(0);
        _get.setNewName("j");
        List<ParameterInfo> _parameterInfos_1 = it.getParameterInfos();
        ParameterInfo _get_1 = _parameterInfos_1.get(1);
        _get_1.setNewName("i");
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo(int i, int j) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("bar(i, j)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar(int j, int i) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("j-i");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void testTypeParameter_0() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <T> foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("$<T>newArrayList$");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def <T> foo() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("bar()");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def <T> bar() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("<T>newArrayList");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void testTypeParameter_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <T, U> foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if(true) ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("$<T>newArrayList$");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("else");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<U>newArrayList");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def <T, U> foo() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("if(true) ");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("bar()");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("else");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("<U>newArrayList");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def <T> bar() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("<T>newArrayList");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void testTypeParameter_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <T, U> foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("$if(true) ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<T>newArrayList");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("else");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<U>newArrayList$");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def <T, U> foo() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("bar()");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def <T, U> bar() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("if(true) ");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("<T>newArrayList");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("else");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("<U>newArrayList");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void testFailOnMultipleCallins() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("$val x=42");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val y=42$");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("x+y");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
      }
    };
    this.assertExtractForbidden(_builder, _function, "ambiguous");
  }
  
  @Test
  public void testFailOnReturns() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("$if(true) ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("else ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("val y=42$");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("y");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
      }
    };
    this.assertExtractForbidden(_builder, _function, "control flow");
  }
  
  @Test
  public void testFailOnDuplicateMethodName() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("$val x = 4$");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
        it.setMethodName("foo");
      }
    };
    this.assertExtractForbidden(_builder, _function, "already defined");
  }
  
  @Test
  public void testFailOnDuplicateParameterName() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val x = 4");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val y = 2");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("$x+y$");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
        List<ParameterInfo> _parameterInfos = it.getParameterInfos();
        ParameterInfo _get = _parameterInfos.get(1);
        _get.setNewName("x");
      }
    };
    this.assertExtractForbidden(_builder, _function, "duplicate");
  }
  
  @Test
  public void testBug_404244() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("\"foo\".contains($\"my string\"$)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("\"foo\".contains(bar())");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("\"my string\"");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void testTemplateExpression_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() \'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("$Hello World!$");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo() \'");
    _builder_1.append("\'\'");
    _builder_1.append("«", "\t");
    _builder_1.append("bar()");
    _builder_1.append("»", "\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar()");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("Hello World!");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void testTemplateExpression_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(String value) \'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("$Hello ");
    _builder.append("«", "\t\t");
    _builder.append(" /* prefix */ value /* postfix */ ");
    _builder.append("»", "\t\t");
    _builder.append("!$");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("\'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo(String value) \'");
    _builder_1.append("\'\'");
    _builder_1.append("«", "\t");
    _builder_1.append("bar(value)");
    _builder_1.append("»", "\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar(String value)");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("Hello ");
    _builder_1.append("«", "\t\t\t");
    _builder_1.append(" /* prefix */ value /* postfix */ ");
    _builder_1.append("»", "\t\t\t");
    _builder_1.append("!");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void testTemplateExpression_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(String value) \'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("$Hello$ ");
    _builder.append("«", "\t\t");
    _builder.append(" /* prefix */ value /* postfix */ ");
    _builder.append("»", "\t\t");
    _builder.append("!");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("\'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo(String value) \'");
    _builder_1.append("\'\'");
    _builder_1.append("«", "\t");
    _builder_1.append("bar()");
    _builder_1.append("»", "\t");
    _builder_1.append("«", "\t");
    _builder_1.append(" /* prefix */ value /* postfix */ ");
    _builder_1.append("»", "\t");
    _builder_1.append("!");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar()");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("Hello \'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void testTemplateExpression_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(String value) \'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Hello ");
    _builder.append("«", "\t\t");
    _builder.append(" /* prefix */ value /* postfix */ ");
    _builder.append("»", "\t\t");
    _builder.append("$!$");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("\'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo(String value) \'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("Hello ");
    _builder_1.append("«", "\t\t");
    _builder_1.append(" /* prefix */ value /* postfix */ ");
    _builder_1.append("»", "\t\t");
    _builder_1.append("«", "\t\t");
    _builder_1.append("bar()");
    _builder_1.append("»", "\t\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar()");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'!");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void testTemplateExpression_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(String value) \'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Hello ");
    _builder.append("«", "\t\t");
    _builder.append("$ /* prefix */ value /* postfix */ $");
    _builder.append("»", "\t\t");
    _builder.append("!");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("\'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo(String value) \'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("Hello ");
    _builder_1.append("«", "\t\t");
    _builder_1.append("bar(value)");
    _builder_1.append("»", "\t\t");
    _builder_1.append("!");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar(String value) {");
    _builder_1.newLine();
    _builder_1.append("\t\t ");
    _builder_1.append("/* prefix */ value /* postfix */ ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void testTemplateExpression_06() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(String value) \'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Hello ");
    _builder.append("«", "\t\t");
    _builder.append("$ /* prefix */ value /* postfix */ ");
    _builder.append("»", "\t\t");
    _builder.append("$!");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("\'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo(String value) \'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("Hello ");
    _builder_1.append("«", "\t\t");
    _builder_1.append("bar(value)");
    _builder_1.append("»", "\t\t");
    _builder_1.append("!");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar(String value) {");
    _builder_1.newLine();
    _builder_1.append("\t\t ");
    _builder_1.append("/* prefix */ value /* postfix */ ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void testTemplateExpression_07() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(String value) \'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Hello $");
    _builder.append("«", "\t\t");
    _builder.append(" /* prefix */ value /* postfix */ $");
    _builder.append("»", "\t\t");
    _builder.append("!");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("\'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo(String value) \'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("Hello ");
    _builder_1.append("«", "\t\t");
    _builder_1.append("bar(value)");
    _builder_1.append("»", "\t\t");
    _builder_1.append("!");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar(String value) {");
    _builder_1.newLine();
    _builder_1.append("\t\t ");
    _builder_1.append("/* prefix */ value /* postfix */ ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void testTemplateExpression_08() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(String value) \'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Hello $");
    _builder.append("«", "\t\t");
    _builder.append(" /* prefix */ value /* postfix */ ");
    _builder.append("»", "\t\t");
    _builder.append("$!");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("\'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo(String value) \'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("Hello ");
    _builder_1.append("«", "\t\t");
    _builder_1.append("bar(value)");
    _builder_1.append("»", "\t\t");
    _builder_1.append("!");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar(String value) {");
    _builder_1.newLine();
    _builder_1.append("\t\t ");
    _builder_1.append("/* prefix */ value /* postfix */ ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void testTemplateExpression_09() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(String value) \'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("$Hello ");
    _builder.append("«", "\t\t");
    _builder.append(" /* prefix */ value /* postfix */ ");
    _builder.append("»", "\t\t");
    _builder.append("$!");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("\'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo(String value) \'");
    _builder_1.append("\'\'");
    _builder_1.append("«", "\t");
    _builder_1.append("bar(value)");
    _builder_1.append("»", "\t");
    _builder_1.append("!");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar(String value)");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("Hello ");
    _builder_1.append("«", "\t\t\t");
    _builder_1.append(" /* prefix */ value /* postfix */ ");
    _builder_1.append("»", "\t\t\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void testTemplateExpression_10() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(String value) \'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("$Hello ");
    _builder.append("«", "\t\t");
    _builder.append(" /* prefix */ value /* postfix */ $");
    _builder.append("»", "\t\t");
    _builder.append("!");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("\'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo(String value) \'");
    _builder_1.append("\'\'");
    _builder_1.append("«", "\t");
    _builder_1.append("bar(value)");
    _builder_1.append("»", "\t");
    _builder_1.append("!");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar(String value)");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("Hello ");
    _builder_1.append("«", "\t\t\t");
    _builder_1.append(" /* prefix */ value /* postfix */ ");
    _builder_1.append("»", "\t\t\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void testTemplateExpression_11() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(String value) \'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("$Hello ");
    _builder.append("«", "\t\t");
    _builder.append(" /* prefix */ val$ue /* postfix */ ");
    _builder.append("»", "\t\t");
    _builder.append("!");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("\'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo(String value) \'");
    _builder_1.append("\'\'");
    _builder_1.append("«", "\t");
    _builder_1.append("bar(value)");
    _builder_1.append("»", "\t");
    _builder_1.append("!");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar(String value)");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("Hello ");
    _builder_1.append("«", "\t\t\t");
    _builder_1.append(" /* prefix */ value /* postfix */ ");
    _builder_1.append("»", "\t\t\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void testTemplateExpression_12() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(String value) \'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("$Hello ");
    _builder.append("«", "\t\t");
    _builder.append("$ /* prefix */ value /* postfix */ ");
    _builder.append("»", "\t\t");
    _builder.append("!");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("\'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo(String value) \'");
    _builder_1.append("\'\'");
    _builder_1.append("«", "\t");
    _builder_1.append("bar(value)");
    _builder_1.append("»", "\t");
    _builder_1.append("!");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar(String value)");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("Hello ");
    _builder_1.append("«", "\t\t\t");
    _builder_1.append(" /* prefix */ value /* postfix */ ");
    _builder_1.append("»", "\t\t\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void testTemplateExpression_13() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(String value) \'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("$Hello $");
    _builder.append("«", "\t\t");
    _builder.append(" /* prefix */ value /* postfix */ ");
    _builder.append("»", "\t\t");
    _builder.append("!");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("\'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo(String value) \'");
    _builder_1.append("\'\'");
    _builder_1.append("«", "\t");
    _builder_1.append("bar()");
    _builder_1.append("»", "\t");
    _builder_1.append("«", "\t");
    _builder_1.append(" /* prefix */ value /* postfix */ ");
    _builder_1.append("»", "\t");
    _builder_1.append("!");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar()");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("Hello \'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void testTemplateExpression_14() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(String value) \'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Hello $");
    _builder.append("«", "\t\t");
    _builder.append(" /* prefix */ value /* postfix */ ");
    _builder.append("»", "\t\t");
    _builder.append("!$");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("\'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo(String value) \'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("Hello ");
    _builder_1.append("«", "\t\t");
    _builder_1.append("bar(value)");
    _builder_1.append("»", "\t\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar(String value)");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.append("«", "\t\t");
    _builder_1.append(" /* prefix */ value /* postfix */ ");
    _builder_1.append("»", "\t\t");
    _builder_1.append("!");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t\t\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void testTemplateExpression_15() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(String value) \'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Hello ");
    _builder.append("«", "\t\t");
    _builder.append("$ /* prefix */ value /* postfix */ ");
    _builder.append("»", "\t\t");
    _builder.append("!$");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("\'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo(String value) \'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("Hello ");
    _builder_1.append("«", "\t\t");
    _builder_1.append("bar(value)");
    _builder_1.append("»", "\t\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar(String value)");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.append("«", "\t\t");
    _builder_1.append(" /* prefix */ value /* postfix */ ");
    _builder_1.append("»", "\t\t");
    _builder_1.append("!");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t\t\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void testTemplateExpression_16() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(String value) \'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Hello ");
    _builder.append("«", "\t\t");
    _builder.append(" /* prefix */ va$lue /* postfix */ ");
    _builder.append("»", "\t\t");
    _builder.append("!$");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("\'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo(String value) \'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("Hello ");
    _builder_1.append("«", "\t\t");
    _builder_1.append("bar(value)");
    _builder_1.append("»", "\t\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar(String value)");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.append("«", "\t\t");
    _builder_1.append(" /* prefix */ value /* postfix */ ");
    _builder_1.append("»", "\t\t");
    _builder_1.append("!");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t\t\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void testTemplateExpression_17() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(String value) \'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Hello ");
    _builder.append("«", "\t\t");
    _builder.append(" /* prefix */ value /* postfix */ $");
    _builder.append("»", "\t\t");
    _builder.append("!$");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("\'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo(String value) \'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("Hello ");
    _builder_1.append("«", "\t\t");
    _builder_1.append("bar(value)");
    _builder_1.append("»", "\t\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar(String value)");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.append("«", "\t\t");
    _builder_1.append(" /* prefix */ value /* postfix */ ");
    _builder_1.append("»", "\t\t");
    _builder_1.append("!");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t\t\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void testTemplateExpression_18() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(int i) \'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("$");
    _builder.append("«", "\t\t");
    _builder.append("FOR j : 1 .. i");
    _builder.append("»", "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("«", "\t\t\t");
    _builder.append("j");
    _builder.append("»", "\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("«", "\t\t");
    _builder.append("ENDFOR");
    _builder.append("»", "\t\t");
    _builder.append("$");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("\'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo(int i) \'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("«", "\t\t");
    _builder_1.append("bar(i)");
    _builder_1.append("»", "\t\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar(int i)");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.append("«", "\t\t");
    _builder_1.append("FOR j : 1 .. i");
    _builder_1.append("»", "\t\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t\t\t");
    _builder_1.append("«", "\t\t\t");
    _builder_1.append("j»");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t\t");
    _builder_1.append("«", "\t\t");
    _builder_1.append("ENDFOR");
    _builder_1.append("»", "\t\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void testTemplateExpression_19() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(boolean a) \'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("$");
    _builder.append("«", "\t\t");
    _builder.append("IF a");
    _builder.append("»", "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("«", "\t\t\t");
    _builder.append("1");
    _builder.append("»", "\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("«", "\t\t");
    _builder.append("ELSE");
    _builder.append("»", "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("«", "\t\t\t");
    _builder.append("2");
    _builder.append("»", "\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("«", "\t\t");
    _builder.append("ENDIF");
    _builder.append("»", "\t\t");
    _builder.append("$");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("\'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo(boolean a) \'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("«", "\t\t");
    _builder_1.append("bar(a)");
    _builder_1.append("»", "\t\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar(boolean a)");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.append("«", "\t\t");
    _builder_1.append("IF a");
    _builder_1.append("»", "\t\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t\t\t");
    _builder_1.append("«", "\t\t\t");
    _builder_1.append("1");
    _builder_1.append("»", "\t\t\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t\t");
    _builder_1.append("«", "\t\t");
    _builder_1.append("ELSE");
    _builder_1.append("»", "\t\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t\t\t");
    _builder_1.append("«", "\t\t\t");
    _builder_1.append("2");
    _builder_1.append("»", "\t\t\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t\t");
    _builder_1.append("«", "\t\t");
    _builder_1.append("ENDIF");
    _builder_1.append("»", "\t\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void testTemplateExpression_20() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(int i) \'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("«", "\t\t");
    _builder.append("FOR j : 1 .. i");
    _builder.append("»", "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("$x   ");
    _builder.append("«", "\t\t\t");
    _builder.append("j");
    _builder.append("»", "\t\t\t");
    _builder.append("$");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("«", "\t\t");
    _builder.append("ENDFOR");
    _builder.append("»", "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("\'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo(int i) \'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("«", "\t\t");
    _builder_1.append("FOR j : 1 .. i");
    _builder_1.append("»", "\t\t");
    _builder_1.append("«", "\t\t");
    _builder_1.append("bar(j)");
    _builder_1.append("»", "\t\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t\t");
    _builder_1.append("«", "\t\t");
    _builder_1.append("ENDFOR");
    _builder_1.append("»", "\t\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar(Integer j)");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("x   ");
    _builder_1.append("«", "\t\t\t");
    _builder_1.append("j");
    _builder_1.append("»", "\t\t\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void testTemplateExpression_21() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(int i) \'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("«", "\t\t");
    _builder.append("FOR j : 1 .. i");
    _builder.append("»", "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("$x   ");
    _builder.append("«", "\t\t\t");
    _builder.append("j");
    _builder.append("»", "\t\t\t");
    _builder.append("$");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("«", "\t\t");
    _builder.append(" /* lalala */ ENDFOR");
    _builder.append("»", "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("\'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo(int i) \'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("«", "\t\t");
    _builder_1.append("FOR j : 1 .. i");
    _builder_1.append("»", "\t\t");
    _builder_1.append("«", "\t\t");
    _builder_1.append("bar(j)");
    _builder_1.append("»", "\t\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t\t");
    _builder_1.append("«", "\t\t");
    _builder_1.append(" /* lalala */ ENDFOR");
    _builder_1.append("»", "\t\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar(Integer j)");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("x   ");
    _builder_1.append("«", "\t\t\t");
    _builder_1.append("j");
    _builder_1.append("»", "\t\t\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void testTemplateExpression_22() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(boolean a) \'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("«", "\t\t");
    _builder.append("IF a");
    _builder.append("»", "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("$x\t");
    _builder.append("«", "\t\t");
    _builder.append("1");
    _builder.append("»", "\t\t");
    _builder.append("$");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("«", "\t\t");
    _builder.append(" /* lalala */ ENDIF");
    _builder.append("»", "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("\'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo(boolean a) \'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("«", "\t\t");
    _builder_1.append("IF a");
    _builder_1.append("»", "\t\t");
    _builder_1.append("«", "\t\t");
    _builder_1.append("bar()");
    _builder_1.append("»", "\t\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t\t");
    _builder_1.append("«", "\t\t");
    _builder_1.append(" /* lalala */ ENDIF");
    _builder_1.append("»", "\t\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar()");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("x\t");
    _builder_1.append("«", "\t\t");
    _builder_1.append("1");
    _builder_1.append("»", "\t\t");
    _builder_1.append("\'");
    _builder_1.append("\'\'");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void test_Bug_453376() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("$var x = 1$");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("var z = x");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("var y = x");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("var x = bar()");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("var z = x");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("var y = x");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("1");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void test_Bug_453376_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("$val x = 1$");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("bar()");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("val x = 1");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  @Test
  public void test_Bug_453376_3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val x = $1$");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<ExtractMethodRefactoring> _function = new Procedure1<ExtractMethodRefactoring>() {
      @Override
      public void apply(final ExtractMethodRefactoring it) {
      }
    };
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def foo() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("val x = bar()");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("1");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _function, _builder_1);
  }
  
  protected void assertAfterExtract(final CharSequence input, final Procedure1<? super ExtractMethodRefactoring> initializer, final CharSequence expected) {
    try {
      final String inputString = input.toString();
      String _replace = inputString.replace("$", "");
      final IFile file = this.workbenchTestHelper.createFile("Foo", _replace);
      final XtextEditor editor = this.workbenchTestHelper.openEditor(file);
      try {
        IXtextDocument _document = editor.getDocument();
        final IUnitOfWork<Change, XtextResource> _function = new IUnitOfWork<Change, XtextResource>() {
          @Override
          public Change exec(final XtextResource it) throws Exception {
            Change _xblockexpression = null;
            {
              int _indexOf = inputString.indexOf("$");
              int _lastIndexOf = inputString.lastIndexOf("$");
              int _indexOf_1 = inputString.indexOf("$");
              int _minus = (_lastIndexOf - _indexOf_1);
              int _minus_1 = (_minus - 1);
              TextSelection _textSelection = new TextSelection(_indexOf, _minus_1);
              final List<XExpression> selection = ExtractMethodIntegrationTest.this.util.findSelectedSiblingExpressions(it, _textSelection);
              final ExtractMethodRefactoring refactoring = ExtractMethodIntegrationTest.this.refactoringProvider.get();
              refactoring.initialize(editor, selection, true);
              refactoring.setExplicitlyDeclareReturnType(false);
              refactoring.setVisibility(JvmVisibility.PUBLIC);
              refactoring.setMethodName("bar");
              NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
              RefactoringStatus status = refactoring.checkInitialConditions(_nullProgressMonitor);
              String _string = status.toString();
              boolean _isOK = status.isOK();
              Assert.assertTrue(_string, _isOK);
              initializer.apply(refactoring);
              NullProgressMonitor _nullProgressMonitor_1 = new NullProgressMonitor();
              RefactoringStatus _checkFinalConditions = refactoring.checkFinalConditions(_nullProgressMonitor_1);
              status = _checkFinalConditions;
              String _string_1 = status.toString();
              boolean _isOK_1 = status.isOK();
              Assert.assertTrue(_string_1, _isOK_1);
              NullProgressMonitor _nullProgressMonitor_2 = new NullProgressMonitor();
              Change _createChange = refactoring.createChange(_nullProgressMonitor_2);
              NullProgressMonitor _nullProgressMonitor_3 = new NullProgressMonitor();
              _xblockexpression = _createChange.perform(_nullProgressMonitor_3);
            }
            return _xblockexpression;
          }
        };
        _document.<Change>readOnly(_function);
        String _string = expected.toString();
        IXtextDocument _document_1 = editor.getDocument();
        String _get = _document_1.get();
        Assert.assertEquals(_string, _get);
      } finally {
        editor.close(false);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void assertExtractForbidden(final CharSequence input, final Procedure1<? super ExtractMethodRefactoring> initializer, final String messageFragment) {
    try {
      final String inputString = input.toString();
      String _replace = inputString.replace("$", "");
      final IFile file = this.workbenchTestHelper.createFile("Foo", _replace);
      final XtextEditor editor = this.workbenchTestHelper.openEditor(file);
      try {
        IXtextDocument _document = editor.getDocument();
        final IUnitOfWork<String, XtextResource> _function = new IUnitOfWork<String, XtextResource>() {
          @Override
          public String exec(final XtextResource it) throws Exception {
            String _xblockexpression = null;
            {
              int _indexOf = inputString.indexOf("$");
              int _lastIndexOf = inputString.lastIndexOf("$");
              int _indexOf_1 = inputString.indexOf("$");
              int _minus = (_lastIndexOf - _indexOf_1);
              int _minus_1 = (_minus - 1);
              TextSelection _textSelection = new TextSelection(_indexOf, _minus_1);
              final List<XExpression> selection = ExtractMethodIntegrationTest.this.util.findSelectedSiblingExpressions(it, _textSelection);
              final ExtractMethodRefactoring refactoring = ExtractMethodIntegrationTest.this.refactoringProvider.get();
              refactoring.initialize(editor, selection, true);
              refactoring.setMethodName("bar");
              NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
              final RefactoringStatus status = refactoring.checkInitialConditions(_nullProgressMonitor);
              initializer.apply(refactoring);
              NullProgressMonitor _nullProgressMonitor_1 = new NullProgressMonitor();
              RefactoringStatus _checkFinalConditions = refactoring.checkFinalConditions(_nullProgressMonitor_1);
              status.merge(_checkFinalConditions);
              String _string = status.toString();
              boolean _hasError = status.hasError();
              Assert.assertTrue(_string, _hasError);
              final String message = status.getMessageMatchingSeverity(RefactoringStatus.ERROR);
              String _lowerCase = message.toLowerCase();
              String _lowerCase_1 = messageFragment.toLowerCase();
              boolean _contains = _lowerCase.contains(_lowerCase_1);
              Assert.assertTrue(message, _contains);
              _xblockexpression = "";
            }
            return _xblockexpression;
          }
        };
        _document.<String>readOnly(_function);
      } finally {
        editor.close(false);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
