/**
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.quickfix;

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
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
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
public class RemoveUnnecessaryModifiersMultiQuickfixTest extends AbstractMultiQuickfixTest {
  private static final String MODEL_WITH_UNNECESSARY_MODIFIERS = new Function0<String>() {
    @Override
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package unnecessarymodifiers");
      _builder.newLine();
      _builder.append("public class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("private final val A = 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def public m() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Runnable {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("public override def run() {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("println(A)");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      return _builder.toString();
    }
  }.apply();
  
  @Override
  public String getFileName() {
    return "Foo";
  }
  
  @Override
  public IFile dslFile(final CharSequence content) {
    String _projectName = this.getProjectName();
    String _fileName = this.getFileName();
    String _plus = ("src/unnecessarymodifiers/" + _fileName);
    return super.dslFile(_projectName, _plus, this.getFileExtension(), content);
  }
  
  @Override
  public void setUp() throws Exception {
    super.setUp();
    WorkbenchTestHelper.createPluginProject(this.getProjectName());
  }
  
  @Test
  public void testRemoveUnnecessaryModifiersQuickfixXtend() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package unnecessarymodifiers");
    _builder.newLine();
    _builder.append("<0<public>0> class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<1<private>1> <2<final>2> val A = 1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <3<public>3> m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new Runnable {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<4<public>4> override <5<def>5> run() {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("println(A)");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("---------------------------------------------------");
    _builder.newLine();
    _builder.append("0: message=The public modifier is unnecessary on class Foo");
    _builder.newLine();
    _builder.append("1: message=The private modifier is unnecessary on field A");
    _builder.newLine();
    _builder.append("2: message=The final modifier is unnecessary on field A");
    _builder.newLine();
    _builder.append("3: message=The public modifier is unnecessary on method m");
    _builder.newLine();
    _builder.append("4: message=The public modifier is unnecessary on method run");
    _builder.newLine();
    _builder.append("5: message=The def modifier is unnecessary on method run");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package unnecessarymodifiers");
    _builder_1.newLine();
    _builder_1.append("class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("val A = 1");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def m() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("new Runnable {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("override run() {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t\t");
    _builder_1.append("println(A)");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("------------------");
    _builder_1.newLine();
    _builder_1.append("(no markers found)");
    _builder_1.newLine();
    this.testMultiQuickfix(RemoveUnnecessaryModifiersMultiQuickfixTest.MODEL_WITH_UNNECESSARY_MODIFIERS, _builder, _builder_1);
  }
  
  @Test
  public void testRemoveUnnecessaryModifiersQuickfixJava() {
    try {
      final XtextEditor xtextEditor = this.openEditor(this.dslFile(RemoveUnnecessaryModifiersMultiQuickfixTest.MODEL_WITH_UNNECESSARY_MODIFIERS));
      int _indexOf = RemoveUnnecessaryModifiersMultiQuickfixTest.MODEL_WITH_UNNECESSARY_MODIFIERS.indexOf("public");
      final int offset = (_indexOf + 1);
      final ICompletionProposal[] proposals = this.computeQuickAssistProposals(xtextEditor, offset);
      Assert.assertEquals(1, ((List<ICompletionProposal>)Conversions.doWrapArray(proposals)).size());
      final Function1<ICompletionProposal, Boolean> _function = (ICompletionProposal it) -> {
        return Boolean.valueOf((it instanceof QuickAssistCompletionProposal));
      };
      Assert.assertEquals(1, IterableExtensions.size(IterableExtensions.<ICompletionProposal>filter(((Iterable<ICompletionProposal>)Conversions.doWrapArray(proposals)), _function)));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
