/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;

@SuppressWarnings("all")
public class WaitForRefactoringCondition extends DefaultCondition {
  private SWTBotEclipseEditor editor;
  
  private boolean isRedo;
  
  public WaitForRefactoringCondition(final SWTBotEclipseEditor editor, final boolean isRedo) {
    this.editor = editor;
    this.isRedo = isRedo;
  }
  
  public String getFailureMessage() {
    return "Refactoring not performed";
  }
  
  public boolean test() throws Exception {
    boolean _xblockexpression = false;
    {
      final IOperationHistory operationHistory = OperationHistoryFactory.getOperationHistory();
      IUndoableOperation _xifexpression = null;
      if (this.isRedo) {
        IUndoContext _undoContext = this.getUndoContext();
        IUndoableOperation _redoOperation = operationHistory.getRedoOperation(_undoContext);
        _xifexpression = _redoOperation;
      } else {
        IUndoContext _undoContext_1 = this.getUndoContext();
        IUndoableOperation _undoOperation = operationHistory.getUndoOperation(_undoContext_1);
        _xifexpression = _undoOperation;
      }
      String _label = null;
      if (_xifexpression!=null) {
        _label=_xifexpression.getLabel();
      }
      final String label = _label;
      boolean _startsWith = label.startsWith("Rename ");
      _xblockexpression = (_startsWith);
    }
    return _xblockexpression;
  }
  
  protected IUndoContext getUndoContext() {
    IUndoContext _xblockexpression = null;
    {
      IEditorReference _reference = this.editor.getReference();
      IEditorPart _editor = _reference.getEditor(true);
      final ITextEditor ed = ((ITextEditor) _editor);
      IDocumentProvider _documentProvider = ed.getDocumentProvider();
      IEditorInput _editorInput = ed.getEditorInput();
      final IDocument document = _documentProvider.getDocument(_editorInput);
      final IDocumentUndoManager undoManager = DocumentUndoManagerRegistry.getDocumentUndoManager(document);
      IUndoContext _undoContext = undoManager.getUndoContext();
      _xblockexpression = (_undoContext);
    }
    return _xblockexpression;
  }
}
