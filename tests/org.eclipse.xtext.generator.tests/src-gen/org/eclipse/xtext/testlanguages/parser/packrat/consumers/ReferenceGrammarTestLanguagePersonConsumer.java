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
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.testlanguages.services.ReferenceGrammarTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.ReferenceGrammarTestLanguageGrammarAccess.PersonElements;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.ReferenceGrammarTestLanguageErwachsenerConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.ReferenceGrammarTestLanguageKindConsumer;

@SuppressWarnings("unused")
public final class ReferenceGrammarTestLanguagePersonConsumer extends NonTerminalConsumer {

	private ReferenceGrammarTestLanguageErwachsenerConsumer erwachsenerConsumer;
	private ReferenceGrammarTestLanguageKindConsumer kindConsumer;

	public ReferenceGrammarTestLanguagePersonConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeAlternatives$1();
	}

	protected boolean consumeAlternatives$1() throws Exception {
		if (consumeRuleCall$2())
			return true;
		if (consumeRuleCall$3())
			return true;
		return false;
	}

	protected boolean consumeRuleCall$2() throws Exception {
		return consumeNonTerminal(kindConsumer, null, false, false, getRule().ele0ParserRuleCallKind());
	}

	protected boolean consumeRuleCall$3() throws Exception {
		return consumeNonTerminal(erwachsenerConsumer, null, false, false, getRule().ele1ParserRuleCallErwachsener());
	}

	public PersonElements getRule() {
		return ReferenceGrammarTestLanguageGrammarAccess.INSTANCE.prPerson();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Person";
	}
	
	public void setErwachsenerConsumer(ReferenceGrammarTestLanguageErwachsenerConsumer erwachsenerConsumer) {
		this.erwachsenerConsumer = erwachsenerConsumer;
	}
	
	public void setKindConsumer(ReferenceGrammarTestLanguageKindConsumer kindConsumer) {
		this.kindConsumer = kindConsumer;
	}
	
}
