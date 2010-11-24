/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.formatter;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.impl.AbstractNullSafeConverter;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parsetree.AbstractNode;

public class FormatterTestValueConverters extends DefaultTerminalConverters {

	@ValueConverter(rule = "FQN")
	public IValueConverter<String> FQN() {
		return new AbstractNullSafeConverter<String>() {
			@Override
			protected String internalToValue(String string, AbstractNode node, INode newNode) {
				if (!string.equals(string.trim()))
					throw new RuntimeException();
				StringBuffer b = new StringBuffer();
				BidiTreeIterator<INode> iterator = newNode.treeIterator();
				while(iterator.hasNext()) {
					INode next = iterator.next();
					if (next instanceof ILeafNode) {
						if (!((ILeafNode) next).isHidden()) {
							b.append(next.getText());
						}
					}
				}
				return b.toString();
			}

			@Override
			protected String internalToString(String value) {
				return value;
			}
		};
	}

}
