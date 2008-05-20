
package org.eclipse.xtext.grammargen.tests;

import java.util.*;

import org.eclipse.xtext.*;
import org.eclipse.xtext.core.parser.*;
import org.eclipse.xtext.core.parsetree.*;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.grammargen.tests.parser.SimpleTest2ASTFactory;

public class SimpleTest2ParseTreeConstructor extends AbstractParseTreeUpdater {
	private AbstractEcoreElementFactory factory = new SimpleTest2ASTFactory();
	private org.eclipse.xtext.Grammar grammar = org.eclipse.xtext.grammargen.tests.SimpleTest2Constants.getSimpleTest2Grammar();
	
	protected AbstractEcoreElementFactory getFactory() {
		return factory;
	}
	
	protected Grammar getGrammar() {
		return grammar;
	}

	protected void internalDoUpdate(EObject obj, String ruleToCall) {
		if (ruleToCall.equals("Model")) {
			proceedModel(getDescr(obj));
		} else 		if (ruleToCall.equals("Child")) {
			proceedChild(getDescr(obj));
		} else {
			throw new IllegalArgumentException("Couldn't find rule '"+ruleToCall+"'");
		}
	}

	
protected void proceedModel(InstanceDescription obj) {
	
/* xtext::Assignment */ 

while (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("contents"); 
		}
}.check() ){

	final Object value = obj.consume("contents");
    
/* xtext::RuleCall */ 
{

	
	InstanceDescription val = (getDescr((EObject)value));
	EObject ruleCall = grammar.eResource().getEObject("//@parserRules.0/@alternatives/@terminal");
	try {
		ruleCallStart(val, true, (RuleCall) ruleCall);
		proceedChild(val);
	} finally {
		ruleCallEnd(val, true, (RuleCall) ruleCall);
	}
	

}

    if (obj.isConsumed())
    	objectCreation(obj);

}

}

protected void proceedChild(InstanceDescription obj) {
	
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	keyword((Keyword)grammar.eResource().getEObject("//@parserRules.1/@alternatives/@abstractTokens.1"));

}

		
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	keyword((Keyword)grammar.eResource().getEObject("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.1"));

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("number");
    
/* xtext::RuleCall */ 
{

	
	
	lexerRuleCall(value,(RuleCall)grammar.eResource().getEObject("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"));
	
	

}

    if (obj.isConsumed())
    	objectCreation(obj);

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	final Object value = obj.consume("name");
    
/* xtext::RuleCall */ 
{

	
	
	lexerRuleCall(value,(RuleCall)grammar.eResource().getEObject("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"));
	
	

}

    if (obj.isConsumed())
    	objectCreation(obj);

}

		
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	keyword((Keyword)grammar.eResource().getEObject("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1"));

}

		
/* xtext::Assignment */ 

if (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("optional"); 
		}
}.check() ){

	final Object value = obj.consume("optional");
    
/* xtext::Keyword */ 
{

	keyword((Keyword)grammar.eResource().getEObject("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal"));

}

    if (obj.isConsumed())
    	objectCreation(obj);

}


}


}


}


}


}

}

}
