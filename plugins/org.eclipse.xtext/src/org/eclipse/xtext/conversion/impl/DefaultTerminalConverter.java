/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.conversion.impl;


import org.eclipse.emf.ecore.EDataType;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.parsetree.AbstractNode;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author koehnlein - Initial contribution and API
 */
public class DefaultTerminalConverter extends AbstractLexerBasedConverter<Object> {

	public static class Factory {
		@Inject
		protected Provider<DefaultTerminalConverter> provider;
		
		public DefaultTerminalConverter create(TerminalRule terminalRule) {
			EDataType dataType = (EDataType) terminalRule.getType().getClassifier();
			DefaultTerminalConverter defaultTerminalConverter = provider.get();
			defaultTerminalConverter.setDataType(dataType);
			defaultTerminalConverter.setRule(terminalRule);
			return defaultTerminalConverter;
		}
	}
	
	private EDataType dataType;

	protected DefaultTerminalConverter() {
	}
	
	protected void setDataType(EDataType dataType) {
		this.dataType = dataType;
	}

	public Object toValue(String string, AbstractNode node) throws ValueConverterException {
		try {
			return dataType.getEPackage().getEFactoryInstance().createFromString(dataType, string);
		} catch (Exception exc) {
			throw new ValueConverterException("Error converting string to value", node, exc);
		}
	}

	@Override
	protected String toEscapedString(Object value) {
		return dataType.getEPackage().getEFactoryInstance().convertToString(dataType, value);		
	}

}
