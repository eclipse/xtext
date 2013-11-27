/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Sets.*;
import static org.eclipse.ltk.core.refactoring.RefactoringStatus.*;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
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
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.resource.IGlobalServiceProvider;
import org.eclipse.xtext.ui.internal.Activator;
import org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.ui.refactoring.ui.RefactoringPreferences;
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * A rename participant that triggers further rename refactorings based on {@link RenameProcessor}s.
 * 
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
	@Named(Constants.LANGUAGE_NAME)
	private String languageName;

	@Inject
	private StatusWrapper status;
	
	@Inject 
	private SyncUtil syncUtil;
	
	@Inject
	private RefactoringPreferences preferences;

	private List<RenameProcessor> wrappedProcessors;

	private Set<Object> disabledTargets = newHashSet();

	@Override
	protected boolean initialize(Object originalTargetElement) {
		try {
			wrappedProcessors = getRenameProcessors(originalTargetElement);
			if(wrappedProcessors != null) {
				syncUtil.totalSync(preferences.isSaveAllBeforeRefactoring());
				return true;
			}	
		} catch (Exception exc) {
			status.add(ERROR, "Error initializing refactoring participant.", exc, LOG);
		}
		return false;
	}

	protected List<RenameProcessor> getRenameProcessors(Object originalTargetElement) {
		List<? extends IRenameElementContext> participantContexts = createRenameElementContexts(originalTargetElement);
		if (participantContexts != null) {
			List<RenameProcessor> processors = newArrayList();
			for (IRenameElementContext participantContext : participantContexts) {
				RenameProcessor renameProcessor = getRenameProcessor(participantContext);
				if (renameProcessor != null) {
					processors.add(renameProcessor);
				}
			}
			return processors;
		}
		return null;
	}

	protected RenameProcessor getRenameProcessor(IRenameElementContext participantContext) {
		IRenameRefactoringProvider renameRefactoringProvider = getRenameRefactoringProvider(participantContext);
		if (renameRefactoringProvider != null)
			return renameRefactoringProvider.getRenameProcessor(participantContext);
		else
			return null;
	}

	protected IRenameRefactoringProvider getRenameRefactoringProvider(IRenameElementContext renameElementContext) {
		return globalServiceProvider.findService(renameElementContext.getTargetElementURI(),
				IRenameRefactoringProvider.class);
	}

	@Override
	public String getName() {
		return languageName;
	}

	public Object[] getElements() {
		List<Object> elements = newArrayList();
		for (RenameProcessor wrappedProcessor : wrappedProcessors) {
			elements.addAll(Arrays.asList(wrappedProcessor.getElements()));
		}
		return toArray(elements, Object.class);
	}

	public void disableFor(Object... elements) {
		disabledTargets.addAll(Arrays.asList(elements));
	}

	@Override
	public RefactoringStatus checkConditions(IProgressMonitor pm, CheckConditionsContext context)
			throws OperationCanceledException {
		SubMonitor progress = SubMonitor.convert(pm).setWorkRemaining(100);
		try {
			for (RenameProcessor wrappedProcessor : wrappedProcessors) {
				List<Object> targetElements = Arrays.asList(wrappedProcessor.getElements());
				if (!disabledTargets.containsAll(targetElements)) {
					setNewName(wrappedProcessor, getNewName());
					status.merge(wrappedProcessor.checkInitialConditions(progress.newChild(20)));
					if(!status.getRefactoringStatus().hasFatalError())
						status.merge(wrappedProcessor.checkFinalConditions(progress.newChild(80), context));
				}
			}
		} catch (Exception ce) {
			status.add(ERROR, "Error checking conditions in refactoring participant: {0}. See log for details", ce, LOG);
		}
		return status.getRefactoringStatus();
	}

	protected void setNewName(RenameProcessor processor, String newName) {
		((AbstractRenameProcessor) processor).setNewName(newName);
	}

	@Override
	public Change createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		CompositeChange compositeChange = null;
		try {
			for (RenameProcessor wrappedProcessor : wrappedProcessors) {
				if (!disabledTargets.containsAll(Arrays.asList(wrappedProcessor.getElements()))) {
					Change processorChange = wrappedProcessor.createChange(pm);
					if (processorChange != null) {
						if (compositeChange == null)
							compositeChange = new CompositeChange("Changes from participant: " + getName());
						compositeChange.add(processorChange);
					}
				}
			}
		} catch (Exception e) {
			throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error creating change", e));
		} finally {
			dispose();
		}
		return compositeChange;
	}
	
	/**
	 * @since 2.4
	 */
	protected void dispose() {
		status = null;
		wrappedProcessors = null;
		disabledTargets.clear();
	}

	protected List<? extends IRenameElementContext> createRenameElementContexts(Object element) {
		if (element instanceof IRenameElementContext) {
			IRenameElementContext triggeringContext = (IRenameElementContext) element;
			IProject project = projectUtil.getProject(triggeringContext.getTargetElementURI());
			if (project != null) {
				ResourceSet resourceSet = resourceSetProvider.get(project);
				EObject originalTarget = resourceSet.getEObject(triggeringContext.getTargetElementURI(), true);
				List<EObject> renamedElements = getRenamedElementsOrProxies(originalTarget);
				if (renamedElements == null || renamedElements.isEmpty())
					return null;
				List<IRenameElementContext> contexts = newArrayListWithCapacity(renamedElements.size());
				for (EObject renamedElement : renamedElements)
					contexts.add(new IRenameElementContext.Impl(EcoreUtil.getURI(renamedElement), renamedElement
							.eClass(), triggeringContext.getTriggeringEditor(), triggeringContext
							.getTriggeringEditorSelection(), triggeringContext.getContextResourceURI()));
				return contexts;
			}
		}
		return null;
	}

	protected abstract List<EObject> getRenamedElementsOrProxies(EObject originalTarget);

	protected String getNewName() {
		return getArguments().getNewName();
	}

	protected StatusWrapper getStatus() {
		return status;
	}

	protected IGlobalServiceProvider getGlobalServiceProvider() {
		return globalServiceProvider;
	}
}
