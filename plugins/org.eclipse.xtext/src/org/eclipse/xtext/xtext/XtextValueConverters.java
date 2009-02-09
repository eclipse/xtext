/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.builtin.conversion.XtextBuiltInConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractNullSafeConverter;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.LeafNode;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextValueConverters extends XtextBuiltInConverters {

	@ValueConverter(rule = "GrammarID")
	public IValueConverter<String> GrammarID() {
		return new AbstractNullSafeConverter<String>() {
			@Override
			protected String internalToValue(String string, AbstractNode node) throws ValueConverterException {
				StringBuilder result = new StringBuilder(); 
				for(LeafNode leaf: node.getLeafNodes()) {
					if (!leaf.isHidden()) {
						if (leaf.getGrammarElement() instanceof Keyword)
							result.append(leaf.getText());
						else
							result.append(ID().toValue(leaf.getText(), leaf));
					}
				}
				return result.toString();
			}

			@Override
			protected String internalToString(String value) {
				String[] splitted = value.split("\\.");
				StringBuilder result = new StringBuilder(value.length());
				for (String s: splitted)
					result.append(ID().toString(s));
				return result.toString();
			}
		};
	}
	
}
