/*
Generated with Xtext
*/
package org.eclipse.xtext.reference.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;

import org.eclipse.xtext.reference.services.ReferenceGrammarGrammarAccess;

import org.eclipse.xtext.builtin.parser.packrat.XtextBuiltinParserConfiguration; 

import org.eclipse.xtext.reference.parser.packrat.consumers.ReferenceGrammarSpielplatzConsumer;
import org.eclipse.xtext.reference.parser.packrat.consumers.ReferenceGrammarPersonConsumer;
import org.eclipse.xtext.reference.parser.packrat.consumers.ReferenceGrammarKindConsumer;
import org.eclipse.xtext.reference.parser.packrat.consumers.ReferenceGrammarErwachsenerConsumer;
import org.eclipse.xtext.reference.parser.packrat.consumers.ReferenceGrammarSpielzeugConsumer;
import org.eclipse.xtext.reference.parser.packrat.consumers.ReferenceGrammarFamilieConsumer;
import org.eclipse.xtext.reference.parser.packrat.consumers.ReferenceGrammarFarbeConsumer;
import org.eclipse.xtext.reference.parser.packrat.consumers.ReferenceGrammarCustomTypeParserRuleConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinML_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSL_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinWSConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinANY_OTHERConsumer;

@SuppressWarnings("unused")
public class ReferenceGrammarParserConfiguration extends AbstractParserConfiguration {

	private XtextBuiltinParserConfiguration xtextBuiltinConfiguration; 

    private ReferenceGrammarSpielplatzConsumer spielplatzConsumer;
    private ReferenceGrammarPersonConsumer personConsumer;
    private ReferenceGrammarKindConsumer kindConsumer;
    private ReferenceGrammarErwachsenerConsumer erwachsenerConsumer;
    private ReferenceGrammarSpielzeugConsumer spielzeugConsumer;
    private ReferenceGrammarFamilieConsumer familieConsumer;
    private ReferenceGrammarFarbeConsumer farbeConsumer;
    private ReferenceGrammarCustomTypeParserRuleConsumer customTypeParserRuleConsumer;

	private ReferenceGrammarGrammarAccess grammarAccess;

	public ReferenceGrammarParserConfiguration(IInternalParserConfiguration configuration, ReferenceGrammarGrammarAccess grammarAccess) {
		super(configuration);
		this.grammarAccess = grammarAccess;
		this.xtextBuiltinConfiguration = new XtextBuiltinParserConfiguration(configuration, null);
	}

	public ReferenceGrammarSpielplatzConsumer getRootConsumer() {
		return spielplatzConsumer;
	} 

	public void createNonTerminalConsumers() {
		getXtextBuiltinConfiguration().createNonTerminalConsumers();
		spielplatzConsumer = new ReferenceGrammarSpielplatzConsumer(
    		this, null
    	);
		personConsumer = new ReferenceGrammarPersonConsumer(
    		this, null
    	);
		kindConsumer = new ReferenceGrammarKindConsumer(
    		this, null
    	);
		erwachsenerConsumer = new ReferenceGrammarErwachsenerConsumer(
    		this, null
    	);
		spielzeugConsumer = new ReferenceGrammarSpielzeugConsumer(
    		this, null
    	);
		familieConsumer = new ReferenceGrammarFamilieConsumer(
    		this, null
    	);
		farbeConsumer = new ReferenceGrammarFarbeConsumer(
    		this, null
    	);
		customTypeParserRuleConsumer = new ReferenceGrammarCustomTypeParserRuleConsumer(
    		this, null
    	);
	}
	
	public void createTerminalConsumers() {
		getXtextBuiltinConfiguration().createTerminalConsumers();
	}
	
