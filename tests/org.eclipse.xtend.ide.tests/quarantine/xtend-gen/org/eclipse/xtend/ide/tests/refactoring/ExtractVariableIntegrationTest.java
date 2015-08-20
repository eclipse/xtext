package org.eclipse.xtend.ide.tests.refactoring;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.ui.refactoring.ExpressionUtil;
import org.eclipse.xtext.xbase.ui.refactoring.ExtractVariableRefactoring;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class ExtractVariableIntegrationTest extends AbstractXtendUITestCase {
  @Inject
  @Extension
  private WorkbenchTestHelper workbenchTestHelper;
  
  @Inject
  private Provider<ExtractVariableRefactoring> refactoringProvider;
  
  @Inject
  private ExpressionUtil util;
  
  @After
  public void tiraMiGiu() throws Exception {
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
    _builder.append("def getFoo(String x) {");
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
    _builder_1.append("val foo = getFoo(\'bar\')");
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
    _builder_1.append("def getFoo(String x) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("x");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _builder_1, true);
  }
  
  @Test
  public void testTypeName() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Date");
    _builder.newLine();
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
  
  @Test
  public void testClosureBody() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("newArrayList(\'jan\',\'hein\',\'claas\',\'pit\').map[");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("$toFirstUpper$");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("]");
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
    _builder_1.append("newArrayList(\'jan\',\'hein\',\'claas\',\'pit\').map[");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("val toFirstUpper2 = toFirstUpper");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("toFirstUpper2");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("]");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _builder_1, true);
  }
  
  @Test
  public void testClosure() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("newArrayList(\'jan\',\'hein\',\'claas\',\'pit\').map[$toFirstUpper]$");
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
    _builder_1.append("val function = [String it | toFirstUpper]");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("newArrayList(\'jan\',\'hein\',\'claas\',\'pit\').map(function)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _builder_1, true);
  }
  
  @Test
  public void testClosure_1() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("newArrayList(\'jan\',\'hein\',\'claas\',\'pit\').map[$it|toFirstUpper]$");
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
    _builder_1.append("val function = [String it | toFirstUpper]");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("newArrayList(\'jan\',\'hein\',\'claas\',\'pit\').map(function)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _builder_1, true);
  }
  
  @Test
  public void testClosure_2() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("newArrayList(\'jan\',\'hein\',\'claas\',\'pit\').map[$String it|toFirstUpper]$");
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
    _builder_1.append("val function = [String it | toFirstUpper]");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("newArrayList(\'jan\',\'hein\',\'claas\',\'pit\').map(function)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _builder_1, true);
  }
  
  @Test
  public void testClosure_3() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("newArrayList(\'jan\',\'hein\',\'claas\',\'pit\').map($String it|toFirstUpper$)");
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
    _builder_1.append("val function = [String it | toFirstUpper]");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("newArrayList(\'jan\',\'hein\',\'claas\',\'pit\').map(function)");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _builder_1, true);
  }
  
  @Test
  public void testList() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("$#[\'\']$");
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
    _builder_1.append("val strings = #[\'\']");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("strings");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _builder_1, true);
  }
  
  @Test
  public void testSet() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("$#{\'\'}$");
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
    _builder_1.append("val strings = #{\'\'}");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("strings");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _builder_1, true);
  }
  
  @Test
  public void testMap() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("$#{\'\'->\'\'}$");
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
    _builder_1.append("val map = #{\'\'->\'\'}");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("map");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _builder_1, true);
  }
  
  @Test
  public void testArray_0() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("$null as String[]$");
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
    _builder_1.append("val strings = null as String[]");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("strings");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _builder_1, true);
  }
  
  @Test
  public void testArray_1() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("$null as int[]$");
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
    _builder_1.append("val is = null as int[]");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("is");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _builder_1, true);
  }
  
  @Test
  public void testArray_2() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("$null as List<String>[]$");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.List");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("val strings = null as List<String>[]");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("strings");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertAfterExtract(_builder, _builder_1, true);
  }
  
  @Test
  public void testArray_3() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("$null as String[][]$");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.List");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def bar() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("val strings = null as String[][]");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("strings");
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
      final String model = inputString.replace("$", "");
      final IFile file = this.workbenchTestHelper.createFile("Foo", model);
      final XtextEditor editor = this.workbenchTestHelper.openEditor(file);
      try {
        IXtextDocument _document = editor.getDocument();
        final IUnitOfWork<Change, XtextResource> _function = new IUnitOfWork<Change, XtextResource>() {
          @Override
          public Change exec(final XtextResource it) throws Exception {
            Change _xblockexpression = null;
            {
              final int offset = inputString.indexOf("$");
              int _lastIndexOf = inputString.lastIndexOf("$");
              int _minus = (_lastIndexOf - 1);
              final int length = (_minus - offset);
              final TextSelection textSelection = new TextSelection(offset, length);
              final XExpression selection = ExtractVariableIntegrationTest.this.util.findSelectedExpression(it, textSelection);
              final ExtractVariableRefactoring refactoring = ExtractVariableIntegrationTest.this.refactoringProvider.get();
              refactoring.setFinal(isFinal);
              refactoring.initialize(editor, selection);
              NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
              final RefactoringStatus status = refactoring.checkAllConditions(_nullProgressMonitor);
              String _string = status.toString();
              boolean _isOK = status.isOK();
              Assert.assertTrue(_string, _isOK);
              NullProgressMonitor _nullProgressMonitor_1 = new NullProgressMonitor();
              Change _createChange = refactoring.createChange(_nullProgressMonitor_1);
              NullProgressMonitor _nullProgressMonitor_2 = new NullProgressMonitor();
              _xblockexpression = _createChange.perform(_nullProgressMonitor_2);
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
}
