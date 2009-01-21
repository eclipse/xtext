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
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.parser.datatyperules.services.DatatypeRulesTestLanguageGrammarAccess;
import org.eclipse.xtext.parser.datatyperules.services.DatatypeRulesTestLanguageGrammarAccess.ModelElements;

import org.eclipse.xtext.parser.datatyperules.parser.packrat.consumers.DatatypeRulesTestLanguageDotsConsumer;
import org.eclipse.xtext.parser.datatyperules.parser.packrat.consumers.DatatypeRulesTestLanguageFractionConsumer;
import org.eclipse.xtext.parser.datatyperules.parser.packrat.consumers.DatatypeRulesTestLanguageNestedModelIdConsumer;
import org.eclipse.xtext.parser.datatyperules.parser.packrat.consumers.DatatypeRulesTestLanguageVectorConsumer;

@SuppressWarnings("unused")
public final class DatatypeRulesTestLanguageModelConsumer extends NonTerminalConsumer {

	private DatatypeRulesTestLanguageDotsConsumer dotsConsumer;
	private DatatypeRulesTestLanguageFractionConsumer fractionConsumer;
	private DatatypeRulesTestLanguageNestedModelIdConsumer nestedModelIdConsumer;
	private DatatypeRulesTestLanguageVectorConsumer vectorConsumer;

	private ICharacterClass keyword$8$Delimiter;
	
	private ICharacterClass keyword$12$Delimiter;
	
	private ICharacterClass keyword$16$Delimiter;
	
	private ICharacterClass keyword$19$Delimiter;
	
	public DatatypeRulesTestLanguageModelConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		keyword$8$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$12$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$16$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$19$Delimiter = ICharacterClass.Factory.nullClass();
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeAssignment$5()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeGroup$7()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeGroup$11()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeGroup$15()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeKeyword$19()) {
			marker.rollback();
			marker.release();
			return false;
		}
		marker.release();
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
			marker.release();
			return false;
		}
		if (!consumeAssignment$9()) {
			marker.rollback();
			marker.release();
			return false;
		}
		marker.release();
		return true;
	}

	protected boolean consumeKeyword$8() throws Exception {
		return consumeKeyword(getRule().ele00010KeywordColon(), null, false, false, getKeyword$8$Delimiter());
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
			marker.release();
			return false;
		}
		if (!consumeAssignment$13()) {
			marker.rollback();
			marker.release();
			return false;
		}
		marker.release();
		return true;
	}

	protected boolean consumeKeyword$12() throws Exception {
		return consumeKeyword(getRule().ele0010KeywordNumberSign(), null, false, false, getKeyword$12$Delimiter());
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
			marker.release();
			return false;
		}
		if (!consumeAssignment$17()) {
			marker.rollback();
			marker.release();
			return false;
		}
		marker.release();
		return true;
	}

	protected boolean consumeKeyword$16() throws Exception {
		return consumeKeyword(getRule().ele010KeywordPlusSign(), null, false, false, getKeyword$16$Delimiter());
	}

	protected boolean consumeAssignment$17() throws Exception {
		if (consumeNonTerminal(dotsConsumer, "dots", false, true, getRule().ele0110ParserRuleCallDots()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$19() throws Exception {
		return consumeKeyword(getRule().ele1KeywordSemicolon(), null, false, false, getKeyword$19$Delimiter());
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
	
	public void setDotsConsumer(DatatypeRulesTestLanguageDotsConsumer dotsConsumer) {
		this.dotsConsumer = dotsConsumer;
	}
	
	public void setFractionConsumer(DatatypeRulesTestLanguageFractionConsumer fractionConsumer) {
		this.fractionConsumer = fractionConsumer;
	}
	
	public void setNestedModelIdConsumer(DatatypeRulesTestLanguageNestedModelIdConsumer nestedModelIdConsumer) {
		this.nestedModelIdConsumer = nestedModelIdConsumer;
	}
	
	public void setVectorConsumer(DatatypeRulesTestLanguageVectorConsumer vectorConsumer) {
		this.vectorConsumer = vectorConsumer;
	}
	
	public ICharacterClass getKeyword$8$Delimiter() {
		return keyword$8$Delimiter;
	}
	
	public void setKeyword$8$Delimiter(ICharacterClass characterClass) {
		keyword$8$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$12$Delimiter() {
		return keyword$12$Delimiter;
	}
	
	public void setKeyword$12$Delimiter(ICharacterClass characterClass) {
		keyword$12$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$16$Delimiter() {
		return keyword$16$Delimiter;
	}
	
	public void setKeyword$16$Delimiter(ICharacterClass characterClass) {
		keyword$16$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$19$Delimiter() {
		return keyword$19$Delimiter;
	}
	
	public void setKeyword$19$Delimiter(ICharacterClass characterClass) {
		keyword$19$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
}
