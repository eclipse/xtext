/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.service

import org.eclipse.xtext.util.internal.EmfAdaptable
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.GrammarUtil
import com.google.common.collect.Maps
import org.eclipse.xtext.TerminalRule
import org.eclipse.xtext.AbstractRule
import java.util.Map
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * @author Christian Dietrich - Initial contribution and API
 * @since 2.14
 */
@EmfAdaptable
@Accessors
class AllRulesCache {
	
	val Map<String, AbstractRule> allRules;
	
	new(Grammar grammar) {
		allRules = Maps.newHashMap();
		for (AbstractRule rule: GrammarUtil.allRules(grammar)) {
			if(rule instanceof TerminalRule) {
				allRules.put(rule.getName().toUpperCase(), rule);
			} else {
				allRules.put(rule.getName(), rule);
			}
		}
	}
	
}