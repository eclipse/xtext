package de.itemis.statefullexer

import com.google.common.collect.LinkedHashMultimap
import com.google.common.collect.Multimap
import com.google.common.collect.Multimaps
import com.google.common.collect.Sets
import java.util.Collection
import java.util.List
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.Data
import org.eclipse.xtext.AbstractElement
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.ParserRule
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.TerminalRule
import org.eclipse.xtext.grammaranalysis.impl.CfgAdapter
import org.eclipse.xtext.util.formallang.FollowerFunctionImpl
import org.eclipse.xtext.util.formallang.Nfa
import org.eclipse.xtext.util.formallang.NfaFactory
import org.eclipse.xtext.util.formallang.NfaUtil
import org.eclipse.xtext.xbase.lib.Pair

import static extension de.itemis.statefullexer.Util.*
import static extension org.eclipse.xtext.EcoreUtil2.*
import static extension org.eclipse.xtext.GrammarUtil.*

class LexerStatesProvider implements ILexerStatesProvider {
	
	override getStates(Grammar grammar) {
		val owner2terminal = grammar.terminalOwner
		val followers = grammar.followerMap
		val result = createNfa(owner2terminal, followers)
		val ambiguous = result.ambiguousTransitions
		if(ambiguous.empty)
			return result
		val solutions = newArrayList(result)
		for(r: new NfaUtil2().getAllTransitions(result)) {
			val m = mutateFollowers(owner2terminal, r, followers)
			val n = createNfa(m, followers)
			solutions.add(n)
			if(n.ambiguousTransitions.empty)
				return n;
		}
		println(solutions.join("\n"))
		println("Could not determine unambiguous lexer states")
		result
	}
	
	def private mutateFollowers(Multimap<AbstractRule, EObject> owner2terminal, ILexerStatesProvider$ILexerStateTransition transition, Multimap<AbstractElement, AbstractElement> followers){
		val newOwner2terminal = LinkedHashMultimap::create(owner2terminal)
		for(f: followers.get(transition.element))
			if(transition.target.elements.contains(f)) {
				newOwner2terminal.remove(transition.target.rule, f)
				newOwner2terminal.put(transition.source.rule, f)
			}
		newOwner2terminal
	}
	
	def private createNfa(Multimap<AbstractRule, EObject> owner2terminal, Multimap<AbstractElement, AbstractElement> followers) {
		val terminal2owner = Multimaps::invertFrom(owner2terminal, LinkedHashMultimap::create)
		val state2terminal = LinkedHashMultimap::<AbstractRule, EObject>create
		val transitions = LinkedHashMultimap::<AbstractRule, Pair<AbstractElement, AbstractRule>>create
		for(e:owner2terminal.entries) { 
			val t = e.value
			val from = e.key
			switch(t) {
				AbstractElement: {
					val followerstates = followers.get(t).map[terminal2owner.get(it)].flatten.toSet
					for(to:followerstates) 
						if(from == to)
							state2terminal.put(from, t)
						else 
							transitions.put(from, t -> to)
				}
				AbstractRule: {
//					println(e)
					state2terminal.put(from, t)
				}
			}
		}
		var i = -1
		val states = <AbstractRule, LexerState>newLinkedHashMap()
		for(e:state2terminal.asMap.entrySet) 
			states.put(e.key, new LexerState(i = i + 1, e.key, newArrayList(), e.value.toSet))
		for(t:transitions.entries) {
			var from = states.get(t.key) 
			var to = states.get(t.value.value)
			if(from == null)
				states.put(t.key, from = new LexerState(i = i + 1, t.key, newArrayList(), newHashSet()))
			if(to == null)
				states.put(t.value.value, to = new LexerState(i = i + 1, t.key, newArrayList(), newHashSet()))
			from.outgoingTransitions.add(new LexerStateTransition(t.value.key, from, to))
		}
		val start = states.values.iterator.next
		new LexerStateNfa( /* owner2terminal, */start, start)
	}
	
//	def private getFirstSolution(Grammar grammar, Multimap<AbstractElement, AbstractElement> followers) {
//		val owner2terminal = grammar.terminalOwner
//		val terminal2owner = Multimaps::invertFrom(owner2terminal, HashMultimap::create)
//		
//		val state2terminal = HashMultimap::<AbstractRule, AbstractElement>create
//		val transitions = HashMultimap::<AbstractRule, Pair<AbstractElement, AbstractRule>>create
//		for(t:owner2terminal.values) {
//			val states = terminal2owner.get(t).toSet
//			val followerstates = followers.get(t).map[terminal2owner.get(it)].flatten.toSet
//			for(from:states)
//				for(to:followerstates) 
//					if(from == to)
//						state2terminal.put(from, t)
//					else 
//						transitions.put(from, t -> to)
//		}
//		new Solution(state2terminal, transitions)
//	}
	
