/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.conversion.impl;

import java.io.StringWriter;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.LeafNode;

import com.google.inject.Inject;

/**
 * A value converter for qualified names consisting of segments or wildcard literals separated by namespace delimiters.
 * Delegates to another value converter for the segments, thus enabling individual quoting of segments.
 * 
 * @author koehnlein - Initial contribution and API
 */
public class QualifiedNameValueConverter extends AbstractValueConverter<String> {

	@Inject
	protected IValueConverterService valueConverterService;

	protected String getNamespaceDelimiter() {
		return ".";
	}

	protected String getWildcardLiteral() {
		return "*";
	}

	protected String getDelegateRuleName() {
		return "ID";
	}

	public String toString(String value) {
		StringWriter buffer = new StringWriter();
		boolean isFirst = true;
		for (String segment : value.split(Pattern.quote(getNamespaceDelimiter()))) {
			if (!isFirst)
				buffer.append(getNamespaceDelimiter());
			isFirst = false;
			if(getWildcardLiteral().equals(segment)) {
				buffer.append(getWildcardLiteral());
			} else {
				buffer.append(delegateToString(segment));
			}
		}
		return buffer.toString();
	}

	public String toValue(String string, AbstractNode node) throws ValueConverterException {
		StringWriter buffer = new StringWriter();
		boolean isFirst = true;
		for (LeafNode leafNode : node.getLeafNodes()) {
			EObject grammarElement = leafNode.getGrammarElement();
			if (isDelegateRuleCall(grammarElement) || isWildcardLiteral(grammarElement)) {
				if (!isFirst)
					buffer.append(getNamespaceDelimiter());
				isFirst = false;
				if (isDelegateRuleCall(grammarElement))
					buffer.append(delegateToValue(leafNode));
				else 
					buffer.append(getWildcardLiteral());
			}
		}
		return buffer.toString();
	}

	protected boolean isDelegateRuleCall(EObject grammarElement) {
		return grammarElement instanceof RuleCall
				&& getDelegateRuleName().equals(((RuleCall) grammarElement).getRule().getName());
	}

	protected boolean isWildcardLiteral(EObject grammarElement) {
		if(grammarElement instanceof Keyword) {
			String keyword = ((Keyword) grammarElement).getValue();
			return getWildcardLiteral().equals(keyword) ||
				getFullWildcardLiteral().equals(keyword);
		}
		return false;
	}

	protected String fullWildcardLiteral = null;
	
	protected String getFullWildcardLiteral() {
		if(fullWildcardLiteral == null) {
			fullWildcardLiteral = getNamespaceDelimiter() + getWildcardLiteral();
		}
		return fullWildcardLiteral;
	}
	
	protected String delegateToString(String segment) {
		return valueConverterService.toString(segment, getDelegateRuleName());
	}

	protected String delegateToValue(LeafNode leafNode) {
		return (String) valueConverterService.toValue(leafNode.getText(), getDelegateRuleName(), leafNode);
	}

}
