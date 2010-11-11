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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.RefactoringParticipant;
import org.eclipse.ltk.core.refactoring.participants.RenameProcessor;
import org.eclipse.ltk.core.refactoring.participants.SharableParticipants;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.refactoring.IRenameElementProcessor;
import org.eclipse.xtext.ui.refactoring.IRenameElementStrategy;
import org.eclipse.xtext.ui.util.DisplayRunnableWithResult;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class RenameElementProcessor extends RenameProcessor implements IRenameElementProcessor {

	protected static final Logger LOG = Logger.getLogger(RenameElementProcessor.class);

	@Inject
	private RefactoringDocument.Factory documentFactory;

	@Inject
	private ReferenceUpdater referenceUpdater;

	@Inject
	private IResourceDescriptions index;

	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;

	private RefactoringStatus status;
	private IEObjectDescription target;
	private RefactoringDocument targetDocument;
	private IRenameElementStrategy strategy;
	private String newName;

	private TextEditAcceptor acceptor;

	public void initialize(final IEObjectDescription target, IRenameElementStrategy strategy) {
		status = new RefactoringStatus();
		try {
			this.target = target;
			this.strategy = strategy;
			targetDocument = documentFactory.create(target.getEObjectURI(), status);
		} catch (Exception e) {
			handleException(e);
		}
	}

	public IRenameElementStrategy getRenameElementStrategy() {
		return strategy;
	}

	@Override
	public Object[] getElements() {
		return new Object[] { target };
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
		acceptor = new TextEditAcceptor();
		try {
			final ReplaceEdit declarationEdit = strategy.getRenameEdit(newName);
			if (declarationEdit == null)
				throw new RefactoringStatusException("Could not create a text edit", true);
			acceptor.accept(targetDocument, declarationEdit);
			final Multimap<IResourceDescription, IReferenceDescription> referenceMap = findReferencesInIndex(target);
			TextEdit undoDeclarationEdit = null;
			try {
				undoDeclarationEdit = applyInDisplayThread(declarationEdit, targetDocument);
				targetDocument.getXtextDocument().readOnly(new IUnitOfWork.Void<XtextResource>() {
					@Override
					public void process(XtextResource resource) throws Exception {
						// eObjectURI might have changed with the declaration so we use the offset 
						EObject newTargetEObject = eObjectAtOffsetHelper.resolveElementAt(resource,
								declarationEdit.getOffset());
						createReferenceUpdates(referenceMap, acceptor, status, newTargetEObject, declarationEdit);
					}
				});
			} finally {
				if (undoDeclarationEdit != null)
					applyInDisplayThread(undoDeclarationEdit, targetDocument);
			}
		} catch (Exception exc) {
			handleException(exc);
		}
		return status;
	}

	@Override
	public Change createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		return acceptor.getChange(getProcessorName());
	}

	protected Multimap<IResourceDescription, IReferenceDescription> findReferencesInIndex(
			IEObjectDescription targetEObjectDescription) {
		Multimap<IResourceDescription, IReferenceDescription> resource2References = HashMultimap.create();
		for (IResourceDescription resourceDescription : index.getAllResourceDescriptions()) {
			for (IReferenceDescription referenceDescription : resourceDescription.getReferenceDescriptions()) {
				if (referenceDescription.getTargetEObjectUri().equals(targetEObjectDescription.getEObjectURI())) {
					resource2References.put(resourceDescription, referenceDescription);
				}
			}
		}
		return resource2References;
	}

	protected void createReferenceUpdates(Multimap<IResourceDescription, IReferenceDescription> referenceMap,
			TextEditAcceptor acceptor, RefactoringStatus status, EObject newTargetEObject, ReplaceEdit declarationEdit) {
		for (IResourceDescription referringResourceDesc : referenceMap.keySet()) {
			if (referringResourceDesc.getURI().equals(target.getEObjectURI().trimFragment())) {
				referenceUpdater.createReferenceUpdates(targetDocument, referenceMap.get(referringResourceDesc),
						newTargetEObject, acceptor, declarationEdit, status);
			} else {
				RefactoringDocument referringDocument = documentFactory.create(referringResourceDesc.getURI(), status);
				referenceUpdater.createReferenceUpdates(referringDocument, referenceMap.get(referringResourceDesc),
						newTargetEObject, acceptor, null, status);
			}
		}
	}

	@Override
	public RefactoringParticipant[] loadParticipants(RefactoringStatus status, SharableParticipants sharedParticipants)
			throws CoreException {
		// TODO
		return null;
	}

	protected TextEdit applyInDisplayThread(TextEdit edit, RefactoringDocument document) {
		// edits change when being applied !? so we apply a copy
		final TextEdit editToBeApplied = edit.copy();
		TextEdit undoEdit = new DisplayRunnableWithResult<TextEdit>() {
			@Override
			public TextEdit run() throws Exception {
				return editToBeApplied.apply(targetDocument.getXtextDocument());
			}
		}.syncExec();
		return undoEdit;
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
