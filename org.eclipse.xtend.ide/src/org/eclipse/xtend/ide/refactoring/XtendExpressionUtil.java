/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.refactoring;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.xtend.core.services.XtendGrammarAccess;
import org.eclipse.xtend.core.xtend.RichString;
import org.eclipse.xtend.core.xtend.RichStringLiteral;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.ui.refactoring.ExpressionUtil;

import com.google.inject.Inject;

/**
 * @author kosyakov - Initial contribution and API
 */
public class XtendExpressionUtil extends ExpressionUtil {
	
	@Inject
	private XtendGrammarAccess grammarAccess;
	
	@Override
	protected INode nextNodeForFindSelectedExpression(EObject element, INode node, ITextSelection selection) {
		if (element.eContainer() instanceof RichString && 
				node.getEndOffset() - selection.getOffset() > 0 && 
				!isRichTextEnd(element, node)) {
			ILeafNode nextNode = NodeModelUtils.findLeafNodeAtOffset(node.getRootNode(), node.getEndOffset());
			while(nextNode != null && nextNode.isHidden()) {
				INode nextSibling = nextNode.getNextSibling();
				if (nextSibling instanceof ILeafNode) {
					nextNode = (ILeafNode) nextSibling;
				} else {
					nextNode = null;
				}
			}
			if (isRichStringPart(nextNode)) {
				return nextNode;
			}	
		}
		return super.nextNodeForFindSelectedExpression(element, node, selection);
	}

	protected boolean isRichStringPart(ILeafNode nextNode) {
		if (nextNode == null) {
			return false;
		}
		if (grammarAccess.getRichStringForLoopAccess().getENDFORKeyword_9() == nextNode.getGrammarElement()) {
			return false;
		}
		if (grammarAccess.getRichStringIfAccess().getENDIFKeyword_6() == nextNode.getGrammarElement()) {
			return false;
		}
		return true;
	}

	protected boolean isRichTextEnd(EObject element, INode node) {
		if (!(element instanceof RichStringLiteral)) {
			return false;
		}
		for (ILeafNode leafNode : node.getLeafNodes()) {
			EObject grammarElement = leafNode.getGrammarElement();
			if (grammarElement instanceof RuleCall) {
				RuleCall ruleCall = (RuleCall) grammarElement;
				if (grammarAccess.getRICH_TEXT_ENDRule() == ruleCall.getRule()) {
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	protected ITextRegion getTotalTextRegion(EObject element, INode node) {
		if (element.eContainer() instanceof RichString) {
			return getRichStringPartTextRegion(element);
		}
		return super.getTotalTextRegion(element, node);
	}
	
	@Override
	public ITextRegion getTextRegion(EObject element) {
		if (element.eContainer() instanceof RichString) {
			return getRichStringPartTextRegion(element);
		}
		return super.getTextRegion(element);
	}

	protected ITextRegion getRichStringPartTextRegion(EObject element) {
		if (element instanceof RichStringLiteral) {
			return locationInFileProvider.getSignificantTextRegion(element);	
		}
		ICompositeNode elementNode = NodeModelUtils.getNode(element);
		ITextRegion totalTextRegion = elementNode.getTotalTextRegion();
		int offset = totalTextRegion.getOffset() - 1;
		int length = totalTextRegion.getLength() + 2;
		
		ILeafNode nextNode = NodeModelUtils.findLeafNodeAtOffset(elementNode.getRootNode(), elementNode.getEndOffset());
		while (nextNode != null && nextNode.isHidden()) {
			length += nextNode.getLength();
			INode nextSibling = nextNode.getNextSibling();
			if (nextSibling instanceof ILeafNode) {
				nextNode = (ILeafNode) nextSibling;
			} else {
				nextNode = null;
			}
		}
		
		return new TextRegion(offset, length);
	}

}
