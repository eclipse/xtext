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
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess.CharacterRangeElements;

import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageKeywordConsumer;

@SuppressWarnings("unused")
public final class XtextGrammarTestLanguageCharacterRangeConsumer extends NonTerminalConsumer {

	private XtextGrammarTestLanguageKeywordConsumer keywordConsumer;

	private ICharacterClass keyword$7$Delimiter;
	
	public XtextGrammarTestLanguageCharacterRangeConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		keyword$7$Delimiter = ICharacterClass.Factory.nullClass();
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeRuleCall$2()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeGroup$3()) {
			marker.rollback();
			marker.release();
			return false;
		}
		marker.release();
		return true;
	}

	protected boolean consumeRuleCall$2() throws Exception {
		return consumeNonTerminal(keywordConsumer, null, false, false, getRule().ele0ParserRuleCallKeyword());
	}

	protected boolean consumeGroup$3() throws Exception {
		doConsumeGroup$3();
		return true;
	}

	protected boolean doConsumeGroup$3() throws Exception {
		final IMarker marker = mark();
		if (!consumeAction$5()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeKeyword$7()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeAssignment$8()) {
			marker.rollback();
			marker.release();
			return false;
		}
		marker.release();
		return true;
	}
	protected boolean consumeAction$5() {
		consumeAction("CharacterRange", "left", false);
		return true;	
	}

	protected boolean consumeKeyword$7() throws Exception {
		return consumeKeyword(getRule().ele101KeywordFullStopFullStop(), null, false, false, getKeyword$7$Delimiter());
	}

	protected boolean consumeAssignment$8() throws Exception {
		if (consumeNonTerminal(keywordConsumer, "right", false, false, getRule().ele110ParserRuleCallKeyword()))
			return true;
		return false;
	}

	public CharacterRangeElements getRule() {
		return XtextGrammarTestLanguageGrammarAccess.INSTANCE.prCharacterRange();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractElement";
	}
	
	public void setKeywordConsumer(XtextGrammarTestLanguageKeywordConsumer keywordConsumer) {
		this.keywordConsumer = keywordConsumer;
	}
	
	public ICharacterClass getKeyword$7$Delimiter() {
		return keyword$7$Delimiter;
	}
	
	public void setKeyword$7$Delimiter(ICharacterClass characterClass) {
		keyword$7$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
}
