/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring2.rename

import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.name.Named
import org.apache.log4j.Logger
import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.ltk.core.refactoring.Change
import org.eclipse.ltk.core.refactoring.RefactoringStatus
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext
import org.eclipse.ltk.core.refactoring.participants.ParticipantManager
import org.eclipse.ltk.core.refactoring.participants.RenameArguments
import org.eclipse.ltk.core.refactoring.participants.SharableParticipants
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.Constants
import org.eclipse.xtext.ide.refactoring.IRenameNameValidator
import org.eclipse.xtext.ide.refactoring.RenameChange
import org.eclipse.xtext.ide.refactoring.RenameContext
import org.eclipse.xtext.ide.serializer.IChangeSerializer
import org.eclipse.xtext.ui.XtextProjectHelper
import org.eclipse.xtext.ui.refactoring.impl.AbstractRenameProcessor
import org.eclipse.xtext.ui.refactoring.impl.ProjectUtil
import org.eclipse.xtext.ui.refactoring.impl.RefactoringResourceSetProvider
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext
import org.eclipse.xtext.ui.refactoring2.ChangeConverter
import org.eclipse.xtext.ui.refactoring2.LtkIssueAcceptor

import static org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor.Severity.*
import org.eclipse.xtext.ide.refactoring.IRenameStrategy2

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
class RenameElementProcessor2 extends AbstractRenameProcessor {
	
	protected static val LOG = Logger.getLogger(RenameElementProcessor2)
	
	@Inject@Named(Constants.LANGUAGE_NAME) String languageName;

	@Inject IRenameNameValidator nameValidator 
	@Inject RefactoringResourceSetProvider resourceSetProvider
	@Inject ISimpleNameProvider simpleNameProvider
	@Inject ProjectUtil projectUtil
	@Inject Provider<LtkIssueAcceptor> statusProvider
	@Inject IChangeSerializer changeSerializer
	@Inject IRenameStrategy2 renameStrategy
	@Inject ChangeConverter.Factory changeConverterFactory
	
	@Accessors(PUBLIC_GETTER, PUBLIC_SETTER) String newName
	
	IRenameElementContext renameElementContext
	IProject project
	ResourceSet resourceSet
	EObject target
	String originalName
	LtkIssueAcceptor status 
	
	Change change
	
	override initialize(IRenameElementContext renameElementContext) {
		this.renameElementContext = renameElementContext
		status = statusProvider.get
		project = projectUtil.getProject(renameElementContext.targetElementURI.trimFragment)
		if (project === null) 
			status.add(ERROR, 
				'Cannot determine project from targetURI ' + renameElementContext.targetElementURI?.toString, 
				renameElementContext.targetElementURI)
		resourceSet = resourceSetProvider.get(project)
		val target = resourceSet.getEObject(renameElementContext.targetElementURI, true)
		if (target === null) 
			status.add(ERROR, 
				'Rename target does not exist', 
				renameElementContext.targetElementURI)
		else
			originalName = simpleNameProvider.getSimpleName(target)
		return true
	}
	
	override checkInitialConditions(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		return status.refactoringStatus
	}
	
	override checkFinalConditions(IProgressMonitor pm, CheckConditionsContext context) throws CoreException, OperationCanceledException {
		val change = new RenameChange(newName, renameElementContext.targetElementURI)
		val renameContext = new RenameContext(#[change], resourceSet, changeSerializer, status)
		renameStrategy.applyRename(renameContext)
		val changeConverter = changeConverterFactory.create('''Rename «originalName» to «newName»''', null, status)
		changeSerializer.applyModifications(changeConverter)
		this.change = changeConverter.change
		return status.refactoringStatus
	}
	
	override createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		return change
	}
	
	override getElements() {
		#[renameElementContext.targetElementURI]
	}
	
	override getIdentifier() {
		languageName + '.renameProcessor2'
	}
	
	override getProcessorName() {
		'Rename element'
	}
	
	override isApplicable() throws CoreException {
		return true
	}
	
	override loadParticipants(RefactoringStatus status, SharableParticipants sharedParticipants) throws CoreException {
		ParticipantManager.loadRenameParticipants(status, 
			this, 
			renameElementContext, new RenameArguments(newName, true), 
			#[XtextProjectHelper.NATURE_ID], 
			sharedParticipants) 
	}
	
	override getOriginalName() {
		originalName
	}
	
	override validateNewName(String newName) {
		val nameStatus = statusProvider.get 
		nameValidator.validate(target, newName, nameStatus)
		return nameStatus.refactoringStatus
	}
	
}