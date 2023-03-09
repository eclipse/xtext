/*******************************************************************************
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.selection;

import static java.util.Collections.*;
import static org.eclipse.xtext.nodemodel.util.NodeModelUtils.*;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.reconstr.ICommentAssociater;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.util.Tuples;

import com.google.inject.Inject;

/**
 * @author Michael Clay - Initial contribution and API
 * @author Sven Efftinge
 */
public class AstSelectionProvider {
	public static final String SELECT_ENCLOSING = "org.eclipse.xtext.ui.editor.select.enclosing"; //$NON-NLS-1$
	public static final String SELECT_NEXT = "org.eclipse.xtext.ui.editor.select.next"; //$NON-NLS-1$
	public static final String SELECT_PREVIOUS = "org.eclipse.xtext.ui.editor.select.previous"; //$NON-NLS-1$
	public static final String SELECT_LAST = "org.eclipse.xtext.ui.editor.select.last"; //$NON-NLS-1$
	
	@Inject
	private ILocationInFileProvider locationProvider;
	
	@Inject
	private ICommentAssociater commentAssociater;
	
	private Stack<ITextRegion> selectionHistory = new Stack<ITextRegion>();

	public ITextRegion selectLast(XtextResource resource, ITextRegion currentEditorSelection) {
		if (selectionHistory.isEmpty()) {
			return ITextRegion.EMPTY_REGION;
		}
		if (!currentEditorSelection.equals(selectionHistory.pop())) {
			selectionHistory.clear();
			return ITextRegion.EMPTY_REGION;
		}
		return selectionHistory.isEmpty() ? ITextRegion.EMPTY_REGION : selectionHistory.peek();
	}
	
	public ITextRegion selectEnclosing(XtextResource resource, ITextRegion currentEditorSelection) {
		Pair<EObject, EObject> currentlySelected = getSelectedAstElements(resource, currentEditorSelection);
		if (currentlySelected == null) {
			IParseResult parseResult = resource.getParseResult();
			if (parseResult != null) {
				ICompositeNode rootNode = parseResult.getRootNode();
				int offset = getSelectionOffset(rootNode, currentEditorSelection);
				INode node = findLeafNodeAtOffset(rootNode, offset);
				if (node != null) {
					ITextRegion fineGrainedRegion = computeInitialFineGrainedSelection(node, currentEditorSelection);
					if (fineGrainedRegion != null) {
						selectionHistory.clear();
						register(currentEditorSelection);
						return register(fineGrainedRegion);
					}
					EObject eObject = findSemanticObjectFor(node);
					return register(getTextRegion(eObject));
				}
			}
		} else {
			EObject first = currentlySelected.getFirst();
			if (first.eContainer() != null) {
				return register(getTextRegion(first.eContainer()));
			}
		}
		return ITextRegion.EMPTY_REGION;
	}
	
	public ITextRegion selectNext(XtextResource resource, ITextRegion currentEditorSelection) {
		Pair<EObject, EObject> currentlySelected = getSelectedAstElements(resource, currentEditorSelection);
		if (currentlySelected == null) {
			return selectEnclosing(resource, currentEditorSelection);
		}
		EObject second = currentlySelected.getSecond();
		EObject nextSibling = EcoreUtil2.getNextSibling(second);
		if (nextSibling != null) {
			return register(getRegion(Tuples.create(currentlySelected.getFirst(), nextSibling)));
		} else {
			if (second.eContainer() == null)
				return ITextRegion.EMPTY_REGION;
			return register(getRegion(Tuples.create(second.eContainer(), second.eContainer())));
		}
	}

	public ITextRegion selectPrevious(XtextResource resource, ITextRegion currentEditorSelection) {
		Pair<EObject, EObject> currentlySelected = getSelectedAstElements(resource, currentEditorSelection);
		if (currentlySelected == null) {
			return selectEnclosing(resource, currentEditorSelection);
		}
		EObject first = currentlySelected.getFirst();
		EObject previousSibling = EcoreUtil2.getPreviousSibling(first);
		if (previousSibling != null) {
			return register(getRegion(Tuples.create(previousSibling,currentlySelected.getSecond())));
		} else {
			if (first.eContainer() == null)
				return ITextRegion.EMPTY_REGION;
			return register(getRegion(Tuples.create(first.eContainer(), first.eContainer())));
		}
	}
	
	/**
	 * @return the starting EObject and the ending EObject of the current selection or null if the selection doesn't match the exact boundaries of two EObjects with the same container.
	 */
	protected Pair<EObject, EObject> getSelectedAstElements(XtextResource resource, ITextRegion currentSelection) {
		EObject eObject = getEObjectAtOffset(resource, currentSelection);
		while (eObject != null) {
			Pair<EObject, EObject> result = internalGetSelectedAstElements(eObject, currentSelection);
			if (result != null) 
				return result;
			eObject = eObject.eContainer();
		}
		return null;
	}

