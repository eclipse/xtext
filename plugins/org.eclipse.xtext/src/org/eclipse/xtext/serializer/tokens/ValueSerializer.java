/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.tokens;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parsetree.reconstr.impl.TokenUtil;
import org.eclipse.xtext.serializer.diagnostic.ITokenDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ValueSerializer implements IValueSerializer {

	@Inject
	private IValueConverterService converter;

	@Inject
	protected ITokenDiagnosticProvider diagnostics;

	@Inject
	protected TokenUtil tokenUtil;

	//	public boolean equalsOrReplacesNode(EObject context, RuleCall ruleCall, Object value, INode node) {
	//		if (ruleCall != node.getGrammarElement())
	//			return false;
	//		Assignment ass = GrammarUtil.containingAssignment(ruleCall);
	//		if (GrammarUtil.isSingleAssignment(ass))
	//			return true;
	//		Object converted = converter.toValue(serialize(node), ruleCall.getRule().getName(), node);
	//		return converted != null && converted.equals(value);
	//	}

	public boolean isValid(EObject context, RuleCall ruleCall, Object value, Acceptor errors) {
		try {
			String str = converter.toString(value, ruleCall.getRule().getName());
			if (str != null)
				return true;
			if (errors != null)
				errors.accept(diagnostics.getNullNotAllowedDiagnostic(context, ruleCall));
			return false;
		} catch (Throwable e) {
			if (errors != null)
				errors.accept(diagnostics.getValueConversionExceptionDiagnostic(context, ruleCall, value, e));
			return false;
		}
	}

	protected String serialize(INode node) {
		if (node instanceof ILeafNode)
			return ((ILeafNode) node).getText();
		else {
			StringBuilder builder = new StringBuilder(node.getLength());
			boolean hiddenSeen = false;
			for (ILeafNode leaf : node.getLeafNodes()) {
				if (!leaf.isHidden()) {
					if (hiddenSeen && builder.length() > 0)
						builder.append(' ');
					builder.append(leaf.getText());
					hiddenSeen = false;
				} else {
					hiddenSeen = true;
				}
			}
			return builder.toString();
		}
	}

	public String serializeAssignedValue(EObject context, RuleCall ruleCall, Object value, INode node,
			Acceptor errorAcceptor) {
		if (node != null) {
			Object converted = converter.toValue(serialize(node), ruleCall.getRule().getName(), node);
			if (converted != null && converted.equals(value))
				return tokenUtil.serializeNode(node);
		}
		return converter.toString(value, ruleCall.getRule().getName());
	}

}
