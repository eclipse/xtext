/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.refactoring2.participant;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.ISharableParticipant;
import org.eclipse.ltk.core.refactoring.participants.MoveArguments;
import org.eclipse.ltk.core.refactoring.participants.MoveParticipant;
import org.eclipse.ltk.core.refactoring.participants.RefactoringArguments;
import org.eclipse.xtext.ide.refactoring.ResourceRelocationContext;

import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
public class XtextMoveResourceParticipant extends MoveParticipant implements ISharableParticipant {

	@Inject
	private ResourceRelocationProcessor processor;

	private Change change;

	@Override
	public RefactoringStatus checkConditions(IProgressMonitor pm, CheckConditionsContext context) throws OperationCanceledException {
		try {
			change = processor.createChange(getName(), ResourceRelocationContext.ChangeType.MOVE, pm);
			return processor.getIssues().getRefactoringStatus();
		} catch (OperationCanceledException e) {
			throw e;
		} catch (CoreException e) {
			return RefactoringStatus.create(e.getStatus());
		}
	}

	@Override
	public Change createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		return null;
	}

	@Override
	public Change createPreChange(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		return change;
	}

	@Override
	public String getName() {
		return "Xtext move resource participant";
	}

	@Override
	protected boolean initialize(Object element) {
		addElement(element, getArguments());
		return true;
	}

	@Override
	public void addElement(Object element, RefactoringArguments arguments) {
		if (arguments instanceof MoveArguments) {
			if (element instanceof IResource) {
				Object destination = ((MoveArguments) arguments).getDestination();
				if (destination instanceof IFolder || destination instanceof IProject) {
					IFile destinationFile = ((IContainer) destination).getFile(new Path(((IResource) element).getName()));
					processor.addChangedResource(((IResource) element), ((IResource) element).getFullPath(), destinationFile.getFullPath());
				}
			}
		}
	}
}
