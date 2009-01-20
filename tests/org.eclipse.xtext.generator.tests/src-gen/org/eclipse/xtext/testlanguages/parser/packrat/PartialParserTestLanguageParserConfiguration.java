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

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.PartialParserTestLanguageContainerConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.PartialParserTestLanguageNestedConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.PartialParserTestLanguageContentConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.PartialParserTestLanguageChildrenConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.PartialParserTestLanguageChildConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.PartialParserTestLanguageAbstractChildrenConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.PartialParserTestLanguageAbstractChildConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.PartialParserTestLanguageFirstConcreteConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.PartialParserTestLanguageSecondConcreteConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.PartialParserTestLanguageNamedConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinML_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSL_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinWSConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinANY_OTHERConsumer;

public class PartialParserTestLanguageParserConfiguration extends AbstractParserConfiguration {

	private XtextBuiltinParserConfiguration xtextBuiltinConfiguration; 

    private PartialParserTestLanguageContainerConsumer containerConsumer;
    private PartialParserTestLanguageNestedConsumer nestedConsumer;
    private PartialParserTestLanguageContentConsumer contentConsumer;
    private PartialParserTestLanguageChildrenConsumer childrenConsumer;
    private PartialParserTestLanguageChildConsumer childConsumer;
    private PartialParserTestLanguageAbstractChildrenConsumer abstractChildrenConsumer;
    private PartialParserTestLanguageAbstractChildConsumer abstractChildConsumer;
    private PartialParserTestLanguageFirstConcreteConsumer firstConcreteConsumer;
    private PartialParserTestLanguageSecondConcreteConsumer secondConcreteConsumer;
    private PartialParserTestLanguageNamedConsumer namedConsumer;

