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
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess;
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess.GeneratedMetamodelElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;

@SuppressWarnings("unused")
public final class XtextGrammarTestLanguageGeneratedMetamodelConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;
	private XtextBuiltinSTRINGConsumer stringConsumer;

	private ISequenceMatcher ruleCall$13$Delimiter;
	
	private ISequenceMatcher ruleCall$6$Delimiter;
	
	private ISequenceMatcher crossReference$8$Delimiter;
	
	private ICharacterClass keyword$11$Delimiter;
	
	private ICharacterClass keyword$4$Delimiter;
	
	public XtextGrammarTestLanguageGeneratedMetamodelConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		ruleCall$13$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$6$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		crossReference$8$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		keyword$11$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$4$Delimiter = ICharacterClass.Factory.nullClass();
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
		if (!consumeAssignment$5()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$7()) {
			marker.rollback();
			return false;
		}
		if (!consumeGroup$10()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$4() throws Exception {
		return consumeKeyword(getRule().ele000KeywordGenerate(), null, false, false, getKeyword$4$Delimiter());
	}

	protected boolean consumeAssignment$5() throws Exception {
		if (consumeTerminal(idConsumer, "name", false, false, getRule().ele0010LexerRuleCallID(), getRuleCall$6$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeAssignment$7() throws Exception {
		if (consumeTerminal(stringConsumer, null, false, false, getRule().ele010CrossReferenceEStringEPackage(), getCrossReference$8$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeGroup$10() throws Exception {
		doConsumeGroup$10();
		return true;
	}

	protected boolean doConsumeGroup$10() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$11()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$12()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$11() throws Exception {
		return consumeKeyword(getRule().ele10KeywordAs(), null, false, false, getKeyword$11$Delimiter());
	}

	protected boolean consumeAssignment$12() throws Exception {
		if (consumeTerminal(idConsumer, "alias", false, false, getRule().ele110LexerRuleCallID(), getRuleCall$13$Delimiter()))
			return true;
		return false;
	}

	public GeneratedMetamodelElements getRule() {
		return XtextGrammarTestLanguageGrammarAccess.INSTANCE.prGeneratedMetamodel();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "GeneratedMetamodel";
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setStringConsumer(XtextBuiltinSTRINGConsumer stringConsumer) {
		this.stringConsumer = stringConsumer;
	}
	
	public ISequenceMatcher getRuleCall$13$Delimiter() {
		return ruleCall$13$Delimiter;
	}
	
	public void setRuleCall$13$Delimiter(ISequenceMatcher matcher) {
		ruleCall$13$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$6$Delimiter() {
		return ruleCall$6$Delimiter;
	}
	
	public void setRuleCall$6$Delimiter(ISequenceMatcher matcher) {
		ruleCall$6$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getCrossReference$8$Delimiter() {
		return crossReference$8$Delimiter;
	}
	
	public void setCrossReference$8$Delimiter(ISequenceMatcher matcher) {
		crossReference$8$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ICharacterClass getKeyword$11$Delimiter() {
		return keyword$11$Delimiter;
	}
	
	public void setKeyword$11$Delimiter(ICharacterClass characterClass) {
		keyword$11$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$4$Delimiter() {
		return keyword$4$Delimiter;
	}
	
	public void setKeyword$4$Delimiter(ICharacterClass characterClass) {
		keyword$4$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
}
