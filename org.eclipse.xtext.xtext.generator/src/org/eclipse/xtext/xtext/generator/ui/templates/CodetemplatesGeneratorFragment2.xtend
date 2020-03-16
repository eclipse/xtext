/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.ui.templates

import com.google.inject.Inject
import java.util.Collection
import java.util.Collections
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.util.PolymorphicDispatcher
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess
import org.eclipse.xtext.xtext.generator.model.TypeReference

import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.xtext.generator.model.TypeReference.typeRef
import org.eclipse.xtext.xtext.generator.parser.antlr.ContentAssistGrammarNaming
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment

/**
 * Contributes the 'Partial...ContentAssisParser' and performs further
 *  Guice-based registrations. Does not contribute 'plugin.xml' entries.
 *  
 *
 * @author Christian Schneider - Initial contribution and API
 */
class CodetemplatesGeneratorFragment2 extends AbstractXtextGeneratorFragment {
	
	static class Disabled extends CodetemplatesGeneratorFragment2 {
		
		override void generate() {
			// no nothing
		}
		
	}

	@Inject
	ContentAssistGrammarNaming caNaming

	@Inject
	extension XtextGeneratorNaming

	@Inject
	FileAccessFactory fileAccessFactory

	def TypeReference getPartialContentAssistParserClass(Grammar g) {
		new TypeReference(g.genericIdeBasePackage + ".contentassist.antlr", "Partial" + g.simpleName + "ContentAssistParser")
	}

	override generate() {
		projectConfig.eclipsePlugin?.manifest?.requiredBundles?.addAll(#[
			"org.eclipse.xtext.ui", "org.eclipse.xtext.ui.codetemplates.ui"
		])

		new GuiceModuleAccess.BindingFactory()
				.addTypeToProviderInstance(
					"org.eclipse.xtext.ui.codetemplates.ui.preferences.TemplatesLanguageConfiguration".typeRef,
					'''«"org.eclipse.xtext.ui.codetemplates.ui.AccessibleCodetemplatesActivator".typeRef».getTemplatesLanguageConfigurationProvider()''')
				
				.addTypeToProviderInstance(
					"org.eclipse.xtext.ui.codetemplates.ui.registry.LanguageRegistry".typeRef,
					'''«"org.eclipse.xtext.ui.codetemplates.ui.AccessibleCodetemplatesActivator".typeRef».getLanguageRegistry()''')
				
				.addTypeToTypeEagerSingleton(
					"org.eclipse.xtext.ui.codetemplates.ui.registry.LanguageRegistrar".typeRef,
					"org.eclipse.xtext.ui.codetemplates.ui.registry.LanguageRegistrar".typeRef)
				
				.addTypeToType(
					"org.eclipse.xtext.ui.editor.templates.XtextTemplatePreferencePage".typeRef, 
					"org.eclipse.xtext.ui.codetemplates.ui.preferences.AdvancedTemplatesPreferencePage".typeRef)
				
				.addTypeToType(
					"org.eclipse.xtext.ide.editor.partialEditing.IPartialEditingContentAssistParser".typeRef,
					grammar.partialContentAssistParserClass)
				
				.addTypeToType(
					"org.eclipse.xtext.ui.codetemplates.ui.partialEditing.IPartialEditingContentAssistContextFactory".typeRef, 
					"org.eclipse.xtext.ui.codetemplates.ui.partialEditing.PartialEditingContentAssistContextFactory".typeRef)
				
				.contributeTo(language.eclipsePluginGenModule);
		
		if (projectConfig.genericIde?.srcGen !== null) {
			fileAccessFactory.createGeneratedJavaFile(grammar.partialContentAssistParserClass) => [
				content = genPartialContentAssistParser
				writeTo(projectConfig.genericIde.srcGen)
			]
		}
	}
	
	private def StringConcatenationClient getGenPartialContentAssistParser() '''
		public class «grammar.partialContentAssistParserClass.simpleName» extends «caNaming.getParserClass(grammar)» {
		
			private «AbstractRule» rule;
		
			@Override
			public void initializeFor(AbstractRule rule) {
				this.rule = rule;
			}
		
			@Override
			protected «Collection»<«followElementClass»> getFollowElements(«abstractInternalContentAssistParserClass» parser) {
				if (rule == null || rule.eIsProxy())
					return «Collections».emptyList();
				«String» methodName = "entryRule" + rule.getName();
				«PolymorphicDispatcher»<Collection<FollowElement>> dispatcher = 
					new PolymorphicDispatcher<Collection<FollowElement>>(methodName, 0, 0, Collections.singletonList(parser));
				dispatcher.invoke();
				return parser.getFollowElements();
			}
		
		}
	'''
	
	private def getFollowElementClass() {
		"org.eclipse.xtext.ide.editor.contentassist.antlr.FollowElement".typeRef
	}
	
	private def getAbstractInternalContentAssistParserClass() {
		"org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser".typeRef
	}
}
