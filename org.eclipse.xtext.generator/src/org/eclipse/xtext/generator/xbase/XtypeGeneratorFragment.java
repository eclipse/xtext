/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.xbase;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.DefaultGeneratorFragment;

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.9
 */
@Deprecated
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
