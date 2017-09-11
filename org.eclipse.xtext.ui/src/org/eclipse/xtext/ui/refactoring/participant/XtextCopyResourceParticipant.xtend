/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.participant

import com.google.inject.Inject
import org.eclipse.core.resources.IFolder
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IResource
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.ltk.core.refactoring.Change
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext
import org.eclipse.ltk.core.refactoring.participants.CopyArguments
import org.eclipse.ltk.core.refactoring.participants.CopyParticipant
import org.eclipse.ltk.core.refactoring.participants.ISharableParticipant
import org.eclipse.ltk.core.refactoring.participants.RefactoringArguments
import org.eclipse.xtext.ide.refactoring.ResourceRelocationChange

/**
 * @author koehnlein - Initial contribution and API
 */
class XtextCopyResourceParticipant extends CopyParticipant implements ISharableParticipant {
	
	@Inject ResourceRelocationProcessor processor
	
	Change change
	
	override checkConditions(IProgressMonitor pm, CheckConditionsContext context) throws OperationCanceledException {
		change = processor.createChange(name, pm)
		return processor.issues.refactoringStatus
	}

	override createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		return change 
	}

	override getName() {
		'Xtext copy resource participant'
	}

	override protected initialize(Object element) {
		addElement(element, arguments)
		true
	}
	
	override addElement(Object element, RefactoringArguments arguments) {
		if (arguments instanceof CopyArguments) {
			if (element instanceof IResource) {
				val destination = arguments.destination
				if (destination instanceof IFolder || destination instanceof IProject) {
					val destinationFile = switch destination {
						IFolder: destination.getFile(element.name)
						IProject: destination.getFile(element.name)
					}
					processor.addChangedResource(element, element.fullPath, destinationFile.fullPath, ResourceRelocationChange.Type.COPY)
				}
			}
		}
	}
}