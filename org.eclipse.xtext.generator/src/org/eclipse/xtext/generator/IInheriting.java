/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator;

import static org.eclipse.xtext.util.Strings.*;

import org.eclipse.xtext.Grammar;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.4
 */
@Deprecated(forRemoval = true)
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
