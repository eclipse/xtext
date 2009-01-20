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

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.ReferenceGrammarTestLanguageSpielplatzConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.ReferenceGrammarTestLanguagePersonConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.ReferenceGrammarTestLanguageKindConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.ReferenceGrammarTestLanguageErwachsenerConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.ReferenceGrammarTestLanguageSpielzeugConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.ReferenceGrammarTestLanguageFarbeConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.ReferenceGrammarTestLanguageFamilieConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinML_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSL_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinWSConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinANY_OTHERConsumer;

public class ReferenceGrammarTestLanguageParserConfiguration extends AbstractParserConfiguration {

	private XtextBuiltinParserConfiguration xtextBuiltinConfiguration; 

    private ReferenceGrammarTestLanguageSpielplatzConsumer spielplatzConsumer;
    private ReferenceGrammarTestLanguagePersonConsumer personConsumer;
    private ReferenceGrammarTestLanguageKindConsumer kindConsumer;
    private ReferenceGrammarTestLanguageErwachsenerConsumer erwachsenerConsumer;
    private ReferenceGrammarTestLanguageSpielzeugConsumer spielzeugConsumer;
    private ReferenceGrammarTestLanguageFarbeConsumer farbeConsumer;
    private ReferenceGrammarTestLanguageFamilieConsumer familieConsumer;

