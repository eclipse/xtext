/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.builtin.parser.packrat.XtextBuiltinParserConfiguration; 

import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.SimpleReconstrTestLanguageOpConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.SimpleReconstrTestLanguageTermConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.SimpleReconstrTestLanguageAtomConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.SimpleReconstrTestLanguageParensConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.SimpleReconstrTestLanguageTwoNumbersConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.SimpleReconstrTestLanguageManyStringsConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.SimpleReconstrTestLanguageTypeConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.SimpleReconstrTestLanguageRef2Consumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.SimpleReconstrTestLanguageSpareConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinML_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSL_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinWSConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinANY_OTHERConsumer;

public class SimpleReconstrTestLanguageParserConfiguration extends AbstractParserConfiguration {

	private XtextBuiltinParserConfiguration xtextBuiltinConfiguration; 

    private SimpleReconstrTestLanguageOpConsumer opConsumer;
    private SimpleReconstrTestLanguageTermConsumer termConsumer;
    private SimpleReconstrTestLanguageAtomConsumer atomConsumer;
    private SimpleReconstrTestLanguageParensConsumer parensConsumer;
    private SimpleReconstrTestLanguageTwoNumbersConsumer twoNumbersConsumer;
    private SimpleReconstrTestLanguageManyStringsConsumer manyStringsConsumer;
    private SimpleReconstrTestLanguageTypeConsumer typeConsumer;
    private SimpleReconstrTestLanguageRef2Consumer ref2Consumer;
    private SimpleReconstrTestLanguageSpareConsumer spareConsumer;

