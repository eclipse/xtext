/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.types;

import java.util.Set;

import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.DefaultGeneratorFragment;
import org.eclipse.xtext.generator.IGeneratorFragmentExtension4;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated(forRemoval = true)
public class TypesGeneratorFragment extends DefaultGeneratorFragment implements IGeneratorFragmentExtension4 {
	
	static {
		new StandaloneSetup().addRegisterGeneratedEPackage("org.eclipse.xtext.common.types.TypesPackage");
	}

	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		return new BindFactory()
			.addTypeToType(IGlobalScopeProvider.class.getName(), "org.eclipse.xtext.common.types.xtext.TypesAwareDefaultGlobalScopeProvider")
			.getBindings();
	}
	
	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		return new BindFactory()
			 // overrides binding from org.eclipse.xtext.generator.exporting.QualifiedNamesFragment
			 .addTypeToType("org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher",
					 	"org.eclipse.xtext.ui.editor.contentassist.FQNPrefixMatcher")
			 .getBindings();
	}

	@Override
	public String[] getRequiredBundlesRt(Grammar grammar) {
		return new String[] { "org.eclipse.xtext.common.types","org.objectweb.asm;bundle-version=\"[9.5.0,9.6.0)\";resolution:=optional" };
	}
	
	@Override
	public String[] getRequiredBundlesTests(Grammar grammar) {
		return new String[] { "org.objectweb.asm;bundle-version=\"[9.5.0,9.6.0)\";resolution:=optional" };
	}

	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		return new String[] { "org.eclipse.xtext.common.types.ui" };
	}

	/**
	 * @since 2.8
	 */
	@Override
	public String getDefaultRuntimeModuleClassName(Grammar grammar) {
		return "org.eclipse.xtext.common.types.DefaultCommonTypesRuntimeModule";
	}

	/**
	 * @since 2.8
	 */
	@Override
	public String getDefaultUiModuleClassName(Grammar grammar) {
		return "org.eclipse.xtext.common.types.ui.DefaultCommonTypesUiModule";
	}

}
