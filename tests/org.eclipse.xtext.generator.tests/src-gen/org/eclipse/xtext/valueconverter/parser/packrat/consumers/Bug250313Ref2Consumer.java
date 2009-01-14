/*
Generated with Xtext
*/
package org.eclipse.xtext.valueconverter.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.valueconverter.services.Bug250313GrammarAccess;
import org.eclipse.xtext.valueconverter.services.Bug250313GrammarAccess.Ref2Elements;

import org.eclipse.xtext.valueconverter.parser.packrat.Bug250313Delimiters;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

@SuppressWarnings("unused")
public final class Bug250313Ref2Consumer extends NonTerminalConsumer {

	private XtextBuiltinSTRINGConsumer stringConsumer;
	private XtextBuiltinIDConsumer idConsumer;

	public Bug250313Ref2Consumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
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
		return consumeKeyword(getRule().ele0KeywordNumberSignDigitTwo(), null, false, false, Bug250313Delimiters.ID_DELIMITER);
	}

	protected boolean consumeAssignment$3() throws Exception {
		if (consumeKeyword(getRule().ele1000KeywordMykeyword1(), "ref2", false, false, Bug250313Delimiters.ID_DELIMITER))
			return true;
		if (consumeTerminal(stringConsumer, "ref2", false, false, getRule().ele1001LexerRuleCallSTRING(), Bug250313Delimiters.ALL_KEYWORDS))
			return true;
		if (consumeTerminal(idConsumer, "ref2", false, false, getRule().ele101LexerRuleCallID(), Bug250313Delimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	public Ref2Elements getRule() {
		return Bug250313GrammarAccess.INSTANCE.prRef2();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Ref2";
	}
	
	public void setStringConsumer(XtextBuiltinSTRINGConsumer stringConsumer) {
		this.stringConsumer = stringConsumer;
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
}
