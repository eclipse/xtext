/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator;

import static org.eclipse.xtext.util.Strings.*;

import org.eclipse.xtext.Grammar;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.4
 */
public interface IInheriting {

	boolean isInheritImplementation();

	void setInheritImplementation(boolean isInheritImplementation);
	
	static class Util {
		public static Grammar getNonTerminalsSuperGrammar(Grammar grammar) {
			if(!grammar.getUsedGrammars().isEmpty()) {
				Grammar superGrammar = grammar.getUsedGrammars().get(0);
				if(!equal(superGrammar.getName(), "org.eclipse.xtext.common.Terminals"))
					return superGrammar;
			}
			return null;
		}
	}
}
