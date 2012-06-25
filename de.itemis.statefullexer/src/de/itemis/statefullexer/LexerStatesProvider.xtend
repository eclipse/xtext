package de.itemis.statefullexer

import com.google.common.collect.LinkedHashMultimap
import com.google.common.collect.Multimap
import com.google.common.collect.Multimaps
import java.util.List
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.Data
import org.eclipse.xtend.lib.Property
import org.eclipse.xtext.AbstractElement
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.ParserRule
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.TerminalRule
import org.eclipse.xtext.grammaranalysis.impl.CfgAdapter
import org.eclipse.xtext.util.formallang.FollowerFunctionImpl
import org.eclipse.xtext.util.formallang.NfaFactory
import org.eclipse.xtext.util.formallang.NfaUtil
import org.eclipse.xtext.util.formallang.Pda
import org.eclipse.xtext.util.formallang.PdaFactory
import org.eclipse.xtext.util.formallang.PdaUtil
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
		val matches = rule.space
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
	
	def Pda<TokenPDA$TokenPDAState<AbstractElement>, RuleCall> getPda(Grammar grammar) {
		val cfg = new StatesCfgAdapter(grammar)
		val ff = new FollowerFunctionImpl(cfg).setFilter[it instanceof Keyword || it instanceof RuleCall]
		val pdaFact = new TokenPDA$TokenPDAFactory<AbstractElement, RuleCall>() as PdaFactory<Pda<TokenPDA$TokenPDAState<AbstractElement>, RuleCall>, TokenPDA$TokenPDAState<AbstractElement>, RuleCall, AbstractElement>
		val pda = new PdaUtil2().create(cfg, ff, pdaFact)
		pda
	}
	
	def NfaWithGroups<AbstractRule, TokenNFA$TokenNfaState<AbstractElement>> getNfa(Grammar grammar) {
		val pda = getPda(grammar)
		val fact =  new TokenGroupNFA$TokenGroupNfaFactory<AbstractRule, AbstractElement>() as NfaFactory<NfaWithGroups<AbstractRule, TokenNFA$TokenNfaState<AbstractElement>>, TokenNFA$TokenNfaState<AbstractElement>, AbstractElement>
		val traverser = new LaxicalGroupsTraverser(grammar.rules.get(0))
		val filter = [TokenPDA$TokenPDAState<AbstractElement> s | !s.token.parserRuleCall ]
		val token = [TokenPDA$TokenPDAState<AbstractElement> s | s.token ] 
		val nfa = new NfaUtil2().create(pda, traverser, filter, token, fact)
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

class LaxicalGroupsTraverserItem  {
	@Property val LaxicalGroupsTraverserItem parent
	@Property val RuleCall item
	@Property val AbstractRule group

	new(AbstractRule group) {
		this._parent = null
		this._item = null
		this._group = group
	}

	new(LaxicalGroupsTraverserItem parent, RuleCall item, AbstractRule group) {
		super();
		this._parent = parent;
		this._item = item;
		this._group = group
	}

	def LaxicalGroupsTraverserItem push(RuleCall item) {
		var count = 0;
		var current = this;
		while (current != null) {
			if (current.item == item)
				count = count + 1
			current = current.parent;
		}
		if (count >= 2)
			return null;
		val g = if(item.rule.isSpace) item.rule else group 
		return new LaxicalGroupsTraverserItem(this, item, g);
	}

	def LaxicalGroupsTraverserItem pop(RuleCall item) {
		if (parent == null || this.item != item)
			return null;
		return parent;
	}
}

@Data class LaxicalGroupsTraverser implements GroupingTraverser<Pda<TokenPDA$TokenPDAState<AbstractElement>, RuleCall>, TokenPDA$TokenPDAState<AbstractElement>, LaxicalGroupsTraverserItem, AbstractRule> {
	val AbstractRule group
	
	override getGroup(LaxicalGroupsTraverserItem result) {
		result.group
	}
			
	override enter(Pda<TokenPDA$TokenPDAState<AbstractElement>,RuleCall> pda, TokenPDA$TokenPDAState<AbstractElement> state, LaxicalGroupsTraverserItem previous) {
		var RuleCall item;
		if ((item = pda.getPush(state)) != null)
			return previous.push(item)
		if ((item = pda.getPop(state)) != null)
			return previous.pop(item)
		if (previous == null)
			return new LaxicalGroupsTraverserItem(_group) 
		return previous;
	}
			
	override isSolution(LaxicalGroupsTraverserItem result) {
		return result.parent == null;
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
	
	def static isSpace(AbstractRule rule) {
		rule.name.toLowerCase.startsWith("lexicalspace")
	}
}

@Data class LexerStateNfa implements ILexerStatesProvider$ILexerStates {
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
