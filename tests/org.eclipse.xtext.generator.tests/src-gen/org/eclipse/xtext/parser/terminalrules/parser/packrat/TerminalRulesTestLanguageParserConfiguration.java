/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.TerminalRulesTestLanguageModelConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.TerminalRulesTestLanguageIDConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.TerminalRulesTestLanguageINTConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.TerminalRulesTestLanguageSTRINGConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.TerminalRulesTestLanguageML_COMMENTConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.TerminalRulesTestLanguageSL_COMMENTConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.TerminalRulesTestLanguageWSConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.TerminalRulesTestLanguageANY_OTHERConsumer;

public class TerminalRulesTestLanguageParserConfiguration extends AbstractParserConfiguration {

    private TerminalRulesTestLanguageModelConsumer modelConsumer;
    private TerminalRulesTestLanguageIDConsumer idConsumer;
    private TerminalRulesTestLanguageINTConsumer intConsumer;
    private TerminalRulesTestLanguageSTRINGConsumer stringConsumer;
    private TerminalRulesTestLanguageML_COMMENTConsumer mlCommentConsumer;
    private TerminalRulesTestLanguageSL_COMMENTConsumer slCommentConsumer;
    private TerminalRulesTestLanguageWSConsumer wsConsumer;
    private TerminalRulesTestLanguageANY_OTHERConsumer anyOtherConsumer;

	public TerminalRulesTestLanguageParserConfiguration(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil);
	}

	public TerminalRulesTestLanguageModelConsumer getRootConsumer() {
		return modelConsumer;
	} 
	
	public void createNonTerminalConsumers() {
		modelConsumer = new TerminalRulesTestLanguageModelConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
	}
	
	public void createTerminalConsumers() {
		idConsumer = new TerminalRulesTestLanguageIDConsumer(getInput(), getMarkerFactory(), getTokenAcceptor());
		intConsumer = new TerminalRulesTestLanguageINTConsumer(getInput(), getMarkerFactory(), getTokenAcceptor());
		stringConsumer = new TerminalRulesTestLanguageSTRINGConsumer(getInput(), getMarkerFactory(), getTokenAcceptor());
		mlCommentConsumer = new TerminalRulesTestLanguageML_COMMENTConsumer(getInput(), getMarkerFactory(), getTokenAcceptor());
		slCommentConsumer = new TerminalRulesTestLanguageSL_COMMENTConsumer(getInput(), getMarkerFactory(), getTokenAcceptor());
		wsConsumer = new TerminalRulesTestLanguageWSConsumer(getInput(), getMarkerFactory(), getTokenAcceptor());
		anyOtherConsumer = new TerminalRulesTestLanguageANY_OTHERConsumer(getInput(), getMarkerFactory(), getTokenAcceptor());
	}
	
	public void configureConsumers() {
		getModelConsumer().setAnyOtherConsumer(getAnyOtherConsumer());
		getModelConsumer().setIdConsumer(getIdConsumer());
		getModelConsumer().setIntConsumer(getIntConsumer());
		getModelConsumer().setMlCommentConsumer(getMlCommentConsumer());
		getModelConsumer().setSlCommentConsumer(getSlCommentConsumer());
		getModelConsumer().setStringConsumer(getStringConsumer());
		getModelConsumer().setWsConsumer(getWsConsumer());

		getModelConsumer().setRuleCall$20$Delimiter(TerminalRulesTestLanguageDelimiters.ruleCall$11$Delimiter);
		getModelConsumer().setRuleCall$8$Delimiter(TerminalRulesTestLanguageDelimiters.ruleCall$11$Delimiter);
		getModelConsumer().setRuleCall$10$Delimiter(TerminalRulesTestLanguageDelimiters.ruleCall$11$Delimiter);
		getModelConsumer().setRuleCall$14$Delimiter(TerminalRulesTestLanguageDelimiters.ruleCall$11$Delimiter);
		getModelConsumer().setRuleCall$16$Delimiter(TerminalRulesTestLanguageDelimiters.ruleCall$11$Delimiter);
		getModelConsumer().setRuleCall$12$Delimiter(TerminalRulesTestLanguageDelimiters.ruleCall$11$Delimiter);
		getModelConsumer().setRuleCall$18$Delimiter(TerminalRulesTestLanguageDelimiters.ruleCall$11$Delimiter);
	}
	
    public TerminalRulesTestLanguageModelConsumer getModelConsumer() {
    	return modelConsumer;
    }

    public TerminalRulesTestLanguageIDConsumer getIdConsumer() {
    	return idConsumer;
    }

    public TerminalRulesTestLanguageINTConsumer getIntConsumer() {
    	return intConsumer;
    }

    public TerminalRulesTestLanguageSTRINGConsumer getStringConsumer() {
    	return stringConsumer;
    }

    public TerminalRulesTestLanguageML_COMMENTConsumer getMlCommentConsumer() {
    	return mlCommentConsumer;
    }

    public TerminalRulesTestLanguageSL_COMMENTConsumer getSlCommentConsumer() {
    	return slCommentConsumer;
    }

    public TerminalRulesTestLanguageWSConsumer getWsConsumer() {
    	return wsConsumer;
    }

    public TerminalRulesTestLanguageANY_OTHERConsumer getAnyOtherConsumer() {
    	return anyOtherConsumer;
    }


}
