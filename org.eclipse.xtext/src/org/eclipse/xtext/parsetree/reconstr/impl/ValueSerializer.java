/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer.IValueSerializer;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ValueSerializer implements IValueSerializer {

	@Inject
	private IValueConverterService converter;

	@Override
	public boolean equalsOrReplacesNode(EObject context, RuleCall ruleCall, INode node) {
		return ruleCall == node.getGrammarElement();
	}

	@Override
	public boolean equalsOrReplacesNode(EObject context, RuleCall ruleCall, Object value, INode node) {
		if (ruleCall != node.getGrammarElement())
			return false;
		Assignment ass = GrammarUtil.containingAssignment(ruleCall);
		if (GrammarUtil.isSingleAssignment(ass))
			return true;
		Object converted = converter.toValue(serialize(node), ruleCall.getRule().getName(), node);
		return converted != null && converted.equals(value);
	}

	@Override
	public boolean isValid(EObject context, RuleCall ruleCall, Object value, IErrorAcceptor errorAcceptor) {
		try {
			String str = converter.toString(value, ruleCall.getRule().getName());
			if (str != null)
				return true;
			if (errorAcceptor != null)
				errorAcceptor.error("The value may not be null.");
			return false;
		} catch (Throwable e) {
			if (errorAcceptor != null)
				errorAcceptor.error(e.getMessage());
			return false;
		}
	}

	protected String serialize(INode node) {
		if (node instanceof ILeafNode)
			return ((ILeafNode) node).getText();
		else {
			StringBuilder builder = new StringBuilder(node.getLength());
			boolean hiddenSeen = false;
			for(ILeafNode leaf: node.getLeafNodes()) {
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

	@Override
	public String serializeAssignedValue(EObject context, RuleCall ruleCall, Object value, INode node) {
		if (node != null) {
			Object converted = converter.toValue(serialize(node), ruleCall.getRule().getName(), node);
			if (converted != null && converted.equals(value))
				return ITokenSerializer.KEEP_VALUE_FROM_NODE_MODEL;
		}
		return converter.toString(value, ruleCall.getRule().getName());
	}

	@Override
	public String serializeUnassignedValue(EObject context, RuleCall ruleCall, INode node) {
		String r = serializeUnassignedValueByRuleCall(ruleCall, context, node);
		if (r != null)
			return r;
		r = serializeUnassignedValueByRule(ruleCall.getRule(), context, node);
		if (r != null)
			return r;
		if (node != null)
			return ITokenSerializer.KEEP_VALUE_FROM_NODE_MODEL;
		throw new IllegalArgumentException("Could not determine the value for the unassigned rulecall of rule "
				+ ruleCall.getRule().getName() + " from within rule " + GrammarUtil.containingRule(ruleCall).getName()
				+ ". You might want to implement " + IValueSerializer.class.getName()
				+ ".serializeUnassignedValue() or modify your implementation to handle this rulecall.");
	}

	protected String serializeUnassignedValueByRule(AbstractRule rule, EObject current, INode node) {
		// Sorry, but there is no generic default implementation for this yet.
		// A valid implementation would be to automatically derive a valid value
		// for the called rule.
		return null;
	}

	protected String serializeUnassignedValueByRuleCall(RuleCall ruleCall, EObject current, INode node) {
		// Sorry, but there is no generic default implementation for this yet.
		return null;
	}

}
