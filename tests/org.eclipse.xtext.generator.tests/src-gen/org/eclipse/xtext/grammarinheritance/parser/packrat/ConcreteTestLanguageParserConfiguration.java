/*
Generated with Xtext
*/
package org.eclipse.xtext.grammarinheritance.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;

import org.eclipse.xtext.grammarinheritance.services.ConcreteTestLanguageGrammarAccess;

import org.eclipse.xtext.grammarinheritance.parser.packrat.AbstractTestLanguageParserConfiguration; 

import org.eclipse.xtext.grammarinheritance.parser.packrat.consumers.ConcreteTestLanguageRootRuleConsumer;
import org.eclipse.xtext.grammarinheritance.parser.packrat.consumers.ConcreteTestLanguageConcreteParserRuleConsumer;
import org.eclipse.xtext.grammarinheritance.parser.packrat.consumers.ConcreteTestLanguageOverridableParserRuleConsumer;
import org.eclipse.xtext.grammarinheritance.parser.packrat.consumers.ConcreteTestLanguageCallOverridenParserRuleConsumer;
import org.eclipse.xtext.grammarinheritance.parser.packrat.consumers.ConcreteTestLanguageOverridableParserRule2Consumer;
import org.eclipse.xtext.grammarinheritance.parser.packrat.consumers.ConcreteTestLanguageExtendableParserRuleConsumer;
import org.eclipse.xtext.grammarinheritance.parser.packrat.consumers.ConcreteTestLanguageSubrule1Consumer;
import org.eclipse.xtext.grammarinheritance.parser.packrat.consumers.ConcreteTestLanguageSubrule2Consumer;
import org.eclipse.xtext.grammarinheritance.parser.packrat.consumers.ConcreteTestLanguageSubrule3Consumer;
import org.eclipse.xtext.grammarinheritance.parser.packrat.consumers.ConcreteTestLanguageCallExtendedParserRuleConsumer;
import org.eclipse.xtext.grammarinheritance.parser.packrat.consumers.AbstractTestLanguageInheritedParserRuleConsumer;
import org.eclipse.xtext.grammarinheritance.parser.packrat.consumers.AbstractTestLanguageAbstractCallOverridenParserRuleConsumer;
import org.eclipse.xtext.grammarinheritance.parser.packrat.consumers.AbstractTestLanguageAbstractCallExtendedParserRuleConsumer;
import org.eclipse.xtext.grammarinheritance.parser.packrat.consumers.AbstractTestLanguageREALConsumer;
import org.eclipse.xtext.grammarinheritance.parser.packrat.consumers.AbstractTestLanguageIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinML_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSL_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinWSConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinANY_OTHERConsumer;

@SuppressWarnings("unused")
public class ConcreteTestLanguageParserConfiguration extends AbstractParserConfiguration {

	private AbstractTestLanguageParserConfiguration abstractTestLanguageConfiguration; 

    private ConcreteTestLanguageRootRuleConsumer rootRuleConsumer;
    private ConcreteTestLanguageConcreteParserRuleConsumer concreteParserRuleConsumer;
    private ConcreteTestLanguageOverridableParserRuleConsumer overridableParserRuleConsumer;
    private ConcreteTestLanguageCallOverridenParserRuleConsumer callOverridenParserRuleConsumer;
    private ConcreteTestLanguageOverridableParserRule2Consumer overridableParserRule2Consumer;
    private ConcreteTestLanguageExtendableParserRuleConsumer extendableParserRuleConsumer;
    private ConcreteTestLanguageSubrule1Consumer subrule1Consumer;
    private ConcreteTestLanguageSubrule2Consumer subrule2Consumer;
    private ConcreteTestLanguageSubrule3Consumer subrule3Consumer;
    private ConcreteTestLanguageCallExtendedParserRuleConsumer callExtendedParserRuleConsumer;

	private ConcreteTestLanguageGrammarAccess grammarAccess;

	public ConcreteTestLanguageParserConfiguration(IInternalParserConfiguration configuration, ConcreteTestLanguageGrammarAccess grammarAccess) {
		super(configuration);
		this.grammarAccess = grammarAccess;
		this.abstractTestLanguageConfiguration = new AbstractTestLanguageParserConfiguration(configuration, null);
	}

	public ConcreteTestLanguageRootRuleConsumer getRootConsumer() {
		return rootRuleConsumer;
	} 

