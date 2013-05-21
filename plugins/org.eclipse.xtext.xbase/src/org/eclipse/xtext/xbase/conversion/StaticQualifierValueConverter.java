/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.conversion;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;


/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class StaticQualifierValueConverter extends XbaseQualifiedNameValueConverter {

	@Deprecated
	@Override
	protected String getNamespaceDelimiter() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public String getStringNamespaceDelimiter() {
		return "::";
	}
	
	@Override
	protected String getValueNamespaceDelimiter() {
		return ".";
	}
	
	@Override
	public String toValue(String string, INode node) throws ValueConverterException {
		StringBuilder buffer = new StringBuilder();
		boolean isFirst = true;
		if (node != null) {
			for(INode child: node.getAsTreeIterable()) {
				EObject grammarElement = child.getGrammarElement();
				if (isDelegateRuleCall(grammarElement) || isWildcardLiteral(grammarElement)) {
					if (!isFirst)
						buffer.append(getValueNamespaceDelimiter());
					isFirst = false;
					if (isDelegateRuleCall(grammarElement))
						for(ILeafNode leafNode :child.getLeafNodes()){
							if(!leafNode.isHidden())
								buffer.append(delegateToValue(leafNode));
						}
					else 
						buffer.append(getWildcardLiteral());
				}
			}
		} else {
			List<String> splitted = Strings.split(string, getStringNamespaceDelimiter());
			if (splitted.size() == 1 && string.indexOf('.') >= 0) {
				if (string.endsWith("::")) {
					string = string.substring(0, string.length() - 2);
				}
				splitted = Strings.split(string, '.');
			}
			for (String segment : splitted) {
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
	
	protected String internalToString(String value) {
		StringBuilder buffer = new StringBuilder();
		boolean isFirst = true;
		for (String segment : Strings.split(value, getValueNamespaceDelimiter())) {
			if (!isFirst)
				// prefer the dot as delimiter
				buffer.append('.');
			isFirst = false;
			if(getWildcardLiteral().equals(segment)) {
				buffer.append(getWildcardLiteral());
			} else {
				buffer.append(delegateToString(segment));
			}
		}
		return buffer.toString();
	}

	@Override
	public String toString(String value) {
		return internalToString(value) + getStringNamespaceDelimiter();
	}
	
	public String toStringWithoutNamespaceDelimiter(String value) {
		return internalToString(value);
	}
}
