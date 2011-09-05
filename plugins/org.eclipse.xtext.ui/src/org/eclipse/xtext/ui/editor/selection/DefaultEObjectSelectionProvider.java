/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.selection;

import static org.eclipse.xtext.nodemodel.util.NodeModelUtils.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class DefaultEObjectSelectionProvider extends AbstractNodeSelectionProvider {

	@Override
	public ITextRegion select(String selectionType, ICompositeNode rootNode, ITextRegion currentTextRegion) {
		ITextRegion result = currentTextRegion;
		if (currentTextRegion.getLength() == 0) {
			result = selectEnclosing(rootNode, currentTextRegion);
		} else if (SELECT_ENCLOSING.equalsIgnoreCase(selectionType)) {
			result = selectEnclosing(rootNode, currentTextRegion);
		} else if (SELECT_PREVIOUS.equalsIgnoreCase(selectionType)) {
			result = selectPrevious(rootNode, currentTextRegion);
		} else if (SELECT_NEXT.equalsIgnoreCase(selectionType)) {
			result = selectNext(rootNode, currentTextRegion);
		}
		return result;
	}

	public ITextRegion selectEnclosing(ICompositeNode rootNode, ITextRegion currentTextRegion) {
		int offset = getSelectionOffset(rootNode, currentTextRegion);
		INode node = findLeafNodeAtOffset(rootNode, offset);
		EObject eObject = findActualSemanticObjectFor(node);
		EObject enclosingObject = getEnclosingObject(eObject, currentTextRegion);
		return calcEnclosingSelectionRegion(eObject, currentTextRegion, enclosingObject);
	}

	public ITextRegion selectNext(ICompositeNode root, ITextRegion currentTextRegion) {
		ITextRegion result = ITextRegion.EMPTY_REGION;
		int endOffset = getSelectionEndOffset(root, currentTextRegion);
		INode node = findLeafNodeAtOffset(root, endOffset);
		EObject eObject = findActualSemanticObjectFor(node);
		while (isEmptyOrNull(result)) {
			EObject nextObject = getNextObject(eObject, currentTextRegion);
			if (nextObject != null) {
				result = calcNextSelectionRegion(eObject, currentTextRegion, nextObject);
			} else if (eObject.eContainer() != null && equalsEndOffset(eObject.eContainer(), currentTextRegion)
					&& !lessThanOffset(eObject.eContainer(), currentTextRegion)) {
				eObject = eObject.eContainer();
			} else {
				result = selectEnclosing(root, currentTextRegion);
			}
		}
		return result;
	}

	public ITextRegion selectPrevious(ICompositeNode root, ITextRegion currentTextRegion) {
		ITextRegion result = ITextRegion.EMPTY_REGION;
		INode node = findLeafNodeAtOffset(root, currentTextRegion.getOffset());
		EObject eObject = findActualSemanticObjectFor(node);
		while (isEmptyOrNull(result)) {
			EObject previousObject = getPreviousObject(eObject, currentTextRegion);
			if (previousObject != null) {
				result = calcPreviousSelectionRegion(eObject, currentTextRegion, previousObject);
			} else if (eObject.eContainer() != null && equalsOffset(eObject.eContainer(), currentTextRegion)
					&& !lessThanEndOffset(eObject.eContainer(), currentTextRegion)) {
				eObject = eObject.eContainer();
			} else {
				result = selectEnclosing(root, currentTextRegion);
			}
		}
		return result;
	}

	@Override
	protected void initialize(XtextEditor xtextEditor, SelectionHistory selectionHistory) {
		NodeSelectionAction enclosingSelectionAction = new NodeSelectionAction(
				NodeSelectionMessages.NodeSelectEnclosing_label, xtextEditor, selectionHistory, this);
		enclosingSelectionAction.setToolTipText(NodeSelectionMessages.NodeSelectEnclosing_tooltip);
		enclosingSelectionAction.setDescription(NodeSelectionMessages.NodeSelectEnclosing_description);
		setAction(xtextEditor, enclosingSelectionAction, SELECT_ENCLOSING);

		NodeSelectionAction previousSelectionAction = new NodeSelectionAction(
				NodeSelectionMessages.NodeSelectEnclosing_label, xtextEditor, selectionHistory, this);
		previousSelectionAction.setToolTipText(NodeSelectionMessages.NodeSelectPrevious_tooltip);
		previousSelectionAction.setDescription(NodeSelectionMessages.NodeSelectPrevious_description);
		setAction(xtextEditor, previousSelectionAction, SELECT_PREVIOUS);

		NodeSelectionAction nextSelectionAction = new NodeSelectionAction(
				NodeSelectionMessages.NodeSelectEnclosing_label, xtextEditor, selectionHistory, this);
		nextSelectionAction.setActionDefinitionId(SELECT_NEXT);
		nextSelectionAction.setToolTipText(NodeSelectionMessages.NodeSelectNext_tooltip);
		nextSelectionAction.setDescription(NodeSelectionMessages.NodeSelectNext_description);
		setAction(xtextEditor, nextSelectionAction, SELECT_NEXT);
	}

	protected EObject getEnclosingObject(EObject eObject, ITextRegion currentTextRegion) {
		while (eObject.eContainer() != null && getTextRegion(eObject).getOffset() == currentTextRegion.getOffset()) {
			eObject = eObject.eContainer();
		}
		return eObject;
	}

	protected ITextRegion calcEnclosingSelectionRegion(EObject eObject, ITextRegion currentTextRegion,
			EObject enclosingEObject) {
		return getTextRegion(enclosingEObject);
	}

	protected EObject getNextObject(EObject eObject, ITextRegion currentTextRegion) {
		return EcoreUtil2.getNextSibling(eObject);
	}

	protected ITextRegion calcNextSelectionRegion(EObject eObject, ITextRegion currentTextRegion, EObject nextEObject) {
		ITextRegion nextRegion = getTextRegion(nextEObject);
		return new TextRegion(currentTextRegion.getOffset(), getEndOffset(nextRegion) - currentTextRegion.getOffset());
	}

	protected EObject getPreviousObject(EObject eObject, ITextRegion currentTextRegion) {
		return EcoreUtil2.getPreviousSibling(eObject);
	}

	protected ITextRegion calcPreviousSelectionRegion(EObject eObject, ITextRegion currentTextRegion,
			EObject previousEObject) {
		ITextRegion previousRegion = getTextRegion(previousEObject);
		return new TextRegion(previousRegion.getOffset(), getEndOffset(currentTextRegion) - previousRegion.getOffset());
	}

	protected int getSelectionOffset(ICompositeNode rootNode, ITextRegion currentTextRegion) {
		boolean selectionAtEndOfText = rootNode.getTotalEndOffset() == getEndOffset(currentTextRegion);
		return selectionAtEndOfText && currentTextRegion.getOffset() > 0 ? currentTextRegion.getOffset() - 1
				: currentTextRegion.getOffset();
	}

	protected int getSelectionEndOffset(ICompositeNode rootNode, ITextRegion currentTextRegion) {
		boolean selectionAtEndOfText = rootNode.getTotalEndOffset() == getEndOffset(currentTextRegion);
		return selectionAtEndOfText || currentTextRegion.getLength() > 0 ? getEndOffset(currentTextRegion) - 1
				: getEndOffset(currentTextRegion);
	}

}
