/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.testlanguages.services.ReferenceGrammarTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.ReferenceGrammarTestLanguageGrammarAccess.SpielzeugElements;

import org.eclipse.xtext.testlanguages.parser.packrat.ReferenceGrammarTestLanguageDelimiters;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.ReferenceGrammarTestLanguageFarbeConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

@SuppressWarnings("unused")
public final class ReferenceGrammarTestLanguageSpielzeugConsumer extends NonTerminalConsumer {

	private ReferenceGrammarTestLanguageFarbeConsumer farbeConsumer;
	private XtextBuiltinIDConsumer idConsumer;

	public ReferenceGrammarTestLanguageSpielzeugConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$5()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$6()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$7()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$9()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$11()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$5() throws Exception {
		return consumeKeyword(getRule().ele0000KeywordSpielzeug(), null, false, false, ReferenceGrammarTestLanguageDelimiters.ID_DELIMITER);
	}

	protected boolean consumeKeyword$6() throws Exception {
		return consumeKeyword(getRule().ele0001KeywordLeftParenthesis(), null, false, false, ReferenceGrammarTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeAssignment$7() throws Exception {
		if (consumeTerminal(idConsumer, "name", false, false, getRule().ele0010LexerRuleCallID(), ReferenceGrammarTestLanguageDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeAssignment$9() throws Exception {
		if (consumeNonTerminal(farbeConsumer, "farbe", false, false, getRule().ele010ParserRuleCallFarbe()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$11() throws Exception {
		return consumeKeyword(getRule().ele1KeywordRightParenthesis(), null, false, false, ReferenceGrammarTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	public SpielzeugElements getRule() {
		return ReferenceGrammarTestLanguageGrammarAccess.INSTANCE.prSpielzeug();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Spielzeug";
	}
	
	public void setFarbeConsumer(ReferenceGrammarTestLanguageFarbeConsumer farbeConsumer) {
		this.farbeConsumer = farbeConsumer;
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
}
