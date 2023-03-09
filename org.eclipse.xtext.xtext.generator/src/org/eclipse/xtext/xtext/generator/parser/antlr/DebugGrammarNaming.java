/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.parser.antlr;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

public class DebugGrammarNaming extends GrammarNaming {
	@Override
	public TypeReference getInternalParserSuperClass(Grammar it) {
		return null;
	}

	@Override
	public boolean isCombinedGrammar(Grammar it) {
		return true;
	}

	@Override
	protected String getGrammarNamePrefix(Grammar it) {
		return "Debug";
	}
}
