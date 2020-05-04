/*******************************************************************************
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr

import com.google.inject.Singleton
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.AbstractElement
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
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrOptions

import static extension org.eclipse.xtext.EcoreUtil2.*
import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenUtil.*
import com.google.inject.Inject

@Singleton
class AntlrGrammarGenerator extends AbstractAntlrGrammarWithActionsGenerator {
	@Inject extension GrammarNaming naming
	
	protected override getGrammarNaming() {
		naming
	}
	
	protected override compileParserImports(Grammar it, AntlrOptions options) '''

		import org.eclipse.xtext.*;
		import org.eclipse.xtext.parser.*;
		import org.eclipse.xtext.parser.impl.*;
		import org.eclipse.emf.ecore.util.EcoreUtil;
		import org.eclipse.emf.ecore.EObject;
		«IF !allEnumRules.empty»
		import org.eclipse.emf.common.util.Enumerator;
		«ENDIF»
		import «grammarNaming.getInternalParserSuperClass(it).name»;
		import org.eclipse.xtext.parser.antlr.XtextTokenStream;
		import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
		«IF !allParserRules.map[eAllContentsAsList].flatten.filter(UnorderedGroup).empty && options.backtrack»
		import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper.UnorderedGroupState;
		«ENDIF»
		import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
		import «grammarAccess.name»;

	'''
	
	protected override compileParserMembers(Grammar it, AntlrOptions options) '''
		
		@«IF combinedGrammar»parser::«ENDIF»members {
		
		«IF options.backtrack»
		/*
		  This grammar contains a lot of empty actions to work around a bug in ANTLR.
		  Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
		*/

		«ENDIF»
		 	private «grammarAccess.simpleName» grammarAccess;

		    public «internalParserClass.simpleName»(TokenStream input, «grammarAccess.simpleName» grammarAccess) {
		        this(input);
		        this.grammarAccess = grammarAccess;
		        registerRules(grammarAccess.getGrammar());
		    }
		
		    @Override
		    protected String getFirstRuleName() {
		    	return "«allParserRules.head.originalElement.name»";
		   	}
		
		   	@Override
		   	protected «grammarAccess.simpleName» getGrammarAccess() {
		   		return grammarAccess;
		   	}
		
		}
	'''
	
	protected override compileRuleCatch(Grammar it, AntlrOptions options) '''
		
		@rulecatch {
		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }
		}
	''' 
	
	override protected shouldBeSkipped(TerminalRule it, Grammar grammar) {
		false
	}
	
	protected override dispatch compileRule(ParserRule it, Grammar grammar, AntlrOptions options) '''
		«IF isValidEntryRule()»
			«compileEntryRule(grammar, options)»
		«ENDIF»
		
		«compileEBNF(options)»
	'''
	
	protected def String compileEntryRule(ParserRule it, Grammar grammar, AntlrOptions options) '''
		// Entry rule «originalElement.entryRuleName»
		«originalElement.entryRuleName» returns «compileEntryReturns(options)»«compileEntryInit(options)»:
			{ «newCompositeNode» }
			iv_«originalElement.ruleName»=«ruleName»«defaultArgumentList»
			{ $current=$iv_«ruleName».current«IF originalElement.datatypeRule».getText()«ENDIF»; }
			EOF;
		«compileEntryFinally(options)»
	'''
	
	protected def compileEntryReturns(ParserRule it, AntlrOptions options) {
		if (originalElement.datatypeRule)
			return '[String current=null]'
		else
			return '''[«currentType» current=null]'''
	}
	
	override protected compileInit(AbstractRule it, AntlrOptions options) '''
		«IF it instanceof ParserRule»«getParameterList(!isPassCurrentIntoFragment, currentType)»«ENDIF» returns «compileReturns(options)»
		@init {
			enterRule();
			«compileInitHiddenTokens(options)»
			«compileInitUnorderedGroups(options)»
		}
		@after {
			leaveRule();
		}'''
	
	
		
	protected def compileReturns(AbstractRule it, AntlrOptions options) {
		switch it {
			EnumRule:
				'[Enumerator current=null]'
			ParserRule case originalElement.datatypeRule:
				'[AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]'
			ParserRule case originalElement.isEObjectFragmentRule:
				'''[«currentType» current=in_current]'''
			ParserRule:
				'''[«currentType» current=null]'''
			default:
				throw new IllegalStateException("Unexpected rule: " + it)
		}
	}
	
	protected override String _dataTypeEbnf2(Keyword it, boolean supportActions) {
		if (supportActions) '''
			kw=«super._dataTypeEbnf2(it, supportActions)»
			{
				$current.merge(kw);
				«newLeafNode("kw")»
			}
		''' 
		else
			super._dataTypeEbnf2(it, supportActions) 
	}
	
	protected override String _dataTypeEbnf2(RuleCall it, boolean supportActions) {
		if (supportActions)
			switch rule {
				EnumRule case assigned,
				ParserRule case assigned: 
					super._dataTypeEbnf2(it, supportActions)
				EnumRule, 
				ParserRule: '''
					{
						«newCompositeNode»
					}
					«localVar»=«super._dataTypeEbnf2(it, supportActions)»«getArgumentList(isPassCurrentIntoFragment, !supportActions)»
					{
						$current.merge(«localVar»);
					}
					{
						afterParserOrEnumRuleCall();
					}
				'''
				TerminalRule: '''
					«localVar»=«super._dataTypeEbnf2(it, supportActions)»
					{
						$current.merge(«localVar»);
					}
					{
						«newLeafNode(localVar)»
					}
				'''
				default:
					super._dataTypeEbnf2(it, supportActions)
			}
		else
			super._dataTypeEbnf2(it, supportActions)
	}
	
	protected override String _ebnf2(Action it, AntlrOptions options, boolean supportActions) {
		if (supportActions) '''
			«IF options.backtrack»
			{
				/* */
			}
			«ENDIF»
			{
				$current = forceCreateModelElement«IF feature !== null»And«setOrAdd.toFirstUpper»«ENDIF»(
					grammarAccess.«originalElement.grammarElementAccess»,
					$current);
			}
		'''
		else 
			super._ebnf2(it, options, supportActions)
	}
	
	protected override String _ebnf2(Keyword it, AntlrOptions options, boolean supportActions) {
		if (!supportActions) 
			super._ebnf2(it, options, supportActions)
		else if (assigned) '''
			«super._ebnf2(it, options, supportActions)»
			{
				«newLeafNode(containingAssignment.localVar(it))»
			}
		'''
		else '''
			«localVar»=«super._ebnf2(it, options, supportActions)»
			{
				«newLeafNode(localVar)»
			}
		'''
	}
	
	override protected _ebnf2(EnumLiteralDeclaration it, AntlrOptions options, boolean supportActions) {
		if (!supportActions) 
			super._ebnf2(it, options, supportActions)
		else '''
			«localVar»=«super._ebnf2(it, options, supportActions)»
			{
				$current = grammarAccess.«grammarElementAccess(originalElement)».getEnumLiteral().getInstance();
				«newLeafNode(localVar)»
			}
		'''
	}
	
	protected override String _ebnf2(RuleCall it, AntlrOptions options, boolean supportActions) {
		if (!supportActions)
			super._ebnf2(it, options, supportActions)
		else
			switch rule : rule {
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
						«newCompositeNode»
					}
					«super._ebnf2(it, options, supportActions)»
					{
						afterParserOrEnumRuleCall();
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
							if ($current==null) {
								$current = «it.createModelElement»;
							}
						«ENDIF»
						«newCompositeNode»
					}
					«localVar»=«super._ebnf2(it, options, supportActions)»
					{
						$current = $«localVar».current;
						afterParserOrEnumRuleCall();
					}
				'''
				TerminalRule: '''
					«localVar»=«super._ebnf2(it, options, supportActions)»
					{
						«newLeafNode(localVar)»
					}
				'''
				default: 
					super._ebnf2(it, options, supportActions)
			}
	}
	
	protected override String crossrefEbnf(AbstractRule it, RuleCall call, CrossReference ref, boolean supportActions) {
		if (supportActions)
			switch it {
				EnumRule,
				ParserRule: '''
					{
						«ref.newCompositeNode»
					}
					«ruleName»«call.getArgumentList(isPassCurrentIntoFragment, !supportActions)»
					{
						afterParserOrEnumRuleCall();
					}
				'''
				TerminalRule: '''
					«ref.containingAssignment.localVar»=«ruleName»
					{
						«ref.newLeafNode(ref.containingAssignment.localVar)»
					}
				'''
				default:
					throw new IllegalStateException("crossrefEbnf is not supported for " + it)
			}
		else
			super.crossrefEbnf(it, call, ref, supportActions)
	}
	
	override protected _crossrefEbnf(Keyword it, CrossReference ref, boolean supportActions) {
		if (!supportActions)
			super._crossrefEbnf(it, ref, supportActions)
		else '''
			«ref.containingAssignment.localVar»=«super._crossrefEbnf(it, ref, supportActions)»
			{
				«ref.newLeafNode(ref.containingAssignment.localVar)»
			}
		'''
	}
	
	override protected _assignmentEbnf(CrossReference it, Assignment assignment, AntlrOptions options, boolean supportActions) {
		if (supportActions) '''
			«IF options.backtrack»
			{
				/* */
			}
			«ENDIF»
			{
				if ($current==null) {
					$current = «assignment.createModelElement»;
				}
			}
			«super._assignmentEbnf(it, assignment, options, supportActions)»'''
		else
			super._assignmentEbnf(it, assignment, options, supportActions)
	}

	override protected _assignmentEbnf(AbstractElement it, Assignment assignment, AntlrOptions options, boolean supportActions) {
		if (supportActions) '''
			«assignment.localVar(it)»=«super._assignmentEbnf(it, assignment, options, supportActions)»
			{
				if ($current==null) {
					$current = «assignment.createModelElement»;
				}
				«assignment.setOrAdd»WithLastConsumed($current, "«assignment.feature»", «
	        		assignment.localVar(it)»«IF assignment.isBooleanAssignment» != null«ENDIF
	        		», «assignment.terminal.toStringLiteral»);
			}
		'''
		else
			super._assignmentEbnf(it, assignment, options, supportActions)
	}
	
	protected override String _assignmentEbnf(RuleCall it, Assignment assignment, AntlrOptions options, boolean supportActions) {
		if (supportActions)
			switch rule {
				EnumRule,
				ParserRule: '''
					{
						«newCompositeNode»
					}
					«assignment.localVar(it)»=«super._assignmentEbnf(it, assignment, options, supportActions)»
					{
						if ($current==null) {
							$current = «assignment.createModelElementForParent»;
						}
						«assignment.setOrAdd»(
							$current,
							"«assignment.feature»",
							«assignment.localVar(it)»«IF assignment.isBooleanAssignment» != null«ENDIF»,
							«toStringLiteral»);
						afterParserOrEnumRuleCall();
					}
				'''
				TerminalRule: '''
					«assignment.localVar(it)»=«super._assignmentEbnf(it, assignment, options, supportActions)»
					{
						«newLeafNode(assignment.localVar(it))»
					}
					{
						if ($current==null) {
							$current = «assignment.createModelElement»;
						}
						«assignment.setOrAdd»WithLastConsumed(
							$current,
							"«assignment.feature»",
							«assignment.localVar(it)»«IF assignment.isBooleanAssignment» != null«ENDIF»,
							«toStringLiteral»);
					}
				'''
				default: 
					throw new IllegalStateException("assignmentEbnf is not supported for " + it)
			}
		else
			super._assignmentEbnf(it, assignment, options, supportActions)
	}
	
	override protected isPassCurrentIntoFragment() {
		return true
	}
	
	protected def createModelElement(EObject grammarElement) '''
		createModelElement(grammarAccess.«grammarElement.containingParserRule.originalElement.grammarElementAccess»)'''
	
	protected def createModelElementForParent(EObject grammarElement) '''
		createModelElementForParent(grammarAccess.«grammarElement.containingParserRule.originalElement.grammarElementAccess»)'''
	
	protected def newCompositeNode(EObject it) '''newCompositeNode(grammarAccess.«originalElement.grammarElementAccess»);'''

	protected def newLeafNode(EObject it, String token) '''newLeafNode(«token», grammarAccess.«originalElement.grammarElementAccess»);'''

}
