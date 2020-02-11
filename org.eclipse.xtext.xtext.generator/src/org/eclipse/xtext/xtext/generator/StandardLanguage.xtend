/*******************************************************************************
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import com.google.inject.Injector
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.util.internal.Log
import org.eclipse.xtext.xtext.generator.builder.BuilderIntegrationFragment2
import org.eclipse.xtext.xtext.generator.ecore.EMFGeneratorFragment2
import org.eclipse.xtext.xtext.generator.exporting.QualifiedNamesFragment2
import org.eclipse.xtext.xtext.generator.formatting.Formatter2Fragment2
import org.eclipse.xtext.xtext.generator.generator.GeneratorFragment2
import org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessFragment2
import org.eclipse.xtext.xtext.generator.index.ResourceDescriptionStrategyFragment
import org.eclipse.xtext.xtext.generator.junit.JUnitFragment
import org.eclipse.xtext.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment2
import org.eclipse.xtext.xtext.generator.resourceFactory.ResourceFactoryFragment2
import org.eclipse.xtext.xtext.generator.scoping.ImportNamespacesScopingFragment2
import org.eclipse.xtext.xtext.generator.serializer.SerializerFragment2
import org.eclipse.xtext.xtext.generator.types.TypesGeneratorFragment2
import org.eclipse.xtext.xtext.generator.ui.compare.CompareFragment2
import org.eclipse.xtext.xtext.generator.ui.contentAssist.ContentAssistFragment2
import org.eclipse.xtext.xtext.generator.ui.fileWizard.TemplateFileWizardFragment
import org.eclipse.xtext.xtext.generator.ui.labeling.LabelProviderFragment2
import org.eclipse.xtext.xtext.generator.ui.outline.OutlineTreeProviderFragment2
import org.eclipse.xtext.xtext.generator.ui.outline.QuickOutlineFragment2
import org.eclipse.xtext.xtext.generator.ui.projectWizard.TemplateProjectWizardFragment
import org.eclipse.xtext.xtext.generator.ui.quickfix.QuickfixProviderFragment2
import org.eclipse.xtext.xtext.generator.ui.refactoring.RefactorElementNameFragment2
import org.eclipse.xtext.xtext.generator.ui.templates.CodetemplatesGeneratorFragment2
import org.eclipse.xtext.xtext.generator.validation.ValidatorFragment2
import org.eclipse.xtext.xtext.generator.web.WebIntegrationFragment
import org.eclipse.xtext.xtext.generator.xbase.XbaseGeneratorFragment2
import org.eclipse.xtext.xtext.generator.xbase.XtypeGeneratorFragment2

/**
 * This specialization of the {@link XtextGeneratorLanguage} adds all the standard generator fragments
 * that are commonly used for Xtext languages. This eliminates the need to list all these fragments
 * explicitly in the workflow file. More fragments can be added as required, but the standard fragments
 * cannot be removed. However, most of these fragments disable themselves automatically if they are
 * not applicable, e.g. the {@link WebIntegrationFragment} does not generate anything if the web project
 * is disabled in the project configuration.
 * 
 * <p>The configuration for individual fragments can be made with the corresponding properties.
 * For example, write
 * <pre>
 * formatter = formatting.Formatter2Fragment2 {
 *     generateStub = true
 * }
 * </pre>
 * to enable stub generation for the formatter.</p>
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Holger Schill
 * @author Arne Deutsch - Add projectWizard and fileWizard, deprecate 'newProjectWizardForEclipse'
 * @noextend This class should not be extended by clients.
 */
@Accessors(PUBLIC_SETTER, PROTECTED_GETTER)
@Log class StandardLanguage extends XtextGeneratorLanguage {
	
	GrammarAccessFragment2 grammarAccess = new GrammarAccessFragment2
	
	EMFGeneratorFragment2 emfGenerator = new EMFGeneratorFragment2
	
	SerializerFragment2 serializer = new SerializerFragment2
	
	ResourceFactoryFragment2 resourceFactoryFragment = new ResourceFactoryFragment2
	
	XtextAntlrGeneratorFragment2 parserGenerator = new XtextAntlrGeneratorFragment2
	
	ValidatorFragment2 validator = new ValidatorFragment2
	
	ImportNamespacesScopingFragment2 scopeProvider = new ImportNamespacesScopingFragment2
	
	/**
	 * @since 2.14
	 */
	ResourceDescriptionStrategyFragment resourceDescriptionStrategy = new ResourceDescriptionStrategyFragment
	
	QualifiedNamesFragment2 qualifiedNamesProvider = new QualifiedNamesFragment2
	
	BuilderIntegrationFragment2 builder = new BuilderIntegrationFragment2
	
	GeneratorFragment2 generator = new GeneratorFragment2
	
	Formatter2Fragment2 formatter = new Formatter2Fragment2
	
	LabelProviderFragment2 labelProvider = new LabelProviderFragment2
	
	QuickOutlineFragment2 quickOutline = new QuickOutlineFragment2
	
