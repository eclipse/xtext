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
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess;
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess.AlternativesElements;

import org.eclipse.xtext.parser.packrat.XtextGrammarTestLanguageDelimiters;

import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageGroupConsumer;

@SuppressWarnings("unused")
public final class XtextGrammarTestLanguageAlternativesConsumer extends NonTerminalConsumer {

	private XtextGrammarTestLanguageGroupConsumer groupConsumer;

	public XtextGrammarTestLanguageAlternativesConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeRuleCall$2()) {
			marker.rollback();
			return false;
		}
		if (!consumeGroup$3()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeRuleCall$2() throws Exception {
		return consumeNonTerminal(groupConsumer, null, false, false, getRule().ele0ParserRuleCallGroup());
	}

	protected boolean consumeGroup$3() throws Exception {
		while(doConsumeGroup$3()) {}
		return true;
	}

	protected boolean doConsumeGroup$3() throws Exception {
		final IMarker marker = mark();
		if (!consumeAction$5()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$7()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$8()) {
			marker.rollback();
			return false;
		}
		return true;
	}
	protected boolean consumeAction$5() {
		consumeAction("Alternatives", "groups", true);
		return true;	
	}

	protected boolean consumeKeyword$7() throws Exception {
		return consumeKeyword(getRule().ele101KeywordVerticalLine(), null, false, false, XtextGrammarTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeAssignment$8() throws Exception {
		if (consumeNonTerminal(groupConsumer, "groups", true, false, getRule().ele110ParserRuleCallGroup()))
			return true;
		return false;
	}

	public AlternativesElements getRule() {
		return XtextGrammarTestLanguageGrammarAccess.INSTANCE.prAlternatives();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractElement";
	}
	
	public void setGroupConsumer(XtextGrammarTestLanguageGroupConsumer groupConsumer) {
		this.groupConsumer = groupConsumer;
	}
	
}
