/*******************************************************************************

 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.generator.quickfix;

import java.util.List;
import java.util.Set;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.AbstractStubGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.IGeneratorFragment;
import org.eclipse.xtext.generator.IInheriting;
import org.eclipse.xtext.generator.Naming;

/**
 * {@link IGeneratorFragment} to generate a quickfix provider for a given grammar.
 *
 * @author Knut Wannheden - Initial contribution and API
 * @author Heiko Behrens
 */
@Deprecated
public class QuickfixProviderFragment extends AbstractStubGeneratorFragment implements IInheriting {

	private boolean isInheritImplementation = true;
	
	public static String getQuickfixProviderName(Grammar g, Naming n) {
		return n.basePackageUi(g) + ".quickfix." + GrammarUtil.getSimpleName(g) + "QuickfixProvider";
	}

	/**
	 * @since 2.4
	 */
	public String getQuickfixProviderSuperClassName(Grammar g) {
		Grammar superGrammar = IInheriting.Util.getNonTerminalsSuperGrammar(g);
		if(isInheritImplementation && superGrammar != null) 
			return getQuickfixProviderName(superGrammar, getNaming());
		else
			return "org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider";
	}
	
	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		BindFactory bindFactory = new BindFactory();
		if(isGenerateStub()) {
			 bindFactory
				.addTypeToType("org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider", getQuickfixProviderName(grammar, getNaming()));
		} else {
			 bindFactory
				.addTypeToType("org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider", getQuickfixProviderSuperClassName(grammar));
		}
		return bindFactory.getBindings();
	}

	/**
	 * @since 2.4
	 */
	@Override
	public boolean isInheritImplementation() {
		return isInheritImplementation;
	}

	/**
	 * @since 2.4
	 */
	@Override
	public void setInheritImplementation(boolean isInheritImplementation) {
		this.isInheritImplementation = isInheritImplementation;
	}

	/**
	 * @since 2.4
	 */
	@Override
	protected List<Object> getParameters(Grammar grammar) {
		List<Object> parameters = super.getParameters(grammar);
		parameters.add(getQuickfixProviderSuperClassName(grammar));
		return parameters;
	}

	/**
	 * @since 2.4
	 */
	@Override
	public String[] getExportedPackagesUi(Grammar grammar) {
		if(isGenerateStub()) 
			return new String[] { getNaming().packageName(getQuickfixProviderName(grammar, getNaming())) };			
		else 
			return super.getExportedPackagesUi(grammar);
	}
}
