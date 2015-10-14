/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import com.google.inject.Injector
import java.util.ArrayList
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.xtext.generator.builder.BuilderIntegrationFragment2
import org.eclipse.xtext.xtext.generator.ecore.EMFGeneratorFragment2
import org.eclipse.xtext.xtext.generator.exporting.QualifiedNamesFragment2
import org.eclipse.xtext.xtext.generator.formatting.Formatter2Fragment2
import org.eclipse.xtext.xtext.generator.generator.GeneratorFragment2
import org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessFragment2
import org.eclipse.xtext.xtext.generator.idea.IdeaPluginGenerator
import org.eclipse.xtext.xtext.generator.idea.parser.antlr.XtextAntlrIDEAGeneratorFragment
import org.eclipse.xtext.xtext.generator.junit.Junit4Fragment2
import org.eclipse.xtext.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment2
import org.eclipse.xtext.xtext.generator.resourceFactory.ResourceFactoryFragment2
import org.eclipse.xtext.xtext.generator.scoping.ImportNamespacesScopingFragment2
import org.eclipse.xtext.xtext.generator.serializer.SerializerFragment2
import org.eclipse.xtext.xtext.generator.types.TypesGeneratorFragment2
import org.eclipse.xtext.xtext.generator.ui.compare.CompareFragment2
import org.eclipse.xtext.xtext.generator.ui.contentAssist.ContentAssistFragment2
import org.eclipse.xtext.xtext.generator.ui.labeling.LabelProviderFragment2
import org.eclipse.xtext.xtext.generator.ui.outline.OutlineTreeProviderFragment2
import org.eclipse.xtext.xtext.generator.ui.outline.QuickOutlineFragment2
import org.eclipse.xtext.xtext.generator.ui.quickfix.QuickfixProviderFragment2
import org.eclipse.xtext.xtext.generator.ui.refactoring.RefactorElementNameFragment2
import org.eclipse.xtext.xtext.generator.ui.templates.CodetemplatesGeneratorFragment2
import org.eclipse.xtext.xtext.generator.validation.ValidatorFragment2
import org.eclipse.xtext.xtext.generator.web.WebIntegrationFragment
import org.eclipse.xtext.xtext.generator.xbase.XbaseGeneratorFragment2
import org.eclipse.xtext.xtext.generator.xbase.XtypeGeneratorFragment2
import org.eclipse.xtext.util.internal.Log

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Accessors(PUBLIC_SETTER)
@Log class StandardLanguage extends LanguageConfig2 {
	
	GrammarAccessFragment2 grammarAccess = new GrammarAccessFragment2
	 
	SerializerFragment2 serializer = new SerializerFragment2
	
	ResourceFactoryFragment2 resourceFactoryFragment = new ResourceFactoryFragment2

	EMFGeneratorFragment2 emfGenerator = new EMFGeneratorFragment2
	
	XtextAntlrGeneratorFragment2 parserGenerator = new XtextAntlrGeneratorFragment2
	
	ValidatorFragment2 validator = new ValidatorFragment2 => [
		addComposedCheck("org.eclipse.xtext.validation.NamesAreUniqueValidator")
	]
	
	Formatter2Fragment2 formatter = new Formatter2Fragment2 
	
	GeneratorFragment2 generator = new GeneratorFragment2 
	
	BuilderIntegrationFragment2 builder = new BuilderIntegrationFragment2 
	
	ImportNamespacesScopingFragment2 scopeProvider = new ImportNamespacesScopingFragment2
	
	QualifiedNamesFragment2 qualifiedNamesProvider = new QualifiedNamesFragment2
	
	TypesGeneratorFragment2 commonTypesSupport = new TypesGeneratorFragment2 => [
		onlyEnabledIfGrammarIsUsed = true
	]
	
	XtypeGeneratorFragment2 xtypeSupport = new XtypeGeneratorFragment2
	
	XbaseGeneratorFragment2 xbaseSupport = new XbaseGeneratorFragment2
	
	Junit4Fragment2 junitSupport = new Junit4Fragment2
	
	QuickfixProviderFragment2 quickFixProvider =  new QuickfixProviderFragment2 
	
	LabelProviderFragment2 labelProvider = new LabelProviderFragment2 
	
	OutlineTreeProviderFragment2 outline = new OutlineTreeProviderFragment2 
	
	QuickOutlineFragment2 quickOutline = new QuickOutlineFragment2 
	
	CompareFragment2 compareEditor = new CompareFragment2 
	
	ContentAssistFragment2 contentAssist = new ContentAssistFragment2 
	
	RefactorElementNameFragment2 renameRefactoring = new RefactorElementNameFragment2
	
	CodetemplatesGeneratorFragment2 codeTemplates = new CodetemplatesGeneratorFragment2
	 
	XtextAntlrIDEAGeneratorFragment ideaParser = new XtextAntlrIDEAGeneratorFragment
	
	IdeaPluginGenerator ideaPlugin = new IdeaPluginGenerator
	
	WebIntegrationFragment webSupport = new WebIntegrationFragment => [
		framework = "Ace"
		generateServlet = true
		generateJettyLauncher = true
		generateHtmlExample = true
	]
	
	new() {
		try {
			class.classLoader.loadClass("org.eclipse.xtext.xbase.XbaseRuntimeModule")
			standaloneSetup = new XtextLanguageStandaloneSetup => [
				addLoadedResource("platform:/resource/org.eclipse.xtext.xbase/model/Xbase.genmodel")
			]
		} catch (ClassNotFoundException e) {
			LOG.info("Skipping registration of Xbase genmodel. Xbase is not on the classpath.")
		}
	}
	
	override initialize(Injector injector) {
		val configuredFragments = new ArrayList(fragments)
		fragments.clear
		addFragment(grammarAccess)
		addFragment(emfGenerator)
		addFragment(resourceFactoryFragment)
		addFragment(serializer)
		addFragment(parserGenerator)
		addFragment(validator)
		addFragment(formatter)
		addFragment(generator)
		addFragment(builder)
		addFragment(scopeProvider)
		addFragment(qualifiedNamesProvider)
		addFragment(commonTypesSupport)
		addFragment(xtypeSupport)
		addFragment(xbaseSupport)
		addFragment(junitSupport)
		addFragment(quickFixProvider)
		addFragment(labelProvider)
		addFragment(outline)
		addFragment(quickOutline)
		addFragment(compareEditor)
		addFragment(contentAssist)
		addFragment(renameRefactoring)
		addFragment(codeTemplates)
		addFragment(ideaParser)
		addFragment(ideaPlugin)
		addFragment(webSupport)
		fragments.addAll(configuredFragments)
		super.initialize(injector)
	}
	
}