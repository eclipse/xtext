/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;

import org.eclipse.xtext.testlanguages.services.LexerTestLanguageGrammarAccess;

import org.eclipse.xtext.builtin.parser.packrat.XtextBuiltinParserConfiguration; 

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.LexerTestLanguageModelConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.LexerTestLanguageElementConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.LexerTestLanguageSTRINGConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinML_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSL_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinWSConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinANY_OTHERConsumer;

@SuppressWarnings("unused")
public class LexerTestLanguageParserConfiguration extends AbstractParserConfiguration {

	private XtextBuiltinParserConfiguration xtextBuiltinConfiguration; 

    private LexerTestLanguageModelConsumer modelConsumer;
    private LexerTestLanguageElementConsumer elementConsumer;
    private LexerTestLanguageSTRINGConsumer stringConsumer;

	private LexerTestLanguageGrammarAccess grammarAccess;

	public LexerTestLanguageParserConfiguration(IInternalParserConfiguration configuration, LexerTestLanguageGrammarAccess grammarAccess) {
		super(configuration);
		this.grammarAccess = grammarAccess;
		this.xtextBuiltinConfiguration = new XtextBuiltinParserConfiguration(configuration, null);
	}

	public LexerTestLanguageModelConsumer getRootConsumer() {
		return modelConsumer;
	} 

	public void createNonTerminalConsumers() {
		getXtextBuiltinConfiguration().createNonTerminalConsumers();
		modelConsumer = new LexerTestLanguageModelConsumer(
    		this, null
    	);
		elementConsumer = new LexerTestLanguageElementConsumer(
    		this, null
    	);
	}
	
	public void createTerminalConsumers() {
		getXtextBuiltinConfiguration().createTerminalConsumers();
		stringConsumer = new LexerTestLanguageSTRINGConsumer(this);
	}
	
	public void configureConsumers() {
		if (grammarAccess == null)
			throw new NullPointerException("grammarAccess may not be null, if you call configureConsumers");
		getModelConsumer().setRule(grammarAccess.prModel());
		getElementConsumer().setRule(grammarAccess.prElement());
		getStringConsumer().setRule(grammarAccess.lrSTRING());
		getIdConsumer().setRule(grammarAccess.lrID());
		getIntConsumer().setRule(grammarAccess.lrINT());
		getMlCommentConsumer().setRule(grammarAccess.lrML_COMMENT());
		getSlCommentConsumer().setRule(grammarAccess.lrSL_COMMENT());
		getWsConsumer().setRule(grammarAccess.lrWS());
		getAnyOtherConsumer().setRule(grammarAccess.lrANY_OTHER());


		getModelConsumer().setElementConsumer(getElementConsumer());

		getElementConsumer().setIdConsumer(getIdConsumer());
		getElementConsumer().setStringConsumer(getStringConsumer());

		getElementConsumer().setRuleCall$5$Delimiter(LexerTestLanguageDelimiters.ruleCall$9$Delimiter);
		getElementConsumer().setRuleCall$3$Delimiter(LexerTestLanguageDelimiters.ruleCall$9$Delimiter);
	}
	
	// TODO collect superGrammars transitive
	public XtextBuiltinParserConfiguration getXtextBuiltinConfiguration() {
		return xtextBuiltinConfiguration;
	} 
	
    public LexerTestLanguageModelConsumer getModelConsumer() {
    	return modelConsumer;
    }

    public LexerTestLanguageElementConsumer getElementConsumer() {
    	return elementConsumer;
    }

    public LexerTestLanguageSTRINGConsumer getStringConsumer() {
    	return stringConsumer;
    }

    public XtextBuiltinIDConsumer getIdConsumer() {
    	return getXtextBuiltinConfiguration().getIdConsumer();
    }

    public XtextBuiltinINTConsumer getIntConsumer() {
    	return getXtextBuiltinConfiguration().getIntConsumer();
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
