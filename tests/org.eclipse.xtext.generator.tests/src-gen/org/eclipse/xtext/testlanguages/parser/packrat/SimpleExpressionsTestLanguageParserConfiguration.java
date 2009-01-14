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

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.SimpleExpressionsTestLanguageSequenceConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.SimpleExpressionsTestLanguageAdditionConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.SimpleExpressionsTestLanguageMultiplicationConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.SimpleExpressionsTestLanguageTermConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.SimpleExpressionsTestLanguageAtomConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.SimpleExpressionsTestLanguageParensConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinML_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSL_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinWSConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinANY_OTHERConsumer;

public class SimpleExpressionsTestLanguageParserConfiguration extends AbstractParserConfiguration {

	private XtextBuiltinParserConfiguration xtextBuiltinConfiguration; 

    private SimpleExpressionsTestLanguageSequenceConsumer sequenceConsumer;
    private SimpleExpressionsTestLanguageAdditionConsumer additionConsumer;
    private SimpleExpressionsTestLanguageMultiplicationConsumer multiplicationConsumer;
    private SimpleExpressionsTestLanguageTermConsumer termConsumer;
    private SimpleExpressionsTestLanguageAtomConsumer atomConsumer;
    private SimpleExpressionsTestLanguageParensConsumer parensConsumer;

	public SimpleExpressionsTestLanguageParserConfiguration(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil);
		this.xtextBuiltinConfiguration = new XtextBuiltinParserConfiguration(
			input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil);
	}

	public SimpleExpressionsTestLanguageSequenceConsumer getRootConsumer() {
		return sequenceConsumer;
	} 
	
	public void createNonTerminalConsumers() {
		getXtextBuiltinConfiguration().createNonTerminalConsumers();
		sequenceConsumer = new SimpleExpressionsTestLanguageSequenceConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(),
    		new ITerminalConsumer[]{ getWsConsumer(), getMlCommentConsumer(), getSlCommentConsumer() }
    	);
		additionConsumer = new SimpleExpressionsTestLanguageAdditionConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		multiplicationConsumer = new SimpleExpressionsTestLanguageMultiplicationConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		termConsumer = new SimpleExpressionsTestLanguageTermConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		atomConsumer = new SimpleExpressionsTestLanguageAtomConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		parensConsumer = new SimpleExpressionsTestLanguageParensConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
	}
	
	public void createTerminalConsumers() {
		getXtextBuiltinConfiguration().createTerminalConsumers();
	}
	
	public void configureConsumers() {
		getSequenceConsumer().setAdditionConsumer(getAdditionConsumer());

		getAdditionConsumer().setMultiplicationConsumer(getMultiplicationConsumer());

		getMultiplicationConsumer().setTermConsumer(getTermConsumer());

		getTermConsumer().setAtomConsumer(getAtomConsumer());
		getTermConsumer().setParensConsumer(getParensConsumer());

		getAtomConsumer().setIdConsumer(getIdConsumer());

		getParensConsumer().setAdditionConsumer(getAdditionConsumer());

		getAdditionConsumer().setKeyword$9$Delimiter(SimpleExpressionsTestLanguageDelimiters.keyword$20$Delimiter);
		getAdditionConsumer().setKeyword$10$Delimiter(SimpleExpressionsTestLanguageDelimiters.keyword$20$Delimiter);
		getMultiplicationConsumer().setKeyword$9$Delimiter(SimpleExpressionsTestLanguageDelimiters.keyword$20$Delimiter);
		getMultiplicationConsumer().setKeyword$10$Delimiter(SimpleExpressionsTestLanguageDelimiters.keyword$20$Delimiter);
		getAtomConsumer().setRuleCall$2$Delimiter(SimpleExpressionsTestLanguageDelimiters.ruleCall$46$Delimiter);
		getParensConsumer().setKeyword$5$Delimiter(SimpleExpressionsTestLanguageDelimiters.keyword$20$Delimiter);
		getParensConsumer().setKeyword$3$Delimiter(SimpleExpressionsTestLanguageDelimiters.keyword$20$Delimiter);
		// TODO remove workaround
		getIdConsumer().initFields(this);
		// TODO remove workaround
		getIntConsumer().initFields(this);
		// TODO remove workaround
		getStringConsumer().initFields(this);
		// TODO remove workaround
		getMlCommentConsumer().initFields(this);
		// TODO remove workaround
		getSlCommentConsumer().initFields(this);
		// TODO remove workaround
		getWsConsumer().initFields(this);
		// TODO remove workaround
		getAnyOtherConsumer().initFields(this);
	}
	
	// TODO collect superGrammars transitive
	public XtextBuiltinParserConfiguration getXtextBuiltinConfiguration() {
		return xtextBuiltinConfiguration;
	} 
	
    public SimpleExpressionsTestLanguageSequenceConsumer getSequenceConsumer() {
    	return sequenceConsumer;
    }

    public SimpleExpressionsTestLanguageAdditionConsumer getAdditionConsumer() {
    	return additionConsumer;
    }

    public SimpleExpressionsTestLanguageMultiplicationConsumer getMultiplicationConsumer() {
    	return multiplicationConsumer;
    }

    public SimpleExpressionsTestLanguageTermConsumer getTermConsumer() {
    	return termConsumer;
    }

    public SimpleExpressionsTestLanguageAtomConsumer getAtomConsumer() {
    	return atomConsumer;
    }

    public SimpleExpressionsTestLanguageParensConsumer getParensConsumer() {
    	return parensConsumer;
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
