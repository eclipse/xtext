/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;

import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.TerminalRulesTestLanguageModelConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.TerminalRulesTestLanguageIDConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.TerminalRulesTestLanguageINTConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.TerminalRulesTestLanguageSTRINGConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.TerminalRulesTestLanguageML_COMMENTConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.TerminalRulesTestLanguageSL_COMMENTConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.TerminalRulesTestLanguageWSConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.TerminalRulesTestLanguageANY_OTHERConsumer;

@SuppressWarnings("unused")
public class TerminalRulesTestLanguageParserConfiguration extends AbstractParserConfiguration {

    private TerminalRulesTestLanguageModelConsumer modelConsumer;
    private TerminalRulesTestLanguageIDConsumer idConsumer;
    private TerminalRulesTestLanguageINTConsumer intConsumer;
    private TerminalRulesTestLanguageSTRINGConsumer stringConsumer;
    private TerminalRulesTestLanguageML_COMMENTConsumer mlCommentConsumer;
    private TerminalRulesTestLanguageSL_COMMENTConsumer slCommentConsumer;
    private TerminalRulesTestLanguageWSConsumer wsConsumer;
    private TerminalRulesTestLanguageANY_OTHERConsumer anyOtherConsumer;

	public TerminalRulesTestLanguageParserConfiguration(IInternalParserConfiguration configuration) {
		super(configuration);
	}

	public TerminalRulesTestLanguageModelConsumer getRootConsumer() {
		return modelConsumer;
	} 

	public void createNonTerminalConsumers() {
		modelConsumer = new TerminalRulesTestLanguageModelConsumer(
    		this, null
    	);
	}
	
	public void createTerminalConsumers() {
		idConsumer = new TerminalRulesTestLanguageIDConsumer(this);
		intConsumer = new TerminalRulesTestLanguageINTConsumer(this);
		stringConsumer = new TerminalRulesTestLanguageSTRINGConsumer(this);
		mlCommentConsumer = new TerminalRulesTestLanguageML_COMMENTConsumer(this);
		slCommentConsumer = new TerminalRulesTestLanguageSL_COMMENTConsumer(this);
		wsConsumer = new TerminalRulesTestLanguageWSConsumer(this);
		anyOtherConsumer = new TerminalRulesTestLanguageANY_OTHERConsumer(this);
	}
	
	public void configureConsumers() {
		getModelConsumer().setAnyOtherConsumer(getAnyOtherConsumer());
		getModelConsumer().setIdConsumer(getIdConsumer());
		getModelConsumer().setIntConsumer(getIntConsumer());
		getModelConsumer().setMlCommentConsumer(getMlCommentConsumer());
		getModelConsumer().setSlCommentConsumer(getSlCommentConsumer());
		getModelConsumer().setStringConsumer(getStringConsumer());
		getModelConsumer().setWsConsumer(getWsConsumer());

		getModelConsumer().setRuleCall$8$Delimiter(TerminalRulesTestLanguageDelimiters.ruleCall$11$Delimiter);
		getModelConsumer().setRuleCall$10$Delimiter(TerminalRulesTestLanguageDelimiters.ruleCall$11$Delimiter);
		getModelConsumer().setRuleCall$12$Delimiter(TerminalRulesTestLanguageDelimiters.ruleCall$11$Delimiter);
		getModelConsumer().setRuleCall$14$Delimiter(TerminalRulesTestLanguageDelimiters.ruleCall$11$Delimiter);
		getModelConsumer().setRuleCall$16$Delimiter(TerminalRulesTestLanguageDelimiters.ruleCall$11$Delimiter);
		getModelConsumer().setRuleCall$18$Delimiter(TerminalRulesTestLanguageDelimiters.ruleCall$11$Delimiter);
		getModelConsumer().setRuleCall$20$Delimiter(TerminalRulesTestLanguageDelimiters.ruleCall$11$Delimiter);
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
