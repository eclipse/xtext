/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;
import static org.eclipse.ltk.core.refactoring.RefactoringStatus.*;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.ParticipantManager;
import org.eclipse.ltk.core.refactoring.participants.RefactoringParticipant;
import org.eclipse.ltk.core.refactoring.participants.RenameArguments;
import org.eclipse.ltk.core.refactoring.participants.RenameParticipant;
import org.eclipse.ltk.core.refactoring.participants.SharableParticipants;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.refactoring.ElementRenameArguments;
import org.eclipse.xtext.ui.refactoring.IChangeRedirector;
import org.eclipse.xtext.ui.refactoring.IDependentElementsCalculator;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy.Provider.NoSuchStrategyException;
import org.eclipse.xtext.ui.refactoring.IRenamedElementTracker;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

/**
 * LTK {@link org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor} for an Xtext element rename
 * refactoring.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * @author Holger Schill
 */
public class RenameElementProcessor extends AbstractRenameProcessor {

	protected static final Logger LOG = Logger.getLogger(RenameElementProcessor.class);

	@Inject
	private RefactoringResourceSetProvider resourceSetProvider;

	@Inject
	private IDependentElementsCalculator dependentElementsCalculator;

	@Inject
	private IRenameStrategy.Provider strategyProvider;

	@Inject
	private ProjectUtil projectUtil;

	@Inject
	private ReferenceUpdaterDispatcher referenceUpdaterDispatcher;

	@Inject
	private IRenamedElementTracker renameElementTracker;

	@Inject
	@Named(Constants.LANGUAGE_NAME)
	private String languageName;

	@Inject
	private Provider<StatusWrapper> statusProvider;

	private StatusWrapper status;

	private IRenameElementContext renameElementContext;
	private ResourceSet resourceSet;
	private URI targetElementURI;
	private EObject targetElement;
	private IRenameStrategy renameStrategy;
	private String newName;

	@Inject
	private Provider<IRefactoringUpdateAcceptor> updateAcceptorProvider;

	private ElementRenameArguments renameArguments;

	private IRefactoringUpdateAcceptor currentUpdateAcceptor;

	@Override
	public boolean initialize(final IRenameElementContext renameElementContext) {
		try {
			status = statusProvider.get();
			this.renameElementContext = renameElementContext;
			this.targetElementURI = renameElementContext.getTargetElementURI();
			resourceSet = getResourceSet(renameElementContext);
			targetElement = resourceSet.getEObject(targetElementURI, true);
			if (targetElement == null) {
				status.add(FATAL, "Rename target element {0} can not be resolved", targetElementURI);
			} else {
				this.renameStrategy = createRenameElementStrategy(targetElement, renameElementContext);
				if (this.renameStrategy == null)
					return false;
			}
		} catch (NoSuchStrategyException e) {
			status.add(FATAL, e.getMessage());
		} catch (Exception e) {
			handleException(e, status);
			throw (e instanceof RuntimeException) ? (RuntimeException) e : new WrappedException(e);
		}
		return true;
	}

	protected ResourceSet getResourceSet(IRenameElementContext renameElementContext) {
		if (resourceSet == null)
			resourceSet = createResourceSet(renameElementContext);
		return resourceSet;
	}

	protected ResourceSet createResourceSet(IRenameElementContext renameElementContext) {
		IProject project = projectUtil.getProject(renameElementContext.getTargetElementURI());
		if (project == null) {
			status.add(FATAL, "Could not find project for ", renameElementContext.getTargetElementURI());
			return null;
		}
		return resourceSet = resourceSetProvider.get(project);
	}

	protected boolean isValidTargetFile(Resource resource, StatusWrapper status) {
		IFile targetFile = projectUtil.findFileStorage(resource.getURI(), true);
		if (targetFile != null)
			return true;
		String path = (resource.getURI().isPlatformResource()) 
				? resource.getURI().toPlatformString(true)
				: resource.getURI().toString();
		status.add(FATAL, "Rename target file '" + path + "' cannot be accessed", resource.getURI());
		return false;
	}

	protected IRenameStrategy createRenameElementStrategy(EObject targetElement,
			IRenameElementContext renameElementContext) throws NoSuchStrategyException {
		IRenameStrategy result = strategyProvider.get(targetElement, renameElementContext);
		return result;
	}

	public IRenameStrategy getRenameElementStrategy() {
		return renameStrategy;
	}

