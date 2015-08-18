/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.normalization;

import java.util.List;

import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RuleFilter {

	public List<AbstractRule> getRules(Grammar grammar) {
		return GrammarUtil.allRules(grammar);
	}
	
}
