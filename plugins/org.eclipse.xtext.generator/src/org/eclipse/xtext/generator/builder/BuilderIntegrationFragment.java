/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.builder;

import java.util.Set;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.builder.builderState.ShadowingResourceDescriptions;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;
import org.eclipse.xtext.resource.impl.SimpleResourceDescriptionsBasedContainerManager;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.namespaces.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.scoping.namespaces.DefaultGlobalScopeProvider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class BuilderIntegrationFragment extends AbstractGeneratorFragment {

	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		return new BindFactory()
			.addTypeToType(IQualifiedNameProvider.class.getName(), DefaultDeclarativeQualifiedNameProvider.class.getName())
			.addTypeToType(IGlobalScopeProvider.class.getName(), DefaultGlobalScopeProvider.class.getName())
			.addTypeToType(IContainer.Manager.class.getName(), SimpleResourceDescriptionsBasedContainerManager.class.getName())
			.addTypeToType(IResourceDescriptions.class.getName(), ResourceSetBasedResourceDescriptions.class.getName())
			.addConfiguredBinding(
					IResourceDescriptions.class.getName() + "BuilderScope",
					"binder.bind(" + IResourceDescriptions.class.getName() + ".class"
							+ ").annotatedWith(com.google.inject.name.Names.named("
							+ DefaultGlobalScopeProvider.class.getName() + ".NAMED_BUILDER_SCOPE)).to("
							+ ResourceSetBasedResourceDescriptions.class.getName() + ".class)")
			.getBindings();
	}

	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		return new BindFactory()
			.addConfiguredBinding(
					IResourceDescriptions.class.getName() + "BuilderScope",
					"binder.bind(" + IResourceDescriptions.class.getName() + ".class"
							+ ").annotatedWith(com.google.inject.name.Names.named("
							+ DefaultGlobalScopeProvider.class.getName() + ".NAMED_BUILDER_SCOPE)).to("
							+ ShadowingResourceDescriptions.class.getName() + ".class)")
			.addTypeToType(IContainer.Manager.class.getName(), "org.eclipse.xtext.ui.core.scoping.namespaces.ProjectAwareContainerManager")
			.getBindings();
	}

	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		return new String[] { 
			"org.eclipse.xtext.builder",
			"org.eclipse.xtext.ui.core"
		};
	}
}
