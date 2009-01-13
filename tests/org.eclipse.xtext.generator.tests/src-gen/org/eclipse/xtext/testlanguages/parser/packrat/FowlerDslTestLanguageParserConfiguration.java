/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

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

public class FowlerDslTestLanguageParserConfiguration extends AbstractParserConfiguration {

	private XtextBuiltinParserConfiguration xtextBuiltinConfiguration; 

    private FowlerDslTestLanguageStatemachineConsumer statemachineConsumer;
    private FowlerDslTestLanguageEventConsumer eventConsumer;
    private FowlerDslTestLanguageCommandConsumer commandConsumer;
    private FowlerDslTestLanguageStateConsumer stateConsumer;
    private FowlerDslTestLanguageTransitionConsumer transitionConsumer;

	public FowlerDslTestLanguageParserConfiguration(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil);
		this.xtextBuiltinConfiguration = new XtextBuiltinParserConfiguration(
			input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil);
	}

	public FowlerDslTestLanguageStatemachineConsumer getRootConsumer() {
		return statemachineConsumer;
	} 
	
	public void createNonTerminalConsumers() {
		getXtextBuiltinConfiguration().createNonTerminalConsumers();
		statemachineConsumer = new FowlerDslTestLanguageStatemachineConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(),
    		new ITerminalConsumer[]{ getWsConsumer(), getMlCommentConsumer(), getSlCommentConsumer() }
    	);
		eventConsumer = new FowlerDslTestLanguageEventConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		commandConsumer = new FowlerDslTestLanguageCommandConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		stateConsumer = new FowlerDslTestLanguageStateConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		transitionConsumer = new FowlerDslTestLanguageTransitionConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
	}
	
	public void createTerminalConsumers() {
		getXtextBuiltinConfiguration().createTerminalConsumers();
	}
	
	public void configureConsumers() {
		getStatemachineConsumer().setStateConsumer(getStateConsumer());
		getStatemachineConsumer().setCommandConsumer(getCommandConsumer());
		getStatemachineConsumer().setEventConsumer(getEventConsumer());

		getEventConsumer().setIdConsumer(getIdConsumer());

		getCommandConsumer().setIdConsumer(getIdConsumer());

		getStateConsumer().setTransitionConsumer(getTransitionConsumer());
		getStateConsumer().setIdConsumer(getIdConsumer());

		getTransitionConsumer().setIdConsumer(getIdConsumer());

		getIdConsumer().initFields(this);
		getIntConsumer().initFields(this);
		getStringConsumer().initFields(this);
		getMlCommentConsumer().initFields(this);
		getSlCommentConsumer().initFields(this);
		getWsConsumer().initFields(this);
		getAnyOtherConsumer().initFields(this);
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
