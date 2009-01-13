/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.formatter.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;
import org.eclipse.xtext.parsetree.formatter.services.FormatterTestLanguageGrammarAccess;
import org.eclipse.xtext.parsetree.formatter.services.FormatterTestLanguageGrammarAccess.TestLinewrapElements;

import org.eclipse.xtext.parsetree.formatter.parser.packrat.consumers.FormatterTestLanguageLineConsumer;

public final class FormatterTestLanguageTestLinewrapConsumer extends NonTerminalConsumer {

	private FormatterTestLanguageLineConsumer lineConsumer;

	public FormatterTestLanguageTestLinewrapConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	@SuppressWarnings("unused")
	protected boolean doConsume() throws Exception {
		GROUP$1SUCCESS: {
			IMarker mGROUP$1 = mark();
			GROUP$1FAILURE: {
				KEYWORD$2SUCCESS: {
					if (!consumeKeyword(getRule().ele0KeywordLinewrap(), null, false, false))
						break KEYWORD$2SUCCESS;
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			GROUP$1FAILURE: {
				ASSIGNMENT$3SUCCESS: while(true) {
					ASSIGNMENT$3FAILURE: {
						if (consumeNonTerminal(lineConsumer, "items", true, false , getRule().ele10ParserRuleCallLine()))
							break ASSIGNMENT$3FAILURE;
						break ASSIGNMENT$3SUCCESS;
					}
					continue ASSIGNMENT$3SUCCESS;
				}
			}
			return true;
		}
		return false;
	}

	public TestLinewrapElements getRule() {
		return FormatterTestLanguageGrammarAccess.INSTANCE.prTestLinewrap();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "TestLinewrap";
	}
	
	public void setLineConsumer(FormatterTestLanguageLineConsumer lineConsumer) {
		this.lineConsumer = lineConsumer;
	}
	

}
