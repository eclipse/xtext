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
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.DefaultGeneratorFragment;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.containers.IAllContainersState;
import org.eclipse.xtext.resource.containers.StateBasedContainerManager;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class BuilderIntegrationFragment extends DefaultGeneratorFragment {

	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		return new BindFactory()
		.addTypeToType(IContainer.Manager.class.getName(), StateBasedContainerManager.class.getName())
		.addTypeToType(IAllContainersState.Provider.class.getName(), 
				org.eclipse.xtext.resource.containers.ResourceSetBasedAllContainersStateProvider.class.getName())
		.addConfiguredBinding(
					IResourceDescriptions.class.getName(),
					"binder.bind(" + IResourceDescriptions.class.getName() + ".class"
							+ ").to("
							+ ResourceSetBasedResourceDescriptions.class.getName() + ".class)")
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
							+ "org.eclipse.xtext.builder.builderState.ShadowingResourceDescriptions.class)")
			.addConfiguredBinding(
					IResourceDescriptions.class.getName(),
					"binder.bind(" + IResourceDescriptions.class.getName() + ".class"
							+ ").toProvider("
							+ "org.eclipse.xtext.builder.GlobalResourceDescriptionsAccess.getDirtyResourceDescriptions()).asEagerSingleton()")
			.addTypeToType("org.eclipse.xtext.ui.editor.IXtextEditorCallback", "org.eclipse.xtext.builder.nature.NatureAddingEditorCallback")
			.addTypeToType(IAllContainersState.Provider.class.getName(), 
				"org.eclipse.xtext.ui.containers.JavaProjectsStateProvider")
			.getBindings();
	}

	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		return new String[] { 
			"org.eclipse.xtext.builder",
			"org.eclipse.xtext.ui"
		};
	}
}
