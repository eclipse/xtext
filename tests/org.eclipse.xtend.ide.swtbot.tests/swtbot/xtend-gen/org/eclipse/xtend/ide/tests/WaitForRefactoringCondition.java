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

@SuppressWarnings("all")
public class WaitForRefactoringCondition /* implements DefaultCondition  */{
  private /* SWTBotEclipseEditor */Object editor;
  
  private boolean isRedo;
  
  public WaitForRefactoringCondition(final /* SWTBotEclipseEditor */Object editor, final boolean isRedo) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field WaitForRefactoringCondition.editor refers to the missing type SWTBotEclipseEditor");
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
        IUndoContext _undoContext = this.getUndoContext();
        _xifexpression = operationHistory.getRedoOperation(_undoContext);
      } else {
        IUndoContext _undoContext_1 = this.getUndoContext();
        _xifexpression = operationHistory.getUndoOperation(_undoContext_1);
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
    throw new Error("Unresolved compilation problems:"
      + "\nThe field WaitForRefactoringCondition.editor refers to the missing type SWTBotEclipseEditor"
      + "\nreference cannot be resolved"
      + "\ngetEditor cannot be resolved");
  }
}
