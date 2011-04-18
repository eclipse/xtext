/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import static com.google.common.collect.Lists.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.RenameParticipant;
import org.eclipse.xtext.resource.IGlobalServiceProvider;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;

import com.google.inject.Inject;
import com.google.inject.Provider;

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

	private List<AbstractRenameProcessor> wrappedProcessors;

	protected static class RenameProcessorProvider {
		@Inject
		private Provider<AbstractRenameProcessor> processorProvider;

		public AbstractRenameProcessor getRenameRefactoring(IRenameElementContext renameElementContext) {
			AbstractRenameProcessor processor = processorProvider.get();
			if (processor != null) {
				if (processor.initialize(renameElementContext))
					return processor;
			}
			return null;
		}
	}

	@Override
	protected boolean initialize(Object element) {
		status = new RefactoringStatus();
		try {
			if (element instanceof IRenameElementContext) {
				List<IRenameElementContext> participantContexts = createRenameElementContexts((IRenameElementContext) element);
				if (participantContexts != null) {
					wrappedProcessors = newArrayList();
					for (IRenameElementContext participantContext : participantContexts) {
						RenameProcessorProvider renameProcessorProvider = globalServiceProvider.findService(
								participantContext.getTargetElementURI(), RenameProcessorProvider.class);
						AbstractRenameProcessor wrappedProcessor = renameProcessorProvider
								.getRenameRefactoring(participantContext);
						wrappedProcessors.add(wrappedProcessor);
					}
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
		return getClass().getName();
	}

	@Override
	public RefactoringStatus checkConditions(IProgressMonitor pm, CheckConditionsContext context)
			throws OperationCanceledException {
		SubMonitor progress = SubMonitor.convert(pm).setWorkRemaining(100);
		try {
			for (AbstractRenameProcessor wrappedProcessor : wrappedProcessors) {
				status.merge(wrappedProcessor.checkInitialConditions(progress.newChild(20)));
				wrappedProcessor.setNewName(getNewName());
				status.merge(wrappedProcessor.checkFinalConditions(progress.newChild(80), context));
			}
		} catch (CoreException ce) {
			status.addError("Error checking conditions in refactoring participant: " + notNull(ce.getMessage())
					+ ". See log for details");
			LOG.error("Error checking conditions in refactoring participant", ce);
		}
		return status;
	}

	@Override
	public Change createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		CompositeChange compositeChange = new CompositeChange("Changes form participant: " + getName());
		for (AbstractRenameProcessor wrappedProcessor : wrappedProcessors)
			compositeChange.add(wrappedProcessor.createChange(pm));
		return compositeChange;
	}

	protected List<IRenameElementContext> createRenameElementContexts(IRenameElementContext triggeringContext) {
		ResourceSet resourceSet = resourceSetProvider.get(projectUtil.getProject(triggeringContext
				.getTargetElementURI()));
		EObject originalTarget = resourceSet.getEObject(triggeringContext.getTargetElementURI(), true);
		List<EObject> renamedElements = getRenamedElements(originalTarget);
		if (renamedElements == null || renamedElements.isEmpty())
			return null;
		List<IRenameElementContext> contexts = newArrayListWithCapacity(renamedElements.size());
		for (EObject renamedElement : renamedElements)
			contexts.add(new IRenameElementContext.Impl(EcoreUtil.getURI(renamedElement), renamedElement.eClass(),
					triggeringContext.getTriggeringEditor(), triggeringContext.getTriggeringEditorSelection(),
					triggeringContext.getContextResourceURI()));
		return contexts;
	}

	protected abstract List<EObject> getRenamedElements(EObject originalTarget);

	protected String getNewName() {
		return getArguments().getNewName();
	}

	protected RefactoringStatus getStatus() {
		return status;
	}
}
