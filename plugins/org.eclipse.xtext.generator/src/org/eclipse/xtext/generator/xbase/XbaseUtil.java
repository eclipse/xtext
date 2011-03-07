/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.xbase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.Grammar;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XbaseUtil {

	public static boolean usesXbaseGrammar(Grammar grammar) {
		if (grammar.getName().equals("org.eclipse.xtext.xbase.Xbase"))
			return true;
		EList<Grammar> usedGrammars = grammar.getUsedGrammars();
		for (Grammar grammar2 : usedGrammars) {
			if (usesXbaseGrammar(grammar2)) {
				return true;
			}
		}
		return false;
	}

}
