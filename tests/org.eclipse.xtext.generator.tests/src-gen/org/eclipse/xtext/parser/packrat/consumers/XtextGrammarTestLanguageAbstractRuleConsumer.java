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
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess.AbstractRuleElements;

import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageParserRuleConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageLexerRuleConsumer;

public final class XtextGrammarTestLanguageAbstractRuleConsumer extends NonTerminalConsumer {

	private XtextGrammarTestLanguageParserRuleConsumer parserRuleConsumer;
	private XtextGrammarTestLanguageLexerRuleConsumer lexerRuleConsumer;

	public XtextGrammarTestLanguageAbstractRuleConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	@SuppressWarnings("unused")
	protected boolean doConsume() throws Exception {
		ALTERNATIVES$1SUCCESS: {
			ALTERNATIVES$1FAILURE: {
				RULECALL$2SUCCESS: {
					if (!consumeNonTerminal(lexerRuleConsumer, null, false, false,  getRule().ele0ParserRuleCallLexerRule()))
						break RULECALL$2SUCCESS;
					break ALTERNATIVES$1FAILURE;
				}
				RULECALL$3SUCCESS: {
					if (!consumeNonTerminal(parserRuleConsumer, null, false, false,  getRule().ele1ParserRuleCallParserRule()))
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
		return XtextGrammarTestLanguageGrammarAccess.INSTANCE.prAbstractRule();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractRule";
	}
	
	public void setParserRuleConsumer(XtextGrammarTestLanguageParserRuleConsumer parserRuleConsumer) {
		this.parserRuleConsumer = parserRuleConsumer;
	}
	
	public void setLexerRuleConsumer(XtextGrammarTestLanguageLexerRuleConsumer lexerRuleConsumer) {
		this.lexerRuleConsumer = lexerRuleConsumer;
	}
	

}
