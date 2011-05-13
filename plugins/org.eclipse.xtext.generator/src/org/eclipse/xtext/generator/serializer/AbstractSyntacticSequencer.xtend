package org.eclipse.xtext.generator.serializer

import org.eclipse.xtext.generator.grammarAccess.GrammarAccess
import java.util.List
import org.eclipse.xtext.serializer.impl.GrammarConstraintProvider
import org.eclipse.xtext.serializer.IGrammarConstraintProvider$IConstraint
import org.eclipse.xtext.serializer.IGrammarConstraintProvider$IConstraintElement
import org.eclipse.xtext.AbstractElement
import org.eclipse.xtext.Group
import org.eclipse.xtext.Alternatives
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.Grammar
import static extension org.eclipse.xtext.generator.GenModelAccess.*
import static extension org.eclipse.xtext.GrammarUtil.*
import org.eclipse.xtext.generator.serializer.SemanticSequencerUtil.*
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EClass
import com.google.common.collect.Lists
import java.util.Map
import org.eclipse.xtext.serializer.IGrammarConstraintProvider
import org.eclipse.emf.ecore.EcorePackage
import com.google.inject.Inject
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.AbstractElement
import java.util.Set
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider
import org.eclipse.xtext.serializer.IContextProvider
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider$ISynAbsorberState
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider$ISynFollowerOwner
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider$ISynTransition
import org.eclipse.xtext.serializer.ISyntacticSequencer$ISynState
import org.eclipse.xtext.serializer.ISyntacticSequencer$ISyntacticSequencerOwner
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider$ISynState
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider$ISynEmitterState
import org.eclipse.xtext.serializer.analysis.SyntacticSequencerPDAProvider$SynTransition
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementFullTitleSwitch
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.serializer.analysis.NfaToGrammar
import org.eclipse.xtext.serializer.analysis.NfaToGrammar$NfaToGrammar$AbstractElementAlias
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.IGrammarAccess

class AbstractSyntacticSequencer extends GeneratedFile {
	
	@Inject Grammar grammar
	
	@Inject extension GrammarAccess grammarAccess
	
	@Inject SyntacticSequencer sequencer
	
	@Inject extension SyntacticSequencerUtil util
	
	override String getQualifiedName(Grammar grammar) {
		grammar.getName("Abstract", "SyntacticSequencer");		
	}
	
	override getFileContents() {
		val file = new JavaFile(packageName);
		
		file.imported(typeof(org.eclipse.xtext.serializer.impl.AbstractSyntacticSequencer))
		file.imported(typeof(RuleCall))
		file.imported(typeof(INode))
		file.imported(typeof(ISyntacticSequencerPDAProvider$ISynTransition))
		file.imported(typeof(Inject))
		file.imported(typeof(AbstractElement))
		file.imported(typeof(IGrammarAccess))
		file.imported(typeof(EObject))
		file.imported("org.eclipse.xtext.serializer.analysis.NfaToGrammar.AbstractElementAlias")
		
		file.body = '''
			@SuppressWarnings("restriction")
			public class «simpleName» extends AbstractSyntacticSequencer {
			
				protected «file.imported(grammar.gaFQName)» grammarAccess;
				«FOR group:util.allAmbiguousTransitionsBySyntax.entrySet»
					protected AbstractElementAlias<AbstractElement> match_«group.key.elementAliasToIdentifyer»;
				«ENDFOR»
				
				@Inject
				protected void init(IGrammarAccess access) {
					grammarAccess = («file.imported(grammar.gaFQName)») access;
					«FOR group:util.allAmbiguousTransitionsBySyntax.entrySet»
						match_«group.key.elementAliasToIdentifyer» = « group.key.elementAliasToConstructor(file)»;
					«ENDFOR»
				}
				
				«file.genGetUnassignedRuleCallTokens()»
				
				«FOR rule:unassignedCalledTokenRules»
					«file.genGetUnassignedRuleCallToken(rule)»
				«ENDFOR»
				
				«file.genEmitUnassignedTokens()»
			
				«FOR group:util.allAmbiguousTransitionsBySyntax.entrySet»
					/**
					 * Syntax:
					 *     «group.key»
					 */
					protected void emit_«group.key.elementAliasToIdentifyer»(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
						acceptNodes(transition, fromNode, toNode);
					}
					
				«ENDFOR»
			}
		'''.toString; 
		file.toString 
	}
	
//						 *
//					 * Transitions:
//					 «FOR t:group.value»
//					 *    Type: «if(t.EClass == null) "null" else t.EClass.name» Context: «t.context.gaAccessor» Transition: «t»
//					 «ENDFOR»
//	
	
	def unassignedCalledTokenRules() {
		val rules = grammar.allRules.filter(e|e.EObjectRule)
		val calls = rules.map(r|r.containedRuleCalls.filter(e | !e.isAssigned() && !e.isEObjectRuleCall())).flatten
		calls.map(e | e.rule).toSet
	}
	
	def unassignedCalledTokenRuleName(AbstractRule rule) '''get«rule.name»Token'''
	
	def defaultValue(AbstractElement ele, Set<AbstractElement> visited) {
		switch(ele) {
			case !visited.add(ele): ""
			case ele.isOptionalCardinality(): ""
			Alternatives: ele.elements.head.defaultValue(visited)
			Group:  	  ele.elements.map(e|e.defaultValue(visited)).join()
			Keyword:	  ele.value
			RuleCall:     ele.rule.alternatives.defaultValue(visited)
			default:	  ""
		}
	}
	
	def genGetUnassignedRuleCallTokens(JavaFile file) '''
		@Override
		protected String getUnassignedRuleCallToken(RuleCall ruleCall, INode node) {
			«var i = 0»
			«FOR rule:unassignedCalledTokenRules»
				«IF (i = i + 1) > 1»else «ENDIF»if(ruleCall.getRule() == grammarAccess.«rule.gaAccessor»)
					return «rule.unassignedCalledTokenRuleName»(ruleCall, node);
			«ENDFOR»
			return "";
		}
	'''
	
	def genGetUnassignedRuleCallToken(JavaFile file, AbstractRule rule) '''
		protected String «rule.unassignedCalledTokenRuleName»(RuleCall ruleCall, INode node) {
			return "«rule.alternatives.defaultValue(newHashSet)»";
		}
	'''
	
	def genEmitUnassignedTokens(JavaFile file) '''
		@Override
		protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
			if (!transition.isSyntacticallyAmbiguous())
				return;
			«var i = 0»
			«FOR group:util.allAmbiguousTransitionsBySyntax.entrySet»
				«IF (i = i + 1) > 1»else «ENDIF»if(match_«group.key.elementAliasToIdentifyer».equals(transition.getAmbiguousSyntax()))
					emit_«group.key.elementAliasToIdentifyer»(semanticObject, transition, fromNode, toNode);
			«ENDFOR»
			«IF i > 0»else «ENDIF»acceptNodes(transition, fromNode, toNode);
		}
	'''
}

