/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.ISemanticSequencer;
import org.eclipse.xtext.serializer.IGrammarConstraintProvider.IConstraintElement;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic;
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

	@Inject
	protected IKeywordSerializer keywordSerializer;

	@Inject
	protected IValueSerializer valueSerializer;

	protected void acceptAssignedAction(ISemanticSequenceAcceptor out, ISerializationDiagnostic.Acceptor errors,
			EObject semanticObj, Action action, EObject semanticChild, int index, ICompositeNode node) {
		out.acceptAssignedAction(action, semanticChild, node);
	}

	protected void acceptAssignedCrossRefDatatype(ISemanticSequenceAcceptor out,
			ISerializationDiagnostic.Acceptor errors, EObject semanticObj, RuleCall datatypeRC, EObject value,
			int index, ICompositeNode node) {
		String token1 = crossRefSerializer.serializeCrossRef(semanticObj,
				GrammarUtil.containingCrossReference(datatypeRC), value, node, errors);
		out.acceptAssignedCrossRefDatatype(datatypeRC, token1, value, index, node);
	}

	protected void acceptAssignedCrossRefEnum(ISemanticSequenceAcceptor out, ISerializationDiagnostic.Acceptor errors,
			EObject semanticObj, RuleCall enumRC, EObject value, int index, ICompositeNode node) {
		EObject target3 = value;
		String token3 = crossRefSerializer.serializeCrossRef(semanticObj, GrammarUtil.containingCrossReference(enumRC),
				target3, node, errors);
		out.acceptAssignedCrossRefEnum(enumRC, token3, target3, index, node);
	}

	protected void acceptAssignedCrossRefTerminal(ISemanticSequenceAcceptor out,
			ISerializationDiagnostic.Acceptor errors, EObject semanticObj, RuleCall terminalRC, EObject value,
			int index, ILeafNode node) {
		String token2 = crossRefSerializer.serializeCrossRef(semanticObj,
				GrammarUtil.containingCrossReference(terminalRC), value, node, errors);
		out.acceptAssignedCrossRefTerminal(terminalRC, token2, value, index, node);
	}

	protected void acceptAssignedDatatype(ISemanticSequenceAcceptor out, ISerializationDiagnostic.Acceptor errors,
			EObject semanticObj, RuleCall datatypeRC, Object value, int index, ICompositeNode node) {
		String token4 = valueSerializer.serializeAssignedValue(semanticObj, datatypeRC, value, node, errors);
		out.acceptAssignedDatatype(datatypeRC, token4, value, index, node);
	}

	protected void acceptAssignedEnum(ISemanticSequenceAcceptor out, ISerializationDiagnostic.Acceptor errors,
			EObject semanticObj, RuleCall enumRC, Object value, int index, ICompositeNode node) {
		String token5 = enumLiteralSerializer.serializeAssignedEnumLiteral(semanticObj, enumRC, value, node, errors);
		out.acceptAssignedEnum(enumRC, token5, value, index, node);
	}

	protected void acceptAssignedKeyword(ISemanticSequenceAcceptor out, ISerializationDiagnostic.Acceptor errors,
			EObject semanticObj, Keyword keyword, Boolean value, int index, ILeafNode node) {
		String token7 = keywordSerializer.serializeAssignedKeyword(semanticObj, keyword, value, node, errors);
		out.acceptAssignedKeyword(keyword, token7, value == null ? false : value, index, node);
	}

	protected void acceptAssignedKeyword(ISemanticSequenceAcceptor out, ISerializationDiagnostic.Acceptor errors,
			EObject semanticObj, Keyword keyword, String value, int index, ILeafNode node) {
		String token7 = keywordSerializer.serializeAssignedKeyword(semanticObj, keyword, value, node, errors);
		out.acceptAssignedKeyword(keyword, token7, value, index, node);
	}

	protected void acceptAssignedParserRuleCall(ISemanticSequenceAcceptor out,
			ISerializationDiagnostic.Acceptor errors, EObject semanticObj, RuleCall ruleCall, EObject semanticChild,
			int index, ICompositeNode node) {
		out.acceptAssignedParserRuleCall(ruleCall, semanticChild, node);
	}

	protected void acceptAssignedTerminal(ISemanticSequenceAcceptor out, ISerializationDiagnostic.Acceptor errors,
			EObject semanticObj, RuleCall terminalRC, Object value, int index, ILeafNode node) {
		String token6 = valueSerializer.serializeAssignedValue(semanticObj, terminalRC, value, node, errors);
		out.acceptAssignedTerminal(terminalRC, token6, value, index, node);
	}

	protected boolean acceptSemantic(ISemanticSequenceAcceptor out, EObject semanticObj, IConstraintElement constr,
			Object value, int index, INode node, ISerializationDiagnostic.Acceptor errors) {
		switch (constr.getType()) {
			case ASSIGNED_ACTION_CALL:
				acceptAssignedAction(out, errors, semanticObj, constr.getAction(), (EObject) value, -1,
						(ICompositeNode) node);
				return true;
			case ASSIGNED_PARSER_RULE_CALL:
				acceptAssignedParserRuleCall(out, errors, semanticObj, constr.getRuleCall(), (EObject) value, index,
						(ICompositeNode) node);
				return true;
			case ASSIGNED_CROSSREF_DATATYPE_RULE_CALL:
				acceptAssignedCrossRefDatatype(out, errors, semanticObj, constr.getRuleCall(), (EObject) value, index,
						(ICompositeNode) node);
				return true;
			case ASSIGNED_CROSSREF_TERMINAL_RULE_CALL:
				acceptAssignedCrossRefTerminal(out, errors, semanticObj, constr.getRuleCall(), (EObject) value, index,
						(ILeafNode) node);
				return true;
			case ASSIGNED_CROSSREF_ENUM_RULE_CALL:
				acceptAssignedCrossRefEnum(out, errors, semanticObj, constr.getRuleCall(), (EObject) value, index,
						(ICompositeNode) node);
				return true;
			case ASSIGNED_DATATYPE_RULE_CALL:
				acceptAssignedDatatype(out, errors, semanticObj, constr.getRuleCall(), value, index,
						(ICompositeNode) node);
				return true;
			case ASSIGNED_ENUM_RULE_CALL:
				acceptAssignedEnum(out, errors, semanticObj, constr.getRuleCall(), value, index, (ICompositeNode) node);
				return true;
			case ASSIGNED_TERMINAL_RULE_CALL:
				acceptAssignedTerminal(out, errors, semanticObj, constr.getRuleCall(), value, index, (ILeafNode) node);
				return true;
			case ASSIGNED_KEYWORD:
				acceptAssignedKeyword(out, errors, semanticObj, constr.getKeyword(), (String) value, index,
						(ILeafNode) node);
				return true;
			case ASSIGNED_BOOLEAN_KEYWORD:
				acceptAssignedKeyword(out, errors, semanticObj, constr.getKeyword(), (Boolean) value, index,
						(ILeafNode) node);
				return true;
			case ALTERNATIVE:
			case GROUP:
				return false;
		}
		return false;
	}

}
