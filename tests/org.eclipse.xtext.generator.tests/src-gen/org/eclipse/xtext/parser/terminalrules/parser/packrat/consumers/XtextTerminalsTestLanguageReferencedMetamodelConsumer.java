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
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess;
import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess.ReferencedMetamodelElements;

import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageIDConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageSTRINGConsumer;

@SuppressWarnings("unused")
public final class XtextTerminalsTestLanguageReferencedMetamodelConsumer extends NonTerminalConsumer {

	private XtextTerminalsTestLanguageIDConsumer idConsumer;
	private XtextTerminalsTestLanguageSTRINGConsumer stringConsumer;

	private ISequenceMatcher ruleCall$10$Delimiter;
	
	private ISequenceMatcher crossReference$5$Delimiter;
	
	private ICharacterClass keyword$8$Delimiter;
	
	private ICharacterClass keyword$3$Delimiter;
	
	public XtextTerminalsTestLanguageReferencedMetamodelConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		ruleCall$10$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		crossReference$5$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		keyword$8$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$3$Delimiter = ICharacterClass.Factory.nullClass();
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$3()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$4()) {
			marker.rollback();
			return false;
		}
		if (!consumeGroup$7()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$3() throws Exception {
		return consumeKeyword(getRule().ele00KeywordImport(), null, false, false, getKeyword$3$Delimiter());
	}

	protected boolean consumeAssignment$4() throws Exception {
		if (consumeTerminal(stringConsumer, null, false, false, getRule().ele010CrossReferenceEStringEPackage(), getCrossReference$5$Delimiter()))
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
		return consumeKeyword(getRule().ele10KeywordAs(), null, false, false, getKeyword$8$Delimiter());
	}

	protected boolean consumeAssignment$9() throws Exception {
		if (consumeTerminal(idConsumer, "alias", false, false, getRule().ele110ParserRuleCallID(), getRuleCall$10$Delimiter()))
			return true;
		return false;
	}

	public ReferencedMetamodelElements getRule() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prReferencedMetamodel();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "ReferencedMetamodel";
	}
	
	public void setIdConsumer(XtextTerminalsTestLanguageIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setStringConsumer(XtextTerminalsTestLanguageSTRINGConsumer stringConsumer) {
		this.stringConsumer = stringConsumer;
	}
	
	public ISequenceMatcher getRuleCall$10$Delimiter() {
		return ruleCall$10$Delimiter;
	}
	
	public void setRuleCall$10$Delimiter(ISequenceMatcher matcher) {
		ruleCall$10$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getCrossReference$5$Delimiter() {
		return crossReference$5$Delimiter;
	}
	
	public void setCrossReference$5$Delimiter(ISequenceMatcher matcher) {
		crossReference$5$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ICharacterClass getKeyword$8$Delimiter() {
		return keyword$8$Delimiter;
	}
	
	public void setKeyword$8$Delimiter(ICharacterClass characterClass) {
		keyword$8$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$3$Delimiter() {
		return keyword$3$Delimiter;
	}
	
	public void setKeyword$3$Delimiter(ICharacterClass characterClass) {
		keyword$3$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
}
