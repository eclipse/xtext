/*
Generated with Xtext
*/
package org.eclipse.xtext.grammarinheritance.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;

import org.eclipse.xtext.grammarinheritance.services.AbstractTestLanguageGrammarAccess;

import org.eclipse.xtext.builtin.parser.packrat.XtextBuiltinParserConfiguration; 

import org.eclipse.xtext.grammarinheritance.parser.packrat.consumers.AbstractTestLanguageInheritedParserRuleConsumer;
import org.eclipse.xtext.grammarinheritance.parser.packrat.consumers.AbstractTestLanguageAbstractCallOverridenParserRuleConsumer;
import org.eclipse.xtext.grammarinheritance.parser.packrat.consumers.AbstractTestLanguageOverridableParserRuleConsumer;
import org.eclipse.xtext.grammarinheritance.parser.packrat.consumers.AbstractTestLanguageOverridableParserRule2Consumer;
import org.eclipse.xtext.grammarinheritance.parser.packrat.consumers.AbstractTestLanguageAbstractCallExtendedParserRuleConsumer;
import org.eclipse.xtext.grammarinheritance.parser.packrat.consumers.AbstractTestLanguageExtendableParserRuleConsumer;
import org.eclipse.xtext.grammarinheritance.parser.packrat.consumers.AbstractTestLanguageREALConsumer;
import org.eclipse.xtext.grammarinheritance.parser.packrat.consumers.AbstractTestLanguageIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinML_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSL_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinWSConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinANY_OTHERConsumer;

@SuppressWarnings("unused")
public class AbstractTestLanguageParserConfiguration extends AbstractParserConfiguration {

	private XtextBuiltinParserConfiguration xtextBuiltinConfiguration; 

    private AbstractTestLanguageInheritedParserRuleConsumer inheritedParserRuleConsumer;
    private AbstractTestLanguageAbstractCallOverridenParserRuleConsumer abstractCallOverridenParserRuleConsumer;
    private AbstractTestLanguageOverridableParserRuleConsumer overridableParserRuleConsumer;
    private AbstractTestLanguageOverridableParserRule2Consumer overridableParserRule2Consumer;
    private AbstractTestLanguageAbstractCallExtendedParserRuleConsumer abstractCallExtendedParserRuleConsumer;
    private AbstractTestLanguageExtendableParserRuleConsumer extendableParserRuleConsumer;
    private AbstractTestLanguageREALConsumer realConsumer;
    private AbstractTestLanguageIDConsumer idConsumer;

	private AbstractTestLanguageGrammarAccess grammarAccess;

	public AbstractTestLanguageParserConfiguration(IInternalParserConfiguration configuration, AbstractTestLanguageGrammarAccess grammarAccess) {
		super(configuration);
		this.grammarAccess = grammarAccess;
		this.xtextBuiltinConfiguration = new XtextBuiltinParserConfiguration(configuration, null);
	}

	public AbstractTestLanguageInheritedParserRuleConsumer getRootConsumer() {
		return inheritedParserRuleConsumer;
	} 

	public void createNonTerminalConsumers() {
		getXtextBuiltinConfiguration().createNonTerminalConsumers();
		inheritedParserRuleConsumer = new AbstractTestLanguageInheritedParserRuleConsumer(
    		this, null
    	);
		abstractCallOverridenParserRuleConsumer = new AbstractTestLanguageAbstractCallOverridenParserRuleConsumer(
    		this, null
    	);
		overridableParserRuleConsumer = new AbstractTestLanguageOverridableParserRuleConsumer(
    		this, null
    	);
		overridableParserRule2Consumer = new AbstractTestLanguageOverridableParserRule2Consumer(
    		this, null
    	);
		abstractCallExtendedParserRuleConsumer = new AbstractTestLanguageAbstractCallExtendedParserRuleConsumer(
    		this, null
    	);
		extendableParserRuleConsumer = new AbstractTestLanguageExtendableParserRuleConsumer(
    		this, null
    	);
	}
	
	public void createTerminalConsumers() {
		getXtextBuiltinConfiguration().createTerminalConsumers();
		realConsumer = new AbstractTestLanguageREALConsumer(this);
		idConsumer = new AbstractTestLanguageIDConsumer(this);
	}
	
