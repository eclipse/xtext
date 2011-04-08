/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import static com.google.common.collect.Iterables.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.link.LinkedPosition;
import org.eclipse.jface.text.link.LinkedPositionGroup;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.ui.IWorkbench;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.findrefs.IReferenceFinder;
import org.eclipse.xtext.ui.editor.findrefs.SimpleLocalResourceAccess;
import org.eclipse.xtext.ui.refactoring.ElementRenameArguments;
import org.eclipse.xtext.ui.refactoring.IDependentElementsCalculator;
import org.eclipse.xtext.ui.refactoring.ILinkedModelCalculator;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;
import org.eclipse.xtext.ui.refactoring.IReferenceUpdater;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.ui.refactoring.IRenamedElementTracker;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.Strings;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class LinkedModelCalculator implements ILinkedModelCalculator {

	@Inject
	private IDependentElementsCalculator dependentElementsCalculator;
	@Inject
	private RefactoringResourceSetProvider resourceSetProvider;
	@Inject
	private IWorkspace workspace;
	@Inject
	private IWorkbench workbench;
	@Inject
	private IRenamedElementTracker renameElementTracker;
	@Inject
	private IReferenceFinder referenceFinder;
	@Inject
	private IReferenceUpdater referenceUpdater;
	@Inject
	private IRenameStrategy.Provider strategyProvider;
	@Inject
	private RefactoringReferenceQueryDataFactory queryDataFactory;

	private ElementRenameArguments renameArguments;
	private IRenameStrategy renameStrategy;
	private URI targetElementURI;
	private EObject targetElement;
	private ResourceSet resourceSet;
	private URI contextResourceURI;
	private IDocument document;
	private ISourceViewer viewer;

	private Logger log = Logger.getLogger(LinkedModelCalculator.class);

	public void init(IRenameElementContext renameElementContext) {
		this.targetElementURI = renameElementContext.getTargetElementURI();
		this.contextResourceURI = renameElementContext.getContextResourceURI();
		resourceSet = resourceSetProvider.get(getProject(targetElementURI));
		targetElement = resourceSet.getEObject(targetElementURI, true);
		XtextEditor xtextEditor = (XtextEditor) renameElementContext.getTriggeringEditor();
		document = xtextEditor.getDocument();
		viewer = xtextEditor.getInternalSourceViewer();
		if (targetElement == null) {
			throw new RefactoringStatusException("Rename target element can not be resolved", true);
		}
		this.renameStrategy = strategyProvider.get(targetElement, renameElementContext);
	}

	public IRenameStrategy getRenameStrategy() {
		return renameStrategy;
	}

	public LinkedPositionGroup getLinkedPositionGroup() {
		try {
			final LinkedPositionGroup[] result = new LinkedPositionGroup[1];
			getWorkbench().getActiveWorkbenchWindow().run(false, true, new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					result[0] = internalGetLinkedPositionGroup(monitor);
					if(monitor.isCanceled()) 
						result[0] = null;
					else
						monitor.done();
				}
			});
			return result[0];
		} catch (Exception exc) {
			throw new WrappedException(exc);
		}
	}

	protected LinkedPositionGroup internalGetLinkedPositionGroup(IProgressMonitor monitor) {
		SubMonitor progress = SubMonitor.convert(monitor, 100);
		Iterable<TextEdit> edits = computeTextEdits(progress.newChild(80));
		if(edits == null) 
			return null;
		LinkedPositionGroup group = new LinkedPositionGroup();
		Iterable<LinkedPosition> linkedPositions = filter(
				Iterables.transform(edits, new Function<TextEdit, LinkedPosition>() {
					public LinkedPosition apply(TextEdit textEdit) {
						if (textEdit instanceof ReplaceEdit) {
							String originalName = getOriginalName();
							ReplaceEdit edit = (ReplaceEdit) textEdit;
							try {
								String textToReplace = getDocument().get(edit.getOffset(), edit.getLength());
								int indexOf = textToReplace.indexOf(originalName);
								if (indexOf != -1) {
									int calculatedOffset = edit.getOffset() + indexOf;
									return new LinkedPosition(getDocument(), calculatedOffset, originalName.length());
								}
							} catch(BadLocationException exc) {
								log.error(exc.getMessage(), exc);
							}
						}
						return null;
					}
				}), Predicates.notNull());
		progress.worked(10);
		final int invocationOffset = getInvocationOffset();
		int i = 0;
		for (LinkedPosition position : sortPositions(linkedPositions, invocationOffset)) {
			try {
				position.setSequenceNumber(i);
				i++;
				group.addPosition(position);
			} catch (BadLocationException e) {
				log.error(e.getMessage(), e);
				return null;
			}
		}
		return group;
	}

	protected Iterable<LinkedPosition> sortPositions(Iterable<LinkedPosition> linkedPositions,
			final int invocationOffset) {
		Comparator<LinkedPosition> comparator = new Comparator<LinkedPosition>() {

			public int compare(LinkedPosition left, LinkedPosition right) {
				return rank(left) - rank(right);
			}

			private int rank(LinkedPosition o1) {
				int relativeRank = o1.getOffset() + o1.length - invocationOffset;
				if (relativeRank < 0)
					return Integer.MAX_VALUE + relativeRank;
				else
					return relativeRank;
			}
		};
		return ImmutableSortedSet.copyOf(comparator, linkedPositions);
	}

	public Iterable<TextEdit> computeTextEdits(IProgressMonitor monitor) {
		SubMonitor progress = SubMonitor.convert(monitor, 100);
		LinkedModelUpdateAcceptor updateAcceptor = new LinkedModelUpdateAcceptor();
		String originalName = getOriginalName();
		Iterable<URI> dependentElementURIs = dependentElementsCalculator.getDependentElementURIs(targetElement,
				progress.newChild(1));
		Map<URI, URI> original2newElementURIs = renameElementTracker.renameAndTrack(
				concat(Collections.singleton(targetElementURI), dependentElementURIs), originalName, resourceSet,
				renameStrategy, progress.newChild(1));
		// Handle in contextResourceURI to define that references should looked up only in resource that builds the context
		renameArguments = new ElementRenameArguments(targetElementURI, originalName, renameStrategy,
				original2newElementURIs, true, contextResourceURI);

		// Declaration in in current Resource
		if (contextResourceURI.equals(targetElementURI.trimFragment())) {
			renameStrategy.createDeclarationUpdates(originalName, updateAcceptor);
		}
		ReferenceDescriptionAcceptor referenceDescriptionAcceptor = new ReferenceDescriptionAcceptor();
		IReferenceFinder.IQueryData referenceQueryData = queryDataFactory.create(renameArguments);
		referenceFinder.findLocalReferences(referenceQueryData, new SimpleLocalResourceAccess(resourceSet),
				referenceDescriptionAcceptor, progress.newChild(40));
		if(progress.isCanceled()) 
			return null;
		Iterable<IReferenceDescription> localRedefernceDescriptions = referenceDescriptionAcceptor
				.getReferenceDescriptions();
		referenceUpdater.createReferenceUpdates(renameArguments, localRedefernceDescriptions, updateAcceptor, progress.newChild(48));
		if(progress.isCanceled()) 
			return null;
		return updateAcceptor.getTextEdits();
	}

	public IProject getProject(URI targetElementURI) {
		if (!targetElementURI.isPlatformResource())
			throw new IllegalArgumentException("Refactored element URI must be a platform resource URI: "
					+ Strings.notNull(targetElementURI));
		String projectName = targetElementURI.segment(1);
		IProject project = workspace.getRoot().getProject(projectName);
		if (project == null)
			throw new IllegalArgumentException("Cannot find containing project for "
					+ Strings.notNull(targetElementURI));
		return project;
	}

	protected String getOriginalName() {
		return renameStrategy.getOriginalName();
	}

	protected int getInvocationOffset() {
		return viewer.getSelectedRange().x;
	}

	protected IDocument getDocument() {
		return document;
	}

	protected IWorkbench getWorkbench() {
		return workbench;
	}
	
	public static class LinkedModelUpdateAcceptor implements IRefactoringUpdateAcceptor {

		private Set<TextEdit> edits = Sets.newHashSet();

		public void accept(URI resourceURI, TextEdit textEdit) {
			edits.add(textEdit);
		}

		public void accept(URI resourceURI, Change change) {
			throw new UnsupportedOperationException("Method not supported!");
		}

		public RefactoringStatus getRefactoringStatus() {
			throw new UnsupportedOperationException("Method not supported!");
		}

		public IRefactoringDocument getDocument(URI resourceURI) {
			throw new UnsupportedOperationException("Method not supported!");
		}

		public Change createCompositeChange(String name, IProgressMonitor monitor) {
			throw new UnsupportedOperationException("Method not supported!");
		}

		public Iterable<TextEdit> getTextEdits() {
			return edits;
		}
	}

	public static class ReferenceDescriptionAcceptor implements IAcceptor<IReferenceDescription> {

		private Set<IReferenceDescription> referenceDescriptions = Sets.newHashSet();

		public void accept(IReferenceDescription referenceDescription) {
			referenceDescriptions.add(referenceDescription);
		}

		public Iterable<IReferenceDescription> getReferenceDescriptions() {
			return referenceDescriptions;
		}
	}
}
