/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.antlr.ex.wsAware;

import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.generator.parser.antlr.ex.common.AntlrFragmentHelper;


/**
 * This fragment helper could be used to implement whitespace aware grammars.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SyntheticTerminalAwareFragmentHelper extends AntlrFragmentHelper {
	
	public SyntheticTerminalAwareFragmentHelper(Naming naming) {
		super(naming);
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * This implementation answers <code>true</code> for any terminal rule that has a body in the form
	 * <code>terminal MY_TERMINAL: 'synthetic:MY_TERMINAL';</code>.
	 * </p>
	 */
	@Override
	public boolean isSyntheticTerminalRule(TerminalRule rule) {
		if (rule.getAlternatives() instanceof Keyword) {
			String value = ((Keyword) rule.getAlternatives()).getValue();
			return ("synthetic:" + rule.getName()).equals(value);
		}
		return false;
	}

}
