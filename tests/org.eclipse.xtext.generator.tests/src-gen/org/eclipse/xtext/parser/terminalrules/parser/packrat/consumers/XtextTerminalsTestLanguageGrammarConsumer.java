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
import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess.GrammarElements;

import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageAbstractMetamodelDeclarationConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageAbstractRuleConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageIDConsumer;

@SuppressWarnings("unused")
public final class XtextTerminalsTestLanguageGrammarConsumer extends NonTerminalConsumer {

	private XtextTerminalsTestLanguageAbstractMetamodelDeclarationConsumer abstractMetamodelDeclarationConsumer;
	private XtextTerminalsTestLanguageAbstractRuleConsumer abstractRuleConsumer;
	private XtextTerminalsTestLanguageIDConsumer idConsumer;

	private ICharacterClass keyword$13$Delimiter;
	
	private ICharacterClass keyword$22$Delimiter;
	
	private ISequenceMatcher ruleCall$11$Delimiter;
	
	private ISequenceMatcher ruleCall$24$Delimiter;
	
	private ISequenceMatcher ruleCall$15$Delimiter;
	
	private ISequenceMatcher ruleCall$20$Delimiter;
	
	private ICharacterClass keyword$8$Delimiter;
	
	private ICharacterClass keyword$18$Delimiter;
	
	private ICharacterClass keyword$9$Delimiter;
	
	public XtextTerminalsTestLanguageGrammarConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		keyword$13$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$22$Delimiter = ICharacterClass.Factory.nullClass();
		ruleCall$11$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$24$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$15$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$20$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		keyword$8$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$18$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$9$Delimiter = ICharacterClass.Factory.nullClass();
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeAlternatives$6()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$10()) {
			marker.rollback();
			return false;
		}
		if (!consumeGroup$12()) {
			marker.rollback();
			return false;
		}
		if (!consumeGroup$16()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$25()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$27()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeAlternatives$6() throws Exception {
		if (consumeAssignment$7())
			return true;
		if (consumeKeyword$9())
			return true;
		return false;
	}

	protected boolean consumeAssignment$7() throws Exception {
		if (consumeKeyword(getRule().ele0000000KeywordAbstractLanguage(), "abstract", false, true, getKeyword$8$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$9() throws Exception {
		return consumeKeyword(getRule().ele000001KeywordLanguage(), null, false, false, getKeyword$9$Delimiter());
	}

	protected boolean consumeAssignment$10() throws Exception {
		if (consumeTerminal(idConsumer, "idElements", true, false, getRule().ele000010ParserRuleCallID(), getRuleCall$11$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeGroup$12() throws Exception {
		while(doConsumeGroup$12()) {}
		return true;
	}

	protected boolean doConsumeGroup$12() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$13()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$14()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$13() throws Exception {
		return consumeKeyword(getRule().ele00010KeywordFullStop(), null, false, false, getKeyword$13$Delimiter());
	}

	protected boolean consumeAssignment$14() throws Exception {
		if (consumeTerminal(idConsumer, "idElements", true, false, getRule().ele000110ParserRuleCallID(), getRuleCall$15$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeGroup$16() throws Exception {
		doConsumeGroup$16();
		return true;
	}

	protected boolean doConsumeGroup$16() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$18()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$19()) {
			marker.rollback();
			return false;
		}
		if (!consumeGroup$21()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$18() throws Exception {
		return consumeKeyword(getRule().ele00100KeywordExtends(), null, false, false, getKeyword$18$Delimiter());
	}

	protected boolean consumeAssignment$19() throws Exception {
		if (consumeTerminal(idConsumer, "superGrammarIdElements", true, false, getRule().ele001010ParserRuleCallID(), getRuleCall$20$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeGroup$21() throws Exception {
		while(doConsumeGroup$21()) {}
		return true;
	}

	protected boolean doConsumeGroup$21() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$22()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$23()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$22() throws Exception {
		return consumeKeyword(getRule().ele00110KeywordFullStop(), null, false, false, getKeyword$22$Delimiter());
	}

	protected boolean consumeAssignment$23() throws Exception {
		if (consumeTerminal(idConsumer, "superGrammarIdElements", true, false, getRule().ele001110ParserRuleCallID(), getRuleCall$24$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeAssignment$25() throws Exception {
		while(doConsumeAssignment$25()) {}
		return true;
	}

	protected boolean doConsumeAssignment$25() throws Exception {
		if (consumeNonTerminal(abstractMetamodelDeclarationConsumer, "metamodelDeclarations", true, false, getRule().ele010ParserRuleCallAbstractMetamodelDeclaration()))
			return true;
		return false;
	}

	protected boolean consumeAssignment$27() throws Exception {
		if (doConsumeAssignment$27()) {
			while(doConsumeAssignment$27()) {}
			return true;
		}
		return false;
	}

	protected boolean doConsumeAssignment$27() throws Exception {
		if (consumeNonTerminal(abstractRuleConsumer, "rules", true, false, getRule().ele10ParserRuleCallAbstractRule()))
			return true;
		return false;
	}

	public GrammarElements getRule() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGrammar();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Grammar";
	}
	
	public void setAbstractMetamodelDeclarationConsumer(XtextTerminalsTestLanguageAbstractMetamodelDeclarationConsumer abstractMetamodelDeclarationConsumer) {
		this.abstractMetamodelDeclarationConsumer = abstractMetamodelDeclarationConsumer;
	}
	
	public void setAbstractRuleConsumer(XtextTerminalsTestLanguageAbstractRuleConsumer abstractRuleConsumer) {
		this.abstractRuleConsumer = abstractRuleConsumer;
	}
	
	public void setIdConsumer(XtextTerminalsTestLanguageIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public ICharacterClass getKeyword$13$Delimiter() {
		return keyword$13$Delimiter;
	}
	
	public void setKeyword$13$Delimiter(ICharacterClass characterClass) {
		keyword$13$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$22$Delimiter() {
		return keyword$22$Delimiter;
	}
	
	public void setKeyword$22$Delimiter(ICharacterClass characterClass) {
		keyword$22$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ISequenceMatcher getRuleCall$11$Delimiter() {
		return ruleCall$11$Delimiter;
	}
	
	public void setRuleCall$11$Delimiter(ISequenceMatcher matcher) {
		ruleCall$11$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$24$Delimiter() {
		return ruleCall$24$Delimiter;
	}
	
	public void setRuleCall$24$Delimiter(ISequenceMatcher matcher) {
		ruleCall$24$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$15$Delimiter() {
		return ruleCall$15$Delimiter;
	}
	
	public void setRuleCall$15$Delimiter(ISequenceMatcher matcher) {
		ruleCall$15$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$20$Delimiter() {
		return ruleCall$20$Delimiter;
	}
	
	public void setRuleCall$20$Delimiter(ISequenceMatcher matcher) {
		ruleCall$20$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ICharacterClass getKeyword$8$Delimiter() {
		return keyword$8$Delimiter;
	}
	
	public void setKeyword$8$Delimiter(ICharacterClass characterClass) {
		keyword$8$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$18$Delimiter() {
		return keyword$18$Delimiter;
	}
	
	public void setKeyword$18$Delimiter(ICharacterClass characterClass) {
		keyword$18$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$9$Delimiter() {
		return keyword$9$Delimiter;
	}
	
	public void setKeyword$9$Delimiter(ICharacterClass characterClass) {
		keyword$9$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
}
