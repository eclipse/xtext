/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;

import org.eclipse.xtext.testlanguages.services.TreeTestLanguageGrammarAccess;

import org.eclipse.xtext.builtin.parser.packrat.XtextBuiltinParserConfiguration; 

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.TreeTestLanguageModelConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.TreeTestLanguageNodeConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinML_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSL_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinWSConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinANY_OTHERConsumer;

@SuppressWarnings("unused")
public class TreeTestLanguageParserConfiguration extends AbstractParserConfiguration {

	private XtextBuiltinParserConfiguration xtextBuiltinConfiguration; 

    private TreeTestLanguageModelConsumer modelConsumer;
    private TreeTestLanguageNodeConsumer nodeConsumer;

	private TreeTestLanguageGrammarAccess grammarAccess;

	public TreeTestLanguageParserConfiguration(IInternalParserConfiguration configuration, TreeTestLanguageGrammarAccess grammarAccess) {
		super(configuration);
		this.grammarAccess = grammarAccess;
		this.xtextBuiltinConfiguration = new XtextBuiltinParserConfiguration(configuration, null);
	}

	public TreeTestLanguageModelConsumer getRootConsumer() {
		return modelConsumer;
	} 

	public void createNonTerminalConsumers() {
		getXtextBuiltinConfiguration().createNonTerminalConsumers();
		modelConsumer = new TreeTestLanguageModelConsumer(
    		this, null
    	);
		nodeConsumer = new TreeTestLanguageNodeConsumer(
    		this, null
    	);
	}
	
	public void createTerminalConsumers() {
		getXtextBuiltinConfiguration().createTerminalConsumers();
	}
	
	public void configureConsumers() {
		if (grammarAccess == null)
			throw new NullPointerException("grammarAccess may not be null, you call configureConsumers");
		getModelConsumer().setRule(grammarAccess.prModel());
		getNodeConsumer().setRule(grammarAccess.prNode());
		getIdConsumer().setRule(grammarAccess.lrID());
		getIntConsumer().setRule(grammarAccess.lrINT());
		getStringConsumer().setRule(grammarAccess.lrSTRING());
		getMlCommentConsumer().setRule(grammarAccess.lrML_COMMENT());
		getSlCommentConsumer().setRule(grammarAccess.lrSL_COMMENT());
		getWsConsumer().setRule(grammarAccess.lrWS());
		getAnyOtherConsumer().setRule(grammarAccess.lrANY_OTHER());


		getModelConsumer().setNodeConsumer(getNodeConsumer());

		getNodeConsumer().setIdConsumer(getIdConsumer());
		getNodeConsumer().setNodeConsumer(getNodeConsumer());
		getNodeConsumer().setStringConsumer(getStringConsumer());

		getNodeConsumer().setKeyword$9$Delimiter(TreeTestLanguageDelimiters.keyword$15$Delimiter);
		getNodeConsumer().setKeyword$12$Delimiter(TreeTestLanguageDelimiters.keyword$15$Delimiter);
		getNodeConsumer().setKeyword$13$Delimiter(TreeTestLanguageDelimiters.keyword$15$Delimiter);
		getNodeConsumer().setKeyword$16$Delimiter(TreeTestLanguageDelimiters.keyword$15$Delimiter);
		getNodeConsumer().setRuleCall$8$Delimiter(TreeTestLanguageDelimiters.ruleCall$14$Delimiter);
		getNodeConsumer().setRuleCall$11$Delimiter(TreeTestLanguageDelimiters.ruleCall$14$Delimiter);
	}
	
	// TODO collect superGrammars transitive
	public XtextBuiltinParserConfiguration getXtextBuiltinConfiguration() {
		return xtextBuiltinConfiguration;
	} 
	
    public TreeTestLanguageModelConsumer getModelConsumer() {
    	return modelConsumer;
    }

    public TreeTestLanguageNodeConsumer getNodeConsumer() {
    	return nodeConsumer;
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


	@Override
	public ITerminalConsumer[] getInitialHiddenTerminals() {
		return getXtextBuiltinConfiguration().getInitialHiddenTerminals();
	}
	
}
