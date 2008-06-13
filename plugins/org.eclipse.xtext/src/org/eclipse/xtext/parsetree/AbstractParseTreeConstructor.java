package org.eclipse.xtext.parsetree;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.parser.GenericEcoreElementFactory;
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.service.Inject;

public abstract class AbstractParseTreeConstructor implements IParseTreeConstructor {
	private GenericEcoreElementFactory astElementFactory;

    @Inject
	protected IValueConverterService converterService;

	protected IValueConverterService getValueConverterService() {
		return converterService;
	}

	private Grammar grammar;

	@Inject
	protected void setElementFactory(IElementFactory astElementFactory) {
	    this.astElementFactory = (GenericEcoreElementFactory) astElementFactory;
	}
	
	protected GenericEcoreElementFactory getFactory() {
		return astElementFactory;
	}

	@Inject
	public void setGrammarAccess(IGrammarAccess grammarAccess) {
		this.grammar = grammarAccess.getGrammar();
	}

	protected Grammar getGrammar() {
		return grammar;
	}

}
