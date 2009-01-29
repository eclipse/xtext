/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;

import org.eclipse.xtext.builtin.parser.packrat.XtextBuiltinParserConfiguration; 

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.FowlerDslTestLanguageStatemachineConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.FowlerDslTestLanguageEventConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.FowlerDslTestLanguageCommandConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.FowlerDslTestLanguageStateConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.FowlerDslTestLanguageTransitionConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinML_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSL_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinWSConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinANY_OTHERConsumer;

@SuppressWarnings("unused")
public class FowlerDslTestLanguageParserConfiguration extends AbstractParserConfiguration {

	private XtextBuiltinParserConfiguration xtextBuiltinConfiguration; 

    private FowlerDslTestLanguageStatemachineConsumer statemachineConsumer;
    private FowlerDslTestLanguageEventConsumer eventConsumer;
    private FowlerDslTestLanguageCommandConsumer commandConsumer;
    private FowlerDslTestLanguageStateConsumer stateConsumer;
    private FowlerDslTestLanguageTransitionConsumer transitionConsumer;

	public FowlerDslTestLanguageParserConfiguration(IInternalParserConfiguration configuration) {
		super(configuration);
		this.xtextBuiltinConfiguration = new XtextBuiltinParserConfiguration(configuration);
	}

	public FowlerDslTestLanguageStatemachineConsumer getRootConsumer() {
		return statemachineConsumer;
	} 
	
	public void createNonTerminalConsumers() {
		getXtextBuiltinConfiguration().createNonTerminalConsumers();
		statemachineConsumer = new FowlerDslTestLanguageStatemachineConsumer(
    		this, null
    	);
		eventConsumer = new FowlerDslTestLanguageEventConsumer(
    		this, null
    	);
		commandConsumer = new FowlerDslTestLanguageCommandConsumer(
    		this, null
    	);
		stateConsumer = new FowlerDslTestLanguageStateConsumer(
    		this, null
    	);
		transitionConsumer = new FowlerDslTestLanguageTransitionConsumer(
    		this, null
    	);
	}
	
	public void createTerminalConsumers() {
		getXtextBuiltinConfiguration().createTerminalConsumers();
	}
	
	public void configureConsumers() {
		getStatemachineConsumer().setCommandConsumer(getCommandConsumer());
		getStatemachineConsumer().setEventConsumer(getEventConsumer());
		getStatemachineConsumer().setStateConsumer(getStateConsumer());

		getEventConsumer().setIdConsumer(getIdConsumer());

		getCommandConsumer().setIdConsumer(getIdConsumer());

		getStateConsumer().setIdConsumer(getIdConsumer());
		getStateConsumer().setTransitionConsumer(getTransitionConsumer());

		getTransitionConsumer().setIdConsumer(getIdConsumer());

		getStatemachineConsumer().setKeyword$10$Delimiter(FowlerDslTestLanguageDelimiters.keyword$9$Delimiter);
		getStatemachineConsumer().setKeyword$11$Delimiter(FowlerDslTestLanguageDelimiters.keyword$9$Delimiter);
		getStatemachineConsumer().setKeyword$14$Delimiter(FowlerDslTestLanguageDelimiters.keyword$9$Delimiter);
		getStatemachineConsumer().setKeyword$7$Delimiter(FowlerDslTestLanguageDelimiters.keyword$9$Delimiter);
		getEventConsumer().setKeyword$4$Delimiter(FowlerDslTestLanguageDelimiters.keyword$9$Delimiter);
		getEventConsumer().setRuleCall$6$Delimiter(FowlerDslTestLanguageDelimiters.ruleCall$26$Delimiter);
		getEventConsumer().setRuleCall$8$Delimiter(FowlerDslTestLanguageDelimiters.ruleCall$26$Delimiter);
		getCommandConsumer().setRuleCall$3$Delimiter(FowlerDslTestLanguageDelimiters.ruleCall$26$Delimiter);
		getCommandConsumer().setRuleCall$5$Delimiter(FowlerDslTestLanguageDelimiters.ruleCall$26$Delimiter);
		getStateConsumer().setCrossReference$14$Delimiter(FowlerDslTestLanguageDelimiters.ruleCall$26$Delimiter);
		getStateConsumer().setKeyword$5$Delimiter(FowlerDslTestLanguageDelimiters.keyword$9$Delimiter);
		getStateConsumer().setKeyword$11$Delimiter(FowlerDslTestLanguageDelimiters.keyword$9$Delimiter);
		getStateConsumer().setKeyword$12$Delimiter(FowlerDslTestLanguageDelimiters.keyword$49$Delimiter);
		getStateConsumer().setKeyword$16$Delimiter(FowlerDslTestLanguageDelimiters.keyword$49$Delimiter);
		getStateConsumer().setKeyword$19$Delimiter(FowlerDslTestLanguageDelimiters.keyword$9$Delimiter);
		getStateConsumer().setRuleCall$7$Delimiter(FowlerDslTestLanguageDelimiters.ruleCall$26$Delimiter);
		getTransitionConsumer().setCrossReference$4$Delimiter(FowlerDslTestLanguageDelimiters.ruleCall$26$Delimiter);
		getTransitionConsumer().setCrossReference$8$Delimiter(FowlerDslTestLanguageDelimiters.ruleCall$26$Delimiter);
		getTransitionConsumer().setKeyword$6$Delimiter(FowlerDslTestLanguageDelimiters.keyword$49$Delimiter);
	}
	
	// TODO collect superGrammars transitive
	public XtextBuiltinParserConfiguration getXtextBuiltinConfiguration() {
		return xtextBuiltinConfiguration;
	} 
	
    public FowlerDslTestLanguageStatemachineConsumer getStatemachineConsumer() {
    	return statemachineConsumer;
    }

    public FowlerDslTestLanguageEventConsumer getEventConsumer() {
    	return eventConsumer;
    }

    public FowlerDslTestLanguageCommandConsumer getCommandConsumer() {
    	return commandConsumer;
    }

    public FowlerDslTestLanguageStateConsumer getStateConsumer() {
    	return stateConsumer;
    }

    public FowlerDslTestLanguageTransitionConsumer getTransitionConsumer() {
    	return transitionConsumer;
    }

    public XtextBuiltinIDConsumer getIdConsumer() {
    	return getXtextBuiltinConfiguration().getIdConsumer();
    }

    public XtextBuiltinINTConsumer getIntConsumer() {
    	return getXtextBuiltinConfiguration().getIntConsumer();
    }

    public XtextBuiltinSTRINGConsumer getStringConsumer() {
    	return getXtextBuiltinConfiguration().getStringConsumer();
    }

    public XtextBuiltinML_COMMENTConsumer getMlCommentConsumer() {
    	return getXtextBuiltinConfiguration().getMlCommentConsumer();
    }

    public XtextBuiltinSL_COMMENTConsumer getSlCommentConsumer() {
    	return getXtextBuiltinConfiguration().getSlCommentConsumer();
    }

    public XtextBuiltinWSConsumer getWsConsumer() {
    	return getXtextBuiltinConfiguration().getWsConsumer();
    }

    public XtextBuiltinANY_OTHERConsumer getAnyOtherConsumer() {
    	return getXtextBuiltinConfiguration().getAnyOtherConsumer();
    }


}
