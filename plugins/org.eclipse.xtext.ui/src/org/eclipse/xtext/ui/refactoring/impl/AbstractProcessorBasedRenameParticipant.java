/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import static org.eclipse.xtext.util.Strings.*;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.ProcessorBasedRefactoring;
import org.eclipse.ltk.core.refactoring.participants.RenameParticipant;
import org.eclipse.xtext.resource.IGlobalServiceProvider;
import org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public abstract class AbstractProcessorBasedRenameParticipant extends RenameParticipant {

	private static final Logger LOG = Logger.getLogger(AbstractProcessorBasedRenameParticipant.class);

	@Inject
	private IGlobalServiceProvider globalServiceProvider;

	@Inject
	private RefactoringResourceSetProvider resourceSetProvider;

	@Inject
	private ProjectUtil projectUtil;

	private RefactoringStatus status;
	
	private AbstractRenameProcessor wrappedProcessor;

	public void setWrappedProcessor(AbstractRenameProcessor wrappedProcessor) {
		this.wrappedProcessor = wrappedProcessor;
	}

	protected AbstractRenameProcessor getWrappedProcessor() {
		return wrappedProcessor;
	}

	@Override
	protected boolean initialize(Object element) {
		status = new RefactoringStatus();
		try {
			if (element instanceof IRenameElementContext) {
				IRenameElementContext participantContext = createRenameElementContext((IRenameElementContext) element);
				if (participantContext != null) {
					IRenameRefactoringProvider renameRefactoringProvider = globalServiceProvider.findService(
							participantContext.getTargetElementURI(), IRenameRefactoringProvider.class);
					ProcessorBasedRefactoring renameRefactoring = renameRefactoringProvider
							.getRenameRefactoring(participantContext);
					if (renameRefactoring == null)
						return false;
					setWrappedProcessor((AbstractRenameProcessor) renameRefactoring.getProcessor());
					return true;
				}
			}
		} catch (Exception exc) {
			status.addError("Error initializing refactoring participant. See log for details");
			LOG.error("Error initializing refactoring participant", exc);
		}
		return false;
	}

	@Override
	public String getName() {
		return wrappedProcessor.getProcessorName() + ".asParticipant";
	}

	@Override
	public RefactoringStatus checkConditions(IProgressMonitor pm, CheckConditionsContext context)
			throws OperationCanceledException {
		SubMonitor progress = SubMonitor.convert(pm).setWorkRemaining(100);
		try {
			status.merge(wrappedProcessor.checkInitialConditions(progress.newChild(20)));
			wrappedProcessor.setNewName(getNewName());
			status.merge(wrappedProcessor.checkFinalConditions(progress.newChild(80), context));
		} catch (CoreException ce) {
			status.addError("Error checking conditions in refactoring participant: " + notNull(ce.getMessage())
					+ ". See log for details");
			LOG.error("Error checking conditions in refactoring participant", ce);
		}
		return status;
	}

	@Override
	public Change createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		return wrappedProcessor.createChange(pm);
	}

	protected IRenameElementContext createRenameElementContext(IRenameElementContext triggeringContext) {
		ResourceSet resourceSet = resourceSetProvider.get(projectUtil.getProject(triggeringContext
				.getTargetElementURI()));
		EObject originalTarget = resourceSet.getEObject(triggeringContext.getTargetElementURI(), true);
		EObject renamedElement = getRenamedElement(originalTarget);
		if (renamedElement != null)
			return new IRenameElementContext.Impl(EcoreUtil.getURI(renamedElement), renamedElement.eClass(),
					triggeringContext.getTriggeringEditor(), triggeringContext.getTriggeringEditorSelection(),
					triggeringContext.getContextResourceURI());
		else
			return null;
	}

	protected abstract EObject getRenamedElement(EObject originalTarget);

	protected String getNewName() {
		return getArguments().getNewName();
	}
	
	protected RefactoringStatus getStatus() {
		return status;
	}
}
