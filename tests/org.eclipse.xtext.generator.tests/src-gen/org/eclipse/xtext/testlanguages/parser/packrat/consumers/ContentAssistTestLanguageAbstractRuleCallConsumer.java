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
import org.eclipse.xtext.testlanguages.services.ContentAssistTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.ContentAssistTestLanguageGrammarAccess.AbstractRuleCallElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

public final class ContentAssistTestLanguageAbstractRuleCallConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;

	public ContentAssistTestLanguageAbstractRuleCallConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	@SuppressWarnings("unused")
	protected boolean doConsume() throws Exception {
		ASSIGNMENT$1SUCCESS: {
			ASSIGNMENT$1FAILURE: {
				if (consumeTerminal(idConsumer, null, false, false, getRule().ele0CrossReferenceEStringAbstractRule()))
					break ASSIGNMENT$1FAILURE;
				break ASSIGNMENT$1SUCCESS;
			}
			return true;
		}
		return false;
	}

	public AbstractRuleCallElements getRule() {
		return ContentAssistTestLanguageGrammarAccess.INSTANCE.prAbstractRuleCall();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractRuleCall";
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	

}
