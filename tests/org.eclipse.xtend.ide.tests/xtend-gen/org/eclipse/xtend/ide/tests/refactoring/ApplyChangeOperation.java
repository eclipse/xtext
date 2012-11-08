package org.eclipse.xtend.ide.tests.refactoring;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

@SuppressWarnings("all")
public class ApplyChangeOperation extends WorkspaceModifyOperation {
  private Change change;
  
  private Change undoChange;
  
  public ApplyChangeOperation(final Change change) {
    this.change = change;
  }
  
  protected void execute(final IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
    Change _perform = this.change.perform(monitor);
    this.undoChange = _perform;
  }
}
