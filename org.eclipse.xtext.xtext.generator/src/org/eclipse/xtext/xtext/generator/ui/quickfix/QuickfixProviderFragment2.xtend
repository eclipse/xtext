/*******************************************************************************
 * Copyright (c) 2015, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.ui.quickfix

import org.eclipse.xtext.Grammar
import org.eclipse.xtext.xtext.generator.AbstractInheritingFragment
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess
import org.eclipse.xtext.xtext.generator.model.TypeReference
import org.eclipse.xtext.xtext.generator.validation.ValidatorNaming

import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.xtext.generator.util.GrammarUtil2.*
import com.google.inject.Inject

/**
 * Contributes the Quickfix provider stub, either in Xtend or Java language.
 * 
 * @author Christian Schneider - Initial contribution and API
 */
class QuickfixProviderFragment2 extends AbstractInheritingFragment {

	@Inject
	extension XtextGeneratorNaming
	
	@Inject
	extension ValidatorNaming

	@Inject
	FileAccessFactory fileAccessFactory

	def protected TypeReference getQuickfixProviderClass(Grammar g) {
		return new TypeReference(
			g.eclipsePluginBasePackage + ".quickfix." + g.simpleName + "QuickfixProvider"
		)
	}

	def protected TypeReference getQuickfixProviderSuperClass(Grammar g) {
		val superGrammar = g.getNonTerminalsSuperGrammar;
		if (inheritImplementation && superGrammar !== null) 
			superGrammar.quickfixProviderClass
		else
			defaultQuickfixProviderSuperClass
	}

	/**
	 * Extra getter facilitates customization by overriding. 
	 */
	protected def getDefaultQuickfixProviderSuperClass() {
		return new TypeReference("org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider")
	} 

	override generate() {
		new GuiceModuleAccess.BindingFactory()
				.addTypeToType(
					new TypeReference("org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider"),
					grammar.quickfixProviderClass
				).contributeTo(language.eclipsePluginGenModule);

		if (isGenerateStub) {
			if (projectConfig.eclipsePlugin?.src !== null) {
				if (generateXtendStub) {
					generateXtendQuickfixProvider
				} else {
					generateJavaQuickfixProvider
				}
			}

			if (projectConfig.eclipsePlugin.manifest !== null) {
				projectConfig.eclipsePlugin.manifest.exportedPackages += grammar.quickfixProviderClass.packageName
			}

			if (projectConfig.eclipsePlugin.pluginXml !== null) {
				addRegistrationToPluginXml
			}

		} else {
			if (projectConfig.eclipsePlugin?.srcGen !== null) {
				generateGenQuickfixProvider
			}

			if (projectConfig.eclipsePlugin.manifest !== null) {
				projectConfig.eclipsePlugin.manifest.exportedPackages += grammar.quickfixProviderClass.packageName
			}
		}
	}
	
	def generateGenQuickfixProvider() {
		// take the ordinary concrete class signature for the src-gen class, too
		//  as quickfixProviders of sub languages refer to 'superGrammar.quickfixProviderClass',
		//  see 'getGenQuickfixProviderSuperClass(...)'
		val genClass = grammar.quickfixProviderClass
		
		val file = fileAccessFactory.createGeneratedJavaFile(genClass)
		
		file.content = '''
			public class «genClass.simpleName» extends «grammar.quickfixProviderSuperClass» {
			}
		'''
		file.writeTo(projectConfig.eclipsePlugin.srcGen)
	}

	protected def generateXtendQuickfixProvider() {
		fileAccessFactory.createXtendFile(grammar.quickfixProviderClass, '''
			/**
			 * Custom quickfixes.
			 *
			 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#quick-fixes
			 */
			class «grammar.quickfixProviderClass.simpleName» extends «grammar.quickfixProviderSuperClass» {
			
			//	@Fix(«grammar.validatorClass.simpleName».INVALID_NAME)
			//	def capitalizeName(Issue issue, IssueResolutionAcceptor acceptor) {
			//		acceptor.accept(issue, 'Capitalize name', 'Capitalize the name.', 'upcase.png') [
			//			context |
			//			val xtextDocument = context.xtextDocument
			//			val firstLetter = xtextDocument.get(issue.offset, 1)
			//			xtextDocument.replace(issue.offset, 1, firstLetter.toUpperCase)
			//		]
			//	}
			}
		''').writeTo(projectConfig.eclipsePlugin.src)
	}
	
	protected def generateJavaQuickfixProvider() {
		fileAccessFactory.createJavaFile(grammar.quickfixProviderClass, '''
			/**
			 * Custom quickfixes.
			 *
			 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#quick-fixes
			 */
			public class «grammar.quickfixProviderClass.simpleName» extends «grammar.quickfixProviderSuperClass» {
			
			//	@Fix(«grammar.validatorClass.simpleName».INVALID_NAME)
			//	public void capitalizeName(final Issue issue, IssueResolutionAcceptor acceptor) {
			//		acceptor.accept(issue, "Capitalize name", "Capitalize the name.", "upcase.png", new IModification() {
			//			public void apply(IModificationContext context) throws BadLocationException {
			//				IXtextDocument xtextDocument = context.getXtextDocument();
			//				String firstLetter = xtextDocument.get(issue.getOffset(), 1);
			//				xtextDocument.replace(issue.getOffset(), 1, firstLetter.toUpperCase());
			//			}
			//		});
			//	}
			
			}
		''').writeTo(projectConfig.eclipsePlugin.src)
	}
	
	protected def addRegistrationToPluginXml() {
		val markerTypePrefix = projectConfig.eclipsePlugin.name + "." + grammar.simpleName.toLowerCase
		val executableExtensionFactory = grammar.eclipsePluginExecutableExtensionFactory

		projectConfig.eclipsePlugin.pluginXml.entries += '''
			<!-- quickfix marker resolution generator for «grammar.name» -->
			<extension
					point="org.eclipse.ui.ide.markerResolution">
				<markerResolutionGenerator
					class="«executableExtensionFactory»:org.eclipse.xtext.ui.editor.quickfix.MarkerResolutionGenerator"
					markerType="«markerTypePrefix».check.fast">
					<attribute
						name="FIXABLE_KEY"
						value="true">
					</attribute>
				</markerResolutionGenerator>
				<markerResolutionGenerator
					class="«executableExtensionFactory»:org.eclipse.xtext.ui.editor.quickfix.MarkerResolutionGenerator"
					markerType="«markerTypePrefix».check.normal">
					<attribute
						name="FIXABLE_KEY"
						value="true">
					</attribute>
				</markerResolutionGenerator>
				<markerResolutionGenerator
					class="«executableExtensionFactory»:org.eclipse.xtext.ui.editor.quickfix.MarkerResolutionGenerator"
					markerType="«markerTypePrefix».check.expensive">
					<attribute
						name="FIXABLE_KEY"
						value="true">
					</attribute>
				</markerResolutionGenerator>
			</extension>
		'''		
	}
}
