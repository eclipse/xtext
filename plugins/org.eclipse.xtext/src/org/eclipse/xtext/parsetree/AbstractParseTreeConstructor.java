package org.eclipse.xtext.parsetree;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.parser.GenericEcoreElementFactory;
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.service.InjectedService;

public abstract class AbstractParseTreeConstructor implements IParseTreeConstructor {
	private GenericEcoreElementFactory astElementFactory;

	@InjectedService
	public void setElementFactory(IElementFactory factory) {
		this.astElementFactory = (GenericEcoreElementFactory) factory;
	}

	private Grammar grammar;

	protected GenericEcoreElementFactory getFactory() {
		return astElementFactory;
	}

	@InjectedService
	public void setGrammarAccess(IGrammarAccess grammarAccess) {
		this.grammar = grammarAccess.getGrammar();
	}

	protected Grammar getGrammar() {
		return grammar;
	}

}
