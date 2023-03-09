/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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

	interface IEnumRuleAccess extends IAbstractRuleAccess {
		@Override
		EnumRule getRule();
	}

	interface IParserRuleAccess extends IAbstractRuleAccess {
		@Override
		ParserRule getRule();
	}

	List<Pair<Keyword, Keyword>> findKeywordPairs(String leftKw, String rightKw);

	List<Keyword> findKeywords(String... keywords);
	
	List<RuleCall> findRuleCalls(AbstractRule... rules);

	Grammar getGrammar();

}
