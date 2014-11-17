package org.eclipse.xtext.idea.generator.parser.antlr

import com.google.inject.Inject
import com.google.inject.Singleton
import com.intellij.lang.PsiBuilder
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.EnumRule
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.ParserRule
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.TerminalRule
import org.eclipse.xtext.generator.parser.antlr.AntlrOptions
import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser
import org.eclipse.xtext.idea.parser.TokenTypeProvider
import org.eclipse.xtext.idea.generator.IdeaPluginClassNames

import static extension org.eclipse.xtext.GrammarUtil.*
import org.eclipse.xtext.Action

@Singleton
class PsiAntlrGrammarGenerator extends DefaultAntlrGrammarGenerator {
	
	@Inject
	extension IdeaPluginClassNames
	
	override protected getGrammarFileName(Grammar it) {
		getGrammarFileName('Psi')
	}
	
	override protected compileOptions(Grammar it, AntlrOptions options) '''

		options {
			superClass=«AbstractPsiAntlrParser.simpleName»;
		«IF options.backtrack || options.memoize || options.k >= 0»
			«IF options.backtrack»
			backtrack=true
			«ENDIF»
			«IF options.memoize»
			memoize=true
			«ENDIF»
			«IF options.k >= 0»
			memoize=«options.k»
			«ENDIF»
		«ENDIF»
		}
	'''
	
	override protected compileParserImports(Grammar it, AntlrOptions options) '''

		import «AbstractPsiAntlrParser.name»;
		import «grammar.elementTypeProviderName»;
		import «TokenTypeProvider.name»;

		import «PsiBuilder.name»;
	'''
	
	override protected compileParserMembers(Grammar it, AntlrOptions options) '''
		
		@parser::members {
		
		«IF options.backtrack»
		/*
		  This grammar contains a lot of empty actions to work around a bug in ANTLR.
		  Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
		*/
		
		«ENDIF»
		public «grammar.elementTypeProviderName.toSimpleName» elementTypeProvider;
		
		public «grammar.psiInternalParserName.toSimpleName»(PsiBuilder builder, TokenStream input, «TokenTypeProvider.simpleName» tokenTypeProvider, «grammar.elementTypeProviderName.toSimpleName» elementTypeProvider) {
			super(builder, input, tokenTypeProvider);
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
		«entryRuleName»:
			{ «markComposite» }
			«ruleName»
			{ «doneComposite» }
			EOF;
		finally {
		}
		
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
				«markComposite»
				«doneComposite»
			}
		'''
	}
	
	override protected _ebnf2(Keyword it, AntlrOptions options, boolean supportActions) {
		if (!supportActions)
			return super._ebnf2(it, options, supportActions)
		else if (assigned) '''
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
	
	def protected markLeaf(EObject it) '''markLeaf();'''
	
	def protected doneLeaf(EObject it, String token) '''doneLeaf(«token», elementTypeProvider.get«grammarElementIdentifier»ElementType());'''
	
	def protected markComposite(EObject it) '''markComposite();'''
	
	def protected doneComposite(EObject it) '''doneComposite(elementTypeProvider.get«grammarElementIdentifier»ElementType());'''
	
}