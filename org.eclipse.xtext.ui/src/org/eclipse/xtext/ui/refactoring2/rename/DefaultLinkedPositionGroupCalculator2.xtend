/** 
 * Copyright (c) 2017 by TypeFox (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.refactoring2.rename

import com.google.common.collect.ImmutableSortedSet
import com.google.inject.Inject
import com.google.inject.Provider
import java.util.Comparator
import java.util.List
import org.apache.log4j.Logger
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.core.runtime.SubMonitor
import org.eclipse.jface.text.BadLocationException
import org.eclipse.jface.text.link.LinkedPosition
import org.eclipse.jface.text.link.LinkedPositionGroup
import org.eclipse.text.edits.ReplaceEdit
import org.eclipse.xtext.ide.refactoring.RenameChange
import org.eclipse.xtext.ide.refactoring.RenameContext
import org.eclipse.xtext.ide.serializer.IChangeSerializer
import org.eclipse.xtext.ide.serializer.ITextDocumentChange
import org.eclipse.xtext.resource.IGlobalServiceProvider
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.ui.editor.XtextEditor
import org.eclipse.xtext.ui.refactoring.ILinkedPositionGroupCalculator
import org.eclipse.xtext.ui.refactoring.impl.CachingResourceSetProvider
import org.eclipse.xtext.ui.refactoring.impl.ProjectUtil
import org.eclipse.xtext.ui.refactoring.impl.RefactoringResourceSetProvider
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext
import org.eclipse.xtext.ui.refactoring2.LtkIssueAcceptor
import org.eclipse.xtext.ide.refactoring.IRenameStrategy2

/** 
 * Calculates the linked positions for simultaneous editing when a refactoring is triggered in linked mode.
 * 
 * @author Jan Koehnlein 
 */
class DefaultLinkedPositionGroupCalculator2 implements ILinkedPositionGroupCalculator {

	static val LOG = Logger.getLogger(DefaultLinkedPositionGroupCalculator2)

	@Inject ProjectUtil projectUtil

	@Inject RefactoringResourceSetProvider resourceSetProvider

	@Inject ISimpleNameProvider simpleNameProvider

	@Inject IGlobalServiceProvider globalServiceProvider

	@Inject IResourceServiceProvider.Registry resourceServiceProviderRegistry

	override Provider<LinkedPositionGroup> getLinkedPositionGroup(IRenameElementContext renameElementContext,
		IProgressMonitor monitor) {
		val progress = SubMonitor.convert(monitor, 100)
		val editor = renameElementContext.getTriggeringEditor() as XtextEditor
		val project = projectUtil.getProject(renameElementContext.contextResourceURI)
		if (project === null)
			throw new IllegalStateException(
				'''Could not determine project for context resource «renameElementContext.getContextResourceURI()»'''.
					toString)
		val resourceSetProvider = new CachingResourceSetProvider(this.resourceSetProvider)
		val resourceSet = resourceSetProvider.get(project)
		val targetElement = resourceSet.getEObject(renameElementContext.targetElementURI, true)
		if (targetElement === null)
			throw new IllegalStateException("Target element could not be loaded");
		if (monitor.canceled)
			throw new OperationCanceledException

		var renameStrategy = globalServiceProvider.findService(targetElement, typeof(IRenameStrategy2))
		if (renameStrategy === null)
			throw new IllegalArgumentException('''Cannot find a rename strategy for «renameElementContext.targetElementURI»''');

		val oldName = simpleNameProvider.getSimpleName(targetElement)
		val newName = getNewDummyName(oldName)
		val resourceServiceProvider = resourceServiceProviderRegistry.getResourceServiceProvider(
			renameElementContext.targetElementURI)
		val issues = resourceServiceProvider.get(LtkIssueAcceptor)
		val changeSerializer = resourceServiceProvider.get(IChangeSerializer)
		changeSerializer.setUpdateRelatedFiles(false)
		val change = new RenameChange(newName, renameElementContext.targetElementURI)
		val renameContext = new RenameContext(#[change], resourceSet, changeSerializer, issues)
		renameStrategy.applyRename(renameContext)
		val replaceEdits = <ReplaceEdit>newArrayList
		changeSerializer.applyModifications([ c |
			if (c instanceof ITextDocumentChange)
				replaceEdits += c.replacements.map [ replacement |
					new ReplaceEdit(replacement.offset, replacement.length, replacement.replacementText)
				]
		])
		if (monitor.canceled)
			throw new OperationCanceledException

		return [
			createLinkedGroupFromReplaceEdits(replaceEdits, editor, oldName, progress.newChild(10))
		]
	}
	
	protected def String getNewDummyName(String oldName) {
		oldName + oldName
	}

	protected def LinkedPositionGroup createLinkedGroupFromReplaceEdits(
			List<ReplaceEdit> edits, XtextEditor xtextEditor, String originalName, SubMonitor progress) {
		if (edits === null)
			return null
		val document = xtextEditor.document
		val group = new LinkedPositionGroup
		val linkedPositions = edits.map [
			try {
				val textToReplace = document.get(offset, length)
				val indexOf = textToReplace.indexOf(originalName)
				if (indexOf !== -1) {
					val calculatedOffset = offset + indexOf
					return new LinkedPosition(document, calculatedOffset, originalName.length)
				}
			} catch (BadLocationException exc) {
				LOG.error('''Skipping invalid text edit «it»''', exc)
			}
			return null
		].filterNull
		progress.worked(10)
		val invocationOffset = xtextEditor.internalSourceViewer.selectedRange.x
		var i = 0
		for (position : sortPositions(linkedPositions, invocationOffset)) {
			try {
				position.sequenceNumber = i
				i++
				group.addPosition(position)
			} catch (BadLocationException e) {
				LOG.error(e.getMessage(), e)
				return null
			}
		}
		return group
	}

	protected def Iterable<LinkedPosition> sortPositions(Iterable<LinkedPosition> linkedPositions,
		int invocationOffset) {
		val comparator = new Comparator<LinkedPosition>() {
			override int compare(LinkedPosition left, LinkedPosition right) {
				rank(left) - rank(right)
			}

			def private int rank(LinkedPosition o1) {
				val relativeRank = o1.offset + o1.length - invocationOffset
				if (relativeRank < 0)
					return Integer.MAX_VALUE + relativeRank
				else
					return relativeRank
			}
		}
		return ImmutableSortedSet.copyOf(comparator, linkedPositions)
	}
}
