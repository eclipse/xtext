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
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.linking.impl.LinkingHelper;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parsetree.reconstr.impl.TokenUtil;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.diagnostic.ITokenDiagnosticProvider;
import org.eclipse.xtext.xtext.RuleNames;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ValueSerializer implements IValueSerializer {

	@Inject
	private IValueConverterService converter;

	@Inject
	private RuleNames ruleNames;

	@Inject
	private LinkingHelper linkingHelper;

	@Inject
	protected ITokenDiagnosticProvider diagnostics;

	@Inject
	protected TokenUtil tokenUtil;

	@Override
	public boolean isValid(EObject context, RuleCall ruleCall, Object value, Acceptor errors) {
		try {
			String str = converter.toString(value, ruleNames.getQualifiedName(ruleCall.getRule()));
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

	@Override
	public String serializeAssignedValue(EObject context, RuleCall ruleCall, Object value, INode node, Acceptor errors) {
		AbstractRule rule = ruleCall.getRule();
		String ruleName = ruleNames.getQualifiedName(rule);
		if (node != null) {
			AbstractRule nodeRule = linkingHelper.getRuleFrom(node.getGrammarElement());
			// TODO: analyze why grammar element identity is broken here during generation of Xtext languages using MWE2  
			if (nodeRule != null && ruleNames.getQualifiedName(nodeRule).equals(ruleName)) {
				Object converted = converter.toValue(NodeModelUtils.getTokenText(node), ruleName, node);
				if (converted != null && converted.equals(value))
					return tokenUtil.serializeNode(node);
			}
		}
		try {
			String str = converter.toString(value, ruleName);
			if (str != null)
				return str;
			if (errors != null)
				errors.accept(diagnostics.getNullNotAllowedDiagnostic(context, ruleCall));
			return null;
		} catch (Throwable e) {
			if (errors != null)
				errors.accept(diagnostics.getValueConversionExceptionDiagnostic(context, ruleCall, value, e));
			return null;
		}
	}

}
