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
import org.eclipse.xtext.testlanguages.services.PartialParserTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.PartialParserTestLanguageGrammarAccess.AbstractChildElements;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.PartialParserTestLanguageSecondConcreteConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.PartialParserTestLanguageFirstConcreteConsumer;

public final class PartialParserTestLanguageAbstractChildConsumer extends NonTerminalConsumer {

	private PartialParserTestLanguageSecondConcreteConsumer secondConcreteConsumer;
	private PartialParserTestLanguageFirstConcreteConsumer firstConcreteConsumer;

	public PartialParserTestLanguageAbstractChildConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	@SuppressWarnings("unused")
	protected boolean doConsume() throws Exception {
		ALTERNATIVES$1SUCCESS: {
			ALTERNATIVES$1FAILURE: {
				RULECALL$2SUCCESS: {
					if (!consumeNonTerminal(firstConcreteConsumer, null, false, false,  getRule().ele0ParserRuleCallFirstConcrete()))
						break RULECALL$2SUCCESS;
					break ALTERNATIVES$1FAILURE;
				}
				RULECALL$3SUCCESS: {
					if (!consumeNonTerminal(secondConcreteConsumer, null, false, false,  getRule().ele1ParserRuleCallSecondConcrete()))
						break RULECALL$3SUCCESS;
					break ALTERNATIVES$1FAILURE;
				}
				break ALTERNATIVES$1SUCCESS;
			}
			return true;
		}
		return false;
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
	
	public void setSecondConcreteConsumer(PartialParserTestLanguageSecondConcreteConsumer secondConcreteConsumer) {
		this.secondConcreteConsumer = secondConcreteConsumer;
	}
	
	public void setFirstConcreteConsumer(PartialParserTestLanguageFirstConcreteConsumer firstConcreteConsumer) {
		this.firstConcreteConsumer = firstConcreteConsumer;
	}
	

}
