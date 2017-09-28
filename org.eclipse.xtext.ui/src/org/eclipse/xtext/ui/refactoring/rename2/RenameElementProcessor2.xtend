/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.rename2

import com.google.inject.Inject
import com.google.inject.name.Named
import org.apache.log4j.Logger
import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.ltk.core.refactoring.RefactoringStatus
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext
import org.eclipse.ltk.core.refactoring.participants.ParticipantManager
import org.eclipse.ltk.core.refactoring.participants.RenameArguments
import org.eclipse.ltk.core.refactoring.participants.SharableParticipants
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.Constants
import org.eclipse.xtext.ide.refactoring.IRenameNameValidator
import org.eclipse.xtext.ide.refactoring.IRenameStrategy
import org.eclipse.xtext.ide.refactoring.RenameChange
import org.eclipse.xtext.ide.refactoring.RenameContext
import org.eclipse.xtext.ide.serializer.IChangeSerializer
import org.eclipse.xtext.ui.XtextProjectHelper
import org.eclipse.xtext.ui.refactoring.impl.AbstractRenameProcessor
import org.eclipse.xtext.ui.refactoring.impl.ProjectUtil
import org.eclipse.xtext.ui.refactoring.participant.ChangeConverter
import org.eclipse.xtext.ui.refactoring.participant.LtkIssueAcceptor
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext
import org.eclipse.xtext.ui.resource.IResourceSetProvider
import org.eclipse.xtext.ui.resource.LiveScopeResourceSetInitializer

import static org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor.Severity.*
import com.google.inject.Provider

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
class RenameElementProcessor2 extends AbstractRenameProcessor {
	
	protected static val LOG = Logger.getLogger(RenameElementProcessor2)
	
	@Inject@Named(Constants.LANGUAGE_NAME) String languageName;

	@Inject IRenameNameValidator nameValidator 
	@Inject IResourceSetProvider resourceSetProvider
	@Inject LiveScopeResourceSetInitializer liveScopeResourceSetInitializer
	@Inject ProjectUtil projectUtil
	@Inject Provider<LtkIssueAcceptor> statusProvider
	@Inject IChangeSerializer changeSerializer
	@Inject IRenameStrategy renameStrategy
	@Inject ChangeConverter changeConverter
	
	@Accessors(PUBLIC_GETTER, PUBLIC_SETTER) String newName
	
	IRenameElementContext renameElementContext
	IProject project
	ResourceSet resourceSet
	EObject target
	String originalName
	LtkIssueAcceptor status 
	
	override initialize(IRenameElementContext renameElementContext) {
		this.renameElementContext = renameElementContext
		status = statusProvider.get
		project = projectUtil.getProject(renameElementContext.targetElementURI.trimFragment)
		if (project === null) 
			status.add(ERROR, 
				'Cannot determine project from targetURI ' + renameElementContext.targetElementURI?.toString, 
				renameElementContext.targetElementURI)
		resourceSet = resourceSetProvider.get(project)
		liveScopeResourceSetInitializer.initialize(resourceSet)
		val target = resourceSet.getEObject(renameElementContext.targetElementURI, true)
		if (target === null) 
			status.add(ERROR, 
				'Rename target does not exist', 
				renameElementContext.targetElementURI)
		else
			originalName = renameStrategy.getCurrentName(target)
		return true
	}
	
	override checkInitialConditions(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		return status.refactoringStatus
	}
	
	override checkFinalConditions(IProgressMonitor pm, CheckConditionsContext context) throws CoreException, OperationCanceledException {
		val change = new RenameChange(newName, renameElementContext.targetElementURI)
		val renameContext = new RenameContext(#[change], resourceSet, changeSerializer, status)
		renameStrategy.loadAndWatchResources(renameContext)
		renameStrategy.applyRename(renameContext)
		renameStrategy.applySideEffects(renameContext)
		changeConverter.initialize('''Rename «originalName» to «newName»''', null, status)
		changeSerializer.endRecordChanges(changeConverter)
		return status.refactoringStatus
	}
	
	override createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		return changeConverter.change
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