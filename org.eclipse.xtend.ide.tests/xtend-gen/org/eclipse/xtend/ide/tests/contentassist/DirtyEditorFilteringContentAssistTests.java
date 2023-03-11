/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.contentassist;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Holger Schill - Initial contribution and API
 */
@SuppressWarnings("all")
public class DirtyEditorFilteringContentAssistTests extends AbstractXtendUITestCase {
  @Inject
  @Extension
  private WorkbenchTestHelper _workbenchTestHelper;

  @Inject
  private SyncUtil syncUtil;

  @Before
  public void start() {
    try {
      this._workbenchTestHelper.closeWelcomePage();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @After
  public void close() {
    try {
      this._workbenchTestHelper.tearDown();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testFilteringExtends() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.append("class MyDirtyType {}");
      _builder.newLine();
      final XtextEditor fooEditor = this._workbenchTestHelper.openEditor("foo/Foo.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package foo");
      _builder_1.newLine();
      _builder_1.append("class Client extends MyDirtyType|{");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final String clientModel = _builder_1.toString();
      IResourcesSetupUtil.waitForBuild();
      final XtextEditor clientEditor = this._workbenchTestHelper.openEditor("foo/Client.xtend", clientModel);
      IXtextDocument _document = fooEditor.getDocument();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package foo");
      _builder_2.newLine();
      _builder_2.append("class MyDirtyType2 {}");
      _builder_2.newLine();
      _document.set(_builder_2.toString());
      final ICompletionProposal[] proposals = this.computeCompletionProposals(clientEditor, fooEditor, clientModel.indexOf("|"));
      Assert.assertEquals(1, ((List<ICompletionProposal>)Conversions.doWrapArray(proposals)).size());
      final Function1<ICompletionProposal, Boolean> _function = (ICompletionProposal e) -> {
        return Boolean.valueOf(e.toString().startsWith("Proposal: MyDirtyType - "));
      };
      boolean _exists = IterableExtensions.<ICompletionProposal>exists(((Iterable<ICompletionProposal>)Conversions.doWrapArray(proposals)), _function);
      boolean _not = (!_exists);
      Assert.assertTrue(_not);
      final Function1<ICompletionProposal, Boolean> _function_1 = (ICompletionProposal e) -> {
        return Boolean.valueOf(e.toString().startsWith("Proposal: MyDirtyType2 - "));
      };
      Assert.assertTrue(IterableExtensions.<ICompletionProposal>exists(((Iterable<ICompletionProposal>)Conversions.doWrapArray(proposals)), _function_1));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testFilteringConstructor() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.append("class MyDirtyType {}");
      _builder.newLine();
      final XtextEditor fooEditor = this._workbenchTestHelper.openEditor("foo/Foo.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package foo");
      _builder_1.newLine();
      _builder_1.append("class Client {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def foo(){");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("new MyDirtyType|");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final String clientModel = _builder_1.toString();
      IResourcesSetupUtil.waitForBuild();
      final XtextEditor clientEditor = this._workbenchTestHelper.openEditor("foo/Client.xtend", clientModel);
      IXtextDocument _document = fooEditor.getDocument();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package foo");
      _builder_2.newLine();
      _builder_2.append("class MyDirtyType2 {}");
      _builder_2.newLine();
      _document.set(_builder_2.toString());
      final ICompletionProposal[] proposals = this.computeCompletionProposals(clientEditor, fooEditor, clientModel.indexOf("|"));
      final Function1<ICompletionProposal, Boolean> _function = (ICompletionProposal e) -> {
        return Boolean.valueOf(e.toString().startsWith("Proposal: MyDirtyType - "));
      };
      boolean _exists = IterableExtensions.<ICompletionProposal>exists(((Iterable<ICompletionProposal>)Conversions.doWrapArray(proposals)), _function);
      boolean _not = (!_exists);
      Assert.assertTrue(_not);
      final Function1<ICompletionProposal, Boolean> _function_1 = (ICompletionProposal e) -> {
        return Boolean.valueOf(e.toString().startsWith("Proposal: MyDirtyType2 - "));
      };
      Assert.assertTrue(IterableExtensions.<ICompletionProposal>exists(((Iterable<ICompletionProposal>)Conversions.doWrapArray(proposals)), _function_1));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  public ICompletionProposal[] computeCompletionProposals(final XtextEditor editorForCompletion, final XtextEditor dirtyEditor, final int cursorPosition) throws BadLocationException {
    this.syncUtil.waitForReconciler(dirtyEditor);
    final ISourceViewer sourceViewer = editorForCompletion.getInternalSourceViewer();
    final IContentAssistant contentAssistant = editorForCompletion.getXtextSourceViewerConfiguration().getContentAssistant(sourceViewer);
    final String contentType = editorForCompletion.getDocument().getContentType(cursorPosition);
    final IContentAssistProcessor processor = contentAssistant.getContentAssistProcessor(contentType);
    if ((processor != null)) {
      return processor.computeCompletionProposals(sourceViewer, cursorPosition);
    }
    return null;
  }
}