	@Override
	public Object[] getElements() {
		return new Object[] { targetElementURI };
	}
	
	@Override
	public String getOriginalName() {
		return renameStrategy.getOriginalName();
	}

	@Override
	public RefactoringStatus validateNewName(String newName) {
		return renameStrategy.validateNewName(newName);
	}

	protected String getLanguageName() {
		return languageName;
	}

	@Override
	public String getIdentifier() {
		return getLanguageName() + ".ui.refactoring.Processor";
	}

	@Override
	public String getProcessorName() {
		return "Rename element";
	}

	@Override
	public boolean isApplicable() throws CoreException {
		return true;
	}

	@Override
	public void setNewName(String newName) {
		this.newName = newName;
	}

	@Override
	public String getNewName() {
		return newName;
	}

	@Override
	public RefactoringStatus checkInitialConditions(IProgressMonitor pm) throws CoreException,
			OperationCanceledException {
		isValidTargetFile(targetElement.eResource(), status);
		if(!status.getRefactoringStatus().hasFatalError())
			status.merge(validateNewName(newName));
		return status.getRefactoringStatus();
	}

	protected Iterable<URI> getElementURIs() {
		List<URI> elementURIs = newArrayList();
		for(Object element: getElements()) {
			if(element instanceof URI) 
				elementURIs.add((URI) element);
		}
		return elementURIs;
	}
	
	@Override
	public RefactoringStatus checkFinalConditions(IProgressMonitor monitor, CheckConditionsContext context)
			throws CoreException, OperationCanceledException {
		SubMonitor progress = SubMonitor.convert(monitor, 100);
		status = statusProvider.get();
		try {
			currentUpdateAcceptor = updateAcceptorProvider.get();
			transferChangeRedirector(currentUpdateAcceptor);
			Iterable<URI> dependentElementURIs = dependentElementsCalculator.getDependentElementURIs(targetElement,
					progress.newChild(1));
			Map<URI, URI> original2newElementURIs = renameElementTracker.renameAndTrack(
					concat(getElementURIs(), dependentElementURIs), newName, resourceSet,
					renameStrategy, progress.newChild(1));
			renameStrategy.createDeclarationUpdates(newName, resourceSet, currentUpdateAcceptor);

			renameArguments = new ElementRenameArguments(targetElementURI, newName, renameStrategy,
					original2newElementURIs);
			referenceUpdaterDispatcher.createReferenceUpdates(renameArguments, resourceSet, currentUpdateAcceptor,
					progress.newChild(98));
			status.merge(currentUpdateAcceptor.getRefactoringStatus());
		} catch (Exception exc) {
			handleException(exc, status);
		}
		return status.getRefactoringStatus();
	}

	protected void transferChangeRedirector(IRefactoringUpdateAcceptor currentUpdateAcceptor2) {
		if(currentUpdateAcceptor instanceof IChangeRedirector.Aware && renameElementContext instanceof IChangeRedirector.Aware) 
			((IChangeRedirector.Aware) currentUpdateAcceptor).setChangeRedirector(
					((IChangeRedirector.Aware)getRenameElementContext()).getChangeRedirector());
	}

	@Override
	public Change createChange(IProgressMonitor monitor) throws CoreException, OperationCanceledException {
		return currentUpdateAcceptor.createCompositeChange("Rename " + renameStrategy.getOriginalName() + " to "
				+ newName, monitor);
	}

	@Override
	public RefactoringParticipant[] loadParticipants(RefactoringStatus status, SharableParticipants sharedParticipants)
			throws CoreException {
		RenameParticipant[] renameParticipants = ParticipantManager.loadRenameParticipants(status, this,
				renameElementContext, new RenameArguments(newName, true),
				new String[] { XtextProjectHelper.NATURE_ID }, sharedParticipants);
		return renameParticipants;
	}

	protected void handleException(Exception exc, StatusWrapper status) {
		status.add(FATAL, "Error during refactoring: {0}", exc, LOG);
	}

	public IRenameElementContext getRenameElementContext() {
		return renameElementContext;
	}
	
	protected RefactoringResourceSetProvider getResourceSetProvider() {
		return resourceSetProvider;
	}

	protected ElementRenameArguments getRenameArguments() {
		return renameArguments;
	}

	protected EObject getTargetElement() {
		return targetElement;
	}

	public Provider<StatusWrapper> getStatusProvider() {
		return statusProvider;
	}
}