	public void configureConsumers() {
		if (grammarAccess == null)
			throw new NullPointerException("grammarAccess may not be null, if you call configureConsumers");
		getSpielplatzConsumer().setRule(grammarAccess.prSpielplatz());
		getPersonConsumer().setRule(grammarAccess.prPerson());
		getKindConsumer().setRule(grammarAccess.prKind());
		getErwachsenerConsumer().setRule(grammarAccess.prErwachsener());
		getSpielzeugConsumer().setRule(grammarAccess.prSpielzeug());
		getFamilieConsumer().setRule(grammarAccess.prFamilie());
		getFarbeConsumer().setRule(grammarAccess.prFarbe());
		getCustomTypeParserRuleConsumer().setRule(grammarAccess.prCustomTypeParserRule());
		getIdConsumer().setRule(grammarAccess.lrID());
		getIntConsumer().setRule(grammarAccess.lrINT());
		getStringConsumer().setRule(grammarAccess.lrSTRING());
		getMlCommentConsumer().setRule(grammarAccess.lrML_COMMENT());
		getSlCommentConsumer().setRule(grammarAccess.lrSL_COMMENT());
		getWsConsumer().setRule(grammarAccess.lrWS());
		getAnyOtherConsumer().setRule(grammarAccess.lrANY_OTHER());


		getSpielplatzConsumer().setCustomTypeParserRuleConsumer(getCustomTypeParserRuleConsumer());
		getSpielplatzConsumer().setErwachsenerConsumer(getErwachsenerConsumer());
		getSpielplatzConsumer().setFamilieConsumer(getFamilieConsumer());
		getSpielplatzConsumer().setIntConsumer(getIntConsumer());
		getSpielplatzConsumer().setKindConsumer(getKindConsumer());
		getSpielplatzConsumer().setSpielzeugConsumer(getSpielzeugConsumer());
		getSpielplatzConsumer().setStringConsumer(getStringConsumer());

		getPersonConsumer().setErwachsenerConsumer(getErwachsenerConsumer());
		getPersonConsumer().setKindConsumer(getKindConsumer());

		getKindConsumer().setIdConsumer(getIdConsumer());
		getKindConsumer().setIntConsumer(getIntConsumer());

		getErwachsenerConsumer().setIdConsumer(getIdConsumer());
		getErwachsenerConsumer().setIntConsumer(getIntConsumer());

		getSpielzeugConsumer().setFarbeConsumer(getFarbeConsumer());
		getSpielzeugConsumer().setIdConsumer(getIdConsumer());

		getFamilieConsumer().setIdConsumer(getIdConsumer());
		getFamilieConsumer().setStringConsumer(getStringConsumer());


		getCustomTypeParserRuleConsumer().setIdConsumer(getIdConsumer());

		getSpielplatzConsumer().setKeyword$11$Delimiter(ReferenceGrammarDelimiters.keyword$14$Delimiter);
		getSpielplatzConsumer().setKeyword$26$Delimiter(ReferenceGrammarDelimiters.keyword$14$Delimiter);
		getSpielplatzConsumer().setKeyword$6$Delimiter(ReferenceGrammarDelimiters.keyword$9$Delimiter);
		getSpielplatzConsumer().setRuleCall$8$Delimiter(ReferenceGrammarDelimiters.ruleCall$11$Delimiter);
		getSpielplatzConsumer().setRuleCall$10$Delimiter(ReferenceGrammarDelimiters.ruleCall$11$Delimiter);
		getKindConsumer().setKeyword$5$Delimiter(ReferenceGrammarDelimiters.keyword$9$Delimiter);
		getKindConsumer().setKeyword$6$Delimiter(ReferenceGrammarDelimiters.keyword$14$Delimiter);
		getKindConsumer().setKeyword$11$Delimiter(ReferenceGrammarDelimiters.keyword$14$Delimiter);
		getKindConsumer().setRuleCall$8$Delimiter(ReferenceGrammarDelimiters.ruleCall$44$Delimiter);
		getKindConsumer().setRuleCall$10$Delimiter(ReferenceGrammarDelimiters.ruleCall$11$Delimiter);
		getErwachsenerConsumer().setKeyword$5$Delimiter(ReferenceGrammarDelimiters.keyword$9$Delimiter);
		getErwachsenerConsumer().setKeyword$6$Delimiter(ReferenceGrammarDelimiters.keyword$14$Delimiter);
		getErwachsenerConsumer().setKeyword$11$Delimiter(ReferenceGrammarDelimiters.keyword$14$Delimiter);
		getErwachsenerConsumer().setRuleCall$8$Delimiter(ReferenceGrammarDelimiters.ruleCall$44$Delimiter);
		getErwachsenerConsumer().setRuleCall$10$Delimiter(ReferenceGrammarDelimiters.ruleCall$11$Delimiter);
		getSpielzeugConsumer().setKeyword$5$Delimiter(ReferenceGrammarDelimiters.keyword$9$Delimiter);
		getSpielzeugConsumer().setKeyword$6$Delimiter(ReferenceGrammarDelimiters.keyword$14$Delimiter);
		getSpielzeugConsumer().setKeyword$11$Delimiter(ReferenceGrammarDelimiters.keyword$14$Delimiter);
		getSpielzeugConsumer().setRuleCall$8$Delimiter(ReferenceGrammarDelimiters.ruleCall$44$Delimiter);
		getFamilieConsumer().setCrossReference$28$Delimiter(ReferenceGrammarDelimiters.ruleCall$44$Delimiter);
		getFamilieConsumer().setCrossReference$17$Delimiter(ReferenceGrammarDelimiters.ruleCall$44$Delimiter);
		getFamilieConsumer().setCrossReference$20$Delimiter(ReferenceGrammarDelimiters.ruleCall$44$Delimiter);
		getFamilieConsumer().setCrossReference$23$Delimiter(ReferenceGrammarDelimiters.ruleCall$44$Delimiter);
		getFamilieConsumer().setKeyword$26$Delimiter(ReferenceGrammarDelimiters.keyword$14$Delimiter);
		getFamilieConsumer().setKeyword$30$Delimiter(ReferenceGrammarDelimiters.keyword$14$Delimiter);
		getFamilieConsumer().setKeyword$8$Delimiter(ReferenceGrammarDelimiters.keyword$9$Delimiter);
		getFamilieConsumer().setKeyword$9$Delimiter(ReferenceGrammarDelimiters.keyword$14$Delimiter);
		getFamilieConsumer().setKeyword$13$Delimiter(ReferenceGrammarDelimiters.keyword$9$Delimiter);
		getFamilieConsumer().setRuleCall$14$Delimiter(ReferenceGrammarDelimiters.ruleCall$11$Delimiter);
		getFamilieConsumer().setRuleCall$15$Delimiter(ReferenceGrammarDelimiters.ruleCall$44$Delimiter);
		getFarbeConsumer().setKeyword$5$Delimiter(ReferenceGrammarDelimiters.keyword$9$Delimiter);
		getFarbeConsumer().setKeyword$6$Delimiter(ReferenceGrammarDelimiters.keyword$9$Delimiter);
		getFarbeConsumer().setKeyword$7$Delimiter(ReferenceGrammarDelimiters.keyword$9$Delimiter);
		getFarbeConsumer().setKeyword$8$Delimiter(ReferenceGrammarDelimiters.keyword$9$Delimiter);
		getCustomTypeParserRuleConsumer().setKeyword$2$Delimiter(ReferenceGrammarDelimiters.keyword$9$Delimiter);
		getCustomTypeParserRuleConsumer().setRuleCall$4$Delimiter(ReferenceGrammarDelimiters.ruleCall$44$Delimiter);
	}
	
	// TODO collect superGrammars transitive
	public XtextBuiltinParserConfiguration getXtextBuiltinConfiguration() {
		return xtextBuiltinConfiguration;
	} 
	
    public ReferenceGrammarSpielplatzConsumer getSpielplatzConsumer() {
    	return spielplatzConsumer;
    }

    public ReferenceGrammarPersonConsumer getPersonConsumer() {
    	return personConsumer;
    }

    public ReferenceGrammarKindConsumer getKindConsumer() {
    	return kindConsumer;
    }

    public ReferenceGrammarErwachsenerConsumer getErwachsenerConsumer() {
    	return erwachsenerConsumer;
    }

    public ReferenceGrammarSpielzeugConsumer getSpielzeugConsumer() {
    	return spielzeugConsumer;
    }

    public ReferenceGrammarFamilieConsumer getFamilieConsumer() {
    	return familieConsumer;
    }

    public ReferenceGrammarFarbeConsumer getFarbeConsumer() {
    	return farbeConsumer;
    }

    public ReferenceGrammarCustomTypeParserRuleConsumer getCustomTypeParserRuleConsumer() {
    	return customTypeParserRuleConsumer;
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
