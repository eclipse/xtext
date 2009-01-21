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
import org.eclipse.xtext.parsetree.transientvalues.services.TransientValuesTestGrammarAccess.RootElements;

import org.eclipse.xtext.parsetree.transientvalues.parser.packrat.consumers.TransientValuesTestTestListConsumer;
import org.eclipse.xtext.parsetree.transientvalues.parser.packrat.consumers.TransientValuesTestTestOptionalConsumer;
import org.eclipse.xtext.parsetree.transientvalues.parser.packrat.consumers.TransientValuesTestTestRequiredConsumer;

@SuppressWarnings("unused")
public final class TransientValuesTestRootConsumer extends NonTerminalConsumer {

	private TransientValuesTestTestListConsumer testListConsumer;
	private TransientValuesTestTestOptionalConsumer testOptionalConsumer;
	private TransientValuesTestTestRequiredConsumer testRequiredConsumer;

	private ICharacterClass keyword$2$Delimiter;
	
	public TransientValuesTestRootConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		keyword$2$Delimiter = ICharacterClass.Factory.nullClass();
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
		if (!consumeAlternatives$3()) {
			marker.rollback();
			marker.release();
			return false;
		}
		marker.release();
		return true;
	}

	protected boolean consumeKeyword$2() throws Exception {
		return consumeKeyword(getRule().ele0KeywordTest(), null, false, false, getKeyword$2$Delimiter());
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
	
	public void setTestListConsumer(TransientValuesTestTestListConsumer testListConsumer) {
		this.testListConsumer = testListConsumer;
	}
	
	public void setTestOptionalConsumer(TransientValuesTestTestOptionalConsumer testOptionalConsumer) {
		this.testOptionalConsumer = testOptionalConsumer;
	}
	
	public void setTestRequiredConsumer(TransientValuesTestTestRequiredConsumer testRequiredConsumer) {
		this.testRequiredConsumer = testRequiredConsumer;
	}
	
	public ICharacterClass getKeyword$2$Delimiter() {
		return keyword$2$Delimiter;
	}
	
	public void setKeyword$2$Delimiter(ICharacterClass characterClass) {
		keyword$2$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
}
