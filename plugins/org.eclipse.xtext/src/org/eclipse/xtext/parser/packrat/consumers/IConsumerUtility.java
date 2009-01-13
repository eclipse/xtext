/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.consumers;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Keyword;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IConsumerUtility {

	boolean consumeKeyword(Keyword keyword, String feature, boolean isMany, boolean isBoolean);
	
	boolean consumeTerminal(ITerminalConsumer consumer, String feature, boolean isMany, boolean isBoolean, AbstractElement grammarElement);
	
	boolean consumeNonTerminal(INonTerminalConsumer consumer, String feature, boolean isMany, boolean isDatatype, AbstractElement grammarElement) throws Exception;
	
	void consumeAction(String typeName, String feature, boolean isMany);
}
