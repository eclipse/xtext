/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.datatyperules.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.parser.datatyperules.services.DatatypeRulesTestLanguageGrammarAccess;
import org.eclipse.xtext.parser.datatyperules.services.DatatypeRulesTestLanguageGrammarAccess.ModelElements;

import org.eclipse.xtext.parser.datatyperules.parser.packrat.DatatypeRulesTestLanguageDelimiters;

import org.eclipse.xtext.parser.datatyperules.parser.packrat.consumers.DatatypeRulesTestLanguageVectorConsumer;
import org.eclipse.xtext.parser.datatyperules.parser.packrat.consumers.DatatypeRulesTestLanguageFractionConsumer;
import org.eclipse.xtext.parser.datatyperules.parser.packrat.consumers.DatatypeRulesTestLanguageDotsConsumer;
import org.eclipse.xtext.parser.datatyperules.parser.packrat.consumers.DatatypeRulesTestLanguageNestedModelIdConsumer;

@SuppressWarnings("unused")
public final class DatatypeRulesTestLanguageModelConsumer extends NonTerminalConsumer {

	private DatatypeRulesTestLanguageVectorConsumer vectorConsumer;
	private DatatypeRulesTestLanguageFractionConsumer fractionConsumer;
	private DatatypeRulesTestLanguageDotsConsumer dotsConsumer;
	private DatatypeRulesTestLanguageNestedModelIdConsumer nestedModelIdConsumer;

	public DatatypeRulesTestLanguageModelConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeAssignment$5()) {
			marker.rollback();
			return false;
		}
		if (!consumeGroup$7()) {
			marker.rollback();
			return false;
		}
		if (!consumeGroup$11()) {
			marker.rollback();
			return false;
		}
		if (!consumeGroup$15()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$19()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeAssignment$5() throws Exception {
		if (consumeNonTerminal(nestedModelIdConsumer, "id", false, true, getRule().ele00000ParserRuleCallNestedModelId()))
			return true;
		return false;
	}

	protected boolean consumeGroup$7() throws Exception {
		doConsumeGroup$7();
		return true;
	}

	protected boolean doConsumeGroup$7() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$8()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$9()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$8() throws Exception {
		return consumeKeyword(getRule().ele00010KeywordColon(), null, false, false, DatatypeRulesTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeAssignment$9() throws Exception {
		if (consumeNonTerminal(fractionConsumer, "value", false, true, getRule().ele000110ParserRuleCallFraction()))
			return true;
		return false;
	}

	protected boolean consumeGroup$11() throws Exception {
		doConsumeGroup$11();
		return true;
	}

	protected boolean doConsumeGroup$11() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$12()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$13()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$12() throws Exception {
		return consumeKeyword(getRule().ele0010KeywordNumberSign(), null, false, false, DatatypeRulesTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeAssignment$13() throws Exception {
		if (consumeNonTerminal(vectorConsumer, "vector", false, true, getRule().ele00110ParserRuleCallVector()))
			return true;
		return false;
	}

	protected boolean consumeGroup$15() throws Exception {
		doConsumeGroup$15();
		return true;
	}

	protected boolean doConsumeGroup$15() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$16()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$17()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$16() throws Exception {
		return consumeKeyword(getRule().ele010KeywordPlusSign(), null, false, false, DatatypeRulesTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeAssignment$17() throws Exception {
		if (consumeNonTerminal(dotsConsumer, "dots", false, true, getRule().ele0110ParserRuleCallDots()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$19() throws Exception {
		return consumeKeyword(getRule().ele1KeywordSemicolon(), null, false, false, DatatypeRulesTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	public ModelElements getRule() {
		return DatatypeRulesTestLanguageGrammarAccess.INSTANCE.prModel();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Model";
	}
	
	public void setVectorConsumer(DatatypeRulesTestLanguageVectorConsumer vectorConsumer) {
		this.vectorConsumer = vectorConsumer;
	}
	
	public void setFractionConsumer(DatatypeRulesTestLanguageFractionConsumer fractionConsumer) {
		this.fractionConsumer = fractionConsumer;
	}
	
	public void setDotsConsumer(DatatypeRulesTestLanguageDotsConsumer dotsConsumer) {
		this.dotsConsumer = dotsConsumer;
	}
	
	public void setNestedModelIdConsumer(DatatypeRulesTestLanguageNestedModelIdConsumer nestedModelIdConsumer) {
		this.nestedModelIdConsumer = nestedModelIdConsumer;
	}
	
}
