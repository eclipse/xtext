/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.generator.templates;

import java.util.Set;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.Naming;

/**
 * This generator fragment enables an advanced preference page for code templates.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.0
 */
public class CodetemplatesGeneratorFragment extends AbstractGeneratorFragment {
	
	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		return new BindFactory()
			.addTypeToProviderInstance("org.eclipse.xtext.ui.codetemplates.ui.preferences.TemplatesLanguageConfiguration", 
				"org.eclipse.xtext.ui.codetemplates.ui.AccessibleCodetemplatesActivator.getTemplatesLanguageConfigurationProvider()")
			.addTypeToProviderInstance("org.eclipse.xtext.ui.codetemplates.ui.registry.LanguageRegistry", 
				"org.eclipse.xtext.ui.codetemplates.ui.AccessibleCodetemplatesActivator.getLanguageRegistry()")
			.addTypeToTypeEagerSingleton("org.eclipse.xtext.ui.codetemplates.ui.registry.LanguageRegistrar",
				"org.eclipse.xtext.ui.codetemplates.ui.registry.LanguageRegistrar")
			.addTypeToType("org.eclipse.xtext.ui.editor.templates.XtextTemplatePreferencePage", 
				"org.eclipse.xtext.ui.codetemplates.ui.preferences.AdvancedTemplatesPreferencePage")
			.addTypeToType("org.eclipse.xtext.ui.codetemplates.ui.partialEditing.IPartialContentAssistParser",
				getPartialContentAssistParser(grammar, getNaming()))
			.getBindings();
	}
	
	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		return new String[] { "org.eclipse.xtext.ui.codetemplates.ui" };
	}
	
	public static String getPartialContentAssistParser(Grammar grammar, Naming naming) {
		return naming.basePackageUi(grammar) + ".contentassist.antlr.Partial" + GrammarUtil.getName(grammar) + "ContentAssistParser";
	}
	
	public static String getContentAssistParser(Grammar grammar, Naming naming) {
		return naming.basePackageUi(grammar) + ".contentassist.antlr." + GrammarUtil.getName(grammar) + "Parser";
	}
	
}
