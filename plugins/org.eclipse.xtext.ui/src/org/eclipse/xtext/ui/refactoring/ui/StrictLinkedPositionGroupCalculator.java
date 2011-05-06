/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.ui;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.link.LinkedPositionGroup;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.RefactoringTickProvider;
import org.eclipse.ltk.core.refactoring.participants.ProcessorBasedRefactoring;
import org.eclipse.ltk.core.refactoring.participants.RenameProcessor;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.xtext.resource.IGlobalServiceProvider;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.refactoring.IRenameProcessorAdapter;
import org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider;

import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 * @author Jan Koehnlein
 */
public class StrictLinkedPositionGroupCalculator extends AbstractLinkedPositionGroupCalculator {

	@Inject
	private ReplaceEditExtractor replaceEditExtractor;

	@Inject
	private IRenameProcessorAdapter.Factory renameProcessorAdapterFactory;

	@Inject
	private IGlobalServiceProvider globalServiceProvider;

	private Logger log = Logger.getLogger(StrictLinkedPositionGroupCalculator.class);

	protected ProcessorBasedRefactoring createRenameRefactoring(IRenameElementContext renameElementContext) {
		IRenameRefactoringProvider renameRefactoringProvider = globalServiceProvider.findService(
				renameElementContext.getTargetElementURI(), IRenameRefactoringProvider.class);
		return renameRefactoringProvider.getRenameRefactoring(renameElementContext);
	}

	public LinkedPositionGroup getLinkedPositionGroup(final IRenameElementContext renameElementContext,
			IProgressMonitor monitor) {
		try {
			final ProcessorBasedRefactoring renameRefactoring = createRenameRefactoring(renameElementContext);
			final LinkedPositionGroup[] result = new LinkedPositionGroup[1];
			result[0] = internalGetLinkedPositionGroup(renameElementContext, renameRefactoring, monitor);
			if (monitor.isCanceled())
				result[0] = null;
			else
				monitor.done();
			return result[0];
		} catch (Exception exc) {
			throw new WrappedException(exc);
		}
	}

	protected LinkedPositionGroup internalGetLinkedPositionGroup(IRenameElementContext renameElementContext,
			final ProcessorBasedRefactoring renameRefactoring, IProgressMonitor monitor) {
		SubMonitor progress = SubMonitor.convert(monitor, 100);
		XtextEditor xtextEditor = (XtextEditor) renameElementContext.getTriggeringEditor();
		final IXtextDocument document = xtextEditor.getDocument();
		IRenameProcessorAdapter renameProcessorAdapter = renameProcessorAdapterFactory.create((RenameProcessor) renameRefactoring.getProcessor());
		final String originalName = renameProcessorAdapter.getOriginalName();
		renameProcessorAdapter.setNewName(getDummyNewName(originalName));
		List<ReplaceEdit> edits = computeReplaceEditsForDocument(renameRefactoring, document, progress.newChild(80));
		return createLinkedGroupFromReplaceEdits(edits, xtextEditor, originalName, progress);
	}

	/**
	 * JDT refactorings must change the name.
	 */
	protected String getDummyNewName(String originalName) {
		return originalName + "_____";
	}

	protected List<ReplaceEdit> computeReplaceEditsForDocument(ProcessorBasedRefactoring renameRefactoring,
			IDocument document, IProgressMonitor monitor) {
		try {
			RefactoringTickProvider ticks = renameRefactoring.getRefactoringTickProvider();
			SubMonitor subMonitor = SubMonitor.convert(monitor, ticks.getAllTicks());
			RefactoringStatus result = renameRefactoring.checkInitialConditions(subMonitor.newChild(ticks
					.getCheckInitialConditionsTicks()));
			if (!result.hasError()) {
				result.merge(renameRefactoring.checkFinalConditions(subMonitor.newChild(ticks
						.getCheckFinalConditionsTicks())));
				if (!result.hasError()) {
					Change change = renameRefactoring.createChange(subMonitor.newChild(ticks.getCreateChangeTicks()));
					return replaceEditExtractor.getReplaceEditsForDocument(change, document);
				}
			}
		} catch (CoreException e) {
			log.error("Error calculating refactoring changes", e);
		}
		return null;
	}
}
