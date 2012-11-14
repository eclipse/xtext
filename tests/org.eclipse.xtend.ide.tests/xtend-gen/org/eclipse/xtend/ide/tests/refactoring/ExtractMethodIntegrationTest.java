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
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
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
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def int bar() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("var x = 1");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("x");
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
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def int bar() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("val x = 1");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("x");
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
        public void apply(final ExtractMethodRefactoring it) {
          List<ParameterInfo> _parameterInfos = it.getParameterInfos();
          ParameterInfo _get = _parameterInfos.get(1);
          _get.setNewName("x");
        }
      };
    this.assertExtractForbidden(_builder, _function, "duplicate");
  }
  
  protected void assertAfterExtract(final CharSequence input, final Procedure1<? super ExtractMethodRefactoring> initializer, final CharSequence expected) {
    try {
      final String inputString = input.toString();
      String _replace = inputString.replace("$", "");
      final IFile file = this.workbenchTestHelper.createFile("Foo", _replace);
      final XtextEditor editor = this.workbenchTestHelper.openEditor(file);
      try {
        IXtextDocument _document = editor.getDocument();
        final Function1<XtextResource,Change> _function = new Function1<XtextResource,Change>() {
            public Change apply(final XtextResource it) {
              try {
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
                  IXtextDocument _document = editor.getDocument();
                  refactoring.initialize(_document, selection);
                  refactoring.setMethodName("bar");
                  initializer.apply(refactoring);
                  NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
                  final RefactoringStatus status = refactoring.checkAllConditions(_nullProgressMonitor);
                  String _string = status.toString();
                  boolean _isOK = status.isOK();
                  Assert.assertTrue(_string, _isOK);
                  NullProgressMonitor _nullProgressMonitor_1 = new NullProgressMonitor();
                  Change _createChange = refactoring.createChange(_nullProgressMonitor_1);
                  NullProgressMonitor _nullProgressMonitor_2 = new NullProgressMonitor();
                  Change _perform = _createChange.perform(_nullProgressMonitor_2);
                  _xblockexpression = (_perform);
                }
                return _xblockexpression;
              } catch (Exception _e) {
                throw Exceptions.sneakyThrow(_e);
              }
            }
          };
        _document.<Change>readOnly(new IUnitOfWork<Change,XtextResource>() {
            public Change exec(XtextResource state) {
              return _function.apply(state);
            }
        });
        String _string = expected.toString();
        IXtextDocument _document_1 = editor.getDocument();
        String _get = _document_1.get();
        Assert.assertEquals(_string, _get);
      } finally {
        editor.close(false);
      }
    } catch (Exception _e) {
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
        final Function1<XtextResource,String> _function = new Function1<XtextResource,String>() {
            public String apply(final XtextResource it) {
              try {
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
                  IXtextDocument _document = editor.getDocument();
                  refactoring.initialize(_document, selection);
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
                  _xblockexpression = ("");
                }
                return _xblockexpression;
              } catch (Exception _e) {
                throw Exceptions.sneakyThrow(_e);
              }
            }
          };
        _document.<String>readOnly(new IUnitOfWork<String,XtextResource>() {
            public String exec(XtextResource state) {
              return _function.apply(state);
            }
        });
      } finally {
        editor.close(false);
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
