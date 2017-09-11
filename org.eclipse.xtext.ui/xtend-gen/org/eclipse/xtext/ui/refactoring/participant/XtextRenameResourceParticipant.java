/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.refactoring.participant;

import com.google.inject.Inject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.ISharableParticipant;
import org.eclipse.ltk.core.refactoring.participants.RefactoringArguments;
import org.eclipse.ltk.core.refactoring.participants.RenameArguments;
import org.eclipse.ltk.core.refactoring.participants.RenameParticipant;
import org.eclipse.xtext.ide.refactoring.ResourceRelocationContext;
import org.eclipse.xtext.ui.refactoring.participant.ResourceRelocationProcessor;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
@SuppressWarnings("all")
public class XtextRenameResourceParticipant extends RenameParticipant implements ISharableParticipant {
  @Inject
  private ResourceRelocationProcessor processor;
  
  private Change change;
  
  @Override
  public RefactoringStatus checkConditions(final IProgressMonitor pm, final CheckConditionsContext context) throws OperationCanceledException {
    try {
      this.change = this.processor.createChange(this.getName(), ResourceRelocationContext.ChangeType.RENAME, pm);
      return this.processor.getIssues().getRefactoringStatus();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public Change createChange(final IProgressMonitor pm) throws CoreException, OperationCanceledException {
    return this.change;
  }
  
  @Override
  public String getName() {
    return "Xtext rename resource participant";
  }
  
  @Override
  protected boolean initialize(final Object element) {
    boolean _xblockexpression = false;
    {
      this.addElement(element, this.getArguments());
      _xblockexpression = true;
    }
    return _xblockexpression;
  }
  
  @Override
  public void addElement(final Object element, final RefactoringArguments arguments) {
    if ((arguments instanceof RenameArguments)) {
      if ((element instanceof IResource)) {
        final IPath oldPath = ((IResource)element).getFullPath();
        final IPath newPath = oldPath.removeLastSegments(1).append(((RenameArguments)arguments).getNewName());
        this.processor.addChangedResource(((IResource)element), oldPath, newPath);
      }
    }
  }
}
