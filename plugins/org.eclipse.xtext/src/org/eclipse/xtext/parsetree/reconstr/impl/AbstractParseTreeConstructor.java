package org.eclipse.xtext.parsetree.reconstr.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parsetree.reconstr.IInstanceDescription;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructorCallback;
import org.eclipse.xtext.service.Inject;

public abstract class AbstractParseTreeConstructor implements IParseTreeConstructor {
	@Inject
	private IAstFactory factory;

    @Inject
	protected IValueConverterService converterService;

    @Inject
	private IGrammarAccess grammar;

	public IAstFactory getFactory() {
		return factory;
	}

	protected Grammar getGrammar() {
		return grammar.getGrammar();
	}
	
	protected IValueConverterService getValueConverterService() {
		return converterService;
	}


	public void update(EObject object, IParseTreeConstructorCallback callback) {
		EObject root = EcoreUtil.getRootContainer(object);
		ParserRule parserRule = GrammarUtil.getDefaultEntryRule(getGrammar());
		String ruleToCall = parserRule.getName();
		internalDoUpdate(root, ruleToCall,callback);
	}
	protected abstract void internalDoUpdate(EObject obj, String ruleToCall, IParseTreeConstructorCallback callback);

	protected final InstanceDescription getDescr(EObject obj) {
		return new InstanceDescription(this, obj);
	}

	protected final IInstanceDescription getDescr(IInstanceDescription obj) {
		return obj;
	}

	protected EObject getGrammarElement(String string) {
		return grammar.getGrammar().eResource().getResourceSet().getEObject(URI.createURI(string), true);
	}
}
