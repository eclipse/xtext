
package org.eclipse.xtext.grammargen.tests;

import java.util.*;

import org.eclipse.xtext.*;
import org.eclipse.xtext.core.parser.*;
import org.eclipse.xtext.core.parsetree.*;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.grammargen.tests.parser.SimpleTestASTFactory;

public class SimpleTestParseTreeConstructor extends AbstractParseTreeUpdater {
	private AbstractEcoreElementFactory factory = new SimpleTestASTFactory();
	private org.eclipse.xtext.Grammar grammar = org.eclipse.xtext.grammargen.tests.SimpleTestConstants.getSimpleTestGrammar();
	
	protected AbstractEcoreElementFactory getFactory() {
		return factory;
	}
	
	protected Grammar getGrammar() {
		return grammar;
	}

	protected void internalDoUpdate(EObject obj, String ruleToCall) {
		if (ruleToCall.equals("Foo")) {
			proceedFoo(getDescr(obj));
		} else {
			throw new IllegalArgumentException("Couldn't find rule '"+ruleToCall+"'");
		}
	}

	
protected void proceedFoo(InstanceDescription obj) {
	
/* xtext::Assignment */ 
{

	final Object value = obj.consume("name");
    
/* xtext::RuleCall */ 
{

	
	
	lexerRuleCall(value,(RuleCall)grammar.eResource().getEObject("//@parserRules.0/@alternatives/@terminal"));
	
	

}

    if (obj.isConsumed())
    	objectCreation(obj);

}

}

}
