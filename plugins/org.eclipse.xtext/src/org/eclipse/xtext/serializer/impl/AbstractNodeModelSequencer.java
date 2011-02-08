/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.xtext.serializer.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.ISemanticSequencer;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractNodeModelSequencer implements ISemanticSequencer {

	protected boolean acceptSemantic(ISemanticSequenceAcceptor acceptor, AbstractElement ele, Object value, INode node) {
		Assignment ass;
		if (ele instanceof Action) {
			if (((Action) ele).getFeature() != null) {
				acceptor.acceptAssignedAction(((Action) ele), (EObject) value);
				return true;
			}
		} else if (GrammarUtil.containingCrossReference(ele) != null) {
			if (ele instanceof RuleCall) {
				RuleCall rc = (RuleCall) ele;
				if (rc.getRule() instanceof ParserRule) {
					acceptor.acceptAssignedCrossRefDatatype(rc, (EObject) value, (ICompositeNode) node);
					return true;
				}
				if (rc.getRule() instanceof TerminalRule) {
					acceptor.acceptAssignedCrossRefTerminal(rc, (EObject) value, (ILeafNode) node);
					return true;
				}
				if (rc.getRule() instanceof EnumRule) {
					acceptor.acceptAssignedCrossRefEnum(rc, (EObject) value, (ICompositeNode) node);
					return true;
				}
			} else if (ele instanceof Keyword) {
				acceptor.acceptAssignedCrossRefKeyword((Keyword) ele, (EObject) value, (ILeafNode) node);
				return true;
			}
		} else if ((ass = GrammarUtil.containingAssignment(ele)) != null) {
			if (ele instanceof RuleCall) {
				RuleCall rc = (RuleCall) ele;
				if (rc.getRule() instanceof ParserRule) {
					if (rc.getRule().getType().getClassifier() instanceof EClass)
						acceptor.acceptAssignedParserRuleCall(rc, (EObject) value);
					else
						acceptor.acceptAssignedDatatype(rc, value, (ICompositeNode) node);
					return true;
				}
				if (rc.getRule() instanceof TerminalRule) {
					acceptor.acceptAssignedTerminal(rc, value, (ILeafNode) node);
					return true;
				}
				if (rc.getRule() instanceof EnumRule) {
					acceptor.acceptAssignedEnum(rc, value, (ICompositeNode) node);
					return true;
				}
			} else if (ele instanceof Keyword) {
				if (GrammarUtil.isBooleanAssignment(ass))
					acceptor.acceptAssignedKeyword((Keyword) ele, true, (ILeafNode) node);
				else
					acceptor.acceptAssignedKeyword((Keyword) ele, (String) value, (ILeafNode) node);
				return true;
			}
		}
		return false;
	}

}
