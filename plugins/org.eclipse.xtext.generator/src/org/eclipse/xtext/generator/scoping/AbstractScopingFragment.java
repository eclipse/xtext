/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.scoping;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.AbstractInheritingGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.IgnoreCaseLinking;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractScopingFragment extends AbstractInheritingGeneratorFragment {

	public static String getScopeProviderName(Grammar grammar, Naming naming) {
		return naming.basePackageRuntime(grammar) + ".scoping." + GrammarUtil.getName(grammar) + "ScopeProvider";
	}

	private boolean ignoreCase;

	public boolean isIgnoreCase() {
		return ignoreCase;
	}

	public void setIgnoreCase(boolean ignoreCase) {
		this.ignoreCase = ignoreCase;
	}

	protected abstract Class<? extends IGlobalScopeProvider> getGlobalScopeProvider();

	protected abstract Class<? extends IScopeProvider> getLocalScopeProvider();

	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		BindFactory factory = new BindFactory()
				.addTypeToType(IScopeProvider.class.getName(), getScopeProviderName(grammar, getNaming()))
				.addConfiguredBinding(
						IScopeProvider.class.getName() + "Delegate",
						"binder.bind(" + IScopeProvider.class.getName() + ".class"
								+ ").annotatedWith(com.google.inject.name.Names.named("
								+ AbstractDeclarativeScopeProvider.class.getName() + ".NAMED_DELEGATE" + ")).to("
								+ getLocalScopeProvider().getName() + ".class)")
				.addTypeToType(IGlobalScopeProvider.class.getName(), getGlobalScopeProvider().getName());
		factory.addConfiguredBinding(IgnoreCaseLinking.class.getSimpleName(), "binder.bindConstant().annotatedWith("
				+ IgnoreCaseLinking.class.getName() + ".class).to(" + isIgnoreCase() + ")");
		return factory.getBindings();
	}

	protected String getScopeProviderSuperClassName(Grammar grammar) {
		Grammar superGrammar = getSuperGrammar(grammar);
		if(superGrammar != null) {
			return getSuperClassName(getScopeProviderName(superGrammar, getNaming()), getDefaultScopeProviderSuperClassName());
		}
		return getDefaultScopeProviderSuperClassName();
	}
	
	protected String getDefaultScopeProviderSuperClassName() {
		return "org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider";
	}
	
	@Override
	protected List<Object> getParameters(Grammar grammar) {
		return Collections.<Object>singletonList(getScopeProviderSuperClassName(grammar));
	}
}
