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

import org.eclipse.xtext.parser.terminalrules.services.TerminalRulesTestLanguageGrammarAccess;
import org.eclipse.xtext.parser.terminalrules.services.TerminalRulesTestLanguageGrammarAccess.ModelElements;

import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.TerminalRulesTestLanguageANY_OTHERConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.TerminalRulesTestLanguageIDConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.TerminalRulesTestLanguageINTConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.TerminalRulesTestLanguageML_COMMENTConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.TerminalRulesTestLanguageSL_COMMENTConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.TerminalRulesTestLanguageSTRINGConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.TerminalRulesTestLanguageWSConsumer;

@SuppressWarnings("unused")
public final class TerminalRulesTestLanguageModelConsumer extends NonTerminalConsumer {

	private TerminalRulesTestLanguageANY_OTHERConsumer anyOtherConsumer;
	private TerminalRulesTestLanguageIDConsumer idConsumer;
	private TerminalRulesTestLanguageINTConsumer intConsumer;
	private TerminalRulesTestLanguageML_COMMENTConsumer mlCommentConsumer;
	private TerminalRulesTestLanguageSL_COMMENTConsumer slCommentConsumer;
	private TerminalRulesTestLanguageSTRINGConsumer stringConsumer;
	private TerminalRulesTestLanguageWSConsumer wsConsumer;

	private ISequenceMatcher ruleCall$8$Delimiter;
	
	private ISequenceMatcher ruleCall$10$Delimiter;
	
	private ISequenceMatcher ruleCall$12$Delimiter;
	
	private ISequenceMatcher ruleCall$14$Delimiter;
	
	private ISequenceMatcher ruleCall$16$Delimiter;
	
	private ISequenceMatcher ruleCall$18$Delimiter;
	
	private ISequenceMatcher ruleCall$20$Delimiter;
	
	public TerminalRulesTestLanguageModelConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		ruleCall$8$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$10$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$12$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$14$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$16$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$18$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$20$Delimiter = ISequenceMatcher.Factory.nullMatcher();
	}
	
	protected boolean doConsume() throws Exception {
		return consumeAlternatives$1();
	}

	protected boolean consumeAlternatives$1() throws Exception {
		if (consumeAssignment$7())
			return true;
		if (consumeAssignment$9())
			return true;
		if (consumeAssignment$11())
			return true;
		if (consumeAssignment$13())
			return true;
		if (consumeAssignment$15())
			return true;
		if (consumeAssignment$17())
			return true;
		if (consumeAssignment$19())
			return true;
		return false;
	}

	protected boolean consumeAssignment$7() throws Exception {
		if (consumeTerminal(idConsumer, "idValue", false, false, getRule().ele0000000ParserRuleCallID(), getRuleCall$8$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeAssignment$9() throws Exception {
		if (consumeTerminal(intConsumer, "intValue", false, false, getRule().ele0000010ParserRuleCallINT(), getRuleCall$10$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeAssignment$11() throws Exception {
		if (consumeTerminal(stringConsumer, "stringValue", false, false, getRule().ele000010ParserRuleCallSTRING(), getRuleCall$12$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeAssignment$13() throws Exception {
		if (consumeTerminal(mlCommentConsumer, "mlCommentValue", false, false, getRule().ele00010ParserRuleCallML_COMMENT(), getRuleCall$14$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeAssignment$15() throws Exception {
		if (consumeTerminal(slCommentConsumer, "slCommentValue", false, false, getRule().ele0010ParserRuleCallSL_COMMENT(), getRuleCall$16$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeAssignment$17() throws Exception {
		if (consumeTerminal(wsConsumer, "wsValue", false, false, getRule().ele010ParserRuleCallWS(), getRuleCall$18$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeAssignment$19() throws Exception {
		if (consumeTerminal(anyOtherConsumer, "anyValue", false, false, getRule().ele10ParserRuleCallANY_OTHER(), getRuleCall$20$Delimiter()))
			return true;
		return false;
	}

	public ModelElements getRule() {
		return TerminalRulesTestLanguageGrammarAccess.INSTANCE.prModel();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Model";
	}
	
	public void setAnyOtherConsumer(TerminalRulesTestLanguageANY_OTHERConsumer anyOtherConsumer) {
		this.anyOtherConsumer = anyOtherConsumer;
	}
	
	public void setIdConsumer(TerminalRulesTestLanguageIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setIntConsumer(TerminalRulesTestLanguageINTConsumer intConsumer) {
		this.intConsumer = intConsumer;
	}
	
	public void setMlCommentConsumer(TerminalRulesTestLanguageML_COMMENTConsumer mlCommentConsumer) {
		this.mlCommentConsumer = mlCommentConsumer;
	}
	
	public void setSlCommentConsumer(TerminalRulesTestLanguageSL_COMMENTConsumer slCommentConsumer) {
		this.slCommentConsumer = slCommentConsumer;
	}
	
	public void setStringConsumer(TerminalRulesTestLanguageSTRINGConsumer stringConsumer) {
		this.stringConsumer = stringConsumer;
	}
	
	public void setWsConsumer(TerminalRulesTestLanguageWSConsumer wsConsumer) {
		this.wsConsumer = wsConsumer;
	}
	
	public ISequenceMatcher getRuleCall$8$Delimiter() {
		return ruleCall$8$Delimiter;
	}
	
	public void setRuleCall$8$Delimiter(ISequenceMatcher matcher) {
		ruleCall$8$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$10$Delimiter() {
		return ruleCall$10$Delimiter;
	}
	
	public void setRuleCall$10$Delimiter(ISequenceMatcher matcher) {
		ruleCall$10$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$12$Delimiter() {
		return ruleCall$12$Delimiter;
	}
	
	public void setRuleCall$12$Delimiter(ISequenceMatcher matcher) {
		ruleCall$12$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$14$Delimiter() {
		return ruleCall$14$Delimiter;
	}
	
	public void setRuleCall$14$Delimiter(ISequenceMatcher matcher) {
		ruleCall$14$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$16$Delimiter() {
		return ruleCall$16$Delimiter;
	}
	
	public void setRuleCall$16$Delimiter(ISequenceMatcher matcher) {
		ruleCall$16$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$18$Delimiter() {
		return ruleCall$18$Delimiter;
	}
	
	public void setRuleCall$18$Delimiter(ISequenceMatcher matcher) {
		ruleCall$18$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$20$Delimiter() {
		return ruleCall$20$Delimiter;
	}
	
	public void setRuleCall$20$Delimiter(ISequenceMatcher matcher) {
		ruleCall$20$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}
