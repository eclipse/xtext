/**
 * Copyright (c) 2017, 2020 by TypeFox (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.refactoring2.rename;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.link.LinkedPosition;
import org.eclipse.jface.text.link.LinkedPositionGroup;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.xtext.ide.refactoring.IRenameStrategy2;
import org.eclipse.xtext.ide.refactoring.RenameChange;
import org.eclipse.xtext.ide.refactoring.RenameContext;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.ide.serializer.ITextDocumentChange;
import org.eclipse.xtext.resource.IGlobalServiceProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.refactoring.ILinkedPositionGroupCalculator;
import org.eclipse.xtext.ui.refactoring.impl.CachingResourceSetProvider;
import org.eclipse.xtext.ui.refactoring.impl.ProjectUtil;
import org.eclipse.xtext.ui.refactoring.impl.RefactoringResourceSetProvider;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.ui.refactoring2.LtkIssueAcceptor;

import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Calculates the linked positions for simultaneous editing when a refactoring is triggered in linked mode.
 * 
 * @author Jan Koehnlein
 */
public class DefaultLinkedPositionGroupCalculator2 implements ILinkedPositionGroupCalculator {

	private static final Logger LOG = Logger.getLogger(DefaultLinkedPositionGroupCalculator2.class);

	@Inject
	private ProjectUtil projectUtil;

	@Inject
	private RefactoringResourceSetProvider resourceSetProvider;

	@Inject
	private ISimpleNameProvider simpleNameProvider;

	@Inject
	private IGlobalServiceProvider globalServiceProvider;

	@Inject
	private IResourceServiceProvider.Registry resourceServiceProviderRegistry;

	@Override
	public Provider<LinkedPositionGroup> getLinkedPositionGroup(IRenameElementContext renameElementContext, IProgressMonitor monitor) {
		SubMonitor progress = SubMonitor.convert(monitor, 100);
		XtextEditor editor = (XtextEditor) renameElementContext.getTriggeringEditor();
		IProject project = projectUtil.getProject(renameElementContext.getContextResourceURI());
		if (project == null) {
			throw new IllegalStateException(
					"Could not determine the project for context resource " + renameElementContext.getContextResourceURI());
		}

		CachingResourceSetProvider cachingResourceSetProvider = new CachingResourceSetProvider(resourceSetProvider);
		ResourceSet resourceSet = cachingResourceSetProvider.get(project);
		EObject targetElement = resourceSet.getEObject(renameElementContext.getTargetElementURI(), true);
		if (targetElement == null) {
			throw new IllegalStateException("Target element could not be loaded");
		}

		if (monitor.isCanceled()) {
			throw new OperationCanceledException();
		}

		IRenameStrategy2 renameStrategy = globalServiceProvider.findService(targetElement, IRenameStrategy2.class);
		if (renameStrategy == null) {
			throw new IllegalArgumentException("Cannot find a rename strategy for " + renameElementContext.getTargetElementURI());
		}

		String oldName = simpleNameProvider.getSimpleName(targetElement);
		String newName = getNewDummyName(oldName);
		IResourceServiceProvider resourceServiceProvider = resourceServiceProviderRegistry
				.getResourceServiceProvider(renameElementContext.getTargetElementURI());
		LtkIssueAcceptor issues = resourceServiceProvider.get(LtkIssueAcceptor.class);
		IChangeSerializer changeSerializer = resourceServiceProvider.get(IChangeSerializer.class);
		changeSerializer.setUpdateRelatedFiles(false);
		RenameChange change = new RenameChange(newName, renameElementContext.getTargetElementURI());
		RenameContext renameContext = new RenameContext(Lists.newArrayList(change), resourceSet, changeSerializer, issues);
		renameStrategy.applyRename(renameContext);

		List<ReplaceEdit> replaceEdits = new ArrayList<>();
		changeSerializer.applyModifications(c -> {
			if (c instanceof ITextDocumentChange) {
				ITextDocumentChange textDocumentChange = (ITextDocumentChange) c;
				textDocumentChange.getReplacements().forEach(replacement -> {
					replaceEdits.add(new ReplaceEdit(replacement.getOffset(), replacement.getLength(), replacement.getReplacementText()));
				});
			}
		});

		if (monitor.isCanceled()) {
			throw new OperationCanceledException();
		}

		return () -> {
			return createLinkedGroupFromReplaceEdits(replaceEdits, editor, oldName, progress.newChild(10));
		};
	}

	protected String getNewDummyName(String oldName) {
		return oldName + oldName;
	}

	protected LinkedPositionGroup createLinkedGroupFromReplaceEdits(List<ReplaceEdit> edits, XtextEditor xtextEditor, String originalName,
			SubMonitor progress) {
		if (edits == null) {
			return null;
		}

		IXtextDocument document = xtextEditor.getDocument();
		LinkedPositionGroup group = new LinkedPositionGroup();
		List<LinkedPosition> linkedPositions = new ArrayList<>();
		edits.forEach(replaceEdit -> {
			try {
				String textToReplace = document.get(replaceEdit.getOffset(), replaceEdit.getLength());
				int indexOf = textToReplace.indexOf(originalName);
				if (indexOf != -1) {
					int calculatedOffset = replaceEdit.getOffset() + indexOf;
					linkedPositions.add(new LinkedPosition(document, calculatedOffset, originalName.length()));
				}
			} catch (BadLocationException exc) {
				LOG.error("Skipping invalid text edit " + replaceEdit, exc);
			}
		});

		progress.worked(10);

		int invocationOffset = xtextEditor.getInternalSourceViewer().getSelectedRange().x;
		int i = 0;
		for (LinkedPosition position : sortPositions(linkedPositions, invocationOffset)) {
			try {
				position.setSequenceNumber(i);
				i++;
				group.addPosition(position);
			} catch (BadLocationException e) {
				LOG.error(e.getMessage(), e);
				return null;
			}
		}
		return group;
	}

	protected Iterable<LinkedPosition> sortPositions(Iterable<LinkedPosition> linkedPositions, int invocationOffset) {
		Comparator<LinkedPosition> comparator = new Comparator<LinkedPosition>() {

			@Override
			public int compare(LinkedPosition left, LinkedPosition right) {
				return rank(left) - rank(right);
			}

			private int rank(LinkedPosition o1) {
				int relativeRank = (o1.offset + o1.length) - invocationOffset;
				if (relativeRank < 0) {
					return Integer.MAX_VALUE + relativeRank;
				} else {
					return relativeRank;
				}
			}
		};
		return ImmutableSortedSet.copyOf(comparator, linkedPositions);
	}
}
