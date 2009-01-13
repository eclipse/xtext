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
import org.eclipse.xtext.testlanguages.services.PartialParserTestLanguageGrammarAccess.ContentElements;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.PartialParserTestLanguageChildrenConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.PartialParserTestLanguageAbstractChildrenConsumer;

public final class PartialParserTestLanguageContentConsumer extends NonTerminalConsumer {

	private PartialParserTestLanguageChildrenConsumer childrenConsumer;
	private PartialParserTestLanguageAbstractChildrenConsumer abstractChildrenConsumer;

	public PartialParserTestLanguageContentConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	@SuppressWarnings("unused")
	protected boolean doConsume() throws Exception {
		ALTERNATIVES$1SUCCESS: {
			ALTERNATIVES$1FAILURE: {
				RULECALL$2SUCCESS: {
					if (!consumeNonTerminal(childrenConsumer, null, false, false,  getRule().ele0ParserRuleCallChildren()))
						break RULECALL$2SUCCESS;
					break ALTERNATIVES$1FAILURE;
				}
				RULECALL$3SUCCESS: {
					if (!consumeNonTerminal(abstractChildrenConsumer, null, false, false,  getRule().ele1ParserRuleCallAbstractChildren()))
						break RULECALL$3SUCCESS;
					break ALTERNATIVES$1FAILURE;
				}
				break ALTERNATIVES$1SUCCESS;
			}
			return true;
		}
		return false;
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
	
	public void setChildrenConsumer(PartialParserTestLanguageChildrenConsumer childrenConsumer) {
		this.childrenConsumer = childrenConsumer;
	}
	
	public void setAbstractChildrenConsumer(PartialParserTestLanguageAbstractChildrenConsumer abstractChildrenConsumer) {
		this.abstractChildrenConsumer = abstractChildrenConsumer;
	}
	

}
