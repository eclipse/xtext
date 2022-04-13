/**
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEclipseEditor;
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.text.undo.DocumentUndoManagerRegistry;
import org.eclipse.text.undo.IDocumentUndoManager;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.texteditor.ITextEditor;

@SuppressWarnings("all")
public class WaitForRefactoringCondition extends DefaultCondition {
  private SWTBotEclipseEditor editor;

  private boolean isRedo;

  public WaitForRefactoringCondition(final SWTBotEclipseEditor editor, final boolean isRedo) {
    this.editor = editor;
    this.isRedo = isRedo;
  }

  @Override
  public String getFailureMessage() {
    return "Refactoring not performed";
  }

  @Override
  public boolean test() throws Exception {
    boolean _xblockexpression = false;
    {
      final IOperationHistory operationHistory = OperationHistoryFactory.getOperationHistory();
      IUndoableOperation _xifexpression = null;
      if (this.isRedo) {
        _xifexpression = operationHistory.getRedoOperation(this.getUndoContext());
      } else {
        _xifexpression = operationHistory.getUndoOperation(this.getUndoContext());
      }
      String _label = null;
      if (_xifexpression!=null) {
        _label=_xifexpression.getLabel();
      }
      final String label = _label;
      _xblockexpression = label.startsWith("Rename ");
    }
    return _xblockexpression;
  }

  protected IUndoContext getUndoContext() {
    IUndoContext _xblockexpression = null;
    {
      IEditorPart _editor = this.editor.getReference().getEditor(true);
      final ITextEditor ed = ((ITextEditor) _editor);
      final IDocument document = ed.getDocumentProvider().getDocument(ed.getEditorInput());
      final IDocumentUndoManager undoManager = DocumentUndoManagerRegistry.getDocumentUndoManager(document);
      _xblockexpression = undoManager.getUndoContext();
    }
    return _xblockexpression;
  }
}
