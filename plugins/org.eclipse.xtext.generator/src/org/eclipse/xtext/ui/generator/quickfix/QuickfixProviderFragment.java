/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.generator.quickfix;

import java.util.Set;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.validation.IssueResolutionProvider;

/**
 * {@link IGeneratorFragment} to generate a quickfix provider for a given grammar.
 * 
 * @author Knut Wannheden - Initial contribution and API
 * @author Heiko Behrens
 */
public class QuickfixProviderFragment extends AbstractGeneratorFragment {

	public static String getQuickfixProviderName(Grammar g, Naming n) {
		return n.basePackageUi(g) + ".quickfix." + GrammarUtil.getName(g) + "QuickfixProvider";
	}

	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		return new BindFactory()
			.addTypeToType(IssueResolutionProvider.class.getName(), getQuickfixProviderName(grammar, getNaming()))
			.getBindings();
	}

}
