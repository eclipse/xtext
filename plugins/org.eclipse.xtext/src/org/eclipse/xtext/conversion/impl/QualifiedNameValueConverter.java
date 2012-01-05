/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.conversion.impl;

import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;

import com.google.inject.Inject;

/**
 * A value converter for qualified names consisting of segments or wildcard literals separated by namespace delimiters.
 * Delegates to another value converter for the segments, thus enabling individual quoting of segments.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class QualifiedNameValueConverter extends AbstractValueConverter<String> {

	@Inject
	protected IValueConverterService valueConverterService;

	/**
	 * @deprecated use {@link #getStringNamespaceDelimiter()} or {@link #getValueNamespaceDelimiter()}.
	 */
	@Deprecated
	protected String getNamespaceDelimiter() {
		return ".";
	}
	
	/**
	 * Returns the used delimiter in the concrete syntax.
	 * @return the delimiter in the concrete syntax.
	 */
	protected String getStringNamespaceDelimiter() {
		return getNamespaceDelimiter();
	}
	
	/**
	 * Returns the used delimiter in the AST.
	 * @return the delimiter in the AST.
	 */
	protected String getValueNamespaceDelimiter() {
		return getNamespaceDelimiter();
	}

	protected String getWildcardLiteral() {
		return "*";
	}

	protected String getDelegateRuleName() {
		return "ID";
	}

	public String toString(String value) {
		StringBuilder buffer = new StringBuilder();
		boolean isFirst = true;
		for (String segment : value.split(Pattern.quote(getValueNamespaceDelimiter()))) {
			if (!isFirst)
				buffer.append(getStringNamespaceDelimiter());
			isFirst = false;
			if(getWildcardLiteral().equals(segment)) {
				buffer.append(getWildcardLiteral());
			} else {
				buffer.append(delegateToString(segment));
			}
		}
		return buffer.toString();
	}

	public String toValue(String string, INode node) throws ValueConverterException {
		StringBuilder buffer = new StringBuilder();
		boolean isFirst = true;
		if (node != null) {
			for(ILeafNode leafNode: node.getLeafNodes()) {
				EObject grammarElement = leafNode.getGrammarElement();
				if (isDelegateRuleCall(grammarElement) || isWildcardLiteral(grammarElement)) {
					if (!isFirst)
						buffer.append(getValueNamespaceDelimiter());
					isFirst = false;
					if (isDelegateRuleCall(grammarElement))
						buffer.append(delegateToValue(leafNode));
					else 
						buffer.append(getWildcardLiteral());
				}
			}
		} else {
			for (String segment : string.split(Pattern.quote(getStringNamespaceDelimiter()))) {
				if (!isFirst)
					buffer.append(getValueNamespaceDelimiter());
				isFirst = false;
				if(getWildcardLiteral().equals(segment)) {
					buffer.append(getWildcardLiteral());
				} else {
					buffer.append((String) valueConverterService.toValue(segment, getDelegateRuleName(), null));
				}
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
			fullWildcardLiteral = getStringNamespaceDelimiter() + getWildcardLiteral();
		}
		return fullWildcardLiteral;
	}
	
	protected String delegateToString(String segment) {
		return valueConverterService.toString(segment, getDelegateRuleName());
	}

	protected String delegateToValue(ILeafNode leafNode) {
		return (String) valueConverterService.toValue(leafNode.getText(), getDelegateRuleName(), leafNode);
	}

}
