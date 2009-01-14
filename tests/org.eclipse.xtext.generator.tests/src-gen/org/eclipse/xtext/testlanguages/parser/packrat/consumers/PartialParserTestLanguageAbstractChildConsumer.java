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

import org.eclipse.xtext.testlanguages.services.PartialParserTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.PartialParserTestLanguageGrammarAccess.AbstractChildElements;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.PartialParserTestLanguageFirstConcreteConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.PartialParserTestLanguageSecondConcreteConsumer;

@SuppressWarnings("unused")
public final class PartialParserTestLanguageAbstractChildConsumer extends NonTerminalConsumer {

	private PartialParserTestLanguageFirstConcreteConsumer firstConcreteConsumer;
	private PartialParserTestLanguageSecondConcreteConsumer secondConcreteConsumer;

	public PartialParserTestLanguageAbstractChildConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
		return consumeNonTerminal(firstConcreteConsumer, null, false, false, getRule().ele0ParserRuleCallFirstConcrete());
	}

	protected boolean consumeRuleCall$3() throws Exception {
		return consumeNonTerminal(secondConcreteConsumer, null, false, false, getRule().ele1ParserRuleCallSecondConcrete());
	}

	public AbstractChildElements getRule() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prAbstractChild();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractChild";
	}
	
	public void setFirstConcreteConsumer(PartialParserTestLanguageFirstConcreteConsumer firstConcreteConsumer) {
		this.firstConcreteConsumer = firstConcreteConsumer;
	}
	
	public void setSecondConcreteConsumer(PartialParserTestLanguageSecondConcreteConsumer secondConcreteConsumer) {
		this.secondConcreteConsumer = secondConcreteConsumer;
	}
	
}
