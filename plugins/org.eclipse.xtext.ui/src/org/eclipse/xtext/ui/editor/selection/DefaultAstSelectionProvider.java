/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.selection;

import static org.eclipse.xtext.nodemodel.util.NodeModelUtils.*;

import java.util.Stack;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;

import com.google.inject.Inject;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class DefaultAstSelectionProvider implements INodeSelectionProvider, ISelectionChangedListener {
	@Inject
	private ILocationInFileProvider locationProvider;
	private Stack<ITextRegion> selectionHistory = new Stack<ITextRegion>();
	private ITextRegion lastSelection = ITextRegion.EMPTY_REGION;
	private XtextEditor xtextEditor;

	public ITextRegion select(String selectionType, XtextResource resource, ITextRegion currentEditorSelection) {
		ICompositeNode rootNode = resource.getParseResult().getRootNode();
		lastSelection = currentEditorSelection;
		if (SELECT_LAST.equalsIgnoreCase(selectionType)) {
			lastSelection = selectionHistory.isEmpty() ? ITextRegion.EMPTY_REGION : selectionHistory.pop();
		} else if (currentEditorSelection.getLength() == 0 || SELECT_ENCLOSING.equalsIgnoreCase(selectionType)) {
			lastSelection = selectEnclosing(rootNode, currentEditorSelection);
			rememberSelection(currentEditorSelection);
		} else if (SELECT_PREVIOUS.equalsIgnoreCase(selectionType)) {
			lastSelection = selectPrevious(rootNode, currentEditorSelection);
			rememberSelection(currentEditorSelection);
		} else if (SELECT_NEXT.equalsIgnoreCase(selectionType)) {
			lastSelection = selectNext(rootNode, currentEditorSelection);
			rememberSelection(currentEditorSelection);
		}
		return lastSelection;
	}

	public ITextRegion selectEnclosing(ICompositeNode rootNode, ITextRegion currentEditorSelection) {
		int offset = getSelectionOffset(rootNode, currentEditorSelection);
		INode node = findLeafNodeAtOffset(rootNode, offset);
		EObject eObject = findActualSemanticObjectFor(node);
		EObject enclosingObject = getEnclosingObject(eObject, currentEditorSelection);
		return calcEnclosingSelectionRegion(eObject, currentEditorSelection, enclosingObject);
	}

	public ITextRegion selectNext(ICompositeNode root, ITextRegion currentEditorSelection) {
		ITextRegion result = ITextRegion.EMPTY_REGION;
		int endOffset = getSelectionEndOffset(root, currentEditorSelection);
		INode node = findLeafNodeAtOffset(root, endOffset);
		EObject eObject = findActualSemanticObjectFor(node);
		while (isEmptyOrNull(result)) {
			EObject nextObject = getNextObject(eObject, currentEditorSelection);
			if (nextObject != null) {
				result = calcNextSelectionRegion(eObject, currentEditorSelection, nextObject);
			} else if (eObject.eContainer() != null && equalsEndOffset(eObject.eContainer(), currentEditorSelection)
					&& !lessThanOffset(eObject.eContainer(), currentEditorSelection)) {
				eObject = eObject.eContainer();
			} else {
				result = selectEnclosing(root, currentEditorSelection);
			}
		}
		return result;
	}

	public ITextRegion selectPrevious(ICompositeNode root, ITextRegion currentEditorSelection) {
		ITextRegion result = ITextRegion.EMPTY_REGION;
		INode node = findLeafNodeAtOffset(root, currentEditorSelection.getOffset());
		EObject eObject = findActualSemanticObjectFor(node);
		while (isEmptyOrNull(result)) {
			EObject previousObject = getPreviousObject(eObject, currentEditorSelection);
			if (previousObject != null) {
				result = calcPreviousSelectionRegion(eObject, currentEditorSelection, previousObject);
			} else if (eObject.eContainer() != null && equalsOffset(eObject.eContainer(), currentEditorSelection)) {
				eObject = eObject.eContainer();
			} else {
				result = selectEnclosing(root, currentEditorSelection);
			}
		}
		return result;
	}

	public void initialize(XtextEditor xtextEditor) {
		this.xtextEditor = xtextEditor;
		this.xtextEditor.getSelectionProvider().addSelectionChangedListener(this);
		NodeSelectionAction enclosingSelectionAction = new NodeSelectionAction(
				NodeSelectionMessages.NodeSelectEnclosing_label, xtextEditor, this);
		enclosingSelectionAction.setToolTipText(NodeSelectionMessages.NodeSelectEnclosing_tooltip);
		enclosingSelectionAction.setDescription(NodeSelectionMessages.NodeSelectEnclosing_description);
		setAction(xtextEditor, enclosingSelectionAction, SELECT_ENCLOSING);

		NodeSelectionAction previousSelectionAction = new NodeSelectionAction(
				NodeSelectionMessages.NodeSelectEnclosing_label, xtextEditor, this);
		previousSelectionAction.setToolTipText(NodeSelectionMessages.NodeSelectPrevious_tooltip);
		previousSelectionAction.setDescription(NodeSelectionMessages.NodeSelectPrevious_description);
		setAction(xtextEditor, previousSelectionAction, SELECT_PREVIOUS);

		NodeSelectionAction nextSelectionAction = new NodeSelectionAction(
				NodeSelectionMessages.NodeSelectEnclosing_label, xtextEditor, this);
		nextSelectionAction.setActionDefinitionId(SELECT_NEXT);
		nextSelectionAction.setToolTipText(NodeSelectionMessages.NodeSelectNext_tooltip);
		nextSelectionAction.setDescription(NodeSelectionMessages.NodeSelectNext_description);
		setAction(xtextEditor, nextSelectionAction, SELECT_NEXT);

		NodeSelectionAction lastSelectionAction = new NodeSelectionAction(NodeSelectionMessages.NodeSelectLast_label,
				xtextEditor, this);
		nextSelectionAction.setActionDefinitionId(SELECT_NEXT);
		nextSelectionAction.setToolTipText(NodeSelectionMessages.NodeSelectLast_tooltip);
		nextSelectionAction.setDescription(NodeSelectionMessages.NodeSelectLast_description);
		setAction(xtextEditor, lastSelectionAction, SELECT_LAST);
	}

	protected void setAction(XtextEditor xtextEditor, IAction action, String actionDefinitionId) {
		action.setActionDefinitionId(actionDefinitionId);
		xtextEditor.setAction(actionDefinitionId, action);
	}

	public void selectionChanged(SelectionChangedEvent event) {
		if (selectionHistory.isEmpty()) {
			return;
		}
		ISelection selection = event.getSelection();
		ITextRegion textRegion = ITextRegion.EMPTY_REGION;
		if (selection instanceof TextSelection) {
			TextSelection textSelection = (TextSelection) selection;
			textRegion = new TextRegion(textSelection.getOffset(), textSelection.getLength());
		}
		if (!lastSelection.equals(textRegion)) {
			lastSelection = ITextRegion.EMPTY_REGION;
			selectionHistory.clear();
		}
	}

	public void dispose() {
		if (xtextEditor != null) {
			xtextEditor.getSelectionProvider().removeSelectionChangedListener(this);
		}
		xtextEditor = null;
	}

	protected ITextRegion rememberSelection(ITextRegion textRegion) {
		if (selectionHistory.isEmpty() || !selectionHistory.peek().equals(textRegion)) {
			selectionHistory.push(textRegion);
		}
		return textRegion;
	}

	protected EObject getEnclosingObject(EObject eObject, ITextRegion currentEditorSelection) {
		while (eObject.eContainer() != null && getTextRegion(eObject).getOffset() == currentEditorSelection.getOffset()) {
			eObject = eObject.eContainer();
		}
		return eObject;
	}

	protected ITextRegion calcEnclosingSelectionRegion(EObject eObject, ITextRegion currentEditorSelection,
			EObject enclosingEObject) {
		return getTextRegion(enclosingEObject);
	}

	protected EObject getNextObject(EObject eObject, ITextRegion currentEditorSelection) {
		return EcoreUtil2.getNextSibling(eObject);
	}

	protected ITextRegion calcNextSelectionRegion(EObject eObject, ITextRegion currentEditorSelection,
			EObject nextEObject) {
		ITextRegion nextRegion = getTextRegion(nextEObject);
		return new TextRegion(currentEditorSelection.getOffset(), getEndOffset(nextRegion)
				- currentEditorSelection.getOffset());
	}

	protected EObject getPreviousObject(EObject eObject, ITextRegion currentEditorSelection) {
		return EcoreUtil2.getPreviousSibling(eObject);
	}

	protected ITextRegion calcPreviousSelectionRegion(EObject eObject, ITextRegion currentEditorSelection,
			EObject previousEObject) {
		ITextRegion previousRegion = getTextRegion(previousEObject);
		return new TextRegion(previousRegion.getOffset(), getEndOffset(currentEditorSelection)
				- previousRegion.getOffset());
	}

	public ILocationInFileProvider getLocationProvider() {
		return locationProvider;
	}

	protected ITextRegion getTextRegion(EObject eObject) {
		return locationProvider.getFullTextRegion(eObject);
	}

	protected ITextRegion getTextRegion(INode node) {
		return new TextRegion(node.getOffset(), node.getLength());
	}

	/**
	 * @return true if eObject <i>starts</i> at an offset less than that of the given region
	 */
	protected boolean lessThanOffset(EObject eObject, ITextRegion region) {
		return locationProvider.getFullTextRegion(eObject).getOffset() < region.getOffset();
	}

	/**
	 * @return true if eObject <i>starts</i> at the same offset as the one from the given region
	 */
	protected boolean equalsOffset(EObject eObject, ITextRegion region) {
		return locationProvider.getFullTextRegion(eObject).getOffset() == region.getOffset();
	}

	/**
	 * @return true if eObject <i>ends</i> at an offset less than that from the given region
	 */
	protected boolean lessThanEndOffset(EObject eObject, ITextRegion region) {
		return getEndOffset(locationProvider.getFullTextRegion(eObject)) < getEndOffset(region);
	}

	/**
	 * @return true if eObject <i>end</i> at the same endOffset as the from the given region
	 */
	protected boolean equalsEndOffset(EObject eObject, ITextRegion region) {
		return getEndOffset(locationProvider.getFullTextRegion(eObject)) == getEndOffset(region);
	}

	protected boolean isEmptyOrNull(ITextRegion textRegion) {
		return textRegion == null || ITextRegion.EMPTY_REGION == textRegion;
	}

	protected int getEndOffset(ITextRegion region) {
		return region.getOffset() + region.getLength();
	}

	protected int getSelectionOffset(ICompositeNode rootNode, ITextRegion region) {
		boolean selectionAtEndOfText = rootNode.getTotalEndOffset() == getEndOffset(region);
		return selectionAtEndOfText && region.getOffset() > 0 ? region.getOffset() - 1 : region.getOffset();
	}

	protected int getSelectionEndOffset(ICompositeNode rootNode, ITextRegion region) {
		boolean selectionAtEndOfText = rootNode.getTotalEndOffset() == getEndOffset(region);
		return selectionAtEndOfText || region.getLength() > 0 ? getEndOffset(region) - 1 : getEndOffset(region);
	}

}
