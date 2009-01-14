/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr.parser.packrat;

import org.eclipse.xtext.parser.packrat.AbstractParserConfiguration;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.builtin.parser.packrat.XtextBuiltinParserConfiguration; 

import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.ComplexReconstrTestLanguageRootConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.ComplexReconstrTestLanguageOpConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.ComplexReconstrTestLanguageTermConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.ComplexReconstrTestLanguageAtomConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.ComplexReconstrTestLanguageParensConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.ComplexReconstrTestLanguageTrickyAConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.ComplexReconstrTestLanguageTrickyA1Consumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.ComplexReconstrTestLanguageTrickyBConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.ComplexReconstrTestLanguageTrickyCConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.ComplexReconstrTestLanguageTrickyDConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.ComplexReconstrTestLanguageTrickyEConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.ComplexReconstrTestLanguageTrickyFConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.ComplexReconstrTestLanguageTrickyGConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.ComplexReconstrTestLanguageTrickyG1Consumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.ComplexReconstrTestLanguageTrickyG2Consumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinML_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSL_COMMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinWSConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinANY_OTHERConsumer;

public class ComplexReconstrTestLanguageParserConfiguration extends AbstractParserConfiguration {

	private XtextBuiltinParserConfiguration xtextBuiltinConfiguration; 

    private ComplexReconstrTestLanguageRootConsumer rootConsumer;
    private ComplexReconstrTestLanguageOpConsumer opConsumer;
    private ComplexReconstrTestLanguageTermConsumer termConsumer;
    private ComplexReconstrTestLanguageAtomConsumer atomConsumer;
    private ComplexReconstrTestLanguageParensConsumer parensConsumer;
    private ComplexReconstrTestLanguageTrickyAConsumer trickyAConsumer;
    private ComplexReconstrTestLanguageTrickyA1Consumer trickyA1Consumer;
    private ComplexReconstrTestLanguageTrickyBConsumer trickyBConsumer;
    private ComplexReconstrTestLanguageTrickyCConsumer trickyCConsumer;
    private ComplexReconstrTestLanguageTrickyDConsumer trickyDConsumer;
    private ComplexReconstrTestLanguageTrickyEConsumer trickyEConsumer;
    private ComplexReconstrTestLanguageTrickyFConsumer trickyFConsumer;
    private ComplexReconstrTestLanguageTrickyGConsumer trickyGConsumer;
    private ComplexReconstrTestLanguageTrickyG1Consumer trickyG1Consumer;
    private ComplexReconstrTestLanguageTrickyG2Consumer trickyG2Consumer;

