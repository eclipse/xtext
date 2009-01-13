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
import org.eclipse.xtext.parsetree.formatter.services.FormatterTestLanguageGrammarAccess.TestIndentationElements;

import org.eclipse.xtext.parsetree.formatter.parser.packrat.FormatterTestLanguageDelimiters;

import org.eclipse.xtext.parsetree.formatter.parser.packrat.consumers.FormatterTestLanguageTestIndentationConsumer;
import org.eclipse.xtext.parsetree.formatter.parser.packrat.consumers.FormatterTestLanguageLineConsumer;

@SuppressWarnings("unused")
public final class FormatterTestLanguageTestIndentationConsumer extends NonTerminalConsumer {

	private FormatterTestLanguageTestIndentationConsumer testIndentationConsumer;
	private FormatterTestLanguageLineConsumer lineConsumer;

	public FormatterTestLanguageTestIndentationConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$4()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$5()) {
			marker.rollback();
			return false;
		}
		if (!consumeAlternatives$6()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$11()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$4() throws Exception {
		return consumeKeyword(getRule().ele000KeywordIndentation(), null, false, false, FormatterTestLanguageDelimiters.ID_DELIMITER);
	}

	protected boolean consumeKeyword$5() throws Exception {
		return consumeKeyword(getRule().ele001KeywordLeftCurlyBracket(), null, false, false, FormatterTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeAlternatives$6() throws Exception {
		while(doConsumeAlternatives$6()) {}
		return true;
	}

	protected boolean doConsumeAlternatives$6() throws Exception {
		if (consumeAssignment$7())
			return true;
		if (consumeAssignment$9())
			return true;
		return false;
	}

	protected boolean consumeAssignment$7() throws Exception {
		if (consumeNonTerminal(testIndentationConsumer, "sub", true, false, getRule().ele0100ParserRuleCallTestIndentation()))
			return true;
		return false;
	}

	protected boolean consumeAssignment$9() throws Exception {
		if (consumeNonTerminal(lineConsumer, "items", true, false, getRule().ele0110ParserRuleCallLine()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$11() throws Exception {
		return consumeKeyword(getRule().ele1KeywordRightCurlyBracket(), null, false, false, FormatterTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	public TestIndentationElements getRule() {
		return FormatterTestLanguageGrammarAccess.INSTANCE.prTestIndentation();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "TestIndentation";
	}
	
	public void setTestIndentationConsumer(FormatterTestLanguageTestIndentationConsumer testIndentationConsumer) {
		this.testIndentationConsumer = testIndentationConsumer;
	}
	
	public void setLineConsumer(FormatterTestLanguageLineConsumer lineConsumer) {
		this.lineConsumer = lineConsumer;
	}
	
}
