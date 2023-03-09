/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.tokens;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parsetree.reconstr.impl.TokenUtil;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.diagnostic.ITokenDiagnosticProvider;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class EnumLiteralSerializer implements IEnumLiteralSerializer {

	@Inject
	protected ITokenDiagnosticProvider diagnosticProvider;

	//	public boolean equalsOrReplacesNode(EObject context, RuleCall ruleCall, Object value, INode node) {
	//		Keyword nodeLit = getLiteral(node);
	//		Keyword modelLit = getLiteral(context, ruleCall, value);
	//		return nodeLit != null && nodeLit.equals(modelLit);
	//	}

	@Inject
	protected TokenUtil tokenUtil;

	protected Keyword getLiteral(EObject context, RuleCall ruleCall, Object value) {
		EnumRule rule = (EnumRule) ruleCall.getRule();
		if (rule.getAlternatives() instanceof EnumLiteralDeclaration) {
			EnumLiteralDeclaration decl = (EnumLiteralDeclaration) rule.getAlternatives();
			if (decl.getEnumLiteral().getInstance().equals(value)) {
				return decl.getLiteral();
			}
		} else {
			for (AbstractElement element : ((Alternatives) rule.getAlternatives()).getElements()) {
				EnumLiteralDeclaration decl = (EnumLiteralDeclaration) element;
				if (decl.getEnumLiteral().getInstance().equals(value)) {
					return decl.getLiteral();
				}
			}
		}
		return null;
	}

	protected Keyword getLiteral(INode node) {
		if (node != null) {
			for (ILeafNode leaf : node.getLeafNodes()) {
				if (leaf.getGrammarElement() instanceof EnumLiteralDeclaration)
					return ((EnumLiteralDeclaration) leaf.getGrammarElement()).getLiteral();
			}
		}
		return null;
	}

	@Override
	public boolean isValid(EObject context, RuleCall ruleCall, Object value, Acceptor errorAcceptor) {
		return getLiteral(context, ruleCall, value) != null;
	}

	@Override
	public String serializeAssignedEnumLiteral(EObject context, RuleCall ruleCall, Object value, INode node,
			Acceptor errorAcceptor) {
		Keyword nodeLit = getLiteral(node);
		Keyword modelLit = getLiteral(context, ruleCall, value);
		if (modelLit == null) {
			if (errorAcceptor != null)
				errorAcceptor.accept(diagnosticProvider.getInvalidEnumValueDiagnostic(context, ruleCall, value));
			return null;
		} else if (nodeLit != null && nodeLit.equals(modelLit))
			return tokenUtil.serializeNode(node);
		else
			return modelLit.getValue();
	}
}
