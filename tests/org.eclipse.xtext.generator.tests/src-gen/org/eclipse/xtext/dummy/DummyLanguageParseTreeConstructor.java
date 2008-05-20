
package org.eclipse.xtext.dummy;

import java.util.*;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.*;
import org.eclipse.xtext.core.parser.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.dummy.parser.DummyLanguageASTFactory;

public class DummyLanguageParseTreeConstructor extends AbstractParseTreeRewriter{
	private AbstractEcoreElementFactory factory = new DummyLanguageASTFactory();
	private org.eclipse.xtext.Grammar grammar = org.eclipse.xtext.dummy.DummyLanguageConstants.getDummyLanguageGrammar();
	
	protected AbstractEcoreElementFactory getFactory() {
		return factory;
	}


public void proceedModel(EObject obj) {
	proceedModel(getDescr(obj));
}

protected void proceedModel(InstanceDescription obj) {
	
/* xtext::Assignment */ 

while (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("elements"); 
		}
}.check() ){

	Object value = obj.consume("elements");
    
/* xtext::RuleCall */ 
{

	
	InstanceDescription val = (getDescr((EObject)value));
	EObject ruleCall = grammar.eResource().getEObject("//@parserRules.0/@alternatives/@terminal");
	try {
		ruleCallStart(val, true, (RuleCall) ruleCall);
		proceedElement(val);
	} finally {
		ruleCallEnd(val, true, (RuleCall) ruleCall);
	}
	

}

    if (obj.isConsumed())
    	objectCreation(obj);

}

}

public void proceedElement(EObject obj) {
	proceedElement(getDescr(obj));
}

protected void proceedElement(InstanceDescription obj) {
	
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	keyword((Keyword)grammar.eResource().getEObject("//@parserRules.1/@alternatives/@abstractTokens.1"));

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 

while (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("descriptions"); 
		}
}.check() ){

	Object value = obj.consume("descriptions");
    
/* xtext::RuleCall */ 
{

	
	
	lexerRuleCall(value,(RuleCall)grammar.eResource().getEObject("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"));
	
	

}

    if (obj.isConsumed())
    	objectCreation(obj);

}

		
/* xtext::Group */ 
{

		
/* xtext::Assignment */ 
{

	Object value = obj.consume("name");
    
/* xtext::RuleCall */ 
{

	
	
	lexerRuleCall(value,(RuleCall)grammar.eResource().getEObject("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"));
	
	

}

    if (obj.isConsumed())
    	objectCreation(obj);

}

		
/* xtext::Group */ 
{

		
/* xtext::Keyword */ 
{

	keyword((Keyword)grammar.eResource().getEObject("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1"));

}

		
/* xtext::Assignment */ 

if (
new Predicate(obj) { 
		public boolean check() {
			return obj.checkConsume("optional"); 
		}
}.check() ){

	Object value = obj.consume("optional");
    
/* xtext::Keyword */ 
{

	keyword((Keyword)grammar.eResource().getEObject("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal"));

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
