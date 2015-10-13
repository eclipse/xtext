/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.ui.contentAssist

import com.google.common.collect.Sets
import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtext.AbstractElement
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.Alternatives
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.xtext.generator.AbstractGeneratorFragment2
import org.eclipse.xtext.xtext.generator.CodeConfig
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess
import org.eclipse.xtext.xtext.generator.model.TypeReference

import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.xtext.generator.util.GrammarUtil2.*

/**
 * Contributes the 'Abstract...ProposalProvider' and '...ProposalProvider' stub,
 *  the latter either in Xtend or Java language.
 * 
 * @author Christian Schneider - Initial contribution and API
 */
class ContentAssistFragment2 extends AbstractGeneratorFragment2 {

	@Inject
	extension XtextGeneratorNaming
	
	@Inject
	extension CodeConfig
	
	@Inject
	FileAccessFactory fileAccessFactory

	@Accessors
	boolean generateStub = true;

	@Accessors
	boolean inheritImplementation = true

	def protected TypeReference getProposalProviderClass(Grammar g) {
		return new TypeReference(
			g.eclipsePluginBasePackage + ".contentassist." + g.simpleName + "ProposalProvider"
		)
	}

	def protected TypeReference getGenProposalProviderClass(Grammar g) {
		return new TypeReference(
			g.eclipsePluginBasePackage + ".contentassist.Abstract" + g.simpleName + "ProposalProvider"
		)
	}

	def protected TypeReference getGenProposalProviderSuperClass(Grammar g) {
		val superGrammar = g.nonTerminalsSuperGrammar
		if(inheritImplementation && superGrammar != null)
			superGrammar.proposalProviderClass
		else getDefaultGenProposalProviderSuperClass
	}

	/**
	 * Extra getter facilitates customization by overriding. 
	 */
	def protected TypeReference getDefaultGenProposalProviderSuperClass() {
		new TypeReference("org.eclipse.xtext.ui.editor.contentassist.AbstractJavaBasedContentProposalProvider")
	}


	override generate() {
		val chosenClass = 
			if (generateStub) grammar.getProposalProviderClass else grammar.getGenProposalProviderClass;
		
		if (projectConfig.eclipsePlugin.manifest != null) {
			projectConfig.eclipsePlugin.manifest.requiredBundles += "org.eclipse.xtext.ui"
		}

		new GuiceModuleAccess.BindingFactory()
				.addTypeToType(
					new TypeReference("org.eclipse.xtext.ui.editor.contentassist.IContentProposalProvider"),
					chosenClass
				).contributeTo(language.eclipsePluginGenModule);

		if (projectConfig.eclipsePlugin.srcGen !== null) {
			// generate the 'Abstract...ProposalProvider'
			generateGenJavaProposalProvider
		}

		if (generateStub && projectConfig.eclipsePlugin.src != null) {
			if (preferXtendStubs) {
				generateXtendProposalProviderStub

				if (projectConfig.eclipsePlugin.manifest != null) {
					projectConfig.eclipsePlugin.manifest.requiredBundles += "org.eclipse.xtext.xbase.lib"
					projectConfig.eclipsePlugin.manifest.requiredBundles += "org.eclipse.xtend.lib;resolution:=optional"
				}
			} else {
				generateJavaProposalProviderStub
			}
		}

		if (projectConfig.eclipsePlugin.manifest != null) {
			projectConfig.eclipsePlugin.manifest.exportedPackages += grammar.proposalProviderClass.packageName
		}
	}

	// generation of the '...ProposalProvider' stub

	def generateXtendProposalProviderStub() {
		fileAccessFactory.createXtendFile(grammar.proposalProviderClass, '''
			/**
			 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#content-assist
			 * on how to customize the content assistant.
			 */
			class «grammar.proposalProviderClass.simpleName» extends «grammar.genProposalProviderClass» {
			}
		''').writeTo(projectConfig.eclipsePlugin.src)
	}

	def generateJavaProposalProviderStub() {
		fileAccessFactory.createJavaFile(grammar.proposalProviderClass, '''
			/**
			 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#content-assist
			 * on how to customize the content assistant.
			 */
			public class «grammar.proposalProviderClass.simpleName» extends «grammar.genProposalProviderClass» {
			}
		''').writeTo(projectConfig.eclipsePlugin.src)
	}


	// generation of the 'Abstract...ProposalProvider'
	
