/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.generator.parser.antlr

import com.google.inject.Inject
import com.google.inject.Singleton
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
import org.eclipse.xtext.generator.parser.antlr.AntlrOptions
import org.eclipse.xtext.idea.generator.IdeaPluginClassNames

import static extension org.eclipse.xtext.EcoreUtil2.*
import static extension org.eclipse.xtext.GrammarUtil.*

@Singleton
class PsiAntlrGrammarGenerator extends AbstractActionAwareAntlrGrammarGenerator {
	
	@Inject
	extension IdeaPluginClassNames
	
	override protected getGrammarFileName(Grammar it) {
		getGrammarFileName('Psi')
	}
	
	override protected compileOptions(Grammar it, AntlrOptions options) '''

		options {
			superClass=AbstractPsiAntlrParser;
			«IF options.backtrack || options.memoize || options.k >= 0»
			«IF options.backtrack»
			backtrack=true;
			«ENDIF»
			«IF options.memoize»
			memoize=true;
			«ENDIF»
			«IF options.k >= 0»
			memoize=«options.k»;
			«ENDIF»
			«ENDIF»
		}
	'''
	
	override protected compileParserImports(Grammar it, AntlrOptions options) '''

		import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
		import «grammar.elementTypeProviderName»;
		import org.eclipse.xtext.idea.parser.TokenTypeProvider;
		import org.eclipse.xtext.parser.antlr.XtextTokenStream;
		import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
		«IF !allParserRules.map[eAllContentsAsList].flatten.filter(UnorderedGroup).empty && options.backtrack»
		import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper.UnorderedGroupState;
		«ENDIF»
		import «gaFQName»;

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
			protected «gaSimpleName» grammarAccess;
		
			protected «grammar.elementTypeProviderName.toSimpleName» elementTypeProvider;
		
			public «grammar.psiInternalParserName.toSimpleName»(PsiBuilder builder, TokenStream input, «grammar.elementTypeProviderName.toSimpleName» elementTypeProvider, «gaSimpleName» grammarAccess) {
				this(input);
				setPsiBuilder(builder);
		    	this.grammarAccess = grammarAccess;
				this.elementTypeProvider = elementTypeProvider;
			}
		
			@Override
			protected String getFirstRuleName() {
				return "«allParserRules.head.name»";
			}
		
		}
	'''
	
	override protected shouldBeSkipped(TerminalRule it, Grammar grammar) {
		false
	}
	
	override protected _compileRule(ParserRule it, Grammar grammar, AntlrOptions options) '''
		//Entry rule «entryRuleName»
		«entryRuleName»«compileEntryInit(options)»:
			{ «markComposite» }
			«ruleName»
			EOF;
		«compileEntryFinally(options)»
		
		«compileEBNF(options)»
	'''
	
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
			switch rule {
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
				ParserRule: '''
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
	
	override protected _crossrefEbnf(AbstractRule it, CrossReference ref, boolean supportActions) {
		if (supportActions) {
			switch it {
				EnumRule,
				ParserRule: '''
					{
						«ref.markComposite»
					}
					«super._crossrefEbnf(it, ref, supportActions)»
					{
						«ref.doneComposite»
					}
				'''
				TerminalRule: '''
					{
						«ref.markLeaf»
					}
					«ref.containingAssignment.localVar»=«super._crossrefEbnf(it, ref, supportActions)»
					{
						«ref.doneLeaf(ref.containingAssignment.localVar)»
					}
				'''
				default:
					throw new IllegalStateException("crossrefEbnf is not supported for " + it)
			}
		} else {
			super._crossrefEbnf(it, ref, supportActions)
		}
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
					}
				'''
				TerminalRule: '''
					{
						«markLeaf»
					}
					«assignment.localVar(it)»=«super._assignmentEbnf(it, assignment, options, supportActions)»
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
	
	def protected markLeaf(EObject it) '''markLeaf(elementTypeProvider.get«grammarElementIdentifier»ElementType());'''
	
	def protected doneLeaf(EObject it, String token) '''doneLeaf(«token»);'''
	
	def protected markComposite(EObject it) '''markComposite(elementTypeProvider.get«grammarElementIdentifier»ElementType());'''
	
	def protected doneComposite(EObject it) '''doneComposite();'''
	
	def protected precedeComposite(EObject it) '''precedeComposite(elementTypeProvider.get«grammarElementIdentifier»ElementType());'''
	
}