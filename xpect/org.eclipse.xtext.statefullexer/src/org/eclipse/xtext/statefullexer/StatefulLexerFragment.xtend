package org.eclipse.xtext.statefullexer

import java.util.Set
import org.eclipse.xpand2.XpandExecutionContext
import org.eclipse.xtext.AbstractElement
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.TerminalRule
import org.eclipse.xtext.generator.Generator
import org.eclipse.xtext.generator.parser.antlr.AntlrGrammarGenUtil
import org.eclipse.xtext.generator.parser.antlr.ex.ExternalAntlrLexerFragment
import org.eclipse.xtext.generator.parser.antlr.ex.common.KeywordHelper
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch
import org.eclipse.xtext.util.formallang.PdaToDot
import org.eclipse.xtext.xbase.lib.Pair

import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.generator.parser.antlr.TerminalRuleToLexerBody.*
import static extension org.eclipse.xtext.util.Strings.*

class StatefulLexerFragment extends ExternalAntlrLexerFragment { //	override getGuiceBindingsRt(Grammar grammar) {
	//		if (runtime)
	//			return new BindFactory()
	//				.addConfiguredBinding("RuntimeLexer",
	//						"binder.bind(" + typeof(Lexer).getName() + ".class)"+
	//						".annotatedWith(com.google.inject.name.Names.named(" +
	//						"org.eclipse.xtext.parser.antlr.LexerBindings.RUNTIME" +
	//						")).to(" + lexerGrammar +".class)")
	//					.addTypeToType(typeof(Lexer).getName(), lexerGrammar)
	//			.addTypeToProviderInstance(lexerGrammar, "org.eclipse.xtext.parser.antlr.LexerProvider.create(" + lexerGrammar + ".class)")
	//				.getBindings();
	//	}
	String lexerBaseClass;

	def setLexerBaseClass(String clazz) {
		this.lexerBaseClass = clazz
	}

	override generate(Grammar grammar, XpandExecutionContext ctx) {

		//		println("begin")
		new KeywordHelper(grammar, false);
		lexerGrammar = grammar.namespace + ".lexer." + grammar.name.lastToken(".") +
			(if(runtime) "RT" else if(contentAssist) "CA" else "HI")
		val srcGen = if(contentAssist || highlighting) Generator::SRC_GEN_UI else Generator::SRC_GEN;
		val srcGenPath = ctx.output.getOutlet(srcGen).getPath();
		val grammarFile = lexerGrammar.replace('.', '/') + ".g";

		//		println("writing " + grammarFile)
		val nfa2dot = new NfaToDot2()
		nfa2dot.stateFormatter.add [ TokenNFA$TokenNfaState<AbstractElement> s |
			switch (s.type) {
				case (TokenNFA$NFAStateType::START): "start"
				case (TokenNFA$NFAStateType::ELEMENT): new GrammarElementTitleSwitch().doSwitch(s.token)
				case (TokenNFA$NFAStateType::STOP): "stop"
			}
		]
		nfa2dot.groupFormatter.add[LexicalGroup r|r.group.name + "\\n" + r.hidden.map[name].join(", ")]

		val pda2dot = new PdaToDot<TokenPDA$TokenPDAState<AbstractElement>, RuleCall>()
		pda2dot.setStateFormatter [
			switch (type) {
				case (TokenPDA$PDAStateType::START):
					"start"
				case (TokenPDA$PDAStateType::ELEMENT):
					new GrammarElementTitleSwitch().showQualified.showAssignments.doSwitch(token)
				case (TokenPDA$PDAStateType::PUSH):
					new GrammarElementTitleSwitch().showQualified.showAssignments.doSwitch(token)
				case (TokenPDA$PDAStateType::POP):
					new GrammarElementTitleSwitch().showQualified.showAssignments.doSwitch(token)
				case (TokenPDA$PDAStateType::STOP):
					"stop"
			}
		]
		val pda = new LexerStatesProvider().getPda(grammar)
		ctx.output.openFile(lexerGrammar.replace('.', '/') + "GrammarPda.dot", srcGen)
		ctx.output.write(pda2dot.draw(pda))
		ctx.output.closeFile()

		nfa2dot.groupFormatter.add[AbstractRule r|r.name]
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

		var generateTo = if (lexerGrammar.lastIndexOf('.') != -1)
				lexerGrammar.substring(0, lexerGrammar.lastIndexOf('.'))
			else
				"";
		generateTo = srcGenPath + "/" + generateTo.replace('.', '/');
		addAntlrParam("-fo");
		addAntlrParam(generateTo);
		getAntlrTool().runWithParams(srcGenPath + "/" + grammarFile, getAntlrParams());

		val javaFile = srcGenPath + "/" + getLexerGrammar().replace('.', '/') + ".java";
		suppressWarningsImpl(javaFile);
	}

