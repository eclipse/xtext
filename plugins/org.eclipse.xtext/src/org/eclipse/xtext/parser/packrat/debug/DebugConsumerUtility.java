/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.debug;

import org.apache.log4j.Logger;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DebugConsumerUtility implements IConsumerUtility {

	private static final Logger log = Logger.getLogger(DebugConsumerUtility.class);
	
	private final IConsumerUtility delegate;
	
	public DebugConsumerUtility(IConsumerUtility delegate) {
		this.delegate = delegate;
	}
	
	public void consumeAction(Action action, String typeName, boolean isMany) {
		if (log.isDebugEnabled()) {
			log.debug("consumeAction(typeName = " + typeName + ", feature = " + action.getFeature() + ", isMany = " + isMany + ")"); 
		}
		delegate.consumeAction(action, typeName, isMany);
	}

	public int consumeKeyword(Keyword keyword, String feature, boolean isMany, boolean isBoolean,
			ICharacterClass notFollowedBy) {
		if (log.isDebugEnabled()) {
			log.debug("consumeKeyword(keyword = '" + keyword.getValue() + "', " +
					"feature = " + feature + ", " +
					"isMany = " + isMany + ", " +
					"isBoolean = " + isBoolean + ", " +
					"notFollowedBy = " + notFollowedBy + ")"); 
		}
		int result = delegate.consumeKeyword(keyword, feature, isMany, isBoolean, notFollowedBy);
		if (log.isDebugEnabled()) {
			log.debug("consumeKeyword('" + keyword.getValue() + "') = " + result); 
		}
		return result;
	}

	public int consumeNonTerminal(INonTerminalConsumer consumer, String feature, boolean isMany,
			boolean isDatatype, AbstractElement grammarElement) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("consumeNonTerminal(consumer = '" + consumer + "', " +
					"feature = " + feature + ", " +
					"isMany = " + isMany + ", " +
					"isDatatype = " + isDatatype + ", " +
					"grammarElement = " + grammarElement.eClass().getName() + ")"); 
		}
		int result = delegate.consumeNonTerminal(consumer, feature, isMany, isDatatype, grammarElement);
		if (log.isDebugEnabled()) {
			log.debug("consumeNonTerminal(" + consumer + ") = " + result); 
		}
		return result;
	}

	public int consumeTerminal(ITerminalConsumer consumer, String feature, boolean isMany, boolean isBoolean,
			AbstractElement grammarElement, ISequenceMatcher notMatching) {
		if (log.isDebugEnabled()) {
			log.debug("consumeTerminal(consumer = '" + consumer + "', " +
					"feature = " + feature + ", " +
					"isMany = " + isMany + ", " +
					"isBoolean = " + isBoolean + ", " +
					"grammarElement = " + grammarElement.eClass().getName() + ", " +
					"notMatching = " + notMatching + ")"); 
		}
		int result = delegate.consumeTerminal(consumer, feature, isMany, isBoolean, grammarElement, notMatching);
		if (log.isDebugEnabled()) {
			log.debug("consumeTerminal(" + consumer + ") = " + result); 
		}
		return result;
	}

}
