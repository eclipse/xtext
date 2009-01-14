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
import org.eclipse.xtext.testlanguages.services.PartialParserTestLanguageGrammarAccess.ContentElements;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.PartialParserTestLanguageAbstractChildrenConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.PartialParserTestLanguageChildrenConsumer;

@SuppressWarnings("unused")
public final class PartialParserTestLanguageContentConsumer extends NonTerminalConsumer {

	private PartialParserTestLanguageAbstractChildrenConsumer abstractChildrenConsumer;
	private PartialParserTestLanguageChildrenConsumer childrenConsumer;

	public PartialParserTestLanguageContentConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
		return consumeNonTerminal(childrenConsumer, null, false, false, getRule().ele0ParserRuleCallChildren());
	}

	protected boolean consumeRuleCall$3() throws Exception {
		return consumeNonTerminal(abstractChildrenConsumer, null, false, false, getRule().ele1ParserRuleCallAbstractChildren());
	}

	public ContentElements getRule() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prContent();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Content";
	}
	
	public void setAbstractChildrenConsumer(PartialParserTestLanguageAbstractChildrenConsumer abstractChildrenConsumer) {
		this.abstractChildrenConsumer = abstractChildrenConsumer;
	}
	
	public void setChildrenConsumer(PartialParserTestLanguageChildrenConsumer childrenConsumer) {
		this.childrenConsumer = childrenConsumer;
	}
	
}
