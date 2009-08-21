/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.generator.quickfix;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;

/**
 * {@link IGeneratorFragment} to generate a quickfix provider for a given grammar.
 * 
 * @author Knut Wannheden - Initial contribution and API
 */
public class QuickfixProviderFragment extends AbstractGeneratorFragment {

	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		return new String[] { "org.eclipse.ui.ide" };
	}

	public static String getQuickfixProviderName(Grammar g) {
		return GrammarUtil.getNamespace(g) + ".quickfix." + GrammarUtil.getName(g) + "QuickfixProvider";
	}

}
