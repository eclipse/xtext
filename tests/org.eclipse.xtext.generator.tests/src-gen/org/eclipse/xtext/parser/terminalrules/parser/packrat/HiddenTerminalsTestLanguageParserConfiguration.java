/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;

import org.eclipse.xtext.parser.terminalrules.services.HiddenTerminalsTestLanguageGrammarAccess;

import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.HiddenTerminalsTestLanguageModelConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.HiddenTerminalsTestLanguageWithoutHiddensConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.HiddenTerminalsTestLanguageWithHiddensConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.HiddenTerminalsTestLanguageOverridingHiddensConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.HiddenTerminalsTestLanguageOverridingHiddensCallConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.HiddenTerminalsTestLanguageInheritingHiddensConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.HiddenTerminalsTestLanguageDatatypeHiddensConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.HiddenTerminalsTestLanguageDatatypeRuleConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.HiddenTerminalsTestLanguageHidingHiddensConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.HiddenTerminalsTestLanguageInheritingHiddensCallConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.HiddenTerminalsTestLanguageML_COMMENTConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.HiddenTerminalsTestLanguageSL_COMMENTConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.HiddenTerminalsTestLanguageWSConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.HiddenTerminalsTestLanguageANY_OTHERConsumer;

@SuppressWarnings("unused")
public class HiddenTerminalsTestLanguageParserConfiguration extends AbstractParserConfiguration {

    private HiddenTerminalsTestLanguageModelConsumer modelConsumer;
    private HiddenTerminalsTestLanguageWithoutHiddensConsumer withoutHiddensConsumer;
    private HiddenTerminalsTestLanguageWithHiddensConsumer withHiddensConsumer;
    private HiddenTerminalsTestLanguageOverridingHiddensConsumer overridingHiddensConsumer;
    private HiddenTerminalsTestLanguageOverridingHiddensCallConsumer overridingHiddensCallConsumer;
    private HiddenTerminalsTestLanguageInheritingHiddensConsumer inheritingHiddensConsumer;
    private HiddenTerminalsTestLanguageDatatypeHiddensConsumer datatypeHiddensConsumer;
    private HiddenTerminalsTestLanguageDatatypeRuleConsumer datatypeRuleConsumer;
    private HiddenTerminalsTestLanguageHidingHiddensConsumer hidingHiddensConsumer;
    private HiddenTerminalsTestLanguageInheritingHiddensCallConsumer inheritingHiddensCallConsumer;
    private HiddenTerminalsTestLanguageML_COMMENTConsumer mlCommentConsumer;
    private HiddenTerminalsTestLanguageSL_COMMENTConsumer slCommentConsumer;
    private HiddenTerminalsTestLanguageWSConsumer wsConsumer;
    private HiddenTerminalsTestLanguageANY_OTHERConsumer anyOtherConsumer;

	private HiddenTerminalsTestLanguageGrammarAccess grammarAccess;

	public HiddenTerminalsTestLanguageParserConfiguration(IInternalParserConfiguration configuration, HiddenTerminalsTestLanguageGrammarAccess grammarAccess) {
		super(configuration);
		this.grammarAccess = grammarAccess;
	}

	public HiddenTerminalsTestLanguageModelConsumer getRootConsumer() {
		return modelConsumer;
	} 

	public void createNonTerminalConsumers() {
		modelConsumer = new HiddenTerminalsTestLanguageModelConsumer(
    		this, null
    	);
		withoutHiddensConsumer = new HiddenTerminalsTestLanguageWithoutHiddensConsumer(
    		this, null
    	);
		withHiddensConsumer = new HiddenTerminalsTestLanguageWithHiddensConsumer(
    		this, new ITerminalConsumer[]{ getWsConsumer(), getMlCommentConsumer(), getSlCommentConsumer() }
    	);
		overridingHiddensConsumer = new HiddenTerminalsTestLanguageOverridingHiddensConsumer(
    		this, new ITerminalConsumer[]{ getWsConsumer(), getMlCommentConsumer(), getSlCommentConsumer() }
    	);
		overridingHiddensCallConsumer = new HiddenTerminalsTestLanguageOverridingHiddensCallConsumer(
    		this, new ITerminalConsumer[]{  }
    	);
		inheritingHiddensConsumer = new HiddenTerminalsTestLanguageInheritingHiddensConsumer(
    		this, new ITerminalConsumer[]{ getWsConsumer(), getMlCommentConsumer(), getSlCommentConsumer() }
    	);
		datatypeHiddensConsumer = new HiddenTerminalsTestLanguageDatatypeHiddensConsumer(
    		this, null
    	);
		datatypeRuleConsumer = new HiddenTerminalsTestLanguageDatatypeRuleConsumer(
    		this, new ITerminalConsumer[]{ getWsConsumer() }
    	);
		hidingHiddensConsumer = new HiddenTerminalsTestLanguageHidingHiddensConsumer(
    		this, new ITerminalConsumer[]{  }
    	);
		inheritingHiddensCallConsumer = new HiddenTerminalsTestLanguageInheritingHiddensCallConsumer(
    		this, null
    	);
	}
	
