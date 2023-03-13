/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.imports;

import com.google.inject.Inject;
import org.eclipse.jface.text.ITextViewerExtension6;
import org.eclipse.jface.text.IUndoManager;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.ui.imports.OrganizeImportsHandler;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class UndoTest extends AbstractXtendUITestCase {
  @Inject
  @Extension
  private WorkbenchTestHelper _workbenchTestHelper;

  @Inject
  @Extension
  private OrganizeImportsHandler _organizeImportsHandler;

  @Test
  public void testUndo() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val java.lang.String x");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val java.util.ArrayList<String> y");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtextEditor editor = this._workbenchTestHelper.openEditor("Foo", _builder.toString());
      this._organizeImportsHandler.doOrganizeImports(editor.getDocument());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("import java.util.ArrayList");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("class Foo {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("val String x");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("val ArrayList<String> y");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      Assert.assertEquals(_builder_1.toString(), editor.getDocument().get());
      final ISourceViewer viewer = editor.getInternalSourceViewer();
      Assert.assertTrue((viewer instanceof ITextViewerExtension6));
      final IUndoManager undoManager = ((ITextViewerExtension6) viewer).getUndoManager();
      undoManager.undo();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("class Foo {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("val java.lang.String x");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("val java.util.ArrayList<String> y");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      Assert.assertEquals(_builder_2.toString(), editor.getDocument().get());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
