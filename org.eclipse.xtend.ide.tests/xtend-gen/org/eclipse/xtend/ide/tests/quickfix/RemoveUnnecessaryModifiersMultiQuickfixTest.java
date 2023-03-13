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
import java.util.function.Consumer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend.ide.tests.XtendIDEInjectorProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.quickfix.QuickAssistCompletionProposal;
import org.eclipse.xtext.ui.testing.AbstractMultiQuickfixTest;
import org.eclipse.xtext.ui.testing.AbstractWorkbenchTest;
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
public class RemoveUnnecessaryModifiersMultiQuickfixTest extends AbstractMultiQuickfixTest {
  @Test
  public void remove_unnecessary_modifiers001() {
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
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package unnecessarymodifiers");
    _builder_1.newLine();
    _builder_1.append("<0<public>0> class Foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("<1<private>1> <2<final>2> val A = 1");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def <3<public>3> m() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("new Runnable {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("<4<public>4> override <5<def>5> run() {");
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
    _builder_1.append("-----");
    _builder_1.newLine();
    _builder_1.append("0: message=The public modifier is unnecessary on class Foo");
    _builder_1.newLine();
    _builder_1.append("1: message=The private modifier is unnecessary on field A");
    _builder_1.newLine();
    _builder_1.append("2: message=The final modifier is unnecessary on field A");
    _builder_1.newLine();
    _builder_1.append("3: message=The public modifier is unnecessary on method m");
    _builder_1.newLine();
    _builder_1.append("4: message=The public modifier is unnecessary on method run");
    _builder_1.newLine();
    _builder_1.append("5: message=The def modifier is unnecessary on method run");
    _builder_1.newLine();
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("package unnecessarymodifiers");
    _builder_2.newLine();
    _builder_2.append("class Foo {");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("val A = 1");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("def m() {");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("new Runnable {");
    _builder_2.newLine();
    _builder_2.append("\t\t\t");
    _builder_2.append("override run() {");
    _builder_2.newLine();
    _builder_2.append("\t\t\t\t");
    _builder_2.append("println(A)");
    _builder_2.newLine();
    _builder_2.append("\t\t\t");
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("}");
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
  public void remove_unnecessary_modifiers002() {
    try {
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
      final String model = _builder.toString();
      final XtextEditor xtextEditor = this.openEditor(this.dslFile(model));
      int _indexOf = model.indexOf("public");
      final int offset = (_indexOf + 1);
      final ICompletionProposal[] proposals = this.computeQuickAssistProposals(xtextEditor, offset);
      Assert.assertEquals(1, ((List<ICompletionProposal>)Conversions.doWrapArray(proposals)).size());
      Assert.assertEquals(1, IterableExtensions.size(Iterables.<QuickAssistCompletionProposal>filter(((Iterable<?>)Conversions.doWrapArray(proposals)), QuickAssistCompletionProposal.class)));
      Assert.assertEquals("Remove the unnecessary modifier.", IterableExtensions.<ICompletionProposal>head(((Iterable<ICompletionProposal>)Conversions.doWrapArray(proposals))).getDisplayString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Override
  public void setUp() {
    try {
      super.setUp();
      TargetPlatformUtil.setTargetPlatform(RemoveUnnecessaryModifiersMultiQuickfixTest.class);
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
    String _plus = ("src/unnecessarymodifiers/" + _fileName);
    return super.dslFile(_projectName, _plus, this.getFileExtension(), content);
  }

  @Override
  protected IMarker[] getMarkers(final IFile file) {
    IMarker[] _xblockexpression = null;
    {
      this.saveAllOpenEditors();
      _xblockexpression = super.getMarkers(file);
    }
    return _xblockexpression;
  }

  private void saveAllOpenEditors() {
    final Consumer<IEditorReference> _function = (IEditorReference it) -> {
      IEditorPart _editor = it.getEditor(false);
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      _editor.doSave(_nullProgressMonitor);
    };
    ((List<IEditorReference>)Conversions.doWrapArray(AbstractWorkbenchTest.getActivePage().getEditorReferences())).forEach(_function);
  }
}
