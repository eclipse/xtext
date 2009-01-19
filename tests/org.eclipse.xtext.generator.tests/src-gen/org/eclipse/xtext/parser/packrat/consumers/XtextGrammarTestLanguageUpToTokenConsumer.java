/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess;
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess.UpToTokenElements;

import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageTerminalTokenElementConsumer;

@SuppressWarnings("unused")
public final class XtextGrammarTestLanguageUpToTokenConsumer extends NonTerminalConsumer {

	private XtextGrammarTestLanguageTerminalTokenElementConsumer terminalTokenElementConsumer;

	private ICharacterClass keyword$2$Delimiter;
	
	public XtextGrammarTestLanguageUpToTokenConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		keyword$2$Delimiter = ICharacterClass.Factory.nullClass();
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$2()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$3()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$2() throws Exception {
		return consumeKeyword(getRule().ele0KeywordHyphenMinusGreaterThanSign(), null, false, false, getKeyword$2$Delimiter());
	}

	protected boolean consumeAssignment$3() throws Exception {
		if (consumeNonTerminal(terminalTokenElementConsumer, "terminal", false, false, getRule().ele10ParserRuleCallTerminalTokenElement()))
			return true;
		return false;
	}

	public UpToTokenElements getRule() {
		return XtextGrammarTestLanguageGrammarAccess.INSTANCE.prUpToToken();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "UpToToken";
	}
	
	public void setTerminalTokenElementConsumer(XtextGrammarTestLanguageTerminalTokenElementConsumer terminalTokenElementConsumer) {
		this.terminalTokenElementConsumer = terminalTokenElementConsumer;
	}
	
	public ICharacterClass getKeyword$2$Delimiter() {
		return keyword$2$Delimiter;
	}
	
	public void setKeyword$2$Delimiter(ICharacterClass characterClass) {
		keyword$2$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
}