	public ReferenceGrammarTestLanguageParserConfiguration(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil);
		this.xtextBuiltinConfiguration = new XtextBuiltinParserConfiguration(
			input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil);
	}

	public ReferenceGrammarTestLanguageSpielplatzConsumer getRootConsumer() {
		return spielplatzConsumer;
	} 
	
	public void createNonTerminalConsumers() {
		getXtextBuiltinConfiguration().createNonTerminalConsumers();
		spielplatzConsumer = new ReferenceGrammarTestLanguageSpielplatzConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		personConsumer = new ReferenceGrammarTestLanguagePersonConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		kindConsumer = new ReferenceGrammarTestLanguageKindConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		erwachsenerConsumer = new ReferenceGrammarTestLanguageErwachsenerConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		spielzeugConsumer = new ReferenceGrammarTestLanguageSpielzeugConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		farbeConsumer = new ReferenceGrammarTestLanguageFarbeConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		familieConsumer = new ReferenceGrammarTestLanguageFamilieConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
	}
	
	public void createTerminalConsumers() {
		getXtextBuiltinConfiguration().createTerminalConsumers();
	}
	
	public void configureConsumers() {
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

		getSpielplatzConsumer().setKeyword$11$Delimiter(ReferenceGrammarTestLanguageDelimiters.keyword$13$Delimiter);
		getSpielplatzConsumer().setKeyword$23$Delimiter(ReferenceGrammarTestLanguageDelimiters.keyword$13$Delimiter);
		getSpielplatzConsumer().setKeyword$6$Delimiter(ReferenceGrammarTestLanguageDelimiters.keyword$8$Delimiter);
		getSpielplatzConsumer().setRuleCall$8$Delimiter(ReferenceGrammarTestLanguageDelimiters.ruleCall$10$Delimiter);
		getSpielplatzConsumer().setRuleCall$10$Delimiter(ReferenceGrammarTestLanguageDelimiters.ruleCall$10$Delimiter);
		getKindConsumer().setKeyword$5$Delimiter(ReferenceGrammarTestLanguageDelimiters.keyword$8$Delimiter);
		getKindConsumer().setKeyword$6$Delimiter(ReferenceGrammarTestLanguageDelimiters.keyword$13$Delimiter);
		getKindConsumer().setKeyword$11$Delimiter(ReferenceGrammarTestLanguageDelimiters.keyword$13$Delimiter);
		getKindConsumer().setRuleCall$8$Delimiter(ReferenceGrammarTestLanguageDelimiters.ruleCall$40$Delimiter);
		getKindConsumer().setRuleCall$10$Delimiter(ReferenceGrammarTestLanguageDelimiters.ruleCall$10$Delimiter);
		getErwachsenerConsumer().setKeyword$5$Delimiter(ReferenceGrammarTestLanguageDelimiters.keyword$8$Delimiter);
		getErwachsenerConsumer().setKeyword$6$Delimiter(ReferenceGrammarTestLanguageDelimiters.keyword$13$Delimiter);
		getErwachsenerConsumer().setKeyword$11$Delimiter(ReferenceGrammarTestLanguageDelimiters.keyword$13$Delimiter);
		getErwachsenerConsumer().setRuleCall$8$Delimiter(ReferenceGrammarTestLanguageDelimiters.ruleCall$40$Delimiter);
		getErwachsenerConsumer().setRuleCall$10$Delimiter(ReferenceGrammarTestLanguageDelimiters.ruleCall$10$Delimiter);
		getSpielzeugConsumer().setKeyword$5$Delimiter(ReferenceGrammarTestLanguageDelimiters.keyword$8$Delimiter);
		getSpielzeugConsumer().setKeyword$6$Delimiter(ReferenceGrammarTestLanguageDelimiters.keyword$13$Delimiter);
		getSpielzeugConsumer().setKeyword$11$Delimiter(ReferenceGrammarTestLanguageDelimiters.keyword$13$Delimiter);
		getSpielzeugConsumer().setRuleCall$8$Delimiter(ReferenceGrammarTestLanguageDelimiters.ruleCall$40$Delimiter);
		getFarbeConsumer().setKeyword$4$Delimiter(ReferenceGrammarTestLanguageDelimiters.keyword$8$Delimiter);
		getFarbeConsumer().setKeyword$5$Delimiter(ReferenceGrammarTestLanguageDelimiters.keyword$8$Delimiter);
		getFarbeConsumer().setKeyword$6$Delimiter(ReferenceGrammarTestLanguageDelimiters.keyword$8$Delimiter);
		getFarbeConsumer().setKeyword$7$Delimiter(ReferenceGrammarTestLanguageDelimiters.keyword$8$Delimiter);
		getFamilieConsumer().setCrossReference$20$Delimiter(ReferenceGrammarTestLanguageDelimiters.ruleCall$40$Delimiter);
		getFamilieConsumer().setCrossReference$23$Delimiter(ReferenceGrammarTestLanguageDelimiters.ruleCall$40$Delimiter);
		getFamilieConsumer().setCrossReference$28$Delimiter(ReferenceGrammarTestLanguageDelimiters.ruleCall$40$Delimiter);
		getFamilieConsumer().setCrossReference$17$Delimiter(ReferenceGrammarTestLanguageDelimiters.ruleCall$40$Delimiter);
		getFamilieConsumer().setKeyword$26$Delimiter(ReferenceGrammarTestLanguageDelimiters.keyword$13$Delimiter);
		getFamilieConsumer().setKeyword$30$Delimiter(ReferenceGrammarTestLanguageDelimiters.keyword$13$Delimiter);
		getFamilieConsumer().setKeyword$8$Delimiter(ReferenceGrammarTestLanguageDelimiters.keyword$8$Delimiter);
		getFamilieConsumer().setKeyword$9$Delimiter(ReferenceGrammarTestLanguageDelimiters.keyword$13$Delimiter);
		getFamilieConsumer().setKeyword$13$Delimiter(ReferenceGrammarTestLanguageDelimiters.keyword$8$Delimiter);
		getFamilieConsumer().setRuleCall$14$Delimiter(ReferenceGrammarTestLanguageDelimiters.ruleCall$10$Delimiter);
		getFamilieConsumer().setRuleCall$15$Delimiter(ReferenceGrammarTestLanguageDelimiters.ruleCall$40$Delimiter);
	}
	
	// TODO collect superGrammars transitive
	public XtextBuiltinParserConfiguration getXtextBuiltinConfiguration() {
		return xtextBuiltinConfiguration;
	} 
	
    public ReferenceGrammarTestLanguageSpielplatzConsumer getSpielplatzConsumer() {
    	return spielplatzConsumer;
    }

    public ReferenceGrammarTestLanguagePersonConsumer getPersonConsumer() {
    	return personConsumer;
    }

    public ReferenceGrammarTestLanguageKindConsumer getKindConsumer() {
    	return kindConsumer;
    }

    public ReferenceGrammarTestLanguageErwachsenerConsumer getErwachsenerConsumer() {
    	return erwachsenerConsumer;
    }

    public ReferenceGrammarTestLanguageSpielzeugConsumer getSpielzeugConsumer() {
    	return spielzeugConsumer;
    }

    public ReferenceGrammarTestLanguageFarbeConsumer getFarbeConsumer() {
    	return farbeConsumer;
    }

    public ReferenceGrammarTestLanguageFamilieConsumer getFamilieConsumer() {
    	return familieConsumer;
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
