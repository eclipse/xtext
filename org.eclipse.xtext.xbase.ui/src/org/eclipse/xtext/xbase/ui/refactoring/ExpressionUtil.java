/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.refactoring;

import static com.google.common.collect.Lists.*;
import static java.util.Collections.*;
import static org.eclipse.xtext.xbase.XbasePackage.Literals.*;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ExpressionUtil {
	
	@Inject
	protected ILocationInFileProvider locationInFileProvider;

	/**
	 * @return the smallest single expression containing the selection.  
	 */
	public XExpression findSelectedExpression(XtextResource resource, ITextSelection selection) {
		IParseResult parseResult = resource.getParseResult();
		if (parseResult != null) {
			ICompositeNode rootNode = parseResult.getRootNode();
			INode node = NodeModelUtils.findLeafNodeAtOffset(rootNode, selection.getOffset());
			if (node == null) {
				return null;
			}
			if (isHidden(node)) {
				if (selection.getLength() > node.getLength()) {
					node = NodeModelUtils.findLeafNodeAtOffset(rootNode, node.getEndOffset());
				} else {
					node = NodeModelUtils.findLeafNodeAtOffset(rootNode, selection.getOffset() - 1);
				}
			} else if (node.getOffset() == selection.getOffset() && !isBeginOfExpression(node)) { 
				node = NodeModelUtils.findLeafNodeAtOffset(rootNode, selection.getOffset() - 1);
			}
			if(node != null) {
				EObject currentSemanticElement = NodeModelUtils.findActualSemanticObjectFor(node);
				while (!(contains(currentSemanticElement, node, selection) && currentSemanticElement instanceof XExpression)) {
					node = nextNodeForFindSelectedExpression(currentSemanticElement, node, selection);
					if(node == null)
						return null;
					currentSemanticElement = NodeModelUtils.findActualSemanticObjectFor(node);
				}
				return (XExpression) currentSemanticElement;
			}
		}
		return null;
	}

	protected INode nextNodeForFindSelectedExpression(EObject element, INode node, ITextSelection selection) {
		return node.getParent();
	}
	
	private boolean isHidden(INode node) {
		return node instanceof ILeafNode && ((ILeafNode)node).isHidden();
	}

	/**
	 * @return the list of sibling expressions (expressions in the same block expression) containing the selection.  
	 */
	public List<XExpression> findSelectedSiblingExpressions(XtextResource resource, ITextSelection selection) {
		ITextSelection trimmedSelection = trimSelection(resource, selection);
		XExpression selectedExpression = findSelectedExpression(resource, trimmedSelection);
		if(selectedExpression instanceof XBlockExpression) {
			List<XExpression> selectedExpressions = newArrayList();
			for(XExpression subExpression: ((XBlockExpression) selectedExpression).getExpressions()) {
				ITextRegion textRegion = getTextRegion(subExpression);
				if(intersects(textRegion, trimmedSelection)) {
					selectedExpressions.add(subExpression);
				}
			}
			return selectedExpressions; 
		} else if(selectedExpression == null)
			return emptyList();
		return singletonList(selectedExpression);
	}

	protected ITextSelection trimSelection(XtextResource resource, ITextSelection selection) {
		IParseResult parseResult = resource.getParseResult();
		if(parseResult != null) {
			String model = parseResult.getRootNode().getText();
			String selectedText = model.substring(selection.getOffset(), selection.getOffset() + selection.getLength());
			String trimmedSelection = selectedText.trim();
			return new TextSelection(selection.getOffset() + selectedText.indexOf(trimmedSelection), 
					trimmedSelection.length()); 
		}
		return null;
	}
	
	/**
	 * @return whether the given selection is zero length
	 */
	protected boolean isBeginOfExpression(INode node) {
		ITextRegion textRegion = node.getTextRegion();
		if (textRegion.getLength() == 0)
			return false;
		char firstChar = node.getText().charAt(0);
		return Character.isLetterOrDigit(firstChar)
				|| firstChar == '\''
				|| firstChar == '"'
				|| firstChar == '['
				|| firstChar == '('
				|| firstChar == '{'
				|| firstChar == '#'
				|| firstChar == '@'
				;
	}

	protected boolean contains(EObject element, INode node, ITextSelection selection) {
		if (element == null) {
			return false;
		}
		ITextRegion textRegion = getTotalTextRegion(element, node);
		return contains(textRegion, selection);
	}

	protected boolean contains(ITextRegion textRegion, ITextSelection selection) {
		return textRegion.getOffset() <= selection.getOffset()
				&& textRegion.getOffset() + textRegion.getLength() >= selection.getOffset() + selection.getLength();
	}

	protected boolean intersects(ITextRegion textRegion, ITextSelection trimmedSelection) {
		if (textRegion.getOffset() == trimmedSelection.getOffset() + trimmedSelection.getLength()) {
			return false;
		}
		if (textRegion.getOffset() + textRegion.getLength() == trimmedSelection.getOffset()) {
			return false;
		}
		return textRegion.getOffset() <= trimmedSelection.getOffset() + trimmedSelection.getLength()
				&& textRegion.getOffset() + textRegion.getLength() >= trimmedSelection.getOffset();
	}
	
	protected ITextRegion getTotalTextRegion(EObject element, INode node) {
		return node.getTotalTextRegion();
	}

	public ITextRegion getTextRegion(EObject element) {
		return locationInFileProvider.getFullTextRegion(element);
	}
	
	public XExpression findSuccessorExpressionForVariableDeclaration(EObject expression) {
		EObject eContainer = expression.eContainer();
		if (eContainer == null)
			return null;
		if (expression instanceof XExpression) {
			if (eContainer instanceof XBlockExpression)
				return (XExpression) expression;
			else if (isBlockInsertable(eContainer, expression))
				return (XExpression) expression;
		}
		return findSuccessorExpressionForVariableDeclaration(eContainer);
	}

	protected boolean isBlockInsertable(EObject eContainer, EObject expression) {
		EReference ref = expression.eContainmentFeature();
		return ref == XCLOSURE__EXPRESSION 
				|| ref == XIF_EXPRESSION__THEN 
				|| ref == XIF_EXPRESSION__ELSE
				|| ref == XCASE_PART__THEN
				|| ref == XSWITCH_EXPRESSION__DEFAULT
				|| ref == XFOR_LOOP_EXPRESSION__EACH_EXPRESSION
				|| ref == XABSTRACT_WHILE_EXPRESSION__BODY
				|| ref == XTRY_CATCH_FINALLY_EXPRESSION__EXPRESSION
				|| ref == XTRY_CATCH_FINALLY_EXPRESSION__FINALLY_EXPRESSION
				|| ref == XCATCH_CLAUSE__EXPRESSION;
	}
	
}
