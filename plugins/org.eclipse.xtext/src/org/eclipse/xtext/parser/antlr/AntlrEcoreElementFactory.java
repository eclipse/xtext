/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import org.antlr.runtime.Token;
import org.eclipse.xtext.parser.DefaultEcoreElementFactory;
import org.eclipse.xtext.parser.impl.DatatypeRuleToken;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AntlrEcoreElementFactory extends DefaultEcoreElementFactory {

	@Override
	protected Object getTokenAsStringIfPossible(Object tokenOrValue) {
		Object value = super.getTokenAsStringIfPossible(tokenOrValue);
		if (value instanceof DatatypeRuleToken) {
			value = ((DatatypeRuleToken) value).getText();
		} else if (value instanceof Token) {
			value = ((Token) value).getText();
		}
		return value;
	}
}
