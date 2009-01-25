/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers;

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

import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess;
import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess.TerminalGroupElements;

import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageTerminalTokenConsumer;

@SuppressWarnings("unused")
public final class XtextTerminalsTestLanguageTerminalGroupConsumer extends NonTerminalConsumer {

	private XtextTerminalsTestLanguageTerminalTokenConsumer terminalTokenConsumer;

	public XtextTerminalsTestLanguageTerminalGroupConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
			marker.commit();
			return result;
		}
		result = consumeGroup$3(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele1Group());
			marker.commit();
			return result;
		}
		marker.commit();
		return result;
	}

	protected int consumeRuleCall$2() throws Exception {
		return consumeNonTerminal(terminalTokenConsumer, null, false, false, getRule().ele0ParserRuleCallTerminalToken());
	}

	protected int consumeGroup$3() throws Exception {
		IMarker marker = mark();
		while(doConsumeGroup$3() == ConsumeResult.SUCCESS) {
			marker.flush();
		}
		marker.rollback();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$3() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeAction$4(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele10ActionGroupabstractTokens());
			marker.commit();
			return result;
		}
		result = consumeAssignment$6(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele11AssignmentAbstractTokens());
			marker.commit();
			return result;
		}
		marker.commit();
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalGroup();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractElement";
	}
	
	public void setTerminalTokenConsumer(XtextTerminalsTestLanguageTerminalTokenConsumer terminalTokenConsumer) {
		this.terminalTokenConsumer = terminalTokenConsumer;
	}
	
}