	def private List<AbstractRule> getHidden(Grammar grammar) {
		if(!grammar.hiddenTokens.empty)
			grammar.hiddenTokens
		else if(!grammar.usedGrammars.empty) 
			grammar.usedGrammars.get(0).hidden
		else 
			emptyList
	}
	
	def private Multimap<AbstractRule, EObject> getTerminalOwner(Grammar grammar) {
		val result = LinkedHashMultimap::<AbstractRule, EObject>create()
		val startrule = grammar.allParserRules.get(0)
		val starthidden = grammar.hidden
		collectTerminalOwner(startrule, startrule, result, starthidden, newHashSet)
		result
	}
	
	def private void collectTerminalOwner(AbstractRule rule, AbstractRule owner, Multimap<AbstractRule, EObject> owner2terminal, List<AbstractRule> hidden, Set<Pair<AbstractRule, AbstractRule>> visited) {
		val matches = rule.name.toLowerCase.startsWith("lexicalspace")
		val newOwner = if(matches) rule else owner
		if(!visited.add(rule -> owner)) 
			return;
		val definesHidden = rule instanceof ParserRule && (rule as ParserRule).definesHiddenTokens
		val newHidden = if(definesHidden) (rule as ParserRule).hiddenTokens else hidden
		if(matches || definesHidden)
			for(h:newHidden)
				owner2terminal.put(newOwner, h)
		for(e:rule.eAllContentsAsList)
			switch(e) {
				Keyword: owner2terminal.put(newOwner, e)
				RuleCall case e.rule instanceof TerminalRule: owner2terminal.put(newOwner, e)
				RuleCall: collectTerminalOwner(e.rule, newOwner, owner2terminal, newHidden, visited)
			}
	}
	
	def private Multimap<AbstractElement, AbstractElement> getFollowerMap(Grammar grammar) {
		val nfa = grammar.nfa
		val result = LinkedHashMultimap::<AbstractElement, AbstractElement>create()
		for(e: new NfaUtil().collect(nfa))
			for(f:nfa.getFollowers(e))
				result.put(e.token, f.token)
		result
	}
	
	def Nfa<NfaUtil2$TokenNfaState<AbstractElement>> getNfa(Grammar grammar) {
		val cfg = new StatesCfgAdapter(grammar)
		val ff = new FollowerFunctionImpl(cfg).setFilter[it instanceof Keyword || it instanceof RuleCall]
		val fact =  new NfaUtil2$TokenNFAFactory<AbstractElement>() as NfaFactory<Nfa<NfaUtil2$TokenNfaState<AbstractElement>>, NfaUtil2$TokenNfaState<AbstractElement>, AbstractElement>
		val nfa = new NfaUtil2().create(cfg, ff, fact)
		nfa
	} 
}

class StatesCfgAdapter extends CfgAdapter {
	new(Grammar grammar) {
		super(grammar)
	}
	
	override getCall(AbstractElement ele) {
		if(ele instanceof RuleCall) {
			val rc = ele as RuleCall
			if(rc.rule instanceof TerminalRule)
				return null
			else
				return rc.rule.alternatives
		}
		return null;
	}
}

class Util {
	def static getToken(EObject ele) {
		switch(ele) { 
			RuleCall: ele.rule 
			Keyword: ele.value
			AbstractRule: ele
		}
	}
	
	def static getTokenName(Object ele) {
		switch(ele) { 
			RuleCall: ele.rule.name 
			Keyword: ele.value
			TerminalRule: ele.name
			String: ele
		}
	}
}

@Data
class Solution {
	Multimap<AbstractRule, AbstractElement> state2terminal
	Multimap<AbstractRule, Pair<AbstractElement, AbstractRule>> transitions
	
	
	
	def getStateTokens(AbstractRule state) {
		state2terminal.get(state).map[token].toSet
	}
	
	def getTransitionTokens(AbstractRule state) {
		transitions.get(state).map[key.token].toSet
	}
	
	def getQuality() {
		state2terminal.keySet.map[Sets::intersection(stateTokens, transitionTokens).size].reduce([Integer i, Integer j| i + j])
	}
	
	def getAmbiguousTransitions() {
		transitions.entries.filter[key.stateTokens.contains(value.key.token)]
	}
	