	public void createNonTerminalConsumers() {
		getAbstractTestLanguageConfiguration().createNonTerminalConsumers();
		rootRuleConsumer = new ConcreteTestLanguageRootRuleConsumer(
    		this, null
    	);
		concreteParserRuleConsumer = new ConcreteTestLanguageConcreteParserRuleConsumer(
    		this, null
    	);
		overridableParserRuleConsumer = new ConcreteTestLanguageOverridableParserRuleConsumer(
    		this, null
    	);
		callOverridenParserRuleConsumer = new ConcreteTestLanguageCallOverridenParserRuleConsumer(
    		this, null
    	);
		overridableParserRule2Consumer = new ConcreteTestLanguageOverridableParserRule2Consumer(
    		this, null
    	);
		extendableParserRuleConsumer = new ConcreteTestLanguageExtendableParserRuleConsumer(
    		this, null
    	);
		subrule1Consumer = new ConcreteTestLanguageSubrule1Consumer(
    		this, null
    	);
		subrule2Consumer = new ConcreteTestLanguageSubrule2Consumer(
    		this, null
    	);
		subrule3Consumer = new ConcreteTestLanguageSubrule3Consumer(
    		this, null
    	);
		callExtendedParserRuleConsumer = new ConcreteTestLanguageCallExtendedParserRuleConsumer(
    		this, null
    	);
	}
	
	public void createTerminalConsumers() {
		getAbstractTestLanguageConfiguration().createTerminalConsumers();
	}
	
