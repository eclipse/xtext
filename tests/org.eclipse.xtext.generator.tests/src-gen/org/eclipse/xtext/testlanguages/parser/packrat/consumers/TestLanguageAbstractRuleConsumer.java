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
import org.eclipse.xtext.testlanguages.services.TestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.TestLanguageGrammarAccess.AbstractRuleElements;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.TestLanguageReducibleRuleConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.TestLanguageChoiceRuleConsumer;

public final class TestLanguageAbstractRuleConsumer extends NonTerminalConsumer {

	private TestLanguageReducibleRuleConsumer reducibleRuleConsumer;
	private TestLanguageChoiceRuleConsumer choiceRuleConsumer;

	public TestLanguageAbstractRuleConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	@SuppressWarnings("unused")
	protected boolean doConsume() throws Exception {
		ALTERNATIVES$1SUCCESS: {
			ALTERNATIVES$1FAILURE: {
				RULECALL$2SUCCESS: {
					if (!consumeNonTerminal(choiceRuleConsumer, null, false, false,  getRule().ele0ParserRuleCallChoiceRule()))
						break RULECALL$2SUCCESS;
					break ALTERNATIVES$1FAILURE;
				}
				RULECALL$3SUCCESS: {
					if (!consumeNonTerminal(reducibleRuleConsumer, null, false, false,  getRule().ele1ParserRuleCallReducibleRule()))
						break RULECALL$3SUCCESS;
					break ALTERNATIVES$1FAILURE;
				}
				break ALTERNATIVES$1SUCCESS;
			}
			return true;
		}
		return false;
	}

	public AbstractRuleElements getRule() {
		return TestLanguageGrammarAccess.INSTANCE.prAbstractRule();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractElement";
	}
	
	public void setReducibleRuleConsumer(TestLanguageReducibleRuleConsumer reducibleRuleConsumer) {
		this.reducibleRuleConsumer = reducibleRuleConsumer;
	}
	
	public void setChoiceRuleConsumer(TestLanguageChoiceRuleConsumer choiceRuleConsumer) {
		this.choiceRuleConsumer = choiceRuleConsumer;
	}
	

}
