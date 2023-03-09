/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.generator.templates;

import java.util.List;
import java.util.Set;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.Naming;

import com.google.common.collect.ImmutableList;

/**
 * This generator fragment enables an advanced preference page for code templates.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.0
 */
@Deprecated(forRemoval = true)
public class CodetemplatesGeneratorFragment extends AbstractGeneratorFragment {
	
	private boolean suppressRestriction = false;

	/**
	 * Set this flag to <code>false</code> if you don't want to add the 
	 * {@code @SuppressWarnings("restriction")} to the generated PartialContentAssistParser.  
	 * @since 2.7
	 */
	public void setSuppressRestriction(boolean suppressRestriction) {
		this.suppressRestriction = suppressRestriction;
	}
	
	/**
	 * @since 2.7
	 */
	public boolean isSuppressRestriction() {
		return suppressRestriction;
	}
	
	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		if(getNaming().hasIde()){
			return new BindFactory()
				.addTypeToProviderInstance("org.eclipse.xtext.ui.codetemplates.ui.preferences.TemplatesLanguageConfiguration", 
					"org.eclipse.xtext.ui.codetemplates.ui.AccessibleCodetemplatesActivator.getTemplatesLanguageConfigurationProvider()")
				.addTypeToProviderInstance("org.eclipse.xtext.ui.codetemplates.ui.registry.LanguageRegistry", 
					"org.eclipse.xtext.ui.codetemplates.ui.AccessibleCodetemplatesActivator.getLanguageRegistry()")
				.addTypeToTypeEagerSingleton("org.eclipse.xtext.ui.codetemplates.ui.registry.LanguageRegistrar",
					"org.eclipse.xtext.ui.codetemplates.ui.registry.LanguageRegistrar")
				.addTypeToType("org.eclipse.xtext.ui.editor.templates.XtextTemplatePreferencePage", 
					"org.eclipse.xtext.ui.codetemplates.ui.preferences.AdvancedTemplatesPreferencePage")
				.addTypeToType("org.eclipse.xtext.ide.editor.partialEditing.IPartialEditingContentAssistParser",
					getPartialContentAssistParser(grammar, getNaming()))
				.addTypeToType("org.eclipse.xtext.ui.codetemplates.ui.partialEditing.IPartialEditingContentAssistContextFactory", 
						"org.eclipse.xtext.ui.codetemplates.ui.partialEditing.PartialEditingContentAssistContextFactory")
				.getBindings();
		} else {
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
	}
	
	@Override
	protected List<Object> getParameters(Grammar grammar) {
		return ImmutableList.<Object>of(isSuppressRestriction(), getNaming().hasIde());
	}
	
	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		return new String[] { "org.eclipse.xtext.ui.codetemplates.ui" };
	}
	
	public static String getPartialContentAssistParser(Grammar grammar, Naming naming) {
		return naming.basePackageIde(grammar) + ".contentassist.antlr.Partial" + GrammarUtil.getSimpleName(grammar) + "ContentAssistParser";
	}
	
	public static String getContentAssistParser(Grammar grammar, Naming naming) {
		return naming.basePackageIde(grammar) + ".contentassist.antlr." + GrammarUtil.getSimpleName(grammar) + "Parser";
	}
	
}