	public void createTerminalConsumers() {
		mlCommentConsumer = new HiddenTerminalsTestLanguageML_COMMENTConsumer(this);
		slCommentConsumer = new HiddenTerminalsTestLanguageSL_COMMENTConsumer(this);
		wsConsumer = new HiddenTerminalsTestLanguageWSConsumer(this);
		anyOtherConsumer = new HiddenTerminalsTestLanguageANY_OTHERConsumer(this);
	}
	
	public void configureConsumers() {
		if (grammarAccess == null)
			throw new NullPointerException("grammarAccess may not be null, if you call configureConsumers");
		getModelConsumer().setRule(grammarAccess.prModel());
		getWithoutHiddensConsumer().setRule(grammarAccess.prWithoutHiddens());
		getWithHiddensConsumer().setRule(grammarAccess.prWithHiddens());
		getOverridingHiddensConsumer().setRule(grammarAccess.prOverridingHiddens());
		getOverridingHiddensCallConsumer().setRule(grammarAccess.prOverridingHiddensCall());
		getInheritingHiddensConsumer().setRule(grammarAccess.prInheritingHiddens());
		getDatatypeHiddensConsumer().setRule(grammarAccess.prDatatypeHiddens());
		getDatatypeRuleConsumer().setRule(grammarAccess.prDatatypeRule());
		getHidingHiddensConsumer().setRule(grammarAccess.prHidingHiddens());
		getInheritingHiddensCallConsumer().setRule(grammarAccess.prInheritingHiddensCall());
		getMlCommentConsumer().setRule(grammarAccess.prML_COMMENT());
		getSlCommentConsumer().setRule(grammarAccess.prSL_COMMENT());
		getWsConsumer().setRule(grammarAccess.prWS());
		getAnyOtherConsumer().setRule(grammarAccess.prANY_OTHER());


		getModelConsumer().setDatatypeHiddensConsumer(getDatatypeHiddensConsumer());
		getModelConsumer().setInheritingHiddensConsumer(getInheritingHiddensConsumer());
		getModelConsumer().setOverridingHiddensConsumer(getOverridingHiddensConsumer());
		getModelConsumer().setWithHiddensConsumer(getWithHiddensConsumer());
		getModelConsumer().setWithoutHiddensConsumer(getWithoutHiddensConsumer());

		getWithoutHiddensConsumer().setWsConsumer(getWsConsumer());


		getOverridingHiddensConsumer().setOverridingHiddensCallConsumer(getOverridingHiddensCallConsumer());

		getOverridingHiddensCallConsumer().setWsConsumer(getWsConsumer());

		getInheritingHiddensConsumer().setHidingHiddensConsumer(getHidingHiddensConsumer());
		getInheritingHiddensConsumer().setInheritingHiddensCallConsumer(getInheritingHiddensCallConsumer());

		getDatatypeHiddensConsumer().setDatatypeRuleConsumer(getDatatypeRuleConsumer());


		getHidingHiddensConsumer().setInheritingHiddensCallConsumer(getInheritingHiddensCallConsumer());
		getHidingHiddensConsumer().setWsConsumer(getWsConsumer());






		getWithoutHiddensConsumer().setKeyword$5$Delimiter(HiddenTerminalsTestLanguageDelimiters.keyword$19$Delimiter);
		getWithoutHiddensConsumer().setKeyword$8$Delimiter(HiddenTerminalsTestLanguageDelimiters.keyword$19$Delimiter);
		getWithoutHiddensConsumer().setKeyword$12$Delimiter(HiddenTerminalsTestLanguageDelimiters.keyword$19$Delimiter);
		getWithoutHiddensConsumer().setRuleCall$7$Delimiter(HiddenTerminalsTestLanguageDelimiters.ruleCall$21$Delimiter);
		getWithoutHiddensConsumer().setRuleCall$10$Delimiter(HiddenTerminalsTestLanguageDelimiters.ruleCall$21$Delimiter);
		getWithHiddensConsumer().setKeyword$3$Delimiter(HiddenTerminalsTestLanguageDelimiters.keyword$19$Delimiter);
		getWithHiddensConsumer().setKeyword$4$Delimiter(HiddenTerminalsTestLanguageDelimiters.keyword$19$Delimiter);
		getWithHiddensConsumer().setKeyword$6$Delimiter(HiddenTerminalsTestLanguageDelimiters.keyword$19$Delimiter);
		getOverridingHiddensConsumer().setKeyword$6$Delimiter(HiddenTerminalsTestLanguageDelimiters.keyword$19$Delimiter);
		getOverridingHiddensConsumer().setKeyword$7$Delimiter(HiddenTerminalsTestLanguageDelimiters.keyword$19$Delimiter);
		getOverridingHiddensConsumer().setKeyword$8$Delimiter(HiddenTerminalsTestLanguageDelimiters.keyword$19$Delimiter);
		getOverridingHiddensConsumer().setKeyword$11$Delimiter(HiddenTerminalsTestLanguageDelimiters.keyword$19$Delimiter);
		getOverridingHiddensConsumer().setKeyword$13$Delimiter(HiddenTerminalsTestLanguageDelimiters.keyword$19$Delimiter);
		getOverridingHiddensCallConsumer().setKeyword$3$Delimiter(HiddenTerminalsTestLanguageDelimiters.keyword$19$Delimiter);
		getOverridingHiddensCallConsumer().setKeyword$7$Delimiter(HiddenTerminalsTestLanguageDelimiters.keyword$19$Delimiter);
		getOverridingHiddensCallConsumer().setRuleCall$5$Delimiter(HiddenTerminalsTestLanguageDelimiters.ruleCall$21$Delimiter);
		getInheritingHiddensConsumer().setKeyword$6$Delimiter(HiddenTerminalsTestLanguageDelimiters.keyword$19$Delimiter);
		getInheritingHiddensConsumer().setKeyword$7$Delimiter(HiddenTerminalsTestLanguageDelimiters.keyword$19$Delimiter);
		getInheritingHiddensConsumer().setKeyword$8$Delimiter(HiddenTerminalsTestLanguageDelimiters.keyword$19$Delimiter);
		getInheritingHiddensConsumer().setKeyword$14$Delimiter(HiddenTerminalsTestLanguageDelimiters.keyword$19$Delimiter);
		getInheritingHiddensConsumer().setKeyword$16$Delimiter(HiddenTerminalsTestLanguageDelimiters.keyword$19$Delimiter);
		getDatatypeHiddensConsumer().setKeyword$2$Delimiter(HiddenTerminalsTestLanguageDelimiters.keyword$19$Delimiter);
		getDatatypeRuleConsumer().setKeyword$2$Delimiter(HiddenTerminalsTestLanguageDelimiters.keyword$19$Delimiter);
		getDatatypeRuleConsumer().setKeyword$3$Delimiter(HiddenTerminalsTestLanguageDelimiters.keyword$19$Delimiter);
		getHidingHiddensConsumer().setKeyword$3$Delimiter(HiddenTerminalsTestLanguageDelimiters.keyword$19$Delimiter);
		getHidingHiddensConsumer().setRuleCall$5$Delimiter(HiddenTerminalsTestLanguageDelimiters.ruleCall$21$Delimiter);
		getInheritingHiddensCallConsumer().setKeyword$2$Delimiter(HiddenTerminalsTestLanguageDelimiters.keyword$19$Delimiter);
		getInheritingHiddensCallConsumer().setKeyword$4$Delimiter(HiddenTerminalsTestLanguageDelimiters.keyword$19$Delimiter);
	}
	
