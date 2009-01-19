/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.transientvalues.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.builtin.parser.packrat.XtextBuiltinParserConfiguration; 

import org.eclipse.xtext.parsetree.transientvalues.parser.packrat.consumers.TransientValuesTestRootConsumer;
import org.eclipse.xtext.parsetree.transientvalues.parser.packrat.consumers.TransientValuesTestTestRequiredConsumer;
import org.eclipse.xtext.parsetree.transientvalues.parser.packrat.consumers.TransientValuesTestTestOptionalConsumer;
import org.eclipse.xtext.parsetree.transientvalues.parser.packrat.consumers.TransientValuesTestTestListConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinML_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSL_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinWSConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinANY_OTHERConsumer;

public class TransientValuesTestParserConfiguration extends AbstractParserConfiguration {

	private XtextBuiltinParserConfiguration xtextBuiltinConfiguration; 

    private TransientValuesTestRootConsumer rootConsumer;
    private TransientValuesTestTestRequiredConsumer testRequiredConsumer;
    private TransientValuesTestTestOptionalConsumer testOptionalConsumer;
    private TransientValuesTestTestListConsumer testListConsumer;

	public TransientValuesTestParserConfiguration(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil);
		this.xtextBuiltinConfiguration = new XtextBuiltinParserConfiguration(
			input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil);
	}

	public TransientValuesTestRootConsumer getRootConsumer() {
		return rootConsumer;
	} 
	
	public void createNonTerminalConsumers() {
		getXtextBuiltinConfiguration().createNonTerminalConsumers();
		rootConsumer = new TransientValuesTestRootConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(),
    		new ITerminalConsumer[]{ getWsConsumer(), getMlCommentConsumer(), getSlCommentConsumer() }
    	);
		testRequiredConsumer = new TransientValuesTestTestRequiredConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		testOptionalConsumer = new TransientValuesTestTestOptionalConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		testListConsumer = new TransientValuesTestTestListConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
	}
	
	public void createTerminalConsumers() {
		getXtextBuiltinConfiguration().createTerminalConsumers();
	}
	
	public void configureConsumers() {
		getRootConsumer$().setTestListConsumer(getTestListConsumer());
		getRootConsumer$().setTestOptionalConsumer(getTestOptionalConsumer());
		getRootConsumer$().setTestRequiredConsumer(getTestRequiredConsumer());

		getTestRequiredConsumer().setIntConsumer(getIntConsumer());

		getTestOptionalConsumer().setIntConsumer(getIntConsumer());

		getTestListConsumer().setIntConsumer(getIntConsumer());

		getRootConsumer().setKeyword$2$Delimiter(TransientValuesTestDelimiters.keyword$4$Delimiter);
		getTestRequiredConsumer().setKeyword$3$Delimiter(TransientValuesTestDelimiters.keyword$4$Delimiter);
		getTestRequiredConsumer().setRuleCall$5$Delimiter(TransientValuesTestDelimiters.ruleCall$16$Delimiter);
		getTestRequiredConsumer().setRuleCall$7$Delimiter(TransientValuesTestDelimiters.ruleCall$16$Delimiter);
		getTestOptionalConsumer().setKeyword$7$Delimiter(TransientValuesTestDelimiters.keyword$27$Delimiter);
		getTestOptionalConsumer().setKeyword$3$Delimiter(TransientValuesTestDelimiters.keyword$4$Delimiter);
		getTestOptionalConsumer().setRuleCall$5$Delimiter(TransientValuesTestDelimiters.ruleCall$16$Delimiter);
		getTestOptionalConsumer().setRuleCall$9$Delimiter(TransientValuesTestDelimiters.ruleCall$16$Delimiter);
		getTestListConsumer().setKeyword$2$Delimiter(TransientValuesTestDelimiters.keyword$4$Delimiter);
		getTestListConsumer().setRuleCall$4$Delimiter(TransientValuesTestDelimiters.ruleCall$16$Delimiter);
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
	
	public TransientValuesTestRootConsumer getRootConsumer$() {
    	return rootConsumer;
    }

    public TransientValuesTestTestRequiredConsumer getTestRequiredConsumer() {
    	return testRequiredConsumer;
    }

    public TransientValuesTestTestOptionalConsumer getTestOptionalConsumer() {
    	return testOptionalConsumer;
    }

    public TransientValuesTestTestListConsumer getTestListConsumer() {
    	return testListConsumer;
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