	public PartialParserTestLanguageParserConfiguration(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil);
		this.xtextBuiltinConfiguration = new XtextBuiltinParserConfiguration(
			input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil);
	}

	public PartialParserTestLanguageContainerConsumer getRootConsumer() {
		return containerConsumer;
	} 
	
	public void createNonTerminalConsumers() {
		getXtextBuiltinConfiguration().createNonTerminalConsumers();
		containerConsumer = new PartialParserTestLanguageContainerConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		nestedConsumer = new PartialParserTestLanguageNestedConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		contentConsumer = new PartialParserTestLanguageContentConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		childrenConsumer = new PartialParserTestLanguageChildrenConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		childConsumer = new PartialParserTestLanguageChildConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		abstractChildrenConsumer = new PartialParserTestLanguageAbstractChildrenConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		abstractChildConsumer = new PartialParserTestLanguageAbstractChildConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		firstConcreteConsumer = new PartialParserTestLanguageFirstConcreteConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		secondConcreteConsumer = new PartialParserTestLanguageSecondConcreteConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		namedConsumer = new PartialParserTestLanguageNamedConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
	}
	
	public void createTerminalConsumers() {
		getXtextBuiltinConfiguration().createTerminalConsumers();
	}
	
	public void configureConsumers() {
		getContainerConsumer().setContentConsumer(getContentConsumer());
		getContainerConsumer().setIdConsumer(getIdConsumer());
		getContainerConsumer().setNestedConsumer(getNestedConsumer());

		getNestedConsumer().setContainerConsumer(getContainerConsumer());

		getContentConsumer().setAbstractChildrenConsumer(getAbstractChildrenConsumer());
		getContentConsumer().setChildrenConsumer(getChildrenConsumer());

		getChildrenConsumer().setChildConsumer(getChildConsumer());

		getChildConsumer().setNamedConsumer(getNamedConsumer());

		getAbstractChildrenConsumer().setAbstractChildConsumer(getAbstractChildConsumer());

		getAbstractChildConsumer().setFirstConcreteConsumer(getFirstConcreteConsumer());
		getAbstractChildConsumer().setSecondConcreteConsumer(getSecondConcreteConsumer());

		getFirstConcreteConsumer().setIdConsumer(getIdConsumer());
		getFirstConcreteConsumer().setNamedConsumer(getNamedConsumer());

		getSecondConcreteConsumer().setIdConsumer(getIdConsumer());
		getSecondConcreteConsumer().setNamedConsumer(getNamedConsumer());

		getNamedConsumer().setIdConsumer(getIdConsumer());

		getContainerConsumer().setKeyword$8$Delimiter(PartialParserTestLanguageDelimiters.keyword$10$Delimiter);
		getContainerConsumer().setKeyword$14$Delimiter(PartialParserTestLanguageDelimiters.keyword$10$Delimiter);
		getContainerConsumer().setKeyword$5$Delimiter(PartialParserTestLanguageDelimiters.keyword$7$Delimiter);
		getContainerConsumer().setRuleCall$7$Delimiter(PartialParserTestLanguageDelimiters.ruleCall$9$Delimiter);
		getNestedConsumer().setKeyword$4$Delimiter(PartialParserTestLanguageDelimiters.keyword$7$Delimiter);
		getNestedConsumer().setKeyword$5$Delimiter(PartialParserTestLanguageDelimiters.keyword$10$Delimiter);
		getNestedConsumer().setKeyword$8$Delimiter(PartialParserTestLanguageDelimiters.keyword$10$Delimiter);
		getChildrenConsumer().setKeyword$5$Delimiter(PartialParserTestLanguageDelimiters.keyword$7$Delimiter);
		getChildrenConsumer().setKeyword$6$Delimiter(PartialParserTestLanguageDelimiters.keyword$10$Delimiter);
		getChildrenConsumer().setKeyword$10$Delimiter(PartialParserTestLanguageDelimiters.keyword$10$Delimiter);
		getChildrenConsumer().setKeyword$13$Delimiter(PartialParserTestLanguageDelimiters.keyword$10$Delimiter);
		getChildConsumer().setKeyword$5$Delimiter(PartialParserTestLanguageDelimiters.keyword$10$Delimiter);
		getChildConsumer().setKeyword$6$Delimiter(PartialParserTestLanguageDelimiters.keyword$7$Delimiter);
		getChildConsumer().setKeyword$7$Delimiter(PartialParserTestLanguageDelimiters.keyword$10$Delimiter);
		getChildConsumer().setKeyword$10$Delimiter(PartialParserTestLanguageDelimiters.keyword$10$Delimiter);
		getAbstractChildrenConsumer().setKeyword$4$Delimiter(PartialParserTestLanguageDelimiters.keyword$7$Delimiter);
		getAbstractChildrenConsumer().setKeyword$5$Delimiter(PartialParserTestLanguageDelimiters.keyword$10$Delimiter);
		getAbstractChildrenConsumer().setKeyword$8$Delimiter(PartialParserTestLanguageDelimiters.keyword$10$Delimiter);
		getFirstConcreteConsumer().setCrossReference$12$Delimiter(PartialParserTestLanguageDelimiters.ruleCall$9$Delimiter);
		getFirstConcreteConsumer().setKeyword$6$Delimiter(PartialParserTestLanguageDelimiters.keyword$10$Delimiter);
		getFirstConcreteConsumer().setKeyword$7$Delimiter(PartialParserTestLanguageDelimiters.keyword$7$Delimiter);
		getFirstConcreteConsumer().setKeyword$8$Delimiter(PartialParserTestLanguageDelimiters.keyword$10$Delimiter);
		getFirstConcreteConsumer().setKeyword$14$Delimiter(PartialParserTestLanguageDelimiters.keyword$10$Delimiter);
		getSecondConcreteConsumer().setCrossReference$14$Delimiter(PartialParserTestLanguageDelimiters.ruleCall$9$Delimiter);
		getSecondConcreteConsumer().setKeyword$9$Delimiter(PartialParserTestLanguageDelimiters.keyword$7$Delimiter);
		getSecondConcreteConsumer().setKeyword$10$Delimiter(PartialParserTestLanguageDelimiters.keyword$10$Delimiter);
		getSecondConcreteConsumer().setKeyword$16$Delimiter(PartialParserTestLanguageDelimiters.keyword$10$Delimiter);
		getSecondConcreteConsumer().setKeyword$7$Delimiter(PartialParserTestLanguageDelimiters.keyword$10$Delimiter);
		getSecondConcreteConsumer().setKeyword$8$Delimiter(PartialParserTestLanguageDelimiters.keyword$7$Delimiter);
		getNamedConsumer().setRuleCall$2$Delimiter(PartialParserTestLanguageDelimiters.ruleCall$9$Delimiter);
	}
	
	// TODO collect superGrammars transitive
	public XtextBuiltinParserConfiguration getXtextBuiltinConfiguration() {
		return xtextBuiltinConfiguration;
	} 
	
    public PartialParserTestLanguageContainerConsumer getContainerConsumer() {
    	return containerConsumer;
    }

    public PartialParserTestLanguageNestedConsumer getNestedConsumer() {
    	return nestedConsumer;
    }

    public PartialParserTestLanguageContentConsumer getContentConsumer() {
    	return contentConsumer;
    }

    public PartialParserTestLanguageChildrenConsumer getChildrenConsumer() {
    	return childrenConsumer;
    }

    public PartialParserTestLanguageChildConsumer getChildConsumer() {
    	return childConsumer;
    }

    public PartialParserTestLanguageAbstractChildrenConsumer getAbstractChildrenConsumer() {
    	return abstractChildrenConsumer;
    }

    public PartialParserTestLanguageAbstractChildConsumer getAbstractChildConsumer() {
    	return abstractChildConsumer;
    }

    public PartialParserTestLanguageFirstConcreteConsumer getFirstConcreteConsumer() {
    	return firstConcreteConsumer;
    }

    public PartialParserTestLanguageSecondConcreteConsumer getSecondConcreteConsumer() {
    	return secondConcreteConsumer;
    }

    public PartialParserTestLanguageNamedConsumer getNamedConsumer() {
    	return namedConsumer;
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
