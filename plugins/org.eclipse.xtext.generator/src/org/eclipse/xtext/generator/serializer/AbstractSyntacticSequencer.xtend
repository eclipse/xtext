package org.eclipse.xtext.generator.serializer

import com.google.inject.Inject
import java.util.List
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.AbstractElement
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.Alternatives
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.Group
import org.eclipse.xtext.IGrammarAccess
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.generator.grammarAccess.GrammarAccess
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.serializer.analysis.GrammarAlias
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer
import org.eclipse.xtext.util.Strings

import static extension org.eclipse.xtext.GrammarUtil.*

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
		
		file.imported(typeof(org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer))
		file.imported(typeof(RuleCall))
		file.imported(typeof(INode))
		file.imported(typeof(ISyntacticSequencerPDAProvider$ISynTransition))
		file.imported(typeof(Inject))
		file.imported(typeof(IGrammarAccess))
		file.imported(typeof(EObject))
		file.imported(typeof(List))
		file.imported(typeof(GrammarAlias$AbstractElementAlias))
		
		file.body = '''
			@SuppressWarnings("restriction")
			public class «simpleName» extends AbstractSyntacticSequencer {
			
				protected «file.imported(grammar.gaFQName)» grammarAccess;
				«FOR group:util.allAmbiguousTransitionsBySyntax»
					protected «file.imported("org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias")» match_«group.first»;
				«ENDFOR»
				
				@Inject
				protected void init(IGrammarAccess access) {
					grammarAccess = («file.imported(grammar.gaFQName)») access;
					«FOR group:util.allAmbiguousTransitionsBySyntax»
						match_«group.first» = « group.second.elementAliasToConstructor(file)»;
					«ENDFOR»
				}
				
				«file.genGetUnassignedRuleCallTokens()»
				
				«FOR rule:unassignedCalledTokenRules»
					«file.genGetUnassignedRuleCallToken(rule)»
				«ENDFOR»
				
				«file.genEmitUnassignedTokens()»
			
				«FOR group:util.allAmbiguousTransitionsBySyntax»
					/**
					 * Syntax:
					 *     «group.second»
					 */
					protected void emit_«group.first»(EObject semanticObject, «file.imported(typeof(ISyntacticSequencerPDAProvider$ISynNavigable))» transition, List<INode> nodes) {
						acceptNodes(transition, nodes);
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
		calls.map(e | e.rule).toSet.sort(r1, r2 | r1.name.compareTo(r2.name))
	}
	
	def unassignedCalledTokenRuleName(AbstractRule rule) '''get«rule.name»Token'''
	
	def String defaultValue(AbstractElement ele, Set<AbstractElement> visited) {
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
		protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
			«var i = 0»
			«FOR rule:unassignedCalledTokenRules»
				«IF (i = i + 1) > 1»else «ENDIF»if(ruleCall.getRule() == grammarAccess.«rule.gaAccessor»)
					return «rule.unassignedCalledTokenRuleName»(semanticObject, ruleCall, node);
			«ENDFOR»
			return "";
		}
	'''
	
	def genGetUnassignedRuleCallToken(JavaFile file, AbstractRule rule) '''
		protected String «rule.unassignedCalledTokenRuleName»(EObject semanticObject, RuleCall ruleCall, INode node) {
			if (node != null)
				return getTokenText(node);
			return "«Strings::convertToJavaString(rule.alternatives.defaultValue(newHashSet))»";
		}
	'''
	
	def genEmitUnassignedTokens(JavaFile file) '''
		@Override
		protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
			if (transition.getAmbiguousSyntaxes().isEmpty()) return;
			List<INode> transitionNodes = collectNodes(fromNode, toNode);
			for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
				List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
				«var i = 0»
				«FOR group:util.allAmbiguousTransitionsBySyntax»
					«IF (i = i + 1) > 1»else «ENDIF»if(match_«group.first».equals(syntax))
						emit_«group.first»(semanticObject, getLastNavigableState(), syntaxNodes);
				«ENDFOR»
				«IF i > 0»else «ENDIF»acceptNodes(getLastNavigableState(), syntaxNodes);
			}
		}
	'''
}