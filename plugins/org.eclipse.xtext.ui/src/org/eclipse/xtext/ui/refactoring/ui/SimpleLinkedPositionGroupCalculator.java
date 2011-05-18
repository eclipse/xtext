/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.ui;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.text.link.LinkedPositionGroup;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.findrefs.IReferenceFinder;
import org.eclipse.xtext.ui.editor.findrefs.IReferenceFinder.IQueryData;
import org.eclipse.xtext.ui.editor.findrefs.SimpleLocalResourceAccess;
import org.eclipse.xtext.ui.refactoring.ElementRenameArguments;
import org.eclipse.xtext.ui.refactoring.IDependentElementsCalculator;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;
import org.eclipse.xtext.ui.refactoring.IReferenceUpdater;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.ui.refactoring.IRenamedElementTracker;
import org.eclipse.xtext.ui.refactoring.impl.IRefactoringDocument;
import org.eclipse.xtext.ui.refactoring.impl.ProjectUtil;
import org.eclipse.xtext.ui.refactoring.impl.RefactoringReferenceQueryDataFactory;
import org.eclipse.xtext.ui.refactoring.impl.RefactoringResourceSetProvider;
import org.eclipse.xtext.util.IAcceptor;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class SimpleLinkedPositionGroupCalculator extends AbstractLinkedPositionGroupCalculator {

	@Inject
	private ProjectUtil projectUtil;

	@Inject
	private RefactoringResourceSetProvider resourceSetProvider;

	@Inject
	private IRenameStrategy.Provider strategyProvider;

	@Inject
	private IRenamedElementTracker renamedElementTracker;

	@Inject
	private IDependentElementsCalculator dependentElementsCalculator;

	@Inject
	private RefactoringReferenceQueryDataFactory queryDataFactory;

	@Inject
	private IReferenceFinder referenceFinder;

	@Inject
	private IReferenceUpdater referenceUpdater;

	public LinkedPositionGroup getLinkedPositionGroup(IRenameElementContext renameElementContext,
			IProgressMonitor monitor) {
		SubMonitor progress = SubMonitor.convert(monitor, 100);
		XtextEditor editor = (XtextEditor) renameElementContext.getTriggeringEditor();
		IProject project = projectUtil.getProject(renameElementContext.getContextResourceURI());
		ResourceSet resourceSet = resourceSetProvider.get(project);
		EObject targetElement = resourceSet.getEObject(renameElementContext.getTargetElementURI(), true);
		if (targetElement == null)
			throw new IllegalStateException("Target element could not be loaded");
		IRenameStrategy renameStrategy = strategyProvider.get(targetElement, renameElementContext);
		if (renameStrategy == null)
			throw new IllegalArgumentException("Cannot find a rename strategy for "
					+ notNull(renameElementContext.getTargetElementURI()));
		String newName = renameStrategy.getOriginalName();
		Iterable<URI> dependentElementURIs = dependentElementsCalculator.getDependentElementURIs(targetElement,
				progress.newChild(10));
		LocalResourceRefactoringUpdateAcceptor updateAcceptor = new LocalResourceRefactoringUpdateAcceptor(
				renameElementContext.getContextResourceURI());
		renameStrategy.createDeclarationUpdates(newName, resourceSet, updateAcceptor);
		Map<URI, URI> original2newEObjectURI = renamedElementTracker.renameAndTrack(
				concat(Collections.singleton(renameElementContext.getTargetElementURI()), dependentElementURIs),
				newName, resourceSet, renameStrategy, progress.newChild(10));
		ElementRenameArguments elementRenameArguments = new ElementRenameArguments(
				renameElementContext.getTargetElementURI(), newName, renameStrategy, original2newEObjectURI);
		IQueryData queryData = queryDataFactory.create(elementRenameArguments);
		final List<IReferenceDescription> referenceDescriptions = newArrayList();
		IAcceptor<IReferenceDescription> referenceAcceptor = new IAcceptor<IReferenceDescription>() {
			public void accept(IReferenceDescription referenceDescription) {
				referenceDescriptions.add(referenceDescription);
			}
		};
		if (renameElementContext.getTargetElementURI().trimFragment()
				.equals(renameElementContext.getContextResourceURI()))
			referenceFinder.findLocalReferences(queryData, new SimpleLocalResourceAccess(resourceSet),
					referenceAcceptor, progress.newChild(60));
		else
			referenceFinder.findIndexedReferences(queryData, renameElementContext.getContextResourceURI(),
					referenceAcceptor, progress.newChild(60));
		referenceUpdater.createReferenceUpdates(elementRenameArguments, referenceDescriptions, updateAcceptor,
				progress.newChild(10));
		List<ReplaceEdit> textEdits = updateAcceptor.getTextEdits();
		LinkedPositionGroup linkedGroup = createLinkedGroupFromReplaceEdits(textEdits, editor,
				renameStrategy.getOriginalName(), progress.newChild(10));
		return linkedGroup;
	}

	public static class LocalResourceRefactoringUpdateAcceptor implements IRefactoringUpdateAcceptor {

		private List<ReplaceEdit> textEdits = newArrayList();
		private final URI localResourceURI;

		public LocalResourceRefactoringUpdateAcceptor(URI localResourceURI) {
			this.localResourceURI = localResourceURI;
		}

		public List<ReplaceEdit> getTextEdits() {
			return textEdits;
		}

		public RefactoringStatus getRefactoringStatus() {
			return null;
		}

		public IRefactoringDocument getDocument(URI resourceURI) {
			return null;
		}

		public Change createCompositeChange(String name, IProgressMonitor monitor) {
			return null;
		}

		public void accept(URI resourceURI, Change change) {
			// ignore
		}

		public void accept(URI resourceURI, TextEdit textEdit) {
			if (localResourceURI.equals(resourceURI) && textEdit instanceof ReplaceEdit) {
				textEdits.add((ReplaceEdit) textEdit);
			}
		}
	}

}
