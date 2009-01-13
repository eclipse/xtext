/*
Generated with Xtext
*/
package org.eclipse.xtext.reference.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

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

	public ReferenceGrammarParserConfiguration(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil);
		this.xtextBuiltinConfiguration = new XtextBuiltinParserConfiguration(
			input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil);
	}

	public ReferenceGrammarSpielplatzConsumer getRootConsumer() {
		return spielplatzConsumer;
	} 
	
	public void createNonTerminalConsumers() {
		getXtextBuiltinConfiguration().createNonTerminalConsumers();
		spielplatzConsumer = new ReferenceGrammarSpielplatzConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(),
    		new ITerminalConsumer[]{ getWsConsumer(), getMlCommentConsumer(), getSlCommentConsumer() }
    	);
		personConsumer = new ReferenceGrammarPersonConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		kindConsumer = new ReferenceGrammarKindConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		erwachsenerConsumer = new ReferenceGrammarErwachsenerConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		spielzeugConsumer = new ReferenceGrammarSpielzeugConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		familieConsumer = new ReferenceGrammarFamilieConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		farbeConsumer = new ReferenceGrammarFarbeConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		customTypeParserRuleConsumer = new ReferenceGrammarCustomTypeParserRuleConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
	}
	
	public void createTerminalConsumers() {
		getXtextBuiltinConfiguration().createTerminalConsumers();
	}
	
	public void configureConsumers() {
		getSpielplatzConsumer().setErwachsenerConsumer(getErwachsenerConsumer());
		getSpielplatzConsumer().setSpielzeugConsumer(getSpielzeugConsumer());
		getSpielplatzConsumer().setIntConsumer(getIntConsumer());
		getSpielplatzConsumer().setStringConsumer(getStringConsumer());
		getSpielplatzConsumer().setFamilieConsumer(getFamilieConsumer());
		getSpielplatzConsumer().setKindConsumer(getKindConsumer());
		getSpielplatzConsumer().setCustomTypeParserRuleConsumer(getCustomTypeParserRuleConsumer());

		getPersonConsumer().setErwachsenerConsumer(getErwachsenerConsumer());
		getPersonConsumer().setKindConsumer(getKindConsumer());

		getKindConsumer().setIdConsumer(getIdConsumer());
		getKindConsumer().setIntConsumer(getIntConsumer());

		getErwachsenerConsumer().setIdConsumer(getIdConsumer());
		getErwachsenerConsumer().setIntConsumer(getIntConsumer());

		getSpielzeugConsumer().setIdConsumer(getIdConsumer());
		getSpielzeugConsumer().setFarbeConsumer(getFarbeConsumer());

		getFamilieConsumer().setIdConsumer(getIdConsumer());
		getFamilieConsumer().setStringConsumer(getStringConsumer());

		getCustomTypeParserRuleConsumer().setIdConsumer(getIdConsumer());

		getIdConsumer().initFields(this);
		getIntConsumer().initFields(this);
		getStringConsumer().initFields(this);
		getMlCommentConsumer().initFields(this);
		getSlCommentConsumer().initFields(this);
		getWsConsumer().initFields(this);
		getAnyOtherConsumer().initFields(this);
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



}
