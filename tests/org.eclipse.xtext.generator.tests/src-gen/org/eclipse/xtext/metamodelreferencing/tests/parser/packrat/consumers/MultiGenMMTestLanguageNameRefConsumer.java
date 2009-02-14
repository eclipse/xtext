/*
Generated with Xtext
*/
package org.eclipse.xtext.metamodelreferencing.tests.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.metamodelreferencing.tests.services.MultiGenMMTestLanguageGrammarAccess;
import org.eclipse.xtext.metamodelreferencing.tests.services.MultiGenMMTestLanguageGrammarAccess.NameRefElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;

@SuppressWarnings("unused")
public final class MultiGenMMTestLanguageNameRefConsumer extends NonTerminalConsumer {

	private ITerminalConsumer stringConsumer;

	private ISequenceMatcher ruleCall$2$Delimiter;
	
	public MultiGenMMTestLanguageNameRefConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
		ruleCall$2$Delimiter = ISequenceMatcher.Factory.nullMatcher();
	}
	
	@Override
	protected int doConsume(int entryPoint) throws Exception {
		return consumeAssignment$1(entryPoint);
	}

	protected int consumeAssignment$1(int entryPoint) throws Exception {
		return consumeRuleCall$2(entryPoint);
	}

	protected int consumeRuleCall$2(int entryPoint) throws Exception {
		return consumeTerminal(stringConsumer, "name", false, false, getRule().ele0LexerRuleCallSTRING(), getRuleCall$2$Delimiter());
	}

	public NameRefElements getRule() {
		return MultiGenMMTestLanguageGrammarAccess.INSTANCE.prNameRef();
	}
	
	@Override
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "FooBar";
	}
	
	public void setStringConsumer(ITerminalConsumer stringConsumer) {
		this.stringConsumer = stringConsumer;
	}
	
	public ISequenceMatcher getRuleCall$2$Delimiter() {
		return ruleCall$2$Delimiter;
	}
	
	public void setRuleCall$2$Delimiter(ISequenceMatcher matcher) {
		ruleCall$2$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}
