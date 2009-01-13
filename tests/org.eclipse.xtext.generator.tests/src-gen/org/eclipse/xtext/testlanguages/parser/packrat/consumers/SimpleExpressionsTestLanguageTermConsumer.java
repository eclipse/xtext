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
import org.eclipse.xtext.testlanguages.services.SimpleExpressionsTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.SimpleExpressionsTestLanguageGrammarAccess.TermElements;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.SimpleExpressionsTestLanguageAtomConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.SimpleExpressionsTestLanguageParensConsumer;

public final class SimpleExpressionsTestLanguageTermConsumer extends NonTerminalConsumer {

	private SimpleExpressionsTestLanguageAtomConsumer atomConsumer;
	private SimpleExpressionsTestLanguageParensConsumer parensConsumer;

	public SimpleExpressionsTestLanguageTermConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	@SuppressWarnings("unused")
	protected boolean doConsume() throws Exception {
		ALTERNATIVES$1SUCCESS: {
			ALTERNATIVES$1FAILURE: {
				RULECALL$2SUCCESS: {
					if (!consumeNonTerminal(atomConsumer, null, false, false,  getRule().ele0ParserRuleCallAtom()))
						break RULECALL$2SUCCESS;
					break ALTERNATIVES$1FAILURE;
				}
				RULECALL$3SUCCESS: {
					if (!consumeNonTerminal(parensConsumer, null, false, false,  getRule().ele1ParserRuleCallParens()))
						break RULECALL$3SUCCESS;
					break ALTERNATIVES$1FAILURE;
				}
				break ALTERNATIVES$1SUCCESS;
			}
			return true;
		}
		return false;
	}

	public TermElements getRule() {
		return SimpleExpressionsTestLanguageGrammarAccess.INSTANCE.prTerm();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Expression";
	}
	
	public void setAtomConsumer(SimpleExpressionsTestLanguageAtomConsumer atomConsumer) {
		this.atomConsumer = atomConsumer;
	}
	
	public void setParensConsumer(SimpleExpressionsTestLanguageParensConsumer parensConsumer) {
		this.parensConsumer = parensConsumer;
	}
	

}
