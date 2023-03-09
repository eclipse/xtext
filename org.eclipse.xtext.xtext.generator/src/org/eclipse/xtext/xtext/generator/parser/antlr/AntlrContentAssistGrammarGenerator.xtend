/*******************************************************************************
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr

import com.google.inject.Inject
import org.eclipse.xtext.AbstractElement
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.Alternatives
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.EnumRule
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.Group
import org.eclipse.xtext.ParserRule
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.TerminalRule
import org.eclipse.xtext.UnorderedGroup

import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenUtil.*
import org.eclipse.xtext.Keyword

class AntlrContentAssistGrammarGenerator extends AbstractAntlrGrammarWithActionsGenerator {
	@Inject
	extension ContentAssistGrammarNaming naming

	override protected getGrammarNaming() {
		naming
	}

	override protected isParserBackTracking(Grammar it, AntlrOptions options) {
		super.isParserBackTracking(it, options) || !allPredicatedElements.isEmpty
	}
	
	override protected compileParserMembers(Grammar it, AntlrOptions options) '''
		@«IF combinedGrammar»parser::«ENDIF»members {
			private «grammarAccess.simpleName» grammarAccess;
			«IF !combinedGrammar»
				private final Map<String, String> tokenNameToValue = new HashMap<String, String>();
				
				{
					«FOR kw: allKeywords.sort.sortBy[length]»
						tokenNameToValue.put("«keywordHelper.getRuleName(kw)»", "'«kw.toStringInAntlrAction.replace('$', "\\u0024")»'");
					«ENDFOR»
				}
			«ENDIF»
		
			public void setGrammarAccess(«grammarAccess.simpleName» grammarAccess) {
				this.grammarAccess = grammarAccess;
			}
		
			@Override
			protected Grammar getGrammar() {
				return grammarAccess.getGrammar();
			}
		
			@Override
			protected String getValueForTokenName(String tokenName) {
				«IF combinedGrammar»
					return tokenName;
				«ELSE»
					String result = tokenNameToValue.get(tokenName);
					if (result == null)
						result = tokenName;
					return result;
				«ENDIF»
			}
		}
	'''
	
	override protected compileParserImports(Grammar it, AntlrOptions options) '''
		«IF !combinedGrammar»
			import java.util.Map;
			import java.util.HashMap;
		«ENDIF»
		
		import java.io.InputStream;
		import org.eclipse.xtext.*;
		import org.eclipse.xtext.parser.*;
		import org.eclipse.xtext.parser.impl.*;
		import org.eclipse.emf.ecore.util.EcoreUtil;
		import org.eclipse.emf.ecore.EObject;
		import org.eclipse.xtext.parser.antlr.XtextTokenStream;
		import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
		import «grammarNaming.getInternalParserSuperClass(it).name»;
		import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
		import «grammarAccess.name»;

	'''
	
	override protected compileRules(Grammar g, AntlrOptions options) '''
		«FOR rule : (g.allParserRules + g.allEnumRules + g.allAlternatives + g.allGroups + g.allUnorderedGroups + g.allAssignments).filter[containingRule.isCalled(g)]»
			
			«rule.compileRule(g, options)»
		«ENDFOR»
		«IF isCombinedGrammar»
			«g.compileTerminalRules(options)»
		«ENDIF»
	'''
	
	protected override dispatch compileRule(ParserRule it, Grammar grammar, AntlrOptions options) '''
		«IF isValidEntryRule»
			// Entry rule «entryRuleName»
			«entryRuleName»
			«IF definesHiddenTokens»
				@init { 
					«compileInitHiddenTokens(options)»
				}
			«ENDIF»
			:
			{ before(grammarAccess.«originalElement.grammarElementAccess»); }
				 «ruleName»
			{ after(grammarAccess.«originalElement.grammarElementAccess»); } 
				 EOF 
			;
			«IF definesHiddenTokens»
				finally {
					«compileRestoreHiddenTokens(options)»
				}
			«ENDIF»
		«ENDIF»
		
		// Rule «originalElement.name»
		«ruleName» 
			@init {
				«compileInitHiddenTokens(options)»
				int stackSize = keepStackSize();
			}
			:
			«alternatives.ebnf(options, false)»
		;
		finally {
			restoreStackSize(stackSize);
			«compileRestoreHiddenTokens(options)»
		}
	'''
	
	protected override dispatch compileRule(EnumRule it, Grammar grammar, AntlrOptions options) '''
		// Rule «originalElement.name»
		«ruleName()»
			@init {
				int stackSize = keepStackSize();
			}
		:
			«alternatives.ebnf(options, false)»
		;
		finally {
			restoreStackSize(stackSize);
		}
	'''
	
	protected def dispatch compileRule(Alternatives it, Grammar grammar, AntlrOptions options) '''
		«containingRule.contentAssistRuleName»__«originalElement.gaElementIdentifier»
			@init {
				int stackSize = keepStackSize();
			}
		:
			«FOR element : elements SEPARATOR '\n|'»«element.ebnf(options, false)»«ENDFOR»
		;
		finally {
			restoreStackSize(stackSize);
		}
	'''
	
	protected def dispatch compileRule(Assignment it, Grammar grammar, AntlrOptions options) '''
		«containingRule.contentAssistRuleName»__«originalElement.gaElementIdentifier»
			@init {
				int stackSize = keepStackSize();
			}
		:
			«terminal.assignmentEbnf(it, options, false)»
		;
		finally {
			restoreStackSize(stackSize);
		}
	'''
	
	protected def dispatch compileRule(UnorderedGroup it, Grammar grammar, AntlrOptions options) {
		val hasMandatoryContent = elements.exists[!isOptionalCardinality]
		
		'''
			«containingRule.contentAssistRuleName»__«originalElement.gaElementIdentifier()»
				@init {
					int stackSize = keepStackSize();
					getUnorderedGroupHelper().enter(grammarAccess.«originalElement.gaRuleElementAccessor()»);
				}
			:
				«containingRule.contentAssistRuleName»__«originalElement.gaElementIdentifier()»__0
				«IF hasMandatoryContent»
					{getUnorderedGroupHelper().canLeave(grammarAccess.«originalElement.gaRuleElementAccessor()»)}?
				«ELSE»
					?
				«ENDIF»
			;
			finally {
				getUnorderedGroupHelper().leave(grammarAccess.«originalElement.gaRuleElementAccessor()»);
				restoreStackSize(stackSize);
			}
			
			«ruleImpl(grammar, options)»
			
			«ruleImpl(grammar, options, 0)»
		'''
	}
	
	protected def dispatch compileRule(Group it, Grammar grammar, AntlrOptions options) '''
		«ruleImpl(grammar, options, 0)»
	'''
	
	protected def ruleImpl(UnorderedGroup it, Grammar grammar, AntlrOptions options) '''
		«containingRule.contentAssistRuleName»__«originalElement.gaElementIdentifier()»__Impl
			@init {
				int stackSize = keepStackSize();
				boolean selected = false;
			}
		:
				(
				«FOR element : elements.indexed SEPARATOR '|'»
					( 
						{getUnorderedGroupHelper().canSelect(grammarAccess.«originalElement.gaRuleElementAccessor()», «element.key»)}?=>(
							{
								getUnorderedGroupHelper().select(grammarAccess.«originalElement.gaRuleElementAccessor()», «element.key»);
							}
							{
								selected = true;
							}
							(
								«IF element.value.isMultipleCardinality»
								(
									{ before(grammarAccess.«element.value.originalElement.grammarElementAccess()»); }
									(«element.value.ebnf2(options, false)»)
									{ after(grammarAccess.«element.value.originalElement.grammarElementAccess()»); }
								)
								(
									{ before(grammarAccess.«element.value.originalElement.grammarElementAccess()»); }
									((«element.value.ebnf2(options, false)»)=>«element.value.ebnf2(options, false)»)*
									{ after(grammarAccess.«element.value.originalElement.grammarElementAccess()»); }
								)
								«ELSE»
									{ before(grammarAccess.«element.value.originalElement.grammarElementAccess()»); }
									(«element.value.ebnf2(options, false)»)
									{ after(grammarAccess.«element.value.originalElement.grammarElementAccess()»); }
								«ENDIF»
							)
						)
					)
				«ENDFOR»
				)
		;
		finally {
			if (selected)
				getUnorderedGroupHelper().returnFromSelection(grammarAccess.«originalElement.gaRuleElementAccessor()»);
			restoreStackSize(stackSize);
		}
	'''
	
	protected def CharSequence ruleImpl(UnorderedGroup it, Grammar grammar, AntlrOptions options, int index) '''
		«containingRule.contentAssistRuleName»__«originalElement.gaElementIdentifier()»__«index»
			@init {
				int stackSize = keepStackSize();
			}
		:
			«containingRule.contentAssistRuleName»__«originalElement.gaElementIdentifier()»__Impl
			«IF elements.size > index + 1»
				«containingRule.contentAssistRuleName»__«originalElement.gaElementIdentifier()»__«index + 1»?
			«ENDIF» 
		;
		finally {
			restoreStackSize(stackSize);
		}
		
		«IF elements.size > index + 1»
			«ruleImpl(grammar, options, index + 1)»
		«ENDIF»
	'''
	
	protected def CharSequence ruleImpl(Group it, Grammar grammar, AntlrOptions options, int index) '''
		«containingRule.contentAssistRuleName»__«originalElement.gaElementIdentifier»__«index»
			@init {
				int stackSize = keepStackSize();
			}
		:
			«containingRule.contentAssistRuleName»__«originalElement.gaElementIdentifier»__«index»__Impl
			«IF elements.size > index + 1»
				«containingRule().contentAssistRuleName»__«originalElement.gaElementIdentifier»__«index + 1»
			«ENDIF» 
		;
		finally {
			restoreStackSize(stackSize);
		}
		
		«containingRule().contentAssistRuleName»__«originalElement.gaElementIdentifier»__«index»__Impl
			@init {
				int stackSize = keepStackSize();
			}
		:
		«elements.get(index).ebnf(options, false)»
		;
		finally {
			restoreStackSize(stackSize);
		}
		
		«IF elements.size > index + 1»
			«ruleImpl(grammar, options, index + 1)»
		«ENDIF»
	'''
	
	protected override ebnf(AbstractElement it, AntlrOptions options, boolean supportsActions) '''
		«IF !isOptionalCardinality() && isMultipleCardinality()»
			(
				(
					{ before(grammarAccess.«originalElement.grammarElementAccess»«paramConfig»); }
					(«ebnf2(options, supportsActions)»)
					{ after(grammarAccess.«originalElement.grammarElementAccess»«paramConfig»); }
				)
				(
					{ before(grammarAccess.«originalElement.grammarElementAccess»«paramConfig»); }
					(«ebnf2(options, supportsActions)»)*
					{ after(grammarAccess.«originalElement.grammarElementAccess»«paramConfig»); }
				)
			)
		«ELSE»
			(
				{ before(grammarAccess.«originalElement.grammarElementAccess»«paramConfig»); }
				«IF mustBeParenthesized()»(«ebnf2(options, supportsActions)»)«ELSE»«ebnf2(options, supportsActions)»«ENDIF»«cardinality»
				{ after(grammarAccess.«originalElement.grammarElementAccess»«paramConfig»); }
			)
		«ENDIF»
	'''
	
	protected def paramConfig(AbstractElement it) '''
		«IF containingRule.alternatives === it && ParserRule.isInstance(containingRule) && !(containingRule.originalElement as ParserRule).parameters.isEmpty»
			, «(containingRule as ParserRule).parameterConfig»
		«ENDIF»
	'''
	
	protected override dispatch assignmentEbnf(AbstractElement it, Assignment assignment, AntlrOptions options, boolean supportsActions) '''
		(
			{ before(grammarAccess.«originalElement.grammarElementAccess»); }
			«ebnf(options, supportsActions)»
			{ after(grammarAccess.«originalElement.grammarElementAccess»); }
		)
	'''
	
	protected override dispatch assignmentEbnf(CrossReference it, Assignment assignment, AntlrOptions options, boolean supportsActions) '''
		(
			{ before(grammarAccess.«originalElement.grammarElementAccess»); }
			«terminal.crossrefEbnf(it, supportsActions)»
			{ after(grammarAccess.«originalElement.grammarElementAccess»); }
		)
	'''
	
	protected override dispatch assignmentEbnf(Alternatives it, Assignment assignment, AntlrOptions options, boolean supportsActions) '''
		(
			{ before(grammarAccess.«originalElement.grammarElementAccess»); }
			(«containingRule.contentAssistRuleName»__«originalElement.gaElementIdentifier»)
			{ after(grammarAccess.«originalElement.grammarElementAccess»); }
		)
	'''
	
	protected override dispatch assignmentEbnf(RuleCall it, Assignment assignment, AntlrOptions options, boolean supportsActions) '''
		(
			{ before(grammarAccess.«originalElement.grammarElementAccess»); }
			«rule.ruleName»
			{ after(grammarAccess.«originalElement.grammarElementAccess»); }
		)
	'''

	protected dispatch override crossrefEbnf(RuleCall it, CrossReference ref, boolean supportActions) '''
		(
			{ before(grammarAccess.«originalElement.grammarElementAccess»); }
			«rule.crossrefEbnf(it, ref, supportActions)»
			{ after(grammarAccess.«originalElement.grammarElementAccess»); }
		)
	'''
	
	protected dispatch override crossrefEbnf(Keyword it, CrossReference ref, boolean supportActions) '''
		(
			{ before(grammarAccess.«originalElement.grammarElementAccess»); }
			«super._crossrefEbnf(it, ref, supportActions)»
			{ after(grammarAccess.«originalElement.grammarElementAccess»); }
		)
	'''

	protected dispatch def crossrefEbnf(TerminalRule it, RuleCall call, CrossReference ref, boolean supportActions) {
		ruleName
	}

	protected dispatch def crossrefEbnf(EnumRule it, RuleCall call, CrossReference ref, boolean supportActions) {
		ruleName
	}

	protected def dispatch crossrefEbnf(AbstractRule it, RuleCall call, CrossReference ref, boolean supportActions) {
		if (originalElement.isDatatypeRule) {
			return ruleName
		}
		throw new IllegalArgumentException(it.name + " is not a datatype rule")
	}
	
	override protected dispatch ebnf2(Alternatives it, AntlrOptions options, boolean supportActions) {
		'''«containingRule.contentAssistRuleName»__«originalElement.gaElementIdentifier»'''
	}
	
	override protected dispatch ebnf2(Assignment it, AntlrOptions options, boolean supportActions) {
		'''«containingRule.contentAssistRuleName»__«originalElement.gaElementIdentifier»'''
	}
	
	override protected dispatch ebnf2(Group it, AntlrOptions options, boolean supportActions) {
		'''«containingRule.contentAssistRuleName»__«originalElement.gaElementIdentifier»__0'''
	}
	
	override protected dispatch ebnf2(UnorderedGroup it, AntlrOptions options, boolean supportActions) {
		'''«containingRule.contentAssistRuleName»__«originalElement.gaElementIdentifier»'''
	}
	
	override protected dispatch ebnf2(RuleCall it, AntlrOptions options, boolean supportActions) {
		rule.ruleName
	}
	
	override protected shouldBeSkipped(TerminalRule it, Grammar grammar) {
		false
	}

}
