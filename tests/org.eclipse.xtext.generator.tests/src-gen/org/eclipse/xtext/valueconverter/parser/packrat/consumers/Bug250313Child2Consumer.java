/*
Generated with Xtext
*/
package org.eclipse.xtext.valueconverter.parser.packrat.consumers;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.AbstractRule;

import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.valueconverter.services.Bug250313GrammarAccess.Child2Elements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;

@SuppressWarnings("unused")
public final class Bug250313Child2Consumer extends NonTerminalConsumer {

	private Child2Elements rule;
	
	private ITerminalConsumer stringConsumer;

	private ISequenceMatcher ruleCall$2$Delimiter;
	
	public Bug250313Child2Consumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
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

	public Child2Elements getRule() {
		return rule;
	}
	
	public void setRule(Child2Elements rule) {
		this.rule = rule;
	}
	
	@Override
	protected AbstractRule getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected EClassifier getDefaultType() {
		return getGrammarElement().getType().getType();
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
