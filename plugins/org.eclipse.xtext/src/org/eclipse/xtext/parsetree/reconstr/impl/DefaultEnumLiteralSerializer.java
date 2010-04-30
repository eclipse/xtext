/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer;

/**
 * @author meysholdt - Initial contribution and API
 */
public class DefaultEnumLiteralSerializer extends AbstractEnumLiteralSerializer {

	@Override
	public boolean equalsOrReplacesNode(EObject context, RuleCall ruleCall, Object value, AbstractNode node) {
		Keyword nodeLit = getLiteral(node);
		Keyword modelLit = getLiteral(context, ruleCall, value);
		return nodeLit != null && nodeLit.equals(modelLit);
	}

	protected Keyword getLiteral(AbstractNode node) {
		if (node != null) {
			TreeIterator<EObject> i = EcoreUtil2.eAll(node);
			while (i.hasNext()) {
				EObject o = i.next();
				if (o instanceof LeafNode && ((LeafNode) o).getGrammarElement() instanceof EnumLiteralDeclaration)
					return ((EnumLiteralDeclaration) ((LeafNode) o).getGrammarElement()).getLiteral();
			}
		}
		return null;
	}

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

	@Override
	public boolean isValid(EObject context, RuleCall ruleCall, Object value, IErrorAcceptor errorAcceptor) {
		return getLiteral(context, ruleCall, value) != null;
	}

	@Override
	public String serializeAssignedEnumLiteral(EObject context, RuleCall ruleCall, Object value, AbstractNode node) {
		Keyword nodeLit = getLiteral(node);
		Keyword modelLit = getLiteral(context, ruleCall, value);
		if (nodeLit != null && nodeLit.equals(modelLit))
			return ITokenSerializer.KEEP_VALUE_FROM_NODE_MODEL;
		return modelLit.getValue();
	}
}
