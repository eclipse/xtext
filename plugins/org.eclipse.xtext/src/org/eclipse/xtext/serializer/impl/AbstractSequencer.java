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
import org.eclipse.xtext.serializer.IGrammarConstraintProvider.IConstraintElement;
import org.eclipse.xtext.serializer.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.ISemanticSequencer;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractSequencer implements ISemanticSequencer {

	protected boolean acceptSemantic(ISemanticSequenceAcceptor acceptor, AbstractElement ele, Object value) {
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
					acceptor.acceptAssignedCrossRefDatatype(rc, (EObject) value);
					return true;
				}
				if (rc.getRule() instanceof TerminalRule) {
					acceptor.acceptAssignedCrossRefTerminal(rc, (EObject) value);
					return true;
				}
				if (rc.getRule() instanceof EnumRule) {
					acceptor.acceptAssignedCrossRefEnum(rc, (EObject) value);
					return true;
				}
			} else if (ele instanceof Keyword) {
				acceptor.acceptAssignedCrossRefKeyword((Keyword) ele, (EObject) value);
				return true;
			}
		} else if ((ass = GrammarUtil.containingAssignment(ele)) != null) {
			if (ele instanceof RuleCall) {
				RuleCall rc = (RuleCall) ele;
				if (rc.getRule() instanceof ParserRule) {
					if (rc.getRule().getType().getClassifier() instanceof EClass)
						acceptor.acceptAssignedParserRuleCall(rc, (EObject) value);
					else
						acceptor.acceptAssignedDatatype(rc, value);
					return true;
				}
				if (rc.getRule() instanceof TerminalRule) {
					acceptor.acceptAssignedTerminal(rc, value);
					return true;
				}
				if (rc.getRule() instanceof EnumRule) {
					acceptor.acceptAssignedEnum(rc, value);
					return true;
				}
			} else if (ele instanceof Keyword) {
				if (GrammarUtil.isBooleanAssignment(ass))
					acceptor.acceptAssignedKeyword((Keyword) ele, true);
				else
					acceptor.acceptAssignedKeyword((Keyword) ele, (String) value);
				return true;
			}
		}
		return false;
	}

	protected boolean acceptSemantic(ISemanticSequenceAcceptor acceptor, IConstraintElement constraint, Object value) {
		switch (constraint.getType()) {
			case ASSIGNED_ACTION_CALL:
				acceptor.acceptAssignedAction(constraint.getAction(), (EObject) value);
				return true;
			case ASSIGNED_PARSER_RULE_CALL:
				acceptor.acceptAssignedParserRuleCall(constraint.getRuleCall(), (EObject) value);
				return true;
			case ASSIGNED_CROSSREF_DATATYPE_RULE_CALL:
				acceptor.acceptAssignedCrossRefDatatype(constraint.getRuleCall(), (EObject) value);
				return true;
			case ASSIGNED_CROSSREF_TERMINAL_RULE_CALL:
				acceptor.acceptAssignedCrossRefTerminal(constraint.getRuleCall(), (EObject) value);
				return true;
			case ASSIGNED_CROSSREF_KEYWORD:
				acceptor.acceptAssignedCrossRefKeyword(constraint.getKeyword(), (EObject) value);
				return true;
			case ASSIGNED_CROSSREF_ENUM_RULE_CALL:
				acceptor.acceptAssignedCrossRefEnum(constraint.getRuleCall(), (EObject) value);
				return true;
			case ASSIGNED_DATATYPE_RULE_CALL:
				acceptor.acceptAssignedDatatype(constraint.getRuleCall(), value);
				return true;
			case ASSIGNED_ENUM_RULE_CALL:
				acceptor.acceptAssignedEnum(constraint.getRuleCall(), value);
				return true;
			case ASSIGNED_TERMINAL_RULE_CALL:
				acceptor.acceptAssignedTerminal(constraint.getRuleCall(), value);
				return true;
			case ASSIGNED_KEYWORD:
				acceptor.acceptAssignedKeyword(constraint.getKeyword(), (String) value);
				return true;
			case ASSIGNED_BOOLEAN_KEYWORD:
				acceptor.acceptAssignedKeyword(constraint.getKeyword(), (Boolean) value);
				return true;
			case ALTERNATIVE:
			case GROUP:
			case UNASSIGNED_DATATYPE_RULE_CALL:
			case UNASSIGNED_TERMINAL_RULE_CALL:
				return false;
		}
		return false;
	}
}
