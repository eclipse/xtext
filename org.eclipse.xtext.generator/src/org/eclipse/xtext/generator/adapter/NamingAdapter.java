/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.adapter;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

@Deprecated(forRemoval = true)
class NamingAdapter extends XtextGeneratorNaming {
	private Naming naming;

	@Override
	public String getRuntimeBasePackage(Grammar grammar) {
		return naming.basePackageRuntime(grammar);
	}

	@Override
	public TypeReference getRuntimeModule(Grammar grammar) {
		return new TypeReference(naming.guiceModuleRt(grammar));
	}

	@Override
	public TypeReference getRuntimeGenModule(Grammar grammar) {
		return new TypeReference(naming.guiceModuleRtGenerated(grammar));
	}

	@Override
	public TypeReference getRuntimeSetup(Grammar grammar) {
		return new TypeReference(naming.setup(grammar));
	}

	@Override
	public TypeReference getRuntimeGenSetup(Grammar grammar) {
		return new TypeReference(naming.setupImpl(grammar));
	}

	@Override
	public String getEclipsePluginBasePackage(Grammar grammar) {
		return naming.basePackageUi(grammar);
	}

	@Override
	public TypeReference getEclipsePluginModule(Grammar grammar) {
		return new TypeReference(naming.guiceModuleUi(grammar));
	}

	@Override
	public TypeReference getEclipsePluginGenModule(Grammar grammar) {
		return new TypeReference(naming.guiceModuleUiGenerated(grammar));
	}

	@Override
	public TypeReference getEclipsePluginExecutableExtensionFactory(Grammar grammar) {
		return new TypeReference(naming.executableExtensionFactory(grammar));
	}

	@Override
	public String getGenericIdeBasePackage(Grammar grammar) {
		return naming.basePackageIde(grammar);
	}

	public NamingAdapter(Naming naming) {
		this.naming = naming;
	}
}
