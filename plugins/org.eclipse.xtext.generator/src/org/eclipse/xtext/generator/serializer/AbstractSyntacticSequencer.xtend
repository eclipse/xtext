/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
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
import org.eclipse.xtext.util.Strings

import static extension org.eclipse.xtext.GrammarUtil.*
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.nodemodel.ILeafNode
import org.eclipse.xtext.nodemodel.ICompositeNode

class AbstractSyntacticSequencer extends GeneratedFile {
	
	@Inject Grammar grammar
	
	@Inject extension GrammarAccess grammarAccess
	
	@Inject extension SyntacticSequencerUtil util
	
	override getFileContents(SerializerGenFileNames$GenFileName filename) {
		val file = new JavaFile(filename.packageName);
		
		file.imported(typeof(org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer))
		file.imported(typeof(RuleCall))
		file.imported(typeof(INode))
		file.imported(typeof(ISyntacticSequencerPDAProvider$ISynTransition))
		file.imported(typeof(Inject))
		file.imported(typeof(IGrammarAccess))
		file.imported(typeof(EObject))
		file.imported(typeof(List))
		file.imported(typeof(GrammarAlias$AbstractElementAlias))
		
		val _abstract = if (filename.isAbstract) "abstract " else ""
		file.body = '''
			@SuppressWarnings("all")
			public «_abstract»class «filename.simpleName» extends AbstractSyntacticSequencer {
			
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
				
				«FOR rule:unassignedCalledTokenRules SEPARATOR "\n"»
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
	
	def List<AbstractRule> unassignedCalledTokenRules() {
		val rules = grammar.allRules.filter[EObjectRule]
		val calls = rules.map(r|r.containedRuleCalls.filter(e|isUnassignedRuleCall(e))).flatten
		calls.map[rule].toSet.sortBy[name]
	}
	
	def boolean isUnassignedRuleCall(RuleCall c) {
		if(c.isEObjectRuleCall()) return false
		val ass = c.containingAssignment
		ass == null || ass.isBooleanAssignment 
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
	
	def textWithoutComments(INode node) {
		switch node {
			ILeafNode case !node.hidden || node.text.trim.length == 0: node.text
			ICompositeNode: node.children.map[textWithoutComments].join
			default: ""
		}
	}
	
	def genGetUnassignedRuleCallToken(JavaFile file, AbstractRule rule) '''
		/**
		 * «NodeModelUtils::getNode(rule).textWithoutComments.trim.replace("\n", "\n* ")»
		 */
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