	public ComplexReconstrTestLanguageParserConfiguration(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil);
		this.xtextBuiltinConfiguration = new XtextBuiltinParserConfiguration(
			input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil);
	}

	public ComplexReconstrTestLanguageRootConsumer getRootConsumer() {
		return rootConsumer;
	} 
	
	public void createNonTerminalConsumers() {
		getXtextBuiltinConfiguration().createNonTerminalConsumers();
		rootConsumer = new ComplexReconstrTestLanguageRootConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(),
    		new ITerminalConsumer[]{ getWsConsumer(), getMlCommentConsumer(), getSlCommentConsumer() }
    	);
		opConsumer = new ComplexReconstrTestLanguageOpConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		termConsumer = new ComplexReconstrTestLanguageTermConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		atomConsumer = new ComplexReconstrTestLanguageAtomConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		parensConsumer = new ComplexReconstrTestLanguageParensConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		trickyAConsumer = new ComplexReconstrTestLanguageTrickyAConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		trickyA1Consumer = new ComplexReconstrTestLanguageTrickyA1Consumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		trickyBConsumer = new ComplexReconstrTestLanguageTrickyBConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		trickyCConsumer = new ComplexReconstrTestLanguageTrickyCConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		trickyDConsumer = new ComplexReconstrTestLanguageTrickyDConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		trickyEConsumer = new ComplexReconstrTestLanguageTrickyEConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		trickyFConsumer = new ComplexReconstrTestLanguageTrickyFConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		trickyGConsumer = new ComplexReconstrTestLanguageTrickyGConsumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		trickyG1Consumer = new ComplexReconstrTestLanguageTrickyG1Consumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
		trickyG2Consumer = new ComplexReconstrTestLanguageTrickyG2Consumer(
    		getInput(), getMarkerFactory(), getTokenAcceptor(), getHiddenTokenHandler(), getConsumerUtil(), null
    	);
	}
	
	public void createTerminalConsumers() {
		getXtextBuiltinConfiguration().createTerminalConsumers();
	}
	
	public void configureConsumers() {
		getRootConsumer$().setTrickyGConsumer(getTrickyGConsumer());
		getRootConsumer$().setOpConsumer(getOpConsumer());

		getOpConsumer().setTermConsumer(getTermConsumer());

		getTermConsumer().setAtomConsumer(getAtomConsumer());
		getTermConsumer().setParensConsumer(getParensConsumer());

		getAtomConsumer().setIdConsumer(getIdConsumer());

		getParensConsumer().setOpConsumer(getOpConsumer());

		getTrickyAConsumer().setIdConsumer(getIdConsumer());
		getTrickyAConsumer().setStringConsumer(getStringConsumer());
		getTrickyAConsumer().setTrickyA1Consumer(getTrickyA1Consumer());

		getTrickyA1Consumer().setIdConsumer(getIdConsumer());

		getTrickyBConsumer().setIdConsumer(getIdConsumer());
		getTrickyBConsumer().setIntConsumer(getIntConsumer());

		getTrickyCConsumer().setIdConsumer(getIdConsumer());

		getTrickyDConsumer().setIdConsumer(getIdConsumer());
		getTrickyDConsumer().setStringConsumer(getStringConsumer());
		getTrickyDConsumer().setIntConsumer(getIntConsumer());

		getTrickyEConsumer().setIdConsumer(getIdConsumer());
		getTrickyEConsumer().setStringConsumer(getStringConsumer());
		getTrickyEConsumer().setIntConsumer(getIntConsumer());

		getTrickyFConsumer().setIdConsumer(getIdConsumer());
		getTrickyFConsumer().setIntConsumer(getIntConsumer());

		getTrickyGConsumer().setTrickyG1Consumer(getTrickyG1Consumer());

		getTrickyG1Consumer().setTrickyG2Consumer(getTrickyG2Consumer());

		getTrickyG2Consumer().setTrickyG1Consumer(getTrickyG1Consumer());
		getTrickyG2Consumer().setIntConsumer(getIntConsumer());

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
	
	public ComplexReconstrTestLanguageRootConsumer getRootConsumer$() {
    	return rootConsumer;
    }

    public ComplexReconstrTestLanguageOpConsumer getOpConsumer() {
    	return opConsumer;
    }

    public ComplexReconstrTestLanguageTermConsumer getTermConsumer() {
    	return termConsumer;
    }

    public ComplexReconstrTestLanguageAtomConsumer getAtomConsumer() {
    	return atomConsumer;
    }

    public ComplexReconstrTestLanguageParensConsumer getParensConsumer() {
    	return parensConsumer;
    }

    public ComplexReconstrTestLanguageTrickyAConsumer getTrickyAConsumer() {
    	return trickyAConsumer;
    }

    public ComplexReconstrTestLanguageTrickyA1Consumer getTrickyA1Consumer() {
    	return trickyA1Consumer;
    }

    public ComplexReconstrTestLanguageTrickyBConsumer getTrickyBConsumer() {
    	return trickyBConsumer;
    }

    public ComplexReconstrTestLanguageTrickyCConsumer getTrickyCConsumer() {
    	return trickyCConsumer;
    }

    public ComplexReconstrTestLanguageTrickyDConsumer getTrickyDConsumer() {
    	return trickyDConsumer;
    }

    public ComplexReconstrTestLanguageTrickyEConsumer getTrickyEConsumer() {
    	return trickyEConsumer;
    }

    public ComplexReconstrTestLanguageTrickyFConsumer getTrickyFConsumer() {
    	return trickyFConsumer;
    }

    public ComplexReconstrTestLanguageTrickyGConsumer getTrickyGConsumer() {
    	return trickyGConsumer;
    }

    public ComplexReconstrTestLanguageTrickyG1Consumer getTrickyG1Consumer() {
    	return trickyG1Consumer;
    }

    public ComplexReconstrTestLanguageTrickyG2Consumer getTrickyG2Consumer() {
    	return trickyG2Consumer;
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
