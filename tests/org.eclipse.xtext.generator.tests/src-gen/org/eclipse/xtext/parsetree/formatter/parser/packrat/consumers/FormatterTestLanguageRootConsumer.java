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
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.parsetree.formatter.services.FormatterTestLanguageGrammarAccess;
import org.eclipse.xtext.parsetree.formatter.services.FormatterTestLanguageGrammarAccess.RootElements;

import org.eclipse.xtext.parsetree.formatter.parser.packrat.FormatterTestLanguageDelimiters;

import org.eclipse.xtext.parsetree.formatter.parser.packrat.consumers.FormatterTestLanguageTestIndentationConsumer;
import org.eclipse.xtext.parsetree.formatter.parser.packrat.consumers.FormatterTestLanguageTestLinewrapConsumer;

@SuppressWarnings("unused")
public final class FormatterTestLanguageRootConsumer extends NonTerminalConsumer {

	private FormatterTestLanguageTestIndentationConsumer testIndentationConsumer;
	private FormatterTestLanguageTestLinewrapConsumer testLinewrapConsumer;

	public FormatterTestLanguageRootConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
		return consumeKeyword(getRule().ele0KeywordTest(), null, false, false, FormatterTestLanguageDelimiters.ID_DELIMITER);
	}

	protected boolean consumeAlternatives$3() throws Exception {
		if (consumeRuleCall$4())
			return true;
		if (consumeRuleCall$5())
			return true;
		return false;
	}

	protected boolean consumeRuleCall$4() throws Exception {
		return consumeNonTerminal(testLinewrapConsumer, null, false, false, getRule().ele10ParserRuleCallTestLinewrap());
	}

	protected boolean consumeRuleCall$5() throws Exception {
		return consumeNonTerminal(testIndentationConsumer, null, false, false, getRule().ele11ParserRuleCallTestIndentation());
	}

	public RootElements getRule() {
		return FormatterTestLanguageGrammarAccess.INSTANCE.prRoot();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Root";
	}
	
	public void setTestIndentationConsumer(FormatterTestLanguageTestIndentationConsumer testIndentationConsumer) {
		this.testIndentationConsumer = testIndentationConsumer;
	}
	
	public void setTestLinewrapConsumer(FormatterTestLanguageTestLinewrapConsumer testLinewrapConsumer) {
		this.testLinewrapConsumer = testLinewrapConsumer;
	}
	
}
