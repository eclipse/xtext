/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import java.util.Iterator;

import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractNullSafeConverter;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parsetree.AbstractNode;

import com.google.common.collect.Iterators;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextValueConverters extends DefaultTerminalConverters {

	@ValueConverter(rule = "GrammarID")
	public IValueConverter<String> GrammarID() {
		return new AbstractNullSafeConverter<String>() {
			@Override
			protected String internalToValue(String string, AbstractNode node, INode newNode) throws ValueConverterException {
				StringBuilder result = new StringBuilder();
				Iterator<ILeafNode> iter = Iterators.filter(newNode.treeIterator(), ILeafNode.class);
				while(iter.hasNext()) {
					ILeafNode leaf = iter.next();
					if (!leaf.isHidden()) {
						if (leaf.getGrammarElement() instanceof Keyword)
							result.append(leaf.getText());
						else
							result.append(ID().toValue(leaf.getText(), null, leaf));
					}
				}
				return result.toString();
			}

			@Override
			protected String internalToString(String value) {
				String[] splitted = value.split("\\.");
				StringBuilder result = new StringBuilder(value.length());
				for(int i = 0; i < splitted.length; i++) {
					if (i != 0)
						result.append('.');
					result.append(ID().toString(splitted[i]));
				}
				return result.toString();
			}
		};
	}

}
