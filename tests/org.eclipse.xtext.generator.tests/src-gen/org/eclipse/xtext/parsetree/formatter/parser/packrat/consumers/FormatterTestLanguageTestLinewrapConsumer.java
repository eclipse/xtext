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
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.parsetree.formatter.services.FormatterTestLanguageGrammarAccess;
import org.eclipse.xtext.parsetree.formatter.services.FormatterTestLanguageGrammarAccess.TestLinewrapElements;

import org.eclipse.xtext.parsetree.formatter.parser.packrat.consumers.FormatterTestLanguageLineConsumer;

@SuppressWarnings("unused")
public final class FormatterTestLanguageTestLinewrapConsumer extends NonTerminalConsumer {

	private FormatterTestLanguageLineConsumer lineConsumer;

	private ICharacterClass keyword$2$Delimiter;
	
	public FormatterTestLanguageTestLinewrapConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
		if (!consumeAssignment$3()) {
			marker.rollback();
			marker.release();
			return false;
		}
		marker.release();
		return true;
	}

	protected boolean consumeKeyword$2() throws Exception {
		return consumeKeyword(getRule().ele0KeywordLinewrap(), null, false, false, getKeyword$2$Delimiter());
	}

	protected boolean consumeAssignment$3() throws Exception {
		while(doConsumeAssignment$3()) {}
		return true;
	}

	protected boolean doConsumeAssignment$3() throws Exception {
		if (consumeNonTerminal(lineConsumer, "items", true, false, getRule().ele10ParserRuleCallLine()))
			return true;
		return false;
	}

	public TestLinewrapElements getRule() {
		return FormatterTestLanguageGrammarAccess.INSTANCE.prTestLinewrap();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "TestLinewrap";
	}
	
	public void setLineConsumer(FormatterTestLanguageLineConsumer lineConsumer) {
		this.lineConsumer = lineConsumer;
	}
	
	public ICharacterClass getKeyword$2$Delimiter() {
		return keyword$2$Delimiter;
	}
	
	public void setKeyword$2$Delimiter(ICharacterClass characterClass) {
		keyword$2$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
}
