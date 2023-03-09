/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.conversion.impl;


import org.eclipse.emf.ecore.EDataType;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.INode;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Jan Koehnlein - Initial contribution and API
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

	@Override
	public Object toValue(String string, INode node) throws ValueConverterException {
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
