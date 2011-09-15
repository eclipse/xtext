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
public class AstSelectionProvider implements ISelectionChangedListener {
	public final String SELECT_ENCLOSING = "org.eclipse.xtext.ui.editor.select.enclosing"; //$NON-NLS-1$
	public final String SELECT_NEXT = "org.eclipse.xtext.ui.editor.select.next"; //$NON-NLS-1$
	public final String SELECT_PREVIOUS = "org.eclipse.xtext.ui.editor.select.previous"; //$NON-NLS-1$
	public final String SELECT_LAST = "org.eclipse.xtext.ui.editor.select.last"; //$NON-NLS-1$
	@Inject
	private ILocationInFileProvider locationProvider;
	private Stack<ITextRegion> selectionHistory = new Stack<ITextRegion>();
	private ITextRegion lastSelection = ITextRegion.EMPTY_REGION;
	private XtextEditor xtextEditor;

	public ITextRegion selectLast(XtextResource resource, ITextRegion currentEditorSelection) {
		return lastSelection = selectionHistory.isEmpty() ? ITextRegion.EMPTY_REGION : selectionHistory.pop();
	}

	public ITextRegion selectEnclosing(XtextResource resource, ITextRegion currentEditorSelection) {
		ICompositeNode rootNode = resource.getParseResult().getRootNode();
		int offset = getSelectionOffset(rootNode, currentEditorSelection);
		INode node = findLeafNodeAtOffset(rootNode, offset);
		EObject eObject = findActualSemanticObjectFor(node);
		EObject enclosingObject = getEnclosingObject(eObject, currentEditorSelection);
		return lastSelection = calcEnclosingSelectionRegion(eObject, currentEditorSelection, enclosingObject);
	}

	public ITextRegion selectNext(XtextResource resource, ITextRegion currentEditorSelection) {
		ITextRegion result = ITextRegion.EMPTY_REGION;
		EObject eObjectAtOffset = getEObjectAtOffset(resource, currentEditorSelection);
		EObject eObjectAtEndOffset = getEObjectAtEndOffset(resource, currentEditorSelection);
		while (isEmptyOrNull(result)) {
			EObject nextObject = getNextObject(eObjectAtEndOffset, currentEditorSelection);
			if (nextObject != null) {
				result = calcNextSelectionRegion(eObjectAtOffset, eObjectAtEndOffset, currentEditorSelection,
						nextObject);
			} else if (eObjectAtEndOffset.eContainer() != null
					&& equalsEndOffset(eObjectAtEndOffset.eContainer(), currentEditorSelection)
					&& !lessThanOffset(eObjectAtEndOffset.eContainer(), currentEditorSelection)) {
				eObjectAtEndOffset = eObjectAtEndOffset.eContainer();
			} else {
				result = selectEnclosing(resource, currentEditorSelection);
			}
		}
		return lastSelection = result;
	}

	protected EObject getEObjectAtEndOffset(XtextResource resource, ITextRegion currentEditorSelection) {
		ICompositeNode rootNode = resource.getParseResult().getRootNode();
		int endOffset = getSelectionEndOffset(rootNode, currentEditorSelection);
		INode nodeAtEndOffset = findLeafNodeAtOffset(rootNode, endOffset);
		return findActualSemanticObjectFor(nodeAtEndOffset);
	}

	public ITextRegion selectPrevious(XtextResource resource, ITextRegion currentEditorSelection) {
		ITextRegion result = ITextRegion.EMPTY_REGION;
		EObject eObjectAtOffset = getEObjectAtOffset(resource, currentEditorSelection);
		EObject eObjectAtEndOffset = getEObjectAtEndOffset(resource, currentEditorSelection);
		while (isEmptyOrNull(result)) {
			EObject previousObject = getPreviousObject(eObjectAtOffset, currentEditorSelection);
			if (previousObject != null) {
				result = calcPreviousSelectionRegion(eObjectAtOffset, eObjectAtEndOffset, currentEditorSelection,
						previousObject);
			} else if (eObjectAtOffset.eContainer() != null
					&& equalsOffset(eObjectAtOffset.eContainer(), currentEditorSelection)) {
				eObjectAtOffset = eObjectAtOffset.eContainer();
			} else {
				result = selectEnclosing(resource, currentEditorSelection);
			}
		}
		return lastSelection = result;
	}

	protected EObject getEObjectAtOffset(XtextResource resource, ITextRegion currentEditorSelection) {
		ICompositeNode rootNode = resource.getParseResult().getRootNode();
		INode nodeAtOffset = findLeafNodeAtOffset(rootNode, currentEditorSelection.getOffset());
		return findActualSemanticObjectFor(nodeAtOffset);
	}