	public void configureConsumers() {
		if (grammarAccess == null)
			throw new NullPointerException("grammarAccess may not be null, you call configureConsumers");
		getInheritedParserRuleConsumer().setRule(grammarAccess.prInheritedParserRule());
		getAbstractCallOverridenParserRuleConsumer().setRule(grammarAccess.prAbstractCallOverridenParserRule());
		getOverridableParserRuleConsumer().setRule(grammarAccess.prOverridableParserRule());
		getOverridableParserRule2Consumer().setRule(grammarAccess.prOverridableParserRule2());
		getAbstractCallExtendedParserRuleConsumer().setRule(grammarAccess.prAbstractCallExtendedParserRule());
		getExtendableParserRuleConsumer().setRule(grammarAccess.prExtendableParserRule());
		getRealConsumer().setRule(grammarAccess.lrREAL());
		getIdConsumer().setRule(grammarAccess.lrID());
		getIntConsumer().setRule(grammarAccess.lrINT());
		getStringConsumer().setRule(grammarAccess.lrSTRING());
		getMlCommentConsumer().setRule(grammarAccess.lrML_COMMENT());
		getSlCommentConsumer().setRule(grammarAccess.lrSL_COMMENT());
		getWsConsumer().setRule(grammarAccess.lrWS());
		getAnyOtherConsumer().setRule(grammarAccess.lrANY_OTHER());


		getInheritedParserRuleConsumer().setIdConsumer(getIdConsumer());

		getAbstractCallOverridenParserRuleConsumer().setOverridableParserRuleConsumer(getOverridableParserRuleConsumer());

		getOverridableParserRuleConsumer().setIdConsumer(getIdConsumer());

		getOverridableParserRule2Consumer().setStringConsumer(getStringConsumer());

		getAbstractCallExtendedParserRuleConsumer().setExtendableParserRuleConsumer(getExtendableParserRuleConsumer());

		getExtendableParserRuleConsumer().setIdConsumer(getIdConsumer());

		getInheritedParserRuleConsumer().setKeyword$2$Delimiter(AbstractTestLanguageDelimiters.keyword$5$Delimiter);
		getInheritedParserRuleConsumer().setRuleCall$4$Delimiter(AbstractTestLanguageDelimiters.ruleCall$7$Delimiter);
		getAbstractCallOverridenParserRuleConsumer().setKeyword$2$Delimiter(AbstractTestLanguageDelimiters.keyword$5$Delimiter);
		getOverridableParserRuleConsumer().setKeyword$2$Delimiter(AbstractTestLanguageDelimiters.keyword$5$Delimiter);
		getOverridableParserRuleConsumer().setRuleCall$4$Delimiter(AbstractTestLanguageDelimiters.ruleCall$7$Delimiter);
		getOverridableParserRule2Consumer().setKeyword$2$Delimiter(AbstractTestLanguageDelimiters.keyword$5$Delimiter);
		getOverridableParserRule2Consumer().setRuleCall$4$Delimiter(AbstractTestLanguageDelimiters.ruleCall$25$Delimiter);
		getAbstractCallExtendedParserRuleConsumer().setKeyword$2$Delimiter(AbstractTestLanguageDelimiters.keyword$5$Delimiter);
		getExtendableParserRuleConsumer().setKeyword$2$Delimiter(AbstractTestLanguageDelimiters.keyword$5$Delimiter);
		getExtendableParserRuleConsumer().setRuleCall$4$Delimiter(AbstractTestLanguageDelimiters.ruleCall$7$Delimiter);
	}
	
	// TODO collect superGrammars transitive
	public XtextBuiltinParserConfiguration getXtextBuiltinConfiguration() {
		return xtextBuiltinConfiguration;
	} 
	
    public AbstractTestLanguageInheritedParserRuleConsumer getInheritedParserRuleConsumer() {
    	return inheritedParserRuleConsumer;
    }

    public AbstractTestLanguageAbstractCallOverridenParserRuleConsumer getAbstractCallOverridenParserRuleConsumer() {
    	return abstractCallOverridenParserRuleConsumer;
    }

    public AbstractTestLanguageOverridableParserRuleConsumer getOverridableParserRuleConsumer() {
    	return overridableParserRuleConsumer;
    }

    public AbstractTestLanguageOverridableParserRule2Consumer getOverridableParserRule2Consumer() {
    	return overridableParserRule2Consumer;
    }

    public AbstractTestLanguageAbstractCallExtendedParserRuleConsumer getAbstractCallExtendedParserRuleConsumer() {
    	return abstractCallExtendedParserRuleConsumer;
    }

    public AbstractTestLanguageExtendableParserRuleConsumer getExtendableParserRuleConsumer() {
    	return extendableParserRuleConsumer;
    }

    public AbstractTestLanguageREALConsumer getRealConsumer() {
    	return realConsumer;
    }

    public AbstractTestLanguageIDConsumer getIdConsumer() {
    	return idConsumer;
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
