/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.impl;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.ISemanticSequencer;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractNodeModelSequencer implements ISemanticSequencer {

	protected boolean acceptSemantic(ISemanticSequenceAcceptor acceptor, EObject semanticObject, AbstractElement ele,
			Object value, INode node) {
		Assignment ass = GrammarUtil.containingAssignment(ele);
		int index = -2;
		if (ass != null) {
			EStructuralFeature feat = semanticObject.eClass().getEStructuralFeature(ass.getFeature());
			if (feat != null) {
				if (feat.isMany())
					index = ((List<?>) semanticObject.eGet(feat)).indexOf(value);
				else
					index = -1;
			}
		}
		String token = node.getText().trim();
		if (ele instanceof Action) {
			if (((Action) ele).getFeature() != null) {
				acceptor.acceptAssignedAction(((Action) ele), (EObject) value, (ICompositeNode) node);
				return true;
			}
		} else if (GrammarUtil.containingCrossReference(ele) != null) {
			if (ele instanceof RuleCall) {
				RuleCall rc = (RuleCall) ele;
				if (rc.getRule() instanceof ParserRule) {
					acceptor.acceptAssignedCrossRefDatatype(rc, token, (EObject) value, index, (ICompositeNode) node);
					return true;
				}
				if (rc.getRule() instanceof TerminalRule) {
					acceptor.acceptAssignedCrossRefTerminal(rc, token, (EObject) value, index, (ILeafNode) node);
					return true;
				}
				if (rc.getRule() instanceof EnumRule) {
					acceptor.acceptAssignedCrossRefEnum(rc, token, (EObject) value, index, (ICompositeNode) node);
					return true;
				}
				//			} else if (ele instanceof Keyword) {
				//				acceptor.acceptAssignedCrossRefKeyword((Keyword) ele, token, (EObject) value, index,(ILeafNode) node);
				//				return true;
			}
		} else if (ass != null) {
			if (ele instanceof RuleCall) {
				RuleCall rc = (RuleCall) ele;
				if (rc.getRule() instanceof ParserRule) {
					if (rc.getRule().getType().getClassifier() instanceof EClass)
						acceptor.acceptAssignedParserRuleCall(rc, (EObject) value, (ICompositeNode) node);
					else
						acceptor.acceptAssignedDatatype(rc, token, value, index, (ICompositeNode) node);
					return true;
				}
				if (rc.getRule() instanceof TerminalRule) {
					acceptor.acceptAssignedTerminal(rc, token, value, index, (ILeafNode) node);
					return true;
				}
				if (rc.getRule() instanceof EnumRule) {
					acceptor.acceptAssignedEnum(rc, token, value, index, (ICompositeNode) node);
					return true;
				}
			} else if (ele instanceof Keyword) {
				if (GrammarUtil.isBooleanAssignment(ass))
					acceptor.acceptAssignedKeyword((Keyword) ele, token, true, index, (ILeafNode) node);
				else
					acceptor.acceptAssignedKeyword((Keyword) ele, token, (String) value, index, (ILeafNode) node);
				return true;
			}
		}
		return false;
	}

}
