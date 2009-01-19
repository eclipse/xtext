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

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.ContentAssistTestLanguageStartConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.ContentAssistTestLanguageAbstractRuleConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.ContentAssistTestLanguageFirstAbstractRuleChildConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.ContentAssistTestLanguageSecondAbstractRuleChildConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.ContentAssistTestLanguageAbstractRuleCallConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinML_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSL_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinWSConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinANY_OTHERConsumer;

public class ContentAssistTestLanguageParserConfiguration extends AbstractParserConfiguration {

	private XtextBuiltinParserConfiguration xtextBuiltinConfiguration; 

    private ContentAssistTestLanguageStartConsumer startConsumer;
    private ContentAssistTestLanguageAbstractRuleConsumer abstractRuleConsumer;
    private ContentAssistTestLanguageFirstAbstractRuleChildConsumer firstAbstractRuleChildConsumer;
    private ContentAssistTestLanguageSecondAbstractRuleChildConsumer secondAbstractRuleChildConsumer;
    private ContentAssistTestLanguageAbstractRuleCallConsumer abstractRuleCallConsumer;

	public ContentAssistTestLanguageParserConfiguration(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil);
		this.xtextBuiltinConfiguration = new XtextBuiltinParserConfiguration(
			input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil);
	}

	public ContentAssistTestLanguageStartConsumer getRootConsumer() {
		return startConsumer;
	} 
	
	public void createNonTerminalConsumers() {
		getXtextBuiltinConfiguration().createNonTerminalConsumers();
		startConsumer = new ContentAssistTestLanguageStartConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		abstractRuleConsumer = new ContentAssistTestLanguageAbstractRuleConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		firstAbstractRuleChildConsumer = new ContentAssistTestLanguageFirstAbstractRuleChildConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		secondAbstractRuleChildConsumer = new ContentAssistTestLanguageSecondAbstractRuleChildConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		abstractRuleCallConsumer = new ContentAssistTestLanguageAbstractRuleCallConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
	}
	
	public void createTerminalConsumers() {
		getXtextBuiltinConfiguration().createTerminalConsumers();
	}
	
	public void configureConsumers() {
		getStartConsumer().setAbstractRuleConsumer(getAbstractRuleConsumer());

		getAbstractRuleConsumer().setFirstAbstractRuleChildConsumer(getFirstAbstractRuleChildConsumer());
		getAbstractRuleConsumer().setSecondAbstractRuleChildConsumer(getSecondAbstractRuleChildConsumer());

		getFirstAbstractRuleChildConsumer().setAbstractRuleConsumer(getAbstractRuleConsumer());
		getFirstAbstractRuleChildConsumer().setIdConsumer(getIdConsumer());

		getSecondAbstractRuleChildConsumer().setAbstractRuleCallConsumer(getAbstractRuleCallConsumer());
		getSecondAbstractRuleChildConsumer().setIdConsumer(getIdConsumer());

		getAbstractRuleCallConsumer().setIdConsumer(getIdConsumer());

		getStartConsumer().setKeyword$3$Delimiter(ContentAssistTestLanguageDelimiters.keyword$5$Delimiter);
		getStartConsumer().setKeyword$6$Delimiter(ContentAssistTestLanguageDelimiters.keyword$5$Delimiter);
		getFirstAbstractRuleChildConsumer().setKeyword$7$Delimiter(ContentAssistTestLanguageDelimiters.keyword$22$Delimiter);
		getFirstAbstractRuleChildConsumer().setKeyword$10$Delimiter(ContentAssistTestLanguageDelimiters.keyword$22$Delimiter);
		getFirstAbstractRuleChildConsumer().setKeyword$11$Delimiter(ContentAssistTestLanguageDelimiters.keyword$22$Delimiter);
		getFirstAbstractRuleChildConsumer().setRuleCall$6$Delimiter(ContentAssistTestLanguageDelimiters.ruleCall$21$Delimiter);
		getSecondAbstractRuleChildConsumer().setKeyword$8$Delimiter(ContentAssistTestLanguageDelimiters.keyword$22$Delimiter);
		getSecondAbstractRuleChildConsumer().setKeyword$11$Delimiter(ContentAssistTestLanguageDelimiters.keyword$22$Delimiter);
		getSecondAbstractRuleChildConsumer().setRuleCall$6$Delimiter(ContentAssistTestLanguageDelimiters.ruleCall$21$Delimiter);
		getSecondAbstractRuleChildConsumer().setKeyword$7$Delimiter(ContentAssistTestLanguageDelimiters.keyword$5$Delimiter);
		getAbstractRuleCallConsumer().setCrossReference$2$Delimiter(ContentAssistTestLanguageDelimiters.ruleCall$21$Delimiter);
	}
	
	// TODO collect superGrammars transitive
	public XtextBuiltinParserConfiguration getXtextBuiltinConfiguration() {
		return xtextBuiltinConfiguration;
	} 
	
    public ContentAssistTestLanguageStartConsumer getStartConsumer() {
    	return startConsumer;
    }

    public ContentAssistTestLanguageAbstractRuleConsumer getAbstractRuleConsumer() {
    	return abstractRuleConsumer;
    }

    public ContentAssistTestLanguageFirstAbstractRuleChildConsumer getFirstAbstractRuleChildConsumer() {
    	return firstAbstractRuleChildConsumer;
    }

    public ContentAssistTestLanguageSecondAbstractRuleChildConsumer getSecondAbstractRuleChildConsumer() {
    	return secondAbstractRuleChildConsumer;
    }

    public ContentAssistTestLanguageAbstractRuleCallConsumer getAbstractRuleCallConsumer() {
    	return abstractRuleCallConsumer;
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
