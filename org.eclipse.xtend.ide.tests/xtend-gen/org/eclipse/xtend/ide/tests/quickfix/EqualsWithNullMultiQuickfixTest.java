/**
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.quickfix;

import com.google.common.collect.Iterables;
import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend.ide.tests.XtendIDEInjectorProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.quickfix.QuickAssistCompletionProposal;
import org.eclipse.xtext.ui.testing.AbstractMultiQuickfixTest;
import org.eclipse.xtext.ui.testing.util.TargetPlatformUtil;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Aaron R Miller - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XtendIDEInjectorProvider.class)
@SuppressWarnings("all")
public class EqualsWithNullMultiQuickfixTest extends AbstractMultiQuickfixTest {
  @Test
  public void equals_with_null_in_expression() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package equalsnull");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m(Object a, Object b, Object c) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if(a == null || b != null || c === null) 0 else 1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package equalsnull");
    _builder_1.newLine();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def m(Object a, Object b, Object c) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("if(a <0<==>0> null || b <1<!=>1> null || c === null) 0 else 1");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("-----");
    _builder_1.newLine();
    _builder_1.append("0: message=The operator \'==\' should be replaced by \'===\' when null is one of the arguments.");
    _builder_1.newLine();
    _builder_1.append("1: message=The operator \'!=\' should be replaced by \'!==\' when null is one of the arguments.");
    _builder_1.newLine();
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("package equalsnull");
    _builder_2.newLine();
    _builder_2.append("class Foo {");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("def m(Object a, Object b, Object c) {");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("if(a === null || b !== null || c === null) 0 else 1");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("-----");
    _builder_2.newLine();
    _builder_2.append("(no markers found)");
    _builder_2.newLine();
    this.testMultiQuickfix(_builder, _builder_1, _builder_2);
  }

  @Test
  public void equals_with_null_in_switch() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package equalsnull");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def m(Object a, Object b, Object c) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("switch true {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("case a == null: 0");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("case b != null: 0");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("case c === null: 0");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("default: 1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String model = _builder.toString();
      final XtextEditor xtextEditor = this.openEditor(this.dslFile(model));
      int _indexOf = model.indexOf("==");
      final int offset = (_indexOf + 1);
      final ICompletionProposal[] proposals = this.computeQuickAssistProposals(xtextEditor, offset);
      Assert.assertEquals(1, ((List<ICompletionProposal>)Conversions.doWrapArray(proposals)).size());
      Assert.assertEquals(1, IterableExtensions.size(Iterables.<QuickAssistCompletionProposal>filter(((Iterable<?>)Conversions.doWrapArray(proposals)), QuickAssistCompletionProposal.class)));
      Assert.assertEquals("Replace \'==\' with \'===\' and \'!=\' with \'!==\'", IterableExtensions.<ICompletionProposal>head(((Iterable<ICompletionProposal>)Conversions.doWrapArray(proposals))).getDisplayString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Override
  public void setUp() {
    try {
      super.setUp();
      TargetPlatformUtil.setTargetPlatform(EqualsWithNullMultiQuickfixTest.class);
      WorkbenchTestHelper.createPluginProject(this.getProjectName());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Override
  public String getFileName() {
    return "Foo";
  }

  @Override
  public IFile dslFile(final CharSequence content) {
    String _projectName = this.getProjectName();
    String _fileName = this.getFileName();
    String _plus = ("src/equalsnull/" + _fileName);
    return super.dslFile(_projectName, _plus, this.getFileExtension(), content);
  }
}