	OutlineTreeProviderFragment2 outline = new OutlineTreeProviderFragment2
	
	QuickfixProviderFragment2 quickFixProvider = new QuickfixProviderFragment2
	
	ContentAssistFragment2 contentAssist = new ContentAssistFragment2
	
	JUnitFragment junitSupport = new JUnitFragment
	
	RefactorElementNameFragment2 renameRefactoring = new RefactorElementNameFragment2
	
	TypesGeneratorFragment2 commonTypesSupport = new TypesGeneratorFragment2
	
	XbaseGeneratorFragment2 xbaseSupport = new XbaseGeneratorFragment2
	
	XtypeGeneratorFragment2 xtypeSupport = new XtypeGeneratorFragment2
	
	CodetemplatesGeneratorFragment2 codeTemplates = new CodetemplatesGeneratorFragment2
	
	CompareFragment2 compareEditor = new CompareFragment2
	
	@Deprecated 
	org.eclipse.xtext.xtext.generator.idea.parser.antlr.XtextAntlrIDEAGeneratorFragment ideaParser
	
	@Deprecated
	org.eclipse.xtext.xtext.generator.idea.IdeaPluginGenerator ideaPlugin
	
	WebIntegrationFragment webSupport = new WebIntegrationFragment
	
	@Deprecated org.eclipse.xtext.xtext.generator.ui.projectWizard.SimpleProjectWizardFragment2 newProjectWizardForEclipse = new org.eclipse.xtext.xtext.generator.ui.projectWizard.SimpleProjectWizardFragment2
	
	TemplateProjectWizardFragment projectWizard = new TemplateProjectWizardFragment
	
	TemplateFileWizardFragment fileWizard = new TemplateFileWizardFragment
	
	new() {
		try {
			class.classLoader.loadClass("org.eclipse.xtext.xbase.XbaseRuntimeModule")
			addReferencedResource("platform:/resource/org.eclipse.xtext.xbase/model/Xbase.genmodel")
		} catch (ClassNotFoundException e) {
			LOG.info("Skipping registration of Xbase genmodel. Xbase is not on the classpath.")
		}
	}
	
	override initialize(Injector injector) {
		if (!formatter.getGenerateStub.isSet)
			formatter.generateStub = false
		if (!commonTypesSupport.onlyEnabledIfGrammarIsUsed.isSet)
			commonTypesSupport.onlyEnabledIfGrammarIsUsed = true
		if (!webSupport.framework.isSet)
			webSupport.framework = 'Ace'
		if (!webSupport.generateServlet.isSet)
			webSupport.generateServlet = true
		if (!webSupport.generateJettyLauncher.isSet)
			webSupport.generateJettyLauncher = true
		if (!webSupport.generateHtmlExample.isSet)
			webSupport.generateHtmlExample = true
		super.initialize(injector)
	}
	
	override protected getImplicitFragments() {
		val fragments = newArrayList 
		fragments += super.getImplicitFragments
		fragments += grammarAccess
		fragments += emfGenerator
		fragments += serializer
		fragments += resourceFactoryFragment
		fragments += parserGenerator
		fragments += validator
		fragments += scopeProvider
		fragments += resourceDescriptionStrategy
		fragments += qualifiedNamesProvider
		fragments += builder
		fragments += generator
		fragments += formatter
		fragments += labelProvider
		fragments += quickOutline
		fragments += outline
		fragments += quickFixProvider
		fragments += contentAssist
		fragments += junitSupport
		fragments += renameRefactoring
		fragments += commonTypesSupport
		fragments += xbaseSupport
		fragments += xtypeSupport
		fragments += codeTemplates
		fragments += compareEditor
		if(ideaParser !== null) {
			fragments += ideaParser	
		}
		if(ideaPlugin !== null) {
			fragments += ideaPlugin
		}
		fragments += webSupport
		fragments += newProjectWizardForEclipse
		fragments += projectWizard
		fragments += fileWizard
		fragments
	}
	
	private def +=(List<IXtextGeneratorFragment> list, IXtextGeneratorFragment fragment) {
		if (fragment !== null) {
			list.add(fragment)
		}
	}
	
	/**
	 * @deprecated Use 'projectWizard' instead
	 */
	@Deprecated
	def setNewProjectWizardForEclipse(org.eclipse.xtext.xtext.generator.ui.projectWizard.SimpleProjectWizardFragment2 fragment) {
		this.newProjectWizardForEclipse = fragment
	}
	
	/**
	 * Create a wizard able to create new projects with initial content based on template definitions.
	 * Supported options: 'generate', 'generateToolbarButton', 'pluginProject'.
	 */
	def setProjectWizard(TemplateProjectWizardFragment fragment) {
		this.projectWizard = fragment
	}
	
	/**
	 * Create a wizard able to create new files with initial content based on template definitions.
	 * Supported options: 'generate', 'generateToolbarButton'.
	 */
	def setFileWizard(TemplateFileWizardFragment fragment) {
		this.fileWizard = fragment
	}
}
