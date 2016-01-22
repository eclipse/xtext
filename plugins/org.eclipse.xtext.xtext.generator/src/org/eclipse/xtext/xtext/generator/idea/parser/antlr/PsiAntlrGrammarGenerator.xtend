/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.idea.parser.antlr

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.Action
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.EnumLiteralDeclaration
import org.eclipse.xtext.EnumRule
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.ParserRule
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.TerminalRule
import org.eclipse.xtext.UnorderedGroup
import org.eclipse.xtext.xtext.generator.idea.IdeaPluginClassNames
import org.eclipse.xtext.xtext.generator.parser.antlr.AbstractAntlrGrammarWithActionsGenerator
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrOptions

import static extension org.eclipse.xtext.EcoreUtil2.*
import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenUtil.*
import org.eclipse.xtext.AbstractElement

class PsiAntlrGrammarGenerator extends AbstractAntlrGrammarWithActionsGenerator {
	
	@Inject
	extension IdeaPluginClassNames
	@Inject
	extension PsiGrammarNaming naming
	
	override protected getGrammarNaming() {
		naming
	}
	
	override protected compileParserImports(Grammar it, AntlrOptions options) '''

		import «grammarNaming.getInternalParserSuperClass(it).name»;
		import «grammar.elementTypeProvider»;
		import org.eclipse.xtext.idea.parser.TokenTypeProvider;
		import org.eclipse.xtext.parser.antlr.XtextTokenStream;
		import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
		«IF !allParserRules.map[eAllContentsAsList].flatten.filter(UnorderedGroup).empty && options.backtrack»
			import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper.UnorderedGroupState;
		«ENDIF»
		import «grammarAccess.name»;

		import com.intellij.lang.PsiBuilder;
	'''
	
	override protected compileParserMembers(Grammar it, AntlrOptions options) '''
		
		@parser::members {
		
		«IF options.backtrack»
		/*
		  This grammar contains a lot of empty actions to work around a bug in ANTLR.
		  Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
		*/
		
		«ENDIF»
			protected «grammarAccess.simpleName» grammarAccess;
		
			protected «grammar.elementTypeProvider.simpleName» elementTypeProvider;
		
			public «grammar.psiInternalParser.simpleName»(PsiBuilder builder, TokenStream input, «grammar.elementTypeProvider.simpleName» elementTypeProvider, «grammarAccess.simpleName» grammarAccess) {
				this(input);
				setPsiBuilder(builder);
				this.grammarAccess = grammarAccess;
				this.elementTypeProvider = elementTypeProvider;
			}
		
			@Override
			protected String getFirstRuleName() {
				return "«(allParserRules.head.originalElement as AbstractRule).name»";
			}
		
		}
	'''
	
	override protected shouldBeSkipped(TerminalRule it, Grammar grammar) {
		false
	}
	
	override protected dispatch compileRule(ParserRule it, Grammar grammar, AntlrOptions options) '''
		«IF isValidEntryRule»
			//Entry rule «entryRuleName»
			«entryRuleName» returns [«currentType» current=false]«compileEntryInit(options)»:
				{ «markComposite» }
				iv_«originalElement.ruleName»=«originalElement.ruleName»«defaultArgumentList»
				{ $current=$iv_«originalElement.ruleName».current; }
				EOF;
			«compileEntryFinally(options)»
		«ENDIF»
		
		«compileEBNF(options)»
	'''
	
	override protected compileInit(AbstractRule it, AntlrOptions options) '''
		«IF it instanceof ParserRule»«getParameterList(!isPassCurrentIntoFragment, currentType)»«ENDIF» returns «compileReturns(options)»
		«super.compileInit(it, options)»'''
	
	protected def compileReturns(AbstractRule it, AntlrOptions options) {
		switch it {
			ParserRule case !originalElement.datatypeRule && originalElement.isEObjectFragmentRule:
				'''[«currentType» current=in_current]'''
			default:
				'''[«currentType» current=false]'''
		}
	}
	
	override protected _dataTypeEbnf2(Keyword it, boolean supportActions) {
		if (supportActions) '''
			{
				«markLeaf»
			}
			kw=«super._dataTypeEbnf2(it, supportActions)»
			{
				«doneLeaf('kw')»
			}
		'''
		else {
			super._dataTypeEbnf2(it, supportActions)
		}
	}
	
	override protected _dataTypeEbnf2(RuleCall it, boolean supportActions) {
		if (supportActions) {
			switch it.getRule {
				EnumRule case assigned,
				ParserRule case assigned: 
					super._dataTypeEbnf2(it, supportActions)
				EnumRule, 
				ParserRule: '''
					{
						«markComposite»
					}
					«super._dataTypeEbnf2(it, supportActions)»
					{
						«doneComposite»
					}
				'''
				TerminalRule: '''
					{
						«markLeaf»
					}
					«localVar»=«super._dataTypeEbnf2(it, supportActions)»
					{
						«doneLeaf(localVar)»
					}
				'''
				default:
					super._dataTypeEbnf2(it, supportActions)
			}
		} else {
			super._dataTypeEbnf2(it, supportActions)
		}
	}
	
	override protected _ebnf2(Action it, AntlrOptions options, boolean supportActions) {
		if (!supportActions)
			return super._ebnf2(it, options, supportActions)
		else '''
			«IF options.backtrack»
			{
				/* */
			}
			«ENDIF»
			{
				«precedeComposite»
				«doneComposite»
				«associateWithSemanticElement»
			}
		'''
	}
	
