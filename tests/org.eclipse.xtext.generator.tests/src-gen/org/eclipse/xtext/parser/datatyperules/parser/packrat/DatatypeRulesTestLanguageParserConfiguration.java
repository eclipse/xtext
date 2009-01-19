/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.datatyperules.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.builtin.parser.packrat.XtextBuiltinParserConfiguration; 

import org.eclipse.xtext.parser.datatyperules.parser.packrat.consumers.DatatypeRulesTestLanguageCompositeModelConsumer;
import org.eclipse.xtext.parser.datatyperules.parser.packrat.consumers.DatatypeRulesTestLanguageModelConsumer;
import org.eclipse.xtext.parser.datatyperules.parser.packrat.consumers.DatatypeRulesTestLanguageModelIdConsumer;
import org.eclipse.xtext.parser.datatyperules.parser.packrat.consumers.DatatypeRulesTestLanguageNestedModelIdConsumer;
import org.eclipse.xtext.parser.datatyperules.parser.packrat.consumers.DatatypeRulesTestLanguageFractionConsumer;
import org.eclipse.xtext.parser.datatyperules.parser.packrat.consumers.DatatypeRulesTestLanguageVectorConsumer;
import org.eclipse.xtext.parser.datatyperules.parser.packrat.consumers.DatatypeRulesTestLanguageDotsConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinML_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSL_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinWSConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinANY_OTHERConsumer;

public class DatatypeRulesTestLanguageParserConfiguration extends AbstractParserConfiguration {

	private XtextBuiltinParserConfiguration xtextBuiltinConfiguration; 

    private DatatypeRulesTestLanguageCompositeModelConsumer compositeModelConsumer;
    private DatatypeRulesTestLanguageModelConsumer modelConsumer;
    private DatatypeRulesTestLanguageModelIdConsumer modelIdConsumer;
    private DatatypeRulesTestLanguageNestedModelIdConsumer nestedModelIdConsumer;
    private DatatypeRulesTestLanguageFractionConsumer fractionConsumer;
    private DatatypeRulesTestLanguageVectorConsumer vectorConsumer;
    private DatatypeRulesTestLanguageDotsConsumer dotsConsumer;

	public DatatypeRulesTestLanguageParserConfiguration(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil);
		this.xtextBuiltinConfiguration = new XtextBuiltinParserConfiguration(
			input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil);
	}

	public DatatypeRulesTestLanguageCompositeModelConsumer getRootConsumer() {
		return compositeModelConsumer;
	} 
	
	public void createNonTerminalConsumers() {
		getXtextBuiltinConfiguration().createNonTerminalConsumers();
		compositeModelConsumer = new DatatypeRulesTestLanguageCompositeModelConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(),
    		new ITerminalConsumer[]{ getWsConsumer(), getMlCommentConsumer(), getSlCommentConsumer() }
    	);
		modelConsumer = new DatatypeRulesTestLanguageModelConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		modelIdConsumer = new DatatypeRulesTestLanguageModelIdConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		nestedModelIdConsumer = new DatatypeRulesTestLanguageNestedModelIdConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		fractionConsumer = new DatatypeRulesTestLanguageFractionConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		vectorConsumer = new DatatypeRulesTestLanguageVectorConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		dotsConsumer = new DatatypeRulesTestLanguageDotsConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
	}
	
	public void createTerminalConsumers() {
		getXtextBuiltinConfiguration().createTerminalConsumers();
	}
	
	public void configureConsumers() {
		getCompositeModelConsumer().setModelConsumer(getModelConsumer());

		getModelConsumer().setDotsConsumer(getDotsConsumer());
		getModelConsumer().setFractionConsumer(getFractionConsumer());
		getModelConsumer().setNestedModelIdConsumer(getNestedModelIdConsumer());
		getModelConsumer().setVectorConsumer(getVectorConsumer());

		getModelIdConsumer().setIdConsumer(getIdConsumer());

		getNestedModelIdConsumer().setModelIdConsumer(getModelIdConsumer());

		getFractionConsumer().setIntConsumer(getIntConsumer());

		getVectorConsumer().setIntConsumer(getIntConsumer());

		getModelConsumer().setKeyword$16$Delimiter(DatatypeRulesTestLanguageDelimiters.keyword$15$Delimiter);
		getModelConsumer().setKeyword$8$Delimiter(DatatypeRulesTestLanguageDelimiters.keyword$15$Delimiter);
		getModelConsumer().setKeyword$12$Delimiter(DatatypeRulesTestLanguageDelimiters.keyword$15$Delimiter);
		getModelConsumer().setKeyword$19$Delimiter(DatatypeRulesTestLanguageDelimiters.keyword$15$Delimiter);
		getModelIdConsumer().setRuleCall$5$Delimiter(DatatypeRulesTestLanguageDelimiters.ruleCall$31$Delimiter);
		getModelIdConsumer().setRuleCall$3$Delimiter(DatatypeRulesTestLanguageDelimiters.ruleCall$31$Delimiter);
		getModelIdConsumer().setKeyword$4$Delimiter(DatatypeRulesTestLanguageDelimiters.keyword$15$Delimiter);
		getNestedModelIdConsumer().setKeyword$4$Delimiter(DatatypeRulesTestLanguageDelimiters.keyword$15$Delimiter);
		getFractionConsumer().setRuleCall$2$Delimiter(DatatypeRulesTestLanguageDelimiters.ruleCall$31$Delimiter);
		getFractionConsumer().setRuleCall$5$Delimiter(DatatypeRulesTestLanguageDelimiters.ruleCall$31$Delimiter);
		getFractionConsumer().setKeyword$4$Delimiter(DatatypeRulesTestLanguageDelimiters.keyword$15$Delimiter);
		getVectorConsumer().setRuleCall$5$Delimiter(DatatypeRulesTestLanguageDelimiters.ruleCall$31$Delimiter);
		getVectorConsumer().setRuleCall$6$Delimiter(DatatypeRulesTestLanguageDelimiters.ruleCall$31$Delimiter);
		getVectorConsumer().setKeyword$7$Delimiter(DatatypeRulesTestLanguageDelimiters.keyword$15$Delimiter);
		getVectorConsumer().setKeyword$4$Delimiter(DatatypeRulesTestLanguageDelimiters.keyword$15$Delimiter);
		getDotsConsumer().setKeyword$5$Delimiter(DatatypeRulesTestLanguageDelimiters.keyword$15$Delimiter);
		getDotsConsumer().setKeyword$4$Delimiter(DatatypeRulesTestLanguageDelimiters.keyword$15$Delimiter);
		getDotsConsumer().setKeyword$3$Delimiter(DatatypeRulesTestLanguageDelimiters.keyword$15$Delimiter);
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
	
    public DatatypeRulesTestLanguageCompositeModelConsumer getCompositeModelConsumer() {
    	return compositeModelConsumer;
    }

    public DatatypeRulesTestLanguageModelConsumer getModelConsumer() {
    	return modelConsumer;
    }

    public DatatypeRulesTestLanguageModelIdConsumer getModelIdConsumer() {
    	return modelIdConsumer;
    }

    public DatatypeRulesTestLanguageNestedModelIdConsumer getNestedModelIdConsumer() {
    	return nestedModelIdConsumer;
    }

    public DatatypeRulesTestLanguageFractionConsumer getFractionConsumer() {
    	return fractionConsumer;
    }

    public DatatypeRulesTestLanguageVectorConsumer getVectorConsumer() {
    	return vectorConsumer;
    }

    public DatatypeRulesTestLanguageDotsConsumer getDotsConsumer() {
    	return dotsConsumer;
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
