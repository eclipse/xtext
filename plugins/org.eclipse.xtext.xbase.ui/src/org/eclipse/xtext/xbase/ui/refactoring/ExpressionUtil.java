/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.refactoring;

import static org.eclipse.xtext.xbase.XbasePackage.Literals.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ExpressionUtil {

	public XExpression findSelectedExpression(XtextResource resource, ITextSelection selection) {
		IParseResult parseResult = resource.getParseResult();
		if (parseResult != null) {
			INode node = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), selection.getOffset());
			if (node != null &&
					(((ILeafNode) node).isHidden() || isBeginOfASymbol(node, selection))) {
				node = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(),
						selection.getOffset() - node.getLength());
			}
			while (node != null
					&& (!nodeContainsSelection(node, selection) || node.getSemanticElement() == null || !(node
							.getSemanticElement() instanceof XExpression)))
				node = node.getParent();
			if (node != null && node.getSemanticElement() != null)
				return (XExpression) node.getSemanticElement();
		}
		return null;
	}

	protected boolean isBeginOfASymbol(INode node, ITextSelection selection) {
		return node.getOffset() == selection.getOffset() 
				&& node.getLength() > 0 
				&& !Character.isLetterOrDigit(node.getText().charAt(0));
	}

	protected boolean nodeContainsSelection(INode node, ITextSelection selection) {
		return node.getOffset() <= selection.getOffset()
				&& node.getOffset() + node.getLength() >= selection.getOffset() + selection.getLength();
	}

	public Pair<XBlockExpression, XExpression> findInsertionPointForVariableDeclaration(EObject expression) {
		EObject eContainer = expression.eContainer();
		if (eContainer == null)
			return null;
		if (expression instanceof XExpression) {
			if (eContainer instanceof XBlockExpression)
				return Tuples.create((XBlockExpression) eContainer, (XExpression) expression);
			else if (isBlockInsertable(eContainer, expression))
				return Tuples.create(null, (XExpression) expression);
		}
		return findInsertionPointForVariableDeclaration(eContainer);
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