	override protected _ebnf2(Keyword it, AntlrOptions options, boolean supportActions) {
		if (!supportActions)
			return super._ebnf2(it, options, supportActions)
		else if(assigned) '''
			{
				«markLeaf»
			}
			«containingAssignment.localVar(it)»=«super._ebnf2(it, options, supportActions)»
			{
				«doneLeaf(containingAssignment.localVar(it))»
			}
		'''
		else '''
			{
				«markLeaf»
			}
			«localVar»=«super._ebnf2(it, options, supportActions)»
			{
				«doneLeaf(localVar)»
			}
		'''
	}
	
	override protected _ebnf2(EnumLiteralDeclaration it, AntlrOptions options, boolean supportActions) {
		if (!supportActions)
			return super._ebnf2(it, options, supportActions)
		else '''
			{
				«markLeaf»
			}
			«localVar»=«super._ebnf2(it, options, supportActions)»
			{
				«doneLeaf(localVar)»
			}
		'''
	}
	
	override protected _ebnf2(RuleCall it, AntlrOptions options, boolean supportActions) {
		if (supportActions) {
			switch rule {
				EnumRule case assigned,
				ParserRule case assigned: 
					super._ebnf2(it, options, supportActions)
				EnumRule, 
				ParserRule case rule.originalElement.datatypeRule: '''
					«IF options.backtrack»
					{
						/* */
					}
					«ENDIF»
					{
						«markComposite»
					}
					«super._ebnf2(it, options, supportActions)»
					{
						«doneComposite»
					}
				'''
				ParserRule: '''
					«IF options.backtrack»
					{
						/* */
					}
					«ENDIF»
					{
						«IF isEObjectFragmentRuleCall»
							if (!$current) {
								«associateWithSemanticElement»
								$current = true;
							}
						«ENDIF»
						«markComposite»
					}
					«localVar»=«super._ebnf2(it, options, supportActions)»
					{
						$current = $«localVar».current;
						«doneComposite»
					}
				'''
				TerminalRule: '''
					{
						«markLeaf»
					}
					«localVar»=«super._ebnf2(it, options, supportActions)»
					{
						«doneLeaf(localVar)»
					}
				'''
				default: 
					super._ebnf2(it, options, supportActions)
			}
		} else {
			super._ebnf2(it, options, supportActions)
		}
	}
	
	override protected crossrefEbnf(AbstractRule it, RuleCall call, CrossReference ref, boolean supportActions) {
		if (supportActions) {
			switch it {
				EnumRule,
				ParserRule: '''
					{
						«ref.markComposite»
					}
					«super.crossrefEbnf(it, call, ref, supportActions)»
					{
						«ref.doneComposite»
					}
				'''
				TerminalRule: '''
					{
						«ref.markLeaf»
					}
					«ref.containingAssignment.localVar»=«super.crossrefEbnf(it, call, ref, supportActions)»
					{
						«ref.doneLeaf(ref.containingAssignment.localVar)»
					}
				'''
				default:
					throw new IllegalStateException("crossrefEbnf is not supported for " + it)
			}
		} else {
			super.crossrefEbnf(it, call, ref, supportActions)
		}
	}
	
	override protected _assignmentEbnf(CrossReference it, Assignment assignment, AntlrOptions options, boolean supportActions) {
		if (supportActions) '''
			«IF options.backtrack»
			{
				/* */
			}
			«ENDIF»
			{
				if (!$current) {
					«associateWithSemanticElement»
					$current = true;
				}
			}
			«super._assignmentEbnf(it, assignment, options, supportActions)»'''
		else
		super._assignmentEbnf(it, assignment, options, supportActions)
	}
	
	override protected _assignmentEbnf(AbstractElement it, Assignment assignment, AntlrOptions options, boolean supportActions) {
		if (supportActions) '''
			«super._assignmentEbnf(it, assignment, options, supportActions)»
			{
				if (!$current) {
					«associateWithSemanticElement»
					$current = true;
				}
			}
		'''
		else
			super._assignmentEbnf(it, assignment, options, supportActions)
	}
	
	override protected _assignmentEbnf(RuleCall it, Assignment assignment, AntlrOptions options, boolean supportActions) {
		if (supportActions) {
			switch rule {
				EnumRule,
				ParserRule: '''
					{
						«markComposite»
					}
					«assignment.localVar(it)»=«super._assignmentEbnf(it, assignment, options, supportActions)»
					{
						«doneComposite»
						if(!$current) {
							«associateWithSemanticElement»
							$current = true;
						}
					}
				'''
				TerminalRule: '''
					{
						«markLeaf»
					}
					«assignment.localVar(it)»=«super._assignmentEbnf(it, assignment, options, supportActions)»
					{
						if(!$current) {
							«associateWithSemanticElement»
							$current = true;
						}
					}
					{
						«doneLeaf(assignment.localVar(it))»
					}
				'''
				default: 
					throw new IllegalStateException("assignmentEbnf is not supported for " + it)
			}
		} else {
			super._assignmentEbnf(it, assignment, options, supportActions)
		}
	}
	
	def protected markLeaf(EObject it) '''markLeaf(elementTypeProvider.get«originalElement.grammarElementIdentifier»ElementType());'''
	
	def protected doneLeaf(EObject it, String token) '''doneLeaf(«token»);'''
	
	def protected markComposite(EObject it) '''markComposite(elementTypeProvider.get«originalElement.grammarElementIdentifier»ElementType());'''
	
	def protected doneComposite(EObject it) '''doneComposite();'''
	
	def protected precedeComposite(EObject it) '''precedeComposite(elementTypeProvider.get«originalElement.grammarElementIdentifier»ElementType());'''
	
	def protected associateWithSemanticElement() '''associateWithSemanticElement();'''
	
	override protected isPassCurrentIntoFragment() {
		true
	}
	
	override protected getCurrentType() {
		'Boolean'
	}
	
}