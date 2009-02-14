/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.testlanguages.services.LookaheadTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.LookaheadTestLanguageGrammarAccess.EntryElements;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.LookaheadTestLanguageAltsConsumer;

@SuppressWarnings("unused")
public final class LookaheadTestLanguageEntryConsumer extends NonTerminalConsumer {

	private INonTerminalConsumer altsConsumer;

	public LookaheadTestLanguageEntryConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
	}
	
	@Override
	protected int doConsume(int entryPoint) throws Exception {
		return consumeAssignment$1(entryPoint);
	}

	protected int consumeAssignment$1(int entryPoint) throws Exception {
		IMarker marker = mark();
		while(doConsumeAssignment$1(entryPoint) == ConsumeResult.SUCCESS) {
			marker.flush();
		}
		marker.rollback();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeAssignment$1(int entryPoint) throws Exception {
		return consumeRuleCall$2(entryPoint);
	}

	protected int consumeRuleCall$2(int entryPoint) throws Exception {
		return consumeNonTerminal(altsConsumer, "contents", true, false, false, getRule().ele0ParserRuleCallAlts());
	}

	public EntryElements getRule() {
		return LookaheadTestLanguageGrammarAccess.INSTANCE.prEntry();
	}
	
	@Override
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Entry";
	}
	
	public void setAltsConsumer(INonTerminalConsumer altsConsumer) {
		this.altsConsumer = altsConsumer;
	}
	
}
