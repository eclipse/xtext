/*
Generated with Xtext
*/
package org.eclipse.xtext.ui.core.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;
import org.eclipse.xtext.ui.core.services.TestLanguageGrammarAccess;
import org.eclipse.xtext.ui.core.services.TestLanguageGrammarAccess.FileElements;

import org.eclipse.xtext.ui.core.parser.packrat.consumers.TestLanguageStuffConsumer;

public final class TestLanguageFileConsumer extends NonTerminalConsumer {

	private TestLanguageStuffConsumer stuffConsumer;

	public TestLanguageFileConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	@SuppressWarnings("unused")
	protected boolean doConsume() throws Exception {
		ASSIGNMENT$1SUCCESS: while(true) {
			ASSIGNMENT$1FAILURE: {
				if (consumeNonTerminal(stuffConsumer, "stuff", true, false , getRule().ele0ParserRuleCallStuff()))
					break ASSIGNMENT$1FAILURE;
				break ASSIGNMENT$1SUCCESS;
			}
			continue ASSIGNMENT$1SUCCESS;
		}
		return true;
	}

	public FileElements getRule() {
		return TestLanguageGrammarAccess.INSTANCE.prFile();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "File";
	}
	
	public void setStuffConsumer(TestLanguageStuffConsumer stuffConsumer) {
		this.stuffConsumer = stuffConsumer;
	}
	

}