	def create it: <AbstractRule, Integer>newHashMap() getRule2Index(Grammar grammar) {
		var i = -1
		for (rule : grammar.allRules)
			put(rule, i = i + 1)
	}

	def getStateTokens(Grammar grammar, ILexerStatesProvider$ILexerStates nfa) {
		val groups = <Pair<Object, ILexerStatesProvider$ILexerState>, Token>newLinkedHashMap()
		for (s : nfa.allStates) {
			for (t : s.tokens) {
				var x = groups.get(t -> null)
				if (x == null)
					groups.put(t -> null, x = new Token(newLinkedHashSet(), t, null))
				x.sources.add(s)
			}
			for (t : nfa.getOutgoingTransitions(s)) {
				var x = groups.get(t.token -> t.target)
				if (x == null)
					groups.put(t.token -> t.target, x = new Token(newLinkedHashSet(), t.token, t.target))
				x.sources.add(s)
			}
		}
		val rule2index = grammar.rule2Index
		groups.values.sortBy[switch (it.token) { AbstractRule: rule2index.get(it.token) String: 0 }]
	}

	def getStatelessTerminalRules(Grammar grammar, ILexerStatesProvider$ILexerStates nfa) {
		val stateful = nfa.allStates.map[tokens + outgoingTransitions.map[token]].flatten.filter(
			typeof(TerminalRule)).toSet
		grammar.allTerminalRules.filter[!stateful.contains(it)]
	}

	def genLexer(Grammar grammar, ILexerStatesProvider$ILexerStates nfa) '''
		lexer grammar «lexerGrammar.lastToken(".")»;
		
		options {
			tokenVocab=Internal«grammar.name.lastToken(".") + "Lexer"»;
		}
		
		@header {
		package «lexerGrammar.skipLastToken(".")»;
		
		// Use our own Lexer superclass by means of import.
		«IF contentAssist»
			import «lexerBaseClass ?: "org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer"»;
		«ELSE» 
			import «lexerBaseClass ?: "org.eclipse.xtext.parser.antlr.Lexer"»;
		«ENDIF»
		}
		
		@members{
			«FOR s : nfa.allStates»
				// state «s.name» = «s.ID»
			«ENDFOR»
			private int tokenstate = «nfa.start.ID»;
		}
		
		«FOR s : getStateTokens(grammar, nfa)»
			«genToken(grammar, s.sources, s.token, s.target)»
		«ENDFOR»
		
		«FOR rule : getStatelessTerminalRules(grammar, nfa)»
			RULE_«rule.name»: «rule.toLexerBody»;
		«ENDFOR»
	'''

	def int toBitmask(Set<ILexerStatesProvider$ILexerState> sources) {
		sources.map[ID].reduce[Integer a, Integer b|a + b]
	}

	def guardAction(Set<ILexerStatesProvider$ILexerState> sources) {
		"{(tokenstate & " + sources.toBitmask + ") != 0}?=>"
	}

	def guardAction(Set<ILexerStatesProvider$ILexerState> sources, String keyword) {
		"{(tokenstate & " + sources.toBitmask + ") != 0 && matches(\"" + keyword + "\")}?=>"
	}

	def transitionAction(ILexerStatesProvider$ILexerState target) {
		"{tokenstate=" + target.ID + ";}"
	}

	def dispatch genToken(Grammar grammar, Set<ILexerStatesProvider$ILexerState> sources, String keyword, Void NULL) '''
		«val keywords = KeywordHelper::getHelper(grammar)»
		«keywords.getRuleName(keyword)»: «sources.guardAction(keyword)» '«AntlrGrammarGenUtil::toAntlrString(keyword)»';
	'''

	def dispatch genToken(Grammar grammar, Set<ILexerStatesProvider$ILexerState> sources, TerminalRule rule, Void NULL) '''
		RULE_«rule.name»: «if("ANY_OTHER" != rule.name) sources.guardAction» «rule.toLexerBody»;
	'''

	def dispatch genToken(Grammar grammar, Set<ILexerStatesProvider$ILexerState> sources, String keyword,
		ILexerStatesProvider$ILexerState target) '''
		«val keywords = KeywordHelper::getHelper(grammar)»
		«keywords.getRuleName(keyword)»: «sources.guardAction(keyword)» '«AntlrGrammarGenUtil::toAntlrString(keyword)»' «target.
			transitionAction»;
	'''

	def dispatch genToken(Grammar grammar, Set<ILexerStatesProvider$ILexerState> sources, TerminalRule rule,
		ILexerStatesProvider$ILexerState target) '''
		RULE_«rule.name»: «if("ANY_OTHER" != rule.name) sources.guardAction» «rule.toLexerBody»  «target.transitionAction»;
	'''
}

@Data class Token {
	Set<ILexerStatesProvider$ILexerState> sources
	Object token
	ILexerStatesProvider$ILexerState target
}