	def mutateForward(AbstractRule sourceState, AbstractElement element, Collection<AbstractElement> followers){
		println('''mutateForward(«sourceState.name», «element.tokenName», {«followers.map[tokenName].join(", ")»})''')
		val newstate2terminal = LinkedHashMultimap::create(state2terminal)
		val newtransitions = LinkedHashMultimap::create(transitions)
//		val sourceStates = transitions.entries.filter([value.key == element]).map[key].toSet	
		val targetStates = transitions.values.filter([key == element]).map[value].toSet	
		for(e:newstate2terminal.entries.toList)
			if(followers.contains(e.value))
				newstate2terminal.remove(e.key, e.value) 
		for(e:newtransitions.entries.toList)
			if(e.key == sourceState && e.value.key == element)
				newtransitions.remove(e.key, e.value)
//		for(s:sourceStates) { 
			newstate2terminal.put(sourceState, element)
			for(f:followers)
				for(t:targetStates) 
					transitions.put(sourceState, f -> t)
//		}
		val result = new Solution(newstate2terminal, newtransitions)
		println(result)
		result 
	}
	
//	def toNfa() {
//		var i = 0
//		val states = <AbstractRule, LexerState>newLinkedHashMap()
//		for(e:state2terminal.asMap.entrySet) 
//			states.put(e.key, new LexerState(i = i + 1, newArrayList(), e.value.map[token].toSet))
//		for(t:transitions.entries) {
//			var from = states.get(t.key) 
//			var to = states.get(t.value.value)
//			if(from == null)
//				states.put(t.key, from = new LexerState(i = i + 1, newArrayList(), newHashSet()))
//			if(to == null)
//				states.put(t.value.value, to = new LexerState(i = i + 1, newArrayList(), newHashSet()))
//			from.outgoingTransitions.add(new LexerStateTransition(t.value.key.token, to))
//		}
//		val start = states.values.iterator.next
//		new LexerStateNfa(null, start, start)
//	}
	
	override toString() '''
		Solution {
			«FOR t:ambiguousTransitions»
				Ambiguous Transition: «t.key.name» ---«t.value.key.tokenName»---> «t.value.value.name»
			«ENDFOR»
			«FOR s:state2terminal.asMap.entrySet»
				State «s.key.name»: «s.value.map[tokenName].join(", ")»
			«ENDFOR»
			«FOR t:transitions.entries»
				Transition: «t.key.name» ---«t.value.key.tokenName»---> «t.value.value.name»
			«ENDFOR»
		}
	'''
}

@Data class LexerStateNfa implements ILexerStatesProvider$ILexerStates {
//	Multimap<AbstractRule, EObject> owner2terminal
	ILexerStatesProvider$ILexerState start
	ILexerStatesProvider$ILexerState stop
	
	override getOutgoingTransitions(ILexerStatesProvider$ILexerState state) {
		state.outgoingTransitions
	}
	
	override getTarget(ILexerStatesProvider$ILexerStateTransition trans) {
		trans.target
	}
	
	override getFollowers(ILexerStatesProvider$ILexerState state) {
		state.outgoingTransitions.map[target]
	}
	
	def getAmbiguousTransitions() {
		new NfaUtil2().getAllTransitions(this).filter[source.tokens.contains(token)]
	}
	
	override toString() '''
		Solution {
			«FOR t:ambiguousTransitions»
				Ambiguous Transition: «t.source.rule.name» ---«t.token.tokenName»---> «t.target.rule.name»
			«ENDFOR»
			«FOR s:allStates»
				State «s.rule.name»: «s.tokens.map[tokenName].join(", ")»
			«ENDFOR»
			«FOR t:new NfaUtil2().getAllTransitions(this)»
				Transition: «t.source.rule.name» ---«t.token.tokenName»---> «t.target.rule.name»
			«ENDFOR»
		}
	'''

	override getAllStates() {
		new NfaUtil().collect(this)
	}
	
}

@Data class LexerState implements ILexerStatesProvider$ILexerState {
	int ID
	AbstractRule rule
	List<ILexerStatesProvider$ILexerStateTransition> outgoingTransitions
	Set<EObject> elements
	
	override toString() {
		tokens.map[switch(it) { String: it TerminalRule: it.name }].join(", ")
	}	
	
	override hashCode() {
		ID
	}

	override getTokens() {
		elements.map[token].toSet
	}
	
} 

@Data class LexerStateTransition implements ILexerStatesProvider$ILexerStateTransition {
	AbstractElement element
	ILexerStatesProvider$ILexerState source
	ILexerStatesProvider$ILexerState target
	
	override toString() {
		switch(token) {
			String: token
			TerminalRule: token.name
		}
	}

	override getToken() {
		element.token
	}
	
} 
