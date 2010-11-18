/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.RefactoringParticipant;
import org.eclipse.ltk.core.refactoring.participants.SharableParticipants;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.refactoring.IRefactoringDocument;
import org.eclipse.xtext.ui.refactoring.IRenameElementStrategy;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class RenameElementProcessor extends AbstractRenameElementProcessor {

	protected static final Logger LOG = Logger.getLogger(RenameElementProcessor.class);

	@Inject
	private IRefactoringDocument.Provider documentProvider;

	@Inject
	private ReferenceFinder referenceFinder;

	@Inject
	private ReferenceUpdater referenceUpdater;

	private RefactoringStatus status;
	private URI targetElementURI;
	private IRefactoringDocument targetDocument;
	private IRenameElementStrategy strategy;
	private String newName;

	private TextEditAcceptor textEditAcceptor;

	@Override
	public void initialize(final URI targetElementURI, IRenameElementStrategy strategy) {
		status = new RefactoringStatus();
		try {
			this.targetElementURI = targetElementURI;
			this.strategy = strategy;
			targetDocument = documentProvider.get(targetElementURI, status);
		} catch (Exception e) {
			handleException(e);
		}
	}

	@Override
	public IRenameElementStrategy getRenameElementStrategy() {
		return strategy;
	}

	@Override
	public Object[] getElements() {
		return new Object[] { targetElementURI };
	}

	@Override
	public String getIdentifier() {
		return getClass().getName();
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
	public RefactoringStatus checkInitialConditions(IProgressMonitor pm) throws CoreException,
			OperationCanceledException {
		return status;
	}

	@Override
	public RefactoringStatus checkFinalConditions(IProgressMonitor pm, CheckConditionsContext context)
			throws CoreException, OperationCanceledException {
		textEditAcceptor = new TextEditAcceptor();
		try {
			final ReplaceEdit declarationEdit = strategy.getRenameEdit(newName);
			if (declarationEdit == null)
				throw new RefactoringStatusException("Could not create a text edit", true);
			textEditAcceptor.accept(targetDocument, declarationEdit);
			ElementRenameInfo.Table elementRenameInfos = strategy.getRenamedElementInfos();
			final CrossRefRenameInfo.Table crossRefInfos = referenceFinder.findReferences(elementRenameInfos, targetElementURI, targetDocument, status);
			TextEdit undoDeclarationEdit = null;
			try {
				undoDeclarationEdit = targetDocument.apply(declarationEdit);
				targetDocument.readOnly(new IUnitOfWork.Void<XtextResource>() {
					@Override
					public void process(XtextResource resource) throws Exception {
						referenceUpdater.createReferenceUpdates(crossRefInfos, targetDocument, declarationEdit, textEditAcceptor, status);
					}
				});
			} finally {
				if (undoDeclarationEdit != null)
					targetDocument.apply(undoDeclarationEdit);
			}
		} catch (Exception exc) {
			handleException(exc);
		}
		return status;
	}

	@Override
	public Change createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		return textEditAcceptor.getCompositeChange(getProcessorName());
	}

	@Override
	public RefactoringParticipant[] loadParticipants(RefactoringStatus status, SharableParticipants sharedParticipants)
			throws CoreException {
		// TODO
		return null;
	}

	protected void handleException(Exception e) {
		if (e instanceof RefactoringStatusException) {
			((RefactoringStatusException) e).reportToStatus(status);
		} else {
			status.addFatalError("Error during refactoring. See log for details");
			LOG.error(e);
		}
	}
}
