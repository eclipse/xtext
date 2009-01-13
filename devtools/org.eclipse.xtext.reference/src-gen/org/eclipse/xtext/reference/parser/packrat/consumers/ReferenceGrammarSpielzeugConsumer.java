/*
Generated with Xtext
*/
package org.eclipse.xtext.reference.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.reference.services.ReferenceGrammarGrammarAccess;
import org.eclipse.xtext.reference.services.ReferenceGrammarGrammarAccess.SpielzeugElements;

import org.eclipse.xtext.reference.parser.packrat.ReferenceGrammarDelimiters;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.reference.parser.packrat.consumers.ReferenceGrammarFarbeConsumer;

@SuppressWarnings("unused")
public final class ReferenceGrammarSpielzeugConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;
	private ReferenceGrammarFarbeConsumer farbeConsumer;

	public ReferenceGrammarSpielzeugConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
		return consumeKeyword(getRule().ele0000KeywordSpielzeug(), null, false, false, ReferenceGrammarDelimiters.ID_DELIMITER);
	}

	protected boolean consumeKeyword$6() throws Exception {
		return consumeKeyword(getRule().ele0001KeywordLeftParenthesis(), null, false, false, ReferenceGrammarDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeAssignment$7() throws Exception {
		if (consumeTerminal(idConsumer, "name", false, false, getRule().ele0010LexerRuleCallID(), ReferenceGrammarDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeAssignment$9() throws Exception {
		if (consumeNonTerminal(farbeConsumer, "farbe", false, false, getRule().ele010ParserRuleCallFarbe()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$11() throws Exception {
		return consumeKeyword(getRule().ele1KeywordRightParenthesis(), null, false, false, ReferenceGrammarDelimiters.ANY_OTHER_DELIMITER);
	}

	public SpielzeugElements getRule() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prSpielzeug();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Spielzeug";
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setFarbeConsumer(ReferenceGrammarFarbeConsumer farbeConsumer) {
		this.farbeConsumer = farbeConsumer;
	}
	
}
