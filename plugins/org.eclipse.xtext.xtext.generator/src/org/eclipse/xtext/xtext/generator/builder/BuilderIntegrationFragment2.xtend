/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.builder

import com.google.inject.name.Names
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtext.resource.IContainer
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.containers.IAllContainersState
import org.eclipse.xtext.resource.containers.ResourceSetBasedAllContainersStateProvider
import org.eclipse.xtext.resource.containers.StateBasedContainerManager
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions
import org.eclipse.xtext.xtext.generator.AbstractGeneratorFragment2
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess

import static extension org.eclipse.xtext.xtext.generator.model.TypeReference.*

class BuilderIntegrationFragment2 extends AbstractGeneratorFragment2 {
	
	override generate() {
		addRuntimeGuiceBindings
		addEclipsePluginGuiceBindings
		
		if (projectConfig.eclipsePluginManifest !== null) {
			projectConfig.eclipsePluginManifest.requiredBundles.addAll(#[
				'org.eclipse.xtext.builder', 'org.eclipse.xtext.ui'
			])
		}
	}
	
	protected def addRuntimeGuiceBindings() {
		val StringConcatenationClient statement1 =
			'''binder.bind(«IResourceDescriptions».class).to(«ResourceSetBasedResourceDescriptions».class);'''
		val StringConcatenationClient statement2 =
			'''binder.bind(«IResourceDescriptions».class).annotatedWith(«Names».named(«ResourceDescriptionsProvider».PERSISTED_DESCRIPTIONS)).to(«ResourceSetBasedResourceDescriptions».class);'''
		new GuiceModuleAccess.BindingFactory()
			.addTypeToType(IContainer.Manager.typeRef,
					StateBasedContainerManager.typeRef)
			.addTypeToType(IAllContainersState.Provider.typeRef,
					ResourceSetBasedAllContainersStateProvider.typeRef)
			.addConfiguredBinding(IResourceDescriptions.simpleName, statement1)
			.addConfiguredBinding(IResourceDescriptions.simpleName + 'Persisted', statement2)
			.contributeTo(language.runtimeGenModule)
	}

	protected def addEclipsePluginGuiceBindings() {
		val StringConcatenationClient statement1 =
			'''binder.bind(«IResourceDescriptions».class).annotatedWith(«Names».named(«ResourceDescriptionsProvider».NAMED_BUILDER_SCOPE)).to(«'org.eclipse.xtext.builder.clustering.CurrentDescriptions.ResourceSetAware'.typeRef».class);'''
		val StringConcatenationClient statement2 =
			'''binder.bind(«IResourceDescriptions».class).annotatedWith(«Names».named(«ResourceDescriptionsProvider».PERSISTED_DESCRIPTIONS)).to(«'org.eclipse.xtext.builder.builderState.IBuilderState'.typeRef».class);'''
		new GuiceModuleAccess.BindingFactory()
			.addConfiguredBinding(IResourceDescriptions.simpleName + 'BuilderScope', statement1)
			.addTypeToType('org.eclipse.xtext.ui.editor.IXtextEditorCallback'.typeRef,
					'org.eclipse.xtext.builder.nature.NatureAddingEditorCallback'.typeRef)
			.addTypeToType('org.eclipse.xtext.generator.IContextualOutputConfigurationProvider'.typeRef,
					'org.eclipse.xtext.builder.EclipseOutputConfigurationProvider'.typeRef)
			.addConfiguredBinding(IResourceDescriptions.simpleName + 'Persisted', statement2)
			.addTypeToType('org.eclipse.xtext.ui.editor.DocumentBasedDirtyResource'.typeRef,
					'org.eclipse.xtext.builder.impl.PersistentDataAwareDirtyResource'.typeRef)
			.contributeTo(language.eclipsePluginGenModule)
	}
	
}