    public HiddenTerminalsTestLanguageModelConsumer getModelConsumer() {
    	return modelConsumer;
    }

    public HiddenTerminalsTestLanguageWithoutHiddensConsumer getWithoutHiddensConsumer() {
    	return withoutHiddensConsumer;
    }

    public HiddenTerminalsTestLanguageWithHiddensConsumer getWithHiddensConsumer() {
    	return withHiddensConsumer;
    }

    public HiddenTerminalsTestLanguageOverridingHiddensConsumer getOverridingHiddensConsumer() {
    	return overridingHiddensConsumer;
    }

    public HiddenTerminalsTestLanguageOverridingHiddensCallConsumer getOverridingHiddensCallConsumer() {
    	return overridingHiddensCallConsumer;
    }

    public HiddenTerminalsTestLanguageInheritingHiddensConsumer getInheritingHiddensConsumer() {
    	return inheritingHiddensConsumer;
    }

    public HiddenTerminalsTestLanguageDatatypeHiddensConsumer getDatatypeHiddensConsumer() {
    	return datatypeHiddensConsumer;
    }

    public HiddenTerminalsTestLanguageDatatypeRuleConsumer getDatatypeRuleConsumer() {
    	return datatypeRuleConsumer;
    }

    public HiddenTerminalsTestLanguageHidingHiddensConsumer getHidingHiddensConsumer() {
    	return hidingHiddensConsumer;
    }

    public HiddenTerminalsTestLanguageInheritingHiddensCallConsumer getInheritingHiddensCallConsumer() {
    	return inheritingHiddensCallConsumer;
    }

    public HiddenTerminalsTestLanguageML_COMMENTConsumer getMlCommentConsumer() {
    	return mlCommentConsumer;
    }

    public HiddenTerminalsTestLanguageSL_COMMENTConsumer getSlCommentConsumer() {
    	return slCommentConsumer;
    }

    public HiddenTerminalsTestLanguageWSConsumer getWsConsumer() {
    	return wsConsumer;
    }

    public HiddenTerminalsTestLanguageANY_OTHERConsumer getAnyOtherConsumer() {
    	return anyOtherConsumer;
    }

}
