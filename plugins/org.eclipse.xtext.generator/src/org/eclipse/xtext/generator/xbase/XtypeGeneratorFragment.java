/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.xbase;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.DefaultGeneratorFragment;

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.9
 */
public class XtypeGeneratorFragment extends DefaultGeneratorFragment {

	protected boolean doesUseXtype(Grammar grammar) {
		if (grammar.getName().equals("org.eclipse.xtext.xbase.Xtype"))
			return true;
		for (Grammar usedGrammar : grammar.getUsedGrammars()) {
			if (doesUseXtype(usedGrammar)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		if (!doesUseXtype(grammar))
			return new String[0];
		return new String[] { "org.eclipse.xtext.xbase.ui" };
	}
}
