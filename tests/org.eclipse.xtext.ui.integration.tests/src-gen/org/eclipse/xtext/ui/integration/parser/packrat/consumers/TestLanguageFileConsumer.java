/*
Generated with Xtext
*/
package org.eclipse.xtext.ui.integration.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.ui.integration.services.TestLanguageGrammarAccess;
import org.eclipse.xtext.ui.integration.services.TestLanguageGrammarAccess.FileElements;

import org.eclipse.xtext.ui.integration.parser.packrat.consumers.TestLanguageStuffConsumer;

@SuppressWarnings("unused")
public final class TestLanguageFileConsumer extends NonTerminalConsumer {

	private TestLanguageStuffConsumer stuffConsumer;

	public TestLanguageFileConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
	}
	
	protected int doConsume() throws Exception {
		return consumeAssignment$1();
	}

	protected int consumeAssignment$1() throws Exception {
		IMarker marker = mark();
		while(doConsumeAssignment$1() == ConsumeResult.SUCCESS) {
			marker.flush();
		}
		marker.rollback();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeAssignment$1() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeNonTerminal(stuffConsumer, "stuff", true, false, getRule().ele0ParserRuleCallStuff());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
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
