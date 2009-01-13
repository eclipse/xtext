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
import org.eclipse.xtext.parsetree.formatter.services.FormatterTestLanguageGrammarAccess.RootElements;

import org.eclipse.xtext.parsetree.formatter.parser.packrat.consumers.FormatterTestLanguageTestLinewrapConsumer;
import org.eclipse.xtext.parsetree.formatter.parser.packrat.consumers.FormatterTestLanguageTestIndentationConsumer;

public final class FormatterTestLanguageRootConsumer extends NonTerminalConsumer {

	private FormatterTestLanguageTestLinewrapConsumer testLinewrapConsumer;
	private FormatterTestLanguageTestIndentationConsumer testIndentationConsumer;

	public FormatterTestLanguageRootConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
					if (!consumeKeyword(getRule().ele0KeywordTest(), null, false, false))
						break KEYWORD$2SUCCESS;
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			GROUP$1FAILURE: {
				ALTERNATIVES$3SUCCESS: {
					ALTERNATIVES$3FAILURE: {
						RULECALL$4SUCCESS: {
							if (!consumeNonTerminal(testLinewrapConsumer, null, false, false,  getRule().ele10ParserRuleCallTestLinewrap()))
								break RULECALL$4SUCCESS;
							break ALTERNATIVES$3FAILURE;
						}
						RULECALL$5SUCCESS: {
							if (!consumeNonTerminal(testIndentationConsumer, null, false, false,  getRule().ele11ParserRuleCallTestIndentation()))
								break RULECALL$5SUCCESS;
							break ALTERNATIVES$3FAILURE;
						}
						mGROUP$1.rollback();
						break ALTERNATIVES$3SUCCESS;
					}
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			return true;
		}
		return false;
	}

	public RootElements getRule() {
		return FormatterTestLanguageGrammarAccess.INSTANCE.prRoot();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Root";
	}
	
	public void setTestLinewrapConsumer(FormatterTestLanguageTestLinewrapConsumer testLinewrapConsumer) {
		this.testLinewrapConsumer = testLinewrapConsumer;
	}
	
	public void setTestIndentationConsumer(FormatterTestLanguageTestIndentationConsumer testIndentationConsumer) {
		this.testIndentationConsumer = testIndentationConsumer;
	}
	

}
