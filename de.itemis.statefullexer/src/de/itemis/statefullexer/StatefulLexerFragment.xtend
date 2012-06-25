package de.itemis.statefullexer

import org.eclipse.xpand2.XpandExecutionContext
import org.eclipse.xtext.AbstractElement
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.TerminalRule
import org.eclipse.xtext.generator.Generator
import org.eclipse.xtext.generator.parser.antlr.AntlrGrammarGenUtil
import org.eclipse.xtext.generator.parser.antlr.ex.ExternalAntlrLexerFragment
import org.eclipse.xtext.generator.parser.antlr.ex.common.KeywordHelper
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch

import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.generator.parser.antlr.TerminalRuleToLexerBody.*
import static extension org.eclipse.xtext.util.Strings.*
import static de.itemis.statefullexer.TokenNFA$NFAStateType.*

class StatefulLexerFragment extends ExternalAntlrLexerFragment {
	
	override generate(Grammar grammar, XpandExecutionContext ctx) {
		println("begin")
		new KeywordHelper(grammar, false);
		lexerGrammar = grammar.namespace + ".lexer." + grammar.name.lastToken(".") + "Lexer"
		val srcGen = if (contentAssist || highlighting) Generator::SRC_GEN_UI else Generator::SRC_GEN;
		val srcGenPath = ctx.output.getOutlet(srcGen).getPath();
		val grammarFile = lexerGrammar.replace('.', '/') + ".g";
		println("writing " + grammarFile)

		val nfa2dot = new NfaToDot2()
		nfa2dot.stateFormatter.add[TokenNFA$TokenNfaState<AbstractElement> s | 
			switch(s.type) { 
				case(START): "start"
				case(ELEMENT): new GrammarElementTitleSwitch().doSwitch(s.token)
				case(STOP): "stop"
			}
		]
		nfa2dot.groupFormatter.add[AbstractRule r | r.name]
		val nfa1 = new LexerStatesProvider().getNfa(grammar)
		ctx.output.openFile(lexerGrammar.replace('.', '/') + "GrammarNfa.dot", srcGen)
		ctx.output.write(nfa2dot.draw(nfa1))
		ctx.output.closeFile()

		val nfa = new LexerStatesProvider().getStates(grammar)
		ctx.output.openFile(lexerGrammar.replace('.', '/') + "States.dot", srcGen)
		ctx.output.write(new NfaToDot2().draw(nfa))
		ctx.output.closeFile()

		ctx.output.openFile(grammarFile, srcGen)
		ctx.output.write(genLexer(grammar, nfa).toString)
		ctx.output.closeFile()

		var generateTo = if (lexerGrammar.lastIndexOf('.') != -1) lexerGrammar.substring(0, lexerGrammar.lastIndexOf('.')) else "";
		generateTo = srcGenPath + "/" + generateTo.replace('.', '/');
		addAntlrParam("-fo");
		addAntlrParam(generateTo);
		getAntlrTool().runWithParams(srcGenPath + "/" + grammarFile, getAntlrParams());

		val javaFile = srcGenPath+"/"+getLexerGrammar().replace('.', '/')+".java";
		suppressWarningsImpl(javaFile);
		
		println("end")
	}
	
	def create it: <AbstractRule, Integer>newHashMap() getRule2Index(Grammar grammar) {
		var i = -1
		for(rule:grammar.allRules)
			put(rule, i = i + 1)
	}
	
	def getStateTokens(Grammar grammar, ILexerStatesProvider$ILexerState state) {
		val rule2index = grammar.rule2Index
		val transitionTokens = state.outgoingTransitions.map[it.token -> it]
		val stateTokens = state.tokens.map[it -> null as ILexerStatesProvider$ILexerStateTransition]
		val tokens = stateTokens + transitionTokens
		tokens.sortBy[switch(it.key) { AbstractRule: rule2index.get(it.key) String: 0 }]
	}
	
	def getStatelessTerminalRules(Grammar grammar, ILexerStatesProvider$ILexerStates nfa) {
		val stateful = nfa.allStates.map[tokens + outgoingTransitions.map[token]].flatten.filter(typeof(TerminalRule)).toSet
		grammar.allTerminalRules.filter[!stateful.contains(it)]
	}
	
	def genLexer(Grammar grammar, ILexerStatesProvider$ILexerStates nfa) '''
		lexer grammar «lexerGrammar.lastToken(".")»;
		
		options {
			tokenVocab=Internal«lexerGrammar.lastToken(".")»;
		}
		
		@header {
		package «lexerGrammar.skipLastToken(".")»;
		
		// Use our own Lexer superclass by means of import. 
		import org.eclipse.xtext.parser.antlr.Lexer;
		}
		
		@members{
			«FOR s: nfa.allStates»
				// state «s.rule.name» = «s.ID»
			«ENDFOR»
			private int tokenstate = «nfa.start.ID»;
		}
		
		«FOR s: nfa.allStates»
			// state «s.rule.name» («s.ID») {
				«FOR t: getStateTokens(grammar, s)»
					«genToken(grammar, s, t.key, t.value)»
				«ENDFOR»
			// }
			
		«ENDFOR»
		
		«FOR rule:getStatelessTerminalRules(grammar, nfa)»
			RULE_«rule.name»: «rule.toLexerBody»;
		«ENDFOR»
	'''
	
	def guardAction(ILexerStatesProvider$ILexerState state) {
		"{tokenstate==" + state.ID + "}?=>"
	}
	
	def transitionAction(ILexerStatesProvider$ILexerStateTransition trans) {
		"{tokenstate=" + trans.target.ID + ";}"
	}
	
	def dispatch genToken(Grammar grammar, ILexerStatesProvider$ILexerState state, String keyword, Void NULL) '''
		«val keywords = KeywordHelper::getHelper(grammar)»
		«keywords.getRuleName(keyword)»: «state.guardAction» '«AntlrGrammarGenUtil::toAntlrString(keyword)»';
	'''
	
	def dispatch genToken(Grammar grammar, ILexerStatesProvider$ILexerState state, TerminalRule rule, Void NULL) '''
		RULE_«rule.name»: «state.guardAction» «rule.toLexerBody»;
	'''
	
	def dispatch genToken(Grammar grammar, ILexerStatesProvider$ILexerState state, String keyword, ILexerStatesProvider$ILexerStateTransition trans) '''
		«val keywords = KeywordHelper::getHelper(grammar)»
		«keywords.getRuleName(keyword)»: «state.guardAction» '«AntlrGrammarGenUtil::toAntlrString(keyword)»' «trans.transitionAction»;
	'''
	
	def dispatch genToken(Grammar grammar, ILexerStatesProvider$ILexerState state, TerminalRule rule, ILexerStatesProvider$ILexerStateTransition trans) '''
		RULE_«rule.name»: «state.guardAction» «rule.toLexerBody»  «trans.transitionAction»;
	'''
}