	public void configureConsumers() {
		if (grammarAccess == null)
			throw new NullPointerException("grammarAccess may not be null, if you call configureConsumers");
		getRootRuleConsumer().setRule(grammarAccess.prRootRule());
		getConcreteParserRuleConsumer().setRule(grammarAccess.prConcreteParserRule());
		getOverridableParserRuleConsumer().setRule(grammarAccess.prOverridableParserRule());
		getCallOverridenParserRuleConsumer().setRule(grammarAccess.prCallOverridenParserRule());
		getOverridableParserRule2Consumer().setRule(grammarAccess.prOverridableParserRule2());
		getExtendableParserRuleConsumer().setRule(grammarAccess.prExtendableParserRule());
		getSubrule1Consumer().setRule(grammarAccess.prSubrule1());
		getSubrule2Consumer().setRule(grammarAccess.prSubrule2());
		getSubrule3Consumer().setRule(grammarAccess.prSubrule3());
		getCallExtendedParserRuleConsumer().setRule(grammarAccess.prCallExtendedParserRule());
		getInheritedParserRuleConsumer().setRule(grammarAccess.prInheritedParserRule());
		getAbstractCallOverridenParserRuleConsumer().setRule(grammarAccess.prAbstractCallOverridenParserRule());
		getAbstractCallExtendedParserRuleConsumer().setRule(grammarAccess.prAbstractCallExtendedParserRule());
		getRealConsumer().setRule(grammarAccess.lrREAL());
		getIdConsumer().setRule(grammarAccess.lrID());
		getIntConsumer().setRule(grammarAccess.lrINT());
		getStringConsumer().setRule(grammarAccess.lrSTRING());
		getMlCommentConsumer().setRule(grammarAccess.lrML_COMMENT());
		getSlCommentConsumer().setRule(grammarAccess.lrSL_COMMENT());
		getWsConsumer().setRule(grammarAccess.lrWS());
		getAnyOtherConsumer().setRule(grammarAccess.lrANY_OTHER());


		getRootRuleConsumer().setCallExtendedParserRuleConsumer(getCallExtendedParserRuleConsumer());
		getRootRuleConsumer().setCallOverridenParserRuleConsumer(getCallOverridenParserRuleConsumer());
		getRootRuleConsumer().setConcreteParserRuleConsumer(getConcreteParserRuleConsumer());
		getRootRuleConsumer().setOverridableParserRule2Consumer(getOverridableParserRule2Consumer());

		getConcreteParserRuleConsumer().setInheritedParserRuleConsumer(getInheritedParserRuleConsumer());
		getConcreteParserRuleConsumer().setRealConsumer(getRealConsumer());

		getOverridableParserRuleConsumer().setIdConsumer(getIdConsumer());

		getCallOverridenParserRuleConsumer().setAbstractCallOverridenParserRuleConsumer(getAbstractCallOverridenParserRuleConsumer());

		getOverridableParserRule2Consumer().setIdConsumer(getIdConsumer());
		getOverridableParserRule2Consumer().setIntConsumer(getIntConsumer());

		getExtendableParserRuleConsumer().setSubrule1Consumer(getSubrule1Consumer());
		getExtendableParserRuleConsumer().setSubrule2Consumer(getSubrule2Consumer());
		getExtendableParserRuleConsumer().setSubrule3Consumer(getSubrule3Consumer());

		getSubrule1Consumer().setIdConsumer(getIdConsumer());

		getSubrule2Consumer().setIdConsumer(getIdConsumer());
		getSubrule2Consumer().setStringConsumer(getStringConsumer());

		getSubrule3Consumer().setIdConsumer(getIdConsumer());
		getSubrule3Consumer().setIntConsumer(getIntConsumer());

		getCallExtendedParserRuleConsumer().setAbstractCallExtendedParserRuleConsumer(getAbstractCallExtendedParserRuleConsumer());

		getInheritedParserRuleConsumer().setIdConsumer(getIdConsumer());

		getAbstractCallOverridenParserRuleConsumer().setOverridableParserRuleConsumer(getOverridableParserRuleConsumer());

		getAbstractCallExtendedParserRuleConsumer().setExtendableParserRuleConsumer(getExtendableParserRuleConsumer());

		getConcreteParserRuleConsumer().setKeyword$4$Delimiter(ConcreteTestLanguageDelimiters.keyword$16$Delimiter);
		getConcreteParserRuleConsumer().setKeyword$7$Delimiter(ConcreteTestLanguageDelimiters.keyword$19$Delimiter);
		getConcreteParserRuleConsumer().setRuleCall$6$Delimiter(ConcreteTestLanguageDelimiters.ruleCall$18$Delimiter);
		getOverridableParserRuleConsumer().setKeyword$2$Delimiter(ConcreteTestLanguageDelimiters.keyword$16$Delimiter);
		getOverridableParserRuleConsumer().setRuleCall$4$Delimiter(ConcreteTestLanguageDelimiters.ruleCall$27$Delimiter);
		getOverridableParserRule2Consumer().setKeyword$4$Delimiter(ConcreteTestLanguageDelimiters.keyword$16$Delimiter);
		getOverridableParserRule2Consumer().setKeyword$7$Delimiter(ConcreteTestLanguageDelimiters.keyword$19$Delimiter);
		getOverridableParserRule2Consumer().setRuleCall$6$Delimiter(ConcreteTestLanguageDelimiters.ruleCall$27$Delimiter);
		getOverridableParserRule2Consumer().setRuleCall$9$Delimiter(ConcreteTestLanguageDelimiters.ruleCall$18$Delimiter);
		getSubrule1Consumer().setKeyword$3$Delimiter(ConcreteTestLanguageDelimiters.keyword$16$Delimiter);
		getSubrule1Consumer().setRuleCall$5$Delimiter(ConcreteTestLanguageDelimiters.ruleCall$27$Delimiter);
		getSubrule1Consumer().setRuleCall$7$Delimiter(ConcreteTestLanguageDelimiters.ruleCall$27$Delimiter);
		getSubrule2Consumer().setKeyword$3$Delimiter(ConcreteTestLanguageDelimiters.keyword$16$Delimiter);
		getSubrule2Consumer().setRuleCall$5$Delimiter(ConcreteTestLanguageDelimiters.ruleCall$27$Delimiter);
		getSubrule2Consumer().setRuleCall$7$Delimiter(ConcreteTestLanguageDelimiters.ruleCall$18$Delimiter);
		getSubrule3Consumer().setKeyword$3$Delimiter(ConcreteTestLanguageDelimiters.keyword$16$Delimiter);
		getSubrule3Consumer().setRuleCall$5$Delimiter(ConcreteTestLanguageDelimiters.ruleCall$27$Delimiter);
		getSubrule3Consumer().setRuleCall$7$Delimiter(ConcreteTestLanguageDelimiters.ruleCall$18$Delimiter);
		getInheritedParserRuleConsumer().setKeyword$2$Delimiter(ConcreteTestLanguageDelimiters.keyword$16$Delimiter);
		getInheritedParserRuleConsumer().setRuleCall$4$Delimiter(ConcreteTestLanguageDelimiters.ruleCall$27$Delimiter);
		getAbstractCallOverridenParserRuleConsumer().setKeyword$2$Delimiter(ConcreteTestLanguageDelimiters.keyword$16$Delimiter);
		getAbstractCallExtendedParserRuleConsumer().setKeyword$2$Delimiter(ConcreteTestLanguageDelimiters.keyword$16$Delimiter);
	}
	
