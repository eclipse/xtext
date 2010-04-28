/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext;

import java.util.List;

import org.eclipse.xtext.util.Pair;

/**
 * TODO Javadoc
 */
public interface IGrammarAccess {

	/**
	 * TODO can we use generics instead of inheritance?
	 */
	interface IAbstractRuleAccess {
		AbstractRule getRule();
	}

	interface IParserRuleAccess extends IAbstractRuleAccess {
		ParserRule getRule();
	}

	interface IEnumRuleAccess extends IAbstractRuleAccess {
		EnumRule getRule();
	}

	List<Pair<Keyword, Keyword>> findKeywordPairs(String leftKw, String rightKw);

	Grammar getGrammar();

}
