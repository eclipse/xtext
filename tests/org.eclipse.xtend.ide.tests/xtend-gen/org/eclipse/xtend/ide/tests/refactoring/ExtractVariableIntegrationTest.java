package org.eclipse.xtend.ide.tests.refactoring;

import com.google.inject.Provider;
import javax.inject.Inject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.ltk.core.refactoring.Change;
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
import org.eclipse.xtext.xbase.ui.refactoring.ExpressionUtil;
import org.eclipse.xtext.xbase.ui.refactoring.ExtractVariableRefactoring;
import org.junit.After;
import org.junit.Test;

@SuppressWarnings("all")
public class ExtractVariableIntegrationTest extends AbstractXtendUITestCase {
  @Inject
  private WorkbenchTestHelper workbenchTestHelper;
  
  @Inject
  private Provider<ExtractVariableRefactoring> refactoringProvider;
  
  @Inject
  private ExpressionUtil util;
  
  @After
  public void myTearDown() throws Exception {
    this.workbenchTestHelper.tearDown();
  }
  
  @Test
  public void testValInBlock() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("22 + $33$");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("val i = 33");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("22 + i");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _builder_1, true);
  }
  
  @Test
  public void testVarInBlock() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("22 + $33$");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("var i = 33");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("22 + i");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _builder_1, false);
  }
  
  @Test
  public void testInsertBlock() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if(true)");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("22 + $33$");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("if(true) {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("val i = 33");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("22 + i");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _builder_1, true);
  }
  
  @Test
  public void testGoUpControlStructure() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if($true$)");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("22 + 33");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("var b = true");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("if(b)");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("22 + 33");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _builder_1, false);
  }
  
  @Test
  public void testGetterName() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("$getFoo(\'bar\')$");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def getFoo(String x)\u00A0{");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("x");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("foo = getFoo(\'bar\')");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("foo");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def getFoo(String x)\u00A0{");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("x");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _builder_1, true);
  }
  
  @Test
  public void testTypeName() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Date");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("$new Date()$");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.Date");
    _builder_1.newLine();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("val date = new Date()");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("date");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _builder_1, true);
  }
  
  protected void assertAfterExtract(final CharSequence input, final CharSequence expected, final boolean isFinal) {
    try {
      final String inputString = input.toString();
      String _replace = inputString.replace("$", "");
      final XtextEditor editor = this.workbenchTestHelper.openEditor("Foo", _replace);
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
                final XExpression selection = ExtractVariableIntegrationTest.this.util.findSelectedExpression(it, _textSelection);
                final ExtractVariableRefactoring refactoring = ExtractVariableIntegrationTest.this.refactoringProvider.get();
                refactoring.setFinal(isFinal);
                IXtextDocument _document = editor.getDocument();
                refactoring.initialize(_document, selection);
                NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
                refactoring.checkAllConditions(_nullProgressMonitor);
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
      editor.close(false);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
