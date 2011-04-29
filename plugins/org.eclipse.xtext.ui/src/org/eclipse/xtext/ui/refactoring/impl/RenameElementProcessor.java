/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import static com.google.common.collect.Iterables.*;

import java.util.Collections;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.xtext.ui.refactoring.IDependentElementsCalculator;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.ui.refactoring.IRenamedElementTracker;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.ui.util.ResourceUtil;

import com.google.inject.Inject;
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

	@Inject@Named(Constants.LANGUAGE_NAME)
	private String languageName;
	
	private IRenameElementContext renameElementContext;
	private ResourceSet resourceSet;
	private RefactoringStatus status;
	private URI targetElementURI;
	private EObject targetElement;
	private IRenameStrategy renameStrategy;
	private String newName;

	@Inject
	private IRefactoringUpdateAcceptor updateAcceptor;

	private ElementRenameArguments renameArguments;


	@Override
	public boolean initialize(final IRenameElementContext renameElementContext) {
		status = new RefactoringStatus();
		try {
			this.renameElementContext = renameElementContext;
			this.targetElementURI = renameElementContext.getTargetElementURI();
			resourceSet = resourceSetProvider.get(projectUtil.getProject(targetElementURI));
			targetElement = resourceSet.getEObject(targetElementURI, true);
			if (targetElement == null) {
				throw new RefactoringStatusException("Rename target element can not be resolved", true);
			}
			IFile targetFile = ResourceUtil.getFile(targetElement.eResource());
			if(targetFile == null || !targetFile.isAccessible())
				throw new RefactoringStatusException("Rename target cannot be accessed", true);
			if(targetFile.isReadOnly())
				throw new RefactoringStatusException("Target file is read-only", true);
			this.renameStrategy = strategyProvider.get(targetElement, renameElementContext);
			if(this.renameStrategy == null)
				return false;
		} catch (Exception e) {
			handleException(status, e);
			if(status.getSeverity()==RefactoringStatus.FATAL)
				throw (e instanceof RuntimeException) ? (RuntimeException) e : new WrappedException(e);
		}
		return true;
	}

	@Override
	public IRenameStrategy getRenameElementStrategy() {
		return renameStrategy;
	}

	@Override
	public Object[] getElements() {
		return new Object[] { targetElementURI };
	}
	
	public String getOriginalName() {
		return renameStrategy.getOriginalName();
	}

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
		return status;
	}

	@Override
	public RefactoringStatus checkFinalConditions(IProgressMonitor monitor, CheckConditionsContext context)
			throws CoreException, OperationCanceledException {
		SubMonitor progress = SubMonitor.convert(monitor, 100);
		try {
			Iterable<URI> dependentElementURIs = dependentElementsCalculator.getDependentElementURIs(targetElement,
					progress.newChild(1));
			Map<URI, URI> original2newElementURIs = renameElementTracker.renameAndTrack(
					concat(Collections.singleton(targetElementURI), dependentElementURIs), newName, resourceSet,
					renameStrategy, progress.newChild(1));
			renameStrategy.createDeclarationUpdates(newName, resourceSet, updateAcceptor);

			renameArguments = new ElementRenameArguments(targetElementURI, newName, renameStrategy,
					original2newElementURIs, renameElementContext.getContextResourceURI());
			referenceUpdaterDispatcher.createReferenceUpdates(renameArguments, resourceSet, updateAcceptor,
					progress.newChild(98));
			status.merge(updateAcceptor.getRefactoringStatus());
		} catch (Exception exc) {
			handleException(status, exc);
		}
		return status;
	}

	@Override
	public Change createChange(IProgressMonitor monitor) throws CoreException, OperationCanceledException {
		return updateAcceptor.createCompositeChange("Rename " + renameStrategy.getOriginalName() + " to " + newName,
				monitor);
	}

	@Override
	public RefactoringParticipant[] loadParticipants(RefactoringStatus status, SharableParticipants sharedParticipants)
			throws CoreException {
		RenameParticipant[] renameParticipants = ParticipantManager.loadRenameParticipants(status, this,
				renameElementContext, new RenameArguments(newName, true), new String[] { XtextProjectHelper.NATURE_ID }, sharedParticipants);
		return renameParticipants;
	}

	public void handleException(RefactoringStatus status, Exception exc) {
		if (exc instanceof RefactoringStatusException) {
			if (((RefactoringStatusException) exc).isFatal())
				status.addFatalError(exc.getMessage());
			else
				status.addError(exc.getMessage());
		} else {
			status.addFatalError("Error during refactoring: " + exc.getMessage() + ". See log for details");
			LOG.error("Error during refactoring", exc);
		}
	}

}
