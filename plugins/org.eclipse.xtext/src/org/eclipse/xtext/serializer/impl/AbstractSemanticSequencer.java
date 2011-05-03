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
import org.eclipse.xtext.serializer.IGrammarConstraintProvider.IConstraintElement;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.tokens.ICrossReferenceSerializer;
import org.eclipse.xtext.serializer.tokens.IEnumLiteralSerializer;
import org.eclipse.xtext.serializer.tokens.IKeywordSerializer;
import org.eclipse.xtext.serializer.tokens.IValueSerializer;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractSemanticSequencer implements ISemanticSequencer {

	@Inject
	protected ICrossReferenceSerializer crossRefSerializer;

	@Inject
	protected IEnumLiteralSerializer enumLiteralSerializer;

	protected ISerializationDiagnostic.Acceptor errorAcceptor;

	@Inject
	protected IKeywordSerializer keywordSerializer;

	protected ISemanticSequenceAcceptor sequenceAcceptor;

	@Inject
	protected IValueSerializer valueSerializer;

	protected void acceptAssignedAction(EObject semanticObj, Action action, EObject semanticChild, int index,
			ICompositeNode node) {
		sequenceAcceptor.acceptAssignedAction(action, semanticChild, node);
	}

	protected void acceptAssignedCrossRefDatatype(EObject semanticObj, RuleCall datatypeRC, EObject value, int index,
			ICompositeNode node) {
		String token1 = crossRefSerializer.serializeCrossRef(semanticObj,
				GrammarUtil.containingCrossReference(datatypeRC), value, node, errorAcceptor);
		sequenceAcceptor.acceptAssignedCrossRefDatatype(datatypeRC, token1, value, index, node);
	}

	protected void acceptAssignedCrossRefEnum(EObject semanticObj, RuleCall enumRC, EObject value, int index,
			ICompositeNode node) {
		EObject target3 = value;
		String token3 = crossRefSerializer.serializeCrossRef(semanticObj, GrammarUtil.containingCrossReference(enumRC),
				target3, node, errorAcceptor);
		sequenceAcceptor.acceptAssignedCrossRefEnum(enumRC, token3, target3, index, node);
	}

	protected void acceptAssignedCrossRefTerminal(EObject semanticObj, RuleCall terminalRC, EObject value, int index,
			ILeafNode node) {
		String token2 = crossRefSerializer.serializeCrossRef(semanticObj,
				GrammarUtil.containingCrossReference(terminalRC), value, node, errorAcceptor);
		sequenceAcceptor.acceptAssignedCrossRefTerminal(terminalRC, token2, value, index, node);
	}

	protected void acceptAssignedDatatype(EObject semanticObj, RuleCall datatypeRC, Object value, int index,
			ICompositeNode node) {
		String token4 = valueSerializer.serializeAssignedValue(semanticObj, datatypeRC, value, node, errorAcceptor);
		sequenceAcceptor.acceptAssignedDatatype(datatypeRC, token4, value, index, node);
	}

	protected void acceptAssignedEnum(EObject semanticObj, RuleCall enumRC, Object value, int index, ICompositeNode node) {
		String token5 = enumLiteralSerializer.serializeAssignedEnumLiteral(semanticObj, enumRC, value, node,
				errorAcceptor);
		sequenceAcceptor.acceptAssignedEnum(enumRC, token5, value, index, node);
	}

	protected void acceptAssignedKeyword(EObject semanticObj, Keyword keyword, Boolean value, int index, ILeafNode node) {
		String token7 = keywordSerializer.serializeAssignedKeyword(semanticObj, keyword, value, node, errorAcceptor);
		sequenceAcceptor.acceptAssignedKeyword(keyword, token7, value == null ? false : value, index, node);
	}

	protected void acceptAssignedKeyword(EObject semanticObj, Keyword keyword, String value, int index, ILeafNode node) {
		String token7 = keywordSerializer.serializeAssignedKeyword(semanticObj, keyword, value, node, errorAcceptor);
		sequenceAcceptor.acceptAssignedKeyword(keyword, token7, value, index, node);
	}

	protected void acceptAssignedParserRuleCall(EObject semanticObj, RuleCall ruleCall, EObject semanticChild,
			int index, ICompositeNode node) {
		sequenceAcceptor.acceptAssignedParserRuleCall(ruleCall, semanticChild, node);
	}

	protected void acceptAssignedTerminal(EObject semanticObj, RuleCall terminalRC, Object value, int index,
			ILeafNode node) {
		String token6 = valueSerializer.serializeAssignedValue(semanticObj, terminalRC, value, node, errorAcceptor);
		sequenceAcceptor.acceptAssignedTerminal(terminalRC, token6, value, index, node);
	}

	protected void acceptFinish() {
		sequenceAcceptor.finish();
	}

	protected boolean acceptSemantic(EObject semanticObject, AbstractElement ele, Object value, INode node) {
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
				sequenceAcceptor.acceptAssignedAction(((Action) ele), (EObject) value, (ICompositeNode) node);
				return true;
			}
		} else if (GrammarUtil.containingCrossReference(ele) != null) {
			if (ele instanceof RuleCall) {
				RuleCall rc = (RuleCall) ele;
				if (rc.getRule() instanceof ParserRule) {
					sequenceAcceptor.acceptAssignedCrossRefDatatype(rc, token, (EObject) value, index,
							(ICompositeNode) node);
					return true;
				}
				if (rc.getRule() instanceof TerminalRule) {
					sequenceAcceptor
							.acceptAssignedCrossRefTerminal(rc, token, (EObject) value, index, (ILeafNode) node);
					return true;
				}
				if (rc.getRule() instanceof EnumRule) {
					sequenceAcceptor.acceptAssignedCrossRefEnum(rc, token, (EObject) value, index,
							(ICompositeNode) node);
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
						sequenceAcceptor.acceptAssignedParserRuleCall(rc, (EObject) value, (ICompositeNode) node);
					else
						sequenceAcceptor.acceptAssignedDatatype(rc, token, value, index, (ICompositeNode) node);
					return true;
				}
				if (rc.getRule() instanceof TerminalRule) {
					sequenceAcceptor.acceptAssignedTerminal(rc, token, value, index, (ILeafNode) node);
					return true;
				}
				if (rc.getRule() instanceof EnumRule) {
					sequenceAcceptor.acceptAssignedEnum(rc, token, value, index, (ICompositeNode) node);
					return true;
				}
			} else if (ele instanceof Keyword) {
				if (GrammarUtil.isBooleanAssignment(ass))
					sequenceAcceptor.acceptAssignedKeyword((Keyword) ele, token, true, index, (ILeafNode) node);
				else
					sequenceAcceptor.acceptAssignedKeyword((Keyword) ele, token, (String) value, index,
							(ILeafNode) node);
				return true;
			}
		}
		return false;
	}

	protected boolean acceptSemantic(EObject semanticObj, IConstraintElement constr, Object value, int index, INode node) {
		switch (constr.getType()) {
			case ASSIGNED_ACTION_CALL:
				acceptAssignedAction(semanticObj, constr.getAction(), (EObject) value, -1, (ICompositeNode) node);
				return true;
			case ASSIGNED_PARSER_RULE_CALL:
				acceptAssignedParserRuleCall(semanticObj, constr.getRuleCall(), (EObject) value, index,
						(ICompositeNode) node);
				return true;
			case ASSIGNED_CROSSREF_DATATYPE_RULE_CALL:
				acceptAssignedCrossRefDatatype(semanticObj, constr.getRuleCall(), (EObject) value, index,
						(ICompositeNode) node);
				return true;
			case ASSIGNED_CROSSREF_TERMINAL_RULE_CALL:
				acceptAssignedCrossRefTerminal(semanticObj, constr.getRuleCall(), (EObject) value, index,
						(ILeafNode) node);
				return true;
			case ASSIGNED_CROSSREF_ENUM_RULE_CALL:
				acceptAssignedCrossRefEnum(semanticObj, constr.getRuleCall(), (EObject) value, index,
						(ICompositeNode) node);
				return true;
			case ASSIGNED_DATATYPE_RULE_CALL:
				acceptAssignedDatatype(semanticObj, constr.getRuleCall(), value, index, (ICompositeNode) node);
				return true;
			case ASSIGNED_ENUM_RULE_CALL:
				acceptAssignedEnum(semanticObj, constr.getRuleCall(), value, index, (ICompositeNode) node);
				return true;
			case ASSIGNED_TERMINAL_RULE_CALL:
				acceptAssignedTerminal(semanticObj, constr.getRuleCall(), value, index, (ILeafNode) node);
				return true;
			case ASSIGNED_KEYWORD:
				acceptAssignedKeyword(semanticObj, constr.getKeyword(), (String) value, index, (ILeafNode) node);
				return true;
			case ASSIGNED_BOOLEAN_KEYWORD:
				acceptAssignedKeyword(semanticObj, constr.getKeyword(), (Boolean) value, index, (ILeafNode) node);
				return true;
			case ALTERNATIVE:
			case GROUP:
				return false;
		}
		return false;
	}

	public void init(ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		this.sequenceAcceptor = sequenceAcceptor;
		this.errorAcceptor = errorAcceptor;
	}

}