	public SimpleReconstrTestLanguageParserConfiguration(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil);
		this.xtextBuiltinConfiguration = new XtextBuiltinParserConfiguration(
			input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil);
	}

	public SimpleReconstrTestLanguageOpConsumer getRootConsumer() {
		return opConsumer;
	} 
	
	public void createNonTerminalConsumers() {
		getXtextBuiltinConfiguration().createNonTerminalConsumers();
		opConsumer = new SimpleReconstrTestLanguageOpConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(),
    		new ITerminalConsumer[]{ getWsConsumer(), getMlCommentConsumer(), getSlCommentConsumer() }
    	);
		termConsumer = new SimpleReconstrTestLanguageTermConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		atomConsumer = new SimpleReconstrTestLanguageAtomConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		parensConsumer = new SimpleReconstrTestLanguageParensConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		twoNumbersConsumer = new SimpleReconstrTestLanguageTwoNumbersConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		manyStringsConsumer = new SimpleReconstrTestLanguageManyStringsConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		typeConsumer = new SimpleReconstrTestLanguageTypeConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		ref2Consumer = new SimpleReconstrTestLanguageRef2Consumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		spareConsumer = new SimpleReconstrTestLanguageSpareConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
	}
	
	public void createTerminalConsumers() {
		getXtextBuiltinConfiguration().createTerminalConsumers();
	}
	
	public void configureConsumers() {
		getOpConsumer().setTermConsumer(getTermConsumer());

		getTermConsumer().setAtomConsumer(getAtomConsumer());
		getTermConsumer().setManyStringsConsumer(getManyStringsConsumer());
		getTermConsumer().setParensConsumer(getParensConsumer());
		getTermConsumer().setRef2Consumer(getRef2Consumer());
		getTermConsumer().setSpareConsumer(getSpareConsumer());
		getTermConsumer().setTwoNumbersConsumer(getTwoNumbersConsumer());
		getTermConsumer().setTypeConsumer(getTypeConsumer());

		getAtomConsumer().setIdConsumer(getIdConsumer());

		getParensConsumer().setOpConsumer(getOpConsumer());

		getTwoNumbersConsumer().setIntConsumer(getIntConsumer());

		getManyStringsConsumer().setStringConsumer(getStringConsumer());

		getTypeConsumer().setIdConsumer(getIdConsumer());

		getRef2Consumer().setStringConsumer(getStringConsumer());

		getSpareConsumer().setIdConsumer(getIdConsumer());

		getAtomConsumer().setRuleCall$2$Delimiter(SimpleReconstrTestLanguageDelimiters.ruleCall$28$Delimiter);
		getParensConsumer().setKeyword$8$Delimiter(SimpleReconstrTestLanguageDelimiters.keyword$34$Delimiter);
		getParensConsumer().setKeyword$6$Delimiter(SimpleReconstrTestLanguageDelimiters.keyword$34$Delimiter);
		getParensConsumer().setKeyword$4$Delimiter(SimpleReconstrTestLanguageDelimiters.keyword$34$Delimiter);
		getTwoNumbersConsumer().setRuleCall$6$Delimiter(SimpleReconstrTestLanguageDelimiters.ruleCall$44$Delimiter);
		getTwoNumbersConsumer().setRuleCall$10$Delimiter(SimpleReconstrTestLanguageDelimiters.ruleCall$44$Delimiter);
		getTwoNumbersConsumer().setRuleCall$4$Delimiter(SimpleReconstrTestLanguageDelimiters.ruleCall$44$Delimiter);
		getTwoNumbersConsumer().setKeyword$8$Delimiter(SimpleReconstrTestLanguageDelimiters.keyword$34$Delimiter);
		getManyStringsConsumer().setRuleCall$7$Delimiter(SimpleReconstrTestLanguageDelimiters.ruleCall$44$Delimiter);
		getManyStringsConsumer().setKeyword$3$Delimiter(SimpleReconstrTestLanguageDelimiters.keyword$34$Delimiter);
		getManyStringsConsumer().setRuleCall$5$Delimiter(SimpleReconstrTestLanguageDelimiters.ruleCall$44$Delimiter);
		getTypeConsumer().setCrossReference$9$Delimiter(SimpleReconstrTestLanguageDelimiters.ruleCall$28$Delimiter);
		getTypeConsumer().setKeyword$7$Delimiter(SimpleReconstrTestLanguageDelimiters.keyword$65$Delimiter);
		getTypeConsumer().setKeyword$4$Delimiter(SimpleReconstrTestLanguageDelimiters.keyword$65$Delimiter);
		getTypeConsumer().setRuleCall$6$Delimiter(SimpleReconstrTestLanguageDelimiters.ruleCall$28$Delimiter);
		getRef2Consumer().setKeyword$8$Delimiter(SimpleReconstrTestLanguageDelimiters.keyword$65$Delimiter);
		getRef2Consumer().setRuleCall$7$Delimiter(SimpleReconstrTestLanguageDelimiters.ruleCall$44$Delimiter);
		getRef2Consumer().setKeyword$6$Delimiter(SimpleReconstrTestLanguageDelimiters.keyword$65$Delimiter);
		getRef2Consumer().setKeyword$2$Delimiter(SimpleReconstrTestLanguageDelimiters.keyword$34$Delimiter);
		getSpareConsumer().setKeyword$3$Delimiter(SimpleReconstrTestLanguageDelimiters.keyword$34$Delimiter);
		getSpareConsumer().setRuleCall$5$Delimiter(SimpleReconstrTestLanguageDelimiters.ruleCall$28$Delimiter);
		getSpareConsumer().setKeyword$7$Delimiter(SimpleReconstrTestLanguageDelimiters.keyword$34$Delimiter);
		getSpareConsumer().setRuleCall$9$Delimiter(SimpleReconstrTestLanguageDelimiters.ruleCall$28$Delimiter);
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
	
    public SimpleReconstrTestLanguageOpConsumer getOpConsumer() {
    	return opConsumer;
    }

    public SimpleReconstrTestLanguageTermConsumer getTermConsumer() {
    	return termConsumer;
    }

    public SimpleReconstrTestLanguageAtomConsumer getAtomConsumer() {
    	return atomConsumer;
    }

    public SimpleReconstrTestLanguageParensConsumer getParensConsumer() {
    	return parensConsumer;
    }

    public SimpleReconstrTestLanguageTwoNumbersConsumer getTwoNumbersConsumer() {
    	return twoNumbersConsumer;
    }

    public SimpleReconstrTestLanguageManyStringsConsumer getManyStringsConsumer() {
    	return manyStringsConsumer;
    }

    public SimpleReconstrTestLanguageTypeConsumer getTypeConsumer() {
    	return typeConsumer;
    }

    public SimpleReconstrTestLanguageRef2Consumer getRef2Consumer() {
    	return ref2Consumer;
    }

    public SimpleReconstrTestLanguageSpareConsumer getSpareConsumer() {
    	return spareConsumer;
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
