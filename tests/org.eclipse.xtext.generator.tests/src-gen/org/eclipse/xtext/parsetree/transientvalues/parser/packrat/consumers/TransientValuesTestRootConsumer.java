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
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.parsetree.transientvalues.services.TransientValuesTestGrammarAccess;
import org.eclipse.xtext.parsetree.transientvalues.services.TransientValuesTestGrammarAccess.RootElements;

import org.eclipse.xtext.parsetree.transientvalues.parser.packrat.TransientValuesTestDelimiters;

import org.eclipse.xtext.parsetree.transientvalues.parser.packrat.consumers.TransientValuesTestTestRequiredConsumer;
import org.eclipse.xtext.parsetree.transientvalues.parser.packrat.consumers.TransientValuesTestTestListConsumer;
import org.eclipse.xtext.parsetree.transientvalues.parser.packrat.consumers.TransientValuesTestTestOptionalConsumer;

@SuppressWarnings("unused")
public final class TransientValuesTestRootConsumer extends NonTerminalConsumer {

	private TransientValuesTestTestRequiredConsumer testRequiredConsumer;
	private TransientValuesTestTestListConsumer testListConsumer;
	private TransientValuesTestTestOptionalConsumer testOptionalConsumer;

	public TransientValuesTestRootConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$2()) {
			marker.rollback();
			return false;
		}
		if (!consumeAlternatives$3()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$2() throws Exception {
		return consumeKeyword(getRule().ele0KeywordTest(), null, false, false, TransientValuesTestDelimiters.ID_DELIMITER);
	}

	protected boolean consumeAlternatives$3() throws Exception {
		if (consumeRuleCall$5())
			return true;
		if (consumeRuleCall$6())
			return true;
		if (consumeRuleCall$7())
			return true;
		return false;
	}

	protected boolean consumeRuleCall$5() throws Exception {
		return consumeNonTerminal(testRequiredConsumer, null, false, false, getRule().ele100ParserRuleCallTestRequired());
	}

	protected boolean consumeRuleCall$6() throws Exception {
		return consumeNonTerminal(testOptionalConsumer, null, false, false, getRule().ele101ParserRuleCallTestOptional());
	}

	protected boolean consumeRuleCall$7() throws Exception {
		return consumeNonTerminal(testListConsumer, null, false, false, getRule().ele11ParserRuleCallTestList());
	}

	public RootElements getRule() {
		return TransientValuesTestGrammarAccess.INSTANCE.prRoot();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Root";
	}
	
	public void setTestRequiredConsumer(TransientValuesTestTestRequiredConsumer testRequiredConsumer) {
		this.testRequiredConsumer = testRequiredConsumer;
	}
	
	public void setTestListConsumer(TransientValuesTestTestListConsumer testListConsumer) {
		this.testListConsumer = testListConsumer;
	}
	
	public void setTestOptionalConsumer(TransientValuesTestTestOptionalConsumer testOptionalConsumer) {
		this.testOptionalConsumer = testOptionalConsumer;
	}
	
}