	public void initialize(XtextEditor xtextEditor) {
		this.xtextEditor = xtextEditor;
		this.xtextEditor.getSelectionProvider().addSelectionChangedListener(this);
		AstSelectionAction enclosingSelectionAction = new AstSelectionAction(
				AstSelectionMessages.AstSelectEnclosing_label, xtextEditor) {
			@Override
			protected ITextRegion internalSelect(XtextResource xtextResource, ITextRegion textRegion) {
				rememberSelection(textRegion);
				return selectEnclosing(xtextResource, textRegion);
			}
		};
		enclosingSelectionAction.setToolTipText(AstSelectionMessages.AstSelectEnclosing_tooltip);
		enclosingSelectionAction.setDescription(AstSelectionMessages.AstSelectEnclosing_description);
		setAction(xtextEditor, enclosingSelectionAction, SELECT_ENCLOSING);

		AstSelectionAction previousSelectionAction = new AstSelectionAction(
				AstSelectionMessages.AstSelectPrevious_label, xtextEditor) {
			@Override
			protected ITextRegion internalSelect(XtextResource xtextResource, ITextRegion textRegion) {
				rememberSelection(textRegion);
				return selectPrevious(xtextResource, textRegion);
			}
		};
		previousSelectionAction.setToolTipText(AstSelectionMessages.AstSelectPrevious_tooltip);
		previousSelectionAction.setDescription(AstSelectionMessages.AstSelectPrevious_description);
		setAction(xtextEditor, previousSelectionAction, SELECT_PREVIOUS);

		AstSelectionAction nextSelectionAction = new AstSelectionAction(AstSelectionMessages.AstSelectNext_label,
				xtextEditor) {
			@Override
			protected ITextRegion internalSelect(XtextResource xtextResource, ITextRegion textRegion) {
				rememberSelection(textRegion);
				return selectNext(xtextResource, textRegion);
			}
		};
		nextSelectionAction.setActionDefinitionId(SELECT_NEXT);
		nextSelectionAction.setToolTipText(AstSelectionMessages.AstSelectNext_tooltip);
		nextSelectionAction.setDescription(AstSelectionMessages.AstSelectNext_description);
		setAction(xtextEditor, nextSelectionAction, SELECT_NEXT);

		AstSelectionAction lastSelectionAction = new AstSelectionAction(AstSelectionMessages.AstSelectLast_label,
				xtextEditor) {
			@Override
			protected ITextRegion internalSelect(XtextResource xtextResource, ITextRegion textRegion) {
				return selectLast(xtextResource, textRegion);
			}
		};
		nextSelectionAction.setActionDefinitionId(SELECT_NEXT);
		nextSelectionAction.setToolTipText(AstSelectionMessages.AstSelectLast_tooltip);
		nextSelectionAction.setDescription(AstSelectionMessages.AstSelectLast_description);
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

	protected ITextRegion calcNextSelectionRegion(EObject eObjectOffset, EObject eObjectAtEndOffset,
			ITextRegion currentEditorSelection, EObject nextEObject) {
		ITextRegion textRegion = getTextRegion(eObjectOffset);
		if (currentEditorSelection.getLength() == 0) {
			return textRegion;
		}
		ITextRegion nextRegion = getTextRegion(nextEObject);
		int offset = textRegion.getOffset() < currentEditorSelection.getOffset() ? textRegion.getOffset()
				: currentEditorSelection.getOffset();
		return new TextRegion(offset, getEndOffset(nextRegion) - offset);
	}

	protected EObject getPreviousObject(EObject eObject, ITextRegion currentEditorSelection) {
		return EcoreUtil2.getPreviousSibling(eObject);
	}

	protected ITextRegion calcPreviousSelectionRegion(EObject eObjectAtOffset, EObject eObjectAtEndOffset,
			ITextRegion currentEditorSelection, EObject previousEObject) {
		ITextRegion textRegion = getTextRegion(eObjectAtEndOffset);
		if (currentEditorSelection.getLength() == 0) {
			return textRegion;
		}
		ITextRegion previousRegion = getTextRegion(previousEObject);
		int endOffset = getEndOffset(textRegion) > getEndOffset(currentEditorSelection) ? getEndOffset(textRegion)
				: getEndOffset(currentEditorSelection);
		return new TextRegion(previousRegion.getOffset(), endOffset - previousRegion.getOffset());
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
	 * @return true if eObjects first node <i>starts</i> at an offset less than that of the given region
	 */
	protected boolean lessThanOffset(EObject eObject, ITextRegion region) {
		return locationProvider.getFullTextRegion(eObject).getOffset() < region.getOffset();
	}

	/**
	 * @return true if eObjects first node <i>starts</i> at the same offset as the one from the given region
	 */
	protected boolean equalsOffset(EObject eObject, ITextRegion region) {
		return locationProvider.getFullTextRegion(eObject).getOffset() == region.getOffset();
	}

	/**
	 * @return true if eObjects last node <i>ends</i> at an offset less than that from the given region
	 */
	protected boolean lessThanEndOffset(EObject eObject, ITextRegion region) {
		return getEndOffset(locationProvider.getFullTextRegion(eObject)) < getEndOffset(region);
	}

	/**
	 * @return true if eObjects last node <i>ends</i> at the same endOffset as the from the given region
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
