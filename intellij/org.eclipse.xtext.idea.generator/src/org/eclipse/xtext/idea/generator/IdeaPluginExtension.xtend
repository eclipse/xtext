/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.generator

import org.eclipse.xtext.Grammar
import org.eclipse.xtext.GrammarUtil
import org.eclipse.xtext.TerminalRule

class IdeaPluginExtension {
	
	def getAllNonTerminalRules(Grammar grammar) {
		GrammarUtil.allRules(grammar).filter[!(it instanceof TerminalRule)]
	}
	
	def getSimpleName(Grammar grammar) {
		GrammarUtil::getName(grammar);
	}
	
	def getPackageName(Grammar grammar) {
		GrammarUtil::getNamespace(grammar);
	}
	
	def getLanguageID(Grammar grammar) {
		grammar.name
	}

}