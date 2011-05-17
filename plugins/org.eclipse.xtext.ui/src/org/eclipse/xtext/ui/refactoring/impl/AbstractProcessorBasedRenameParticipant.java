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
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.RenameParticipant;
import org.eclipse.ltk.core.refactoring.participants.RenameProcessor;
import org.eclipse.xtext.resource.IGlobalServiceProvider;
import org.eclipse.xtext.ui.internal.Activator;
import org.eclipse.xtext.ui.refactoring.IRenameProcessorAdapter;
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

	@Inject
	private IRenameProcessorAdapter.Factory processorAdapterFactory;

	private RefactoringStatus status;

	private List<IRenameProcessorAdapter> wrappedProcessors;

	@Override
	protected boolean initialize(Object element) {
		status = new RefactoringStatus();
		try {
			wrappedProcessors = getRenameProcessors(element);
			return wrappedProcessors != null;
		} catch (Exception exc) {
			status.addError("Error initializing refactoring participant. See log for details");
			LOG.error("Error initializing refactoring participant", exc);
		}
		return false;
	}

	protected List<IRenameProcessorAdapter> getRenameProcessors(Object element) {
		List<? extends IRenameElementContext> participantContexts = createRenameElementContexts(element);
		if (participantContexts != null) {
			List<IRenameProcessorAdapter> processors = newArrayList();
			for (IRenameElementContext participantContext : participantContexts) {
				IRenameRefactoringProvider renameRefactoringProvider = getRenameRefactoringProvider(participantContext);
				RenameProcessor processor = renameRefactoringProvider.getRenameProcessor(participantContext);
				processors.add(processorAdapterFactory.create(processor));
			}
			return processors;
		}
		return null;
	}

	protected IRenameRefactoringProvider getRenameRefactoringProvider(IRenameElementContext renameElementContext) {
		return globalServiceProvider.findService(renameElementContext.getTargetElementURI(),
				IRenameRefactoringProvider.class);
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
			for (IRenameProcessorAdapter wrappedProcessor : wrappedProcessors) {
				status.merge(wrappedProcessor.checkInitialConditions(progress.newChild(20)));
				wrappedProcessor.setNewName(getNewName());
				status.merge(wrappedProcessor.checkFinalConditions(progress.newChild(80), context));
			}
		} catch (Exception ce) {
			status.addError("Error checking conditions in refactoring participant: " + notNull(ce.getMessage())
					+ ". See log for details");
			LOG.error("Error checking conditions in refactoring participant", ce);
		}
		return status;
	}

	@Override
	public Change createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		CompositeChange compositeChange = null;
		try {
			for (IRenameProcessorAdapter wrappedProcessor : wrappedProcessors) {
				Change processorChange = wrappedProcessor.createChange(pm);
				if(processorChange != null) {
					if(compositeChange == null)
						compositeChange = new CompositeChange("Changes form participant: " + getName());
					compositeChange.add(processorChange);
				}
			}
		} catch (Exception e) {
			throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error creating change", e));
		}
		return compositeChange;
	}

	protected List<? extends IRenameElementContext> createRenameElementContexts(Object element) {
		if (element instanceof IRenameElementContext) {
			IRenameElementContext triggeringContext = (IRenameElementContext) element;
			ResourceSet resourceSet = resourceSetProvider.get(projectUtil.getProject(triggeringContext
					.getTargetElementURI()));
			EObject originalTarget = resourceSet.getEObject(triggeringContext.getTargetElementURI(), true);
			List<EObject> renamedElements = getRenamedElementsOrProxies(originalTarget);
			if (renamedElements == null || renamedElements.isEmpty())
				return null;
			List<IRenameElementContext> contexts = newArrayListWithCapacity(renamedElements.size());
			for (EObject renamedElement : renamedElements)
				contexts.add(new IRenameElementContext.Impl(EcoreUtil.getURI(renamedElement), renamedElement.eClass(),
						triggeringContext.getTriggeringEditor(), triggeringContext.getTriggeringEditorSelection(),
						triggeringContext.getContextResourceURI()));
			return contexts;
		}
		return null;
	}

	protected abstract List<EObject> getRenamedElementsOrProxies(EObject originalTarget);

	protected String getNewName() {
		return getArguments().getNewName();
	}

	protected RefactoringStatus getStatus() {
		return status;
	}

	protected IGlobalServiceProvider getGlobalServiceProvider() {
		return globalServiceProvider;
	}
}