	protected Pair<EObject, EObject> internalGetSelectedAstElements(EObject eObject, ITextRegion currentSelection) {
		ITextRegion textRegion = getTextRegion(eObject);
		while (textRegion.getOffset() == currentSelection.getOffset()) {
			EObject container = eObject.eContainer();
			if (container != null) {
				for (EObject obj : container.eContents()) {
					ITextRegion region = getTextRegion(obj);
					if (getEndOffset(region) == getEndOffset(currentSelection)) {
						Pair<EObject, EObject> parentMatch = internalGetSelectedAstElements(eObject.eContainer(), currentSelection);
						if (parentMatch != null)
							return parentMatch;
						return Tuples.create(eObject, obj);
					}
				}
			} else {
				if (textRegion.equals(currentSelection))
					return Tuples.create(eObject, eObject);
				return null;
			}
			eObject = container;
			textRegion = getTextRegion(eObject);
		}
		return null;
	}
	
	protected ITextRegion getRegion(Pair<EObject, EObject> selection) {
		final ITextRegion firstRegion = getTextRegion(selection.getFirst());
		if (selection.getFirst() == selection.getSecond()) {
			return firstRegion;
		}
		ITextRegion secondRegion = getTextRegion(selection.getSecond());
		return new TextRegion(firstRegion.getOffset(), getEndOffset(secondRegion) - firstRegion.getOffset());
	}

	
	protected ITextRegion computeInitialFineGrainedSelection(INode node, ITextRegion currentEditorSelection) {
		if (node.getText().trim().length() > 0) {
			ITextRegion textRegion = node.getTextRegion();
			if (currentEditorSelection.getOffset() >= textRegion.getOffset()
				&& getEndOffset(currentEditorSelection) < textRegion.getOffset() + textRegion.getLength()) {
				//TODO enhance to just select a single word in a comment or string literal.
				return textRegion;
			}
		}
		return null;
	}
	
	protected EObject findSemanticObjectFor(INode node) {
		if (node instanceof ILeafNode && ((ILeafNode) node).isHidden()) {
			Map<ILeafNode, EObject> semanticEObjects = commentAssociater.associateCommentsWithSemanticEObjects(null, singleton(node.getRootNode()));
			if (semanticEObjects.containsKey(node))
				return semanticEObjects.get(node);
		} 
		return findActualSemanticObjectFor(node);
	}

	protected EObject getEObjectAtOffset(XtextResource resource, ITextRegion currentEditorSelection) {
		IParseResult parseResult = resource.getParseResult();
		if (parseResult != null) {
			ICompositeNode rootNode = parseResult.getRootNode();
			INode nodeAtOffset = findLeafNodeAtOffset(rootNode, currentEditorSelection.getOffset());
			return findSemanticObjectFor(nodeAtOffset);
		}
		return null;
	}

	public void initialize(XtextEditor xtextEditor) {
		AstSelectionAction enclosingSelectionAction = new AstSelectionAction(
				AstSelectionMessages.AstSelectEnclosing_label, xtextEditor) {
			@Override
			protected ITextRegion internalSelect(XtextResource xtextResource, ITextRegion textRegion) {
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

	protected ITextRegion register(ITextRegion textRegion) {
		if (textRegion == null) {
			return ITextRegion.EMPTY_REGION;
		}
		if (selectionHistory.isEmpty() || !selectionHistory.peek().equals(textRegion)) {
			selectionHistory.push(textRegion);
		}
		return textRegion;
	}

	protected ITextRegion getTextRegion(EObject eObject) {
		if (eObject == null)
			return null;
		IParseResult parseResult = ((XtextResource)eObject.eResource()).getParseResult();
		if (parseResult == null)
			return null;
		ICompositeNode rootNode = parseResult.getRootNode();
		Map<ILeafNode, EObject> comments = commentAssociater.associateCommentsWithSemanticEObjects(eObject, singleton(rootNode));
		final ITextRegion result = locationProvider.getFullTextRegion(eObject);
		int start = result.getOffset();
		int end = result.getOffset() + result.getLength();
		for (Entry<ILeafNode, EObject> entry : comments.entrySet()) {
			if (entry.getValue() == eObject) {
				ILeafNode node = entry.getKey();
				if (node.getTotalOffset() < start) {
					start = node.getTotalOffset();
				}
				if (node.getTotalEndOffset() > end) {
					end = node.getTotalEndOffset();
				}
			}
		}
		return new TextRegion(start, end-start);
	}

	protected int getEndOffset(ITextRegion region) {
		return region.getOffset() + region.getLength();
	}

	protected int getSelectionOffset(ICompositeNode rootNode, ITextRegion region) {
		boolean selectionAtEndOfText = rootNode.getTotalEndOffset() == getEndOffset(region);
		return selectionAtEndOfText && region.getOffset() > 0 ? region.getOffset() - 1 : region.getOffset();
	}

}