	def generateGenJavaProposalProvider() {
		// excluded features are those that stem from inherited grammars,
		//  they are handled by the super grammars' proposal provider
		val excludedFqnFeatureNames = grammar.getFQFeatureNamesToExclude
		val processedNames = newHashSet()

		// determine all assignments within the grammar that are not excluded and not handled yet
		val assignments = grammar.containedAssignments().fold(<Assignment>newArrayList()) [ candidates, assignment |
			val fqFeatureName = assignment.FQFeatureName
			if (!processedNames.contains(fqFeatureName) && !excludedFqnFeatureNames.contains(fqFeatureName)) {
				processedNames += fqFeatureName;
				candidates += assignment;
			}
			candidates
		]
		
		// determine the (remaining) rules that are not excluded and not handled yet
		val remainingRules = grammar.rules.fold(<AbstractRule>newArrayList()) [candidates, rule |
  			val fqnFeatureName = rule.FQFeatureName
			if (!processedNames.contains(fqnFeatureName) && !excludedFqnFeatureNames.contains(fqnFeatureName)) {
				processedNames += fqnFeatureName
				candidates += rule
			}
			candidates
		]
		
		fileAccessFactory.createGeneratedJavaFile(grammar.getGenProposalProviderClass) => [
			val superClass = grammar.getGenProposalProviderSuperClass

			typeComment = '''
				/**
				 * Represents a generated, default implementation of superclass {@link «superClass»}.
				 * Methods are dynamically dispatched on the first parameter, i.e., you can override them 
				 * with a more concrete subtype. 
				 */
			'''

			content = '''
				public class «grammar.getGenProposalProviderClass.simpleName» extends «superClass» {
				
					«FOR assignment : assignments»
						«assignment.handleAssignment»
				  	«ENDFOR»
					
					«FOR rule : remainingRules»
						public void complete«rule.FQFeatureName»(«EObject» model, «RuleCall» ruleCall, «
								contentAssistContextClass» context, «ICompletionProposalAcceptorClass» acceptor) {
							// subclasses may override
						}
			    	«ENDFOR»
				}
			'''
			writeTo(projectConfig.eclipsePlugin.srcGen)	
		]
	}

	private def StringConcatenationClient handleAssignment(Assignment assignment) {
		// determine all assignment within 'assignment's containing parser rule
		//  assigning the same feature, obtain their expected terminals, ...
		val terminals = assignment.containingParserRule.containedAssignments().filter[
			it.feature == assignment.feature
		].map[
			terminal
		].toList

		// ... and determine the types of those terminals 
		val terminalTypes = terminals.map[ eClass ].toSet;

		'''
			public void complete«assignment.FQFeatureName»(«EObject» model, «Assignment» assignment, «
					contentAssistContextClass» context, «ICompletionProposalAcceptorClass» acceptor) {
				«IF terminalTypes.size > 1»
					«terminals.handleAssignmentOptions»
				«ELSE»
					«assignment.terminal.assignmentTerminal("assignment.getTerminal()")»
				«ENDIF»
			}
		'''
	}
	
	private def StringConcatenationClient handleAssignmentOptions(Iterable<AbstractElement> terminals) {
		val processedTerminals = newHashSet();
		
		// for each type of terminal occurring in 'terminals' ...
		val candidates = terminals.fold(<AbstractElement>newArrayList()) [ candidates, terminal |
			if (!processedTerminals.contains(terminal.eClass)) {
				processedTerminals += terminal.eClass
				candidates += terminal
			}
			candidates
		]
		
		// ... generate an 'instanceof' clause
		'''
			«FOR terminal : candidates»
				if (assignment.getTerminal() instanceof «terminal.eClass.instanceClass») {
					«terminal.assignmentTerminal("assignment.getTerminal()")»
				}
			«ENDFOR»		
		'''
	}

	private def dispatch StringConcatenationClient assignmentTerminal(AbstractElement element, String accessor) '''
		// subclasses may override
	'''

	private def dispatch StringConcatenationClient assignmentTerminal(CrossReference element, String accessor)  '''
		lookupCrossReference(((«CrossReference»)«accessor»), context, acceptor);
	'''

	private def dispatch StringConcatenationClient assignmentTerminal(RuleCall element, String accessor) '''
		completeRuleCall(((«RuleCall»)«accessor»), context, acceptor);
	'''

	private def dispatch StringConcatenationClient assignmentTerminal(Alternatives alternatives, String accessor) '''
		«FOR pair : alternatives.elements.indexed»
			«pair.value.assignmentTerminal("((Alternatives)" + accessor + ").getElements.get("+ pair.key +")")»
		«ENDFOR»
	'''

	// helper methods

	private def getContentAssistContextClass() {
		new TypeReference("org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext")
	}

	private def getICompletionProposalAcceptorClass() {
		new TypeReference("org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor")
	} 

	def private getFQFeatureName(AbstractRule r) {
		"_" + r.name;
	}

	def private getFQFeatureName(Assignment a) {
		a.containingParserRule().name.toFirstUpper() + "_" + a.feature.toFirstUpper();
	}

	def private computeFQFeatureNames(Grammar g) {
		g.containedAssignments.map[ FQFeatureName ] + g.rules.map[ FQFeatureName ]
	}

	def getFQFeatureNamesToExclude(Grammar g) {
		if (g.nonTerminalsSuperGrammar != null) {
			val thisGrammarFqFeatureNames = g.computeFQFeatureNames.toSet
			val superGrammarsFqFeatureNames = g.allUsedGrammars.map[
				computeFQFeatureNames
			].flatten.toSet

			// return all elements (of 'g') that are already defined in some inherited grammars
			Sets.intersection(thisGrammarFqFeatureNames, superGrammarsFqFeatureNames)
		} else {
			emptySet()
		}
	}
}