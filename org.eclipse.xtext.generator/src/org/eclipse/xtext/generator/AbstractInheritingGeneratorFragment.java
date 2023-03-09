/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator;

import org.eclipse.xtext.Grammar;

/**
 * A generator fragment that generates code which inherits form the generated code
 * of the super language.
 *
 * @author Jan Koehnlein - Initial contribution and API
 */
@Deprecated(forRemoval = true)
public class AbstractInheritingGeneratorFragment extends AbstractGeneratorFragment implements IInheriting {

	private boolean isInheritImplementation = true;

	@Override
	public boolean isInheritImplementation() {
		return isInheritImplementation;
	}

	@Override
	public void setInheritImplementation(boolean isInheritImplementation) {
		this.isInheritImplementation = isInheritImplementation;
	}
	
	@Deprecated(forRemoval = true)
	public String getSuperClassName(String superClassName, String defaultName) {
		if (isInheritImplementation && isClassExists(superClassName))
			return superClassName;
		else
			return defaultName;
	}

	@Deprecated(forRemoval = true)
	protected boolean isClassExists(String className) {
		try {
			Class.forName(className);
			return true;
		} catch (ClassNotFoundException e) {
			return false;
		}
	}

	/**
	 * @return the super grammar 
	 */
	protected Grammar getSuperGrammar(Grammar grammar) {
		if(!grammar.getUsedGrammars().isEmpty()) {
			return grammar.getUsedGrammars().get(0);
		} else {
			return null;
		}
	}
}
