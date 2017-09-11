/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.participant

import com.google.inject.Inject
import org.eclipse.core.resources.IResource
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.ltk.core.refactoring.Change
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext
import org.eclipse.ltk.core.refactoring.participants.ISharableParticipant
import org.eclipse.ltk.core.refactoring.participants.RefactoringArguments
import org.eclipse.ltk.core.refactoring.participants.RenameArguments
import org.eclipse.ltk.core.refactoring.participants.RenameParticipant
import org.eclipse.xtext.ide.refactoring.ResourceRelocationContext.ChangeType

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
class XtextRenameResourceParticipant extends RenameParticipant implements ISharableParticipant {

	@Inject ResourceRelocationProcessor processor

	Change change
	
	override checkConditions(IProgressMonitor pm, CheckConditionsContext context) throws OperationCanceledException {
		change = processor.createChange(name, ChangeType.RENAME, pm)
		return processor.issues.refactoringStatus
	}

	override createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		return change 
	}

	override getName() {
		'Xtext rename resource participant'
	}

	override protected initialize(Object element) {
		addElement(element, arguments)
		true
	}

	override addElement(Object element, RefactoringArguments arguments) {
		if (arguments instanceof RenameArguments) {
			if (element instanceof IResource) {
				val oldPath = element.fullPath
				val newPath = oldPath.removeLastSegments(1).append(arguments.newName)
				processor.addChangedResource(element, oldPath, newPath)
			}
		}
	}
}
