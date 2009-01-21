/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.transientvalues.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.parsetree.transientvalues.services.TransientValuesTestGrammarAccess;
import org.eclipse.xtext.parsetree.transientvalues.services.TransientValuesTestGrammarAccess.TestListElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;

@SuppressWarnings("unused")
public final class TransientValuesTestTestListConsumer extends NonTerminalConsumer {

	private XtextBuiltinINTConsumer intConsumer;

	private ICharacterClass keyword$2$Delimiter;
	
	private ISequenceMatcher ruleCall$4$Delimiter;
	
	public TransientValuesTestTestListConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		keyword$2$Delimiter = ICharacterClass.Factory.nullClass();
		ruleCall$4$Delimiter = ISequenceMatcher.Factory.nullMatcher();
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$2()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeAssignment$3()) {
			marker.rollback();
			marker.release();
			return false;
		}
		marker.release();
		return true;
	}

	protected boolean consumeKeyword$2() throws Exception {
		return consumeKeyword(getRule().ele0KeywordList(), null, false, false, getKeyword$2$Delimiter());
	}

	protected boolean consumeAssignment$3() throws Exception {
		while(doConsumeAssignment$3()) {}
		return true;
	}

	protected boolean doConsumeAssignment$3() throws Exception {
		if (consumeTerminal(intConsumer, "item", true, false, getRule().ele10LexerRuleCallINT(), getRuleCall$4$Delimiter()))
			return true;
		return false;
	}

	public TestListElements getRule() {
		return TransientValuesTestGrammarAccess.INSTANCE.prTestList();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "TestList";
	}
	
	public void setIntConsumer(XtextBuiltinINTConsumer intConsumer) {
		this.intConsumer = intConsumer;
	}
	
	public ICharacterClass getKeyword$2$Delimiter() {
		return keyword$2$Delimiter;
	}
	
	public void setKeyword$2$Delimiter(ICharacterClass characterClass) {
		keyword$2$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ISequenceMatcher getRuleCall$4$Delimiter() {
		return ruleCall$4$Delimiter;
	}
	
	public void setRuleCall$4$Delimiter(ISequenceMatcher matcher) {
		ruleCall$4$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}
