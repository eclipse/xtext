/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;
import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess;
import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess.RootElements;

import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.ComplexReconstrTestLanguageOpConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.ComplexReconstrTestLanguageTrickyGConsumer;

public final class ComplexReconstrTestLanguageRootConsumer extends NonTerminalConsumer {

	private ComplexReconstrTestLanguageOpConsumer opConsumer;
	private ComplexReconstrTestLanguageTrickyGConsumer trickyGConsumer;

	public ComplexReconstrTestLanguageRootConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	@SuppressWarnings("unused")
	protected boolean doConsume() throws Exception {
		ALTERNATIVES$1SUCCESS: {
			ALTERNATIVES$1FAILURE: {
				RULECALL$2SUCCESS: {
					if (!consumeNonTerminal(opConsumer, null, false, false,  getRule().ele0ParserRuleCallOp()))
						break RULECALL$2SUCCESS;
					break ALTERNATIVES$1FAILURE;
				}
				RULECALL$3SUCCESS: {
					if (!consumeNonTerminal(trickyGConsumer, null, false, false,  getRule().ele1ParserRuleCallTrickyG()))
						break RULECALL$3SUCCESS;
					break ALTERNATIVES$1FAILURE;
				}
				break ALTERNATIVES$1SUCCESS;
			}
			return true;
		}
		return false;
	}

	public RootElements getRule() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prRoot();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Root";
	}
	
	public void setOpConsumer(ComplexReconstrTestLanguageOpConsumer opConsumer) {
		this.opConsumer = opConsumer;
	}
	
	public void setTrickyGConsumer(ComplexReconstrTestLanguageTrickyGConsumer trickyGConsumer) {
		this.trickyGConsumer = trickyGConsumer;
	}
	

}
