/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.conversion.impl;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * A value converter for qualified names consisting of segments or wildcard literals separated by namespace delimiters.
 * Delegates to another value converter for the segments, thus enabling individual quoting of segments.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
@Singleton
public class QualifiedNameValueConverter extends AbstractValueConverter<String> {

	@Inject
	protected IValueConverterService valueConverterService;
	
	/**
	 * @since 2.7
	 */
	protected IValueConverter<Object> delegateConverter;

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

	@Override
	public String toString(String value) {
		if (value == null) {
			throw new ValueConverterException("'null' is not a valid qualified name value", null, null);
		}
		String valueDelimiter = getValueNamespaceDelimiter();
		List<String> segments = valueDelimiter.length() == 1 ? Strings.split(value, valueDelimiter.charAt(0)) : Strings.split(value, valueDelimiter);
		int size = segments.size();
		if (size == 1) {
			return delegateToString(segments.get(0));
		}
		StringBuilder result = new StringBuilder(value.length());
		String delimiterToUse = getStringNamespaceDelimiter();
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				result.append(delimiterToUse);
			}
			if (i == size - 1 && getWildcardLiteral().equals(segments.get(i))) {
				result.append(getWildcardLiteral());
			} else {
				result.append(delegateToString(segments.get(i)));
			}
		}
		return result.toString();
	}

	@Override
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
			for (String segment : Strings.split(string, getStringNamespaceDelimiter())) {
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
	
	private IValueConverter<Object> initializeDelegateConverter() {
		if (valueConverterService instanceof IValueConverterService.Introspectable) {
			return delegateConverter = ((IValueConverterService.Introspectable) valueConverterService).getConverter(getDelegateRuleName());
		} else {
			final String ruleName = getDelegateRuleName();
			return delegateConverter = new IValueConverter<Object>() {

				@Override
				public Object toValue(String string, INode node) throws ValueConverterException {
					return valueConverterService.toValue(string, ruleName, node);
				}

				@Override
				public String toString(Object value) throws ValueConverterException {
					return valueConverterService.toString(value, ruleName);
				}
				
			};
		}
	}
	
	protected String delegateToString(String segment) {
		if (delegateConverter == null) {
			return initializeDelegateConverter().toString(segment);
		}
		return delegateConverter.toString(segment);
	}

	protected String delegateToValue(ILeafNode leafNode) {
		if (delegateConverter == null) {
			return (String) initializeDelegateConverter().toValue(leafNode.getText(), leafNode);
		}
		return (String) delegateConverter.toValue(leafNode.getText(), leafNode);
	}

}
