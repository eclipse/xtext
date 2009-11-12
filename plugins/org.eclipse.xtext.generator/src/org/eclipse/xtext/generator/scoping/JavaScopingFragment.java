/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.generator.scoping;

import java.util.Set;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.SimpleNameScopeProvider;

/**
 * An {@link IGeneratorFragment} to create Java-based scoping.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class JavaScopingFragment extends AbstractGeneratorFragment {
	
	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		return new BindFactory()
			.addTypeToType(IScopeProvider.class.getName(), getScopeProviderName(grammar))
			.addConfiguredBinding(IScopeProvider.class.getName() + "Delegate", 
					"binder.bind(" + 
						IScopeProvider.class.getName() + ".class" +
						").annotatedWith(com.google.inject.name.Names.named(" +
						"\"" + AbstractDeclarativeScopeProvider.NAMED_DELEGATE + "\"" +
						")).to("+ SimpleNameScopeProvider.class.getName() + ".class)")
			.getBindings();
	}

	public static String getScopeProviderName(Grammar grammar) {
		return GrammarUtil.getNamespace(grammar) + ".scoping." + GrammarUtil.getName(grammar) + "ScopeProvider";
	}
	
}
