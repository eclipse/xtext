/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.scoping;

import java.util.Set;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.ignorecase.IgnoreCaseResourceDescriptionManager;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractScopingFragment extends AbstractGeneratorFragment {

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
			.addConfiguredBinding(IScopeProvider.class.getName() + "Delegate", 
				"binder.bind(" + 
					IScopeProvider.class.getName() + ".class" +
					").annotatedWith(com.google.inject.name.Names.named(" +
					"\"" + AbstractDeclarativeScopeProvider.NAMED_DELEGATE + "\"" +
					")).to("+ getLocalScopeProvider().getName() + ".class)")
			.addTypeToType(IGlobalScopeProvider.class.getName(), getGlobalScopeProvider().getName());
		if (isIgnoreCase()) {
			factory = factory
				.addTypeToType(IResourceDescription.Manager.class.getName(), IgnoreCaseResourceDescriptionManager.class.getName());
		}
		return factory.getBindings();
	}
	
}
