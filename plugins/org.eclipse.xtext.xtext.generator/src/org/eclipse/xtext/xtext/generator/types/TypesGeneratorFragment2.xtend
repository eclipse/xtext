/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.types

import org.eclipse.xtext.scoping.IGlobalScopeProvider
import org.eclipse.xtext.xtext.generator.AbstractGeneratorFragment2
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess

import static extension org.eclipse.xtext.xtext.generator.model.TypeReference.*

class TypesGeneratorFragment2 extends AbstractGeneratorFragment2 {
	
	override generate() {
		new GuiceModuleAccess.BindingFactory()
			.addTypeToType(IGlobalScopeProvider.typeRef,
					'org.eclipse.xtext.common.types.xtext.TypesAwareDefaultGlobalScopeProvider'.typeRef)
			.contributeTo(language.runtimeGenModule)
		language.runtimeGenModule.superClass = 'org.eclipse.xtext.common.types.DefaultCommonTypesRuntimeModule'.typeRef
		
		new GuiceModuleAccess.BindingFactory()
			// overrides binding from org.eclipse.xtext.xtext.generator.exporting.QualifiedNamesFragment2
			.addTypeToType("org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher".typeRef,
		 			'org.eclipse.xtext.ui.editor.contentassist.FQNPrefixMatcher'.typeRef)
			.contributeTo(language.eclipsePluginGenModule)
		language.eclipsePluginGenModule.superClass = 'org.eclipse.xtext.common.types.ui.DefaultCommonTypesUiModule'.typeRef
		
		if (projectConfig.runtimeManifest !== null) {
			projectConfig.runtimeManifest.requiredBundles.addAll(
				'org.eclipse.xtext.common.types',
				'org.objectweb.asm;bundle-version="[5.0.1,6.0.0)";resolution:=optional'
			)
		}
		
		if (projectConfig.runtimeTestManifest !== null) {
			projectConfig.runtimeTestManifest.requiredBundles.add(
				'org.objectweb.asm;bundle-version="[5.0.1,6.0.0)";resolution:=optional'
			)
		}
		
		if (projectConfig.eclipsePluginManifest !== null) {
			projectConfig.eclipsePluginManifest.requiredBundles.add(
				'org.eclipse.xtext.common.types.ui'
			)
		}
	}
	
}