/*
Generated with Xtext
*/
package org.eclipse.xtext.grammarinheritance.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;

import org.eclipse.xtext.grammarinheritance.services.InheritanceTestLanguageGrammarAccess;

import org.eclipse.xtext.grammarinheritance.parser.packrat.BaseInheritanceTestLanguageParserConfiguration; 

import org.eclipse.xtext.grammarinheritance.parser.packrat.consumers.InheritanceTestLanguageModelConsumer;
import org.eclipse.xtext.grammarinheritance.parser.packrat.consumers.InheritanceTestLanguageElementConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinML_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSL_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinWSConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinANY_OTHERConsumer;

@SuppressWarnings("unused")
public class InheritanceTestLanguageParserConfiguration extends AbstractParserConfiguration {

	private BaseInheritanceTestLanguageParserConfiguration baseInheritanceTestLanguageConfiguration; 

    private InheritanceTestLanguageModelConsumer modelConsumer;
    private InheritanceTestLanguageElementConsumer elementConsumer;

	private InheritanceTestLanguageGrammarAccess grammarAccess;

	public InheritanceTestLanguageParserConfiguration(IInternalParserConfiguration configuration, InheritanceTestLanguageGrammarAccess grammarAccess) {
		super(configuration);
		this.grammarAccess = grammarAccess;
		this.baseInheritanceTestLanguageConfiguration = new BaseInheritanceTestLanguageParserConfiguration(configuration, null);
	}

	public InheritanceTestLanguageModelConsumer getRootConsumer() {
		return modelConsumer;
	} 

	public void createNonTerminalConsumers() {
		getBaseInheritanceTestLanguageConfiguration().createNonTerminalConsumers();
		modelConsumer = new InheritanceTestLanguageModelConsumer(
    		this, null
    	);
		elementConsumer = new InheritanceTestLanguageElementConsumer(
    		this, null
    	);
	}
	
	public void createTerminalConsumers() {
		getBaseInheritanceTestLanguageConfiguration().createTerminalConsumers();
	}
	
	public void configureConsumers() {
		if (grammarAccess == null)
			throw new NullPointerException("grammarAccess may not be null, if you call configureConsumers");
		getModelConsumer().setRule(grammarAccess.prModel());
		getElementConsumer().setRule(grammarAccess.prElement());
		getIdConsumer().setRule(grammarAccess.lrID());
		getIntConsumer().setRule(grammarAccess.lrINT());
		getStringConsumer().setRule(grammarAccess.lrSTRING());
		getMlCommentConsumer().setRule(grammarAccess.lrML_COMMENT());
		getSlCommentConsumer().setRule(grammarAccess.lrSL_COMMENT());
		getWsConsumer().setRule(grammarAccess.lrWS());
		getAnyOtherConsumer().setRule(grammarAccess.lrANY_OTHER());


		getModelConsumer().setElementConsumer(getElementConsumer());
		getModelConsumer().setIdConsumer(getIdConsumer());

		getElementConsumer().setIdConsumer(getIdConsumer());

		getModelConsumer().setKeyword$8$Delimiter(InheritanceTestLanguageDelimiters.keyword$10$Delimiter);
		getModelConsumer().setKeyword$11$Delimiter(InheritanceTestLanguageDelimiters.keyword$10$Delimiter);
		getModelConsumer().setKeyword$5$Delimiter(InheritanceTestLanguageDelimiters.keyword$7$Delimiter);
		getModelConsumer().setRuleCall$7$Delimiter(InheritanceTestLanguageDelimiters.ruleCall$9$Delimiter);
		getElementConsumer().setKeyword$2$Delimiter(InheritanceTestLanguageDelimiters.keyword$7$Delimiter);
		getElementConsumer().setRuleCall$4$Delimiter(InheritanceTestLanguageDelimiters.ruleCall$9$Delimiter);
	}
	
	// TODO collect superGrammars transitive
	public BaseInheritanceTestLanguageParserConfiguration getBaseInheritanceTestLanguageConfiguration() {
		return baseInheritanceTestLanguageConfiguration;
	} 
	
    public InheritanceTestLanguageModelConsumer getModelConsumer() {
    	return modelConsumer;
    }

    public InheritanceTestLanguageElementConsumer getElementConsumer() {
    	return elementConsumer;
    }

    public XtextBuiltinIDConsumer getIdConsumer() {
    	return getBaseInheritanceTestLanguageConfiguration().getIdConsumer();
    }

    public XtextBuiltinINTConsumer getIntConsumer() {
    	return getBaseInheritanceTestLanguageConfiguration().getIntConsumer();
    }

    public XtextBuiltinSTRINGConsumer getStringConsumer() {
    	return getBaseInheritanceTestLanguageConfiguration().getStringConsumer();
    }

    public XtextBuiltinML_COMMENTConsumer getMlCommentConsumer() {
    	return getBaseInheritanceTestLanguageConfiguration().getMlCommentConsumer();
    }

    public XtextBuiltinSL_COMMENTConsumer getSlCommentConsumer() {
    	return getBaseInheritanceTestLanguageConfiguration().getSlCommentConsumer();
    }

    public XtextBuiltinWSConsumer getWsConsumer() {
    	return getBaseInheritanceTestLanguageConfiguration().getWsConsumer();
    }

    public XtextBuiltinANY_OTHERConsumer getAnyOtherConsumer() {
    	return getBaseInheritanceTestLanguageConfiguration().getAnyOtherConsumer();
    }

	@Override
	public ITerminalConsumer[] getInitialHiddenTerminals() {
		return getBaseInheritanceTestLanguageConfiguration().getInitialHiddenTerminals();
	}
	
}
