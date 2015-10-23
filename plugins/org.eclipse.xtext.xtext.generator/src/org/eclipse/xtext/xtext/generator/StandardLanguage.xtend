/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.util.internal.Log
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

/**
 * @author Sven Efftinge - Initial contribution and API
 * @noextend
 */
@Accessors(PUBLIC_SETTER)
@Log class StandardLanguage extends XtextGeneratorLanguage {
	
	GrammarAccessFragment2 grammarAccess = new GrammarAccessFragment2
	 
	SerializerFragment2 serializer = new SerializerFragment2
	
	ResourceFactoryFragment2 resourceFactoryFragment = new ResourceFactoryFragment2

	EMFGeneratorFragment2 emfGenerator = new EMFGeneratorFragment2
	
	XtextAntlrGeneratorFragment2 parserGenerator = new XtextAntlrGeneratorFragment2
	
	ValidatorFragment2 validator = new ValidatorFragment2
	
	Formatter2Fragment2 formatter = new Formatter2Fragment2  => [
		generateStub = false
	]
	
	GeneratorFragment2 generator = new GeneratorFragment2 
	
	BuilderIntegrationFragment2 builder = new BuilderIntegrationFragment2 
	
	ImportNamespacesScopingFragment2 scopeProvider = new ImportNamespacesScopingFragment2
	
	QualifiedNamesFragment2 qualifiedNamesProvider = new QualifiedNamesFragment2
	
	
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
	
	TypesGeneratorFragment2 commonTypesSupport = new TypesGeneratorFragment2 => [
		onlyEnabledIfGrammarIsUsed = true
	]
	
	XtypeGeneratorFragment2 xtypeSupport = new XtypeGeneratorFragment2
	
	XbaseGeneratorFragment2 xbaseSupport = new XbaseGeneratorFragment2
	
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
	
	override protected getImplicitFragments() {
		val fragments = newArrayList 
		fragments += super.getImplicitFragments
		fragments.add(grammarAccess)
		fragments.add(emfGenerator)
		fragments.add(serializer)
		fragments.add(resourceFactoryFragment)
		fragments.add(parserGenerator)
		fragments.add(validator)
		fragments.add(scopeProvider)
		fragments.add(qualifiedNamesProvider)
		fragments.add(builder)
		fragments.add(generator)
		fragments.add(formatter)
		fragments.add(labelProvider)
		fragments.add(quickOutline)
		fragments.add(outline)
		fragments.add(quickFixProvider)
		fragments.add(contentAssist)
		fragments.add(junitSupport)
		fragments.add(renameRefactoring)
		fragments.add(commonTypesSupport)
		fragments.add(xbaseSupport)
		fragments.add(xtypeSupport)
		fragments.add(codeTemplates)
		fragments.add(compareEditor)
		fragments.add(ideaParser)
		fragments.add(ideaPlugin)
		fragments.add(webSupport)
		fragments
	}
}