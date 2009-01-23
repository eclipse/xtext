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
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.services.XtextGrammarAccess;
import org.eclipse.xtext.services.XtextGrammarAccess.TerminalGroupElements;

import org.eclipse.xtext.parser.packrat.consumers.XtextTerminalTokenConsumer;

@SuppressWarnings("unused")
public final class XtextTerminalGroupConsumer extends NonTerminalConsumer {

	private XtextTerminalTokenConsumer terminalTokenConsumer;

	public XtextTerminalGroupConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected int doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected int consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeRuleCall$2(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele0ParserRuleCallTerminalToken());
			marker.release();
			return result;
		}
		result = consumeGroup$3(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele1Group());
			marker.release();
			return result;
		}
		marker.release();
		return result;
	}

	protected int consumeRuleCall$2() throws Exception {
		return consumeNonTerminal(terminalTokenConsumer, null, false, false, getRule().ele0ParserRuleCallTerminalToken());
	}

	protected int consumeGroup$3() throws Exception {
		IMarker marker = mark();
		while(doConsumeGroup$3() == ConsumeResult.SUCCESS) {
			marker.release();
			marker = mark();
		}
		marker.rollback();
		marker.release();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$3() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeAction$4(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele10ActionGroupabstractTokens());
			marker.release();
			return result;
		}
		result = consumeAssignment$6(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele11AssignmentAbstractTokens());
			marker.release();
			return result;
		}
		marker.release();
		return result;
	}
	protected int consumeAction$4() {
		consumeAction("Group", "abstractTokens", true);
		return ConsumeResult.SUCCESS;	
	}

	protected int consumeAssignment$6() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeNonTerminal(terminalTokenConsumer, "abstractTokens", true, false, getRule().ele110ParserRuleCallTerminalToken());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	public TerminalGroupElements getRule() {
		return XtextGrammarAccess.INSTANCE.prTerminalGroup();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractElement";
	}
	
	public void setTerminalTokenConsumer(XtextTerminalTokenConsumer terminalTokenConsumer) {
		this.terminalTokenConsumer = terminalTokenConsumer;
	}
	
}
