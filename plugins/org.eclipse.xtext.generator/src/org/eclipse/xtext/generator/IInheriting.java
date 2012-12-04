/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.xbase.lib.Functions;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.4
 */
public interface IInheriting {

	boolean isInheritImplementation();

	void setInheritImplementation(boolean isInheritImplementation);

	static class Util {
		public String getInheritedClassName(Grammar grammar, 
			Functions.Function1<Grammar, String> nameFunc) {
			Grammar superGrammar = getSuperGrammar(grammar);
			if (superGrammar != null) {
				String superClassName = nameFunc.apply(superGrammar);
				if (isClassExists(superClassName)) {
					return superClassName;
				}
			}
			return null;
		}

		protected boolean isClassExists(String className) {
			try {
				Class.forName(className);
				return true;
			} catch (ClassNotFoundException e) {
				return false;
			}
		}

		protected Grammar getSuperGrammar(Grammar grammar) {
			return grammar.getUsedGrammars().isEmpty() ? null : grammar.getUsedGrammars().get(0);
		}
	}
}
