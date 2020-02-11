/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.adapter

import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.generator.Naming
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming
import org.eclipse.xtext.xtext.generator.model.TypeReference

@FinalFieldsConstructor
@Deprecated
package class NamingAdapter extends XtextGeneratorNaming {
	
	val Naming naming
	
	override getRuntimeBasePackage(Grammar grammar) {
		naming.basePackageRuntime(grammar)
	}
	
	override getRuntimeModule(Grammar grammar) {
		new TypeReference(naming.guiceModuleRt(grammar))
	}
	
	override getRuntimeGenModule(Grammar grammar) {
		new TypeReference(naming.guiceModuleRtGenerated(grammar))
	}
	
	override getRuntimeSetup(Grammar grammar) {
		new TypeReference(naming.setup(grammar))
	}
	
	override getRuntimeGenSetup(Grammar grammar) {
		new TypeReference(naming.setupImpl(grammar))
	}
	
	override getEclipsePluginBasePackage(Grammar grammar) {
		naming.basePackageUi(grammar)
	}
	
	override getEclipsePluginModule(Grammar grammar) {
		new TypeReference(naming.guiceModuleUi(grammar))
	}
	
	override getEclipsePluginGenModule(Grammar grammar) {
		new TypeReference(naming.guiceModuleUiGenerated(grammar))
	}
	
	override getEclipsePluginExecutableExtensionFactory(Grammar grammar) {
		new TypeReference(naming.executableExtensionFactory(grammar))
	}
	
	override getGenericIdeBasePackage(Grammar grammar) {
		naming.basePackageIde(grammar)
	}
	
}