	// TODO collect superGrammars transitive
	public AbstractTestLanguageParserConfiguration getAbstractTestLanguageConfiguration() {
		return abstractTestLanguageConfiguration;
	} 
	
    public ConcreteTestLanguageRootRuleConsumer getRootRuleConsumer() {
    	return rootRuleConsumer;
    }

    public ConcreteTestLanguageConcreteParserRuleConsumer getConcreteParserRuleConsumer() {
    	return concreteParserRuleConsumer;
    }

    public ConcreteTestLanguageOverridableParserRuleConsumer getOverridableParserRuleConsumer() {
    	return overridableParserRuleConsumer;
    }

    public ConcreteTestLanguageCallOverridenParserRuleConsumer getCallOverridenParserRuleConsumer() {
    	return callOverridenParserRuleConsumer;
    }

    public ConcreteTestLanguageOverridableParserRule2Consumer getOverridableParserRule2Consumer() {
    	return overridableParserRule2Consumer;
    }

    public ConcreteTestLanguageExtendableParserRuleConsumer getExtendableParserRuleConsumer() {
    	return extendableParserRuleConsumer;
    }

    public ConcreteTestLanguageSubrule1Consumer getSubrule1Consumer() {
    	return subrule1Consumer;
    }

    public ConcreteTestLanguageSubrule2Consumer getSubrule2Consumer() {
    	return subrule2Consumer;
    }

    public ConcreteTestLanguageSubrule3Consumer getSubrule3Consumer() {
    	return subrule3Consumer;
    }

    public ConcreteTestLanguageCallExtendedParserRuleConsumer getCallExtendedParserRuleConsumer() {
    	return callExtendedParserRuleConsumer;
    }

    public AbstractTestLanguageInheritedParserRuleConsumer getInheritedParserRuleConsumer() {
    	return getAbstractTestLanguageConfiguration().getInheritedParserRuleConsumer();
    }

    public AbstractTestLanguageAbstractCallOverridenParserRuleConsumer getAbstractCallOverridenParserRuleConsumer() {
    	return getAbstractTestLanguageConfiguration().getAbstractCallOverridenParserRuleConsumer();
    }

    public AbstractTestLanguageAbstractCallExtendedParserRuleConsumer getAbstractCallExtendedParserRuleConsumer() {
    	return getAbstractTestLanguageConfiguration().getAbstractCallExtendedParserRuleConsumer();
    }

    public AbstractTestLanguageREALConsumer getRealConsumer() {
    	return getAbstractTestLanguageConfiguration().getRealConsumer();
    }

    public AbstractTestLanguageIDConsumer getIdConsumer() {
    	return getAbstractTestLanguageConfiguration().getIdConsumer();
    }

    public XtextBuiltinINTConsumer getIntConsumer() {
    	return getAbstractTestLanguageConfiguration().getIntConsumer();
    }

    public XtextBuiltinSTRINGConsumer getStringConsumer() {
    	return getAbstractTestLanguageConfiguration().getStringConsumer();
    }

    public XtextBuiltinML_COMMENTConsumer getMlCommentConsumer() {
    	return getAbstractTestLanguageConfiguration().getMlCommentConsumer();
    }

    public XtextBuiltinSL_COMMENTConsumer getSlCommentConsumer() {
    	return getAbstractTestLanguageConfiguration().getSlCommentConsumer();
    }

    public XtextBuiltinWSConsumer getWsConsumer() {
    	return getAbstractTestLanguageConfiguration().getWsConsumer();
    }

    public XtextBuiltinANY_OTHERConsumer getAnyOtherConsumer() {
    	return getAbstractTestLanguageConfiguration().getAnyOtherConsumer();
    }

	@Override
	public ITerminalConsumer[] getInitialHiddenTerminals() {
		return getAbstractTestLanguageConfiguration().getInitialHiddenTerminals();
	}
	
}
